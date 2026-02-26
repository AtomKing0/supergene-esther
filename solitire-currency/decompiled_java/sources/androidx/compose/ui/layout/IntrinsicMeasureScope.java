package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IntrinsicMeasureScope.kt */
/* JADX INFO: loaded from: classes.dex */
public interface IntrinsicMeasureScope extends Density {
    @NotNull
    LayoutDirection getLayoutDirection();
}
