package androidx.compose.foundation.lazy.grid;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1 extends v implements l<Object, Integer> {
    final /* synthetic */ LazyGridItemProvider $itemProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1(LazyGridItemProvider lazyGridItemProvider) {
        super(1);
        this.$itemProvider = lazyGridItemProvider;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @NotNull
    public final Integer invoke(@NotNull Object needle) {
        t.i(needle, "needle");
        LazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1$key$1 lazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1$key$1 = new LazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1$key$1(this.$itemProvider);
        int itemCount = this.$itemProvider.getItemCount();
        int i10 = 0;
        while (true) {
            if (i10 >= itemCount) {
                i10 = -1;
                break;
            }
            if (t.d(lazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1$key$1.invoke(Integer.valueOf(i10)), needle)) {
                break;
            }
            i10++;
        }
        return Integer.valueOf(i10);
    }
}
