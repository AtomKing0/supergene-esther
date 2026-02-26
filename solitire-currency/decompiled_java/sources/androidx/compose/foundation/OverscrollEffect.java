package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Overscroll.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface OverscrollEffect {
    @Nullable
    /* JADX INFO: renamed from: consumePostFling-sF-c-tU */
    Object mo158consumePostFlingsFctU(long j10, @NotNull z8.d<? super k0> dVar);

    /* JADX INFO: renamed from: consumePostScroll-l7mfB5k */
    void mo159consumePostScrolll7mfB5k(long j10, long j11, @Nullable Offset offset, int i10);

    @Nullable
    /* JADX INFO: renamed from: consumePreFling-QWom1Mo */
    Object mo160consumePreFlingQWom1Mo(long j10, @NotNull z8.d<? super Velocity> dVar);

    /* JADX INFO: renamed from: consumePreScroll-A0NYTsA */
    long mo161consumePreScrollA0NYTsA(long j10, @Nullable Offset offset, int i10);

    @NotNull
    Modifier getEffectModifier();

    boolean isEnabled();

    boolean isInProgress();

    void setEnabled(boolean z10);
}
