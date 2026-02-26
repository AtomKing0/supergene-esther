package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;

/* JADX INFO: compiled from: Selectable.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Selectable {
    @NotNull
    Rect getBoundingBox(int i10);

    /* JADX INFO: renamed from: getHandlePosition-dBAh8RU */
    long mo759getHandlePositiondBAh8RU(@NotNull Selection selection, boolean z10);

    @Nullable
    LayoutCoordinates getLayoutCoordinates();

    /* JADX INFO: renamed from: getRangeOfLineContaining--jx7JFs */
    long mo760getRangeOfLineContainingjx7JFs(int i10);

    @Nullable
    Selection getSelectAllSelection();

    long getSelectableId();

    @NotNull
    AnnotatedString getText();

    @NotNull
    /* JADX INFO: renamed from: updateSelection-qCDeeow */
    s<Selection, Boolean> mo761updateSelectionqCDeeow(long j10, long j11, @Nullable Offset offset, boolean z10, @NotNull LayoutCoordinates layoutCoordinates, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection);
}
