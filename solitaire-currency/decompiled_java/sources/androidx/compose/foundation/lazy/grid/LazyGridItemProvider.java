package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridItemProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface LazyGridItemProvider extends LazyLayoutItemProvider {
    @NotNull
    LazyGridSpanLayoutProvider getSpanLayoutProvider();
}
