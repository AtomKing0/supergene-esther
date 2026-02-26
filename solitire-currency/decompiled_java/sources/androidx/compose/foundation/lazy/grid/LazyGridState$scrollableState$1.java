package androidx.compose.foundation.lazy.grid;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridState.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridState$scrollableState$1 extends v implements l<Float, Float> {
    final /* synthetic */ LazyGridState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridState$scrollableState$1(LazyGridState lazyGridState) {
        super(1);
        this.this$0 = lazyGridState;
    }

    @NotNull
    public final Float invoke(float f10) {
        return Float.valueOf(-this.this$0.onScroll$foundation_release(-f10));
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Float invoke(Float f10) {
        return invoke(f10.floatValue());
    }
}
