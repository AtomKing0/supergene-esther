package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
final class AlignmentLineOffsetDp extends InspectorValueInfo implements LayoutModifier {
    private final float after;

    @NotNull
    private final AlignmentLine alignmentLine;
    private final float before;

    public /* synthetic */ AlignmentLineOffsetDp(AlignmentLine alignmentLine, float f10, float f11, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(alignmentLine, f10, f11, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        AlignmentLineOffsetDp alignmentLineOffsetDp = obj instanceof AlignmentLineOffsetDp ? (AlignmentLineOffsetDp) obj : null;
        if (alignmentLineOffsetDp == null) {
            return false;
        }
        return t.d(this.alignmentLine, alignmentLineOffsetDp.alignmentLine) && Dp.m3678equalsimpl0(this.before, alignmentLineOffsetDp.before) && Dp.m3678equalsimpl0(this.after, alignmentLineOffsetDp.after);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    /* JADX INFO: renamed from: getAfter-D9Ej5fM, reason: not valid java name */
    public final float m333getAfterD9Ej5fM() {
        return this.after;
    }

    @NotNull
    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    /* JADX INFO: renamed from: getBefore-D9Ej5fM, reason: not valid java name */
    public final float m334getBeforeD9Ej5fM() {
        return this.before;
    }

    public int hashCode() {
        return (((this.alignmentLine.hashCode() * 31) + Dp.m3679hashCodeimpl(this.before)) * 31) + Dp.m3679hashCodeimpl(this.after);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.a(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.b(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        return AlignmentLineKt.m324alignmentLineOffsetMeasuretjqqzMA(measure, this.alignmentLine, this.before, this.after, measurable, j10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.c(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.d(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "AlignmentLineOffset(alignmentLine=" + this.alignmentLine + ", before=" + ((Object) Dp.m3684toStringimpl(this.before)) + ", after=" + ((Object) Dp.m3684toStringimpl(this.after)) + ')';
    }

    private AlignmentLineOffsetDp(AlignmentLine alignmentLine, float f10, float f11, h9.l<? super InspectorInfo, k0> lVar) {
        super(lVar);
        this.alignmentLine = alignmentLine;
        this.before = f10;
        this.after = f11;
        if (!((f10 >= 0.0f || Dp.m3678equalsimpl0(f10, Dp.Companion.m3693getUnspecifiedD9Ej5fM())) && (f11 >= 0.0f || Dp.m3678equalsimpl0(f11, Dp.Companion.m3693getUnspecifiedD9Ej5fM())))) {
            throw new IllegalArgumentException("Padding from alignment line must be a non-negative number".toString());
        }
    }
}
