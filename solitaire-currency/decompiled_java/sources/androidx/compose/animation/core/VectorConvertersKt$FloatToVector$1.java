package androidx.compose.animation.core;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$FloatToVector$1 extends v implements l<Float, AnimationVector1D> {
    public static final VectorConvertersKt$FloatToVector$1 INSTANCE = new VectorConvertersKt$FloatToVector$1();

    VectorConvertersKt$FloatToVector$1() {
        super(1);
    }

    @NotNull
    public final AnimationVector1D invoke(float f10) {
        return new AnimationVector1D(f10);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector1D invoke(Float f10) {
        return invoke(f10.floatValue());
    }
}
