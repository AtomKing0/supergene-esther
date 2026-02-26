package com.unity3d.services.core.domain;

import kotlinx.coroutines.e1;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SDKDispatchers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SDKDispatchers implements ISDKDispatchers {

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    @NotNull
    private final k0 f24289io = e1.b();

    /* JADX INFO: renamed from: default, reason: not valid java name */
    @NotNull
    private final k0 f22default = e1.a();

    @NotNull
    private final k0 main = e1.c();

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    @NotNull
    public k0 getDefault() {
        return this.f22default;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    @NotNull
    public k0 getIo() {
        return this.f24289io;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    @NotNull
    public k0 getMain() {
        return this.main;
    }
}
