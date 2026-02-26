package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Fade {
    private final float alpha;

    @NotNull
    private final FiniteAnimationSpec<Float> animationSpec;

    public Fade(float f10, @NotNull FiniteAnimationSpec<Float> animationSpec) {
        t.i(animationSpec, "animationSpec");
        this.alpha = f10;
        this.animationSpec = animationSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Fade copy$default(Fade fade, float f10, FiniteAnimationSpec finiteAnimationSpec, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = fade.alpha;
        }
        if ((i10 & 2) != 0) {
            finiteAnimationSpec = fade.animationSpec;
        }
        return fade.copy(f10, finiteAnimationSpec);
    }

    public final float component1() {
        return this.alpha;
    }

    @NotNull
    public final FiniteAnimationSpec<Float> component2() {
        return this.animationSpec;
    }

    @NotNull
    public final Fade copy(float f10, @NotNull FiniteAnimationSpec<Float> animationSpec) {
        t.i(animationSpec, "animationSpec");
        return new Fade(f10, animationSpec);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fade)) {
            return false;
        }
        Fade fade = (Fade) obj;
        return t.d(Float.valueOf(this.alpha), Float.valueOf(fade.alpha)) && t.d(this.animationSpec, fade.animationSpec);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.alpha) * 31) + this.animationSpec.hashCode();
    }

    @NotNull
    public String toString() {
        return "Fade(alpha=" + this.alpha + ", animationSpec=" + this.animationSpec + ')';
    }
}
