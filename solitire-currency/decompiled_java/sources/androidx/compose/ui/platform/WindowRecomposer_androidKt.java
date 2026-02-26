package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i0;

/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowRecomposer_androidKt {

    @NotNull
    private static final Map<Context, s9.m0<Float>> animationScale = new LinkedHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [z8.g] */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, androidx.compose.ui.platform.MotionDurationScaleImpl] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r10v3, types: [z8.g] */
    @ExperimentalComposeUiApi
    @NotNull
    public static final Recomposer createLifecycleAwareWindowRecomposer(@NotNull final View view, @NotNull z8.g coroutineContext, @Nullable Lifecycle lifecycle) {
        final PausableMonotonicFrameClock pausableMonotonicFrameClock;
        kotlin.jvm.internal.t.i(view, "<this>");
        kotlin.jvm.internal.t.i(coroutineContext, "coroutineContext");
        if (coroutineContext.get(z8.e.R7) == null || coroutineContext.get(MonotonicFrameClock.Key) == null) {
            coroutineContext = AndroidUiDispatcher.Companion.getCurrentThread().plus(coroutineContext);
        }
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) coroutineContext.get(MonotonicFrameClock.Key);
        if (monotonicFrameClock != null) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(monotonicFrameClock);
            pausableMonotonicFrameClock2.pause();
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        } else {
            pausableMonotonicFrameClock = null;
        }
        final kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.Key);
        ?? r02 = motionDurationScale;
        if (motionDurationScale == null) {
            ?? motionDurationScaleImpl = new MotionDurationScaleImpl();
            n0Var.f29834a = motionDurationScaleImpl;
            r02 = motionDurationScaleImpl;
        }
        z8.g gVarPlus = coroutineContext.plus(pausableMonotonicFrameClock != null ? pausableMonotonicFrameClock : z8.h.f37608a).plus(r02);
        final Recomposer recomposer = new Recomposer(gVarPlus);
        final kotlinx.coroutines.o0 o0VarA = kotlinx.coroutines.p0.a(gVarPlus);
        if (lifecycle == null) {
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
            lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
        }
        if (lifecycle != null) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View v10) {
                    kotlin.jvm.internal.t.i(v10, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View v10) {
                    kotlin.jvm.internal.t.i(v10, "v");
                    view.removeOnAttachStateChangeListener(this);
                    recomposer.cancel();
                }
            });
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer.2

                /* JADX INFO: renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$WhenMappings */
                /* JADX INFO: compiled from: WindowRecomposer.android.kt */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[Lifecycle.Event.values().length];
                        iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                        iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                        iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner2, @NotNull Lifecycle.Event event) {
                    kotlin.jvm.internal.t.i(lifecycleOwner2, "lifecycleOwner");
                    kotlin.jvm.internal.t.i(event, "event");
                    int i10 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                    if (i10 == 1) {
                        kotlinx.coroutines.k.d(o0VarA, null, kotlinx.coroutines.q0.UNDISPATCHED, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(n0Var, recomposer, lifecycleOwner2, this, view, null), 1, null);
                        return;
                    }
                    if (i10 == 2) {
                        PausableMonotonicFrameClock pausableMonotonicFrameClock3 = pausableMonotonicFrameClock;
                        if (pausableMonotonicFrameClock3 != null) {
                            pausableMonotonicFrameClock3.resume();
                            return;
                        }
                        return;
                    }
                    if (i10 != 3) {
                        if (i10 != 4) {
                            return;
                        }
                        recomposer.cancel();
                    } else {
                        PausableMonotonicFrameClock pausableMonotonicFrameClock4 = pausableMonotonicFrameClock;
                        if (pausableMonotonicFrameClock4 != null) {
                            pausableMonotonicFrameClock4.pause();
                        }
                    }
                }
            });
            return recomposer;
        }
        throw new IllegalStateException(("ViewTreeLifecycleOwner not found from " + view).toString());
    }

    public static /* synthetic */ Recomposer createLifecycleAwareWindowRecomposer$default(View view, z8.g gVar, Lifecycle lifecycle, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        if ((i10 & 2) != 0) {
            lifecycle = null;
        }
        return createLifecycleAwareWindowRecomposer(view, gVar, lifecycle);
    }

    @Nullable
    public static final CompositionContext findViewTreeCompositionContext(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "<this>");
        CompositionContext compositionContext = getCompositionContext(view);
        if (compositionContext != null) {
            return compositionContext;
        }
        for (ViewParent parent = view.getParent(); compositionContext == null && (parent instanceof View); parent = parent.getParent()) {
            compositionContext = getCompositionContext((View) parent);
        }
        return compositionContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    public static final s9.m0<Float> getAnimationScaleFlowFor(Context context) {
        s9.m0<Float> m0Var;
        Map<Context, s9.m0<Float>> map = animationScale;
        synchronized (map) {
            s9.m0<Float> m0VarL = map.get(context);
            if (m0VarL == null) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                final r9.d dVarB = r9.g.b(-1, null, null, 6, null);
                final Handler handlerCreateAsync = HandlerCompat.createAsync(Looper.getMainLooper());
                m0VarL = s9.j.L(s9.j.z(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(contentResolver, uriFor, new ContentObserver(handlerCreateAsync) { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z10, @Nullable Uri uri) {
                        dVarB.f(v8.k0.f35197a);
                    }
                }, dVarB, context, null)), kotlinx.coroutines.p0.b(), i0.a.b(s9.i0.f33702a, 0L, 0L, 3, null), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                map.put(context, m0VarL);
            }
            m0Var = m0VarL;
        }
        return m0Var;
    }

    @Nullable
    public static final CompositionContext getCompositionContext(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "<this>");
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    private static final View getContentChild(View view) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view;
            }
            parent = view2.getParent();
            view = view2;
        }
        return view;
    }

    @NotNull
    public static final Recomposer getWindowRecomposer(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "<this>");
        if (!view.isAttachedToWindow()) {
            throw new IllegalStateException(("Cannot locate windowRecomposer; View " + view + " is not attached to a window").toString());
        }
        View contentChild = getContentChild(view);
        CompositionContext compositionContext = getCompositionContext(contentChild);
        if (compositionContext == null) {
            return WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui_release(contentChild);
        }
        if (compositionContext instanceof Recomposer) {
            return (Recomposer) compositionContext;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static final void setCompositionContext(@NotNull View view, @Nullable CompositionContext compositionContext) {
        kotlin.jvm.internal.t.i(view, "<this>");
        view.setTag(R.id.androidx_compose_ui_view_composition_context, compositionContext);
    }

    public static /* synthetic */ void getWindowRecomposer$annotations(View view) {
    }
}
