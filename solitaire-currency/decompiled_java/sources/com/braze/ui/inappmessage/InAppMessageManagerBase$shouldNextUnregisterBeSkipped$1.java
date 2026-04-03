package com.braze.ui.inappmessage;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageManagerBase.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageManagerBase$shouldNextUnregisterBeSkipped$1 extends v implements a<String> {
    final /* synthetic */ boolean $shouldSkip;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageManagerBase$shouldNextUnregisterBeSkipped$1(boolean z10) {
        super(0);
        this.$shouldSkip = z10;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Setting setShouldNextUnregisterBeSkipped to " + this.$shouldSkip;
    }
}
