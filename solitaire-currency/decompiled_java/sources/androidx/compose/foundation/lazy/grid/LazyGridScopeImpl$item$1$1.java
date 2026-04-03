package androidx.compose.foundation.lazy.grid;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridScopeImpl$item$1$1 extends v implements l<Integer, Object> {
    final /* synthetic */ Object $key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridScopeImpl$item$1$1(Object obj) {
        super(1);
        this.$key = obj;
    }

    @NotNull
    public final Object invoke(int i10) {
        return this.$key;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
