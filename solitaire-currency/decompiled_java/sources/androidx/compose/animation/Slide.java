package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Slide {

    @NotNull
    private final FiniteAnimationSpec<IntOffset> animationSpec;

    @NotNull
    private final l<IntSize, IntOffset> slideOffset;

    /* JADX WARN: Multi-variable type inference failed */
    public Slide(@NotNull l<? super IntSize, IntOffset> slideOffset, @NotNull FiniteAnimationSpec<IntOffset> animationSpec) {
        t.i(slideOffset, "slideOffset");
        t.i(animationSpec, "animationSpec");
        this.slideOffset = slideOffset;
        this.animationSpec = animationSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Slide copy$default(Slide slide, l lVar, FiniteAnimationSpec finiteAnimationSpec, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = slide.slideOffset;
        }
        if ((i10 & 2) != 0) {
            finiteAnimationSpec = slide.animationSpec;
        }
        return slide.copy(lVar, finiteAnimationSpec);
    }

    @NotNull
    public final l<IntSize, IntOffset> component1() {
        return this.slideOffset;
    }

    @NotNull
    public final FiniteAnimationSpec<IntOffset> component2() {
        return this.animationSpec;
    }

    @NotNull
    public final Slide copy(@NotNull l<? super IntSize, IntOffset> slideOffset, @NotNull FiniteAnimationSpec<IntOffset> animationSpec) {
        t.i(slideOffset, "slideOffset");
        t.i(animationSpec, "animationSpec");
        return new Slide(slideOffset, animationSpec);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Slide)) {
            return false;
        }
        Slide slide = (Slide) obj;
        return t.d(this.slideOffset, slide.slideOffset) && t.d(this.animationSpec, slide.animationSpec);
    }

    @NotNull
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec() {
        return this.animationSpec;
    }

    @NotNull
    public final l<IntSize, IntOffset> getSlideOffset() {
        return this.slideOffset;
    }

    public int hashCode() {
        return (this.slideOffset.hashCode() * 31) + this.animationSpec.hashCode();
    }

    @NotNull
    public String toString() {
        return "Slide(slideOffset=" + this.slideOffset + ", animationSpec=" + this.animationSpec + ')';
    }
}
