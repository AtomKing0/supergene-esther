package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScrollableState.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollableStateKt$rememberScrollableState$1$1 extends v implements l<Float, Float> {
    final /* synthetic */ State<l<Float, Float>> $lambdaState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScrollableStateKt$rememberScrollableState$1$1(State<? extends l<? super Float, Float>> state) {
        super(1);
        this.$lambdaState = state;
    }

    @NotNull
    public final Float invoke(float f10) {
        return this.$lambdaState.getValue().invoke(Float.valueOf(f10));
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Float invoke(Float f10) {
        return invoke(f10.floatValue());
    }
}
