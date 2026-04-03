package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12187c;

    public fu(boolean z10, boolean z11, boolean z12) {
        this.f12185a = z10;
        this.f12186b = z11;
        this.f12187c = z12;
    }

    public static /* synthetic */ fu a(fu fuVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = fuVar.f12185a;
        }
        if ((i10 & 2) != 0) {
            z11 = fuVar.f12186b;
        }
        if ((i10 & 4) != 0) {
            z12 = fuVar.f12187c;
        }
        return fuVar.a(z10, z11, z12);
    }

    public final boolean b() {
        return this.f12186b;
    }

    public final boolean c() {
        return this.f12187c;
    }

    public final boolean d() {
        return this.f12187c;
    }

    public final boolean e() {
        return this.f12185a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fu)) {
            return false;
        }
        fu fuVar = (fu) obj;
        return this.f12185a == fuVar.f12185a && this.f12186b == fuVar.f12186b && this.f12187c == fuVar.f12187c;
    }

    public final boolean f() {
        return this.f12186b;
    }

    @NotNull
    public final JSONObject g() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(Cif.f12602k, this.f12185a).put(Cif.f12603l, this.f12186b).put(Cif.f12604m, this.f12187c);
        kotlin.jvm.internal.t.h(jSONObjectPut, "JSONObject()\n        .pu…ts.IS_SHOWN_KEY, isShown)");
        return jSONObjectPut;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z10 = this.f12185a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.f12186b;
        ?? r22 = z11;
        if (z11) {
            r22 = 1;
        }
        int i11 = (i10 + r22) * 31;
        boolean z12 = this.f12187c;
        return i11 + (z12 ? 1 : z12);
    }

    @NotNull
    public String toString() {
        return "ViewVisibilityParams(isVisible=" + this.f12185a + ", isWindowVisible=" + this.f12186b + ", isShown=" + this.f12187c + ')';
    }

    @NotNull
    public final fu a(boolean z10, boolean z11, boolean z12) {
        return new fu(z10, z11, z12);
    }

    public final boolean a() {
        return this.f12185a;
    }
}
