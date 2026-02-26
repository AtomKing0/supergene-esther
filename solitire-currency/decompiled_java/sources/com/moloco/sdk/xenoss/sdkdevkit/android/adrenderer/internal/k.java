package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.webkit.WebView;
import com.ironsource.nb;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static final void a(@NotNull WebView webView, @NotNull String data) {
        kotlin.jvm.internal.t.i(webView, "<this>");
        kotlin.jvm.internal.t.i(data, "data");
        webView.loadDataWithBaseURL("https://appassets.androidplatform.net", data, "text/html", nb.N, null);
    }
}
