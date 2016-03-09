package com.ux.client.theme.gray;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.ux.client.theme.base.AppThemeStyles;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.theme.gray.client.GrayThemeAppearance;
import org.jetbrains.annotations.NotNull;

public class AppGrayThemeAppearance extends GrayThemeAppearance implements AppThemeStyles.ThemeAppearance {

    private final AppBundle appBundle;

    @NotNull
    private final AppStyles appStyle;


    public AppGrayThemeAppearance() {

        super();
        this.appBundle = GWT.create(AppBundle.class);
        this.appStyle = appBundle.css();

        StyleInjectorHelper.ensureInjected(this.appStyle, true);
    }


    @NotNull
    @Override
    public AppStyles style() {

        return appStyle;
    }


    interface AppBundle extends ClientBundle {

        @NotNull
        @ClientBundle.Source("app.css")
        AppStyles css();


    }
}
