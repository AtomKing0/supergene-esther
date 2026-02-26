package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalAnimationApi
public final class ContentTransform {
    public static final int $stable = 8;

    @NotNull
    private final ExitTransition initialContentExit;

    @Nullable
    private SizeTransform sizeTransform;

    @NotNull
    private final EnterTransition targetContentEnter;

    @NotNull
    private final MutableState targetContentZIndex$delegate;

    public ContentTransform(@NotNull EnterTransition targetContentEnter, @NotNull ExitTransition initialContentExit, float f10, @Nullable SizeTransform sizeTransform) {
        t.i(targetContentEnter, "targetContentEnter");
        t.i(initialContentExit, "initialContentExit");
        this.targetContentEnter = targetContentEnter;
        this.initialContentExit = initialContentExit;
        this.targetContentZIndex$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f10), null, 2, null);
        this.sizeTransform = sizeTransform;
    }

    @NotNull
    public final ExitTransition getInitialContentExit() {
        return this.initialContentExit;
    }

    @Nullable
    public final SizeTransform getSizeTransform() {
        return this.sizeTransform;
    }

    @NotNull
    public final EnterTransition getTargetContentEnter() {
        return this.targetContentEnter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getTargetContentZIndex() {
        return ((Number) this.targetContentZIndex$delegate.getValue()).floatValue();
    }

    public final void setSizeTransform$animation_release(@Nullable SizeTransform sizeTransform) {
        this.sizeTransform = sizeTransform;
    }

    public final void setTargetContentZIndex(float f10) {
        this.targetContentZIndex$delegate.setValue(Float.valueOf(f10));
    }

    public /* synthetic */ ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f10, SizeTransform sizeTransform, int i10, k kVar) {
        this(enterTransition, exitTransition, (i10 & 4) != 0 ? 0.0f : f10, (i10 & 8) != 0 ? AnimatedContentKt.SizeTransform$default(false, null, 3, null) : sizeTransform);
    }
}
