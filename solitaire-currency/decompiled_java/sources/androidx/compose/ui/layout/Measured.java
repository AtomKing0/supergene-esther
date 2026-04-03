package androidx.compose.ui.layout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Measured.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Measured {
    int get(@NotNull AlignmentLine alignmentLine);

    int getMeasuredHeight();

    int getMeasuredWidth();

    @Nullable
    Object getParentData();
}
