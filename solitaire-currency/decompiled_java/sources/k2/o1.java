package k2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k2.h;

/* JADX INFO: compiled from: Format.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o1 implements h {
    private static final o1 G = new b().E();
    public static final h.a<o1> H = new h.a() { // from class: k2.n1
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return o1.e(bundle);
        }
    };
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    private int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f29336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f29337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f29338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f29339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f29340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f29341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f29342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f29343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f29344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final c3.a f29345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f29346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f29347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f29348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<byte[]> f29349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final o2.m f29350o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f29351p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f29352q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f29353r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f29354s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f29355t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f29356u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public final byte[] f29357v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f29358w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final b4.c f29359x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f29360y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f29361z;

    /* JADX INFO: compiled from: Format.java */
    public static final class b {
        private int A;
        private int B;
        private int C;
        private int D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f29362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private String f29363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f29364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f29365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f29366e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f29367f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f29368g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private String f29369h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private c3.a f29370i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private String f29371j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private String f29372k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f29373l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        private List<byte[]> f29374m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        private o2.m f29375n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private long f29376o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f29377p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f29378q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private float f29379r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f29380s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private float f29381t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Nullable
        private byte[] f29382u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f29383v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Nullable
        private b4.c f29384w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f29385x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f29386y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f29387z;

        public o1 E() {
            return new o1(this);
        }

        public b F(int i10) {
            this.C = i10;
            return this;
        }

        public b G(int i10) {
            this.f29367f = i10;
            return this;
        }

        public b H(int i10) {
            this.f29385x = i10;
            return this;
        }

        public b I(@Nullable String str) {
            this.f29369h = str;
            return this;
        }

        public b J(@Nullable b4.c cVar) {
            this.f29384w = cVar;
            return this;
        }

        public b K(@Nullable String str) {
            this.f29371j = str;
            return this;
        }

        public b L(int i10) {
            this.D = i10;
            return this;
        }

        public b M(@Nullable o2.m mVar) {
            this.f29375n = mVar;
            return this;
        }

        public b N(int i10) {
            this.A = i10;
            return this;
        }

        public b O(int i10) {
            this.B = i10;
            return this;
        }

        public b P(float f10) {
            this.f29379r = f10;
            return this;
        }

        public b Q(int i10) {
            this.f29378q = i10;
            return this;
        }

        public b R(int i10) {
            this.f29362a = Integer.toString(i10);
            return this;
        }

        public b S(@Nullable String str) {
            this.f29362a = str;
            return this;
        }

        public b T(@Nullable List<byte[]> list) {
            this.f29374m = list;
            return this;
        }

        public b U(@Nullable String str) {
            this.f29363b = str;
            return this;
        }

        public b V(@Nullable String str) {
            this.f29364c = str;
            return this;
        }

        public b W(int i10) {
            this.f29373l = i10;
            return this;
        }

        public b X(@Nullable c3.a aVar) {
            this.f29370i = aVar;
            return this;
        }

        public b Y(int i10) {
            this.f29387z = i10;
            return this;
        }

        public b Z(int i10) {
            this.f29368g = i10;
            return this;
        }

        public b a0(float f10) {
            this.f29381t = f10;
            return this;
        }

        public b b0(@Nullable byte[] bArr) {
            this.f29382u = bArr;
            return this;
        }

        public b c0(int i10) {
            this.f29366e = i10;
            return this;
        }

        public b d0(int i10) {
            this.f29380s = i10;
            return this;
        }

        public b e0(@Nullable String str) {
            this.f29372k = str;
            return this;
        }

        public b f0(int i10) {
            this.f29386y = i10;
            return this;
        }

        public b g0(int i10) {
            this.f29365d = i10;
            return this;
        }

        public b h0(int i10) {
            this.f29383v = i10;
            return this;
        }

        public b i0(long j10) {
            this.f29376o = j10;
            return this;
        }

        public b j0(int i10) {
            this.f29377p = i10;
            return this;
        }

        public b() {
            this.f29367f = -1;
            this.f29368g = -1;
            this.f29373l = -1;
            this.f29376o = Long.MAX_VALUE;
            this.f29377p = -1;
            this.f29378q = -1;
            this.f29379r = -1.0f;
            this.f29381t = 1.0f;
            this.f29383v = -1;
            this.f29385x = -1;
            this.f29386y = -1;
            this.f29387z = -1;
            this.C = -1;
            this.D = 0;
        }

        private b(o1 o1Var) {
            this.f29362a = o1Var.f29336a;
            this.f29363b = o1Var.f29337b;
            this.f29364c = o1Var.f29338c;
            this.f29365d = o1Var.f29339d;
            this.f29366e = o1Var.f29340e;
            this.f29367f = o1Var.f29341f;
            this.f29368g = o1Var.f29342g;
            this.f29369h = o1Var.f29344i;
            this.f29370i = o1Var.f29345j;
            this.f29371j = o1Var.f29346k;
            this.f29372k = o1Var.f29347l;
            this.f29373l = o1Var.f29348m;
            this.f29374m = o1Var.f29349n;
            this.f29375n = o1Var.f29350o;
            this.f29376o = o1Var.f29351p;
            this.f29377p = o1Var.f29352q;
            this.f29378q = o1Var.f29353r;
            this.f29379r = o1Var.f29354s;
            this.f29380s = o1Var.f29355t;
            this.f29381t = o1Var.f29356u;
            this.f29382u = o1Var.f29357v;
            this.f29383v = o1Var.f29358w;
            this.f29384w = o1Var.f29359x;
            this.f29385x = o1Var.f29360y;
            this.f29386y = o1Var.f29361z;
            this.f29387z = o1Var.A;
            this.A = o1Var.B;
            this.B = o1Var.C;
            this.C = o1Var.D;
            this.D = o1Var.E;
        }
    }

    @Nullable
    private static <T> T d(@Nullable T t10, @Nullable T t11) {
        return t10 != null ? t10 : t11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o1 e(Bundle bundle) {
        b bVar = new b();
        a4.c.a(bundle);
        int i10 = 0;
        String string = bundle.getString(h(0));
        o1 o1Var = G;
        bVar.S((String) d(string, o1Var.f29336a)).U((String) d(bundle.getString(h(1)), o1Var.f29337b)).V((String) d(bundle.getString(h(2)), o1Var.f29338c)).g0(bundle.getInt(h(3), o1Var.f29339d)).c0(bundle.getInt(h(4), o1Var.f29340e)).G(bundle.getInt(h(5), o1Var.f29341f)).Z(bundle.getInt(h(6), o1Var.f29342g)).I((String) d(bundle.getString(h(7)), o1Var.f29344i)).X((c3.a) d((c3.a) bundle.getParcelable(h(8)), o1Var.f29345j)).K((String) d(bundle.getString(h(9)), o1Var.f29346k)).e0((String) d(bundle.getString(h(10)), o1Var.f29347l)).W(bundle.getInt(h(11), o1Var.f29348m));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(i(i10));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i10++;
        }
        b bVarM = bVar.T(arrayList).M((o2.m) bundle.getParcelable(h(13)));
        String strH = h(14);
        o1 o1Var2 = G;
        bVarM.i0(bundle.getLong(strH, o1Var2.f29351p)).j0(bundle.getInt(h(15), o1Var2.f29352q)).Q(bundle.getInt(h(16), o1Var2.f29353r)).P(bundle.getFloat(h(17), o1Var2.f29354s)).d0(bundle.getInt(h(18), o1Var2.f29355t)).a0(bundle.getFloat(h(19), o1Var2.f29356u)).b0(bundle.getByteArray(h(20))).h0(bundle.getInt(h(21), o1Var2.f29358w));
        Bundle bundle2 = bundle.getBundle(h(22));
        if (bundle2 != null) {
            bVar.J((b4.c) b4.c.f2084g.fromBundle(bundle2));
        }
        bVar.H(bundle.getInt(h(23), o1Var2.f29360y)).f0(bundle.getInt(h(24), o1Var2.f29361z)).Y(bundle.getInt(h(25), o1Var2.A)).N(bundle.getInt(h(26), o1Var2.B)).O(bundle.getInt(h(27), o1Var2.C)).F(bundle.getInt(h(28), o1Var2.D)).L(bundle.getInt(h(29), o1Var2.E));
        return bVar.E();
    }

    private static String h(int i10) {
        return Integer.toString(i10, 36);
    }

    private static String i(int i10) {
        return h(12) + "_" + Integer.toString(i10, 36);
    }

    public b b() {
        return new b();
    }

    public o1 c(int i10) {
        return b().L(i10).E();
    }

    public boolean equals(@Nullable Object obj) {
        int i10;
        if (this == obj) {
            return true;
        }
        if (obj == null || o1.class != obj.getClass()) {
            return false;
        }
        o1 o1Var = (o1) obj;
        int i11 = this.F;
        if (i11 == 0 || (i10 = o1Var.F) == 0 || i11 == i10) {
            return this.f29339d == o1Var.f29339d && this.f29340e == o1Var.f29340e && this.f29341f == o1Var.f29341f && this.f29342g == o1Var.f29342g && this.f29348m == o1Var.f29348m && this.f29351p == o1Var.f29351p && this.f29352q == o1Var.f29352q && this.f29353r == o1Var.f29353r && this.f29355t == o1Var.f29355t && this.f29358w == o1Var.f29358w && this.f29360y == o1Var.f29360y && this.f29361z == o1Var.f29361z && this.A == o1Var.A && this.B == o1Var.B && this.C == o1Var.C && this.D == o1Var.D && this.E == o1Var.E && Float.compare(this.f29354s, o1Var.f29354s) == 0 && Float.compare(this.f29356u, o1Var.f29356u) == 0 && a4.o0.c(this.f29336a, o1Var.f29336a) && a4.o0.c(this.f29337b, o1Var.f29337b) && a4.o0.c(this.f29344i, o1Var.f29344i) && a4.o0.c(this.f29346k, o1Var.f29346k) && a4.o0.c(this.f29347l, o1Var.f29347l) && a4.o0.c(this.f29338c, o1Var.f29338c) && Arrays.equals(this.f29357v, o1Var.f29357v) && a4.o0.c(this.f29345j, o1Var.f29345j) && a4.o0.c(this.f29359x, o1Var.f29359x) && a4.o0.c(this.f29350o, o1Var.f29350o) && g(o1Var);
        }
        return false;
    }

    public int f() {
        int i10;
        int i11 = this.f29352q;
        if (i11 == -1 || (i10 = this.f29353r) == -1) {
            return -1;
        }
        return i11 * i10;
    }

    public boolean g(o1 o1Var) {
        if (this.f29349n.size() != o1Var.f29349n.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f29349n.size(); i10++) {
            if (!Arrays.equals(this.f29349n.get(i10), o1Var.f29349n.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.F == 0) {
            String str = this.f29336a;
            int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f29337b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f29338c;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f29339d) * 31) + this.f29340e) * 31) + this.f29341f) * 31) + this.f29342g) * 31;
            String str4 = this.f29344i;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            c3.a aVar = this.f29345j;
            int iHashCode5 = (iHashCode4 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            String str5 = this.f29346k;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f29347l;
            this.F = ((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f29348m) * 31) + ((int) this.f29351p)) * 31) + this.f29352q) * 31) + this.f29353r) * 31) + Float.floatToIntBits(this.f29354s)) * 31) + this.f29355t) * 31) + Float.floatToIntBits(this.f29356u)) * 31) + this.f29358w) * 31) + this.f29360y) * 31) + this.f29361z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E;
        }
        return this.F;
    }

    public Bundle j(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString(h(0), this.f29336a);
        bundle.putString(h(1), this.f29337b);
        bundle.putString(h(2), this.f29338c);
        bundle.putInt(h(3), this.f29339d);
        bundle.putInt(h(4), this.f29340e);
        bundle.putInt(h(5), this.f29341f);
        bundle.putInt(h(6), this.f29342g);
        bundle.putString(h(7), this.f29344i);
        if (!z10) {
            bundle.putParcelable(h(8), this.f29345j);
        }
        bundle.putString(h(9), this.f29346k);
        bundle.putString(h(10), this.f29347l);
        bundle.putInt(h(11), this.f29348m);
        for (int i10 = 0; i10 < this.f29349n.size(); i10++) {
            bundle.putByteArray(i(i10), this.f29349n.get(i10));
        }
        bundle.putParcelable(h(13), this.f29350o);
        bundle.putLong(h(14), this.f29351p);
        bundle.putInt(h(15), this.f29352q);
        bundle.putInt(h(16), this.f29353r);
        bundle.putFloat(h(17), this.f29354s);
        bundle.putInt(h(18), this.f29355t);
        bundle.putFloat(h(19), this.f29356u);
        bundle.putByteArray(h(20), this.f29357v);
        bundle.putInt(h(21), this.f29358w);
        if (this.f29359x != null) {
            bundle.putBundle(h(22), this.f29359x.toBundle());
        }
        bundle.putInt(h(23), this.f29360y);
        bundle.putInt(h(24), this.f29361z);
        bundle.putInt(h(25), this.A);
        bundle.putInt(h(26), this.B);
        bundle.putInt(h(27), this.C);
        bundle.putInt(h(28), this.D);
        bundle.putInt(h(29), this.E);
        return bundle;
    }

    @Override // k2.h
    public Bundle toBundle() {
        return j(false);
    }

    public String toString() {
        return "Format(" + this.f29336a + ", " + this.f29337b + ", " + this.f29346k + ", " + this.f29347l + ", " + this.f29344i + ", " + this.f29343h + ", " + this.f29338c + ", [" + this.f29352q + ", " + this.f29353r + ", " + this.f29354s + "], [" + this.f29360y + ", " + this.f29361z + "])";
    }

    private o1(b bVar) {
        this.f29336a = bVar.f29362a;
        this.f29337b = bVar.f29363b;
        this.f29338c = a4.o0.y0(bVar.f29364c);
        this.f29339d = bVar.f29365d;
        this.f29340e = bVar.f29366e;
        int i10 = bVar.f29367f;
        this.f29341f = i10;
        int i11 = bVar.f29368g;
        this.f29342g = i11;
        this.f29343h = i11 != -1 ? i11 : i10;
        this.f29344i = bVar.f29369h;
        this.f29345j = bVar.f29370i;
        this.f29346k = bVar.f29371j;
        this.f29347l = bVar.f29372k;
        this.f29348m = bVar.f29373l;
        this.f29349n = bVar.f29374m == null ? Collections.emptyList() : bVar.f29374m;
        o2.m mVar = bVar.f29375n;
        this.f29350o = mVar;
        this.f29351p = bVar.f29376o;
        this.f29352q = bVar.f29377p;
        this.f29353r = bVar.f29378q;
        this.f29354s = bVar.f29379r;
        this.f29355t = bVar.f29380s == -1 ? 0 : bVar.f29380s;
        this.f29356u = bVar.f29381t == -1.0f ? 1.0f : bVar.f29381t;
        this.f29357v = bVar.f29382u;
        this.f29358w = bVar.f29383v;
        this.f29359x = bVar.f29384w;
        this.f29360y = bVar.f29385x;
        this.f29361z = bVar.f29386y;
        this.A = bVar.f29387z;
        this.B = bVar.A == -1 ? 0 : bVar.A;
        this.C = bVar.B != -1 ? bVar.B : 0;
        this.D = bVar.C;
        if (bVar.D != 0 || mVar == null) {
            this.E = bVar.D;
        } else {
            this.E = 1;
        }
    }
}
