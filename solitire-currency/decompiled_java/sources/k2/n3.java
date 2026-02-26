package k2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.google.common.collect.y;
import java.util.ArrayList;
import k2.h;
import k2.n3;
import k2.w1;
import m3.c;

/* JADX INFO: compiled from: Timeline.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n3 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n3 f29295a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h.a<n3> f29296b = new h.a() { // from class: k2.m3
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return n3.b(bundle);
        }
    };

    /* JADX INFO: compiled from: Timeline.java */
    class a extends n3 {
        a() {
        }

        @Override // k2.n3
        public int f(Object obj) {
            return -1;
        }

        @Override // k2.n3
        public b k(int i10, b bVar, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // k2.n3
        public int m() {
            return 0;
        }

        @Override // k2.n3
        public Object q(int i10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // k2.n3
        public d s(int i10, d dVar, long j10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // k2.n3
        public int t() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: Timeline.java */
    public static final class b implements h {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h.a<b> f29297h = new h.a() { // from class: k2.o3
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return n3.b.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Object f29298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f29299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f29300c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f29301d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f29302e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f29303f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private m3.c f29304g = m3.c.f31432g;

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Bundle bundle) {
            int i10 = bundle.getInt(u(0), 0);
            long j10 = bundle.getLong(u(1), C.TIME_UNSET);
            long j11 = bundle.getLong(u(2), 0L);
            boolean z10 = bundle.getBoolean(u(3));
            Bundle bundle2 = bundle.getBundle(u(4));
            m3.c cVar = bundle2 != null ? (m3.c) m3.c.f31434i.fromBundle(bundle2) : m3.c.f31432g;
            b bVar = new b();
            bVar.w(null, null, i10, j10, j11, cVar, z10);
            return bVar;
        }

        private static String u(int i10) {
            return Integer.toString(i10, 36);
        }

        public int d(int i10) {
            return this.f29304g.c(i10).f31443b;
        }

        public long e(int i10, int i11) {
            c.a aVarC = this.f29304g.c(i10);
            return aVarC.f31443b != -1 ? aVarC.f31447f[i11] : C.TIME_UNSET;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return a4.o0.c(this.f29298a, bVar.f29298a) && a4.o0.c(this.f29299b, bVar.f29299b) && this.f29300c == bVar.f29300c && this.f29301d == bVar.f29301d && this.f29302e == bVar.f29302e && this.f29303f == bVar.f29303f && a4.o0.c(this.f29304g, bVar.f29304g);
        }

        public int f() {
            return this.f29304g.f31436b;
        }

        public int g(long j10) {
            return this.f29304g.d(j10, this.f29301d);
        }

        public int h(long j10) {
            return this.f29304g.e(j10, this.f29301d);
        }

        public int hashCode() {
            Object obj = this.f29298a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f29299b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f29300c) * 31;
            long j10 = this.f29301d;
            int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f29302e;
            return ((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f29303f ? 1 : 0)) * 31) + this.f29304g.hashCode();
        }

        public long i(int i10) {
            return this.f29304g.c(i10).f31442a;
        }

        public long j() {
            return this.f29304g.f31437c;
        }

        public int k(int i10, int i11) {
            c.a aVarC = this.f29304g.c(i10);
            if (aVarC.f31443b != -1) {
                return aVarC.f31446e[i11];
            }
            return 0;
        }

        public long l(int i10) {
            return this.f29304g.c(i10).f31448g;
        }

        public long m() {
            return this.f29301d;
        }

        public int n(int i10) {
            return this.f29304g.c(i10).e();
        }

        public int o(int i10, int i11) {
            return this.f29304g.c(i10).f(i11);
        }

        public long p() {
            return a4.o0.P0(this.f29302e);
        }

        public long q() {
            return this.f29302e;
        }

        public int r() {
            return this.f29304g.f31439e;
        }

        public boolean s(int i10) {
            return !this.f29304g.c(i10).g();
        }

        public boolean t(int i10) {
            return this.f29304g.c(i10).f31449h;
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(u(0), this.f29300c);
            bundle.putLong(u(1), this.f29301d);
            bundle.putLong(u(2), this.f29302e);
            bundle.putBoolean(u(3), this.f29303f);
            bundle.putBundle(u(4), this.f29304g.toBundle());
            return bundle;
        }

        public b v(@Nullable Object obj, @Nullable Object obj2, int i10, long j10, long j11) {
            return w(obj, obj2, i10, j10, j11, m3.c.f31432g, false);
        }

        public b w(@Nullable Object obj, @Nullable Object obj2, int i10, long j10, long j11, m3.c cVar, boolean z10) {
            this.f29298a = obj;
            this.f29299b = obj2;
            this.f29300c = i10;
            this.f29301d = j10;
            this.f29302e = j11;
            this.f29304g = cVar;
            this.f29303f = z10;
            return this;
        }
    }

    /* JADX INFO: compiled from: Timeline.java */
    public static final class c extends n3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.common.collect.y<d> f29305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.google.common.collect.y<b> f29306d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f29307e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f29308f;

        public c(com.google.common.collect.y<d> yVar, com.google.common.collect.y<b> yVar2, int[] iArr) {
            a4.a.a(yVar.size() == iArr.length);
            this.f29305c = yVar;
            this.f29306d = yVar2;
            this.f29307e = iArr;
            this.f29308f = new int[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                this.f29308f[iArr[i10]] = i10;
            }
        }

        @Override // k2.n3
        public int e(boolean z10) {
            if (u()) {
                return -1;
            }
            if (z10) {
                return this.f29307e[0];
            }
            return 0;
        }

        @Override // k2.n3
        public int f(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // k2.n3
        public int g(boolean z10) {
            if (u()) {
                return -1;
            }
            return z10 ? this.f29307e[t() - 1] : t() - 1;
        }

        @Override // k2.n3
        public int i(int i10, int i11, boolean z10) {
            if (i11 == 1) {
                return i10;
            }
            if (i10 != g(z10)) {
                return z10 ? this.f29307e[this.f29308f[i10] + 1] : i10 + 1;
            }
            if (i11 == 2) {
                return e(z10);
            }
            return -1;
        }

        @Override // k2.n3
        public b k(int i10, b bVar, boolean z10) {
            b bVar2 = this.f29306d.get(i10);
            bVar.w(bVar2.f29298a, bVar2.f29299b, bVar2.f29300c, bVar2.f29301d, bVar2.f29302e, bVar2.f29304g, bVar2.f29303f);
            return bVar;
        }

        @Override // k2.n3
        public int m() {
            return this.f29306d.size();
        }

        @Override // k2.n3
        public int p(int i10, int i11, boolean z10) {
            if (i11 == 1) {
                return i10;
            }
            if (i10 != e(z10)) {
                return z10 ? this.f29307e[this.f29308f[i10] - 1] : i10 - 1;
            }
            if (i11 == 2) {
                return g(z10);
            }
            return -1;
        }

        @Override // k2.n3
        public Object q(int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // k2.n3
        public d s(int i10, d dVar, long j10) {
            d dVar2 = this.f29305c.get(i10);
            dVar.k(dVar2.f29313a, dVar2.f29315c, dVar2.f29316d, dVar2.f29317e, dVar2.f29318f, dVar2.f29319g, dVar2.f29320h, dVar2.f29321i, dVar2.f29323k, dVar2.f29325m, dVar2.f29326n, dVar2.f29327o, dVar2.f29328p, dVar2.f29329q);
            dVar.f29324l = dVar2.f29324l;
            return dVar;
        }

        @Override // k2.n3
        public int t() {
            return this.f29305c.size();
        }
    }

    /* JADX INFO: compiled from: Timeline.java */
    public static final class d implements h {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final Object f29309r = new Object();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final Object f29310s = new Object();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final w1 f29311t = new w1.c().d("com.google.android.exoplayer2.Timeline").g(Uri.EMPTY).a();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final h.a<d> f29312u = new h.a() { // from class: k2.p3
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return n3.d.c(bundle);
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        @Deprecated
        public Object f29314b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f29316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f29317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f29318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f29319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f29320h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f29321i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Deprecated
        public boolean f29322j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public w1.g f29323k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f29324l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f29325m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f29326n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f29327o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f29328p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f29329q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f29313a = f29309r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public w1 f29315c = f29311t;

        /* JADX INFO: Access modifiers changed from: private */
        public static d c(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(j(1));
            w1 w1Var = bundle2 != null ? (w1) w1.f29515j.fromBundle(bundle2) : null;
            long j10 = bundle.getLong(j(2), C.TIME_UNSET);
            long j11 = bundle.getLong(j(3), C.TIME_UNSET);
            long j12 = bundle.getLong(j(4), C.TIME_UNSET);
            boolean z10 = bundle.getBoolean(j(5), false);
            boolean z11 = bundle.getBoolean(j(6), false);
            Bundle bundle3 = bundle.getBundle(j(7));
            w1.g gVar = bundle3 != null ? (w1.g) w1.g.f29569g.fromBundle(bundle3) : null;
            boolean z12 = bundle.getBoolean(j(8), false);
            long j13 = bundle.getLong(j(9), 0L);
            long j14 = bundle.getLong(j(10), C.TIME_UNSET);
            int i10 = bundle.getInt(j(11), 0);
            int i11 = bundle.getInt(j(12), 0);
            long j15 = bundle.getLong(j(13), 0L);
            d dVar = new d();
            dVar.k(f29310s, w1Var, null, j10, j11, j12, z10, z11, gVar, j13, j14, i10, i11, j15);
            dVar.f29324l = z12;
            return dVar;
        }

        private static String j(int i10) {
            return Integer.toString(i10, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle l(boolean z10) {
            Bundle bundle = new Bundle();
            bundle.putBundle(j(1), (z10 ? w1.f29514i : this.f29315c).toBundle());
            bundle.putLong(j(2), this.f29317e);
            bundle.putLong(j(3), this.f29318f);
            bundle.putLong(j(4), this.f29319g);
            bundle.putBoolean(j(5), this.f29320h);
            bundle.putBoolean(j(6), this.f29321i);
            w1.g gVar = this.f29323k;
            if (gVar != null) {
                bundle.putBundle(j(7), gVar.toBundle());
            }
            bundle.putBoolean(j(8), this.f29324l);
            bundle.putLong(j(9), this.f29325m);
            bundle.putLong(j(10), this.f29326n);
            bundle.putInt(j(11), this.f29327o);
            bundle.putInt(j(12), this.f29328p);
            bundle.putLong(j(13), this.f29329q);
            return bundle;
        }

        public long d() {
            return a4.o0.V(this.f29319g);
        }

        public long e() {
            return a4.o0.P0(this.f29325m);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return a4.o0.c(this.f29313a, dVar.f29313a) && a4.o0.c(this.f29315c, dVar.f29315c) && a4.o0.c(this.f29316d, dVar.f29316d) && a4.o0.c(this.f29323k, dVar.f29323k) && this.f29317e == dVar.f29317e && this.f29318f == dVar.f29318f && this.f29319g == dVar.f29319g && this.f29320h == dVar.f29320h && this.f29321i == dVar.f29321i && this.f29324l == dVar.f29324l && this.f29325m == dVar.f29325m && this.f29326n == dVar.f29326n && this.f29327o == dVar.f29327o && this.f29328p == dVar.f29328p && this.f29329q == dVar.f29329q;
        }

        public long f() {
            return this.f29325m;
        }

        public long g() {
            return a4.o0.P0(this.f29326n);
        }

        public long h() {
            return this.f29329q;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f29313a.hashCode()) * 31) + this.f29315c.hashCode()) * 31;
            Object obj = this.f29316d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            w1.g gVar = this.f29323k;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j10 = this.f29317e;
            int i10 = (iHashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f29318f;
            int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f29319g;
            int i12 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f29320h ? 1 : 0)) * 31) + (this.f29321i ? 1 : 0)) * 31) + (this.f29324l ? 1 : 0)) * 31;
            long j13 = this.f29325m;
            int i13 = (i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            long j14 = this.f29326n;
            int i14 = (((((i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.f29327o) * 31) + this.f29328p) * 31;
            long j15 = this.f29329q;
            return i14 + ((int) (j15 ^ (j15 >>> 32)));
        }

        public boolean i() {
            a4.a.g(this.f29322j == (this.f29323k != null));
            return this.f29323k != null;
        }

        public d k(Object obj, @Nullable w1 w1Var, @Nullable Object obj2, long j10, long j11, long j12, boolean z10, boolean z11, @Nullable w1.g gVar, long j13, long j14, int i10, int i11, long j15) {
            w1.h hVar;
            this.f29313a = obj;
            this.f29315c = w1Var != null ? w1Var : f29311t;
            this.f29314b = (w1Var == null || (hVar = w1Var.f29517b) == null) ? null : hVar.f29587h;
            this.f29316d = obj2;
            this.f29317e = j10;
            this.f29318f = j11;
            this.f29319g = j12;
            this.f29320h = z10;
            this.f29321i = z11;
            this.f29322j = gVar != null;
            this.f29323k = gVar;
            this.f29325m = j13;
            this.f29326n = j14;
            this.f29327o = i10;
            this.f29328p = i11;
            this.f29329q = j15;
            this.f29324l = false;
            return this;
        }

        @Override // k2.h
        public Bundle toBundle() {
            return l(false);
        }
    }

    protected n3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n3 b(Bundle bundle) {
        com.google.common.collect.y yVarC = c(d.f29312u, a4.b.a(bundle, w(0)));
        com.google.common.collect.y yVarC2 = c(b.f29297h, a4.b.a(bundle, w(1)));
        int[] intArray = bundle.getIntArray(w(2));
        if (intArray == null) {
            intArray = d(yVarC.size());
        }
        return new c(yVarC, yVarC2, intArray);
    }

    private static <T extends h> com.google.common.collect.y<T> c(h.a<T> aVar, @Nullable IBinder iBinder) {
        if (iBinder == null) {
            return com.google.common.collect.y.q();
        }
        y.a aVar2 = new y.a();
        com.google.common.collect.y<Bundle> yVarA = g.a(iBinder);
        for (int i10 = 0; i10 < yVarA.size(); i10++) {
            aVar2.a(aVar.fromBundle(yVarA.get(i10)));
        }
        return aVar2.k();
    }

    private static int[] d(int i10) {
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = i11;
        }
        return iArr;
    }

    private static String w(int i10) {
        return Integer.toString(i10, 36);
    }

    public int e(boolean z10) {
        return u() ? -1 : 0;
    }

    public boolean equals(@Nullable Object obj) {
        int iG;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (n3Var.t() != t() || n3Var.m() != m()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i10 = 0; i10 < t(); i10++) {
            if (!r(i10, dVar).equals(n3Var.r(i10, dVar2))) {
                return false;
            }
        }
        for (int i11 = 0; i11 < m(); i11++) {
            if (!k(i11, bVar, true).equals(n3Var.k(i11, bVar2, true))) {
                return false;
            }
        }
        int iE = e(true);
        if (iE != n3Var.e(true) || (iG = g(true)) != n3Var.g(true)) {
            return false;
        }
        while (iE != iG) {
            int i12 = i(iE, 0, true);
            if (i12 != n3Var.i(iE, 0, true)) {
                return false;
            }
            iE = i12;
        }
        return true;
    }

    public abstract int f(Object obj);

    public int g(boolean z10) {
        if (u()) {
            return -1;
        }
        return t() - 1;
    }

    public final int h(int i10, b bVar, d dVar, int i11, boolean z10) {
        int i12 = j(i10, bVar).f29300c;
        if (r(i12, dVar).f29328p != i10) {
            return i10 + 1;
        }
        int i13 = i(i12, i11, z10);
        if (i13 == -1) {
            return -1;
        }
        return r(i13, dVar).f29327o;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iT = 217 + t();
        for (int i10 = 0; i10 < t(); i10++) {
            iT = (iT * 31) + r(i10, dVar).hashCode();
        }
        int iM = (iT * 31) + m();
        for (int i11 = 0; i11 < m(); i11++) {
            iM = (iM * 31) + k(i11, bVar, true).hashCode();
        }
        int iE = e(true);
        while (iE != -1) {
            iM = (iM * 31) + iE;
            iE = i(iE, 0, true);
        }
        return iM;
    }

    public int i(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == g(z10)) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == g(z10) ? e(z10) : i10 + 1;
        }
        throw new IllegalStateException();
    }

    public final b j(int i10, b bVar) {
        return k(i10, bVar, false);
    }

    public abstract b k(int i10, b bVar, boolean z10);

    public b l(Object obj, b bVar) {
        return k(f(obj), bVar, true);
    }

    public abstract int m();

    public final Pair<Object, Long> n(d dVar, b bVar, int i10, long j10) {
        return (Pair) a4.a.e(o(dVar, bVar, i10, j10, 0L));
    }

    @Nullable
    public final Pair<Object, Long> o(d dVar, b bVar, int i10, long j10, long j11) {
        a4.a.c(i10, 0, t());
        s(i10, dVar, j11);
        if (j10 == C.TIME_UNSET) {
            j10 = dVar.f();
            if (j10 == C.TIME_UNSET) {
                return null;
            }
        }
        int i11 = dVar.f29327o;
        j(i11, bVar);
        while (i11 < dVar.f29328p && bVar.f29302e != j10) {
            int i12 = i11 + 1;
            if (j(i12, bVar).f29302e > j10) {
                break;
            }
            i11 = i12;
        }
        k(i11, bVar, true);
        long jMin = j10 - bVar.f29302e;
        long j12 = bVar.f29301d;
        if (j12 != C.TIME_UNSET) {
            jMin = Math.min(jMin, j12 - 1);
        }
        return Pair.create(a4.a.e(bVar.f29299b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int p(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == e(z10)) {
                return -1;
            }
            return i10 - 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == e(z10) ? g(z10) : i10 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object q(int i10);

    public final d r(int i10, d dVar) {
        return s(i10, dVar, 0L);
    }

    public abstract d s(int i10, d dVar, long j10);

    public abstract int t();

    @Override // k2.h
    public final Bundle toBundle() {
        return x(false);
    }

    public final boolean u() {
        return t() == 0;
    }

    public final boolean v(int i10, b bVar, d dVar, int i11, boolean z10) {
        return h(i10, bVar, dVar, i11, z10) == -1;
    }

    public final Bundle x(boolean z10) {
        ArrayList arrayList = new ArrayList();
        int iT = t();
        d dVar = new d();
        for (int i10 = 0; i10 < iT; i10++) {
            arrayList.add(s(i10, dVar, 0L).l(z10));
        }
        ArrayList arrayList2 = new ArrayList();
        int iM = m();
        b bVar = new b();
        for (int i11 = 0; i11 < iM; i11++) {
            arrayList2.add(k(i11, bVar, false).toBundle());
        }
        int[] iArr = new int[iT];
        if (iT > 0) {
            iArr[0] = e(true);
        }
        for (int i12 = 1; i12 < iT; i12++) {
            iArr[i12] = i(iArr[i12 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        a4.b.c(bundle, w(0), new g(arrayList));
        a4.b.c(bundle, w(1), new g(arrayList2));
        bundle.putIntArray(w(2), iArr);
        return bundle;
    }
}
