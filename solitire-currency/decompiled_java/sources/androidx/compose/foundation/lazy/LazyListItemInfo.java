package androidx.compose.foundation.lazy;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyListItemInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LazyListItemInfo {
    int getIndex();

    @NotNull
    Object getKey();

    int getOffset();

    int getSize();
}
