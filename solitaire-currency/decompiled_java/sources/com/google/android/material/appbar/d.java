package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f8769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8774f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8775g = true;

    public d(View view) {
        this.f8769a = view;
    }

    void a() {
        View view = this.f8769a;
        ViewCompat.offsetTopAndBottom(view, this.f8772d - (view.getTop() - this.f8770b));
        View view2 = this.f8769a;
        ViewCompat.offsetLeftAndRight(view2, this.f8773e - (view2.getLeft() - this.f8771c));
    }

    public int b() {
        return this.f8772d;
    }

    void c() {
        this.f8770b = this.f8769a.getTop();
        this.f8771c = this.f8769a.getLeft();
    }

    public boolean d(int i10) {
        if (!this.f8775g || this.f8773e == i10) {
            return false;
        }
        this.f8773e = i10;
        a();
        return true;
    }

    public boolean e(int i10) {
        if (!this.f8774f || this.f8772d == i10) {
            return false;
        }
        this.f8772d = i10;
        a();
        return true;
    }
}
