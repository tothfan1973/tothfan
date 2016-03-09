package com.ux.client.theme.base;


import com.sencha.gxt.core.client.resources.ThemeStyles;
import org.jetbrains.annotations.NotNull;

/** The app theme */
public final class AppThemeStyles {


    private AppThemeStyles() {

    }

    @NotNull
    public static ThemeAppearance get() {

        return (ThemeAppearance) ThemeStyles.get();
    }

    /** The app appearance */
    public interface ThemeAppearance extends ThemeStyles.ThemeAppearance {

        @Override
        AppStyles style();

        interface AppStyles extends ThemeStyles.Styles {

            @NotNull
            String disabled();

            @NotNull
            @ClassName("label-text-color")
            String labelTextColor();

            @NotNull
            @ClassName("input-text")
            String inputText();

            @NotNull
            @ClassName("input-label")
            String inputLabel();

        }


    }
}
