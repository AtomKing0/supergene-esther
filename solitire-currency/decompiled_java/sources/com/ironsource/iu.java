package com.ironsource;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class iu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final jn f12663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private View f12664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener f12666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ViewTreeObserver.OnWindowFocusChangeListener f12667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Rect f12668f;

    public iu(@NotNull jn onVisibilityChangeListener) {
        kotlin.jvm.internal.t.i(onVisibilityChangeListener, "onVisibilityChangeListener");
        this.f12663a = onVisibilityChangeListener;
        this.f12666d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ironsource.ww
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                iu.a(this.f16069a);
            }
        };
        this.f12667e = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.ironsource.xw
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z10) {
                iu.a(this.f16209a, z10);
            }
        };
        this.f12668f = new Rect();
    }

    private final void a() {
        boolean zC = c();
        if (this.f12665c != zC) {
            this.f12665c = zC;
            this.f12663a.a(zC);
        }
    }

    public final void a(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        this.f12664b = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f12666d);
        view.getViewTreeObserver().addOnWindowFocusChangeListener(this.f12667e);
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        View view = this.f12664b;
        if (view != null && (viewTreeObserver2 = view.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.f12666d);
        }
        View view2 = this.f12664b;
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.f12667e);
        }
        this.f12664b = null;
    }

    public final boolean c() {
        View view = this.f12664b;
        if (!(view != null && view.isShown())) {
            return false;
        }
        View view2 = this.f12664b;
        if (!(view2 != null && view2.hasWindowFocus())) {
            return false;
        }
        View view3 = this.f12664b;
        return view3 != null && view3.getGlobalVisibleRect(this.f12668f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(iu this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(iu this$0, boolean z10) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.a();
    }
}
