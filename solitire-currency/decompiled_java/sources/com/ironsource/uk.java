package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class uk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final gh f15594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f15595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f15596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f15597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f15598e;

    public uk(@NotNull gh instanceType, @NotNull String adSourceNameForEvents, long j10, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(instanceType, "instanceType");
        kotlin.jvm.internal.t.i(adSourceNameForEvents, "adSourceNameForEvents");
        this.f15594a = instanceType;
        this.f15595b = adSourceNameForEvents;
        this.f15596c = j10;
        this.f15597d = z10;
        this.f15598e = z11;
    }

    @NotNull
    public final gh a() {
        return this.f15594a;
    }

    @NotNull
    public final String b() {
        return this.f15595b;
    }

    public final long c() {
        return this.f15596c;
    }

    public final boolean d() {
        return this.f15597d;
    }

    public final boolean e() {
        return this.f15598e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uk)) {
            return false;
        }
        uk ukVar = (uk) obj;
        return this.f15594a == ukVar.f15594a && kotlin.jvm.internal.t.d(this.f15595b, ukVar.f15595b) && this.f15596c == ukVar.f15596c && this.f15597d == ukVar.f15597d && this.f15598e == ukVar.f15598e;
    }

    @NotNull
    public final String f() {
        return this.f15595b;
    }

    @NotNull
    public final gh g() {
        return this.f15594a;
    }

    public final long h() {
        return this.f15596c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((this.f15594a.hashCode() * 31) + this.f15595b.hashCode()) * 31) + androidx.compose.animation.a.a(this.f15596c)) * 31;
        boolean z10 = this.f15597d;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int i10 = (iHashCode + r12) * 31;
        boolean z11 = this.f15598e;
        return i10 + (z11 ? 1 : z11);
    }

    public final boolean i() {
        return this.f15598e;
    }

    public final boolean j() {
        return this.f15597d;
    }

    @NotNull
    public String toString() {
        return "LoadTaskConfig(instanceType=" + this.f15594a + ", adSourceNameForEvents=" + this.f15595b + ", loadTimeoutInMills=" + this.f15596c + ", isOneFlow=" + this.f15597d + ", isMultipleAdObjects=" + this.f15598e + ')';
    }

    public /* synthetic */ uk(gh ghVar, String str, long j10, boolean z10, boolean z11, int i10, kotlin.jvm.internal.k kVar) {
        this(ghVar, str, j10, z10, (i10 & 16) != 0 ? true : z11);
    }

    @NotNull
    public final uk a(@NotNull gh instanceType, @NotNull String adSourceNameForEvents, long j10, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(instanceType, "instanceType");
        kotlin.jvm.internal.t.i(adSourceNameForEvents, "adSourceNameForEvents");
        return new uk(instanceType, adSourceNameForEvents, j10, z10, z11);
    }

    public static /* synthetic */ uk a(uk ukVar, gh ghVar, String str, long j10, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ghVar = ukVar.f15594a;
        }
        if ((i10 & 2) != 0) {
            str = ukVar.f15595b;
        }
        String str2 = str;
        if ((i10 & 4) != 0) {
            j10 = ukVar.f15596c;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            z10 = ukVar.f15597d;
        }
        boolean z12 = z10;
        if ((i10 & 16) != 0) {
            z11 = ukVar.f15598e;
        }
        return ukVar.a(ghVar, str2, j11, z12, z11);
    }
}
