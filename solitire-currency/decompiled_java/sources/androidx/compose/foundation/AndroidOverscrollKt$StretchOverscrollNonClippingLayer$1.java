package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidOverscroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1 extends v implements h9.q<MeasureScope, Measurable, Constraints, MeasureResult> {
    public static final AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1 INSTANCE = new AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1();

    /* JADX INFO: renamed from: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidOverscroll.kt */
    static final class AnonymousClass1 extends v implements h9.l<Placeable.PlacementScope, k0> {
        final /* synthetic */ int $extraSizePx;
        final /* synthetic */ Placeable $placeable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Placeable placeable, int i10) {
            super(1);
            this.$placeable = placeable;
            this.$extraSizePx = i10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
            invoke2(placementScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
            t.i(layout, "$this$layout");
            Placeable placeable = this.$placeable;
            Placeable.PlacementScope.placeWithLayer$default(layout, placeable, ((-this.$extraSizePx) / 2) - ((placeable.getWidth() - this.$placeable.getMeasuredWidth()) / 2), ((-this.$extraSizePx) / 2) - ((this.$placeable.getHeight() - this.$placeable.getMeasuredHeight()) / 2), 0.0f, null, 12, null);
        }
    }

    AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        return m163invoke3p2s80s(measureScope, measurable, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
    public final MeasureResult m163invoke3p2s80s(@NotNull MeasureScope layout, @NotNull Measurable measurable, long j10) {
        t.i(layout, "$this$layout");
        t.i(measurable, "measurable");
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        int iMo290roundToPx0680j_4 = layout.mo290roundToPx0680j_4(Dp.m3673constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
        return MeasureScope.CC.p(layout, placeableMo2987measureBRTryo0.getMeasuredWidth() - iMo290roundToPx0680j_4, placeableMo2987measureBRTryo0.getMeasuredHeight() - iMo290roundToPx0680j_4, null, new AnonymousClass1(placeableMo2987measureBRTryo0, iMo290roundToPx0680j_4), 4, null);
    }
}
