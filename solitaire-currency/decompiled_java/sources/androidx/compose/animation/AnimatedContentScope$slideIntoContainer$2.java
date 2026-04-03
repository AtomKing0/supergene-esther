package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentScope$slideIntoContainer$2 extends v implements l<Integer, Integer> {
    final /* synthetic */ l<Integer, Integer> $initialOffset;
    final /* synthetic */ AnimatedContentScope<S> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AnimatedContentScope$slideIntoContainer$2(l<? super Integer, Integer> lVar, AnimatedContentScope<S> animatedContentScope) {
        super(1);
        this.$initialOffset = lVar;
        this.this$0 = animatedContentScope;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final Integer invoke(int i10) {
        return this.$initialOffset.invoke(Integer.valueOf(IntSize.m3833getWidthimpl(this.this$0.m14getCurrentSizeYbymL2g()) - IntOffset.m3791getXimpl(this.this$0.m11calculateOffsetemnUabE(IntSizeKt.IntSize(i10, i10), this.this$0.m14getCurrentSizeYbymL2g()))));
    }
}
