package com.applovin.impl;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class s7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6819a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f6823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f6824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference f6825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f6826h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f6830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f6831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6832n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f6820b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f6821c = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WeakReference f6827i = new WeakReference(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WeakReference f6828j = new WeakReference(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f6833o = Long.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f6822d = new Handler(Looper.getMainLooper());

    public interface a {
        void onLogVisibilityImpression();
    }

    public s7(final View view, com.applovin.impl.sdk.j jVar, a aVar) {
        this.f6819a = jVar.I();
        this.f6826h = ((Long) jVar.a(l4.f5744t1)).longValue();
        this.f6825g = new WeakReference(view);
        final WeakReference weakReference = new WeakReference(aVar);
        this.f6823e = new Runnable() { // from class: com.applovin.impl.md
            @Override // java.lang.Runnable
            public final void run() {
                this.f5904a.a(weakReference);
            }
        };
        this.f6824f = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.nd
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f6433a.a(view);
            }
        };
    }

    private void c(View view) {
        View viewB = q7.b((View) this.f6825g.get());
        if (viewB == null) {
            viewB = q7.b(view);
        }
        if (viewB == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6819a.a("VisibilityTracker", "Unable to set view tree observer due to no root view.");
                return;
            }
            return;
        }
        ViewTreeObserver viewTreeObserver = viewB.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f6827i = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.f6824f);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f6819a.k("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WeakReference weakReference) {
        View view = (View) this.f6825g.get();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View view2 = (View) this.f6828j.get();
        if (viewGroup == null || view2 == null) {
            return;
        }
        if (!a(viewGroup, view2)) {
            a();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f6819a.a("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
        }
        b();
        a aVar = (a) weakReference.get();
        if (aVar != null) {
            aVar.onLogVisibilityImpression();
        }
    }

    public void b() {
        synchronized (this.f6820b) {
            this.f6822d.removeMessages(0);
            b((View) this.f6825g.get());
            this.f6833o = Long.MIN_VALUE;
            this.f6828j.clear();
        }
    }

    private boolean b(View view, View view2) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.f6821c)) {
            return false;
        }
        long jPxToDp = AppLovinSdkUtils.pxToDp(view2.getContext(), this.f6821c.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f6821c.height());
        if (jPxToDp < this.f6829k) {
            return false;
        }
        if ((jPxToDp / (AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getWidth()) * AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getHeight()))) * 100.0f < this.f6830l) {
            return false;
        }
        return (((float) ((long) (this.f6821c.width() * this.f6821c.height()))) / ((float) ((long) (view2.getWidth() * view2.getHeight())))) * 100.0f >= this.f6831m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        a();
        b(view);
        return true;
    }

    public void a(y2 y2Var) {
        View viewK0;
        if (y2Var instanceof s2) {
            viewK0 = y2Var.y();
        } else if (!(y2Var instanceof u2)) {
            return;
        } else {
            viewK0 = ((u2) y2Var).k0();
        }
        a(y2Var.c0(), y2Var.e0(), y2Var.f0(), y2Var.g0(), viewK0);
    }

    private void b(View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f6827i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f6824f);
        } else if (view != null) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnPreDrawListener(this.f6824f);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f6819a.a("VisibilityTracker", "Could not remove on pre-draw listener. View tree observer is not alive.");
            }
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f6819a.a("VisibilityTracker", "Could not remove on pre-draw listener. Root view is null.");
        }
        this.f6827i.clear();
    }

    public void a(int i10, float f10, float f11, long j10, View view) {
        synchronized (this.f6820b) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6819a.a("VisibilityTracker", "Tracking visibility for " + view);
            }
            b();
            WeakReference weakReference = new WeakReference(view);
            this.f6828j = weakReference;
            this.f6829k = i10;
            this.f6830l = f10;
            this.f6831m = f11;
            this.f6832n = j10;
            c((View) weakReference.get());
        }
    }

    private void a() {
        this.f6822d.postDelayed(this.f6823e, this.f6826h);
    }

    private boolean a(View view, View view2) {
        if (!b(view, view2)) {
            return false;
        }
        if (this.f6833o == Long.MIN_VALUE) {
            this.f6833o = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.f6833o >= this.f6832n;
    }
}
