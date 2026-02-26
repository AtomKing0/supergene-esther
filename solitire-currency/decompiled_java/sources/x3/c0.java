package x3;

import a4.o0;
import androidx.annotation.Nullable;
import k2.d3;
import k2.s3;

/* JADX INFO: compiled from: TrackSelectorResult.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d3[] f35934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s[] f35935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s3 f35936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Object f35937e;

    public c0(d3[] d3VarArr, s[] sVarArr, s3 s3Var, @Nullable Object obj) {
        this.f35934b = d3VarArr;
        this.f35935c = (s[]) sVarArr.clone();
        this.f35936d = s3Var;
        this.f35937e = obj;
        this.f35933a = d3VarArr.length;
    }

    public boolean a(@Nullable c0 c0Var) {
        if (c0Var == null || c0Var.f35935c.length != this.f35935c.length) {
            return false;
        }
        for (int i10 = 0; i10 < this.f35935c.length; i10++) {
            if (!b(c0Var, i10)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(@Nullable c0 c0Var, int i10) {
        return c0Var != null && o0.c(this.f35934b[i10], c0Var.f35934b[i10]) && o0.c(this.f35935c[i10], c0Var.f35935c[i10]);
    }

    public boolean c(int i10) {
        return this.f35934b[i10] != null;
    }
}
