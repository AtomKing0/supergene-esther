package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class hd implements id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ld f12472b;

    public hd(long j10, @NotNull ld recoveryStrategy) {
        kotlin.jvm.internal.t.i(recoveryStrategy, "recoveryStrategy");
        this.f12471a = j10;
        this.f12472b = recoveryStrategy;
    }

    @Override // com.ironsource.id
    public long a() {
        return this.f12471a;
    }

    @Override // com.ironsource.id
    @NotNull
    public ld b() {
        return this.f12472b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hd(@NotNull kd feature) {
        this(feature.a(), feature.b());
        kotlin.jvm.internal.t.i(feature, "feature");
    }
}
