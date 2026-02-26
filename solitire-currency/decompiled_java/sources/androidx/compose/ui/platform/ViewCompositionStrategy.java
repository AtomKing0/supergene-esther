package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.poolingcontainer.PoolingContainerListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ViewCompositionStrategy {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final ViewCompositionStrategy getDefault() {
            return DisposeOnDetachedFromWindowOrReleasedFromPool.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class DisposeOnDetachedFromWindow implements ViewCompositionStrategy {
        public static final int $stable = 0;

        @NotNull
        public static final DisposeOnDetachedFromWindow INSTANCE = new DisposeOnDetachedFromWindow();

        private DisposeOnDetachedFromWindow() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View$OnAttachStateChangeListener, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1] */
        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        @NotNull
        public h9.a<v8.k0> installFor(@NotNull final AbstractComposeView view) {
            kotlin.jvm.internal.t.i(view, "view");
            ?? r02 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View v10) {
                    kotlin.jvm.internal.t.i(v10, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View v10) {
                    kotlin.jvm.internal.t.i(v10, "v");
                    view.disposeComposition();
                }
            };
            view.addOnAttachStateChangeListener(r02);
            return new ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$1(view, r02);
        }
    }

    /* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class DisposeOnDetachedFromWindowOrReleasedFromPool implements ViewCompositionStrategy {
        public static final int $stable = 0;

        @NotNull
        public static final DisposeOnDetachedFromWindowOrReleasedFromPool INSTANCE = new DisposeOnDetachedFromWindowOrReleasedFromPool();

        private DisposeOnDetachedFromWindowOrReleasedFromPool() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View$OnAttachStateChangeListener, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1] */
        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        @NotNull
        public h9.a<v8.k0> installFor(@NotNull final AbstractComposeView view) {
            kotlin.jvm.internal.t.i(view, "view");
            ?? r02 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View v10) {
                    kotlin.jvm.internal.t.i(v10, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View v10) {
                    kotlin.jvm.internal.t.i(v10, "v");
                    if (PoolingContainer.isWithinPoolingContainer(view)) {
                        return;
                    }
                    view.disposeComposition();
                }
            };
            view.addOnAttachStateChangeListener(r02);
            PoolingContainerListener poolingContainerListener = new PoolingContainerListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1
                @Override // androidx.customview.poolingcontainer.PoolingContainerListener
                public final void onRelease() {
                    view.disposeComposition();
                }
            };
            PoolingContainer.addPoolingContainerListener(view, poolingContainerListener);
            return new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$1(view, r02, poolingContainerListener);
        }
    }

    /* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class DisposeOnViewTreeLifecycleDestroyed implements ViewCompositionStrategy {
        public static final int $stable = 0;

        @NotNull
        public static final DisposeOnViewTreeLifecycleDestroyed INSTANCE = new DisposeOnViewTreeLifecycleDestroyed();

        private DisposeOnViewTreeLifecycleDestroyed() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$OnAttachStateChangeListener, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1] */
        /* JADX WARN: Type inference failed for: r2v0, types: [T, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$1] */
        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        @NotNull
        public h9.a<v8.k0> installFor(@NotNull final AbstractComposeView view) {
            kotlin.jvm.internal.t.i(view, "view");
            if (!view.isAttachedToWindow()) {
                final kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
                ?? r12 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1
                    /* JADX WARN: Type inference failed for: r4v7, types: [T, h9.a] */
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NotNull View v10) {
                        kotlin.jvm.internal.t.i(v10, "v");
                        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
                        AbstractComposeView abstractComposeView = view;
                        if (lifecycleOwner == null) {
                            throw new IllegalStateException(("View tree for " + abstractComposeView + " has no ViewTreeLifecycleOwner").toString());
                        }
                        kotlin.jvm.internal.t.h(lifecycleOwner, "checkNotNull(ViewTreeLif…                        }");
                        kotlin.jvm.internal.n0<h9.a<v8.k0>> n0Var2 = n0Var;
                        AbstractComposeView abstractComposeView2 = view;
                        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
                        kotlin.jvm.internal.t.h(lifecycle, "lco.lifecycle");
                        n0Var2.f29834a = ViewCompositionStrategy_androidKt.installForLifecycle(abstractComposeView2, lifecycle);
                        view.removeOnAttachStateChangeListener(this);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(@NotNull View v10) {
                        kotlin.jvm.internal.t.i(v10, "v");
                    }
                };
                view.addOnAttachStateChangeListener(r12);
                n0Var.f29834a = new ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$1(view, r12);
                return new ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2(n0Var);
            }
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
            if (lifecycleOwner != null) {
                kotlin.jvm.internal.t.h(lifecycleOwner, "checkNotNull(ViewTreeLif…eOwner\"\n                }");
                Lifecycle lifecycle = lifecycleOwner.getLifecycle();
                kotlin.jvm.internal.t.h(lifecycle, "lco.lifecycle");
                return ViewCompositionStrategy_androidKt.installForLifecycle(view, lifecycle);
            }
            throw new IllegalStateException(("View tree for " + view + " has no ViewTreeLifecycleOwner").toString());
        }
    }

    @NotNull
    h9.a<v8.k0> installFor(@NotNull AbstractComposeView abstractComposeView);

    /* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class DisposeOnLifecycleDestroyed implements ViewCompositionStrategy {
        public static final int $stable = 8;

        @NotNull
        private final Lifecycle lifecycle;

        public DisposeOnLifecycleDestroyed(@NotNull Lifecycle lifecycle) {
            kotlin.jvm.internal.t.i(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
        }

        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        @NotNull
        public h9.a<v8.k0> installFor(@NotNull AbstractComposeView view) {
            kotlin.jvm.internal.t.i(view, "view");
            return ViewCompositionStrategy_androidKt.installForLifecycle(view, this.lifecycle);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public DisposeOnLifecycleDestroyed(@NotNull LifecycleOwner lifecycleOwner) {
            kotlin.jvm.internal.t.i(lifecycleOwner, "lifecycleOwner");
            Lifecycle lifecycle = lifecycleOwner.getLifecycle();
            kotlin.jvm.internal.t.h(lifecycle, "lifecycleOwner.lifecycle");
            this(lifecycle);
        }
    }
}
