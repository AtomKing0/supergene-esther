package androidx.compose.ui.layout;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MeasureResult.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MeasureResult {
    @NotNull
    Map<AlignmentLine, Integer> getAlignmentLines();

    int getHeight();

    int getWidth();

    void placeChildren();
}
