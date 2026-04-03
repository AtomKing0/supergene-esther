package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontFamily.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class GenericFontFamily extends SystemFontFamily {

    @NotNull
    private final String fontFamilyName;

    @NotNull
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericFontFamily(@NotNull String name, @NotNull String fontFamilyName) {
        super(null);
        t.i(name, "name");
        t.i(fontFamilyName, "fontFamilyName");
        this.name = name;
        this.fontFamilyName = fontFamilyName;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public String toString() {
        return this.fontFamilyName;
    }
}
