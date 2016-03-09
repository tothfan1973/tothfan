package com.ux.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.ux.client.data.PersonItem;

import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MainEntry implements EntryPoint {


    private AppFormServiceAsync appFormServiceInstance = AppFormService.App.getInstance();

    private CellTable<PersonItem> table;

    public void onModuleLoad() {
        final Button button = new Button("Save in database");

        final InputTextWidget personNameWidget = new InputTextWidget("Name: ");
        final InputTextWidget emailWidget = new InputTextWidget("Email: ");

        final FlowPanel flowPanel = new FlowPanel();
        flowPanel.add(personNameWidget);
        flowPanel.add(emailWidget);
        flowPanel.add(button);


        createCellTable();
        appFormServiceInstance.getPersonItems(new GetPersonAsyncCallback());

        final VerticalPanel cellTablePanel = new VerticalPanel();
        cellTablePanel.setBorderWidth(1);
        cellTablePanel.setWidth("500");
        cellTablePanel.add(table);
        flowPanel.add(cellTablePanel);

        button.addClickHandler(new ClickHandler() {

            public void onClick(final ClickEvent event) {

                final String personName = personNameWidget.getValue();
                final String emailAddress = emailWidget.getValue();
                final PersonItem personItem = new PersonItem(personName, emailAddress);

                appFormServiceInstance.savePerson(personItem, new SavePersonAsyncCallback());

            }
        });

        RootPanel.get("gwtContainer").add(flowPanel);
    }


    private class SavePersonAsyncCallback implements AsyncCallback<Void> {

        @Override
        public void onFailure(final Throwable caught) {

        }

        @Override
        public void onSuccess(final Void result) {

            appFormServiceInstance.getPersonItems(new GetPersonAsyncCallback());
        }
    }


    private class GetPersonAsyncCallback implements AsyncCallback<List<PersonItem>> {

        @Override
        public void onFailure(final Throwable caught) {

        }

        @Override
        public void onSuccess(final List<PersonItem> result) {

            pushCellTableData(result);
        }

    }

    private void pushCellTableData(final List<PersonItem> personItems) {

        table.setRowCount(personItems.size(), true);
        table.setRowData(0, personItems);

    }

    private void createCellTable() {

        table = new CellTable<>();
        table.setPageSize(20);

        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        // Add a text column to show the name.
        final TextColumn<PersonItem> nameColumn =  new TextColumn<PersonItem>() {

                    @Override
                    public String getValue(final PersonItem object) {
                        return object.getUsername();
                    }
                };
        table.addColumn(nameColumn, "Name");

         // Add a text column to show the email address.
        final TextColumn<PersonItem> emailAddressColumn = new TextColumn<PersonItem>() {

                    @Override
                    public String getValue(final PersonItem object) {
                        return object.getEmail();
                    }
        };
        table.addColumn(emailAddressColumn, "Email");

        // Add a selection model to handle user selection.
        final SingleSelectionModel<PersonItem> selectionModel = new SingleSelectionModel<>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(final SelectionChangeEvent event) {

                        PersonItem selected = selectionModel.getSelectedObject();
                        if (selected != null) {

                            Window.alert("You selected: " + selected.getUsername());
                        }
                    }
                });
    }


}
