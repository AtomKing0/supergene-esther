package com.unity3d.services.core.di;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IServiceComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IServiceComponent {

    /* JADX INFO: compiled from: IServiceComponent.kt */
    public static final class DefaultImpls {
        @NotNull
        public static IServiceProvider getServiceProvider(@NotNull IServiceComponent iServiceComponent) {
            return ServiceProvider.INSTANCE;
        }
    }

    @NotNull
    IServiceProvider getServiceProvider();
}
