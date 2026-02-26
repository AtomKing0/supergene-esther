package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ironsource.w8;
import io.sentry.Breadcrumb;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.a9;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.c1;
import io.sentry.f1;
import io.sentry.internal.gestures.b;
import io.sentry.l0;
import io.sentry.p1;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.q8;
import io.sentry.util.k0;
import io.sentry.y8;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: compiled from: SentryGestureListener.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class g implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final WeakReference<Activity> f27247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final f1 f27248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private io.sentry.internal.gestures.b f27250d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private p1 f27251e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private b f27252f = b.Unknown;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f27253g = new c(null);

    /* JADX INFO: compiled from: SentryGestureListener.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27254a;

        static {
            int[] iArr = new int[b.values().length];
            f27254a = iArr;
            try {
                iArr[b.Click.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27254a[b.Scroll.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27254a[b.Swipe.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27254a[b.Unknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SentryGestureListener.java */
    private enum b {
        Click,
        Scroll,
        Swipe,
        Unknown
    }

    public g(@NotNull Activity activity, @NotNull f1 f1Var, @NotNull SentryAndroidOptions sentryAndroidOptions) {
        this.f27247a = new WeakReference<>(activity);
        this.f27248b = f1Var;
        this.f27249c = sentryAndroidOptions;
    }

    private void e(@NotNull io.sentry.internal.gestures.b bVar, @NotNull b bVar2, @NotNull Map<String, Object> map, @NotNull MotionEvent motionEvent) {
        if (this.f27249c.isEnableUserInteractionBreadcrumbs()) {
            String strJ = j(bVar2);
            l0 l0Var = new l0();
            l0Var.j("android:motionEvent", motionEvent);
            l0Var.j("android:view", bVar.f());
            this.f27248b.addBreadcrumb(Breadcrumb.userInteraction(strJ, bVar.d(), bVar.a(), bVar.e(), map), l0Var);
        }
    }

    @Nullable
    private View h(@NotNull String str) {
        Activity activity = this.f27247a.get();
        if (activity == null) {
            this.f27249c.getLogger().c(SentryLevel.DEBUG, "Activity is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            this.f27249c.getLogger().c(SentryLevel.DEBUG, "Window is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            return decorView;
        }
        this.f27249c.getLogger().c(SentryLevel.DEBUG, "DecorView is null in " + str + ". No breadcrumb captured.", new Object[0]);
        return null;
    }

    @NotNull
    private String i(@NotNull Activity activity) {
        return activity.getClass().getSimpleName();
    }

    @NotNull
    private static String j(@NotNull b bVar) {
        int i10 = a.f27254a[bVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "unknown" : "swipe" : "scroll" : w8.f16021d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(c1 c1Var, p1 p1Var, p1 p1Var2) {
        if (p1Var2 == null) {
            c1Var.setTransaction(p1Var);
        } else {
            this.f27249c.getLogger().c(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", p1Var.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(c1 c1Var, p1 p1Var) {
        if (p1Var == this.f27251e) {
            c1Var.clearTransaction();
        }
    }

    private void p(@NotNull io.sentry.internal.gestures.b bVar, @NotNull b bVar2) {
        boolean z10 = (bVar2 == b.Click) || !(bVar2 == this.f27252f && bVar.equals(this.f27250d));
        if (!this.f27249c.isTracingEnabled() || !this.f27249c.isEnableUserInteractionTracing()) {
            if (z10) {
                if (this.f27249c.isEnableAutoTraceIdGeneration()) {
                    k0.r(this.f27248b);
                }
                this.f27250d = bVar;
                this.f27252f = bVar2;
                return;
            }
            return;
        }
        Activity activity = this.f27247a.get();
        if (activity == null) {
            this.f27249c.getLogger().c(SentryLevel.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
            return;
        }
        String strB = bVar.b();
        p1 p1Var = this.f27251e;
        if (p1Var != null) {
            if (!z10 && !p1Var.isFinished()) {
                this.f27249c.getLogger().c(SentryLevel.DEBUG, "The view with id: " + strB + " already has an ongoing transaction assigned. Rescheduling finish", new Object[0]);
                if (this.f27249c.getIdleTimeout() != null) {
                    this.f27251e.q();
                    return;
                }
                return;
            }
            q(q8.OK);
        }
        String str = i(activity) + "." + strB;
        String str2 = "ui.action." + j(bVar2);
        a9 a9Var = new a9();
        a9Var.v(true);
        a9Var.s(30000L);
        a9Var.t(this.f27249c.getIdleTimeout());
        a9Var.i(true);
        a9Var.g("auto.ui.gesture_listener." + bVar.c());
        final p1 p1VarJ = this.f27248b.J(new y8(str, TransactionNameSource.COMPONENT, str2), a9Var);
        this.f27248b.n(new ScopeCallback() { // from class: io.sentry.android.core.internal.gestures.d
            @Override // io.sentry.ScopeCallback
            public final void run(c1 c1Var) {
                this.f27240a.m(p1VarJ, c1Var);
            }
        });
        this.f27251e = p1VarJ;
        this.f27250d = bVar;
        this.f27252f = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull final c1 c1Var, @NotNull final p1 p1Var) {
        c1Var.withTransaction(new Scope.c() { // from class: io.sentry.android.core.internal.gestures.e
            @Override // io.sentry.Scope.c
            public final void a(p1 p1Var2) {
                this.f27242a.k(c1Var, p1Var, p1Var2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull final c1 c1Var) {
        c1Var.withTransaction(new Scope.c() { // from class: io.sentry.android.core.internal.gestures.f
            @Override // io.sentry.Scope.c
            public final void a(p1 p1Var) {
                this.f27245a.l(c1Var, p1Var);
            }
        });
    }

    public void o(@NotNull MotionEvent motionEvent) {
        View viewH = h("onUp");
        io.sentry.internal.gestures.b bVar = this.f27253g.f27256b;
        if (viewH == null || bVar == null) {
            return;
        }
        if (this.f27253g.f27255a == b.Unknown) {
            this.f27249c.getLogger().c(SentryLevel.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
            return;
        }
        e(bVar, this.f27253g.f27255a, Collections.singletonMap("direction", this.f27253g.i(motionEvent)), motionEvent);
        p(bVar, this.f27253g.f27255a);
        this.f27253g.j();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@Nullable MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.f27253g.j();
        this.f27253g.f27257c = motionEvent.getX();
        this.f27253g.f27258d = motionEvent.getY();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(@Nullable MotionEvent motionEvent, @Nullable MotionEvent motionEvent2, float f10, float f11) {
        this.f27253g.f27255a = b.Swipe;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(@Nullable MotionEvent motionEvent, @Nullable MotionEvent motionEvent2, float f10, float f11) {
        View viewH = h("onScroll");
        if (viewH != null && motionEvent != null && this.f27253g.f27255a == b.Unknown) {
            io.sentry.internal.gestures.b bVarA = j.a(this.f27249c, viewH, motionEvent.getX(), motionEvent.getY(), b.a.SCROLLABLE);
            if (bVarA == null) {
                this.f27249c.getLogger().c(SentryLevel.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            this.f27249c.getLogger().c(SentryLevel.DEBUG, "Scroll target found: " + bVarA.b(), new Object[0]);
            this.f27253g.k(bVarA);
            this.f27253g.f27255a = b.Scroll;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@Nullable MotionEvent motionEvent) {
        View viewH = h("onSingleTapUp");
        if (viewH != null && motionEvent != null) {
            io.sentry.internal.gestures.b bVarA = j.a(this.f27249c, viewH, motionEvent.getX(), motionEvent.getY(), b.a.CLICKABLE);
            if (bVarA == null) {
                this.f27249c.getLogger().c(SentryLevel.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            b bVar = b.Click;
            e(bVarA, bVar, Collections.emptyMap(), motionEvent);
            p(bVarA, bVar);
        }
        return false;
    }

    void q(@NotNull q8 q8Var) {
        p1 p1Var = this.f27251e;
        if (p1Var != null) {
            if (p1Var.getStatus() == null) {
                this.f27251e.k(q8Var);
            } else {
                this.f27251e.finish();
            }
        }
        this.f27248b.n(new ScopeCallback() { // from class: io.sentry.android.core.internal.gestures.c
            @Override // io.sentry.ScopeCallback
            public final void run(c1 c1Var) {
                this.f27239a.n(c1Var);
            }
        });
        this.f27251e = null;
        if (this.f27250d != null) {
            this.f27250d = null;
        }
        this.f27252f = b.Unknown;
    }

    /* JADX INFO: compiled from: SentryGestureListener.java */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private b f27255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private io.sentry.internal.gestures.b f27256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f27257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f27258d;

        private c() {
            this.f27255a = b.Unknown;
            this.f27257c = 0.0f;
            this.f27258d = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public String i(MotionEvent motionEvent) {
            float x10 = motionEvent.getX() - this.f27257c;
            float y10 = motionEvent.getY() - this.f27258d;
            return Math.abs(x10) > Math.abs(y10) ? x10 > 0.0f ? TtmlNode.RIGHT : TtmlNode.LEFT : y10 > 0.0f ? "down" : "up";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            this.f27256b = null;
            this.f27255a = b.Unknown;
            this.f27257c = 0.0f;
            this.f27258d = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(@NotNull io.sentry.internal.gestures.b bVar) {
            this.f27256b = bVar;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
