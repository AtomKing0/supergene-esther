package androidx.compose.ui.text.font;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceRequest {

    @Nullable
    private final FontFamily fontFamily;
    private final int fontStyle;
    private final int fontSynthesis;

    @NotNull
    private final FontWeight fontWeight;

    @Nullable
    private final Object resourceLoaderCacheKey;

    public /* synthetic */ TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int i10, int i11, Object obj, k kVar) {
        this(fontFamily, fontWeight, i10, i11, obj);
    }

    /* JADX INFO: renamed from: copy-e1PVR60$default, reason: not valid java name */
    public static /* synthetic */ TypefaceRequest m3447copye1PVR60$default(TypefaceRequest typefaceRequest, FontFamily fontFamily, FontWeight fontWeight, int i10, int i11, Object obj, int i12, Object obj2) {
        if ((i12 & 1) != 0) {
            fontFamily = typefaceRequest.fontFamily;
        }
        if ((i12 & 2) != 0) {
            fontWeight = typefaceRequest.fontWeight;
        }
        FontWeight fontWeight2 = fontWeight;
        if ((i12 & 4) != 0) {
            i10 = typefaceRequest.fontStyle;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = typefaceRequest.fontSynthesis;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            obj = typefaceRequest.resourceLoaderCacheKey;
        }
        return typefaceRequest.m3450copye1PVR60(fontFamily, fontWeight2, i13, i14, obj);
    }

    @Nullable
    public final FontFamily component1() {
        return this.fontFamily;
    }

    @NotNull
    public final FontWeight component2() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: component3-_-LCdwA, reason: not valid java name */
    public final int m3448component3_LCdwA() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: component4-GVVA2EU, reason: not valid java name */
    public final int m3449component4GVVA2EU() {
        return this.fontSynthesis;
    }

    @Nullable
    public final Object component5() {
        return this.resourceLoaderCacheKey;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-e1PVR60, reason: not valid java name */
    public final TypefaceRequest m3450copye1PVR60(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i10, int i11, @Nullable Object obj) {
        t.i(fontWeight, "fontWeight");
        return new TypefaceRequest(fontFamily, fontWeight, i10, i11, obj, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceRequest)) {
            return false;
        }
        TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
        return t.d(this.fontFamily, typefaceRequest.fontFamily) && t.d(this.fontWeight, typefaceRequest.fontWeight) && FontStyle.m3413equalsimpl0(this.fontStyle, typefaceRequest.fontStyle) && FontSynthesis.m3422equalsimpl0(this.fontSynthesis, typefaceRequest.fontSynthesis) && t.d(this.resourceLoaderCacheKey, typefaceRequest.resourceLoaderCacheKey);
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    /* JADX INFO: renamed from: getFontStyle-_-LCdwA, reason: not valid java name */
    public final int m3451getFontStyle_LCdwA() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: getFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m3452getFontSynthesisGVVA2EU() {
        return this.fontSynthesis;
    }

    @NotNull
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    @Nullable
    public final Object getResourceLoaderCacheKey() {
        return this.resourceLoaderCacheKey;
    }

    public int hashCode() {
        FontFamily fontFamily = this.fontFamily;
        int iHashCode = (((((((fontFamily == null ? 0 : fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + FontStyle.m3414hashCodeimpl(this.fontStyle)) * 31) + FontSynthesis.m3423hashCodeimpl(this.fontSynthesis)) * 31;
        Object obj = this.resourceLoaderCacheKey;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TypefaceRequest(fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontStyle=" + ((Object) FontStyle.m3415toStringimpl(this.fontStyle)) + ", fontSynthesis=" + ((Object) FontSynthesis.m3426toStringimpl(this.fontSynthesis)) + ", resourceLoaderCacheKey=" + this.resourceLoaderCacheKey + ')';
    }

    private TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int i10, int i11, Object obj) {
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.fontStyle = i10;
        this.fontSynthesis = i11;
        this.resourceLoaderCacheKey = obj;
    }
}
