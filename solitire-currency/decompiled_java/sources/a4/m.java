package a4;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: FlagSet.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f195a;

    /* JADX INFO: compiled from: FlagSet.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f196a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f197b;

        public b a(int i10) {
            a4.a.g(!this.f197b);
            this.f196a.append(i10, true);
            return this;
        }

        public b b(m mVar) {
            for (int i10 = 0; i10 < mVar.d(); i10++) {
                a(mVar.c(i10));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i10 : iArr) {
                a(i10);
            }
            return this;
        }

        public b d(int i10, boolean z10) {
            return z10 ? a(i10) : this;
        }

        public m e() {
            a4.a.g(!this.f197b);
            this.f197b = true;
            return new m(this.f196a);
        }
    }

    public boolean a(int i10) {
        return this.f195a.get(i10);
    }

    public boolean b(int... iArr) {
        for (int i10 : iArr) {
            if (a(i10)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i10) {
        a4.a.c(i10, 0, d());
        return this.f195a.keyAt(i10);
    }

    public int d() {
        return this.f195a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (o0.f214a >= 24) {
            return this.f195a.equals(mVar.f195a);
        }
        if (d() != mVar.d()) {
            return false;
        }
        for (int i10 = 0; i10 < d(); i10++) {
            if (c(i10) != mVar.c(i10)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (o0.f214a >= 24) {
            return this.f195a.hashCode();
        }
        int iD = d();
        for (int i10 = 0; i10 < d(); i10++) {
            iD = (iD * 31) + c(i10);
        }
        return iD;
    }

    private m(SparseBooleanArray sparseBooleanArray) {
        this.f195a = sparseBooleanArray;
    }
}
