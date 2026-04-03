package com.unity3d.ads.adplayer;

import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import z8.g;

/* JADX INFO: compiled from: AdPlayerScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdPlayerScope implements o0 {
    private final /* synthetic */ o0 $$delegate_0;

    @NotNull
    private final k0 defaultDispatcher;

    public AdPlayerScope(@NotNull k0 defaultDispatcher) {
        t.i(defaultDispatcher, "defaultDispatcher");
        this.defaultDispatcher = defaultDispatcher;
        this.$$delegate_0 = p0.a(defaultDispatcher);
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public g getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }
}
