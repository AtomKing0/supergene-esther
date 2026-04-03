package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class mr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final k0 f14036a;

    public mr(@Nullable k0 k0Var) {
        this.f14036a = k0Var;
    }

    @Nullable
    public final k0 a() {
        return this.f14036a;
    }

    @NotNull
    public abstract tr b();

    @NotNull
    public final t a(@NotNull dl<mr, t> mapper) {
        kotlin.jvm.internal.t.i(mapper, "mapper");
        return mapper.a(this);
    }
}
