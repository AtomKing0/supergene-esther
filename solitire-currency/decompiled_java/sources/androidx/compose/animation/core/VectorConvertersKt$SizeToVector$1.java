package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Size;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$SizeToVector$1 extends v implements l<Size, AnimationVector2D> {
    public static final VectorConvertersKt$SizeToVector$1 INSTANCE = new VectorConvertersKt$SizeToVector$1();

    VectorConvertersKt$SizeToVector$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector2D invoke(Size size) {
        return m151invokeuvyYCjk(size.m1441unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
    public final AnimationVector2D m151invokeuvyYCjk(long j10) {
        return new AnimationVector2D(Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10));
    }
}
