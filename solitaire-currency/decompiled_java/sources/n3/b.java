package n3;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import k2.h;

/* JADX INFO: compiled from: Cue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements k2.h {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b f31621r = new C0631b().o("").a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final h.a<b> f31622s = new h.a() { // from class: n3.a
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return b.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f31623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f31624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f31625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Bitmap f31626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f31627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f31628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f31629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f31630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f31631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f31632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f31633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f31634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f31635m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f31636n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f31637o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f31638p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f31639q;

    /* JADX INFO: renamed from: n3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cue.java */
    public static final class C0631b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private CharSequence f31640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Bitmap f31641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Layout.Alignment f31642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Layout.Alignment f31643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f31644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f31645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f31646g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f31647h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f31648i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f31649j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f31650k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private float f31651l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private float f31652m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f31653n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @ColorInt
        private int f31654o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f31655p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f31656q;

        public b a() {
            return new b(this.f31640a, this.f31642c, this.f31643d, this.f31641b, this.f31644e, this.f31645f, this.f31646g, this.f31647h, this.f31648i, this.f31649j, this.f31650k, this.f31651l, this.f31652m, this.f31653n, this.f31654o, this.f31655p, this.f31656q);
        }

        public C0631b b() {
            this.f31653n = false;
            return this;
        }

        public int c() {
            return this.f31646g;
        }

        public int d() {
            return this.f31648i;
        }

        @Nullable
        public CharSequence e() {
            return this.f31640a;
        }

        public C0631b f(Bitmap bitmap) {
            this.f31641b = bitmap;
            return this;
        }

        public C0631b g(float f10) {
            this.f31652m = f10;
            return this;
        }

        public C0631b h(float f10, int i10) {
            this.f31644e = f10;
            this.f31645f = i10;
            return this;
        }

        public C0631b i(int i10) {
            this.f31646g = i10;
            return this;
        }

        public C0631b j(@Nullable Layout.Alignment alignment) {
            this.f31643d = alignment;
            return this;
        }

        public C0631b k(float f10) {
            this.f31647h = f10;
            return this;
        }

        public C0631b l(int i10) {
            this.f31648i = i10;
            return this;
        }

        public C0631b m(float f10) {
            this.f31656q = f10;
            return this;
        }

        public C0631b n(float f10) {
            this.f31651l = f10;
            return this;
        }

        public C0631b o(CharSequence charSequence) {
            this.f31640a = charSequence;
            return this;
        }

        public C0631b p(@Nullable Layout.Alignment alignment) {
            this.f31642c = alignment;
            return this;
        }

        public C0631b q(float f10, int i10) {
            this.f31650k = f10;
            this.f31649j = i10;
            return this;
        }

        public C0631b r(int i10) {
            this.f31655p = i10;
            return this;
        }

        public C0631b s(@ColorInt int i10) {
            this.f31654o = i10;
            this.f31653n = true;
            return this;
        }

        public C0631b() {
            this.f31640a = null;
            this.f31641b = null;
            this.f31642c = null;
            this.f31643d = null;
            this.f31644e = -3.4028235E38f;
            this.f31645f = Integer.MIN_VALUE;
            this.f31646g = Integer.MIN_VALUE;
            this.f31647h = -3.4028235E38f;
            this.f31648i = Integer.MIN_VALUE;
            this.f31649j = Integer.MIN_VALUE;
            this.f31650k = -3.4028235E38f;
            this.f31651l = -3.4028235E38f;
            this.f31652m = -3.4028235E38f;
            this.f31653n = false;
            this.f31654o = ViewCompat.MEASURED_STATE_MASK;
            this.f31655p = Integer.MIN_VALUE;
        }

        private C0631b(b bVar) {
            this.f31640a = bVar.f31623a;
            this.f31641b = bVar.f31626d;
            this.f31642c = bVar.f31624b;
            this.f31643d = bVar.f31625c;
            this.f31644e = bVar.f31627e;
            this.f31645f = bVar.f31628f;
            this.f31646g = bVar.f31629g;
            this.f31647h = bVar.f31630h;
            this.f31648i = bVar.f31631i;
            this.f31649j = bVar.f31636n;
            this.f31650k = bVar.f31637o;
            this.f31651l = bVar.f31632j;
            this.f31652m = bVar.f31633k;
            this.f31653n = bVar.f31634l;
            this.f31654o = bVar.f31635m;
            this.f31655p = bVar.f31638p;
            this.f31656q = bVar.f31639q;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b c(Bundle bundle) {
        C0631b c0631b = new C0631b();
        CharSequence charSequence = bundle.getCharSequence(d(0));
        if (charSequence != null) {
            c0631b.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(d(1));
        if (alignment != null) {
            c0631b.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(d(2));
        if (alignment2 != null) {
            c0631b.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(d(3));
        if (bitmap != null) {
            c0631b.f(bitmap);
        }
        if (bundle.containsKey(d(4)) && bundle.containsKey(d(5))) {
            c0631b.h(bundle.getFloat(d(4)), bundle.getInt(d(5)));
        }
        if (bundle.containsKey(d(6))) {
            c0631b.i(bundle.getInt(d(6)));
        }
        if (bundle.containsKey(d(7))) {
            c0631b.k(bundle.getFloat(d(7)));
        }
        if (bundle.containsKey(d(8))) {
            c0631b.l(bundle.getInt(d(8)));
        }
        if (bundle.containsKey(d(10)) && bundle.containsKey(d(9))) {
            c0631b.q(bundle.getFloat(d(10)), bundle.getInt(d(9)));
        }
        if (bundle.containsKey(d(11))) {
            c0631b.n(bundle.getFloat(d(11)));
        }
        if (bundle.containsKey(d(12))) {
            c0631b.g(bundle.getFloat(d(12)));
        }
        if (bundle.containsKey(d(13))) {
            c0631b.s(bundle.getInt(d(13)));
        }
        if (!bundle.getBoolean(d(14), false)) {
            c0631b.b();
        }
        if (bundle.containsKey(d(15))) {
            c0631b.r(bundle.getInt(d(15)));
        }
        if (bundle.containsKey(d(16))) {
            c0631b.m(bundle.getFloat(d(16)));
        }
        return c0631b.a();
    }

    private static String d(int i10) {
        return Integer.toString(i10, 36);
    }

    public C0631b b() {
        return new C0631b();
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.f31623a, bVar.f31623a) && this.f31624b == bVar.f31624b && this.f31625c == bVar.f31625c && ((bitmap = this.f31626d) != null ? !((bitmap2 = bVar.f31626d) == null || !bitmap.sameAs(bitmap2)) : bVar.f31626d == null) && this.f31627e == bVar.f31627e && this.f31628f == bVar.f31628f && this.f31629g == bVar.f31629g && this.f31630h == bVar.f31630h && this.f31631i == bVar.f31631i && this.f31632j == bVar.f31632j && this.f31633k == bVar.f31633k && this.f31634l == bVar.f31634l && this.f31635m == bVar.f31635m && this.f31636n == bVar.f31636n && this.f31637o == bVar.f31637o && this.f31638p == bVar.f31638p && this.f31639q == bVar.f31639q;
    }

    public int hashCode() {
        return e5.k.b(this.f31623a, this.f31624b, this.f31625c, this.f31626d, Float.valueOf(this.f31627e), Integer.valueOf(this.f31628f), Integer.valueOf(this.f31629g), Float.valueOf(this.f31630h), Integer.valueOf(this.f31631i), Float.valueOf(this.f31632j), Float.valueOf(this.f31633k), Boolean.valueOf(this.f31634l), Integer.valueOf(this.f31635m), Integer.valueOf(this.f31636n), Float.valueOf(this.f31637o), Integer.valueOf(this.f31638p), Float.valueOf(this.f31639q));
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.f31623a);
        bundle.putSerializable(d(1), this.f31624b);
        bundle.putSerializable(d(2), this.f31625c);
        bundle.putParcelable(d(3), this.f31626d);
        bundle.putFloat(d(4), this.f31627e);
        bundle.putInt(d(5), this.f31628f);
        bundle.putInt(d(6), this.f31629g);
        bundle.putFloat(d(7), this.f31630h);
        bundle.putInt(d(8), this.f31631i);
        bundle.putInt(d(9), this.f31636n);
        bundle.putFloat(d(10), this.f31637o);
        bundle.putFloat(d(11), this.f31632j);
        bundle.putFloat(d(12), this.f31633k);
        bundle.putBoolean(d(14), this.f31634l);
        bundle.putInt(d(13), this.f31635m);
        bundle.putInt(d(15), this.f31638p);
        bundle.putFloat(d(16), this.f31639q);
        return bundle;
    }

    private b(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f10, int i10, int i11, float f11, int i12, int i13, float f12, float f13, float f14, boolean z10, int i14, int i15, float f15) {
        if (charSequence == null) {
            a4.a.e(bitmap);
        } else {
            a4.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f31623a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f31623a = charSequence.toString();
        } else {
            this.f31623a = null;
        }
        this.f31624b = alignment;
        this.f31625c = alignment2;
        this.f31626d = bitmap;
        this.f31627e = f10;
        this.f31628f = i10;
        this.f31629g = i11;
        this.f31630h = f11;
        this.f31631i = i12;
        this.f31632j = f13;
        this.f31633k = f14;
        this.f31634l = z10;
        this.f31635m = i14;
        this.f31636n = i13;
        this.f31637o = f12;
        this.f31638p = i15;
        this.f31639q = f15;
    }
}
