package androidx.compose.animation.core;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$IntToVector$2 extends v implements l<AnimationVector1D, Integer> {
    public static final VectorConvertersKt$IntToVector$2 INSTANCE = new VectorConvertersKt$IntToVector$2();

    VectorConvertersKt$IntToVector$2() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Integer invoke(@NotNull AnimationVector1D it) {
        t.i(it, "it");
        return Integer.valueOf((int) it.getValue());
    }
}
