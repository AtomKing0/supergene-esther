package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: LazyGridState.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridState$prefetchInfoRetriever$2 extends v implements l<LineIndex, List<? extends s<? extends Integer, ? extends Constraints>>> {
    public static final LazyGridState$prefetchInfoRetriever$2 INSTANCE = new LazyGridState$prefetchInfoRetriever$2();

    LazyGridState$prefetchInfoRetriever$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ List<? extends s<? extends Integer, ? extends Constraints>> invoke(LineIndex lineIndex) {
        return m584invokebKFJvoY(lineIndex.m603unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-bKFJvoY, reason: not valid java name */
    public final List<s<Integer, Constraints>> m584invokebKFJvoY(int i10) {
        return kotlin.collections.v.l();
    }
}
