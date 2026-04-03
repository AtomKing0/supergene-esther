package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class yr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f16344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f16345b;

    public yr(@NotNull String identifier, @NotNull String baseConst) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        kotlin.jvm.internal.t.i(baseConst, "baseConst");
        this.f16344a = identifier;
        this.f16345b = baseConst;
    }

    @NotNull
    public final String a() {
        return this.f16344a + '_' + this.f16345b;
    }
}
