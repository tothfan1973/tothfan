package com.ux.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.ux.client.data.PersonItem;

import java.util.List;

@RemoteServiceRelativePath("app")
public interface AppFormService extends RemoteService {

    void savePerson(PersonItem personItem);

    List<PersonItem> getPersonItems();

    /**
     * Utility/Convenience class.
     * Use AppFormService.App.getInstance() to access static instance of uxServiceAsync
     */
    public static class App {
        private static AppFormServiceAsync ourInstance = GWT.create(AppFormService.class);

        public static synchronized AppFormServiceAsync getInstance() {

            return ourInstance;
        }
    }
}
