package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimationVectors.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class AnimationVector {
    public static final int $stable = 0;

    private AnimationVector() {
    }

    public /* synthetic */ AnimationVector(k kVar) {
        this();
    }

    public abstract float get$animation_core_release(int i10);

    public abstract int getSize$animation_core_release();

    @NotNull
    public abstract AnimationVector newVector$animation_core_release();

    public abstract void reset$animation_core_release();

    public abstract void set$animation_core_release(int i10, float f10);
}
