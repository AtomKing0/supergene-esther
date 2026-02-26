package com.moloco.sdk.internal.scheduling;

import kotlinx.coroutines.e1;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {
    @Override // com.moloco.sdk.internal.scheduling.a
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k0 getDefault() {
        return e1.a();
    }

    @Override // com.moloco.sdk.internal.scheduling.a
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public k0 getIo() {
        return e1.b();
    }

    @Override // com.moloco.sdk.internal.scheduling.a
    @NotNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public k0 getMain() {
        return e1.c();
    }

    @Override // com.moloco.sdk.internal.scheduling.a
    @NotNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public k0 a() {
        return e1.c().getImmediate();
    }
}
