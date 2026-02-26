package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import com.google.android.material.carousel.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: KeylineStateList.java */
/* JADX INFO: loaded from: classes3.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f9069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<f> f9070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f> f9071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f9072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f9073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f9074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f9075g;

    private g(@NonNull f fVar, List<f> list, List<f> list2) {
        this.f9069a = fVar;
        this.f9070b = Collections.unmodifiableList(list);
        this.f9071c = Collections.unmodifiableList(list2);
        float f10 = list.get(list.size() - 1).c().f9061a - fVar.c().f9061a;
        this.f9074f = f10;
        float f11 = fVar.j().f9061a - list2.get(list2.size() - 1).j().f9061a;
        this.f9075g = f11;
        this.f9072d = m(f10, list, true);
        this.f9073e = m(f11, list2, false);
    }

    private f a(List<f> list, float f10, float[] fArr) {
        float[] fArrO = o(list, f10, fArr);
        return fArrO[0] >= 0.5f ? list.get((int) fArrO[2]) : list.get((int) fArrO[1]);
    }

    private static int b(f fVar, float f10) {
        for (int i10 = fVar.i(); i10 < fVar.g().size(); i10++) {
            if (f10 == fVar.g().get(i10).f9063c) {
                return i10;
            }
        }
        return fVar.g().size() - 1;
    }

    private static int c(f fVar) {
        for (int i10 = 0; i10 < fVar.g().size(); i10++) {
            if (!fVar.g().get(i10).f9065e) {
                return i10;
            }
        }
        return -1;
    }

    private static int d(f fVar, float f10) {
        for (int iB = fVar.b() - 1; iB >= 0; iB--) {
            if (f10 == fVar.g().get(iB).f9063c) {
                return iB;
            }
        }
        return 0;
    }

    private static int e(f fVar) {
        for (int size = fVar.g().size() - 1; size >= 0; size--) {
            if (!fVar.g().get(size).f9065e) {
                return size;
            }
        }
        return -1;
    }

    static g f(b bVar, f fVar, float f10, float f11, float f12) {
        return new g(fVar, p(bVar, fVar, f10, f11), n(bVar, fVar, f10, f12));
    }

    private static float[] m(float f10, List<f> list, boolean z10) {
        int size = list.size();
        float[] fArr = new float[size];
        int i10 = 1;
        while (i10 < size) {
            int i11 = i10 - 1;
            f fVar = list.get(i11);
            f fVar2 = list.get(i10);
            fArr[i10] = i10 == size + (-1) ? 1.0f : fArr[i11] + ((z10 ? fVar2.c().f9061a - fVar.c().f9061a : fVar.j().f9061a - fVar2.j().f9061a) / f10);
            i10++;
        }
        return fArr;
    }

    private static List<f> n(b bVar, f fVar, float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        int iE = e(fVar);
        float fA = bVar.d() ? bVar.a() : bVar.b();
        if (r(bVar, fVar) || iE == -1) {
            if (f11 > 0.0f) {
                arrayList.add(u(fVar, f11, fA, false, f10));
            }
            return arrayList;
        }
        int i10 = iE - fVar.i();
        float f12 = fVar.c().f9062b - (fVar.c().f9064d / 2.0f);
        if (i10 <= 0 && fVar.h().f9066f > 0.0f) {
            arrayList.add(v(fVar, f12 - fVar.h().f9066f, fA));
            return arrayList;
        }
        float f13 = 0.0f;
        int i11 = 0;
        while (i11 < i10) {
            f fVar2 = (f) arrayList.get(arrayList.size() - 1);
            int i12 = iE - i11;
            float f14 = f13 + fVar.g().get(i12).f9066f;
            int i13 = i12 + 1;
            int i14 = i11;
            f fVarT = t(fVar2, iE, i13 < fVar.g().size() ? d(fVar2, fVar.g().get(i13).f9063c) + 1 : 0, f12 - f14, fVar.b() + i11 + 1, fVar.i() + i11 + 1, fA);
            if (i14 == i10 - 1 && f11 > 0.0f) {
                fVarT = u(fVarT, f11, fA, false, f10);
            }
            arrayList.add(fVarT);
            i11 = i14 + 1;
            f13 = f14;
        }
        return arrayList;
    }

    private static float[] o(List<f> list, float f10, float[] fArr) {
        int size = list.size();
        float f11 = fArr[0];
        int i10 = 1;
        while (i10 < size) {
            float f12 = fArr[i10];
            if (f10 <= f12) {
                return new float[]{f4.a.b(0.0f, 1.0f, f11, f12, f10), i10 - 1, i10};
            }
            i10++;
            f11 = f12;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<f> p(b bVar, f fVar, float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        int iC = c(fVar);
        float fA = bVar.d() ? bVar.a() : bVar.b();
        int i10 = 1;
        if (q(fVar) || iC == -1) {
            if (f11 > 0.0f) {
                arrayList.add(u(fVar, f11, fA, true, f10));
            }
            return arrayList;
        }
        int iB = fVar.b() - iC;
        float f12 = fVar.c().f9062b - (fVar.c().f9064d / 2.0f);
        if (iB <= 0 && fVar.a().f9066f > 0.0f) {
            arrayList.add(v(fVar, f12 + fVar.a().f9066f, fA));
            return arrayList;
        }
        int i11 = 0;
        float f13 = 0.0f;
        while (i11 < iB) {
            f fVar2 = (f) arrayList.get(arrayList.size() - i10);
            int i12 = iC + i11;
            int size = fVar.g().size() - i10;
            float f14 = f13 + fVar.g().get(i12).f9066f;
            int i13 = i12 - i10;
            int iB2 = i13 >= 0 ? b(fVar2, fVar.g().get(i13).f9063c) - i10 : size;
            int i14 = i11;
            f fVarT = t(fVar2, iC, iB2, f12 + f14, (fVar.b() - i11) - 1, (fVar.i() - i11) - 1, fA);
            if (i14 == iB - 1 && f11 > 0.0f) {
                fVarT = u(fVarT, f11, fA, true, f10);
            }
            arrayList.add(fVarT);
            i11 = i14 + 1;
            f13 = f14;
            i10 = 1;
        }
        return arrayList;
    }

    private static boolean q(f fVar) {
        return fVar.a().f9062b - (fVar.a().f9064d / 2.0f) >= 0.0f && fVar.a() == fVar.d();
    }

    private static boolean r(b bVar, f fVar) {
        int iB = bVar.b();
        if (bVar.d()) {
            iB = bVar.a();
        }
        return fVar.h().f9062b + (fVar.h().f9064d / 2.0f) <= ((float) iB) && fVar.h() == fVar.k();
    }

    private static f s(List<f> list, float f10, float[] fArr) {
        float[] fArrO = o(list, f10, fArr);
        return f.m(list.get((int) fArrO[1]), list.get((int) fArrO[2]), fArrO[0]);
    }

    private static f t(f fVar, int i10, int i11, float f10, int i12, int i13, float f11) {
        ArrayList arrayList = new ArrayList(fVar.g());
        arrayList.add(i11, (f.c) arrayList.remove(i10));
        f.b bVar = new f.b(fVar.f(), f11);
        int i14 = 0;
        while (i14 < arrayList.size()) {
            f.c cVar = (f.c) arrayList.get(i14);
            float f12 = cVar.f9064d;
            bVar.e(f10 + (f12 / 2.0f), cVar.f9063c, f12, i14 >= i12 && i14 <= i13, cVar.f9065e, cVar.f9066f);
            f10 += cVar.f9064d;
            i14++;
        }
        return bVar.i();
    }

    private static f u(f fVar, float f10, float f11, boolean z10, float f12) {
        ArrayList arrayList = new ArrayList(fVar.g());
        f.b bVar = new f.b(fVar.f(), f11);
        float fL = f10 / fVar.l();
        float f13 = z10 ? f10 : 0.0f;
        int i10 = 0;
        while (i10 < arrayList.size()) {
            f.c cVar = (f.c) arrayList.get(i10);
            if (cVar.f9065e) {
                bVar.e(cVar.f9062b, cVar.f9063c, cVar.f9064d, false, true, cVar.f9066f);
            } else {
                boolean z11 = i10 >= fVar.b() && i10 <= fVar.i();
                float f14 = cVar.f9064d - fL;
                float fB = d.b(f14, fVar.f(), f12);
                float f15 = (f14 / 2.0f) + f13;
                float f16 = f15 - cVar.f9062b;
                bVar.f(f15, fB, f14, z11, false, cVar.f9066f, z10 ? f16 : 0.0f, z10 ? 0.0f : f16);
                f13 += f14;
            }
            i10++;
        }
        return bVar.i();
    }

    private static f v(f fVar, float f10, float f11) {
        return t(fVar, 0, 0, f10, fVar.b(), fVar.i(), f11);
    }

    f g() {
        return this.f9069a;
    }

    f h() {
        return this.f9071c.get(r0.size() - 1);
    }

    Map<Integer, f> i(int i10, int i11, int i12, boolean z10) {
        float f10 = this.f9069a.f();
        HashMap map = new HashMap();
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= i10) {
                break;
            }
            int i15 = z10 ? (i10 - i13) - 1 : i13;
            if (i15 * f10 * (z10 ? -1 : 1) > i12 - this.f9075g || i13 >= i10 - this.f9071c.size()) {
                Integer numValueOf = Integer.valueOf(i15);
                List<f> list = this.f9071c;
                map.put(numValueOf, list.get(MathUtils.clamp(i14, 0, list.size() - 1)));
                i14++;
            }
            i13++;
        }
        int i16 = 0;
        for (int i17 = i10 - 1; i17 >= 0; i17--) {
            int i18 = z10 ? (i10 - i17) - 1 : i17;
            if (i18 * f10 * (z10 ? -1 : 1) < i11 + this.f9074f || i17 < this.f9070b.size()) {
                Integer numValueOf2 = Integer.valueOf(i18);
                List<f> list2 = this.f9070b;
                map.put(numValueOf2, list2.get(MathUtils.clamp(i16, 0, list2.size() - 1)));
                i16++;
            }
        }
        return map;
    }

    public f j(float f10, float f11, float f12) {
        return k(f10, f11, f12, false);
    }

    f k(float f10, float f11, float f12, boolean z10) {
        float fB;
        List<f> list;
        float[] fArr;
        float f13 = this.f9074f + f11;
        float f14 = f12 - this.f9075g;
        float f15 = l().a().f9067g;
        float f16 = h().h().f9068h;
        if (this.f9074f == f15) {
            f13 += f15;
        }
        if (this.f9075g == f16) {
            f14 -= f16;
        }
        if (f10 < f13) {
            fB = f4.a.b(1.0f, 0.0f, f11, f13, f10);
            list = this.f9070b;
            fArr = this.f9072d;
        } else {
            if (f10 <= f14) {
                return this.f9069a;
            }
            fB = f4.a.b(0.0f, 1.0f, f14, f12, f10);
            list = this.f9071c;
            fArr = this.f9073e;
        }
        return z10 ? a(list, fB, fArr) : s(list, fB, fArr);
    }

    f l() {
        return this.f9070b.get(r0.size() - 1);
    }
}
