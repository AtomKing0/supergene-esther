package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import h9.l;
import h9.p;
import h9.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BackdropScaffoldKt$BackdropStack$1$1 extends v implements p<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $backLayer;
    final /* synthetic */ l<Constraints, Constraints> $calculateBackLayerConstraints;
    final /* synthetic */ r<Constraints, Float, Composer, Integer, k0> $frontLayer;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    static final class AnonymousClass2 extends v implements l<Placeable.PlacementScope, k0> {
        final /* synthetic */ Placeable $backLayerPlaceable;
        final /* synthetic */ List<Placeable> $placeables;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Placeable placeable, List<? extends Placeable> list) {
            super(1);
            this.$backLayerPlaceable = placeable;
            this.$placeables = list;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
            invoke2(placementScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
            t.i(layout, "$this$layout");
            Placeable.PlacementScope.placeRelative$default(layout, this.$backLayerPlaceable, 0, 0, 0.0f, 4, null);
            List<Placeable> list = this.$placeables;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                Placeable.PlacementScope.placeRelative$default(layout, list.get(i10), 0, 0, 0.0f, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BackdropScaffoldKt$BackdropStack$1$1(p<? super Composer, ? super Integer, k0> pVar, l<? super Constraints, Constraints> lVar, r<? super Constraints, ? super Float, ? super Composer, ? super Integer, k0> rVar, int i10) {
        super(2);
        this.$backLayer = pVar;
        this.$calculateBackLayerConstraints = lVar;
        this.$frontLayer = rVar;
        this.$$dirty = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ MeasureResult mo4invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return m876invoke0kLqBqw(subcomposeMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m876invoke0kLqBqw(@NotNull SubcomposeMeasureScope SubcomposeLayout, long j10) {
        t.i(SubcomposeLayout, "$this$SubcomposeLayout");
        Placeable placeableMo2987measureBRTryo0 = ((Measurable) d0.i0(SubcomposeLayout.subcompose(BackdropLayers.Back, this.$backLayer))).mo2987measureBRTryo0(this.$calculateBackLayerConstraints.invoke(Constraints.m3629boximpl(j10)).m3647unboximpl());
        List<Measurable> listSubcompose = SubcomposeLayout.subcompose(BackdropLayers.Front, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new BackdropScaffoldKt$BackdropStack$1$1$placeables$1(this.$frontLayer, j10, placeableMo2987measureBRTryo0.getHeight(), this.$$dirty)));
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size = listSubcompose.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(listSubcompose.get(i10).mo2987measureBRTryo0(j10));
        }
        int iMax = Math.max(Constraints.m3643getMinWidthimpl(j10), placeableMo2987measureBRTryo0.getWidth());
        int iMax2 = Math.max(Constraints.m3642getMinHeightimpl(j10), placeableMo2987measureBRTryo0.getHeight());
        int size2 = arrayList.size();
        int iMax3 = iMax2;
        int iMax4 = iMax;
        for (int i11 = 0; i11 < size2; i11++) {
            Placeable placeable = (Placeable) arrayList.get(i11);
            iMax4 = Math.max(iMax4, placeable.getWidth());
            iMax3 = Math.max(iMax3, placeable.getHeight());
        }
        return MeasureScope.CC.p(SubcomposeLayout, iMax4, iMax3, null, new AnonymousClass2(placeableMo2987measureBRTryo0, arrayList), 4, null);
    }
}
