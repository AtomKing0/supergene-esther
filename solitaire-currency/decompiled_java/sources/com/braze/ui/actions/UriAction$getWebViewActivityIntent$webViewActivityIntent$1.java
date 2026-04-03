package com.braze.ui.actions;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UriAction.kt */
/* JADX INFO: loaded from: classes2.dex */
final class UriAction$getWebViewActivityIntent$webViewActivityIntent$1 extends v implements a<String> {
    final /* synthetic */ String $customWebViewActivityClassName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UriAction$getWebViewActivityIntent$webViewActivityIntent$1(String str) {
        super(0);
        this.$customWebViewActivityClassName = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Launching custom WebView Activity with class name: " + this.$customWebViewActivityClassName;
    }
}
