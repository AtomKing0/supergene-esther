package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class f8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final h8 f12083b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12084a;

        static {
            int[] iArr = new int[h8.values().length];
            try {
                iArr[h8.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h8.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h8.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f12084a = iArr;
        }
    }

    public f8(boolean z10, @Nullable h8 h8Var) {
        this.f12082a = z10;
        this.f12083b = h8Var;
    }

    public static /* synthetic */ f8 a(f8 f8Var, boolean z10, h8 h8Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = f8Var.f12082a;
        }
        if ((i10 & 2) != 0) {
            h8Var = f8Var.f12083b;
        }
        return f8Var.a(z10, h8Var);
    }

    @Nullable
    public final h8 b() {
        return this.f12083b;
    }

    @Nullable
    public final h8 c() {
        return this.f12083b;
    }

    public final boolean d() {
        return this.f12082a;
    }

    @Nullable
    public final String e() {
        h8 h8Var = this.f12083b;
        int i10 = h8Var == null ? -1 : a.f12084a[h8Var.ordinal()];
        if (i10 == 1) {
            return "Placement delivery is false";
        }
        if (i10 == 2) {
            return "In pacing mode";
        }
        if (i10 != 3) {
            return null;
        }
        return "Max ad cap reached";
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f8)) {
            return false;
        }
        f8 f8Var = (f8) obj;
        return this.f12082a == f8Var.f12082a && this.f12083b == f8Var.f12083b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.f12082a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        h8 h8Var = this.f12083b;
        return i10 + (h8Var == null ? 0 : h8Var.hashCode());
    }

    @NotNull
    public String toString() {
        return "CappingStatus(isCapped=" + this.f12082a + " reason=" + this.f12083b + ')';
    }

    public /* synthetic */ f8(boolean z10, h8 h8Var, int i10, kotlin.jvm.internal.k kVar) {
        this(z10, (i10 & 2) != 0 ? null : h8Var);
    }

    @NotNull
    public final f8 a(boolean z10, @Nullable h8 h8Var) {
        return new f8(z10, h8Var);
    }

    public final boolean a() {
        return this.f12082a;
    }
}
