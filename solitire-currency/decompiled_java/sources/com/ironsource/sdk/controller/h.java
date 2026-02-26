package com.ironsource.sdk.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.ce;
import com.ironsource.el;
import com.ironsource.i9;
import com.ironsource.kn;
import com.ironsource.n5;
import com.ironsource.sdk.controller.v;

/* JADX INFO: loaded from: classes4.dex */
public class h extends FrameLayout implements kn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f15022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ce f15023c;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.addView(h.this);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.removeView(h.this);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f15023c = el.N().f();
        this.f15021a = context;
        setClickable(true);
    }

    private void b() {
        ((Activity) this.f15021a).runOnUiThread(new b());
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.f15021a;
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (this.f15023c.E(activity) == 1) {
                int i10 = rect.bottom - rect2.bottom;
                if (i10 > 0) {
                    return i10;
                }
                return 0;
            }
            int i11 = rect.right - rect2.right;
            if (i11 > 0) {
                return i11;
            }
            return 0;
        } catch (Exception e10) {
            i9.d().a(e10);
            return 0;
        }
    }

    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    private int getStatusBarHeight() {
        int identifier;
        try {
            Context context = this.f15021a;
            if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                return this.f15021a.getResources().getDimensionPixelSize(identifier);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
        }
        return 0;
    }

    private int getStatusBarPadding() {
        int statusBarHeight;
        if (!((((Activity) this.f15021a).getWindow().getAttributes().flags & 1024) != 0) && (statusBarHeight = getStatusBarHeight()) > 0) {
            return statusBarHeight;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.f15021a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f15022b.F();
        this.f15022b.a(true, "main");
    }

    @Override // com.ironsource.kn
    public boolean onBackButtonPressed() {
        return n5.a().a((Activity) this.f15021a);
    }

    @Override // com.ironsource.kn
    public void onCloseRequested() {
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15022b.B();
        this.f15022b.a(false, "main");
        v vVar = this.f15022b;
        if (vVar != null) {
            vVar.a(v.u.Gone);
            this.f15022b.C();
            this.f15022b.D();
        }
        removeAllViews();
    }

    private void a() {
        ((Activity) this.f15021a).runOnUiThread(new a());
    }

    private void a(int i10, int i11) {
        try {
            Context context = this.f15021a;
            if (context != null) {
                int iE = this.f15023c.E(context);
                if (iE == 1) {
                    setPadding(0, i10, 0, i11);
                } else if (iE == 2) {
                    setPadding(0, i10, i11, 0);
                }
            }
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }

    public void a(v vVar) {
        this.f15022b = vVar;
        vVar.a(this);
        this.f15022b.E();
        this.f15021a = this.f15022b.q();
        a(getStatusBarPadding(), getNavigationBarPadding());
        a();
    }

    @Override // com.ironsource.kn
    public void onOrientationChanged(String str, int i10) {
    }
}
