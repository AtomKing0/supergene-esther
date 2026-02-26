package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import h9.q;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
final class TransformableStateKt$rememberTransformableState$1$1 extends v implements q<Float, Offset, Float, k0> {
    final /* synthetic */ State<q<Float, Offset, Float, k0>> $lambdaState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TransformableStateKt$rememberTransformableState$1$1(State<? extends q<? super Float, ? super Offset, ? super Float, k0>> state) {
        super(3);
        this.$lambdaState = state;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Float f10, Offset offset, Float f11) {
        m321invoked4ec7I(f10.floatValue(), offset.m1377unboximpl(), f11.floatValue());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
    public final void m321invoked4ec7I(float f10, long j10, float f11) {
        this.$lambdaState.getValue().invoke(Float.valueOf(f10), Offset.m1356boximpl(j10), Float.valueOf(f11));
    }
}
