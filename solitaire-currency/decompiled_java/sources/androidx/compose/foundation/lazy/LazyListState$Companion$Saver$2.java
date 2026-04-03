package androidx.compose.foundation.lazy;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyListState.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyListState$Companion$Saver$2 extends v implements l<List<? extends Integer>, LazyListState> {
    public static final LazyListState$Companion$Saver$2 INSTANCE = new LazyListState$Companion$Saver$2();

    LazyListState$Companion$Saver$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ LazyListState invoke(List<? extends Integer> list) {
        return invoke2((List<Integer>) list);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LazyListState invoke2(@NotNull List<Integer> it) {
        t.i(it, "it");
        return new LazyListState(it.get(0).intValue(), it.get(1).intValue());
    }
}
