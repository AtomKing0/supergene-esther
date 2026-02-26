package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontFamily.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class DefaultFontFamily extends SystemFontFamily {
    public DefaultFontFamily() {
        super(null);
    }

    @NotNull
    public String toString() {
        return "FontFamily.Default";
    }
}
