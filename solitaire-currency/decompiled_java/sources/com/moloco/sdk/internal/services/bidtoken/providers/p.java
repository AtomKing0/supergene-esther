package com.moloco.sdk.internal.services.bidtoken.providers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Boolean f18530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Long f18531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Long f18532c;

    public p() {
        this(null, null, null, 7, null);
    }

    @Nullable
    public final Boolean a() {
        return this.f18530a;
    }

    @Nullable
    public final Long b() {
        return this.f18531b;
    }

    @Nullable
    public final Long c() {
        return this.f18532c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kotlin.jvm.internal.t.d(this.f18530a, pVar.f18530a) && kotlin.jvm.internal.t.d(this.f18531b, pVar.f18531b) && kotlin.jvm.internal.t.d(this.f18532c, pVar.f18532c);
    }

    public int hashCode() {
        Boolean bool = this.f18530a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l10 = this.f18531b;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.f18532c;
        return iHashCode2 + (l11 != null ? l11.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MemoryInfoSignal(lowMemory=" + this.f18530a + ", threshold=" + this.f18531b + ", totalMem=" + this.f18532c + ')';
    }

    public p(@Nullable Boolean bool, @Nullable Long l10, @Nullable Long l11) {
        this.f18530a = bool;
        this.f18531b = l10;
        this.f18532c = l11;
    }

    public /* synthetic */ p(Boolean bool, Long l10, Long l11, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : l11);
    }
}
