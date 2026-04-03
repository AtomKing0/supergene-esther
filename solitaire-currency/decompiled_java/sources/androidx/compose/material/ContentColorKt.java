package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentColor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContentColorKt {

    @NotNull
    private static final ProvidableCompositionLocal<Color> LocalContentColor = CompositionLocalKt.compositionLocalOf$default(null, ContentColorKt$LocalContentColor$1.INSTANCE, 1, null);

    @NotNull
    public static final ProvidableCompositionLocal<Color> getLocalContentColor() {
        return LocalContentColor;
    }
}
