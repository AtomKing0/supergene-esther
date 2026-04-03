package com.braze.ui.inappmessage.views;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageHtmlBaseView$messageWebView$1 extends v implements h9.a<String> {
    public static final InAppMessageHtmlBaseView$messageWebView$1 INSTANCE = new InAppMessageHtmlBaseView$messageWebView$1();

    InAppMessageHtmlBaseView$messageWebView$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Cannot return the WebView for an already finished message";
    }
}
