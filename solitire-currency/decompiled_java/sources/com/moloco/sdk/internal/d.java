package com.moloco.sdk.internal;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements com.moloco.sdk.internal.a, LifecycleOwner, SavedStateRegistryOwner {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17598c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final LifecycleRegistry f17599a = new LifecycleRegistry(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final SavedStateRegistryController f17600b = SavedStateRegistryController.Companion.create(this);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends kotlin.jvm.internal.v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ View f17601g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d f17602h;

        public static final class a implements View.OnAttachStateChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f17603a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f17604b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f17605c;

            public a(View view, d dVar, View view2) {
                this.f17603a = view;
                this.f17604b = dVar;
                this.f17605c = view2;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View view) {
                kotlin.jvm.internal.t.i(view, "view");
                this.f17603a.removeOnAttachStateChangeListener(this);
                this.f17604b.g(this.f17605c);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View view) {
                kotlin.jvm.internal.t.i(view, "view");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, d dVar) {
            super(0);
            this.f17601g = view;
            this.f17602h = dVar;
        }

        public final void b() {
            View view = this.f17601g;
            d dVar = this.f17602h;
            if (ViewCompat.isAttachedToWindow(view)) {
                dVar.g(view);
            } else {
                view.addOnAttachStateChangeListener(new a(view, dVar, view));
            }
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    @Override // com.moloco.sdk.internal.a
    public void a(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        com.moloco.sdk.internal.scheduling.e.a(new b(view, this));
    }

    @Override // com.moloco.sdk.internal.a
    public void b(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        View rootView = view.getRootView();
        if (rootView == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "RootView is absent, skipping", null, false, 12, null);
            return;
        }
        if (kotlin.jvm.internal.t.d(ViewTreeSavedStateRegistryOwner.get(rootView), this)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "Removing ViewTreeSavedStateRegistryOwner", null, false, 12, null);
            ViewTreeSavedStateRegistryOwner.set(rootView, null);
        }
        if (f(rootView)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "Removing ViewTreeLifecycleOwner", null, false, 12, null);
            ViewTreeLifecycleOwner.set(rootView, null);
        }
    }

    @Override // com.moloco.sdk.internal.a
    public void c(@NotNull View view) {
        Object objB;
        kotlin.jvm.internal.t.i(view, "view");
        View resume$lambda$7 = view.getRootView();
        kotlin.jvm.internal.t.h(resume$lambda$7, "resume$lambda$7");
        if (f(resume$lambda$7)) {
            try {
                t.a aVar = v8.t.f35208b;
                this.f17599a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                objB = v8.t.b(k0.f35197a);
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            if (v8.t.h(objB)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "lifecycle resume success", null, false, 12, null);
            }
            Throwable thE = v8.t.e(objB);
            if (thE != null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "lifecycle resume failure", thE, false, 8, null);
            }
        }
    }

    @Override // com.moloco.sdk.internal.a
    public void d(@NotNull View view) {
        Object objB;
        kotlin.jvm.internal.t.i(view, "view");
        View pause$lambda$9 = view.getRootView();
        kotlin.jvm.internal.t.h(pause$lambda$9, "pause$lambda$9");
        if (f(pause$lambda$9)) {
            try {
                t.a aVar = v8.t.f35208b;
                this.f17599a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                objB = v8.t.b(k0.f35197a);
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "lifecycle pause success " + v8.t.h(objB), v8.t.e(objB), false, 8, null);
        }
    }

    public final boolean f(View view) {
        return kotlin.jvm.internal.t.d(ViewTreeLifecycleOwner.get(view), this);
    }

    public final void g(View view) {
        View rootView = view.getRootView();
        if (rootView == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "RootView is absent, skipping", null, false, 12, null);
            return;
        }
        if (ViewTreeSavedStateRegistryOwner.get(rootView) == null) {
            ViewTreeSavedStateRegistryOwner.set(rootView, this);
            try {
                t.a aVar = v8.t.f35208b;
                this.f17600b.performRestore(null);
                v8.t.b(k0.f35197a);
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                v8.t.b(v8.u.a(th));
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "ViewTreeSavedStateRegistryOwner is absent, setting custom one", null, false, 12, null);
        }
        if (ViewTreeLifecycleOwner.get(rootView) == null) {
            ViewTreeLifecycleOwner.set(rootView, this);
            this.f17599a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            this.f17599a.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.f17599a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "ViewLifecycleOwner", "ViewTreeLifecycleOwner is absent, setting custom one", null, false, 12, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.f17599a;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NotNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f17600b.getSavedStateRegistry();
    }
}
