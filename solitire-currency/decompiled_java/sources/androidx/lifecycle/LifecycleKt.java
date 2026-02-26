package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleKt {
    @NotNull
    public static final LifecycleCoroutineScope getCoroutineScope(@NotNull Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        t.i(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, y2.b(null, 1, null).plus(e1.c().getImmediate()));
        } while (!androidx.compose.animation.core.d.a(lifecycle.getInternalScopeRef(), null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }

    @NotNull
    public static final s9.h<Lifecycle.Event> getEventFlow(@NotNull Lifecycle lifecycle) {
        t.i(lifecycle, "<this>");
        return s9.j.C(s9.j.f(new LifecycleKt$eventFlow$1(lifecycle, null)), e1.c().getImmediate());
    }
}
