package com.onetrust.otpublishers.headless.UI.extensions;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import com.onetrust.otpublishers.headless.UI.Helper.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    @NotNull
    public static final SpannableStringBuilder a(@NotNull Context context, @NotNull String str) {
        Spanned spannedFromHtml;
        String str2;
        t.i(str, "<this>");
        t.i(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            spannedFromHtml = Html.fromHtml(str, 0);
            str2 = "{\n        Html.fromHtml(…M_HTML_MODE_LEGACY)\n    }";
        } else {
            spannedFromHtml = Html.fromHtml(str, null, new l.a());
            str2 = "{\n        Html.fromHtml(…CustomTagHandler())\n    }";
        }
        t.h(spannedFromHtml, str2);
        SpannableStringBuilder strBuilder = new SpannableStringBuilder(spannedFromHtml);
        URLSpan[] urls = (URLSpan[]) strBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class);
        t.h(urls, "urls");
        for (URLSpan span : urls) {
            t.h(span, "span");
            t.i(context, "context");
            t.i(strBuilder, "strBuilder");
            t.i(span, "span");
            strBuilder.setSpan(new i(context, span), strBuilder.getSpanStart(span), strBuilder.getSpanEnd(span), strBuilder.getSpanFlags(span));
            strBuilder.removeSpan(span);
        }
        return strBuilder;
    }

    @Nullable
    public static final String b(@NotNull Context context, @Nullable String str) {
        t.i(context, "context");
        com.onetrust.otpublishers.headless.Internal.Preferences.g gVar = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
        if (!gVar.v() || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return str;
        }
        String strG = com.onetrust.otpublishers.headless.UI.Helper.l.g(gVar.l(), "activeIabVendorsCount");
        t.h(strG, "otSharedPreferenceUtils.activeVendorCount");
        if (strG.length() == 0) {
            strG = "0";
        }
        if (str == null) {
            return null;
        }
        return q.G(str, "[VENDOR_NUMBER]", "<b>" + strG + "</b>", false, 4, null);
    }
}
