package androidx.compose.foundation.gestures;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", l = {829, 867}, m = "awaitHorizontalTouchSlopOrCancellation-jO51t88")
final class DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 extends kotlin.coroutines.jvm.internal.d {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(z8.d<? super DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1> dVar) {
        super(dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m250awaitHorizontalTouchSlopOrCancellationjO51t88(null, 0L, null, this);
    }
}
