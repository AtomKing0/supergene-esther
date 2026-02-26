package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import h9.l;
import h9.p;
import h9.q;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends v implements p<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $body;
    final /* synthetic */ q<Integer, Composer, Integer, k0> $bottomSheet;
    final /* synthetic */ p<Composer, Integer, k0> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ State<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ BottomSheetState $sheetState;
    final /* synthetic */ p<Composer, Integer, k0> $snackbarHost;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass1 extends v implements l<Placeable.PlacementScope, k0> {
        final /* synthetic */ Placeable $bodyPlaceable;
        final /* synthetic */ int $fabOffsetX;
        final /* synthetic */ int $fabOffsetY;
        final /* synthetic */ Placeable $fabPlaceable;
        final /* synthetic */ int $sheetOffsetY;
        final /* synthetic */ Placeable $sheetPlaceable;
        final /* synthetic */ int $snackbarOffsetX;
        final /* synthetic */ int $snackbarOffsetY;
        final /* synthetic */ Placeable $snackbarPlaceable;
        final /* synthetic */ int $topBarHeight;
        final /* synthetic */ Placeable $topBarPlaceable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Placeable placeable, int i10, Placeable placeable2, Placeable placeable3, int i11, Placeable placeable4, int i12, int i13, Placeable placeable5, int i14, int i15) {
            super(1);
            this.$bodyPlaceable = placeable;
            this.$topBarHeight = i10;
            this.$topBarPlaceable = placeable2;
            this.$sheetPlaceable = placeable3;
            this.$sheetOffsetY = i11;
            this.$fabPlaceable = placeable4;
            this.$fabOffsetX = i12;
            this.$fabOffsetY = i13;
            this.$snackbarPlaceable = placeable5;
            this.$snackbarOffsetX = i14;
            this.$snackbarOffsetY = i15;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
            invoke2(placementScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
            t.i(layout, "$this$layout");
            Placeable.PlacementScope.placeRelative$default(layout, this.$bodyPlaceable, 0, this.$topBarHeight, 0.0f, 4, null);
            Placeable placeable = this.$topBarPlaceable;
            if (placeable != null) {
                Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, 0, 0.0f, 4, null);
            }
            Placeable.PlacementScope.placeRelative$default(layout, this.$sheetPlaceable, 0, this.$sheetOffsetY, 0.0f, 4, null);
            Placeable placeable2 = this.$fabPlaceable;
            if (placeable2 != null) {
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, this.$fabOffsetX, this.$fabOffsetY, 0.0f, 4, null);
            }
            Placeable.PlacementScope.placeRelative$default(layout, this.$snackbarPlaceable, this.$snackbarOffsetX, this.$snackbarOffsetY, 0.0f, 4, null);
        }
    }

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(State<Float> state, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10, float f10, p<? super Composer, ? super Integer, k0> pVar3, BottomSheetState bottomSheetState, q<? super Integer, ? super Composer, ? super Integer, k0> qVar, int i11, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar2) {
        super(2);
        this.$sheetOffset = state;
        this.$topBar = pVar;
        this.$floatingActionButton = pVar2;
        this.$floatingActionButtonPosition = i10;
        this.$sheetPeekHeight = f10;
        this.$snackbarHost = pVar3;
        this.$sheetState = bottomSheetState;
        this.$bottomSheet = qVar;
        this.$$dirty = i11;
        this.$body = qVar2;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ MeasureResult mo4invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return m900invoke0kLqBqw(subcomposeMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m900invoke0kLqBqw(@NotNull SubcomposeMeasureScope SubcomposeLayout, long j10) {
        int height;
        t.i(SubcomposeLayout, "$this$SubcomposeLayout");
        int iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10);
        int iM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(j10);
        long jM3632copyZbe2FdA$default = Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 10, null);
        Placeable placeableMo2987measureBRTryo0 = SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(520491296, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1(this.$bottomSheet, iM3640getMaxHeightimpl, this.$$dirty))).get(0).mo2987measureBRTryo0(jM3632copyZbe2FdA$default);
        int iC = c.c(this.$sheetOffset.getValue().floatValue());
        p<Composer, Integer, k0> pVar = this.$topBar;
        Placeable placeableMo2987measureBRTryo02 = pVar != null ? SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(1988456983, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1(pVar, this.$$dirty))).get(0).mo2987measureBRTryo0(jM3632copyZbe2FdA$default) : null;
        int height2 = placeableMo2987measureBRTryo02 != null ? placeableMo2987measureBRTryo02.getHeight() : 0;
        Placeable placeableMo2987measureBRTryo03 = SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Body, ComposableLambdaKt.composableLambdaInstance(1466287989, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(this.$body, this.$sheetPeekHeight, this.$$dirty))).get(0).mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(jM3632copyZbe2FdA$default, 0, 0, 0, iM3640getMaxHeightimpl - height2, 7, null));
        p<Composer, Integer, k0> pVar2 = this.$floatingActionButton;
        Placeable placeableMo2987measureBRTryo04 = pVar2 != null ? SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Fab, pVar2).get(0).mo2987measureBRTryo0(jM3632copyZbe2FdA$default) : null;
        int width = placeableMo2987measureBRTryo04 != null ? placeableMo2987measureBRTryo04.getWidth() : 0;
        int height3 = placeableMo2987measureBRTryo04 != null ? placeableMo2987measureBRTryo04.getHeight() : 0;
        int iMo290roundToPx0680j_4 = FabPosition.m1034equalsimpl0(this.$floatingActionButtonPosition, FabPosition.Companion.m1038getCenter5ygKITE()) ? (iM3641getMaxWidthimpl - width) / 2 : (iM3641getMaxWidthimpl - width) - SubcomposeLayout.mo290roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        int i10 = height3 / 2;
        int iMo290roundToPx0680j_42 = SubcomposeLayout.mo296toPx0680j_4(this.$sheetPeekHeight) < ((float) i10) ? (iC - height3) - SubcomposeLayout.mo290roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing) : iC - i10;
        Placeable placeableMo2987measureBRTryo05 = SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.$snackbarHost).get(0).mo2987measureBRTryo0(jM3632copyZbe2FdA$default);
        int width2 = (iM3641getMaxWidthimpl - placeableMo2987measureBRTryo05.getWidth()) / 2;
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.$sheetState.getCurrentValue().ordinal()];
        if (i11 == 1) {
            height = iMo290roundToPx0680j_42 - placeableMo2987measureBRTryo05.getHeight();
        } else {
            if (i11 != 2) {
                throw new v8.q();
            }
            height = iM3640getMaxHeightimpl - placeableMo2987measureBRTryo05.getHeight();
        }
        return MeasureScope.CC.p(SubcomposeLayout, iM3641getMaxWidthimpl, iM3640getMaxHeightimpl, null, new AnonymousClass1(placeableMo2987measureBRTryo03, height2, placeableMo2987measureBRTryo02, placeableMo2987measureBRTryo0, iC, placeableMo2987measureBRTryo04, iMo290roundToPx0680j_4, iMo290roundToPx0680j_42, placeableMo2987measureBRTryo05, width2, height), 4, null);
    }
}
