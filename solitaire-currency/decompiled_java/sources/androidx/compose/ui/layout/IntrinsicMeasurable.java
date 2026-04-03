package androidx.compose.ui.layout;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IntrinsicMeasurable.kt */
/* JADX INFO: loaded from: classes.dex */
public interface IntrinsicMeasurable {
    @Nullable
    Object getParentData();

    int maxIntrinsicHeight(int i10);

    int maxIntrinsicWidth(int i10);

    int minIntrinsicHeight(int i10);

    int minIntrinsicWidth(int i10);
}
