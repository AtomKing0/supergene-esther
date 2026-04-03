package androidx.compose.foundation.lazy.grid;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridScopeImpl$DefaultSpan$1 extends v implements p<LazyGridItemSpanScope, Integer, GridItemSpan> {
    public static final LazyGridScopeImpl$DefaultSpan$1 INSTANCE = new LazyGridScopeImpl$DefaultSpan$1();

    LazyGridScopeImpl$DefaultSpan$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ GridItemSpan mo4invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
        return GridItemSpan.m531boximpl(m575invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
    }

    /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
    public final long m575invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i10) {
        t.i(lazyGridItemSpanScope, "$this$null");
        return LazyGridSpanKt.GridItemSpan(1);
    }
}
