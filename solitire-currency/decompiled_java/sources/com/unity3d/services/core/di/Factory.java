package com.unity3d.services.core.di;

import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.l;

/* JADX INFO: compiled from: ServiceFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
final class Factory<T> implements l<T> {

    @NotNull
    private final a<T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public Factory(@NotNull a<? extends T> initializer) {
        t.i(initializer, "initializer");
        this.initializer = initializer;
    }

    @Override // v8.l
    public T getValue() {
        return this.initializer.invoke();
    }

    @Override // v8.l
    public boolean isInitialized() {
        return false;
    }
}
