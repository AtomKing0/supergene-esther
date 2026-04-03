package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$IntSizeToVector$1 extends v implements l<IntSize, AnimationVector2D> {
    public static final VectorConvertersKt$IntSizeToVector$1 INSTANCE = new VectorConvertersKt$IntSizeToVector$1();

    VectorConvertersKt$IntSizeToVector$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector2D invoke(IntSize intSize) {
        return m147invokeozmzZPI(intSize.m3837unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final AnimationVector2D m147invokeozmzZPI(long j10) {
        return new AnimationVector2D(IntSize.m3833getWidthimpl(j10), IntSize.m3832getHeightimpl(j10));
    }
}
