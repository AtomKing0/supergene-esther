package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Column.kt */
/* JADX INFO: loaded from: classes.dex */
final class ColumnKt$columnMeasurePolicy$1$1 extends v implements s<Integer, int[], LayoutDirection, Density, int[], k0> {
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ColumnKt$columnMeasurePolicy$1$1(Arrangement.Vertical vertical) {
        super(5);
        this.$verticalArrangement = vertical;
    }

    @Override // h9.s
    public /* bridge */ /* synthetic */ k0 invoke(Integer num, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
        invoke(num.intValue(), iArr, layoutDirection, density, iArr2);
        return k0.f35197a;
    }

    public final void invoke(int i10, @NotNull int[] size, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull int[] outPosition) {
        t.i(size, "size");
        t.i(layoutDirection, "<anonymous parameter 2>");
        t.i(density, "density");
        t.i(outPosition, "outPosition");
        this.$verticalArrangement.arrange(density, i10, size, outPosition);
    }
}
