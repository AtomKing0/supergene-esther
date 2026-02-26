package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: RightSheetDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SideSheetBehavior<? extends View> f9580a;

    b(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f9580a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    float b(int i10) {
        float fE = e();
        return (fE - i10) / (fE - d());
    }

    @Override // com.google.android.material.sidesheet.d
    int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    int d() {
        return Math.max(0, (e() - this.f9580a.z()) - this.f9580a.G());
    }

    @Override // com.google.android.material.sidesheet.d
    int e() {
        return this.f9580a.J();
    }

    @Override // com.google.android.material.sidesheet.d
    int f() {
        return this.f9580a.J();
    }

    @Override // com.google.android.material.sidesheet.d
    int g() {
        return d();
    }

    @Override // com.google.android.material.sidesheet.d
    <V extends View> int h(@NonNull V v10) {
        return v10.getLeft() - this.f9580a.G();
    }

    @Override // com.google.android.material.sidesheet.d
    public int i(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.d
    int j() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean k(float f10) {
        return f10 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean l(@NonNull View view) {
        return view.getLeft() > (e() + d()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean m(float f10, float f11) {
        return e.a(f10, f11) && Math.abs(f10) > ((float) this.f9580a.K());
    }

    @Override // com.google.android.material.sidesheet.d
    boolean n(@NonNull View view, float f10) {
        return Math.abs(((float) view.getRight()) + (f10 * this.f9580a.E())) > this.f9580a.F();
    }

    @Override // com.google.android.material.sidesheet.d
    void o(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.rightMargin = i10;
    }

    @Override // com.google.android.material.sidesheet.d
    void p(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int iJ = this.f9580a.J();
        if (i10 <= iJ) {
            marginLayoutParams.rightMargin = iJ - i10;
        }
    }
}
