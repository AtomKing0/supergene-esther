package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PinnableParent.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface PinnableParent {

    /* JADX INFO: compiled from: PinnableParent.kt */
    @ExperimentalFoundationApi
    public interface PinnedItemsHandle {
        void unpin();
    }

    @NotNull
    PinnedItemsHandle pinItems();
}
