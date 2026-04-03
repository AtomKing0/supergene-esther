package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class km {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final tr f12880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f12881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final we f12882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f12883d;

    public km(@NotNull tr recordType, @NotNull String advertiserBundleId, @NotNull we adProvider, @NotNull String adInstanceId) {
        kotlin.jvm.internal.t.i(recordType, "recordType");
        kotlin.jvm.internal.t.i(advertiserBundleId, "advertiserBundleId");
        kotlin.jvm.internal.t.i(adProvider, "adProvider");
        kotlin.jvm.internal.t.i(adInstanceId, "adInstanceId");
        this.f12880a = recordType;
        this.f12881b = advertiserBundleId;
        this.f12882c = adProvider;
        this.f12883d = adInstanceId;
    }

    @NotNull
    public final z2 a(@NotNull dl<km, z2> mapper) {
        kotlin.jvm.internal.t.i(mapper, "mapper");
        return mapper.a(this);
    }

    @NotNull
    public final we b() {
        return this.f12882c;
    }

    @NotNull
    public final String c() {
        return this.f12881b;
    }

    @NotNull
    public final tr d() {
        return this.f12880a;
    }

    @NotNull
    public final String a() {
        return this.f12883d;
    }
}
