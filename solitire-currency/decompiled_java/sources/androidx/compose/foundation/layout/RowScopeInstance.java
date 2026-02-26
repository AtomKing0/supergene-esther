package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.SiblingsAlignedModifier;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Row.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RowScopeInstance implements RowScope {

    @NotNull
    public static final RowScopeInstance INSTANCE = new RowScopeInstance();

    private RowScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    @NotNull
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment.Vertical alignment) {
        t.i(modifier, "<this>");
        t.i(alignment, "alignment");
        return modifier.then(new VerticalAlignModifier(alignment, InspectableValueKt.isDebugInspectorInfoEnabled() ? new RowScopeInstance$align$$inlined$debugInspectorInfo$1(alignment) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    @NotNull
    public Modifier alignBy(@NotNull Modifier modifier, @NotNull HorizontalAlignmentLine alignmentLine) {
        t.i(modifier, "<this>");
        t.i(alignmentLine, "alignmentLine");
        return modifier.then(new SiblingsAlignedModifier.WithAlignmentLine(alignmentLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new RowScopeInstance$alignBy$$inlined$debugInspectorInfo$1(alignmentLine) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    @NotNull
    public Modifier alignByBaseline(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return alignBy(modifier, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    @NotNull
    public Modifier weight(@NotNull Modifier modifier, float f10, boolean z10) {
        t.i(modifier, "<this>");
        if (((double) f10) > 0.0d) {
            return modifier.then(new LayoutWeightImpl(f10, z10, InspectableValueKt.isDebugInspectorInfoEnabled() ? new RowScopeInstance$weight$$inlined$debugInspectorInfo$1(f10, z10) : InspectableValueKt.getNoInspectorInfo()));
        }
        throw new IllegalArgumentException(("invalid weight " + f10 + "; must be greater than zero").toString());
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @NotNull
    public Modifier alignBy(@NotNull Modifier modifier, @NotNull h9.l<? super Measured, Integer> alignmentLineBlock) {
        t.i(modifier, "<this>");
        t.i(alignmentLineBlock, "alignmentLineBlock");
        return modifier.then(new SiblingsAlignedModifier.WithAlignmentLineBlock(alignmentLineBlock, InspectableValueKt.isDebugInspectorInfoEnabled() ? new RowScopeInstance$alignBy$$inlined$debugInspectorInfo$2(alignmentLineBlock) : InspectableValueKt.getNoInspectorInfo()));
    }
}
