package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: CoreText.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextController$measurePolicy$1$measure$2 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ List<s<Placeable, IntOffset>> $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextController$measurePolicy$1$measure$2(List<? extends s<? extends Placeable, IntOffset>> list) {
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
        List<s<Placeable, IntOffset>> list = this.$placeables;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            s<Placeable, IntOffset> sVar = list.get(i10);
            Placeable.PlacementScope.m3017place70tqf50$default(layout, sVar.a(), sVar.b().m3800unboximpl(), 0.0f, 2, null);
        }
    }
}
