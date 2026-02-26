package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final tr f16234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f16235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f16236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final we f16237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f16238e;

    public y1(@NotNull tr recordType, @NotNull String advertiserBundleId, @NotNull String networkInstanceId, @NotNull we adProvider, @NotNull String adInstanceId) {
        kotlin.jvm.internal.t.i(recordType, "recordType");
        kotlin.jvm.internal.t.i(advertiserBundleId, "advertiserBundleId");
        kotlin.jvm.internal.t.i(networkInstanceId, "networkInstanceId");
        kotlin.jvm.internal.t.i(adProvider, "adProvider");
        kotlin.jvm.internal.t.i(adInstanceId, "adInstanceId");
        this.f16234a = recordType;
        this.f16235b = advertiserBundleId;
        this.f16236c = networkInstanceId;
        this.f16237d = adProvider;
        this.f16238e = adInstanceId;
    }

    @NotNull
    public final km a(@NotNull dl<y1, km> mapper) {
        kotlin.jvm.internal.t.i(mapper, "mapper");
        return mapper.a(this);
    }

    @NotNull
    public final we b() {
        return this.f16237d;
    }

    @NotNull
    public final String c() {
        return this.f16235b;
    }

    @NotNull
    public final String d() {
        return this.f16236c;
    }

    @NotNull
    public final tr e() {
        return this.f16234a;
    }

    @NotNull
    public final String a() {
        return this.f16238e;
    }
}
