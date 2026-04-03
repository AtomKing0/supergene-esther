package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNodeWithAdjustedBounds {

    @NotNull
    private final Rect adjustedBounds;

    @NotNull
    private final SemanticsNode semanticsNode;

    public SemanticsNodeWithAdjustedBounds(@NotNull SemanticsNode semanticsNode, @NotNull Rect adjustedBounds) {
        kotlin.jvm.internal.t.i(semanticsNode, "semanticsNode");
        kotlin.jvm.internal.t.i(adjustedBounds, "adjustedBounds");
        this.semanticsNode = semanticsNode;
        this.adjustedBounds = adjustedBounds;
    }

    @NotNull
    public final Rect getAdjustedBounds() {
        return this.adjustedBounds;
    }

    @NotNull
    public final SemanticsNode getSemanticsNode() {
        return this.semanticsNode;
    }
}
