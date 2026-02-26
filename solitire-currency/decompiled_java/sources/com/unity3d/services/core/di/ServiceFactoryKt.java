package com.unity3d.services.core.di;

import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.l;

/* JADX INFO: compiled from: ServiceFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ServiceFactoryKt {
    @NotNull
    public static final <T> l<T> factoryOf(@NotNull a<? extends T> initializer) {
        t.i(initializer, "initializer");
        return new Factory(initializer);
    }
}
