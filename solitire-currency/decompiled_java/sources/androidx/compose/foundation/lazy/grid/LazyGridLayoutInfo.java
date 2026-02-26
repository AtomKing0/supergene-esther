package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridLayoutInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LazyGridLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    @NotNull
    Orientation getOrientation();

    boolean getReverseLayout();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    long mo530getViewportSizeYbymL2g();

    int getViewportStartOffset();

    @NotNull
    List<LazyGridItemInfo> getVisibleItemsInfo();
}
