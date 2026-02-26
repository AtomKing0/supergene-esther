package androidx.compose.material;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.material.SwipeableState", f = "Swipeable.kt", l = {159, 183, 186}, m = "processNewAnchors$material_release")
final class SwipeableState$processNewAnchors$1 extends d {
    float F$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableState$processNewAnchors$1(SwipeableState<T> swipeableState, z8.d<? super SwipeableState$processNewAnchors$1> dVar) {
        super(dVar);
        this.this$0 = swipeableState;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processNewAnchors$material_release(null, null, this);
    }
}
