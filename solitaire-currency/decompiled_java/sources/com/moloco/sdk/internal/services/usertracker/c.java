package com.moloco.sdk.internal.services.usertracker;

import com.moloco.sdk.internal.services.f0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final f0 f18817a;

    public c(@NotNull f0 dataStoreService) {
        t.i(dataStoreService, "dataStoreService");
        this.f18817a = dataStoreService;
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    @Nullable
    public Object b(@NotNull String str, @NotNull z8.d<? super k0> dVar) {
        Object objB = this.f18817a.b("com.moloco.sdk.mref", str, dVar);
        return objB == a9.d.e() ? objB : k0.f35197a;
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    @Nullable
    public Object c(@NotNull z8.d<? super String> dVar) {
        return this.f18817a.a("com.moloco.sdk.mref", dVar);
    }
}
