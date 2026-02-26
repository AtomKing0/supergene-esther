package androidx.compose.ui.text.font;

import java.io.File;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidFileFont extends AndroidPreloadedFont {

    @Nullable
    private final String cacheKey;

    @NotNull
    private final File file;
    private final int style;

    @Nullable
    private final android.graphics.Typeface typefaceInternal;

    @NotNull
    private final FontWeight weight;

    public /* synthetic */ AndroidFileFont(File file, FontWeight fontWeight, int i10, k kVar) {
        this(file, fontWeight, i10);
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    @Nullable
    public String getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo3361getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    @Nullable
    public android.graphics.Typeface getTypefaceInternal() {
        return this.typefaceInternal;
    }

    @Override // androidx.compose.ui.text.font.Font
    @NotNull
    public FontWeight getWeight() {
        return this.weight;
    }

    @NotNull
    public String toString() {
        return "Font(file=" + this.file + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m3415toStringimpl(mo3361getStyle_LCdwA())) + ')';
    }

    public /* synthetic */ AndroidFileFont(File file, FontWeight fontWeight, int i10, int i11, k kVar) {
        this(file, (i11 & 2) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i11 & 4) != 0 ? FontStyle.Companion.m3418getNormal_LCdwA() : i10, null);
    }

    private AndroidFileFont(File file, FontWeight fontWeight, int i10) {
        this.file = file;
        this.weight = fontWeight;
        this.style = i10;
        this.typefaceInternal = android.graphics.Typeface.createFromFile(file);
    }
}
