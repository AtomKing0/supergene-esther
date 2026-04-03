package x3;

import a4.o0;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import k2.h;
import l3.c1;

/* JADX INFO: compiled from: TrackSelectionParameters.java */
/* JADX INFO: loaded from: classes2.dex */
public class z implements k2.h {
    public static final z A;

    @Deprecated
    public static final z B;

    @Deprecated
    public static final h.a<z> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f36028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f36031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f36032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f36033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f36034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f36035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f36036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f36037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f36038k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.common.collect.y<String> f36039l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f36040m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.common.collect.y<String> f36041n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f36042o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f36043p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f36044q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.google.common.collect.y<String> f36045r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.google.common.collect.y<String> f36046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f36047t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f36048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f36049v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f36050w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f36051x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.google.common.collect.a0<c1, x> f36052y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.google.common.collect.c0<Integer> f36053z;

    static {
        z zVarA = new a().A();
        A = zVarA;
        B = zVarA;
        C = new h.a() { // from class: x3.y
            @Override // k2.h.a
            public final k2.h fromBundle(Bundle bundle) {
                return z.b(bundle);
            }
        };
    }

    protected z(a aVar) {
        this.f36028a = aVar.f36054a;
        this.f36029b = aVar.f36055b;
        this.f36030c = aVar.f36056c;
        this.f36031d = aVar.f36057d;
        this.f36032e = aVar.f36058e;
        this.f36033f = aVar.f36059f;
        this.f36034g = aVar.f36060g;
        this.f36035h = aVar.f36061h;
        this.f36036i = aVar.f36062i;
        this.f36037j = aVar.f36063j;
        this.f36038k = aVar.f36064k;
        this.f36039l = aVar.f36065l;
        this.f36040m = aVar.f36066m;
        this.f36041n = aVar.f36067n;
        this.f36042o = aVar.f36068o;
        this.f36043p = aVar.f36069p;
        this.f36044q = aVar.f36070q;
        this.f36045r = aVar.f36071r;
        this.f36046s = aVar.f36072s;
        this.f36047t = aVar.f36073t;
        this.f36048u = aVar.f36074u;
        this.f36049v = aVar.f36075v;
        this.f36050w = aVar.f36076w;
        this.f36051x = aVar.f36077x;
        this.f36052y = com.google.common.collect.a0.c(aVar.f36078y);
        this.f36053z = com.google.common.collect.c0.m(aVar.f36079z);
    }

    public static z b(Bundle bundle) {
        return new a(bundle).A();
    }

    protected static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    public a a() {
        return new a(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f36028a == zVar.f36028a && this.f36029b == zVar.f36029b && this.f36030c == zVar.f36030c && this.f36031d == zVar.f36031d && this.f36032e == zVar.f36032e && this.f36033f == zVar.f36033f && this.f36034g == zVar.f36034g && this.f36035h == zVar.f36035h && this.f36038k == zVar.f36038k && this.f36036i == zVar.f36036i && this.f36037j == zVar.f36037j && this.f36039l.equals(zVar.f36039l) && this.f36040m == zVar.f36040m && this.f36041n.equals(zVar.f36041n) && this.f36042o == zVar.f36042o && this.f36043p == zVar.f36043p && this.f36044q == zVar.f36044q && this.f36045r.equals(zVar.f36045r) && this.f36046s.equals(zVar.f36046s) && this.f36047t == zVar.f36047t && this.f36048u == zVar.f36048u && this.f36049v == zVar.f36049v && this.f36050w == zVar.f36050w && this.f36051x == zVar.f36051x && this.f36052y.equals(zVar.f36052y) && this.f36053z.equals(zVar.f36053z);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.f36028a + 31) * 31) + this.f36029b) * 31) + this.f36030c) * 31) + this.f36031d) * 31) + this.f36032e) * 31) + this.f36033f) * 31) + this.f36034g) * 31) + this.f36035h) * 31) + (this.f36038k ? 1 : 0)) * 31) + this.f36036i) * 31) + this.f36037j) * 31) + this.f36039l.hashCode()) * 31) + this.f36040m) * 31) + this.f36041n.hashCode()) * 31) + this.f36042o) * 31) + this.f36043p) * 31) + this.f36044q) * 31) + this.f36045r.hashCode()) * 31) + this.f36046s.hashCode()) * 31) + this.f36047t) * 31) + this.f36048u) * 31) + (this.f36049v ? 1 : 0)) * 31) + (this.f36050w ? 1 : 0)) * 31) + (this.f36051x ? 1 : 0)) * 31) + this.f36052y.hashCode()) * 31) + this.f36053z.hashCode();
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(6), this.f36028a);
        bundle.putInt(c(7), this.f36029b);
        bundle.putInt(c(8), this.f36030c);
        bundle.putInt(c(9), this.f36031d);
        bundle.putInt(c(10), this.f36032e);
        bundle.putInt(c(11), this.f36033f);
        bundle.putInt(c(12), this.f36034g);
        bundle.putInt(c(13), this.f36035h);
        bundle.putInt(c(14), this.f36036i);
        bundle.putInt(c(15), this.f36037j);
        bundle.putBoolean(c(16), this.f36038k);
        bundle.putStringArray(c(17), (String[]) this.f36039l.toArray(new String[0]));
        bundle.putInt(c(25), this.f36040m);
        bundle.putStringArray(c(1), (String[]) this.f36041n.toArray(new String[0]));
        bundle.putInt(c(2), this.f36042o);
        bundle.putInt(c(18), this.f36043p);
        bundle.putInt(c(19), this.f36044q);
        bundle.putStringArray(c(20), (String[]) this.f36045r.toArray(new String[0]));
        bundle.putStringArray(c(3), (String[]) this.f36046s.toArray(new String[0]));
        bundle.putInt(c(4), this.f36047t);
        bundle.putInt(c(26), this.f36048u);
        bundle.putBoolean(c(5), this.f36049v);
        bundle.putBoolean(c(21), this.f36050w);
        bundle.putBoolean(c(22), this.f36051x);
        bundle.putParcelableArrayList(c(23), a4.c.d(this.f36052y.values()));
        bundle.putIntArray(c(24), g5.e.k(this.f36053z));
        return bundle;
    }

    /* JADX INFO: compiled from: TrackSelectionParameters.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f36057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f36059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f36060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f36061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f36062i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f36063j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f36064k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private com.google.common.collect.y<String> f36065l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f36066m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private com.google.common.collect.y<String> f36067n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f36068o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f36069p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f36070q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private com.google.common.collect.y<String> f36071r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private com.google.common.collect.y<String> f36072s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f36073t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f36074u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private boolean f36075v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private boolean f36076w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private boolean f36077x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private HashMap<c1, x> f36078y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private HashSet<Integer> f36079z;

        @Deprecated
        public a() {
            this.f36054a = Integer.MAX_VALUE;
            this.f36055b = Integer.MAX_VALUE;
            this.f36056c = Integer.MAX_VALUE;
            this.f36057d = Integer.MAX_VALUE;
            this.f36062i = Integer.MAX_VALUE;
            this.f36063j = Integer.MAX_VALUE;
            this.f36064k = true;
            this.f36065l = com.google.common.collect.y.q();
            this.f36066m = 0;
            this.f36067n = com.google.common.collect.y.q();
            this.f36068o = 0;
            this.f36069p = Integer.MAX_VALUE;
            this.f36070q = Integer.MAX_VALUE;
            this.f36071r = com.google.common.collect.y.q();
            this.f36072s = com.google.common.collect.y.q();
            this.f36073t = 0;
            this.f36074u = 0;
            this.f36075v = false;
            this.f36076w = false;
            this.f36077x = false;
            this.f36078y = new HashMap<>();
            this.f36079z = new HashSet<>();
        }

        private void C(z zVar) {
            this.f36054a = zVar.f36028a;
            this.f36055b = zVar.f36029b;
            this.f36056c = zVar.f36030c;
            this.f36057d = zVar.f36031d;
            this.f36058e = zVar.f36032e;
            this.f36059f = zVar.f36033f;
            this.f36060g = zVar.f36034g;
            this.f36061h = zVar.f36035h;
            this.f36062i = zVar.f36036i;
            this.f36063j = zVar.f36037j;
            this.f36064k = zVar.f36038k;
            this.f36065l = zVar.f36039l;
            this.f36066m = zVar.f36040m;
            this.f36067n = zVar.f36041n;
            this.f36068o = zVar.f36042o;
            this.f36069p = zVar.f36043p;
            this.f36070q = zVar.f36044q;
            this.f36071r = zVar.f36045r;
            this.f36072s = zVar.f36046s;
            this.f36073t = zVar.f36047t;
            this.f36074u = zVar.f36048u;
            this.f36075v = zVar.f36049v;
            this.f36076w = zVar.f36050w;
            this.f36077x = zVar.f36051x;
            this.f36079z = new HashSet<>(zVar.f36053z);
            this.f36078y = new HashMap<>(zVar.f36052y);
        }

        private static com.google.common.collect.y<String> D(String[] strArr) {
            y.a aVarK = com.google.common.collect.y.k();
            for (String str : (String[]) a4.a.e(strArr)) {
                aVarK.a(o0.y0((String) a4.a.e(str)));
            }
            return aVarK.k();
        }

        @RequiresApi(19)
        private void I(Context context) {
            CaptioningManager captioningManager;
            if ((o0.f214a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f36073t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f36072s = com.google.common.collect.y.r(o0.S(locale));
                }
            }
        }

        public z A() {
            return new z(this);
        }

        public a B(int i10) {
            Iterator<x> it = this.f36078y.values().iterator();
            while (it.hasNext()) {
                if (it.next().b() == i10) {
                    it.remove();
                }
            }
            return this;
        }

        protected a E(z zVar) {
            C(zVar);
            return this;
        }

        public a F(int i10) {
            this.f36074u = i10;
            return this;
        }

        public a G(x xVar) {
            B(xVar.b());
            this.f36078y.put(xVar.f36026a, xVar);
            return this;
        }

        public a H(Context context) {
            if (o0.f214a >= 19) {
                I(context);
            }
            return this;
        }

        public a J(int i10, boolean z10) {
            if (z10) {
                this.f36079z.add(Integer.valueOf(i10));
            } else {
                this.f36079z.remove(Integer.valueOf(i10));
            }
            return this;
        }

        public a K(int i10, int i11, boolean z10) {
            this.f36062i = i10;
            this.f36063j = i11;
            this.f36064k = z10;
            return this;
        }

        public a L(Context context, boolean z10) {
            Point pointI = o0.I(context);
            return K(pointI.x, pointI.y, z10);
        }

        public a(Context context) {
            this();
            H(context);
            L(context, true);
        }

        protected a(z zVar) {
            C(zVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected a(Bundle bundle) {
            com.google.common.collect.y yVarB;
            String strC = z.c(6);
            z zVar = z.A;
            this.f36054a = bundle.getInt(strC, zVar.f36028a);
            this.f36055b = bundle.getInt(z.c(7), zVar.f36029b);
            this.f36056c = bundle.getInt(z.c(8), zVar.f36030c);
            this.f36057d = bundle.getInt(z.c(9), zVar.f36031d);
            this.f36058e = bundle.getInt(z.c(10), zVar.f36032e);
            this.f36059f = bundle.getInt(z.c(11), zVar.f36033f);
            this.f36060g = bundle.getInt(z.c(12), zVar.f36034g);
            this.f36061h = bundle.getInt(z.c(13), zVar.f36035h);
            this.f36062i = bundle.getInt(z.c(14), zVar.f36036i);
            this.f36063j = bundle.getInt(z.c(15), zVar.f36037j);
            this.f36064k = bundle.getBoolean(z.c(16), zVar.f36038k);
            this.f36065l = com.google.common.collect.y.n((String[]) e5.i.a(bundle.getStringArray(z.c(17)), new String[0]));
            this.f36066m = bundle.getInt(z.c(25), zVar.f36040m);
            this.f36067n = D((String[]) e5.i.a(bundle.getStringArray(z.c(1)), new String[0]));
            this.f36068o = bundle.getInt(z.c(2), zVar.f36042o);
            this.f36069p = bundle.getInt(z.c(18), zVar.f36043p);
            this.f36070q = bundle.getInt(z.c(19), zVar.f36044q);
            this.f36071r = com.google.common.collect.y.n((String[]) e5.i.a(bundle.getStringArray(z.c(20)), new String[0]));
            this.f36072s = D((String[]) e5.i.a(bundle.getStringArray(z.c(3)), new String[0]));
            this.f36073t = bundle.getInt(z.c(4), zVar.f36047t);
            this.f36074u = bundle.getInt(z.c(26), zVar.f36048u);
            this.f36075v = bundle.getBoolean(z.c(5), zVar.f36049v);
            this.f36076w = bundle.getBoolean(z.c(21), zVar.f36050w);
            this.f36077x = bundle.getBoolean(z.c(22), zVar.f36051x);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(z.c(23));
            if (parcelableArrayList == null) {
                yVarB = com.google.common.collect.y.q();
            } else {
                yVarB = a4.c.b(x.f36025c, parcelableArrayList);
            }
            this.f36078y = new HashMap<>();
            for (int i10 = 0; i10 < yVarB.size(); i10++) {
                x xVar = (x) yVarB.get(i10);
                this.f36078y.put(xVar.f36026a, xVar);
            }
            int[] iArr = (int[]) e5.i.a(bundle.getIntArray(z.c(24)), new int[0]);
            this.f36079z = new HashSet<>();
            for (int i11 : iArr) {
                this.f36079z.add(Integer.valueOf(i11));
            }
        }
    }
}
