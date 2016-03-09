package com.ux.client;


import com.google.gwt.user.client.ui.*;
import com.ux.client.theme.base.AppThemeStyles;


public class InputTextWidget implements IsWidget {

    private final String labelText;

    private TextBox textBox;

    private HorizontalPanel container;

    public static final AppThemeStyles.ThemeAppearance.AppStyles style = AppThemeStyles.get().style();

    public InputTextWidget(final String labelText) {

        this.labelText = labelText;
    }

    @Override
    public HorizontalPanel asWidget() {

        if (container == null) {

            container = createTextBox();
        }

        return container;
    }

    private HorizontalPanel createTextBox() {

        final HorizontalPanel  inputBox = new HorizontalPanel();
        inputBox.setStyleName(style.labelTextColor());

        final SimplePanel labelPanel = new ScrollPanel();
        labelPanel.setStyleName(style.inputLabel());
        final Label label = new Label(labelText);
        labelPanel.add(label);

        textBox =new TextBox();

        inputBox.add(labelPanel);
        inputBox.add(textBox);

        return inputBox;
    }



    public String getValue() {

        return textBox.getText();
    }
}