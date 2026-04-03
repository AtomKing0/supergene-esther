package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Vertices.kt */
/* JADX INFO: loaded from: classes.dex */
final class Vertices$outOfBounds$1 extends kotlin.jvm.internal.v implements h9.l<Integer, Boolean> {
    final /* synthetic */ List<Offset> $positions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Vertices$outOfBounds$1(List<Offset> list) {
        super(1);
        this.$positions = list;
    }

    @NotNull
    public final Boolean invoke(int i10) {
        return Boolean.valueOf(i10 < 0 || i10 >= this.$positions.size());
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return invoke(num.intValue());
    }
}
