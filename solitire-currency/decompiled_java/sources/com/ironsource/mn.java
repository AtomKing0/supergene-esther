package com.ironsource;

import com.google.android.gms.drive.DriveFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class mn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14035b;

    /* JADX WARN: Multi-variable type inference failed */
    public mn() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static /* synthetic */ mn a(mn mnVar, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = mnVar.f14034a;
        }
        if ((i11 & 2) != 0) {
            i10 = mnVar.f14035b;
        }
        return mnVar.a(z10, i10);
    }

    public final int b() {
        return this.f14035b;
    }

    public final int c() {
        return this.f14035b;
    }

    public final boolean d() {
        return this.f14034a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mn)) {
            return false;
        }
        mn mnVar = (mn) obj;
        return this.f14034a == mnVar.f14034a && this.f14035b == mnVar.f14035b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.f14034a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.f14035b;
    }

    @NotNull
    public String toString() {
        return "OpenUrlConfigurations(isImmersive=" + this.f14034a + ", flags=" + this.f14035b + ')';
    }

    public mn(boolean z10, int i10) {
        this.f14034a = z10;
        this.f14035b = i10;
    }

    @NotNull
    public final mn a(boolean z10, int i10) {
        return new mn(z10, i10);
    }

    public /* synthetic */ mn(boolean z10, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? DriveFile.MODE_READ_WRITE : i10);
    }

    public final boolean a() {
        return this.f14034a;
    }
}
