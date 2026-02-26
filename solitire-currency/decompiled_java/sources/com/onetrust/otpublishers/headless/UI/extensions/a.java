package com.onetrust.otpublishers.headless.UI.extensions;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.Button;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final void a(@NotNull Button button, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.f buttonProperty, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable OTConfiguration oTConfiguration) {
        t.i(button, "<this>");
        t.i(buttonProperty, "buttonProperty");
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = buttonProperty.f22758a;
        t.h(lVar, "buttonProperty.fontProperty");
        b(button, lVar, oTConfiguration);
        String str4 = lVar.f22783b;
        if (!(str4 == null || str4.length() == 0)) {
            String str5 = lVar.f22783b;
            t.f(str5);
            button.setTextSize(Float.parseFloat(str5));
        }
        c(button, str2);
        com.onetrust.otpublishers.headless.UI.Helper.l.i(button.getContext(), button, buttonProperty, str, str3);
    }

    public static final void b(@NotNull Button button, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.l titleFontProperty, @Nullable OTConfiguration oTConfiguration) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        t.i(button, "<this>");
        t.i(titleFontProperty, "titleFontProperty");
        String str = titleFontProperty.f22785d;
        if (!(str == null || str.length() == 0) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            button.setTypeface(otTypeFaceMap);
            return;
        }
        int style = titleFontProperty.f22784c;
        if (style == -1 && (typeface = button.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        String str2 = titleFontProperty.f22782a;
        button.setTypeface(!(str2 == null || str2.length() == 0) ? Typeface.create(titleFontProperty.f22782a, style) : Typeface.create(button.getTypeface(), style));
    }

    public static final void c(@NotNull Button button, @Nullable String str) {
        t.i(button, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        button.setTextColor(Color.parseColor(str));
    }
}
