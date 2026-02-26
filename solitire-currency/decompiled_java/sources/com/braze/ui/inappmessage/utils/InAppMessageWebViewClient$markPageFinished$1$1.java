package com.braze.ui.inappmessage.utils;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageWebViewClient.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageWebViewClient$markPageFinished$1$1 extends v implements a<String> {
    public static final InAppMessageWebViewClient$markPageFinished$1$1 INSTANCE = new InAppMessageWebViewClient$markPageFinished$1$1();

    InAppMessageWebViewClient$markPageFinished$1$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Page may not have finished loading, but max wait time has expired. Calling onPageFinished on listener.";
    }
}
