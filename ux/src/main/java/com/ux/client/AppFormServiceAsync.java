package com.ux.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ux.client.data.PersonItem;

import java.util.List;

public interface AppFormServiceAsync {

    void savePerson(PersonItem personItem, AsyncCallback<Void> async);

    void getPersonItems(AsyncCallback<List<PersonItem>> async);



}
