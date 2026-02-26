package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VerticalAlignmentLine extends AlignmentLine {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalAlignmentLine(@NotNull p<? super Integer, ? super Integer, Integer> merger) {
        super(merger, null);
        t.i(merger, "merger");
    }
}
