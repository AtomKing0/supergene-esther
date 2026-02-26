package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RootMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
final class RootMeasurePolicy$measure$4 extends v implements h9.l<Placeable.PlacementScope, k0> {
    final /* synthetic */ List<Placeable> $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RootMeasurePolicy$measure$4(List<? extends Placeable> list) {
        super(1);
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
        List<Placeable> list = this.$placeables;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Placeable.PlacementScope.placeRelativeWithLayer$default(layout, list.get(i10), 0, 0, 0.0f, null, 12, null);
        }
    }
}
