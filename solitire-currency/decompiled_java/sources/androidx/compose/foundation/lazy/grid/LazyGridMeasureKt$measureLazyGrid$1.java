package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridMeasureKt$measureLazyGrid$1 extends v implements l<Placeable.PlacementScope, k0> {
    public static final LazyGridMeasureKt$measureLazyGrid$1 INSTANCE = new LazyGridMeasureKt$measureLazyGrid$1();

    LazyGridMeasureKt$measureLazyGrid$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope invoke) {
        t.i(invoke, "$this$invoke");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }
}
