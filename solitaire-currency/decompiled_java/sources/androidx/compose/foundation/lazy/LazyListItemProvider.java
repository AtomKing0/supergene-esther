package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyListItemProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface LazyListItemProvider extends LazyLayoutItemProvider {
    @NotNull
    List<Integer> getHeaderIndexes();

    @NotNull
    LazyItemScopeImpl getItemScope();
}
