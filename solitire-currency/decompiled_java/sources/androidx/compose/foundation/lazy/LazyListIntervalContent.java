package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import h9.l;
import h9.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyListScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListIntervalContent {

    @NotNull
    private final r<LazyItemScope, Integer, Composer, Integer, k0> item;

    @Nullable
    private final l<Integer, Object> key;

    @NotNull
    private final l<Integer, Object> type;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyListIntervalContent(@Nullable l<? super Integer, ? extends Object> lVar, @NotNull l<? super Integer, ? extends Object> type, @NotNull r<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, k0> item) {
        t.i(type, "type");
        t.i(item, "item");
        this.key = lVar;
        this.type = type;
        this.item = item;
    }

    @NotNull
    public final r<LazyItemScope, Integer, Composer, Integer, k0> getItem() {
        return this.item;
    }

    @Nullable
    public final l<Integer, Object> getKey() {
        return this.key;
    }

    @NotNull
    public final l<Integer, Object> getType() {
        return this.type;
    }
}
