package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$OffsetToVector$1 extends v implements l<Offset, AnimationVector2D> {
    public static final VectorConvertersKt$OffsetToVector$1 INSTANCE = new VectorConvertersKt$OffsetToVector$1();

    VectorConvertersKt$OffsetToVector$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector2D invoke(Offset offset) {
        return m149invokek4lQ0M(offset.m1377unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final AnimationVector2D m149invokek4lQ0M(long j10) {
        return new AnimationVector2D(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
    }
}
