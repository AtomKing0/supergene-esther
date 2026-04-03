package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAnimationApi
public interface SizeTransform {
    @NotNull
    /* JADX INFO: renamed from: createAnimationSpec-TemP2vQ, reason: not valid java name */
    FiniteAnimationSpec<IntSize> mo89createAnimationSpecTemP2vQ(long j10, long j11);

    boolean getClip();
}
