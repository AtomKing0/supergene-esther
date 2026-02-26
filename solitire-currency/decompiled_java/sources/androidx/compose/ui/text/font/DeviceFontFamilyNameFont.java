package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DeviceFontFamilyNameFont.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
final class DeviceFontFamilyNameFont extends AndroidFont {

    @NotNull
    private final String familyName;

    @Nullable
    private final android.graphics.Typeface resolvedTypeface;
    private final int style;

    @NotNull
    private final FontWeight weight;

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i10, k kVar) {
        this(str, fontWeight, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(DeviceFontFamilyNameFont.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.text.font.DeviceFontFamilyNameFont");
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) obj;
        return DeviceFontFamilyName.m3386equalsimpl0(this.familyName, deviceFontFamilyNameFont.familyName) && t.d(getWeight(), deviceFontFamilyNameFont.getWeight()) && FontStyle.m3413equalsimpl0(mo3361getStyle_LCdwA(), deviceFontFamilyNameFont.mo3361getStyle_LCdwA());
    }

    @Nullable
    public final android.graphics.Typeface getResolvedTypeface() {
        return this.resolvedTypeface;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo3361getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    @NotNull
    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((DeviceFontFamilyName.m3387hashCodeimpl(this.familyName) * 31) + getWeight().hashCode()) * 31) + FontStyle.m3414hashCodeimpl(mo3361getStyle_LCdwA());
    }

    @NotNull
    public String toString() {
        return "Font(familyName=\"" + ((Object) DeviceFontFamilyName.m3388toStringimpl(this.familyName)) + "\", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m3415toStringimpl(mo3361getStyle_LCdwA())) + ')';
    }

    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i10) {
        super(FontLoadingStrategy.Companion.m3406getOptionalLocalPKNRLFQ(), NamedFontLoader.INSTANCE, null);
        this.familyName = str;
        this.weight = fontWeight;
        this.style = i10;
        this.resolvedTypeface = PlatformTypefacesKt.PlatformTypefaces().mo3435optionalOnDeviceFontFamilyByNameRetOiIg(str, getWeight(), mo3361getStyle_LCdwA());
    }
}
