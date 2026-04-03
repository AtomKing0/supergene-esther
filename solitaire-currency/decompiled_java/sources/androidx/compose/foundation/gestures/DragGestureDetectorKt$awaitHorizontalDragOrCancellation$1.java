package androidx.compose.foundation.gestures;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", l = {823}, m = "awaitHorizontalDragOrCancellation-rnUCldI")
final class DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 extends kotlin.coroutines.jvm.internal.d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(z8.d<? super DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1> dVar) {
        super(dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m248awaitHorizontalDragOrCancellationrnUCldI(null, 0L, this);
    }
}
