package androidx.compose.material.internal;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ List<Placeable> $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3(List<? extends Placeable> list) {
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
        int iM = kotlin.collections.v.m(this.$placeables);
        if (iM < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            Placeable.PlacementScope.placeRelative$default(layout, this.$placeables.get(i10), 0, 0, 0.0f, 4, null);
            if (i10 == iM) {
                return;
            } else {
                i10++;
            }
        }
    }
}
