package com.braze.ui.inappmessage;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class DefaultInAppMessageViewWrapper$open$2$onLayoutChange$1 extends v implements a<String> {
    final /* synthetic */ int $bottom;
    final /* synthetic */ int $top;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultInAppMessageViewWrapper$open$2$onLayoutChange$1(int i10, int i11) {
        super(0);
        this.$bottom = i10;
        this.$top = i11;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Detected (bottom - top) of " + (this.$bottom - this.$top) + " in OnLayoutChangeListener";
    }
}
