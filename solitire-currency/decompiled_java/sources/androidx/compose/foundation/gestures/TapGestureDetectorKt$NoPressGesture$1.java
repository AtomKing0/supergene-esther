package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import h9.q;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$NoPressGesture$1", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
final class TapGestureDetectorKt$NoPressGesture$1 extends l implements q<PressGestureScope, Offset, z8.d<? super k0>, Object> {
    int label;

    TapGestureDetectorKt$NoPressGesture$1(z8.d<? super TapGestureDetectorKt$NoPressGesture$1> dVar) {
        super(3, dVar);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, z8.d<? super k0> dVar) {
        return m315invoked4ec7I(pressGestureScope, offset.m1377unboximpl(), dVar);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
    public final Object m315invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j10, @Nullable z8.d<? super k0> dVar) {
        return new TapGestureDetectorKt$NoPressGesture$1(dVar).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u.b(obj);
        return k0.f35197a;
    }
}
