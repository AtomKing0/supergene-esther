package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Row.kt */
/* JADX INFO: loaded from: classes.dex */
final class RowKt$DefaultRowMeasurePolicy$1 extends v implements s<Integer, int[], LayoutDirection, Density, int[], k0> {
    public static final RowKt$DefaultRowMeasurePolicy$1 INSTANCE = new RowKt$DefaultRowMeasurePolicy$1();

    RowKt$DefaultRowMeasurePolicy$1() {
        super(5);
    }

    @Override // h9.s
    public /* bridge */ /* synthetic */ k0 invoke(Integer num, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
        invoke(num.intValue(), iArr, layoutDirection, density, iArr2);
        return k0.f35197a;
    }

    public final void invoke(int i10, @NotNull int[] size, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull int[] outPosition) {
        t.i(size, "size");
        t.i(layoutDirection, "layoutDirection");
        t.i(density, "density");
        t.i(outPosition, "outPosition");
        Arrangement.INSTANCE.getStart().arrange(density, i10, size, layoutDirection, outPosition);
    }
}
