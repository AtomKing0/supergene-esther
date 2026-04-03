package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes3.dex */
class c<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f8766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8768c;

    public c() {
        this.f8767b = 0;
        this.f8768c = 0;
    }

    public int e() {
        d dVar = this.f8766a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    protected void f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        coordinatorLayout.onLayoutChild(v10, i10);
    }

    public boolean g(int i10) {
        d dVar = this.f8766a;
        if (dVar != null) {
            return dVar.e(i10);
        }
        this.f8767b = i10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        f(coordinatorLayout, v10, i10);
        if (this.f8766a == null) {
            this.f8766a = new d(v10);
        }
        this.f8766a.c();
        this.f8766a.a();
        int i11 = this.f8767b;
        if (i11 != 0) {
            this.f8766a.e(i11);
            this.f8767b = 0;
        }
        int i12 = this.f8768c;
        if (i12 == 0) {
            return true;
        }
        this.f8766a.d(i12);
        this.f8768c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8767b = 0;
        this.f8768c = 0;
    }
}
