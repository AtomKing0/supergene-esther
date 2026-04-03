package com.unity3d.services.core.di;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IServiceProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IServiceProvider {
    @NotNull
    IServicesRegistry getRegistry();

    @NotNull
    IServicesRegistry initialize();
}
