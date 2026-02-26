package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import h9.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAnimationApi
final class SizeTransformImpl implements SizeTransform {
    private final boolean clip;

    @NotNull
    private final p<IntSize, IntSize, FiniteAnimationSpec<IntSize>> sizeAnimationSpec;

    /* JADX WARN: Multi-variable type inference failed */
    public SizeTransformImpl(boolean z10, @NotNull p<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        t.i(sizeAnimationSpec, "sizeAnimationSpec");
        this.clip = z10;
        this.sizeAnimationSpec = sizeAnimationSpec;
    }

    @Override // androidx.compose.animation.SizeTransform
    @NotNull
    /* JADX INFO: renamed from: createAnimationSpec-TemP2vQ */
    public FiniteAnimationSpec<IntSize> mo89createAnimationSpecTemP2vQ(long j10, long j11) {
        return this.sizeAnimationSpec.mo4invoke(IntSize.m3825boximpl(j10), IntSize.m3825boximpl(j11));
    }

    @Override // androidx.compose.animation.SizeTransform
    public boolean getClip() {
        return this.clip;
    }

    @NotNull
    public final p<IntSize, IntSize, FiniteAnimationSpec<IntSize>> getSizeAnimationSpec() {
        return this.sizeAnimationSpec;
    }

    public /* synthetic */ SizeTransformImpl(boolean z10, p pVar, int i10, k kVar) {
        this((i10 & 1) != 0 ? true : z10, pVar);
    }
}
