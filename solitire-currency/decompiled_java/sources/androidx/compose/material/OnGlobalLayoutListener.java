package androidx.compose.material;

import android.view.View;
import android.view.ViewTreeObserver;
import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
final class OnGlobalLayoutListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    private boolean isListeningToGlobalLayout;

    @NotNull
    private final a<k0> onGlobalLayoutCallback;

    @NotNull
    private final View view;

    public OnGlobalLayoutListener(@NotNull View view, @NotNull a<k0> onGlobalLayoutCallback) {
        t.i(view, "view");
        t.i(onGlobalLayoutCallback, "onGlobalLayoutCallback");
        this.view = view;
        this.onGlobalLayoutCallback = onGlobalLayoutCallback;
        view.addOnAttachStateChangeListener(this);
        registerOnGlobalLayoutListener();
    }

    private final void registerOnGlobalLayoutListener() {
        if (this.isListeningToGlobalLayout || !this.view.isAttachedToWindow()) {
            return;
        }
        this.view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.isListeningToGlobalLayout = true;
    }

    private final void unregisterOnGlobalLayoutListener() {
        if (this.isListeningToGlobalLayout) {
            this.view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.isListeningToGlobalLayout = false;
        }
    }

    public final void dispose() {
        unregisterOnGlobalLayoutListener();
        this.view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.onGlobalLayoutCallback.invoke();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View p02) {
        t.i(p02, "p0");
        registerOnGlobalLayoutListener();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View p02) {
        t.i(p02, "p0");
        unregisterOnGlobalLayoutListener();
    }
}
