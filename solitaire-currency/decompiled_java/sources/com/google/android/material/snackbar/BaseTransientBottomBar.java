package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.u;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f9586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f9587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f9588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final ViewGroup f9589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f9590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    protected final s f9591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.snackbar.a f9592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9594l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f9598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f9603u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<q<B>> f9604v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Behavior f9605w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private final AccessibilityManager f9606x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final TimeInterpolator f9582z = f4.a.f25669b;
    private static final TimeInterpolator A = f4.a.f25668a;
    private static final TimeInterpolator B = f4.a.f25671d;
    private static final boolean D = false;
    private static final int[] E = {e4.b.O};
    private static final String F = BaseTransientBottomBar.class.getSimpleName();

    @NonNull
    static final Handler C = new Handler(Looper.getMainLooper(), new h());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9595m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @RequiresApi(29)
    private final Runnable f9596n = new i();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    b.InterfaceC0217b f9607y = new l();

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NonNull
        private final r f9608l = new r(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void q(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f9608l.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean f(View view) {
            return this.f9608l.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f9608l.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9609a;

        a(int i10) {
            this.f9609a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.P(this.f9609a);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f9591i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f9591i.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f9591i.setScaleY(fFloatValue);
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.Q();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f9592j.a(BaseTransientBottomBar.this.f9585c - BaseTransientBottomBar.this.f9583a, BaseTransientBottomBar.this.f9583a);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9615b;

        e(int i10) {
            this.f9615b = i10;
            this.f9614a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f9591i, iIntValue - this.f9614a);
            } else {
                BaseTransientBottomBar.this.f9591i.setTranslationY(iIntValue);
            }
            this.f9614a = iIntValue;
        }
    }

    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9617a;

        f(int i10) {
            this.f9617a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.P(this.f9617a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f9592j.b(0, BaseTransientBottomBar.this.f9584b);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9619a = 0;

        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f9591i, iIntValue - this.f9619a);
            } else {
                BaseTransientBottomBar.this.f9591i.setTranslationY(iIntValue);
            }
            this.f9619a = iIntValue;
        }
    }

    class h implements Handler.Callback {
        h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                ((BaseTransientBottomBar) message.obj).X();
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).J(message.arg1);
            return true;
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f9591i == null || baseTransientBottomBar.f9590h == null) {
                return;
            }
            int iHeight = (u.a(BaseTransientBottomBar.this.f9590h).height() - BaseTransientBottomBar.this.H()) + ((int) BaseTransientBottomBar.this.f9591i.getTranslationY());
            if (iHeight >= BaseTransientBottomBar.this.f9601s) {
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                baseTransientBottomBar2.f9602t = baseTransientBottomBar2.f9601s;
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f9591i.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.F, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
            baseTransientBottomBar3.f9602t = baseTransientBottomBar3.f9601s;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f9601s - iHeight;
            BaseTransientBottomBar.this.f9591i.requestLayout();
        }
    }

    class j implements OnApplyWindowInsetsListener {
        j() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.f9597o = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.f9598p = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.f9599q = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.d0();
            return windowInsetsCompat;
        }
    }

    class k extends AccessibilityDelegateCompat {
        k() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 1048576) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            BaseTransientBottomBar.this.x();
            return true;
        }
    }

    class l implements b.InterfaceC0217b {
        l() {
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0217b
        public void a(int i10) {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(1, i10, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0217b
        public void show() {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.P(3);
        }
    }

    class n implements SwipeDismissBehavior.c {
        n() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.y(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i10) {
            if (i10 == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.f9607y);
            } else if (i10 == 1 || i10 == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.f9607y);
            }
        }
    }

    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s sVar = BaseTransientBottomBar.this.f9591i;
            if (sVar == null) {
                return;
            }
            if (sVar.getParent() != null) {
                BaseTransientBottomBar.this.f9591i.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f9591i.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.Z();
            } else {
                BaseTransientBottomBar.this.b0();
            }
        }
    }

    class p extends AnimatorListenerAdapter {
        p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.Q();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b.InterfaceC0217b f9629a;

        public r(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.m(0.1f);
            swipeDismissBehavior.k(0.6f);
            swipeDismissBehavior.n(0);
        }

        public boolean a(View view) {
            return view instanceof s;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.f9629a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.f9629a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f9629a = baseTransientBottomBar.f9607y;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static class s extends FrameLayout {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final View.OnTouchListener f9630l = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private BaseTransientBottomBar<?> f9631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        x4.k f9632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f9634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f9635e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f9636f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f9637g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ColorStateList f9638h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private PorterDuff.Mode f9639i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private Rect f9640j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f9641k;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected s(@NonNull Context context, AttributeSet attributeSet) {
            super(b5.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, e4.k.F4);
            if (typedArrayObtainStyledAttributes.hasValue(e4.k.M4)) {
                ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f9633c = typedArrayObtainStyledAttributes.getInt(e4.k.I4, 0);
            if (typedArrayObtainStyledAttributes.hasValue(e4.k.O4) || typedArrayObtainStyledAttributes.hasValue(e4.k.P4)) {
                this.f9632b = x4.k.e(context2, attributeSet, 0, 0).m();
            }
            this.f9634d = typedArrayObtainStyledAttributes.getFloat(e4.k.J4, 1.0f);
            setBackgroundTintList(u4.c.a(context2, typedArrayObtainStyledAttributes, e4.k.K4));
            setBackgroundTintMode(com.google.android.material.internal.s.i(typedArrayObtainStyledAttributes.getInt(e4.k.L4, -1), PorterDuff.Mode.SRC_IN));
            this.f9635e = typedArrayObtainStyledAttributes.getFloat(e4.k.H4, 1.0f);
            this.f9636f = typedArrayObtainStyledAttributes.getDimensionPixelSize(e4.k.G4, -1);
            this.f9637g = typedArrayObtainStyledAttributes.getDimensionPixelSize(e4.k.N4, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f9630l);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, d());
            }
        }

        @NonNull
        private Drawable d() {
            int iK = n4.a.k(this, e4.b.f24756m, e4.b.f24752i, getBackgroundOverlayColorAlpha());
            x4.k kVar = this.f9632b;
            Drawable drawableW = kVar != null ? BaseTransientBottomBar.w(iK, kVar) : BaseTransientBottomBar.v(iK, getResources());
            if (this.f9638h == null) {
                return DrawableCompat.wrap(drawableW);
            }
            Drawable drawableWrap = DrawableCompat.wrap(drawableW);
            DrawableCompat.setTintList(drawableWrap, this.f9638h);
            return drawableWrap;
        }

        private void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f9640j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f9631a = baseTransientBottomBar;
        }

        void c(ViewGroup viewGroup) {
            this.f9641k = true;
            viewGroup.addView(this);
            this.f9641k = false;
        }

        float getActionTextColorAlpha() {
            return this.f9635e;
        }

        int getAnimationMode() {
            return this.f9633c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f9634d;
        }

        int getMaxInlineActionWidth() {
            return this.f9637g;
        }

        int getMaxWidth() {
            return this.f9636f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9631a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.M();
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9631a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.N();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9631a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.O();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f9636f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = this.f9636f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        void setAnimationMode(int i10) {
            this.f9633c = i10;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f9638h != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f9638h);
                DrawableCompat.setTintMode(drawable, this.f9639i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f9638h = colorStateList;
            if (getBackground() != null) {
                Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(drawableWrap, colorStateList);
                DrawableCompat.setTintMode(drawableWrap, this.f9639i);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f9639i = mode;
            if (getBackground() != null) {
                Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(drawableWrap, mode);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f9641k || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            e((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9631a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.d0();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f9630l);
            super.setOnClickListener(onClickListener);
        }
    }

    protected BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f9589g = viewGroup;
        this.f9592j = aVar;
        this.f9590h = context;
        com.google.android.material.internal.p.a(context);
        s sVar = (s) LayoutInflater.from(context).inflate(E(), viewGroup, false);
        this.f9591i = sVar;
        sVar.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            snackbarContentLayout.c(sVar.getActionTextColorAlpha());
            snackbarContentLayout.setMaxInlineActionWidth(sVar.getMaxInlineActionWidth());
        }
        sVar.addView(view);
        ViewCompat.setAccessibilityLiveRegion(sVar, 1);
        ViewCompat.setImportantForAccessibility(sVar, 1);
        ViewCompat.setFitsSystemWindows(sVar, true);
        ViewCompat.setOnApplyWindowInsetsListener(sVar, new j());
        ViewCompat.setAccessibilityDelegate(sVar, new k());
        this.f9606x = (AccessibilityManager) context.getSystemService("accessibility");
        int i10 = e4.b.f24769z;
        this.f9585c = s4.h.f(context, i10, 250);
        this.f9583a = s4.h.f(context, i10, 150);
        this.f9584b = s4.h.f(context, e4.b.A, 75);
        int i11 = e4.b.I;
        this.f9586d = s4.h.g(context, i11, A);
        this.f9588f = s4.h.g(context, i11, B);
        this.f9587e = s4.h.g(context, i11, f9582z);
    }

    private ValueAnimator D(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f9588f);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    private int F() {
        int height = this.f9591i.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f9591i.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H() {
        int[] iArr = new int[2];
        this.f9591i.getLocationInWindow(iArr);
        return iArr[1] + this.f9591i.getHeight();
    }

    private boolean L() {
        ViewGroup.LayoutParams layoutParams = this.f9591i.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    private void R() {
        this.f9600r = u();
        d0();
    }

    private void T(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorC = this.f9605w;
        if (swipeDismissBehaviorC == null) {
            swipeDismissBehaviorC = C();
        }
        if (swipeDismissBehaviorC instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorC).q(this);
        }
        swipeDismissBehaviorC.l(new n());
        layoutParams.setBehavior(swipeDismissBehaviorC);
        if (A() == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean V() {
        return this.f9601s > 0 && !this.f9594l && L();
    }

    private void Y() {
        if (U()) {
            s();
            return;
        }
        if (this.f9591i.getParent() != null) {
            this.f9591i.setVisibility(0);
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        ValueAnimator valueAnimatorZ = z(0.0f, 1.0f);
        ValueAnimator valueAnimatorD = D(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorZ, valueAnimatorD);
        animatorSet.setDuration(this.f9583a);
        animatorSet.addListener(new p());
        animatorSet.start();
    }

    private void a0(int i10) {
        ValueAnimator valueAnimatorZ = z(1.0f, 0.0f);
        valueAnimatorZ.setDuration(this.f9584b);
        valueAnimatorZ.addListener(new a(i10));
        valueAnimatorZ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        int iF = F();
        if (D) {
            ViewCompat.offsetTopAndBottom(this.f9591i, iF);
        } else {
            this.f9591i.setTranslationY(iF);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iF, 0);
        valueAnimator.setInterpolator(this.f9587e);
        valueAnimator.setDuration(this.f9585c);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(iF));
        valueAnimator.start();
    }

    private void c0(int i10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, F());
        valueAnimator.setInterpolator(this.f9587e);
        valueAnimator.setDuration(this.f9585c);
        valueAnimator.addListener(new f(i10));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        ViewGroup.LayoutParams layoutParams = this.f9591i.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(F, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f9591i.f9640j == null) {
            Log.w(F, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f9591i.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i10 = this.f9591i.f9640j.bottom + (A() != null ? this.f9600r : this.f9597o);
        int i11 = this.f9591i.f9640j.left + this.f9598p;
        int i12 = this.f9591i.f9640j.right + this.f9599q;
        int i13 = this.f9591i.f9640j.top;
        boolean z10 = (marginLayoutParams.bottomMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12 && marginLayoutParams.topMargin == i13) ? false : true;
        if (z10) {
            marginLayoutParams.bottomMargin = i10;
            marginLayoutParams.leftMargin = i11;
            marginLayoutParams.rightMargin = i12;
            marginLayoutParams.topMargin = i13;
            this.f9591i.requestLayout();
        }
        if ((z10 || this.f9602t != this.f9601s) && Build.VERSION.SDK_INT >= 29 && V()) {
            this.f9591i.removeCallbacks(this.f9596n);
            this.f9591i.post(this.f9596n);
        }
    }

    private void t(int i10) {
        if (this.f9591i.getAnimationMode() == 1) {
            a0(i10);
        } else {
            c0(i10);
        }
    }

    private int u() {
        if (A() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        A().getLocationOnScreen(iArr);
        int i10 = iArr[1];
        int[] iArr2 = new int[2];
        this.f9589g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f9589g.getHeight()) - i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static GradientDrawable v(@ColorInt int i10, @NonNull Resources resources) {
        float dimension = resources.getDimension(e4.d.f24779b0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static x4.g w(@ColorInt int i10, @NonNull x4.k kVar) {
        x4.g gVar = new x4.g(kVar);
        gVar.Y(ColorStateList.valueOf(i10));
        return gVar;
    }

    private ValueAnimator z(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f9586d);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    @Nullable
    public View A() {
        return null;
    }

    public int B() {
        return this.f9593k;
    }

    @NonNull
    protected SwipeDismissBehavior<? extends View> C() {
        return new Behavior();
    }

    @LayoutRes
    protected int E() {
        return I() ? e4.h.f24868t : e4.h.f24850b;
    }

    @NonNull
    public View G() {
        return this.f9591i;
    }

    protected boolean I() {
        TypedArray typedArrayObtainStyledAttributes = this.f9590h.obtainStyledAttributes(E);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void J(int i10) {
        if (U() && this.f9591i.getVisibility() == 0) {
            t(i10);
        } else {
            P(i10);
        }
    }

    public boolean K() {
        return com.google.android.material.snackbar.b.c().e(this.f9607y);
    }

    void M() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f9591i.getRootWindowInsets()) == null) {
            return;
        }
        this.f9601s = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        d0();
    }

    void N() {
        if (K()) {
            C.post(new m());
        }
    }

    void O() {
        if (this.f9603u) {
            Y();
            this.f9603u = false;
        }
    }

    void P(int i10) {
        com.google.android.material.snackbar.b.c().h(this.f9607y);
        List<q<B>> list = this.f9604v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f9604v.get(size).a(this, i10);
            }
        }
        ViewParent parent = this.f9591i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f9591i);
        }
    }

    void Q() {
        com.google.android.material.snackbar.b.c().i(this.f9607y);
        List<q<B>> list = this.f9604v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f9604v.get(size).b(this);
            }
        }
    }

    @NonNull
    public B S(int i10) {
        this.f9593k = i10;
        return this;
    }

    boolean U() {
        AccessibilityManager accessibilityManager = this.f9606x;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void W() {
        com.google.android.material.snackbar.b.c().m(B(), this.f9607y);
    }

    final void X() {
        if (this.f9591i.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f9591i.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                T((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.f9591i.c(this.f9589g);
            R();
            this.f9591i.setVisibility(4);
        }
        if (ViewCompat.isLaidOut(this.f9591i)) {
            Y();
        } else {
            this.f9603u = true;
        }
    }

    void s() {
        this.f9591i.post(new o());
    }

    public void x() {
        y(3);
    }

    protected void y(int i10) {
        com.google.android.material.snackbar.b.c().b(this.f9607y, i10);
    }

    public static abstract class q<B> {
        public void b(B b10) {
        }

        public void a(B b10, int i10) {
        }
    }
}
