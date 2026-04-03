package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SelectionMode.kt */
/* JADX INFO: loaded from: classes.dex */
public enum SelectionMode {
    Vertical { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo826compare3MmeM6k$foundation_release(long j10, @NotNull Rect bounds) {
            t.i(bounds, "bounds");
            if (bounds.m1393containsk4lQ0M(j10)) {
                return 0;
            }
            if (Offset.m1368getYimpl(j10) < bounds.getTop()) {
                return -1;
            }
            return (Offset.m1367getXimpl(j10) >= bounds.getLeft() || Offset.m1368getYimpl(j10) >= bounds.getBottom()) ? 1 : -1;
        }
    },
    Horizontal { // from class: androidx.compose.foundation.text.selection.SelectionMode.Horizontal
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo826compare3MmeM6k$foundation_release(long j10, @NotNull Rect bounds) {
            t.i(bounds, "bounds");
            if (bounds.m1393containsk4lQ0M(j10)) {
                return 0;
            }
            if (Offset.m1367getXimpl(j10) < bounds.getLeft()) {
                return -1;
            }
            return (Offset.m1368getYimpl(j10) >= bounds.getTop() || Offset.m1367getXimpl(j10) >= bounds.getRight()) ? 1 : -1;
        }
    };

    /* synthetic */ SelectionMode(k kVar) {
        this();
    }

    /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo826compare3MmeM6k$foundation_release(long j10, @NotNull Rect rect);

    /* JADX INFO: renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m827isSelected2x9bVx0$foundation_release(@NotNull Rect bounds, long j10, long j11) {
        t.i(bounds, "bounds");
        if (bounds.m1393containsk4lQ0M(j10) || bounds.m1393containsk4lQ0M(j11)) {
            return true;
        }
        return (mo826compare3MmeM6k$foundation_release(j10, bounds) > 0) ^ (mo826compare3MmeM6k$foundation_release(j11, bounds) > 0);
    }
}
