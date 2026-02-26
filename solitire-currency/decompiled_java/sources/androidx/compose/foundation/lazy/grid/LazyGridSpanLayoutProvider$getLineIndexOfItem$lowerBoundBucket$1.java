package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridSpanLayoutProvider.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1 extends v implements l<LazyGridSpanLayoutProvider.Bucket, Integer> {
    final /* synthetic */ int $itemIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1(int i10) {
        super(1);
        this.$itemIndex = i10;
    }

    @Override // h9.l
    @NotNull
    public final Integer invoke(@NotNull LazyGridSpanLayoutProvider.Bucket it) {
        t.i(it, "it");
        return Integer.valueOf(it.getFirstItemIndex() - this.$itemIndex);
    }
}
