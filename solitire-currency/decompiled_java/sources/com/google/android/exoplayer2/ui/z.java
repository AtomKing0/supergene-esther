package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class z {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.ui.g f8654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final View f8655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ViewGroup f8656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final ViewGroup f8657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final ViewGroup f8658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final ViewGroup f8659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final ViewGroup f8660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final ViewGroup f8661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final ViewGroup f8662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final View f8663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final View f8664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AnimatorSet f8665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AnimatorSet f8666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AnimatorSet f8667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AnimatorSet f8668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AnimatorSet f8669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ValueAnimator f8670q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ValueAnimator f8671r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f8672s = new Runnable() { // from class: com.google.android.exoplayer2.ui.m
        @Override // java.lang.Runnable
        public final void run() {
            this.f8641a.c0();
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f8673t = new Runnable() { // from class: com.google.android.exoplayer2.ui.s
        @Override // java.lang.Runnable
        public final void run() {
            this.f8647a.D();
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f8674u = new Runnable() { // from class: com.google.android.exoplayer2.ui.t
        @Override // java.lang.Runnable
        public final void run() {
            this.f8648a.H();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Runnable f8675v = new Runnable() { // from class: com.google.android.exoplayer2.ui.u
        @Override // java.lang.Runnable
        public final void run() {
            this.f8649a.G();
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f8676w = new Runnable() { // from class: com.google.android.exoplayer2.ui.v
        @Override // java.lang.Runnable
        public final void run() {
            this.f8650a.E();
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final View.OnLayoutChangeListener f8677x = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.w
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f8651a.R(view, i10, i11, i12, i13, i14, i15, i16, i17);
        }
    };
    private boolean C = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8679z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List<View> f8678y = new ArrayList();

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (z.this.f8655b != null) {
                z.this.f8655b.setVisibility(4);
            }
            if (z.this.f8656c != null) {
                z.this.f8656c.setVisibility(4);
            }
            if (z.this.f8658e != null) {
                z.this.f8658e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(z.this.f8663j instanceof com.google.android.exoplayer2.ui.b) || z.this.A) {
                return;
            }
            ((com.google.android.exoplayer2.ui.b) z.this.f8663j).g(250L);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (z.this.f8655b != null) {
                z.this.f8655b.setVisibility(0);
            }
            if (z.this.f8656c != null) {
                z.this.f8656c.setVisibility(0);
            }
            if (z.this.f8658e != null) {
                z.this.f8658e.setVisibility(z.this.A ? 0 : 4);
            }
            if (!(z.this.f8663j instanceof com.google.android.exoplayer2.ui.b) || z.this.A) {
                return;
            }
            ((com.google.android.exoplayer2.ui.b) z.this.f8663j).t(250L);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.exoplayer2.ui.g f8682a;

        c(com.google.android.exoplayer2.ui.g gVar) {
            this.f8682a = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            z.this.Z(1);
            if (z.this.B) {
                this.f8682a.post(z.this.f8672s);
                z.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            z.this.Z(3);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.exoplayer2.ui.g f8684a;

        d(com.google.android.exoplayer2.ui.g gVar) {
            this.f8684a = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            z.this.Z(2);
            if (z.this.B) {
                this.f8684a.post(z.this.f8672s);
                z.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            z.this.Z(3);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.exoplayer2.ui.g f8686a;

        e(com.google.android.exoplayer2.ui.g gVar) {
            this.f8686a = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            z.this.Z(2);
            if (z.this.B) {
                this.f8686a.post(z.this.f8672s);
                z.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            z.this.Z(3);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            z.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            z.this.Z(4);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            z.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            z.this.Z(4);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (z.this.f8659f != null) {
                z.this.f8659f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (z.this.f8661h != null) {
                z.this.f8661h.setVisibility(0);
                z.this.f8661h.setTranslationX(z.this.f8661h.getWidth());
                z.this.f8661h.scrollTo(z.this.f8661h.getWidth(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlViewLayoutManager.java */
    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (z.this.f8661h != null) {
                z.this.f8661h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (z.this.f8659f != null) {
                z.this.f8659f.setVisibility(0);
            }
        }
    }

    public z(com.google.android.exoplayer2.ui.g gVar) {
        this.f8654a = gVar;
        this.f8655b = gVar.findViewById(y3.k.f36546l);
        this.f8656c = (ViewGroup) gVar.findViewById(y3.k.f36541g);
        this.f8658e = (ViewGroup) gVar.findViewById(y3.k.f36556v);
        ViewGroup viewGroup = (ViewGroup) gVar.findViewById(y3.k.f36539e);
        this.f8657d = viewGroup;
        this.f8662i = (ViewGroup) gVar.findViewById(y3.k.R);
        View viewFindViewById = gVar.findViewById(y3.k.F);
        this.f8663j = viewFindViewById;
        this.f8659f = (ViewGroup) gVar.findViewById(y3.k.f36538d);
        this.f8660g = (ViewGroup) gVar.findViewById(y3.k.f36549o);
        this.f8661h = (ViewGroup) gVar.findViewById(y3.k.f36550p);
        View viewFindViewById2 = gVar.findViewById(y3.k.f36560z);
        this.f8664k = viewFindViewById2;
        View viewFindViewById3 = gVar.findViewById(y3.k.f36559y);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8652a.T(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8652a.T(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.y
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8653a.J(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8642a.K(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = gVar.getResources();
        int i10 = y3.h.f36517b;
        float dimension = resources.getDimension(i10) - resources.getDimension(y3.h.f36518c);
        float dimension2 = resources.getDimension(i10);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8665l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(gVar));
        animatorSet.play(valueAnimatorOfFloat).with(N(0.0f, dimension, viewFindViewById)).with(N(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f8666m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(gVar));
        animatorSet2.play(N(dimension, dimension2, viewFindViewById)).with(N(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f8667n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(gVar));
        animatorSet3.play(valueAnimatorOfFloat).with(N(0.0f, dimension2, viewFindViewById)).with(N(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f8668o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(N(dimension, 0.0f, viewFindViewById)).with(N(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f8669p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(N(dimension2, 0.0f, viewFindViewById)).with(N(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8670q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.q
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8645a.L(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f8671r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8646a.M(valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    private static int B(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f8667n.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Z(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.f8665l.start();
        U(this.f8674u, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f8666m.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f8655b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f8656c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f8658e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f8655b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f8656c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f8658e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private static ObjectAnimator N(float f10, float f11, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f10, f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        boolean zE0 = e0();
        if (this.A != zE0) {
            this.A = zE0;
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8643a.d0();
                }
            });
        }
        boolean z10 = i12 - i10 != i16 - i14;
        if (this.A || !z10) {
            return;
        }
        view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f8644a.S();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        int i10;
        if (this.f8659f == null || this.f8660g == null) {
            return;
        }
        int width = (this.f8654a.getWidth() - this.f8654a.getPaddingLeft()) - this.f8654a.getPaddingRight();
        while (true) {
            if (this.f8660g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f8660g.getChildCount() - 2;
            View childAt = this.f8660g.getChildAt(childCount);
            this.f8660g.removeViewAt(childCount);
            this.f8659f.addView(childAt, 0);
        }
        View view = this.f8664k;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.f8662i);
        int childCount2 = this.f8659f.getChildCount() - 1;
        for (int i11 = 0; i11 < childCount2; i11++) {
            iB += B(this.f8659f.getChildAt(i11));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.f8661h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f8671r.isStarted()) {
                return;
            }
            this.f8670q.cancel();
            this.f8671r.start();
            return;
        }
        View view2 = this.f8664k;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.f8664k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = this.f8659f.getChildAt(i12);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f8659f.removeViews(0, arrayList.size());
        for (i10 = 0; i10 < arrayList.size(); i10++) {
            this.f8660g.addView((View) arrayList.get(i10), this.f8660g.getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(View view) {
        W();
        if (view.getId() == y3.k.f36560z) {
            this.f8670q.start();
        } else if (view.getId() == y3.k.f36559y) {
            this.f8671r.start();
        }
    }

    private void U(Runnable runnable, long j10) {
        if (j10 >= 0) {
            this.f8654a.postDelayed(runnable, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i10) {
        int i11 = this.f8679z;
        this.f8679z = i10;
        if (i10 == 2) {
            this.f8654a.setVisibility(8);
        } else if (i11 == 2) {
            this.f8654a.setVisibility(0);
        }
        if (i11 != i10) {
            this.f8654a.i0();
        }
    }

    private boolean a0(View view) {
        int id = view.getId();
        return id == y3.k.f36539e || id == y3.k.E || id == y3.k.f36558x || id == y3.k.I || id == y3.k.J || id == y3.k.f36551q || id == y3.k.f36552r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (!this.C) {
            Z(0);
            W();
            return;
        }
        int i10 = this.f8679z;
        if (i10 == 1) {
            this.f8668o.start();
        } else if (i10 == 2) {
            this.f8669p.start();
        } else if (i10 == 3) {
            this.B = true;
        } else if (i10 == 4) {
            return;
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        ViewGroup viewGroup = this.f8658e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        if (this.f8663j != null) {
            int dimensionPixelSize = this.f8654a.getResources().getDimensionPixelSize(y3.h.f36519d);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8663j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f8663j.setLayoutParams(marginLayoutParams);
            }
            View view = this.f8663j;
            if (view instanceof com.google.android.exoplayer2.ui.b) {
                com.google.android.exoplayer2.ui.b bVar = (com.google.android.exoplayer2.ui.b) view;
                if (this.A) {
                    bVar.h(true);
                } else {
                    int i10 = this.f8679z;
                    if (i10 == 1) {
                        bVar.h(false);
                    } else if (i10 != 3) {
                        bVar.s();
                    }
                }
            }
        }
        for (View view2 : this.f8678y) {
            view2.setVisibility((this.A && a0(view2)) ? 4 : 0);
        }
    }

    private boolean e0() {
        int width = (this.f8654a.getWidth() - this.f8654a.getPaddingLeft()) - this.f8654a.getPaddingRight();
        int height = (this.f8654a.getHeight() - this.f8654a.getPaddingBottom()) - this.f8654a.getPaddingTop();
        int iB = B(this.f8656c);
        ViewGroup viewGroup = this.f8656c;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f8656c.getPaddingRight() : 0);
        int iZ = z(this.f8656c);
        ViewGroup viewGroup2 = this.f8656c;
        return width <= Math.max(paddingLeft, B(this.f8662i) + B(this.f8664k)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f8656c.getPaddingBottom() : 0)) + (z(this.f8657d) * 2);
    }

    private void y(float f10) {
        if (this.f8661h != null) {
            this.f8661h.setTranslationX((int) (r0.getWidth() * (1.0f - f10)));
        }
        ViewGroup viewGroup = this.f8662i;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f10);
        }
        ViewGroup viewGroup2 = this.f8659f;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f10);
        }
    }

    private static int z(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@Nullable View view) {
        return view != null && this.f8678y.contains(view);
    }

    public void C() {
        int i10 = this.f8679z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        V();
        if (!this.C) {
            E();
        } else if (this.f8679z == 1) {
            H();
        } else {
            D();
        }
    }

    public void F() {
        int i10 = this.f8679z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        V();
        E();
    }

    public boolean I() {
        return this.f8679z == 0 && this.f8654a.h0();
    }

    public void O() {
        this.f8654a.addOnLayoutChangeListener(this.f8677x);
    }

    public void P() {
        this.f8654a.removeOnLayoutChangeListener(this.f8677x);
    }

    public void Q(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.f8655b;
        if (view != null) {
            view.layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    public void V() {
        this.f8654a.removeCallbacks(this.f8676w);
        this.f8654a.removeCallbacks(this.f8673t);
        this.f8654a.removeCallbacks(this.f8675v);
        this.f8654a.removeCallbacks(this.f8674u);
    }

    public void W() {
        if (this.f8679z == 3) {
            return;
        }
        V();
        int showTimeoutMs = this.f8654a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                U(this.f8676w, showTimeoutMs);
            } else if (this.f8679z == 1) {
                U(this.f8674u, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            } else {
                U(this.f8675v, showTimeoutMs);
            }
        }
    }

    public void X(boolean z10) {
        this.C = z10;
    }

    public void Y(@Nullable View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (!z10) {
            view.setVisibility(8);
            this.f8678y.remove(view);
            return;
        }
        if (this.A && a0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f8678y.add(view);
    }

    public void b0() {
        if (!this.f8654a.h0()) {
            this.f8654a.setVisibility(0);
            this.f8654a.s0();
            this.f8654a.n0();
        }
        c0();
    }
}
