package com.braze.ui.inappmessage.views;

import android.webkit.WebView;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$4 extends v implements h9.a<String> {
    final /* synthetic */ WebView.HitTestResult $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$4(WebView.HitTestResult hitTestResult) {
        super(0);
        this.$result = hitTestResult;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "onCreateWindow: hitTestResult type was " + this.$result.getType() + ". Not doing anything.";
    }
}
