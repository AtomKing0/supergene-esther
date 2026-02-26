package androidx.compose.ui.draw;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class DrawResult {
    public static final int $stable = 8;

    @NotNull
    private l<? super ContentDrawScope, k0> block;

    public DrawResult(@NotNull l<? super ContentDrawScope, k0> block) {
        t.i(block, "block");
        this.block = block;
    }

    @NotNull
    public final l<ContentDrawScope, k0> getBlock$ui_release() {
        return this.block;
    }

    public final void setBlock$ui_release(@NotNull l<? super ContentDrawScope, k0> lVar) {
        t.i(lVar, "<set-?>");
        this.block = lVar;
    }
}
