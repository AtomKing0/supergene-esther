package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$IntSizeToVector$2 extends v implements l<AnimationVector2D, IntSize> {
    public static final VectorConvertersKt$IntSizeToVector$2 INSTANCE = new VectorConvertersKt$IntSizeToVector$2();

    VectorConvertersKt$IntSizeToVector$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ IntSize invoke(AnimationVector2D animationVector2D) {
        return IntSize.m3825boximpl(m148invokeYEO4UFw(animationVector2D));
    }

    /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
    public final long m148invokeYEO4UFw(@NotNull AnimationVector2D it) {
        t.i(it, "it");
        return IntSizeKt.IntSize(j9.c.c(it.getV1()), j9.c.c(it.getV2()));
    }
}
