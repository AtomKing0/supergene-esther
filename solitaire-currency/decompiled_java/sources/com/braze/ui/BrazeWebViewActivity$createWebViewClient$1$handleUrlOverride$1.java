package com.braze.ui;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeWebViewActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeWebViewActivity$createWebViewClient$1$handleUrlOverride$1 extends v implements a<String> {
    final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeWebViewActivity$createWebViewClient$1$handleUrlOverride$1(String str) {
        super(0);
        this.$url = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Unexpected exception while processing url " + this.$url + ". Passing url back to WebView.";
    }
}
