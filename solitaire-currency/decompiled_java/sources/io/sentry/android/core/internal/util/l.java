package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import io.sentry.android.core.w0;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FirstDrawDoneListener.java */
/* JADX INFO: loaded from: classes5.dex */
public class l implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Handler f27316a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final AtomicReference<View> f27317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Runnable f27318c;

    /* JADX INFO: compiled from: FirstDrawDoneListener.java */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(l.this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private l(@NotNull View view, @NotNull Runnable runnable) {
        this.f27317b = new AtomicReference<>(view);
        this.f27318c = runnable;
    }

    private static boolean c(@NotNull View view) {
        return view.getViewTreeObserver().isAlive() && view.isAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Window window, Window.Callback callback, Runnable runnable, w0 w0Var) {
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView != null) {
            window.setCallback(callback);
            g(viewPeekDecorView, runnable, w0Var);
        }
    }

    public static void f(@NotNull Activity activity, @NotNull final Runnable runnable, @NotNull final w0 w0Var) {
        final Window window = activity.getWindow();
        if (window != null) {
            View viewPeekDecorView = window.peekDecorView();
            if (viewPeekDecorView != null) {
                g(viewPeekDecorView, runnable, w0Var);
            } else {
                final Window.Callback callback = window.getCallback();
                window.setCallback(new io.sentry.android.core.performance.j(callback != null ? callback : new io.sentry.android.core.internal.gestures.b(), new Runnable() { // from class: io.sentry.android.core.internal.util.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.e(window, callback, runnable, w0Var);
                    }
                }));
            }
        }
    }

    public static void g(@NotNull View view, @NotNull Runnable runnable, @NotNull w0 w0Var) {
        l lVar = new l(view, runnable);
        if (w0Var.d() >= 26 || c(view)) {
            view.getViewTreeObserver().addOnDrawListener(lVar);
        } else {
            view.addOnAttachStateChangeListener(lVar.new a());
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View andSet = this.f27317b.getAndSet(null);
        if (andSet == null) {
            return;
        }
        andSet.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.sentry.android.core.internal.util.k
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f27314a.d(andSet);
            }
        });
        this.f27316a.postAtFrontOfQueue(this.f27318c);
    }
}
