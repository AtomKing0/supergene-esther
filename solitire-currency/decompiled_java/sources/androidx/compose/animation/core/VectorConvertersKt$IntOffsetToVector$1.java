package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntOffset;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$IntOffsetToVector$1 extends v implements l<IntOffset, AnimationVector2D> {
    public static final VectorConvertersKt$IntOffsetToVector$1 INSTANCE = new VectorConvertersKt$IntOffsetToVector$1();

    VectorConvertersKt$IntOffsetToVector$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector2D invoke(IntOffset intOffset) {
        return m145invokegyyYBs(intOffset.m3800unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke--gyyYBs, reason: not valid java name */
    public final AnimationVector2D m145invokegyyYBs(long j10) {
        return new AnimationVector2D(IntOffset.m3791getXimpl(j10), IntOffset.m3792getYimpl(j10));
    }
}
