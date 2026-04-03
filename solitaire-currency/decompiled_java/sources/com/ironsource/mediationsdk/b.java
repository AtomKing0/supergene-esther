package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s.d f13302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13305d;

    public b(@NotNull s.d sdkState, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.t.i(sdkState, "sdkState");
        this.f13302a = sdkState;
        this.f13303b = z10;
        this.f13304c = z11;
        this.f13305d = z12;
    }

    public static /* synthetic */ b a(b bVar, s.d dVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = bVar.f13302a;
        }
        if ((i10 & 2) != 0) {
            z10 = bVar.f13303b;
        }
        if ((i10 & 4) != 0) {
            z11 = bVar.f13304c;
        }
        if ((i10 & 8) != 0) {
            z12 = bVar.f13305d;
        }
        return bVar.a(dVar, z10, z11, z12);
    }

    public final boolean b() {
        return this.f13303b;
    }

    public final boolean c() {
        return this.f13304c;
    }

    public final boolean d() {
        return this.f13305d;
    }

    @NotNull
    public final s.d e() {
        return this.f13302a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13302a == bVar.f13302a && this.f13303b == bVar.f13303b && this.f13304c == bVar.f13304c && this.f13305d == bVar.f13305d;
    }

    public final boolean f() {
        return this.f13305d;
    }

    public final boolean g() {
        return this.f13304c;
    }

    public final boolean h() {
        return this.f13303b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.f13302a.hashCode() * 31;
        boolean z10 = this.f13303b;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int i10 = (iHashCode + r12) * 31;
        boolean z11 = this.f13304c;
        ?? r13 = z11;
        if (z11) {
            r13 = 1;
        }
        int i11 = (i10 + r13) * 31;
        boolean z12 = this.f13305d;
        return i11 + (z12 ? 1 : z12);
    }

    @NotNull
    public String toString() {
        return "AdUnitInitStateInfo(sdkState=" + this.f13302a + ", isRetryForMoreThan15Secs=" + this.f13303b + ", isDemandOnlyInitRequested=" + this.f13304c + ", isAdUnitInitRequested=" + this.f13305d + ')';
    }

    @NotNull
    public final b a(@NotNull s.d sdkState, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.t.i(sdkState, "sdkState");
        return new b(sdkState, z10, z11, z12);
    }

    @NotNull
    public final s.d a() {
        return this.f13302a;
    }
}
