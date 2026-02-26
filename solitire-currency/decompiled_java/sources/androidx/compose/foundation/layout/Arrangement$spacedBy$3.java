package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes.dex */
final class Arrangement$spacedBy$3 extends v implements p<Integer, LayoutDirection, Integer> {
    final /* synthetic */ Alignment.Vertical $alignment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Arrangement$spacedBy$3(Alignment.Vertical vertical) {
        super(2);
        this.$alignment = vertical;
    }

    @NotNull
    public final Integer invoke(int i10, @NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "<anonymous parameter 1>");
        return Integer.valueOf(this.$alignment.align(0, i10));
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, LayoutDirection layoutDirection) {
        return invoke(num.intValue(), layoutDirection);
    }
}
