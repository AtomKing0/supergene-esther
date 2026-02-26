package com.moloco.sdk.internal.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class e implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final f f18836a;

    public e(@NotNull f key) {
        t.i(key, "key");
        this.f18836a = key;
    }

    @Override // z8.g.b
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f getKey() {
        return this.f18836a;
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r10, pVar);
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public g minusKey(@NotNull g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // z8.g
    @NotNull
    public g plus(@NotNull g gVar) {
        return g.b.a.d(this, gVar);
    }
}
