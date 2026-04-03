package androidx.window.layout;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;
import androidx.window.core.Bounds;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowMetrics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowMetrics {

    @NotNull
    private final Bounds _bounds;

    public WindowMetrics(@NotNull Bounds _bounds) {
        t.i(_bounds, "_bounds");
        this._bounds = _bounds;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(WindowMetrics.class, obj.getClass())) {
            return false;
        }
        return t.d(this._bounds, ((WindowMetrics) obj)._bounds);
    }

    @NotNull
    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public int hashCode() {
        return this._bounds.hashCode();
    }

    @NotNull
    public String toString() {
        return "WindowMetrics { bounds: " + getBounds() + " }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowMetrics(@NotNull Rect bounds) {
        this(new Bounds(bounds));
        t.i(bounds, "bounds");
    }
}
