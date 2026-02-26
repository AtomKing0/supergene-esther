package androidx.compose.ui.text.font;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FontFamily.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LoadedFontFamily extends FontFamily {

    @NotNull
    private final Typeface typeface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadedFontFamily(@NotNull Typeface typeface) {
        super(true, null);
        t.i(typeface, "typeface");
        this.typeface = typeface;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LoadedFontFamily) && t.d(this.typeface, ((LoadedFontFamily) obj).typeface);
    }

    @NotNull
    public final Typeface getTypeface() {
        return this.typeface;
    }

    public int hashCode() {
        return this.typeface.hashCode();
    }

    @NotNull
    public String toString() {
        return "LoadedFontFamily(typeface=" + this.typeface + ')';
    }
}
