package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.os.Build;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Lifecycle f21452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final LifecycleEventObserver f21453b;

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a$a, reason: collision with other inner class name */
    public static final class C0469a implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21455b;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0470a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f21456a;

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
                f21456a = iArr;
            }
        }

        public C0469a(h9.a<k0> aVar, h9.a<k0> aVar2) {
            this.f21454a = aVar;
            this.f21455b = aVar2;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
            t.i(lifecycleOwner, "<anonymous parameter 0>");
            t.i(event, "event");
            int i10 = C0470a.f21456a[event.ordinal()];
            if (i10 == 1) {
                if (Build.VERSION.SDK_INT > 23) {
                    this.f21454a.invoke();
                }
            } else if (i10 == 2) {
                if (Build.VERSION.SDK_INT <= 23) {
                    this.f21454a.invoke();
                }
            } else if (i10 == 3) {
                if (Build.VERSION.SDK_INT <= 23) {
                    this.f21455b.invoke();
                }
            } else if (i10 == 4 && Build.VERSION.SDK_INT > 23) {
                this.f21455b.invoke();
            }
        }
    }

    public a(@NotNull Lifecycle lifecycle, @NotNull h9.a<k0> onExoResume, @NotNull h9.a<k0> onExoPause) {
        t.i(lifecycle, "lifecycle");
        t.i(onExoResume, "onExoResume");
        t.i(onExoPause, "onExoPause");
        this.f21452a = lifecycle;
        C0469a c0469a = new C0469a(onExoResume, onExoPause);
        this.f21453b = c0469a;
        lifecycle.addObserver(c0469a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        this.f21452a.removeObserver(this.f21453b);
    }
}
