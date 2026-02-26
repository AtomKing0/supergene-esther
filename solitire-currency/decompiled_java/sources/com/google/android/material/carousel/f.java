package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: KeylineState.java */
/* JADX INFO: loaded from: classes3.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f9048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f9049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9051d;

    /* JADX INFO: compiled from: KeylineState.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f9052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f9053b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f9055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f9056e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<c> f9054c = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9057f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f9058g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f9059h = 0.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9060i = -1;

        b(float f10, float f11) {
            this.f9052a = f10;
            this.f9053b = f11;
        }

        private static float j(float f10, float f11, int i10, int i11) {
            return (f10 - (i10 * f11)) + (i11 * f11);
        }

        @NonNull
        b a(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12) {
            return d(f10, f11, f12, false, true);
        }

        @NonNull
        b b(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12) {
            return c(f10, f11, f12, false);
        }

        @NonNull
        b c(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, boolean z10) {
            return d(f10, f11, f12, z10, false);
        }

        @NonNull
        b d(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, boolean z10, boolean z11) {
            float fAbs;
            float f13 = f12 / 2.0f;
            float f14 = f10 - f13;
            float f15 = f13 + f10;
            float f16 = this.f9053b;
            if (f15 > f16) {
                fAbs = Math.abs(f15 - Math.max(f15 - f12, f16));
            } else {
                fAbs = 0.0f;
                if (f14 < 0.0f) {
                    fAbs = Math.abs(f14 - Math.min(f14 + f12, 0.0f));
                }
            }
            return e(f10, f11, f12, z10, z11, fAbs);
        }

        @NonNull
        b e(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, boolean z10, boolean z11, float f13) {
            return f(f10, f11, f12, z10, z11, f13, 0.0f, 0.0f);
        }

        @NonNull
        b f(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, boolean z10, boolean z11, float f13, float f14, float f15) {
            if (f12 <= 0.0f) {
                return this;
            }
            if (z11) {
                if (z10) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i10 = this.f9060i;
                if (i10 != -1 && i10 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f9060i = this.f9054c.size();
            }
            c cVar = new c(Float.MIN_VALUE, f10, f11, f12, z11, f13, f14, f15);
            if (z10) {
                if (this.f9055d == null) {
                    this.f9055d = cVar;
                    this.f9057f = this.f9054c.size();
                }
                if (this.f9058g != -1 && this.f9054c.size() - this.f9058g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f12 != this.f9055d.f9064d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f9056e = cVar;
                this.f9058g = this.f9054c.size();
            } else {
                if (this.f9055d == null && cVar.f9064d < this.f9059h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f9056e != null && cVar.f9064d > this.f9059h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f9059h = cVar.f9064d;
            this.f9054c.add(cVar);
            return this;
        }

        @NonNull
        b g(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, int i10) {
            return h(f10, f11, f12, i10, false);
        }

        @NonNull
        b h(float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, int i10, boolean z10) {
            if (i10 > 0 && f12 > 0.0f) {
                for (int i11 = 0; i11 < i10; i11++) {
                    c((i11 * f12) + f10, f11, f12, z10);
                }
            }
            return this;
        }

        @NonNull
        f i() {
            if (this.f9055d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.f9054c.size(); i10++) {
                c cVar = this.f9054c.get(i10);
                arrayList.add(new c(j(this.f9055d.f9062b, this.f9052a, this.f9057f, i10), cVar.f9062b, cVar.f9063c, cVar.f9064d, cVar.f9065e, cVar.f9066f, cVar.f9067g, cVar.f9068h));
            }
            return new f(this.f9052a, arrayList, this.f9057f, this.f9058g);
        }
    }

    /* JADX INFO: compiled from: KeylineState.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f9061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f9062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f9063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f9064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f9065e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final float f9066f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final float f9067g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final float f9068h;

        c(float f10, float f11, float f12, float f13) {
            this(f10, f11, f12, f13, false, 0.0f, 0.0f, 0.0f);
        }

        static c a(c cVar, c cVar2, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
            return new c(f4.a.a(cVar.f9061a, cVar2.f9061a, f10), f4.a.a(cVar.f9062b, cVar2.f9062b, f10), f4.a.a(cVar.f9063c, cVar2.f9063c, f10), f4.a.a(cVar.f9064d, cVar2.f9064d, f10));
        }

        c(float f10, float f11, float f12, float f13, boolean z10, float f14, float f15, float f16) {
            this.f9061a = f10;
            this.f9062b = f11;
            this.f9063c = f12;
            this.f9064d = f13;
            this.f9065e = z10;
            this.f9066f = f14;
            this.f9067g = f15;
            this.f9068h = f16;
        }
    }

    static f m(f fVar, f fVar2, float f10) {
        if (fVar.f() != fVar2.f()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<c> listG = fVar.g();
        List<c> listG2 = fVar2.g();
        if (listG.size() != listG2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < fVar.g().size(); i10++) {
            arrayList.add(c.a(listG.get(i10), listG2.get(i10), f10));
        }
        return new f(fVar.f(), arrayList, f4.a.c(fVar.b(), fVar2.b(), f10), f4.a.c(fVar.i(), fVar2.i(), f10));
    }

    static f n(f fVar, float f10) {
        b bVar = new b(fVar.f(), f10);
        float f11 = (f10 - fVar.j().f9062b) - (fVar.j().f9064d / 2.0f);
        int size = fVar.g().size() - 1;
        while (size >= 0) {
            c cVar = fVar.g().get(size);
            bVar.d(f11 + (cVar.f9064d / 2.0f), cVar.f9063c, cVar.f9064d, size >= fVar.b() && size <= fVar.i(), cVar.f9065e);
            f11 += cVar.f9064d;
            size--;
        }
        return bVar.i();
    }

    c a() {
        return this.f9049b.get(this.f9050c);
    }

    int b() {
        return this.f9050c;
    }

    c c() {
        return this.f9049b.get(0);
    }

    @Nullable
    c d() {
        for (int i10 = 0; i10 < this.f9049b.size(); i10++) {
            c cVar = this.f9049b.get(i10);
            if (!cVar.f9065e) {
                return cVar;
            }
        }
        return null;
    }

    List<c> e() {
        return this.f9049b.subList(this.f9050c, this.f9051d + 1);
    }

    float f() {
        return this.f9048a;
    }

    List<c> g() {
        return this.f9049b;
    }

    c h() {
        return this.f9049b.get(this.f9051d);
    }

    int i() {
        return this.f9051d;
    }

    c j() {
        return this.f9049b.get(r0.size() - 1);
    }

    @Nullable
    c k() {
        for (int size = this.f9049b.size() - 1; size >= 0; size--) {
            c cVar = this.f9049b.get(size);
            if (!cVar.f9065e) {
                return cVar;
            }
        }
        return null;
    }

    int l() {
        Iterator<c> it = this.f9049b.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().f9065e) {
                i10++;
            }
        }
        return this.f9049b.size() - i10;
    }

    private f(float f10, List<c> list, int i10, int i11) {
        this.f9048a = f10;
        this.f9049b = Collections.unmodifiableList(list);
        this.f9050c = i10;
        this.f9051d = i11;
    }
}
