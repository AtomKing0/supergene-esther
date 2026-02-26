package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.InternalComposeUiApi;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeUiApi
public final class WindowRecomposerPolicy {

    @NotNull
    public static final WindowRecomposerPolicy INSTANCE = new WindowRecomposerPolicy();

    @NotNull
    private static final AtomicReference<WindowRecomposerFactory> factory = new AtomicReference<>(WindowRecomposerFactory.Companion.getLifecycleAware());
    public static final int $stable = 8;

    private WindowRecomposerPolicy() {
    }

    public final boolean compareAndSetFactory(@NotNull WindowRecomposerFactory expected, @NotNull WindowRecomposerFactory factory2) {
        kotlin.jvm.internal.t.i(expected, "expected");
        kotlin.jvm.internal.t.i(factory2, "factory");
        return androidx.compose.animation.core.d.a(factory, expected, factory2);
    }

    @NotNull
    public final Recomposer createAndInstallWindowRecomposer$ui_release(@NotNull View rootView) {
        kotlin.jvm.internal.t.i(rootView, "rootView");
        Recomposer recomposerCreateRecomposer = factory.get().createRecomposer(rootView);
        WindowRecomposer_androidKt.setCompositionContext(rootView, recomposerCreateRecomposer);
        kotlinx.coroutines.t1 t1Var = kotlinx.coroutines.t1.f29982a;
        Handler handler = rootView.getHandler();
        kotlin.jvm.internal.t.h(handler, "rootView.handler");
        final kotlinx.coroutines.b2 b2VarD = kotlinx.coroutines.k.d(t1Var, HandlerDispatcherKt.from(handler, "windowRecomposer cleanup").getImmediate(), null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(recomposerCreateRecomposer, rootView, null), 2, null);
        rootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View v10) {
                kotlin.jvm.internal.t.i(v10, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View v10) {
                kotlin.jvm.internal.t.i(v10, "v");
                v10.removeOnAttachStateChangeListener(this);
                b2.a.a(b2VarD, null, 1, null);
            }
        });
        return recomposerCreateRecomposer;
    }

    @NotNull
    public final WindowRecomposerFactory getAndSetFactory(@NotNull WindowRecomposerFactory factory2) {
        kotlin.jvm.internal.t.i(factory2, "factory");
        WindowRecomposerFactory andSet = factory.getAndSet(factory2);
        kotlin.jvm.internal.t.h(andSet, "factory.getAndSet(factory)");
        return andSet;
    }

    public final void setFactory(@NotNull WindowRecomposerFactory factory2) {
        kotlin.jvm.internal.t.i(factory2, "factory");
        factory.set(factory2);
    }

    public final <R> R withFactory(@NotNull WindowRecomposerFactory factory2, @NotNull h9.a<? extends R> block) {
        kotlin.jvm.internal.t.i(factory2, "factory");
        kotlin.jvm.internal.t.i(block, "block");
        WindowRecomposerFactory andSetFactory = getAndSetFactory(factory2);
        try {
            R rInvoke = block.invoke();
            kotlin.jvm.internal.r.b(1);
            if (!compareAndSetFactory(factory2, andSetFactory)) {
                throw new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state");
            }
            kotlin.jvm.internal.r.a(1);
            return rInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.r.b(1);
                if (compareAndSetFactory(factory2, andSetFactory)) {
                    kotlin.jvm.internal.r.a(1);
                    throw th2;
                }
                v8.f.a(th, new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state"));
                throw th;
            }
        }
    }
}
