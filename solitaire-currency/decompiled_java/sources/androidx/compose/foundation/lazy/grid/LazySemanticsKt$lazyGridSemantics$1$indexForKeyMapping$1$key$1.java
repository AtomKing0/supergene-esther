package androidx.compose.foundation.lazy.grid;

import h9.l;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class LazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1$key$1 extends q implements l<Integer, Object> {
    LazySemanticsKt$lazyGridSemantics$1$indexForKeyMapping$1$key$1(Object obj) {
        super(1, obj, LazyGridItemProvider.class, "getKey", "getKey(I)Ljava/lang/Object;", 0);
    }

    @NotNull
    public final Object invoke(int i10) {
        return ((LazyGridItemProvider) this.receiver).getKey(i10);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
