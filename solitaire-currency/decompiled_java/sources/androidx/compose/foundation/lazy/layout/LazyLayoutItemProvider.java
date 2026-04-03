package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyLayoutItemProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface LazyLayoutItemProvider {
    @Composable
    void Item(int i10, @Nullable Composer composer, int i11);

    @Nullable
    Object getContentType(int i10);

    int getItemCount();

    @NotNull
    Object getKey(int i10);

    @NotNull
    Map<Object, Integer> getKeyToIndexMap();
}
