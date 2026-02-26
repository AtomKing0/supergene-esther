package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import h9.p;
import kotlin.coroutines.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1", f = "DragGestureDetector.kt", l = {277}, m = "invokeSuspend")
final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1 extends k implements p<AwaitPointerEventScope, z8.d<? super PointerInputChange>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1(z8.d<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1> dVar) {
        super(2, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1(dVar);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super PointerInputChange> dVar) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            this.label = 1;
            obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return obj;
    }
}
