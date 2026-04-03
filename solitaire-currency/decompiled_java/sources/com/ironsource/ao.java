package com.ironsource;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private String f11303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private int[] f11306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private int[] f11307f;

    public ao() {
        this(false, null, false, 0, null, null, 63, null);
    }

    public static /* synthetic */ ao a(ao aoVar, boolean z10, String str, boolean z11, int i10, int[] iArr, int[] iArr2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = aoVar.f11302a;
        }
        if ((i11 & 2) != 0) {
            str = aoVar.f11303b;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            z11 = aoVar.f11304c;
        }
        boolean z12 = z11;
        if ((i11 & 8) != 0) {
            i10 = aoVar.f11305d;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            iArr = aoVar.f11306e;
        }
        int[] iArr3 = iArr;
        if ((i11 & 32) != 0) {
            iArr2 = aoVar.f11307f;
        }
        return aoVar.a(z10, str2, z12, i12, iArr3, iArr2);
    }

    @NotNull
    public final String b() {
        return this.f11303b;
    }

    public final boolean c() {
        return this.f11304c;
    }

    public final int d() {
        return this.f11305d;
    }

    @Nullable
    public final int[] e() {
        return this.f11306e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ao)) {
            return false;
        }
        ao aoVar = (ao) obj;
        return this.f11302a == aoVar.f11302a && kotlin.jvm.internal.t.d(this.f11303b, aoVar.f11303b) && this.f11304c == aoVar.f11304c && this.f11305d == aoVar.f11305d && kotlin.jvm.internal.t.d(this.f11306e, aoVar.f11306e) && kotlin.jvm.internal.t.d(this.f11307f, aoVar.f11307f);
    }

    @Nullable
    public final int[] f() {
        return this.f11307f;
    }

    public final boolean g() {
        return this.f11304c;
    }

    public final int h() {
        return this.f11305d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        boolean z10 = this.f11302a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int iHashCode = ((r02 * 31) + this.f11303b.hashCode()) * 31;
        boolean z11 = this.f11304c;
        int i10 = (((iHashCode + (z11 ? 1 : z11)) * 31) + this.f11305d) * 31;
        int[] iArr = this.f11306e;
        int iHashCode2 = (i10 + (iArr == null ? 0 : Arrays.hashCode(iArr))) * 31;
        int[] iArr2 = this.f11307f;
        return iHashCode2 + (iArr2 != null ? Arrays.hashCode(iArr2) : 0);
    }

    public final boolean i() {
        return this.f11302a;
    }

    @NotNull
    public final String j() {
        return this.f11303b;
    }

    @Nullable
    public final int[] k() {
        return this.f11307f;
    }

    @Nullable
    public final int[] l() {
        return this.f11306e;
    }

    @NotNull
    public String toString() {
        return "PixelSettings(pixelEventsEnabled=" + this.f11302a + ", pixelEventsUrl=" + this.f11303b + ", pixelEventsCompression=" + this.f11304c + ", pixelEventsCompressionLevel=" + this.f11305d + ", pixelOptOut=" + Arrays.toString(this.f11306e) + ", pixelOptIn=" + Arrays.toString(this.f11307f) + ')';
    }

    public ao(boolean z10, @NotNull String pixelEventsUrl, boolean z11, int i10, @Nullable int[] iArr, @Nullable int[] iArr2) {
        kotlin.jvm.internal.t.i(pixelEventsUrl, "pixelEventsUrl");
        this.f11302a = z10;
        this.f11303b = pixelEventsUrl;
        this.f11304c = z11;
        this.f11305d = i10;
        this.f11306e = iArr;
        this.f11307f = iArr2;
    }

    @NotNull
    public final ao a(boolean z10, @NotNull String pixelEventsUrl, boolean z11, int i10, @Nullable int[] iArr, @Nullable int[] iArr2) {
        kotlin.jvm.internal.t.i(pixelEventsUrl, "pixelEventsUrl");
        return new ao(z10, pixelEventsUrl, z11, i10, iArr, iArr2);
    }

    public final void b(boolean z10) {
        this.f11302a = z10;
    }

    public /* synthetic */ ao(boolean z10, String str, boolean z11, int i10, int[] iArr, int[] iArr2, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? bo.f11442a : str, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? -1 : i10, (i11 & 16) != 0 ? null : iArr, (i11 & 32) != 0 ? null : iArr2);
    }

    public final void a(int i10) {
        this.f11305d = i10;
    }

    public final void b(@Nullable int[] iArr) {
        this.f11306e = iArr;
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f11303b = str;
    }

    public final void a(boolean z10) {
        this.f11304c = z10;
    }

    public final void a(@Nullable int[] iArr) {
        this.f11307f = iArr;
    }

    public final boolean a() {
        return this.f11302a;
    }
}
