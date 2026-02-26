package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final tr f15351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f15352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f15353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f15354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final we f15355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final String f15356f;

    public t(@NotNull tr recordType, @NotNull String advertiserBundleId, @NotNull String networkInstanceId, @NotNull String adUnitId, @NotNull we adProvider, @NotNull String adInstanceId) {
        kotlin.jvm.internal.t.i(recordType, "recordType");
        kotlin.jvm.internal.t.i(advertiserBundleId, "advertiserBundleId");
        kotlin.jvm.internal.t.i(networkInstanceId, "networkInstanceId");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(adProvider, "adProvider");
        kotlin.jvm.internal.t.i(adInstanceId, "adInstanceId");
        this.f15351a = recordType;
        this.f15352b = advertiserBundleId;
        this.f15353c = networkInstanceId;
        this.f15354d = adUnitId;
        this.f15355e = adProvider;
        this.f15356f = adInstanceId;
    }

    @NotNull
    public final y1 a(@NotNull dl<t, y1> mapper) {
        kotlin.jvm.internal.t.i(mapper, "mapper");
        return mapper.a(this);
    }

    @NotNull
    public final we b() {
        return this.f15355e;
    }

    @NotNull
    public final String c() {
        return this.f15354d;
    }

    @NotNull
    public final String d() {
        return this.f15352b;
    }

    @NotNull
    public final String e() {
        return this.f15353c;
    }

    @NotNull
    public final tr f() {
        return this.f15351a;
    }

    @NotNull
    public final String a() {
        return this.f15356f;
    }
}
