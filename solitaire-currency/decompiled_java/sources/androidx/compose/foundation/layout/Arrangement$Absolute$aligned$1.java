package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes.dex */
final class Arrangement$Absolute$aligned$1 extends v implements p<Integer, LayoutDirection, Integer> {
    final /* synthetic */ Alignment.Horizontal $alignment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Arrangement$Absolute$aligned$1(Alignment.Horizontal horizontal) {
        super(2);
        this.$alignment = horizontal;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, LayoutDirection layoutDirection) {
        return invoke(num.intValue(), layoutDirection);
    }

    @NotNull
    public final Integer invoke(int i10, @NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        return Integer.valueOf(this.$alignment.align(0, i10, layoutDirection));
    }
}
