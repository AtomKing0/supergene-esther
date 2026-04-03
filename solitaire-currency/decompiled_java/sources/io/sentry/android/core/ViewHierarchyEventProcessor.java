package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.media3.exoplayer.ExoPlayer;
import io.sentry.SentryLevel;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.r6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class ViewHierarchyEventProcessor implements io.sentry.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.internal.util.h f27115b = new io.sentry.android.core.internal.util.h(io.sentry.android.core.internal.util.b.b(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, 3);

    public ViewHierarchyEventProcessor(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        this.f27114a = (SentryAndroidOptions) io.sentry.util.w.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        if (sentryAndroidOptions.isAttachViewHierarchy()) {
            io.sentry.util.p.a("ViewHierarchy");
        }
    }

    private static void d(@NotNull View view, @NotNull ViewHierarchyNode viewHierarchyNode, @NotNull List<io.sentry.internal.viewhierarchy.a> list) {
        if (view instanceof ViewGroup) {
            Iterator<io.sentry.internal.viewhierarchy.a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().a(viewHierarchyNode, view)) {
                    return;
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(childCount);
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    ViewHierarchyNode viewHierarchyNodeH = h(childAt);
                    arrayList.add(viewHierarchyNodeH);
                    d(childAt, viewHierarchyNodeH, list);
                }
            }
            viewHierarchyNode.setChildren(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(AtomicReference atomicReference, View view, List list, CountDownLatch countDownLatch, io.sentry.w0 w0Var) {
        try {
            atomicReference.set(g(view, list));
            countDownLatch.countDown();
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Failed to process view hierarchy.", th);
        }
    }

    @Nullable
    public static ViewHierarchy f(@Nullable Activity activity, @NotNull final List<io.sentry.internal.viewhierarchy.a> list, @NotNull io.sentry.util.thread.a aVar, @NotNull final io.sentry.w0 w0Var) {
        if (activity == null) {
            w0Var.c(SentryLevel.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            w0Var.c(SentryLevel.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        final View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            w0Var.c(SentryLevel.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        try {
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Failed to process view hierarchy.", th);
        }
        if (aVar.a()) {
            return g(viewPeekDecorView, list);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference(null);
        activity.runOnUiThread(new Runnable() { // from class: io.sentry.android.core.p2
            @Override // java.lang.Runnable
            public final void run() {
                ViewHierarchyEventProcessor.e(atomicReference, viewPeekDecorView, list, countDownLatch, w0Var);
            }
        });
        if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
            return (ViewHierarchy) atomicReference.get();
        }
        return null;
    }

    @NotNull
    public static ViewHierarchy g(@NotNull View view, @NotNull List<io.sentry.internal.viewhierarchy.a> list) {
        ArrayList arrayList = new ArrayList(1);
        ViewHierarchy viewHierarchy = new ViewHierarchy("android_view_system", arrayList);
        ViewHierarchyNode viewHierarchyNodeH = h(view);
        arrayList.add(viewHierarchyNodeH);
        d(view, viewHierarchyNodeH, list);
        return viewHierarchy;
    }

    @NotNull
    private static ViewHierarchyNode h(@NotNull View view) {
        ViewHierarchyNode viewHierarchyNode = new ViewHierarchyNode();
        viewHierarchyNode.setType(io.sentry.android.core.internal.util.e.a(view));
        try {
            viewHierarchyNode.setIdentifier(io.sentry.android.core.internal.gestures.j.b(view));
        } catch (Throwable unused) {
        }
        viewHierarchyNode.setX(Double.valueOf(view.getX()));
        viewHierarchyNode.setY(Double.valueOf(view.getY()));
        viewHierarchyNode.setWidth(Double.valueOf(view.getWidth()));
        viewHierarchyNode.setHeight(Double.valueOf(view.getHeight()));
        viewHierarchyNode.setAlpha(Double.valueOf(view.getAlpha()));
        int visibility = view.getVisibility();
        if (visibility == 0) {
            viewHierarchyNode.setVisibility("visible");
        } else if (visibility == 4) {
            viewHierarchyNode.setVisibility("invisible");
        } else if (visibility == 8) {
            viewHierarchyNode.setVisibility("gone");
        }
        return viewHierarchyNode;
    }

    @Override // io.sentry.g0
    @NotNull
    public r6 a(@NotNull r6 r6Var, @NotNull io.sentry.l0 l0Var) {
        ViewHierarchy viewHierarchyF;
        if (!r6Var.s()) {
            return r6Var;
        }
        if (!this.f27114a.isAttachViewHierarchy()) {
            this.f27114a.getLogger().c(SentryLevel.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
            return r6Var;
        }
        if (io.sentry.util.m.i(l0Var)) {
            return r6Var;
        }
        boolean zA = this.f27115b.a();
        this.f27114a.getBeforeViewHierarchyCaptureCallback();
        if (!zA && (viewHierarchyF = f(f1.c().b(), this.f27114a.getViewHierarchyExporters(), this.f27114a.getThreadChecker(), this.f27114a.getLogger())) != null) {
            l0Var.m(io.sentry.b.c(viewHierarchyF));
        }
        return r6Var;
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 11000L;
    }

    @Override // io.sentry.g0
    @NotNull
    public SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @NotNull io.sentry.l0 l0Var) {
        return sentryTransaction;
    }
}
