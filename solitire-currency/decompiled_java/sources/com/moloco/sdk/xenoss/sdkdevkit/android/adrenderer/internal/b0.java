package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.moloco.sdk.internal.MolocoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {
    public static final boolean b(Context context, String str) {
        try {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setUrlBarHidingEnabled(true).build();
            kotlin.jvm.internal.t.h(customTabsIntentBuild, "Builder()\n            .s…rue)\n            .build()");
            customTabsIntentBuild.intent.addFlags(268435456);
            customTabsIntentBuild.launchUrl(context, Uri.parse(str));
            return true;
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "Xenoss", "tryStartCustomTabs exception", e10, false, 8, null);
            return false;
        }
    }
}
