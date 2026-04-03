package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import h9.p;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SubcomposeMeasureScope extends MeasureScope {
    @NotNull
    List<Measurable> subcompose(@Nullable Object obj, @NotNull p<? super Composer, ? super Integer, k0> pVar);
}
