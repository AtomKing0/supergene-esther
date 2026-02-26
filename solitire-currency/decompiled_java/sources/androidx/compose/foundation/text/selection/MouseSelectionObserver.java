package androidx.compose.foundation.text.selection;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MouseSelectionObserver {
    /* JADX INFO: renamed from: onDrag-3MmeM6k */
    boolean mo712onDrag3MmeM6k(long j10, @NotNull SelectionAdjustment selectionAdjustment);

    /* JADX INFO: renamed from: onExtend-k-4lQ0M */
    boolean mo713onExtendk4lQ0M(long j10);

    /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M */
    boolean mo714onExtendDragk4lQ0M(long j10);

    /* JADX INFO: renamed from: onStart-3MmeM6k */
    boolean mo715onStart3MmeM6k(long j10, @NotNull SelectionAdjustment selectionAdjustment);
}
