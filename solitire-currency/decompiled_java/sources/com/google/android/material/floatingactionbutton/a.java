package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import x4.n;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
class a {
    static final TimeInterpolator C = f4.a.f25670c;
    private static final int D = e4.b.f24769z;
    private static final int E = e4.b.I;
    private static final int F = e4.b.A;
    private static final int G = e4.b.G;
    static final int[] H = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] I = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] J = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] K = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] L = {R.attr.state_enabled};
    static final int[] M = new int[0];

    @Nullable
    private ViewTreeObserver.OnPreDrawListener B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    x4.k f9318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    x4.g f9319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    Drawable f9320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    Drawable f9321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f9322e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f9324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f9325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f9326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f9327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.internal.k f9328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private Animator f9329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private f4.h f9330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private f4.h f9331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f9332o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9334q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f9336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f9337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<j> f9338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final FloatingActionButton f9339v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final w4.b f9340w;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f9323f = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f9333p = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9335r = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Rect f9341x = new Rect();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final RectF f9342y = new RectF();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final RectF f9343z = new RectF();
    private final Matrix A = new Matrix();

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class C0213a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f9346c;

        C0213a(boolean z10, k kVar) {
            this.f9345b = z10;
            this.f9346c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f9344a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f9335r = 0;
            a.this.f9329l = null;
            if (this.f9344a) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.f9339v;
            boolean z10 = this.f9345b;
            floatingActionButton.b(z10 ? 8 : 4, z10);
            k kVar = this.f9346c;
            if (kVar != null) {
                kVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f9339v.b(0, this.f9345b);
            a.this.f9335r = 1;
            a.this.f9329l = animator;
            this.f9344a = false;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f9349b;

        b(boolean z10, k kVar) {
            this.f9348a = z10;
            this.f9349b = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f9335r = 0;
            a.this.f9329l = null;
            k kVar = this.f9349b;
            if (kVar != null) {
                kVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f9339v.b(0, this.f9348a);
            a.this.f9335r = 2;
            a.this.f9329l = animator;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class c extends f4.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            a.this.f9333p = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f9352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f9353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f9354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f9355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f9356e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f9357f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f9358g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Matrix f9359h;

        d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
            this.f9352a = f10;
            this.f9353b = f11;
            this.f9354c = f12;
            this.f9355d = f13;
            this.f9356e = f14;
            this.f9357f = f15;
            this.f9358g = f16;
            this.f9359h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f9339v.setAlpha(f4.a.b(this.f9352a, this.f9353b, 0.0f, 0.2f, fFloatValue));
            a.this.f9339v.setScaleX(f4.a.a(this.f9354c, this.f9355d, fFloatValue));
            a.this.f9339v.setScaleY(f4.a.a(this.f9356e, this.f9355d, fFloatValue));
            a.this.f9333p = f4.a.a(this.f9357f, this.f9358g, fFloatValue);
            a.this.h(f4.a.a(this.f9357f, this.f9358g, fFloatValue), this.f9359h);
            a.this.f9339v.setImageMatrix(this.f9359h);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class e implements TypeEvaluator<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FloatEvaluator f9361a = new FloatEvaluator();

        e() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f10, Float f11, Float f12) {
            float fFloatValue = this.f9361a.evaluate(f10, (Number) f11, (Number) f12).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.G();
            return true;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class g extends m {
        g() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class h extends m {
        h() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            a aVar = a.this;
            return aVar.f9324g + aVar.f9325h;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class i extends m {
        i() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            a aVar = a.this;
            return aVar.f9324g + aVar.f9326i;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface j {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface k {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class l extends m {
        l() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            return a.this.f9324g;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f9369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f9370c;

        private m() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.e0((int) this.f9370c);
            this.f9368a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.f9368a) {
                x4.g gVar = a.this.f9319b;
                this.f9369b = gVar == null ? 0.0f : gVar.u();
                this.f9370c = a();
                this.f9368a = true;
            }
            a aVar = a.this;
            float f10 = this.f9369b;
            aVar.e0((int) (f10 + ((this.f9370c - f10) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ m(a aVar, C0213a c0213a) {
            this();
        }
    }

    a(FloatingActionButton floatingActionButton, w4.b bVar) {
        this.f9339v = floatingActionButton;
        this.f9340w = bVar;
        com.google.android.material.internal.k kVar = new com.google.android.material.internal.k();
        this.f9328k = kVar;
        kVar.a(H, k(new i()));
        kVar.a(I, k(new h()));
        kVar.a(J, k(new h()));
        kVar.a(K, k(new h()));
        kVar.a(L, k(new l()));
        kVar.a(M, k(new g()));
        this.f9332o = floatingActionButton.getRotation();
    }

    private boolean Y() {
        return ViewCompat.isLaidOut(this.f9339v) && !this.f9339v.isInEditMode();
    }

    private void f0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f10, @NonNull Matrix matrix) {
        matrix.reset();
        if (this.f9339v.getDrawable() == null || this.f9334q == 0) {
            return;
        }
        RectF rectF = this.f9342y;
        RectF rectF2 = this.f9343z;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i10 = this.f9334q;
        rectF2.set(0.0f, 0.0f, i10, i10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i11 = this.f9334q;
        matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
    }

    @NonNull
    private AnimatorSet i(@NonNull f4.h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f9339v, (Property<FloatingActionButton, Float>) View.ALPHA, f10);
        hVar.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f9339v, (Property<FloatingActionButton, Float>) View.SCALE_X, f11);
        hVar.e("scale").a(objectAnimatorOfFloat2);
        f0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f9339v, (Property<FloatingActionButton, Float>) View.SCALE_Y, f11);
        hVar.e("scale").a(objectAnimatorOfFloat3);
        f0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f12, this.A);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f9339v, new f4.f(), new c(), new Matrix(this.A));
        hVar.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        f4.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f10, float f11, float f12, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new d(this.f9339v.getAlpha(), f10, this.f9339v.getScaleX(), f11, this.f9339v.getScaleY(), this.f9333p, f12, new Matrix(this.A)));
        arrayList.add(valueAnimatorOfFloat);
        f4.b.a(animatorSet, arrayList);
        animatorSet.setDuration(s4.h.f(this.f9339v.getContext(), i10, this.f9339v.getContext().getResources().getInteger(e4.g.f24847b)));
        animatorSet.setInterpolator(s4.h.g(this.f9339v.getContext(), i11, f4.a.f25669b));
        return animatorSet;
    }

    @NonNull
    private ValueAnimator k(@NonNull m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(C);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.B == null) {
            this.B = new f();
        }
        return this.B;
    }

    void A() {
        x4.g gVar = this.f9319b;
        if (gVar != null) {
            x4.h.f(this.f9339v, gVar);
        }
        if (J()) {
            this.f9339v.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    void B() {
        throw null;
    }

    void C() {
        ViewTreeObserver viewTreeObserver = this.f9339v.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.B;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.B = null;
        }
    }

    void D(int[] iArr) {
        throw null;
    }

    void E(float f10, float f11, float f12) {
        throw null;
    }

    void F(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.f9321d, "Didn't initialize content background");
        if (!X()) {
            this.f9340w.setBackgroundDrawable(this.f9321d);
        } else {
            this.f9340w.setBackgroundDrawable(new InsetDrawable(this.f9321d, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void G() {
        float rotation = this.f9339v.getRotation();
        if (this.f9332o != rotation) {
            this.f9332o = rotation;
            b0();
        }
    }

    void H() {
        ArrayList<j> arrayList = this.f9338u;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    void I() {
        ArrayList<j> arrayList = this.f9338u;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    boolean J() {
        throw null;
    }

    void K(@Nullable ColorStateList colorStateList) {
        x4.g gVar = this.f9319b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
    }

    void L(@Nullable PorterDuff.Mode mode) {
        x4.g gVar = this.f9319b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    final void M(float f10) {
        if (this.f9324g != f10) {
            this.f9324g = f10;
            E(f10, this.f9325h, this.f9326i);
        }
    }

    void N(boolean z10) {
        this.f9322e = z10;
    }

    final void O(@Nullable f4.h hVar) {
        this.f9331n = hVar;
    }

    final void P(float f10) {
        if (this.f9325h != f10) {
            this.f9325h = f10;
            E(this.f9324g, f10, this.f9326i);
        }
    }

    final void Q(float f10) {
        this.f9333p = f10;
        Matrix matrix = this.A;
        h(f10, matrix);
        this.f9339v.setImageMatrix(matrix);
    }

    final void R(int i10) {
        if (this.f9334q != i10) {
            this.f9334q = i10;
            c0();
        }
    }

    final void S(float f10) {
        if (this.f9326i != f10) {
            this.f9326i = f10;
            E(this.f9324g, this.f9325h, f10);
        }
    }

    void T(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f9320c;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, v4.b.a(colorStateList));
        }
    }

    void U(boolean z10) {
        this.f9323f = z10;
        d0();
    }

    final void V(@NonNull x4.k kVar) {
        this.f9318a = kVar;
        x4.g gVar = this.f9319b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Object obj = this.f9320c;
        if (obj instanceof n) {
            ((n) obj).setShapeAppearanceModel(kVar);
        }
    }

    final void W(@Nullable f4.h hVar) {
        this.f9330m = hVar;
    }

    boolean X() {
        throw null;
    }

    final boolean Z() {
        return !this.f9322e || this.f9339v.getSizeDimension() >= this.f9327j;
    }

    void a0(@Nullable k kVar, boolean z10) {
        if (y()) {
            return;
        }
        Animator animator = this.f9329l;
        if (animator != null) {
            animator.cancel();
        }
        boolean z11 = this.f9330m == null;
        if (!Y()) {
            this.f9339v.b(0, z10);
            this.f9339v.setAlpha(1.0f);
            this.f9339v.setScaleY(1.0f);
            this.f9339v.setScaleX(1.0f);
            Q(1.0f);
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (this.f9339v.getVisibility() != 0) {
            this.f9339v.setAlpha(0.0f);
            this.f9339v.setScaleY(z11 ? 0.4f : 0.0f);
            this.f9339v.setScaleX(z11 ? 0.4f : 0.0f);
            Q(z11 ? 0.4f : 0.0f);
        }
        f4.h hVar = this.f9330m;
        AnimatorSet animatorSetI = hVar != null ? i(hVar, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f, D, E);
        animatorSetI.addListener(new b(z10, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f9336s;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener(it.next());
            }
        }
        animatorSetI.start();
    }

    void b0() {
        throw null;
    }

    final void c0() {
        Q(this.f9333p);
    }

    final void d0() {
        Rect rect = this.f9341x;
        r(rect);
        F(rect);
        this.f9340w.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f9337t == null) {
            this.f9337t = new ArrayList<>();
        }
        this.f9337t.add(animatorListener);
    }

    void e0(float f10) {
        x4.g gVar = this.f9319b;
        if (gVar != null) {
            gVar.X(f10);
        }
    }

    void f(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f9336s == null) {
            this.f9336s = new ArrayList<>();
        }
        this.f9336s.add(animatorListener);
    }

    void g(@NonNull j jVar) {
        if (this.f9338u == null) {
            this.f9338u = new ArrayList<>();
        }
        this.f9338u.add(jVar);
    }

    @Nullable
    final Drawable l() {
        return this.f9321d;
    }

    float m() {
        throw null;
    }

    boolean n() {
        return this.f9322e;
    }

    @Nullable
    final f4.h o() {
        return this.f9331n;
    }

    float p() {
        return this.f9325h;
    }

    void r(@NonNull Rect rect) {
        int iV = v();
        int iMax = Math.max(iV, (int) Math.ceil(this.f9323f ? m() + this.f9326i : 0.0f));
        int iMax2 = Math.max(iV, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float s() {
        return this.f9326i;
    }

    @Nullable
    final x4.k t() {
        return this.f9318a;
    }

    @Nullable
    final f4.h u() {
        return this.f9330m;
    }

    int v() {
        if (this.f9322e) {
            return Math.max((this.f9327j - this.f9339v.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    void w(@Nullable k kVar, boolean z10) {
        if (x()) {
            return;
        }
        Animator animator = this.f9329l;
        if (animator != null) {
            animator.cancel();
        }
        if (!Y()) {
            this.f9339v.b(z10 ? 8 : 4, z10);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        f4.h hVar = this.f9331n;
        AnimatorSet animatorSetI = hVar != null ? i(hVar, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f, F, G);
        animatorSetI.addListener(new C0213a(z10, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f9337t;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener(it.next());
            }
        }
        animatorSetI.start();
    }

    boolean x() {
        return this.f9339v.getVisibility() == 0 ? this.f9335r == 1 : this.f9335r != 2;
    }

    boolean y() {
        return this.f9339v.getVisibility() != 0 ? this.f9335r == 2 : this.f9335r != 1;
    }

    void z() {
        throw null;
    }
}
