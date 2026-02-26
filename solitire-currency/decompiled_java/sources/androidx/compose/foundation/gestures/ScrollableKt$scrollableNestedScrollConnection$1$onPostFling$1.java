package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ScrollableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1", f = "Scrollable.kt", l = {477}, m = "onPostFling-RZ2iAVY")
final class ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 extends kotlin.coroutines.jvm.internal.d {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollableKt.C08491 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1(ScrollableKt.C08491 c08491, z8.d<? super ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1> dVar) {
        super(dVar);
        this.this$0 = c08491;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo301onPostFlingRZ2iAVY(0L, 0L, this);
    }
}
