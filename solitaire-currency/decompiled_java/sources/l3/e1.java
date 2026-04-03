package l3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import k2.h;

/* JADX INFO: compiled from: TrackGroupArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e1 implements k2.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e1 f30515d = new e1(new c1[0]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h.a<e1> f30516e = new h.a() { // from class: l3.d1
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return e1.e(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.common.collect.y<c1> f30518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30519c;

    public e1(c1... c1VarArr) {
        this.f30518b = com.google.common.collect.y.n(c1VarArr);
        this.f30517a = c1VarArr.length;
        f();
    }

    private static String d(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e1 e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return parcelableArrayList == null ? new e1(new c1[0]) : new e1((c1[]) a4.c.b(c1.f30481f, parcelableArrayList).toArray(new c1[0]));
    }

    private void f() {
        int i10 = 0;
        while (i10 < this.f30518b.size()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f30518b.size(); i12++) {
                if (this.f30518b.get(i10).equals(this.f30518b.get(i12))) {
                    a4.t.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i10 = i11;
        }
    }

    public c1 b(int i10) {
        return this.f30518b.get(i10);
    }

    public int c(c1 c1Var) {
        int iIndexOf = this.f30518b.indexOf(c1Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e1.class != obj.getClass()) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return this.f30517a == e1Var.f30517a && this.f30518b.equals(e1Var.f30518b);
    }

    public int hashCode() {
        if (this.f30519c == 0) {
            this.f30519c = this.f30518b.hashCode();
        }
        return this.f30519c;
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), a4.c.d(this.f30518b));
        return bundle;
    }
}
