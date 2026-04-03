package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsets.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {

    @NotNull
    private final WindowInsetsHolder composeInsets;
    private boolean prepared;

    @Nullable
    private WindowInsetsCompat savedInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsetsListener(@NotNull WindowInsetsHolder composeInsets) {
        super(!composeInsets.getConsumes() ? 1 : 0);
        t.i(composeInsets, "composeInsets");
        this.composeInsets = composeInsets;
    }

    @NotNull
    public final WindowInsetsHolder getComposeInsets() {
        return this.composeInsets;
    }

    public final boolean getPrepared() {
        return this.prepared;
    }

    @Nullable
    public final WindowInsetsCompat getSavedInsets() {
        return this.savedInsets;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    @NotNull
    public WindowInsetsCompat onApplyWindowInsets(@NotNull View view, @NotNull WindowInsetsCompat insets) {
        t.i(view, "view");
        t.i(insets, "insets");
        if (this.prepared) {
            this.savedInsets = insets;
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
            return insets;
        }
        WindowInsetsHolder.update$default(this.composeInsets, insets, 0, 2, null);
        if (!this.composeInsets.getConsumes()) {
            return insets;
        }
        WindowInsetsCompat CONSUMED = WindowInsetsCompat.CONSUMED;
        t.h(CONSUMED, "CONSUMED");
        return CONSUMED;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(@NotNull WindowInsetsAnimationCompat animation) {
        t.i(animation, "animation");
        this.prepared = false;
        WindowInsetsCompat windowInsetsCompat = this.savedInsets;
        if (animation.getDurationMillis() != 0 && windowInsetsCompat != null) {
            this.composeInsets.update(windowInsetsCompat, animation.getTypeMask());
        }
        this.savedInsets = null;
        super.onEnd(animation);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(@NotNull WindowInsetsAnimationCompat animation) {
        t.i(animation, "animation");
        this.prepared = true;
        super.onPrepare(animation);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NotNull
    public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
        t.i(insets, "insets");
        t.i(runningAnimations, "runningAnimations");
        WindowInsetsHolder.update$default(this.composeInsets, insets, 0, 2, null);
        if (!this.composeInsets.getConsumes()) {
            return insets;
        }
        WindowInsetsCompat CONSUMED = WindowInsetsCompat.CONSUMED;
        t.h(CONSUMED, "CONSUMED");
        return CONSUMED;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NotNull
    public WindowInsetsAnimationCompat.BoundsCompat onStart(@NotNull WindowInsetsAnimationCompat animation, @NotNull WindowInsetsAnimationCompat.BoundsCompat bounds) {
        t.i(animation, "animation");
        t.i(bounds, "bounds");
        this.prepared = false;
        WindowInsetsAnimationCompat.BoundsCompat boundsCompatOnStart = super.onStart(animation, bounds);
        t.h(boundsCompatOnStart, "super.onStart(animation, bounds)");
        return boundsCompatOnStart;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        t.i(view, "view");
        view.requestApplyInsets();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v10) {
        t.i(v10, "v");
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prepared) {
            this.prepared = false;
            WindowInsetsCompat windowInsetsCompat = this.savedInsets;
            if (windowInsetsCompat != null) {
                WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, null);
                this.savedInsets = null;
            }
        }
    }

    public final void setPrepared(boolean z10) {
        this.prepared = z10;
    }

    public final void setSavedInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.savedInsets = windowInsetsCompat;
    }
}
