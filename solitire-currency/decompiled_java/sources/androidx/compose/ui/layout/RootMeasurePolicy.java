package androidx.compose.ui.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RootMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {

    @NotNull
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurables, "measurables");
        if (measurables.isEmpty()) {
            return MeasureScope.CC.p(measure, Constraints.m3643getMinWidthimpl(j10), Constraints.m3642getMinHeightimpl(j10), null, RootMeasurePolicy$measure$1.INSTANCE, 4, null);
        }
        if (measurables.size() == 1) {
            Placeable placeableMo2987measureBRTryo0 = measurables.get(0).mo2987measureBRTryo0(j10);
            return MeasureScope.CC.p(measure, ConstraintsKt.m3655constrainWidthK40F9xA(j10, placeableMo2987measureBRTryo0.getWidth()), ConstraintsKt.m3654constrainHeightK40F9xA(j10, placeableMo2987measureBRTryo0.getHeight()), null, new RootMeasurePolicy$measure$2(placeableMo2987measureBRTryo0), 4, null);
        }
        ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(measurables.get(i10).mo2987measureBRTryo0(j10));
        }
        int size2 = arrayList.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i11 = 0; i11 < size2; i11++) {
            Placeable placeable = (Placeable) arrayList.get(i11);
            iMax = Math.max(placeable.getWidth(), iMax);
            iMax2 = Math.max(placeable.getHeight(), iMax2);
        }
        return MeasureScope.CC.p(measure, ConstraintsKt.m3655constrainWidthK40F9xA(j10, iMax), ConstraintsKt.m3654constrainHeightK40F9xA(j10, iMax2), null, new RootMeasurePolicy$measure$4(arrayList), 4, null);
    }
}
