package androidx.compose.foundation.lazy.grid;

import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridScopeImpl$item$2$1 extends v implements p<LazyGridItemSpanScope, Integer, GridItemSpan> {
    final /* synthetic */ l<LazyGridItemSpanScope, GridItemSpan> $span;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazyGridScopeImpl$item$2$1(l<? super LazyGridItemSpanScope, GridItemSpan> lVar) {
        super(2);
        this.$span = lVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ GridItemSpan mo4invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
        return GridItemSpan.m531boximpl(m576invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
    }

    /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
    public final long m576invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i10) {
        t.i(lazyGridItemSpanScope, "$this$null");
        return this.$span.invoke(lazyGridItemSpanScope).m538unboximpl();
    }
}
