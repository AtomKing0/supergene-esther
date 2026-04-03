package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import s4.h;

/* JADX INFO: loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f8777j = e4.b.f24769z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f8778k = e4.b.C;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f8779l = e4.b.I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinkedHashSet<b> f8780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TimeInterpolator f8783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TimeInterpolator f8784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private ViewPropertyAnimator f8788i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f8788i = null;
        }
    }

    public interface b {
        void a(@NonNull View view, int i10);
    }

    public HideBottomViewOnScrollBehavior() {
        this.f8780a = new LinkedHashSet<>();
        this.f8785f = 0;
        this.f8786g = 2;
        this.f8787h = 0;
    }

    private void f(@NonNull V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f8788i = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    private void n(@NonNull V v10, int i10) {
        this.f8786g = i10;
        Iterator<b> it = this.f8780a.iterator();
        while (it.hasNext()) {
            it.next().a(v10, this.f8786g);
        }
    }

    public boolean g() {
        return this.f8786g == 1;
    }

    public boolean h() {
        return this.f8786g == 2;
    }

    public void i(@NonNull V v10, @Dimension int i10) {
        this.f8787h = i10;
        if (this.f8786g == 1) {
            v10.setTranslationY(this.f8785f + i10);
        }
    }

    public void j(@NonNull V v10) {
        k(v10, true);
    }

    public void k(@NonNull V v10, boolean z10) {
        if (g()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f8788i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        n(v10, 1);
        int i10 = this.f8785f + this.f8787h;
        if (z10) {
            f(v10, i10, this.f8782c, this.f8784e);
        } else {
            v10.setTranslationY(i10);
        }
    }

    public void l(@NonNull V v10) {
        m(v10, true);
    }

    public void m(@NonNull V v10, boolean z10) {
        if (h()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f8788i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        n(v10, 2);
        if (z10) {
            f(v10, 0, this.f8781b, this.f8783d);
        } else {
            v10.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        this.f8785f = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        this.f8781b = h.f(v10.getContext(), f8777j, 225);
        this.f8782c = h.f(v10.getContext(), f8778k, 175);
        Context context = v10.getContext();
        int i11 = f8779l;
        this.f8783d = h.g(context, i11, f4.a.f25671d);
        this.f8784e = h.g(v10.getContext(), i11, f4.a.f25670c);
        return super.onLayoutChild(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        if (i11 > 0) {
            j(v10);
        } else if (i11 < 0) {
            l(v10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
        return i10 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8780a = new LinkedHashSet<>();
        this.f8785f = 0;
        this.f8786g = 2;
        this.f8787h = 0;
    }
}
