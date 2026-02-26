package com.braze.ui.inappmessage.views;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageHtmlBaseView$messageWebView$2 extends v implements h9.a<String> {
    public static final InAppMessageHtmlBaseView$messageWebView$2 INSTANCE = new InAppMessageHtmlBaseView$messageWebView$2();

    InAppMessageHtmlBaseView$messageWebView$2() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Cannot find WebView. getWebViewViewId() returned 0.";
    }
}
