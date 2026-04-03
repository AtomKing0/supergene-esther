package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9919a;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ q4.a f9922c;

        a(View view, int i10, q4.a aVar) {
            this.f9920a = view;
            this.f9921b = i10;
            this.f9922c = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f9920a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f9919a == this.f9921b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                q4.a aVar = this.f9922c;
                expandableBehavior.h((View) aVar, this.f9920a, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f9919a = 0;
    }

    private boolean f(boolean z10) {
        if (!z10) {
            return this.f9919a == 1;
        }
        int i10 = this.f9919a;
        return i10 == 0 || i10 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected q4.a g(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = dependencies.get(i10);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (q4.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean h(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        q4.a aVar = (q4.a) view2;
        if (!f(aVar.a())) {
            return false;
        }
        this.f9919a = aVar.a() ? 1 : 2;
        return h((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10) {
        q4.a aVarG;
        if (ViewCompat.isLaidOut(view) || (aVarG = g(coordinatorLayout, view)) == null || !f(aVarG.a())) {
            return false;
        }
        int i11 = aVarG.a() ? 1 : 2;
        this.f9919a = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, aVarG));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9919a = 0;
    }
}
