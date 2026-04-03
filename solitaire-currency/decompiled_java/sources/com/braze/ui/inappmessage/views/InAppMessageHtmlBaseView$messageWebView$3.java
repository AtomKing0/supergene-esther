package com.braze.ui.inappmessage.views;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageHtmlBaseView$messageWebView$3 extends v implements h9.a<String> {
    final /* synthetic */ int $webViewViewId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageHtmlBaseView$messageWebView$3(int i10) {
        super(0);
        this.$webViewViewId = i10;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "findViewById for " + this.$webViewViewId + " returned null. Returning null for WebView.";
    }
}
