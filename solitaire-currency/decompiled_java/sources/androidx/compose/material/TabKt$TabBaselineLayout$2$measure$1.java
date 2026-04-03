package androidx.compose.material;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabKt$TabBaselineLayout$2$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Integer $firstBaseline;
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ Integer $lastBaseline;
    final /* synthetic */ int $tabHeight;
    final /* synthetic */ int $tabWidth;
    final /* synthetic */ Placeable $textPlaceable;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TabKt$TabBaselineLayout$2$measure$1(Placeable placeable, Placeable placeable2, MeasureScope measureScope, int i10, int i11, Integer num, Integer num2) {
        super(1);
        this.$textPlaceable = placeable;
        this.$iconPlaceable = placeable2;
        this.$this_Layout = measureScope;
        this.$tabWidth = i10;
        this.$tabHeight = i11;
        this.$firstBaseline = num;
        this.$lastBaseline = num2;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        Placeable placeable;
        t.i(layout, "$this$layout");
        Placeable placeable2 = this.$textPlaceable;
        if (placeable2 == null || (placeable = this.$iconPlaceable) == null) {
            if (placeable2 != null) {
                TabKt.placeTextOrIcon(layout, placeable2, this.$tabHeight);
                return;
            }
            Placeable placeable3 = this.$iconPlaceable;
            if (placeable3 != null) {
                TabKt.placeTextOrIcon(layout, placeable3, this.$tabHeight);
                return;
            }
            return;
        }
        MeasureScope measureScope = this.$this_Layout;
        int i10 = this.$tabWidth;
        int i11 = this.$tabHeight;
        Integer num = this.$firstBaseline;
        t.f(num);
        int iIntValue = num.intValue();
        Integer num2 = this.$lastBaseline;
        t.f(num2);
        TabKt.placeTextAndIcon(layout, measureScope, placeable2, placeable, i10, i11, iIntValue, num2.intValue());
    }
}
