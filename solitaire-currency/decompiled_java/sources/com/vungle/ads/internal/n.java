package com.vungle.ads.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.vungle.ads.internal.util.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImpressionTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {
    private static final int MIN_VISIBILITY_PERCENTAGE = 1;
    private static final int VISIBILITY_THROTTLE_MILLIS = 100;

    @NotNull
    private final Rect clipRect;
    private boolean isVisibilityScheduled;

    @NotNull
    private final ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    private boolean setViewTreeObserverSucceed;

    @NotNull
    private final Map<View, c> trackedViews;

    @NotNull
    private final Handler visibilityHandler;

    @NotNull
    private final d visibilityRunnable;

    @NotNull
    private WeakReference<ViewTreeObserver> weakViewTreeObserver;

    @NotNull
    public static final a Companion = new a(null);
    private static final String TAG = n.class.getSimpleName();

    /* JADX INFO: compiled from: ImpressionTracker.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ImpressionTracker.kt */
    public interface b {
        void onImpression(@Nullable View view);

        void onViewInvisible(@Nullable View view);
    }

    /* JADX INFO: compiled from: ImpressionTracker.kt */
    @VisibleForTesting
    public static final class c {

        @Nullable
        private b impressionListener;
        private int minViewablePercent;

        @Nullable
        public final b getImpressionListener() {
            return this.impressionListener;
        }

        public final int getMinViewablePercent() {
            return this.minViewablePercent;
        }

        public final void setImpressionListener(@Nullable b bVar) {
            this.impressionListener = bVar;
        }

        public final void setMinViewablePercent(int i10) {
            this.minViewablePercent = i10;
        }
    }

    /* JADX INFO: compiled from: ImpressionTracker.kt */
    @VisibleForTesting
    public final class d implements Runnable {

        @NotNull
        private final ArrayList<View> visibleViews = new ArrayList<>();

        @NotNull
        private final ArrayList<View> invisibleViews = new ArrayList<>();

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b impressionListener;
            b impressionListener2;
            n.this.isVisibilityScheduled = false;
            for (Map.Entry entry : n.this.trackedViews.entrySet()) {
                View view = (View) entry.getKey();
                if (n.this.isVisible(view, ((c) entry.getValue()).getMinViewablePercent())) {
                    this.visibleViews.add(view);
                } else {
                    this.invisibleViews.add(view);
                }
            }
            for (View view2 : this.visibleViews) {
                c cVar = (c) n.this.trackedViews.get(view2);
                if (cVar != null && (impressionListener2 = cVar.getImpressionListener()) != null) {
                    impressionListener2.onImpression(view2);
                }
                n nVar = n.this;
                kotlin.jvm.internal.t.h(view2, "view");
                nVar.removeView(view2);
            }
            this.visibleViews.clear();
            for (View view3 : this.invisibleViews) {
                c cVar2 = (c) n.this.trackedViews.get(view3);
                if (cVar2 != null && (impressionListener = cVar2.getImpressionListener()) != null) {
                    impressionListener.onViewInvisible(view3);
                }
            }
            this.invisibleViews.clear();
            if (!(!n.this.trackedViews.isEmpty()) || n.this.setViewTreeObserverSucceed) {
                return;
            }
            n.this.scheduleVisibilityCheck();
        }
    }

    @VisibleForTesting
    public n(@NotNull Context context, @NotNull Map<View, c> trackedViews, @NotNull Handler visibilityHandler) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(trackedViews, "trackedViews");
        kotlin.jvm.internal.t.i(visibilityHandler, "visibilityHandler");
        this.trackedViews = trackedViews;
        this.visibilityHandler = visibilityHandler;
        this.clipRect = new Rect();
        this.visibilityRunnable = new d();
        this.onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.vungle.ads.internal.m
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return n.m4065_init_$lambda0(this.f24347a);
            }
        };
        this.weakViewTreeObserver = new WeakReference<>(null);
        this.setViewTreeObserverSucceed = setViewTreeObserver(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    public static final boolean m4065_init_$lambda0(n this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.scheduleVisibilityCheck();
        return true;
    }

    private final View getTopView(Context context, View view) {
        View viewFindViewById = context instanceof Activity ? ((Activity) context).getWindow().getDecorView().findViewById(R.id.content) : null;
        if (viewFindViewById != null || view == null) {
            return viewFindViewById;
        }
        if (!ViewCompat.isAttachedToWindow(view)) {
            p.a aVar = com.vungle.ads.internal.util.p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.w(TAG2, "Trying to call View#rootView() on an unattached View.");
        }
        View rootView = view.getRootView();
        if (rootView != null) {
            viewFindViewById = rootView.findViewById(R.id.content);
        }
        return viewFindViewById == null ? rootView : viewFindViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVisible(View view, int i10) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        while (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.getVisibility() != 0) {
                com.vungle.ads.internal.util.p.Companion.w("ImpressionTracker", "Parent visibility is not visible: " + parent);
                return false;
            }
            parent = viewGroup.getParent();
        }
        if (!view.getGlobalVisibleRect(this.clipRect)) {
            return false;
        }
        long jHeight = ((long) this.clipRect.height()) * ((long) this.clipRect.width());
        long height = ((long) view.getHeight()) * ((long) view.getWidth());
        return height > 0 && ((long) 100) * jHeight >= ((long) i10) * height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleVisibilityCheck() {
        if (this.isVisibilityScheduled) {
            return;
        }
        this.isVisibilityScheduled = true;
        this.visibilityHandler.postDelayed(this.visibilityRunnable, 100L);
    }

    private final boolean setViewTreeObserver(Context context, View view) {
        ViewTreeObserver viewTreeObserver = this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            return true;
        }
        View topView = getTopView(context, view);
        if (topView == null) {
            p.a aVar = com.vungle.ads.internal.util.p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.d(TAG2, "Unable to set ViewTreeObserver due to no available root view.");
            return false;
        }
        ViewTreeObserver viewTreeObserver2 = topView.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            this.weakViewTreeObserver = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.onPreDrawListener);
            return true;
        }
        p.a aVar2 = com.vungle.ads.internal.util.p.Companion;
        String TAG3 = TAG;
        kotlin.jvm.internal.t.h(TAG3, "TAG");
        aVar2.d(TAG3, "The root view tree observer was not alive");
        return false;
    }

    public final void addView(@NotNull View view, @Nullable b bVar) {
        kotlin.jvm.internal.t.i(view, "view");
        this.setViewTreeObserverSucceed = setViewTreeObserver(view.getContext(), view);
        c cVar = this.trackedViews.get(view);
        if (cVar == null) {
            cVar = new c();
            this.trackedViews.put(view, cVar);
            scheduleVisibilityCheck();
        }
        cVar.setMinViewablePercent(1);
        cVar.setImpressionListener(bVar);
    }

    public final void clear() {
        this.trackedViews.clear();
        this.visibilityHandler.removeMessages(0);
        this.isVisibilityScheduled = false;
    }

    public final void destroy() {
        clear();
        ViewTreeObserver viewTreeObserver = this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.onPreDrawListener);
        }
        this.weakViewTreeObserver.clear();
    }

    @NotNull
    public final ViewTreeObserver.OnPreDrawListener getOnPreDrawListener() {
        return this.onPreDrawListener;
    }

    @NotNull
    public final WeakReference<ViewTreeObserver> getWeakViewTreeObserver() {
        return this.weakViewTreeObserver;
    }

    @VisibleForTesting
    public final void removeView(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        this.trackedViews.remove(view);
    }

    public final void setWeakViewTreeObserver(@NotNull WeakReference<ViewTreeObserver> weakReference) {
        kotlin.jvm.internal.t.i(weakReference, "<set-?>");
        this.weakViewTreeObserver = weakReference;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(@NotNull Context context) {
        this(context, new WeakHashMap(10), new Handler());
        kotlin.jvm.internal.t.i(context, "context");
    }

    @VisibleForTesting
    public static /* synthetic */ void getOnPreDrawListener$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getWeakViewTreeObserver$annotations() {
    }
}
