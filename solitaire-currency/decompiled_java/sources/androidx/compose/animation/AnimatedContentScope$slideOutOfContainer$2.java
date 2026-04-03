package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentScope$slideOutOfContainer$2 extends v implements l<Integer, Integer> {
    final /* synthetic */ l<Integer, Integer> $targetOffset;
    final /* synthetic */ AnimatedContentScope<S> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AnimatedContentScope$slideOutOfContainer$2(AnimatedContentScope<S> animatedContentScope, l<? super Integer, Integer> lVar) {
        super(1);
        this.this$0 = animatedContentScope;
        this.$targetOffset = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final Integer invoke(int i10) {
        State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
        return this.$targetOffset.invoke(Integer.valueOf((-IntOffset.m3791getXimpl(this.this$0.m11calculateOffsetemnUabE(IntSizeKt.IntSize(i10, i10), state != null ? ((IntSize) state.getValue()).m3837unboximpl() : IntSize.Companion.m3838getZeroYbymL2g()))) - i10));
    }
}
