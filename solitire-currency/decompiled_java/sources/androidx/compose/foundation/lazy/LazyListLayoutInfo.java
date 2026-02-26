package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyListLayoutInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LazyListLayoutInfo {

    /* JADX INFO: compiled from: LazyListLayoutInfo.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static int getAfterContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.a(lazyListLayoutInfo);
        }

        @Deprecated
        public static int getBeforeContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.b(lazyListLayoutInfo);
        }

        @Deprecated
        @NotNull
        public static Orientation getOrientation(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.c(lazyListLayoutInfo);
        }

        @Deprecated
        public static boolean getReverseLayout(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.d(lazyListLayoutInfo);
        }

        @Deprecated
        /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
        public static long m514getViewportSizeYbymL2g(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.e(lazyListLayoutInfo);
        }
    }

    int getAfterContentPadding();

    int getBeforeContentPadding();

    @NotNull
    Orientation getOrientation();

    boolean getReverseLayout();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    long mo497getViewportSizeYbymL2g();

    int getViewportStartOffset();

    @NotNull
    List<LazyListItemInfo> getVisibleItemsInfo();
}
