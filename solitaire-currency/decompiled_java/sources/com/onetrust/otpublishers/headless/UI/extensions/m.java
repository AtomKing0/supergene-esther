package com.onetrust.otpublishers.headless.UI.extensions;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.UI.UIProperty.o;
import com.onetrust.otpublishers.headless.UI.UIProperty.v;
import java.util.regex.Pattern;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    public static final void a(@NotNull TextView textView) {
        t.i(textView, "<this>");
        if (com.onetrust.otpublishers.headless.Internal.Helper.k.e(textView.getContext())) {
            textView.setTextAlignment(5);
        }
    }

    public static void b(TextView textView, com.onetrust.otpublishers.headless.UI.UIProperty.c titleProperty, String str, OTConfiguration oTConfiguration, boolean z10, int i10) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            oTConfiguration = null;
        }
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        t.i(textView, "<this>");
        t.i(titleProperty, "titleProperty");
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = titleProperty.f22720a;
        t.h(lVar, "titleProperty.fontProperty");
        d(textView, lVar, oTConfiguration);
        h(textView, lVar.f22783b);
        if (z10) {
            textView.setText(titleProperty.f22724e);
        }
        String str2 = titleProperty.f22722c;
        String str3 = (str2 == null || str2.length() == 0) ^ true ? str2 : null;
        if (str3 != null) {
            str = str3;
        }
        textView.setTextColor(Color.parseColor(str));
        g(textView, titleProperty.f22721b);
    }

    public static final void c(@NotNull TextView textView, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.c titleProperty, @Nullable String str, boolean z10, @Nullable OTConfiguration oTConfiguration) {
        t.i(textView, "<this>");
        t.i(titleProperty, "titleProperty");
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = titleProperty.f22720a;
        t.h(lVar, "titleProperty.fontProperty");
        d(textView, lVar, oTConfiguration);
        h(textView, lVar.f22783b);
        g(textView, titleProperty.f22721b);
        if (!(str == null || str.length() == 0)) {
            textView.setTextColor(Color.parseColor(str));
        }
        ViewCompat.setAccessibilityHeading(textView, z10);
    }

    public static final void d(@NotNull TextView textView, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.l titleFontProperty, @Nullable OTConfiguration oTConfiguration) {
        Typeface otTypeFaceMap;
        t.i(textView, "<this>");
        t.i(titleFontProperty, "titleFontProperty");
        String str = titleFontProperty.f22785d;
        if (!(str == null || str.length() == 0) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            textView.setTypeface(otTypeFaceMap);
            return;
        }
        int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, titleFontProperty.f22784c);
        String str2 = titleFontProperty.f22782a;
        textView.setTypeface(!(str2 == null || str2.length() == 0) ? Typeface.create(titleFontProperty.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
    }

    public static final void e(@NotNull TextView textView, @NotNull o linkProperty, @Nullable v vVar, @NotNull com.onetrust.otpublishers.headless.UI.DataModels.a bannerData, @Nullable OTConfiguration oTConfiguration) {
        t.i(textView, "<this>");
        t.i(linkProperty, "linkProperty");
        t.i(bannerData, "bannerData");
        com.onetrust.otpublishers.headless.UI.UIProperty.c textProperty = linkProperty.f22787a;
        t.h(textProperty, "linkProperty.linkTextProperty");
        String linkColor = bannerData.f22049l;
        if (linkColor == null) {
            linkColor = "";
        }
        t.i(textProperty, "textProperty");
        t.i(linkColor, "linkColor");
        String str = textProperty.f22722c;
        if (!(!(str == null || str.length() == 0))) {
            str = null;
        }
        if (str == null) {
            String str2 = vVar != null ? vVar.f22832b : null;
            String str3 = true ^ (str2 == null || str2.length() == 0) ? str2 : null;
            if (str3 != null) {
                linkColor = str3;
            }
        } else {
            linkColor = str;
        }
        c(textView, textProperty, linkColor, false, oTConfiguration);
        t.i(textView, "<this>");
        if (vVar == null || vVar.f22831a) {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        }
    }

    public static final void f(@NotNull TextView textView, @Nullable String str) {
        t.i(textView, "<this>");
        if (str == null || str.length() == 0) {
            OTLogger.a("UIUtils", 3, "renderHtmlText called with 'null' text content.");
            return;
        }
        if (!Pattern.compile(".*\\<[^>]+>.*", 32).matcher(str == null ? "" : str).matches()) {
            textView.setText(str);
            return;
        }
        OTLogger.a("UIUtils", 3, "Rendering html content");
        Context context = textView.getContext();
        t.h(context, "context");
        textView.setText(j.a(context, str));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final void g(@NotNull TextView textView, @Nullable String str) {
        t.i(textView, "<this>");
        if (com.onetrust.otpublishers.headless.Internal.Helper.k.e(textView.getContext())) {
            textView.setTextAlignment(5);
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        int layoutDirection = textView.getContext().getResources().getConfiguration().getLayoutDirection();
        int i10 = Integer.parseInt(str);
        t.i(textView, "<this>");
        int i11 = GravityCompat.END;
        int i12 = GravityCompat.START;
        if (layoutDirection != 1) {
            i12 = 8388613;
            i11 = 8388611;
        }
        if (i10 == 2) {
            textView.setGravity(3);
            return;
        }
        if (i10 == 3) {
            textView.setGravity(5);
            return;
        }
        if (i10 == 4) {
            textView.setGravity(1);
        } else if (i10 == 5) {
            textView.setGravity(i11);
        } else {
            if (i10 != 6) {
                return;
            }
            textView.setGravity(i12);
        }
    }

    public static final void h(@NotNull TextView textView, @Nullable String str) {
        t.i(textView, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        textView.setTextSize(Float.parseFloat(str));
    }
}
