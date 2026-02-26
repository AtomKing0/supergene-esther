package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PointerInteropFilter.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class PointerInteropFilter$pointerInputFilter$1$onCancel$1 extends v implements l<MotionEvent, k0> {
    final /* synthetic */ PointerInteropFilter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PointerInteropFilter$pointerInputFilter$1$onCancel$1(PointerInteropFilter pointerInteropFilter) {
        super(1);
        this.this$0 = pointerInteropFilter;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(MotionEvent motionEvent) {
        invoke2(motionEvent);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull MotionEvent motionEvent) {
        t.i(motionEvent, "motionEvent");
        this.this$0.getOnTouchEvent().invoke(motionEvent);
    }
}
