package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Layout.kt */
/* JADX INFO: loaded from: classes.dex */
final class FixedSizeIntrinsicsPlaceable extends Placeable {
    public FixedSizeIntrinsicsPlaceable(int i10, int i11) {
        m3015setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i10, i11));
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(@NotNull AlignmentLine alignmentLine) {
        t.i(alignmentLine, "alignmentLine");
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo2988placeAtf8xVGno(long j10, float f10, @Nullable h9.l<? super GraphicsLayerScope, k0> lVar) {
    }
}
