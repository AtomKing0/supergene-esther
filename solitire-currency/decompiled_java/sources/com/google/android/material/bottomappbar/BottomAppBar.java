package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.animation.core.AnimationConstants;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.s;
import e4.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f8808w = j.f24906l;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f8809x = e4.b.f24769z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f8810y = e4.b.I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Integer f8811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x4.g f8812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Animator f8813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Animator f8814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Px
    private int f8819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f8821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<g> f8824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @MenuRes
    private int f8825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Behavior f8828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8829s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8830t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f8831u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    AnimatorListenerAdapter f8832v;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.A();
            BottomAppBar.this.f8813c = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.B();
        }
    }

    class b extends FloatingActionButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8839a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.A();
            }
        }

        b(int i10) {
            this.f8839a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.F(this.f8839a));
            floatingActionButton.s(new a());
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.A();
            BottomAppBar.this.f8826p = false;
            BottomAppBar.this.f8814d = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.B();
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f8844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f8846d;

        d(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f8844b = actionMenuView;
            this.f8845c = i10;
            this.f8846d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8843a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f8843a) {
                return;
            }
            boolean z10 = BottomAppBar.this.f8825o != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.L(bottomAppBar.f8825o);
            BottomAppBar.this.R(this.f8844b, this.f8845c, this.f8846d, z10);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f8848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8850c;

        e(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f8848a = actionMenuView;
            this.f8849b = i10;
            this.f8850c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8848a.setTranslationX(BottomAppBar.this.E(r0, this.f8849b, this.f8850c));
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f8832v.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonC = BottomAppBar.this.C();
            if (floatingActionButtonC != null) {
                floatingActionButtonC.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    interface g {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    static class h extends AbsSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f8854b;

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(@NonNull Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i10) {
                return new h[i10];
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8853a);
            parcel.writeInt(this.f8854b ? 1 : 0);
        }

        public h(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8853a = parcel.readInt();
            this.f8854b = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        ArrayList<g> arrayList;
        int i10 = this.f8823m - 1;
        this.f8823m = i10;
        if (i10 != 0 || (arrayList = this.f8824n) == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ArrayList<g> arrayList;
        int i10 = this.f8823m;
        this.f8823m = i10 + 1;
        if (i10 != 0 || (arrayList = this.f8824n) == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FloatingActionButton C() {
        View viewD = D();
        if (viewD instanceof FloatingActionButton) {
            return (FloatingActionButton) viewD;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public View D() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float F(int i10) {
        boolean zG = s.g(this);
        if (i10 != 1) {
            return 0.0f;
        }
        return ((getMeasuredWidth() / 2) - ((zG ? this.f8831u : this.f8830t) + ((this.f8819i == -1 || D() == null) ? this.f8818h : (r6.getMeasuredWidth() / 2) + this.f8819i))) * (zG ? -1 : 1);
    }

    private boolean G() {
        FloatingActionButton floatingActionButtonC = C();
        return floatingActionButtonC != null && floatingActionButtonC.p();
    }

    private void I(int i10, boolean z10) {
        if (!ViewCompat.isLaidOut(this)) {
            this.f8826p = false;
            L(this.f8825o);
            return;
        }
        Animator animator = this.f8814d;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!G()) {
            i10 = 0;
            z10 = false;
        }
        z(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f8814d = animatorSet;
        animatorSet.addListener(new c());
        this.f8814d.start();
    }

    private void J(int i10) {
        if (this.f8815e == i10 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.f8813c;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f8816f == 1) {
            y(i10, arrayList);
        } else {
            x(i10, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(s4.h.g(getContext(), f8810y, f4.a.f25668a));
        this.f8813c = animatorSet;
        animatorSet.addListener(new a());
        this.f8813c.start();
    }

    @Nullable
    private Drawable K(@Nullable Drawable drawable) {
        if (drawable == null || this.f8811a == null) {
            return drawable;
        }
        Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(drawableWrap, this.f8811a.intValue());
        return drawableWrap;
    }

    private void M() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f8814d != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (G()) {
            Q(actionMenuView, this.f8815e, this.f8827q);
        } else {
            Q(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        getTopEdgeTreatment().o(getFabTranslationX());
        this.f8812b.Z((this.f8827q && G() && this.f8817g == 1) ? 1.0f : 0.0f);
        View viewD = D();
        if (viewD != null) {
            viewD.setTranslationY(getFabTranslationY());
            viewD.setTranslationX(getFabTranslationX());
        }
    }

    private void Q(@NonNull ActionMenuView actionMenuView, int i10, boolean z10) {
        R(actionMenuView, i10, z10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(@NonNull ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        e eVar = new e(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        layoutParams.anchorGravity = 17;
        int i10 = bottomAppBar.f8817g;
        if (i10 == 1) {
            layoutParams.anchorGravity = 17 | 48;
        }
        if (i10 == 0) {
            layoutParams.anchorGravity |= 80;
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f8829s;
    }

    private int getFabAlignmentAnimationDuration() {
        return s4.h.f(getContext(), f8809x, AnimationConstants.DefaultDurationMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return F(this.f8815e);
    }

    private float getFabTranslationY() {
        if (this.f8817g == 1) {
            return -getTopEdgeTreatment().d();
        }
        return D() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f8831u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f8830t;
    }

    @NonNull
    private com.google.android.material.bottomappbar.b getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.b) this.f8812b.C().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f8832v);
        floatingActionButton.f(new f());
        floatingActionButton.g(null);
    }

    private void w() {
        Animator animator = this.f8814d;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f8813c;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void y(int i10, @NonNull List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(C(), "translationX", F(i10));
        objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(objectAnimatorOfFloat);
    }

    private void z(int i10, boolean z10, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        animatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
        if (Math.abs(actionMenuView.getTranslationX() - E(actionMenuView, i10, z10)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
            objectAnimatorOfFloat.addListener(new d(actionMenuView, i10, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    protected int E(@NonNull ActionMenuView actionMenuView, int i10, boolean z10) {
        int dimensionPixelOffset = 0;
        if (this.f8820j != 1 && (i10 != 1 || !z10)) {
            return 0;
        }
        boolean zG = s.g(this);
        int measuredWidth = zG ? getMeasuredWidth() : 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = zG ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zG ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i12 = zG ? this.f8830t : -this.f8831u;
        if (getNavigationIcon() == null) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(e4.d.f24794m);
            if (!zG) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
        }
        return measuredWidth - ((right + i12) + dimensionPixelOffset);
    }

    public void L(@MenuRes int i10) {
        if (i10 != 0) {
            this.f8825o = 0;
            getMenu().clear();
            inflateMenu(i10);
        }
    }

    public void O(int i10, @MenuRes int i11) {
        this.f8825o = i11;
        this.f8826p = true;
        I(i10, this.f8827q);
        J(i10);
        this.f8815e = i10;
    }

    boolean P(@Px int i10) {
        float f10 = i10;
        if (f10 == getTopEdgeTreatment().h()) {
            return false;
        }
        getTopEdgeTreatment().m(f10);
        this.f8812b.invalidateSelf();
        return true;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.f8812b.G();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d();
    }

    public int getFabAlignmentMode() {
        return this.f8815e;
    }

    @Px
    public int getFabAlignmentModeEndMargin() {
        return this.f8819i;
    }

    public int getFabAnchorMode() {
        return this.f8817g;
    }

    public int getFabAnimationMode() {
        return this.f8816f;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().g();
    }

    public boolean getHideOnScroll() {
        return this.f8822l;
    }

    public int getMenuAlignmentMode() {
        return this.f8820j;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x4.h.f(this, this.f8812b);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            w();
            N();
            final View viewD = D();
            if (viewD != null && ViewCompat.isLaidOut(viewD)) {
                viewD.post(new Runnable() { // from class: com.google.android.material.bottomappbar.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewD.requestLayout();
                    }
                });
            }
        }
        M();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        this.f8815e = hVar.f8853a;
        this.f8827q = hVar.f8854b;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.f8853a = this.f8815e;
        hVar.f8854b = this.f8827q;
        return hVar;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f8812b, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().i(f10);
            this.f8812b.invalidateSelf();
            N();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        this.f8812b.X(f10);
        getBehavior().i(this, this.f8812b.B() - this.f8812b.A());
    }

    public void setFabAlignmentMode(int i10) {
        O(i10, 0);
    }

    public void setFabAlignmentModeEndMargin(@Px int i10) {
        if (this.f8819i != i10) {
            this.f8819i = i10;
            N();
        }
    }

    public void setFabAnchorMode(int i10) {
        this.f8817g = i10;
        N();
        View viewD = D();
        if (viewD != null) {
            S(this, viewD);
            viewD.requestLayout();
            this.f8812b.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i10) {
        this.f8816f = i10;
    }

    void setFabCornerSize(@Dimension float f10) {
        if (f10 != getTopEdgeTreatment().e()) {
            getTopEdgeTreatment().j(f10);
            this.f8812b.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().k(f10);
            this.f8812b.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().l(f10);
            this.f8812b.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f8822l = z10;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.f8820j != i10) {
            this.f8820j = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                Q(actionMenuView, this.f8815e, G());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(K(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i10) {
        this.f8811a = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    protected void x(int i10, List<Animator> list) {
        FloatingActionButton floatingActionButtonC = C();
        if (floatingActionButtonC == null || floatingActionButtonC.o()) {
            return;
        }
        B();
        floatingActionButtonC.m(new b(i10));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.f8828r == null) {
            this.f8828r = new Behavior();
        }
        return this.f8828r;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @NonNull
        private final Rect f8833m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private WeakReference<BottomAppBar> f8834n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f8835o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final View.OnLayoutChangeListener f8836p;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f8834n.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.j(Behavior.this.f8833m);
                    int iHeight = Behavior.this.f8833m.height();
                    bottomAppBar.P(iHeight);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f8833m)));
                    height = iHeight;
                }
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.f8835o == 0) {
                    if (bottomAppBar.f8817g == 1) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(e4.d.L) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                    if (s.g(view)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f8818h;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f8818h;
                    }
                }
                bottomAppBar.N();
            }
        }

        public Behavior() {
            this.f8836p = new a();
            this.f8833m = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i10) {
            this.f8834n = new WeakReference<>(bottomAppBar);
            View viewD = bottomAppBar.D();
            if (viewD != null && !ViewCompat.isLaidOut(viewD)) {
                BottomAppBar.S(bottomAppBar, viewD);
                this.f8835o = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) viewD.getLayoutParams())).bottomMargin;
                if (viewD instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewD;
                    if (bottomAppBar.f8817g == 0 && bottomAppBar.f8821k) {
                        ViewCompat.setElevation(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(e4.a.f24740b);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(e4.a.f24739a);
                    }
                    bottomAppBar.v(floatingActionButton);
                }
                viewD.addOnLayoutChangeListener(this.f8836p);
                bottomAppBar.N();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i10);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i10);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i10, int i11) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8836p = new a();
            this.f8833m = new Rect();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
