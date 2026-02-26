package com.braze.ui.inappmessage.views;

import android.webkit.WebView;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$5 extends v implements h9.a<String> {
    final /* synthetic */ WebView.HitTestResult $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$5(WebView.HitTestResult hitTestResult) {
        super(0);
        this.$result = hitTestResult;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to open link in new window. " + this.$result;
    }
}
