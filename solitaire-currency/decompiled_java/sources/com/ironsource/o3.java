package com.ironsource;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.o3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class o3 implements g4 {

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ij f14200a;

        /* JADX INFO: renamed from: com.ironsource.o3$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0264a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14201a;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Lifecycle.Event.ON_STOP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f14201a = iArr;
            }
        }

        public a(@NotNull ij listener) {
            kotlin.jvm.internal.t.i(listener, "listener");
            this.f14200a = listener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Lifecycle.Event event, a this$0) {
            kotlin.jvm.internal.t.i(event, "$event");
            kotlin.jvm.internal.t.i(this$0, "this$0");
            int i10 = C0264a.f14201a[event.ordinal()];
            if (i10 == 1) {
                this$0.f14200a.c();
                return;
            }
            if (i10 == 2) {
                this$0.f14200a.a();
            } else if (i10 == 3) {
                this$0.f14200a.d();
            } else {
                if (i10 != 4) {
                    return;
                }
                this$0.f14200a.b();
            }
        }

        public boolean equals(@Nullable Object obj) {
            ij ijVar = this.f14200a;
            a aVar = obj instanceof a ? (a) obj : null;
            return kotlin.jvm.internal.t.d(ijVar, aVar != null ? aVar.f14200a : null);
        }

        public int hashCode() {
            return this.f14200a.hashCode();
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NotNull LifecycleOwner source, @NotNull final Lifecycle.Event event) {
            kotlin.jvm.internal.t.i(source, "source");
            kotlin.jvm.internal.t.i(event, "event");
            IronSourceThreadManager.postMediationBackgroundTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.py
                @Override // java.lang.Runnable
                public final void run() {
                    o3.a.a(event, this);
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ij observer) {
        kotlin.jvm.internal.t.i(observer, "$observer");
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new a(observer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ij observer) {
        kotlin.jvm.internal.t.i(observer, "$observer");
        ProcessLifecycleOwner.Companion.get().getLifecycle().removeObserver(new a(observer));
    }

    @Override // com.ironsource.g4
    public void a(@NotNull final ij observer) {
        kotlin.jvm.internal.t.i(observer, "observer");
        IronLog.INTERNAL.verbose("Adding lifecycle event observer");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.ny
            @Override // java.lang.Runnable
            public final void run() {
                o3.c(observer);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.g4
    public void b(@NotNull final ij observer) {
        kotlin.jvm.internal.t.i(observer, "observer");
        IronLog.INTERNAL.verbose("Removing lifecycle event observer");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.oy
            @Override // java.lang.Runnable
            public final void run() {
                o3.d(observer);
            }
        }, 0L, 2, null);
    }
}
