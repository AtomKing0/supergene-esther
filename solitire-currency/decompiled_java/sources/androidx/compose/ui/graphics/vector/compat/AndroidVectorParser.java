package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleableRes;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: XmlVectorParser.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidVectorParser {
    private int config;

    @NotNull
    private final XmlPullParser xmlParser;

    public AndroidVectorParser(@NotNull XmlPullParser xmlParser, int i10) {
        t.i(xmlParser, "xmlParser");
        this.xmlParser = xmlParser;
        this.config = i10;
    }

    public static /* synthetic */ AndroidVectorParser copy$default(AndroidVectorParser androidVectorParser, XmlPullParser xmlPullParser, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            xmlPullParser = androidVectorParser.xmlParser;
        }
        if ((i11 & 2) != 0) {
            i10 = androidVectorParser.config;
        }
        return androidVectorParser.copy(xmlPullParser, i10);
    }

    private final void updateConfig(int i10) {
        this.config = i10 | this.config;
    }

    @NotNull
    public final XmlPullParser component1() {
        return this.xmlParser;
    }

    public final int component2() {
        return this.config;
    }

    @NotNull
    public final AndroidVectorParser copy(@NotNull XmlPullParser xmlParser, int i10) {
        t.i(xmlParser, "xmlParser");
        return new AndroidVectorParser(xmlParser, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) obj;
        return t.d(this.xmlParser, androidVectorParser.xmlParser) && this.config == androidVectorParser.config;
    }

    public final int getConfig() {
        return this.config;
    }

    public final float getDimension(@NotNull TypedArray typedArray, int i10, float f10) {
        t.i(typedArray, "typedArray");
        float dimension = typedArray.getDimension(i10, f10);
        updateConfig(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final float getFloat(@NotNull TypedArray typedArray, int i10, float f10) {
        t.i(typedArray, "typedArray");
        float f11 = typedArray.getFloat(i10, f10);
        updateConfig(typedArray.getChangingConfigurations());
        return f11;
    }

    public final int getInt(@NotNull TypedArray typedArray, int i10, int i11) {
        t.i(typedArray, "typedArray");
        int i12 = typedArray.getInt(i10, i11);
        updateConfig(typedArray.getChangingConfigurations());
        return i12;
    }

    public final boolean getNamedBoolean(@NotNull TypedArray typedArray, @NotNull String attrName, @StyleableRes int i10, boolean z10) {
        t.i(typedArray, "typedArray");
        t.i(attrName, "attrName");
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(typedArray, this.xmlParser, attrName, i10, z10);
        updateConfig(typedArray.getChangingConfigurations());
        return namedBoolean;
    }

    @Nullable
    public final ColorStateList getNamedColorStateList(@NotNull TypedArray typedArray, @Nullable Resources.Theme theme, @NotNull String attrName, @StyleableRes int i10) {
        t.i(typedArray, "typedArray");
        t.i(attrName, "attrName");
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, this.xmlParser, theme, attrName, i10);
        updateConfig(typedArray.getChangingConfigurations());
        return namedColorStateList;
    }

    @NotNull
    public final ComplexColorCompat getNamedComplexColor(@NotNull TypedArray typedArray, @Nullable Resources.Theme theme, @NotNull String attrName, @StyleableRes int i10, @ColorInt int i11) {
        t.i(typedArray, "typedArray");
        t.i(attrName, "attrName");
        ComplexColorCompat result = TypedArrayUtils.getNamedComplexColor(typedArray, this.xmlParser, theme, attrName, i10, i11);
        updateConfig(typedArray.getChangingConfigurations());
        t.h(result, "result");
        return result;
    }

    public final float getNamedFloat(@NotNull TypedArray typedArray, @NotNull String attrName, @StyleableRes int i10, float f10) {
        t.i(typedArray, "typedArray");
        t.i(attrName, "attrName");
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, this.xmlParser, attrName, i10, f10);
        updateConfig(typedArray.getChangingConfigurations());
        return namedFloat;
    }

    public final int getNamedInt(@NotNull TypedArray typedArray, @NotNull String attrName, @StyleableRes int i10, int i11) {
        t.i(typedArray, "typedArray");
        t.i(attrName, "attrName");
        int namedInt = TypedArrayUtils.getNamedInt(typedArray, this.xmlParser, attrName, i10, i11);
        updateConfig(typedArray.getChangingConfigurations());
        return namedInt;
    }

    @Nullable
    public final String getString(@NotNull TypedArray typedArray, int i10) {
        t.i(typedArray, "typedArray");
        String string = typedArray.getString(i10);
        updateConfig(typedArray.getChangingConfigurations());
        return string;
    }

    @NotNull
    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    public int hashCode() {
        return (this.xmlParser.hashCode() * 31) + this.config;
    }

    @NotNull
    public final TypedArray obtainAttributes(@NotNull Resources res, @Nullable Resources.Theme theme, @NotNull AttributeSet set, @NotNull int[] attrs) {
        t.i(res, "res");
        t.i(set, "set");
        t.i(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(res, theme, set, attrs);
        t.h(typedArrayObtainAttributes, "obtainAttributes(\n      …          attrs\n        )");
        updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
        return typedArrayObtainAttributes;
    }

    public final void setConfig(int i10) {
        this.config = i10;
    }

    @NotNull
    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.xmlParser + ", config=" + this.config + ')';
    }

    public /* synthetic */ AndroidVectorParser(XmlPullParser xmlPullParser, int i10, int i11, k kVar) {
        this(xmlPullParser, (i11 & 2) != 0 ? 0 : i10);
    }
}
