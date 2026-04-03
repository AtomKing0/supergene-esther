package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Rect;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$RectToVector$2 extends v implements l<AnimationVector4D, Rect> {
    public static final VectorConvertersKt$RectToVector$2 INSTANCE = new VectorConvertersKt$RectToVector$2();

    VectorConvertersKt$RectToVector$2() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Rect invoke(@NotNull AnimationVector4D it) {
        t.i(it, "it");
        return new Rect(it.getV1(), it.getV2(), it.getV3(), it.getV4());
    }
}
