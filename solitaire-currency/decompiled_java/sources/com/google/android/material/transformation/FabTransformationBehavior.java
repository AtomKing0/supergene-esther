package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e4.f;
import f4.h;
import f4.i;
import f4.j;
import java.util.ArrayList;
import java.util.List;
import l4.d;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f9926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f9927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f9928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f9929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f9930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f9931h;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f9933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f9934c;

        a(boolean z10, View view, View view2) {
            this.f9932a = z10;
            this.f9933b = view;
            this.f9934c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f9932a) {
                return;
            }
            this.f9933b.setVisibility(4);
            this.f9934c.setAlpha(1.0f);
            this.f9934c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f9932a) {
                this.f9933b.setVisibility(0);
                this.f9934c.setAlpha(0.0f);
                this.f9934c.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9936a;

        b(View view) {
            this.f9936a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9936a.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l4.d f9938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f9939b;

        c(l4.d dVar, Drawable drawable) {
            this.f9938a = dVar;
            this.f9939b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9938a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f9938a.setCircularRevealOverlayDrawable(this.f9939b);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l4.d f9941a;

        d(l4.d dVar) {
            this.f9941a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.f9941a.getRevealInfo();
            revealInfo.f30826c = Float.MAX_VALUE;
            this.f9941a.setRevealInfo(revealInfo);
        }
    }

    protected static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public h f9943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f9944b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.f9926c = new Rect();
        this.f9927d = new RectF();
        this.f9928e = new RectF();
        this.f9929f = new int[2];
    }

    private void A(View view, long j10, long j11, long j12, int i10, int i11, float f10, @NonNull List<Animator> list) {
        long j13 = j10 + j11;
        if (j13 < j12) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(j13);
            animatorCreateCircularReveal.setDuration(j12 - j13);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void B(View view, long j10, int i10, int i11, float f10, @NonNull List<Animator> list) {
        if (j10 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j10);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void C(@NonNull View view, @NonNull View view2, boolean z10, boolean z11, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fQ = q(view, view2, eVar.f9944b);
        float fR = r(view, view2, eVar.f9944b);
        Pair<i, i> pairN = n(fQ, fR, z10, eVar);
        i iVar = (i) pairN.first;
        i iVar2 = (i) pairN.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-fQ);
                view2.setTranslationY(-fR);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            l(view2, eVar, iVar, iVar2, -fQ, -fR, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fQ);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fR);
        }
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private int D(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    @Nullable
    private ViewGroup F(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Nullable
    private ViewGroup k(@NonNull View view) {
        View viewFindViewById = view.findViewById(f.D);
        return viewFindViewById != null ? F(viewFindViewById) : ((view instanceof c5.b) || (view instanceof c5.a)) ? F(((ViewGroup) view).getChildAt(0)) : F(view);
    }

    private void l(@NonNull View view, @NonNull e eVar, @NonNull i iVar, @NonNull i iVar2, float f10, float f11, float f12, float f13, @NonNull RectF rectF) {
        float fS = s(eVar, iVar, f10, f12);
        float fS2 = s(eVar, iVar2, f11, f13);
        Rect rect = this.f9926c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f9927d;
        rectF2.set(rect);
        RectF rectF3 = this.f9928e;
        t(view, rectF3);
        rectF3.offset(fS, fS2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void m(@NonNull View view, @NonNull RectF rectF) {
        t(view, rectF);
        rectF.offset(this.f9930g, this.f9931h);
    }

    @NonNull
    private Pair<i, i> n(float f10, float f11, boolean z10, @NonNull e eVar) {
        i iVarE;
        i iVarE2;
        if (f10 == 0.0f || f11 == 0.0f) {
            iVarE = eVar.f9943a.e("translationXLinear");
            iVarE2 = eVar.f9943a.e("translationYLinear");
        } else if ((!z10 || f11 >= 0.0f) && (z10 || f11 <= 0.0f)) {
            iVarE = eVar.f9943a.e("translationXCurveDownwards");
            iVarE2 = eVar.f9943a.e("translationYCurveDownwards");
        } else {
            iVarE = eVar.f9943a.e("translationXCurveUpwards");
            iVarE2 = eVar.f9943a.e("translationYCurveUpwards");
        }
        return new Pair<>(iVarE, iVarE2);
    }

    private float o(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f9927d;
        RectF rectF2 = this.f9928e;
        m(view, rectF);
        t(view2, rectF2);
        rectF2.offset(-q(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float p(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f9927d;
        RectF rectF2 = this.f9928e;
        m(view, rectF);
        t(view2, rectF2);
        rectF2.offset(0.0f, -r(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float q(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float fCenterX;
        float fCenterX2;
        float f10;
        RectF rectF = this.f9927d;
        RectF rectF2 = this.f9928e;
        m(view, rectF);
        t(view2, rectF2);
        int i10 = jVar.f25688a & 7;
        if (i10 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i10 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i10 != 5) {
                f10 = 0.0f;
                return f10 + jVar.f25689b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f10 = fCenterX - fCenterX2;
        return f10 + jVar.f25689b;
    }

    private float r(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float fCenterY;
        float fCenterY2;
        float f10;
        RectF rectF = this.f9927d;
        RectF rectF2 = this.f9928e;
        m(view, rectF);
        t(view2, rectF2);
        int i10 = jVar.f25688a & 112;
        if (i10 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i10 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i10 != 80) {
                f10 = 0.0f;
                return f10 + jVar.f25690c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f10 = fCenterY - fCenterY2;
        return f10 + jVar.f25690c;
    }

    private float s(@NonNull e eVar, @NonNull i iVar, float f10, float f11) {
        long jC = iVar.c();
        long jD = iVar.d();
        i iVarE = eVar.f9943a.e("expansion");
        return f4.a.a(f10, f11, iVar.e().getInterpolation((((iVarE.c() + iVarE.d()) + 17) - jC) / jD));
    }

    private void t(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f9929f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void u(View view, View view2, boolean z10, boolean z11, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupK;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof l4.d) && l4.c.f30819a == 0) || (viewGroupK = k(view2)) == null) {
                return;
            }
            if (z10) {
                if (!z11) {
                    f4.d.f25674a.set(viewGroupK, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, f4.d.f25674a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, f4.d.f25674a, 0.0f);
            }
            eVar.f9943a.e("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v(@NonNull View view, View view2, boolean z10, boolean z11, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof l4.d) {
            l4.d dVar = (l4.d) view2;
            int iD = D(view);
            int i10 = 16777215 & iD;
            if (z10) {
                if (!z11) {
                    dVar.setCircularRevealScrimColor(iD);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(dVar, d.C0621d.f30823a, i10);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(dVar, d.C0621d.f30823a, iD);
            }
            objectAnimatorOfInt.setEvaluator(f4.c.b());
            eVar.f9943a.e("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void w(@NonNull View view, @NonNull View view2, boolean z10, @NonNull e eVar, @NonNull List<Animator> list) {
        float fQ = q(view, view2, eVar.f9944b);
        float fR = r(view, view2, eVar.f9944b);
        Pair<i, i> pairN = n(fQ, fR, z10, eVar);
        i iVar = (i) pairN.first;
        i iVar2 = (i) pairN.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z10) {
            fQ = this.f9930g;
        }
        fArr[0] = fQ;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z10) {
            fR = this.f9931h;
        }
        fArr2[0] = fR;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    private void x(View view, @NonNull View view2, boolean z10, boolean z11, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f9943a.e("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y(@NonNull View view, View view2, boolean z10, boolean z11, @NonNull e eVar, float f10, float f11, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof l4.d) {
            l4.d dVar = (l4.d) view2;
            float fO = o(view, view2, eVar.f9944b);
            float fP = p(view, view2, eVar.f9944b);
            ((FloatingActionButton) view).i(this.f9926c);
            float fWidth = this.f9926c.width() / 2.0f;
            i iVarE = eVar.f9943a.e("expansion");
            if (z10) {
                if (!z11) {
                    dVar.setRevealInfo(new d.e(fO, fP, fWidth));
                }
                if (z11) {
                    fWidth = dVar.getRevealInfo().f30826c;
                }
                animatorA = l4.a.a(dVar, fO, fP, r4.a.b(fO, fP, 0.0f, 0.0f, f10, f11));
                animatorA.addListener(new d(dVar));
                B(view2, iVarE.c(), (int) fO, (int) fP, fWidth, list);
            } else {
                float f12 = dVar.getRevealInfo().f30826c;
                Animator animatorA2 = l4.a.a(dVar, fO, fP, fWidth);
                int i10 = (int) fO;
                int i11 = (int) fP;
                B(view2, iVarE.c(), i10, i11, f12, list);
                A(view2, iVarE.c(), iVarE.d(), eVar.f9943a.f(), i10, i11, fWidth, list);
                animatorA = animatorA2;
            }
            iVarE.a(animatorA);
            list.add(animatorA);
            list2.add(l4.a.b(dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z(View view, View view2, boolean z10, boolean z11, @NonNull e eVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof l4.d) && (view instanceof ImageView)) {
            l4.d dVar = (l4.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, f4.e.f25675b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, f4.e.f25675b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.f9943a.e("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(dVar, drawable));
        }
    }

    protected abstract e E(Context context, boolean z10);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet j(@NonNull View view, @NonNull View view2, boolean z10, boolean z11) {
        e eVarE = E(view2.getContext(), z10);
        if (z10) {
            this.f9930g = view.getTranslationX();
            this.f9931h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        x(view, view2, z10, z11, eVarE, arrayList, arrayList2);
        RectF rectF = this.f9927d;
        C(view, view2, z10, z11, eVarE, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        w(view, view2, z10, eVarE, arrayList);
        z(view, view2, z10, z11, eVarE, arrayList, arrayList2);
        y(view, view2, z10, z11, eVarE, fWidth, fHeight, arrayList, arrayList2);
        v(view, view2, z10, z11, eVarE, arrayList, arrayList2);
        u(view, view2, z10, z11, eVarE, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        f4.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener(arrayList2.get(i10));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9926c = new Rect();
        this.f9927d = new RectF();
        this.f9928e = new RectF();
        this.f9929f = new int[2];
    }
}
