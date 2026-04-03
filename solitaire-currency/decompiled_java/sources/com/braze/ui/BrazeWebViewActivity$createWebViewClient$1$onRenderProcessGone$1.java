package com.braze.ui;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeWebViewActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeWebViewActivity$createWebViewClient$1$onRenderProcessGone$1 extends v implements a<String> {
    public static final BrazeWebViewActivity$createWebViewClient$1$onRenderProcessGone$1 INSTANCE = new BrazeWebViewActivity$createWebViewClient$1$onRenderProcessGone$1();

    BrazeWebViewActivity$createWebViewClient$1$onRenderProcessGone$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "The webview rendering process crashed, returning true";
    }
}
