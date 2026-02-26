package com.moloco.sdk.internal.services.bidtoken.providers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Integer f18536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f18537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Boolean f18538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.internal.services.b f18539d;

    public r() {
        this(null, null, null, null, 15, null);
    }

    @Nullable
    public final Integer a() {
        return this.f18536a;
    }

    @Nullable
    public final Integer b() {
        return this.f18537b;
    }

    @Nullable
    public final Boolean c() {
        return this.f18538c;
    }

    @Nullable
    public final com.moloco.sdk.internal.services.b d() {
        return this.f18539d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return kotlin.jvm.internal.t.d(this.f18536a, rVar.f18536a) && kotlin.jvm.internal.t.d(this.f18537b, rVar.f18537b) && kotlin.jvm.internal.t.d(this.f18538c, rVar.f18538c) && kotlin.jvm.internal.t.d(this.f18539d, rVar.f18539d);
    }

    public int hashCode() {
        Integer num = this.f18536a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f18537b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.f18538c;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        com.moloco.sdk.internal.services.b bVar = this.f18539d;
        return iHashCode3 + (bVar != null ? bVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NetworkInfoSignal(mobileCountryCode=" + this.f18536a + ", mobileNetworkCode=" + this.f18537b + ", networkRestricted=" + this.f18538c + ", networkType=" + this.f18539d + ')';
    }

    public r(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable com.moloco.sdk.internal.services.b bVar) {
        this.f18536a = num;
        this.f18537b = num2;
        this.f18538c = bool;
        this.f18539d = bVar;
    }

    public /* synthetic */ r(Integer num, Integer num2, Boolean bool, com.moloco.sdk.internal.services.b bVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : bool, (i10 & 8) != 0 ? null : bVar);
    }
}
