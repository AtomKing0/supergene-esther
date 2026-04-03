package com.moloco.sdk.internal.services.bidtoken.providers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Integer f18503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f18504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Boolean f18505c;

    public h() {
        this(null, null, null, 7, null);
    }

    @Nullable
    public final Integer a() {
        return this.f18504b;
    }

    @Nullable
    public final Integer b() {
        return this.f18503a;
    }

    @Nullable
    public final Boolean c() {
        return this.f18505c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return kotlin.jvm.internal.t.d(this.f18503a, hVar.f18503a) && kotlin.jvm.internal.t.d(this.f18504b, hVar.f18504b) && kotlin.jvm.internal.t.d(this.f18505c, hVar.f18505c);
    }

    public int hashCode() {
        Integer num = this.f18503a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f18504b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.f18505c;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BatteryInfoSignal(maxBatteryLevel=" + this.f18503a + ", batteryStatus=" + this.f18504b + ", isPowerSaveMode=" + this.f18505c + ')';
    }

    public h(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool) {
        this.f18503a = num;
        this.f18504b = num2;
        this.f18505c = bool;
    }

    public /* synthetic */ h(Integer num, Integer num2, Boolean bool, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : bool);
    }
}
