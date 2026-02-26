package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: MultiBrowseCarouselStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f9076d = {1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f9077e = {1, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9078c = 0;

    @Override // com.google.android.material.carousel.d
    @NonNull
    f g(@NonNull b bVar, @NonNull View view) {
        float fB = bVar.b();
        if (bVar.d()) {
            fB = bVar.a();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.d()) {
            f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f11 = f10;
        float fD = d() + f11;
        float fMax = Math.max(c() + f11, fD);
        float fMin = Math.min(measuredHeight + f11, fB);
        float fClamp = MathUtils.clamp((measuredHeight / 3.0f) + f11, fD + f11, fMax + f11);
        float f12 = (fMin + fClamp) / 2.0f;
        int[] iArrA = f9076d;
        if (fB < 2.0f * fD) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = f9077e;
        if (bVar.c() == 1) {
            iArrA = d.a(iArrA);
            iArrA2 = d.a(iArrA2);
        }
        int[] iArr = iArrA;
        int[] iArr2 = iArrA2;
        int iMax = (int) Math.max(1.0d, Math.floor(((fB - (e.i(iArr2) * f12)) - (e.i(iArr) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(fB / fMin);
        int i10 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr3[i11] = iCeil - i11;
        }
        a aVarC = a.c(fB, fClamp, fD, fMax, iArr, f12, iArr2, fMin, iArr3);
        this.f9078c = aVarC.e();
        if (i(aVarC, bVar.getItemCount())) {
            aVarC = a.c(fB, fClamp, fD, fMax, new int[]{aVarC.f9037c}, f12, new int[]{aVarC.f9038d}, fMin, new int[]{aVarC.f9041g});
        }
        return e.d(view.getContext(), f11, fB, aVarC, bVar.c());
    }

    @Override // com.google.android.material.carousel.d
    boolean h(b bVar, int i10) {
        return (i10 < this.f9078c && bVar.getItemCount() >= this.f9078c) || (i10 >= this.f9078c && bVar.getItemCount() < this.f9078c);
    }

    boolean i(a aVar, int i10) {
        int iE = aVar.e() - i10;
        boolean z10 = iE > 0 && (aVar.f9037c > 0 || aVar.f9038d > 1);
        while (iE > 0) {
            int i11 = aVar.f9037c;
            if (i11 > 0) {
                aVar.f9037c = i11 - 1;
            } else {
                int i12 = aVar.f9038d;
                if (i12 > 1) {
                    aVar.f9038d = i12 - 1;
                }
            }
            iE--;
        }
        return z10;
    }
}
