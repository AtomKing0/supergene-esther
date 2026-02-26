package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes.dex */
final class Arrangement$spacedBy$1 extends v implements p<Integer, LayoutDirection, Integer> {
    public static final Arrangement$spacedBy$1 INSTANCE = new Arrangement$spacedBy$1();

    Arrangement$spacedBy$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, LayoutDirection layoutDirection) {
        return invoke(num.intValue(), layoutDirection);
    }

    @NotNull
    public final Integer invoke(int i10, @NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        return Integer.valueOf(Alignment.Companion.getStart().align(0, i10, layoutDirection));
    }
}
