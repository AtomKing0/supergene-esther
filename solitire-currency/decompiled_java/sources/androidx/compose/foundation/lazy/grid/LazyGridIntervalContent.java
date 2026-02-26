package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import h9.l;
import h9.p;
import h9.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGridScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridIntervalContent {

    @NotNull
    private final r<LazyGridItemScope, Integer, Composer, Integer, k0> item;

    @Nullable
    private final l<Integer, Object> key;

    @NotNull
    private final p<LazyGridItemSpanScope, Integer, GridItemSpan> span;

    @NotNull
    private final l<Integer, Object> type;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridIntervalContent(@Nullable l<? super Integer, ? extends Object> lVar, @NotNull p<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> span, @NotNull l<? super Integer, ? extends Object> type, @NotNull r<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, k0> item) {
        t.i(span, "span");
        t.i(type, "type");
        t.i(item, "item");
        this.key = lVar;
        this.span = span;
        this.type = type;
        this.item = item;
    }

    @NotNull
    public final r<LazyGridItemScope, Integer, Composer, Integer, k0> getItem() {
        return this.item;
    }

    @Nullable
    public final l<Integer, Object> getKey() {
        return this.key;
    }

    @NotNull
    public final p<LazyGridItemSpanScope, Integer, GridItemSpan> getSpan() {
        return this.span;
    }

    @NotNull
    public final l<Integer, Object> getType() {
        return this.type;
    }
}
