package androidx.compose.animation.core;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$FloatToVector$2 extends v implements l<AnimationVector1D, Float> {
    public static final VectorConvertersKt$FloatToVector$2 INSTANCE = new VectorConvertersKt$FloatToVector$2();

    VectorConvertersKt$FloatToVector$2() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Float invoke(@NotNull AnimationVector1D it) {
        t.i(it, "it");
        return Float.valueOf(it.getValue());
    }
}
