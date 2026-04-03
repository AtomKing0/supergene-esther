package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class VNode {
    public static final int $stable = 8;

    @Nullable
    private h9.a<k0> invalidateListener;

    private VNode() {
    }

    public /* synthetic */ VNode(k kVar) {
        this();
    }

    public abstract void draw(@NotNull DrawScope drawScope);

    @Nullable
    public h9.a<k0> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public final void invalidate() {
        h9.a<k0> invalidateListener$ui_release = getInvalidateListener$ui_release();
        if (invalidateListener$ui_release != null) {
            invalidateListener$ui_release.invoke();
        }
    }

    public void setInvalidateListener$ui_release(@Nullable h9.a<k0> aVar) {
        this.invalidateListener = aVar;
    }
}
