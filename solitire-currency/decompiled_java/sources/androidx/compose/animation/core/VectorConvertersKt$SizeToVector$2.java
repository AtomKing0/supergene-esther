package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$SizeToVector$2 extends v implements l<AnimationVector2D, Size> {
    public static final VectorConvertersKt$SizeToVector$2 INSTANCE = new VectorConvertersKt$SizeToVector$2();

    VectorConvertersKt$SizeToVector$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Size invoke(AnimationVector2D animationVector2D) {
        return Size.m1424boximpl(m152invoke7Ah8Wj8(animationVector2D));
    }

    /* JADX INFO: renamed from: invoke-7Ah8Wj8, reason: not valid java name */
    public final long m152invoke7Ah8Wj8(@NotNull AnimationVector2D it) {
        t.i(it, "it");
        return SizeKt.Size(it.getV1(), it.getV2());
    }
}
