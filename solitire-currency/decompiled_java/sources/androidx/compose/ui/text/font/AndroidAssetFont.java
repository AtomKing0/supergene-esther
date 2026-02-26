package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidAssetFont extends AndroidPreloadedFont {

    @NotNull
    private final AssetManager assetManager;

    @NotNull
    private final String cacheKey;

    @NotNull
    private final String path;
    private final int style;

    @Nullable
    private final android.graphics.Typeface typefaceInternal;

    @NotNull
    private final FontWeight weight;

    public /* synthetic */ AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i10, k kVar) {
        this(assetManager, str, fontWeight, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(AndroidAssetFont.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            return t.d(this.path, ((AndroidAssetFont) obj).path);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.text.font.AndroidAssetFont");
    }

    @NotNull
    public final AssetManager getAssetManager() {
        return this.assetManager;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    @NotNull
    public String getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: not valid java name */
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

    public int hashCode() {
        return this.path.hashCode();
    }

    @NotNull
    public String toString() {
        return "Font(assetManager, path=" + this.path + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m3415toStringimpl(mo3361getStyle_LCdwA())) + ')';
    }

    public /* synthetic */ AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i10, int i11, k kVar) {
        this(assetManager, str, (i11 & 4) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i11 & 8) != 0 ? FontStyle.Companion.m3418getNormal_LCdwA() : i10, null);
    }

    private AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i10) {
        this.assetManager = assetManager;
        this.path = str;
        this.weight = fontWeight;
        this.style = i10;
        this.typefaceInternal = android.graphics.Typeface.createFromAsset(assetManager, str);
        this.cacheKey = "asset:" + str;
    }
}
