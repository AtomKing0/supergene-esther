package com.applovin.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap f6805a = new WeakHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f6806b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f6807c = new Handler();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6808d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference f6809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f6810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f6811g;

    public interface a {
        void a(int i10, int i11);
    }

    public s4(View view) {
        this.f6809e = new WeakReference(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f6810f = null;
            return;
        }
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.kd
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f5564a.b();
            }
        };
        this.f6810f = onPreDrawListener;
        viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        synchronized (this.f6806b) {
            this.f6808d = false;
            int iMin = -1;
            int iMax = -1;
            for (Map.Entry entry : this.f6805a.entrySet()) {
                if (a((View) entry.getKey())) {
                    Integer num = (Integer) entry.getValue();
                    if (iMin == -1 && iMax == -1) {
                        iMin = num.intValue();
                        iMax = num.intValue();
                    } else {
                        iMin = Math.min(iMin, ((Integer) entry.getValue()).intValue());
                        iMax = Math.max(iMax, ((Integer) entry.getValue()).intValue());
                    }
                }
            }
            a aVar = this.f6811g;
            if (aVar != null) {
                aVar.a(iMin, iMax);
            }
        }
    }

    private void d() {
        if (this.f6808d) {
            return;
        }
        this.f6808d = true;
        this.f6807c.postDelayed(new Runnable() { // from class: com.applovin.impl.ld
            @Override // java.lang.Runnable
            public final void run() {
                this.f5835a.c();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b() {
        d();
        return true;
    }

    public void a() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.f6811g = null;
        View view = (View) this.f6809e.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onPreDrawListener = this.f6810f) != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            this.f6809e.clear();
        }
    }

    public void b(View view) {
        synchronized (this.f6806b) {
            this.f6805a.remove(view);
        }
    }

    public void a(a aVar) {
        this.f6811g = aVar;
    }

    public void a(View view, int i10) {
        synchronized (this.f6806b) {
            this.f6805a.put(view, Integer.valueOf(i10));
            d();
        }
    }

    private boolean a(View view) {
        return (view == null || view.getVisibility() != 0 || view.getParent() == null) ? false : true;
    }
}
