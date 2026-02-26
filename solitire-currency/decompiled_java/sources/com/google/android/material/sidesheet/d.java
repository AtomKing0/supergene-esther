package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: SheetDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class d {
    d() {
    }

    abstract int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract float b(int i10);

    abstract int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract int d();

    abstract int e();

    abstract int f();

    abstract int g();

    abstract <V extends View> int h(@NonNull V v10);

    abstract int i(@NonNull CoordinatorLayout coordinatorLayout);

    abstract int j();

    abstract boolean k(float f10);

    abstract boolean l(@NonNull View view);

    abstract boolean m(float f10, float f11);

    abstract boolean n(@NonNull View view, float f10);

    abstract void o(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10);

    abstract void p(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11);
}
