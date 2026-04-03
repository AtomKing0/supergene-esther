package com.braze.push.support;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import p9.q;

/* JADX INFO: compiled from: HtmlUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HtmlUtils {

    @NotNull
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("HtmlUtils");

    /* JADX INFO: renamed from: com.braze.push.support.HtmlUtils$getHtmlSpannedTextIfEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: HtmlUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot create html spanned text on blank text. Returning blank string.";
        }
    }

    @NotNull
    public static final CharSequence getHtmlSpannedTextIfEnabled(@NotNull String str, @NotNull BrazeConfigurationProvider configurationProvider) {
        t.i(str, "<this>");
        t.i(configurationProvider, "configurationProvider");
        if (q.z(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 14, (Object) null);
            return str;
        }
        CharSequence charSequence = str;
        if (configurationProvider.isPushNotificationHtmlRenderingEnabled()) {
            Spanned spannedFromHtml = Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
            t.h(spannedFromHtml, "{\n        if (Build.VERS…tml(this)\n        }\n    }");
            charSequence = spannedFromHtml;
        }
        return charSequence;
    }
}
