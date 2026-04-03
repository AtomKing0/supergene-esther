package androidx.compose.animation.core;

import androidx.compose.ui.unit.DpOffset;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$DpOffsetToVector$1 extends v implements l<DpOffset, AnimationVector2D> {
    public static final VectorConvertersKt$DpOffsetToVector$1 INSTANCE = new VectorConvertersKt$DpOffsetToVector$1();

    VectorConvertersKt$DpOffsetToVector$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector2D invoke(DpOffset dpOffset) {
        return m141invokejoFl9I(dpOffset.m3742unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-jo-Fl9I, reason: not valid java name */
    public final AnimationVector2D m141invokejoFl9I(long j10) {
        return new AnimationVector2D(DpOffset.m3734getXD9Ej5fM(j10), DpOffset.m3736getYD9Ej5fM(j10));
    }
}
