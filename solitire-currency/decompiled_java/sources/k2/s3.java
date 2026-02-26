package k2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k2.h;
import k2.s3;

/* JADX INFO: compiled from: Tracks.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s3 implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s3 f29474b = new s3(com.google.common.collect.y.q());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h.a<s3> f29475c = new h.a() { // from class: k2.q3
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return s3.f(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.collect.y<a> f29476a;

    /* JADX INFO: compiled from: Tracks.java */
    public static final class a implements h {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h.a<a> f29477f = new h.a() { // from class: k2.r3
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return s3.a.j(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l3.c1 f29479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f29480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f29481d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean[] f29482e;

        public a(l3.c1 c1Var, boolean z10, int[] iArr, boolean[] zArr) {
            int i10 = c1Var.f30482a;
            this.f29478a = i10;
            boolean z11 = false;
            a4.a.a(i10 == iArr.length && i10 == zArr.length);
            this.f29479b = c1Var;
            if (z10 && i10 > 1) {
                z11 = true;
            }
            this.f29480c = z11;
            this.f29481d = (int[]) iArr.clone();
            this.f29482e = (boolean[]) zArr.clone();
        }

        private static String i(int i10) {
            return Integer.toString(i10, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ a j(Bundle bundle) {
            l3.c1 c1Var = (l3.c1) l3.c1.f30481f.fromBundle((Bundle) a4.a.e(bundle.getBundle(i(0))));
            return new a(c1Var, bundle.getBoolean(i(4), false), (int[]) e5.i.a(bundle.getIntArray(i(1)), new int[c1Var.f30482a]), (boolean[]) e5.i.a(bundle.getBooleanArray(i(3)), new boolean[c1Var.f30482a]));
        }

        public l3.c1 b() {
            return this.f29479b;
        }

        public o1 c(int i10) {
            return this.f29479b.c(i10);
        }

        public int d() {
            return this.f29479b.f30484c;
        }

        public boolean e() {
            return g5.a.b(this.f29482e, true);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f29480c == aVar.f29480c && this.f29479b.equals(aVar.f29479b) && Arrays.equals(this.f29481d, aVar.f29481d) && Arrays.equals(this.f29482e, aVar.f29482e);
        }

        public boolean f(int i10) {
            return this.f29482e[i10];
        }

        public boolean g(int i10) {
            return h(i10, false);
        }

        public boolean h(int i10, boolean z10) {
            int i11 = this.f29481d[i10];
            return i11 == 4 || (z10 && i11 == 3);
        }

        public int hashCode() {
            return (((((this.f29479b.hashCode() * 31) + (this.f29480c ? 1 : 0)) * 31) + Arrays.hashCode(this.f29481d)) * 31) + Arrays.hashCode(this.f29482e);
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(i(0), this.f29479b.toBundle());
            bundle.putIntArray(i(1), this.f29481d);
            bundle.putBooleanArray(i(3), this.f29482e);
            bundle.putBoolean(i(4), this.f29480c);
            return bundle;
        }
    }

    public s3(List<a> list) {
        this.f29476a = com.google.common.collect.y.m(list);
    }

    private static String e(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s3 f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        return new s3(parcelableArrayList == null ? com.google.common.collect.y.q() : a4.c.b(a.f29477f, parcelableArrayList));
    }

    public com.google.common.collect.y<a> b() {
        return this.f29476a;
    }

    public boolean c() {
        return this.f29476a.isEmpty();
    }

    public boolean d(int i10) {
        for (int i11 = 0; i11 < this.f29476a.size(); i11++) {
            a aVar = this.f29476a.get(i11);
            if (aVar.e() && aVar.d() == i10) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s3.class != obj.getClass()) {
            return false;
        }
        return this.f29476a.equals(((s3) obj).f29476a);
    }

    public int hashCode() {
        return this.f29476a.hashCode();
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), a4.c.d(this.f29476a));
        return bundle;
    }
}
