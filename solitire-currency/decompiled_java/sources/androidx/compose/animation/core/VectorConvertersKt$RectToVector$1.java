package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Rect;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$RectToVector$1 extends v implements l<Rect, AnimationVector4D> {
    public static final VectorConvertersKt$RectToVector$1 INSTANCE = new VectorConvertersKt$RectToVector$1();

    VectorConvertersKt$RectToVector$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final AnimationVector4D invoke(@NotNull Rect it) {
        t.i(it, "it");
        return new AnimationVector4D(it.getLeft(), it.getTop(), it.getRight(), it.getBottom());
    }
}
