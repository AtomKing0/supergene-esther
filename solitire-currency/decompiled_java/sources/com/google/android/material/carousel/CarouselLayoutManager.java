package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.f;
import e4.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements com.google.android.material.carousel.b, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    int f9011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    int f9012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    int f9013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f9015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    private com.google.android.material.carousel.d f9016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private g f9017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private f f9018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Map<Integer, f> f9020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.google.android.material.carousel.c f9021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View.OnLayoutChangeListener f9022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f9023m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9024n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9025o;

    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f9017g == null || !CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f9017g == null || CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int i10) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i10);
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f9027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f9028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f9029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final d f9030d;

        b(View view, float f10, float f11, d dVar) {
            this.f9027a = view;
            this.f9028b = f10;
            this.f9029c = f11;
            this.f9030d = dVar;
        }
    }

    private static class c extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Paint f9031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<f.c> f9032b;

        c() {
            Paint paint = new Paint();
            this.f9031a = paint;
            this.f9032b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        void a(List<f.c> list) {
            this.f9032b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.f9031a.setStrokeWidth(recyclerView.getResources().getDimension(e4.d.f24795n));
            for (f.c cVar : this.f9032b) {
                this.f9031a.setColor(ColorUtils.blendARGB(-65281, -16776961, cVar.f9063c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).d()) {
                    canvas.drawLine(cVar.f9062b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).K(), cVar.f9062b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).F(), this.f9031a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).H(), cVar.f9062b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).I(), cVar.f9062b, this.f9031a);
                }
            }
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f.c f9033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final f.c f9034b;

        d(f.c cVar, f.c cVar2) {
            Preconditions.checkArgument(cVar.f9061a <= cVar2.f9061a);
            this.f9033a = cVar;
            this.f9034b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new i());
    }

    private int A() {
        int i10;
        int i11;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.f9021k.f9043a == 0) {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i10 + i11;
    }

    private f B(int i10) {
        f fVar;
        Map<Integer, f> map = this.f9020j;
        return (map == null || (fVar = map.get(Integer.valueOf(MathUtils.clamp(i10, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f9017g.g() : fVar;
    }

    private int C() {
        if (getClipToPadding() || !this.f9016f.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingTop() : getPaddingLeft();
    }

    private float D(float f10, d dVar) {
        f.c cVar = dVar.f9033a;
        float f11 = cVar.f9064d;
        f.c cVar2 = dVar.f9034b;
        return f4.a.b(f11, cVar2.f9064d, cVar.f9062b, cVar2.f9062b, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F() {
        return this.f9021k.g();
    }

    private int G() {
        return this.f9021k.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H() {
        return this.f9021k.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        return this.f9021k.j();
    }

    private int J() {
        return this.f9021k.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K() {
        return this.f9021k.l();
    }

    private int L() {
        if (getClipToPadding() || !this.f9016f.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingBottom() : getPaddingRight();
    }

    private int M(int i10, f fVar) {
        return P() ? (int) (((y() - fVar.h().f9061a) - (i10 * fVar.f())) - (fVar.f() / 2.0f)) : (int) (((i10 * fVar.f()) - fVar.a().f9061a) + (fVar.f() / 2.0f));
    }

    private int N(int i10, @NonNull f fVar) {
        int i11 = Integer.MAX_VALUE;
        for (f.c cVar : fVar.e()) {
            float f10 = (i10 * fVar.f()) + (fVar.f() / 2.0f);
            int iY = (P() ? (int) ((y() - cVar.f9061a) - f10) : (int) (f10 - cVar.f9061a)) - this.f9011a;
            if (Math.abs(i11) > Math.abs(iY)) {
                i11 = iY;
            }
        }
        return i11;
    }

    private static d O(List<f.c> list, float f10, boolean z10) {
        float f11 = Float.MAX_VALUE;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        float f12 = -3.4028235E38f;
        float f13 = Float.MAX_VALUE;
        float f14 = Float.MAX_VALUE;
        for (int i14 = 0; i14 < list.size(); i14++) {
            f.c cVar = list.get(i14);
            float f15 = z10 ? cVar.f9062b : cVar.f9061a;
            float fAbs = Math.abs(f15 - f10);
            if (f15 <= f10 && fAbs <= f11) {
                i10 = i14;
                f11 = fAbs;
            }
            if (f15 > f10 && fAbs <= f13) {
                i12 = i14;
                f13 = fAbs;
            }
            if (f15 <= f14) {
                i11 = i14;
                f14 = f15;
            }
            if (f15 > f12) {
                i13 = i14;
                f12 = f15;
            }
        }
        if (i10 == -1) {
            i10 = i11;
        }
        if (i12 == -1) {
            i12 = i13;
        }
        return new d(list.get(i10), list.get(i12));
    }

    private boolean Q(float f10, d dVar) {
        float fN = n(f10, D(f10, dVar) / 2.0f);
        if (P()) {
            if (fN < 0.0f) {
                return true;
            }
        } else if (fN > y()) {
            return true;
        }
        return false;
    }

    private boolean R(float f10, d dVar) {
        float fM = m(f10, D(f10, dVar) / 2.0f);
        if (P()) {
            if (fM > y()) {
                return true;
            }
        } else if (fM < 0.0f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
            return;
        }
        view.post(new Runnable() { // from class: i4.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f26587a.X();
            }
        });
    }

    private void T() {
        if (this.f9014d && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                Log.d("CarouselLayoutManager", "item position " + getPosition(childAt) + ", center:" + z(childAt) + ", child index:" + i10);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    private b U(RecyclerView.Recycler recycler, float f10, int i10) {
        View viewForPosition = recycler.getViewForPosition(i10);
        measureChildWithMargins(viewForPosition, 0, 0);
        float fM = m(f10, this.f9018h.f() / 2.0f);
        d dVarO = O(this.f9018h.g(), fM, false);
        return new b(viewForPosition, fM, r(viewForPosition, fM, dVarO), dVarO);
    }

    private float V(View view, float f10, float f11, Rect rect) {
        float fM = m(f10, f11);
        d dVarO = O(this.f9018h.g(), fM, false);
        float fR = r(view, fM, dVarO);
        super.getDecoratedBoundsWithMargins(view, rect);
        d0(view, fM, dVarO);
        this.f9021k.o(view, rect, f11, fR);
        return fR;
    }

    private void W(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        f fVarG = this.f9016f.g(this, viewForPosition);
        if (P()) {
            fVarG = f.n(fVarG, y());
        }
        this.f9017g = g.f(this, fVarG, A(), C(), L());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.f9017g = null;
        requestLayout();
    }

    private void Y(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float fZ = z(childAt);
            if (!R(fZ, O(this.f9018h.g(), fZ, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float fZ2 = z(childAt2);
            if (!Q(fZ2, O(this.f9018h.g(), fZ2, true))) {
                return;
            } else {
                removeAndRecycleView(childAt2, recycler);
            }
        }
    }

    private void Z(RecyclerView recyclerView, int i10) {
        if (d()) {
            recyclerView.scrollBy(i10, 0);
        } else {
            recyclerView.scrollBy(0, i10);
        }
    }

    private void b0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f24927b0);
            a0(typedArrayObtainStyledAttributes.getInt(k.f24935c0, 0));
            setOrientation(typedArrayObtainStyledAttributes.getInt(k.f24963f4, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
        int orientation = getOrientation();
        if (i10 == 1) {
            return -1;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 17) {
            if (orientation == 0) {
                return P() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i10 == 33) {
            return orientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 66) {
            if (orientation == 0) {
                return P() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i10 == 130) {
            return orientation == 1 ? 1 : Integer.MIN_VALUE;
        }
        Log.d("CarouselLayoutManager", "Unknown focus request:" + i10);
        return Integer.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d0(View view, float f10, d dVar) {
        if (view instanceof h) {
            f.c cVar = dVar.f9033a;
            float f11 = cVar.f9063c;
            f.c cVar2 = dVar.f9034b;
            float fB = f4.a.b(f11, cVar2.f9063c, cVar.f9061a, cVar2.f9061a, f10);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFF = this.f9021k.f(height, width, f4.a.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), f4.a.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fR = r(view, f10, dVar);
            RectF rectF = new RectF(fR - (rectFF.width() / 2.0f), fR - (rectFF.height() / 2.0f), fR + (rectFF.width() / 2.0f), (rectFF.height() / 2.0f) + fR);
            RectF rectF2 = new RectF(H(), K(), I(), F());
            if (this.f9016f.f()) {
                this.f9021k.a(rectFF, rectF, rectF2);
            }
            this.f9021k.n(rectFF, rectF, rectF2);
            ((h) view).a(rectFF);
        }
    }

    private void e0(@NonNull g gVar) {
        int i10 = this.f9013c;
        int i11 = this.f9012b;
        if (i10 <= i11) {
            this.f9018h = P() ? gVar.h() : gVar.l();
        } else {
            this.f9018h = gVar.j(this.f9011a, i11, i10);
        }
        this.f9015e.a(this.f9018h.g());
    }

    private void f0() {
        int itemCount = getItemCount();
        int i10 = this.f9023m;
        if (itemCount == i10 || this.f9017g == null) {
            return;
        }
        if (this.f9016f.h(this, i10)) {
            X();
        }
        this.f9023m = itemCount;
    }

    private void g0() {
        if (!this.f9014d || getChildCount() < 1) {
            return;
        }
        int i10 = 0;
        while (i10 < getChildCount() - 1) {
            int position = getPosition(getChildAt(i10));
            int i11 = i10 + 1;
            int position2 = getPosition(getChildAt(i11));
            if (position > position2) {
                T();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i10 + "] had adapter position [" + position + "] and child at index [" + i11 + "] had adapter position [" + position2 + "].");
            }
            i10 = i11;
        }
    }

    private View getChildClosestToEnd() {
        return getChildAt(P() ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(P() ? getChildCount() - 1 : 0);
    }

    private void l(View view, int i10, b bVar) {
        float f10 = this.f9018h.f() / 2.0f;
        addView(view, i10);
        float f11 = bVar.f9029c;
        this.f9021k.m(view, (int) (f11 - f10), (int) (f11 + f10));
        d0(view, bVar.f9028b, bVar.f9030d);
    }

    private float m(float f10, float f11) {
        return P() ? f10 - f11 : f10 + f11;
    }

    private float n(float f10, float f11) {
        return P() ? f10 + f11 : f10 - f11;
    }

    private void o(@NonNull RecyclerView.Recycler recycler, int i10, int i11) {
        if (i10 < 0 || i10 >= getItemCount()) {
            return;
        }
        b bVarU = U(recycler, s(i10), i10);
        l(bVarU.f9027a, i11, bVarU);
    }

    private void p(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        float fS = s(i10);
        while (i10 < state.getItemCount()) {
            b bVarU = U(recycler, fS, i10);
            if (Q(bVarU.f9029c, bVarU.f9030d)) {
                return;
            }
            fS = m(fS, this.f9018h.f());
            if (!R(bVarU.f9029c, bVarU.f9030d)) {
                l(bVarU.f9027a, -1, bVarU);
            }
            i10++;
        }
    }

    private void q(RecyclerView.Recycler recycler, int i10) {
        float fS = s(i10);
        while (i10 >= 0) {
            b bVarU = U(recycler, fS, i10);
            if (R(bVarU.f9029c, bVarU.f9030d)) {
                return;
            }
            fS = n(fS, this.f9018h.f());
            if (!Q(bVarU.f9029c, bVarU.f9030d)) {
                l(bVarU.f9027a, 0, bVarU);
            }
            i10--;
        }
    }

    private float r(View view, float f10, d dVar) {
        f.c cVar = dVar.f9033a;
        float f11 = cVar.f9062b;
        f.c cVar2 = dVar.f9034b;
        float fB = f4.a.b(f11, cVar2.f9062b, cVar.f9061a, cVar2.f9061a, f10);
        if (dVar.f9034b != this.f9018h.c() && dVar.f9033a != this.f9018h.j()) {
            return fB;
        }
        float fE = this.f9021k.e((RecyclerView.LayoutParams) view.getLayoutParams()) / this.f9018h.f();
        f.c cVar3 = dVar.f9034b;
        return fB + ((f10 - cVar3.f9061a) * ((1.0f - cVar3.f9063c) + fE));
    }

    private float s(int i10) {
        return m(J() - this.f9011a, this.f9018h.f() * i10);
    }

    private int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        if (this.f9017g == null) {
            W(recycler);
        }
        int iV = v(i10, this.f9011a, this.f9012b, this.f9013c);
        this.f9011a += iV;
        e0(this.f9017g);
        float f10 = this.f9018h.f() / 2.0f;
        float fS = s(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        float f11 = P() ? this.f9018h.h().f9062b : this.f9018h.a().f9062b;
        float f12 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            float fAbs = Math.abs(f11 - V(childAt, fS, f10, rect));
            if (childAt != null && fAbs < f12) {
                this.f9024n = getPosition(childAt);
                f12 = fAbs;
            }
            fS = m(fS, this.f9018h.f());
        }
        x(recycler, state);
        return iV;
    }

    private int t(RecyclerView.State state, g gVar) {
        boolean zP = P();
        f fVarL = zP ? gVar.l() : gVar.h();
        f.c cVarA = zP ? fVarL.a() : fVarL.h();
        int itemCount = (int) (((((state.getItemCount() - 1) * fVarL.f()) * (zP ? -1.0f : 1.0f)) - (cVarA.f9061a - J())) + (G() - cVarA.f9061a) + (zP ? -cVarA.f9067g : cVarA.f9068h));
        return zP ? Math.min(0, itemCount) : Math.max(0, itemCount);
    }

    private static int v(int i10, int i11, int i12, int i13) {
        int i14 = i11 + i10;
        return i14 < i12 ? i12 - i11 : i14 > i13 ? i13 - i11 : i10;
    }

    private int w(@NonNull g gVar) {
        boolean zP = P();
        f fVarH = zP ? gVar.h() : gVar.l();
        return (int) (J() - n((zP ? fVarH.h() : fVarH.a()).f9061a, fVarH.f() / 2.0f));
    }

    private void x(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Y(recycler);
        if (getChildCount() == 0) {
            q(recycler, this.f9019i - 1);
            p(recycler, state, this.f9019i);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            q(recycler, position - 1);
            p(recycler, state, position2 + 1);
        }
        g0();
    }

    private int y() {
        return d() ? a() : b();
    }

    private float z(View view) {
        super.getDecoratedBoundsWithMargins(view, new Rect());
        return d() ? r0.centerX() : r0.centerY();
    }

    int E(int i10, @NonNull f fVar) {
        return M(i10, fVar) - this.f9011a;
    }

    boolean P() {
        return d() && getLayoutDirection() == 1;
    }

    @Override // com.google.android.material.carousel.b
    public int a() {
        return getWidth();
    }

    public void a0(int i10) {
        this.f9025o = i10;
        X();
    }

    @Override // com.google.android.material.carousel.b
    public int b() {
        return getHeight();
    }

    @Override // com.google.android.material.carousel.b
    public int c() {
        return this.f9025o;
    }

    public void c0(@NonNull com.google.android.material.carousel.d dVar) {
        this.f9016f = dVar;
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        if (getChildCount() == 0 || this.f9017g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f9017g.g().f() / computeHorizontalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return this.f9011a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return this.f9013c - this.f9012b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    @Nullable
    public PointF computeScrollVectorForPosition(int i10) {
        if (this.f9017g == null) {
            return null;
        }
        int iE = E(i10, B(i10));
        return d() ? new PointF(iE, 0.0f) : new PointF(0.0f, iE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        if (getChildCount() == 0 || this.f9017g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f9017g.g().f() / computeVerticalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return this.f9011a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return this.f9013c - this.f9012b;
    }

    @Override // com.google.android.material.carousel.b
    public boolean d() {
        return this.f9021k.f9043a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterY = rect.centerY();
        if (d()) {
            fCenterY = rect.centerX();
        }
        float fD = D(fCenterY, O(this.f9018h.g(), fCenterY, true));
        float fWidth = d() ? (rect.width() - fD) / 2.0f : 0.0f;
        float fHeight = d() ? 0.0f : (rect.height() - fD) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public int getOrientation() {
        return this.f9021k.f9043a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(@NonNull View view, int i10, int i11) {
        if (!(view instanceof h)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i12 = i10 + rect.left + rect.right;
        int i13 = i11 + rect.top + rect.bottom;
        g gVar = this.f9017g;
        float f10 = (gVar == null || this.f9021k.f9043a != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : gVar.g().f();
        g gVar2 = this.f9017g;
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i12, (int) f10, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i13, (int) ((gVar2 == null || this.f9021k.f9043a != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : gVar2.g().f()), canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f9016f.e(recyclerView.getContext());
        X();
        recyclerView.addOnLayoutChangeListener(this.f9022l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.f9022l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(@NonNull View view, int i10, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int iConvertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            o(recycler, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        }
        if (getPosition(view) == getItemCount() - 1) {
            return null;
        }
        o(recycler, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return getChildClosestToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || y() <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.f9019i = 0;
            return;
        }
        boolean zP = P();
        boolean z10 = this.f9017g == null;
        if (z10) {
            W(recycler);
        }
        int iW = w(this.f9017g);
        int iT = t(state, this.f9017g);
        this.f9012b = zP ? iT : iW;
        if (zP) {
            iT = iW;
        }
        this.f9013c = iT;
        if (z10) {
            this.f9011a = iW;
            this.f9020j = this.f9017g.i(getItemCount(), this.f9012b, this.f9013c, P());
            int i10 = this.f9024n;
            if (i10 != -1) {
                this.f9011a = M(i10, B(i10));
            }
        }
        int i11 = this.f9011a;
        this.f9011a = i11 + v(0, i11, this.f9012b, this.f9013c);
        this.f9019i = MathUtils.clamp(this.f9019i, 0, state.getItemCount());
        e0(this.f9017g);
        detachAndScrapAttachedViews(recycler);
        x(recycler, state);
        this.f9023m = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.f9019i = 0;
        } else {
            this.f9019i = getPosition(getChildAt(0));
        }
        g0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z10, boolean z11) {
        int iN;
        if (this.f9017g == null || (iN = N(getPosition(view), B(getPosition(view)))) == 0) {
            return false;
        }
        Z(recyclerView, N(getPosition(view), this.f9017g.j(this.f9011a + v(iN, this.f9011a, this.f9012b, this.f9013c), this.f9012b, this.f9013c)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i10, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        this.f9024n = i10;
        if (this.f9017g == null) {
            return;
        }
        this.f9011a = M(i10, B(i10));
        this.f9019i = MathUtils.clamp(i10, 0, Math.max(0, getItemCount() - 1));
        e0(this.f9017g);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i10, recycler, state);
        }
        return 0;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        com.google.android.material.carousel.c cVar = this.f9021k;
        if (cVar == null || i10 != cVar.f9043a) {
            this.f9021k = com.google.android.material.carousel.c.c(this, i10);
            X();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    int u(int i10) {
        return (int) (this.f9011a - M(i10, B(i10)));
    }

    public CarouselLayoutManager(@NonNull com.google.android.material.carousel.d dVar) {
        this(dVar, 0);
    }

    public CarouselLayoutManager(@NonNull com.google.android.material.carousel.d dVar, int i10) {
        this.f9014d = false;
        this.f9015e = new c();
        this.f9019i = 0;
        this.f9022l = new View.OnLayoutChangeListener() { // from class: i4.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                this.f26586a.S(view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f9024n = -1;
        this.f9025o = 0;
        c0(dVar);
        setOrientation(i10);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f9014d = false;
        this.f9015e = new c();
        this.f9019i = 0;
        this.f9022l = new View.OnLayoutChangeListener() { // from class: i4.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i112, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                this.f26586a.S(view, i112, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f9024n = -1;
        this.f9025o = 0;
        c0(new i());
        b0(context, attributeSet);
    }
}
