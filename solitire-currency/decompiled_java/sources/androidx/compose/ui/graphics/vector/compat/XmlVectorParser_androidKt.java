package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: XmlVectorParser.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class XmlVectorParser_androidKt {
    private static final int FILL_TYPE_WINDING = 0;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;

    @NotNull
    private static final String SHAPE_CLIP_PATH = "clip-path";

    @NotNull
    private static final String SHAPE_GROUP = "group";

    @NotNull
    private static final String SHAPE_PATH = "path";

    @NotNull
    public static final ImageVector.Builder createVectorImageBuilder(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources res, @Nullable Resources.Theme theme, @NotNull AttributeSet attrs) throws XmlPullParserException {
        long jM1634getUnspecified0d7_KjU;
        int iM1546getSrcIn0nO6VwU;
        ColorStateList namedColorStateList;
        t.i(androidVectorParser, "<this>");
        t.i(res, "res");
        t.i(attrs, "attrs");
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(res, theme, attrs, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY());
        boolean namedBoolean = androidVectorParser.getNamedBoolean(typedArrayObtainAttributes, "autoMirrored", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_AUTO_MIRRORED(), false);
        float namedFloat = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "viewportWidth", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_WIDTH(), 0.0f);
        float namedFloat2 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "viewportHeight", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_HEIGHT(), 0.0f);
        if (namedFloat <= 0.0f) {
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        }
        if (namedFloat2 <= 0.0f) {
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
        float dimension = androidVectorParser.getDimension(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_WIDTH(), 0.0f);
        float dimension2 = androidVectorParser.getDimension(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_HEIGHT(), 0.0f);
        if (typedArrayObtainAttributes.hasValue(androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) {
            TypedValue typedValue = new TypedValue();
            typedArrayObtainAttributes.getValue(androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT(), typedValue);
            jM1634getUnspecified0d7_KjU = (typedValue.type == 2 || (namedColorStateList = androidVectorParser.getNamedColorStateList(typedArrayObtainAttributes, theme, "tint", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) == null) ? Color.Companion.m1634getUnspecified0d7_KjU() : ColorKt.Color(namedColorStateList.getDefaultColor());
        } else {
            jM1634getUnspecified0d7_KjU = Color.Companion.m1634getUnspecified0d7_KjU();
        }
        long j10 = jM1634getUnspecified0d7_KjU;
        int i10 = androidVectorParser.getInt(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT_MODE(), -1);
        if (i10 == -1) {
            iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1546getSrcIn0nO6VwU();
        } else if (i10 == 3) {
            iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1548getSrcOver0nO6VwU();
        } else if (i10 == 5) {
            iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1546getSrcIn0nO6VwU();
        } else if (i10 != 9) {
            switch (i10) {
                case 14:
                    iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1537getModulate0nO6VwU();
                    break;
                case 15:
                    iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1542getScreen0nO6VwU();
                    break;
                case 16:
                    iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1540getPlus0nO6VwU();
                    break;
                default:
                    iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1546getSrcIn0nO6VwU();
                    break;
            }
        } else {
            iM1546getSrcIn0nO6VwU = BlendMode.Companion.m1545getSrcAtop0nO6VwU();
        }
        int i11 = iM1546getSrcIn0nO6VwU;
        float fM3673constructorimpl = Dp.m3673constructorimpl(dimension / res.getDisplayMetrics().density);
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(dimension2 / res.getDisplayMetrics().density);
        typedArrayObtainAttributes.recycle();
        return new ImageVector.Builder(null, fM3673constructorimpl, fM3673constructorimpl2, namedFloat, namedFloat2, j10, i11, namedBoolean, 1, null);
    }

    /* JADX INFO: renamed from: getStrokeLineCap-CSYIeUk, reason: not valid java name */
    private static final int m2134getStrokeLineCapCSYIeUk(int i10, int i11) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i11 : StrokeCap.Companion.m1887getSquareKaPHkGw() : StrokeCap.Companion.m1886getRoundKaPHkGw() : StrokeCap.Companion.m1885getButtKaPHkGw();
    }

    /* JADX INFO: renamed from: getStrokeLineCap-CSYIeUk$default, reason: not valid java name */
    static /* synthetic */ int m2135getStrokeLineCapCSYIeUk$default(int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = StrokeCap.Companion.m1885getButtKaPHkGw();
        }
        return m2134getStrokeLineCapCSYIeUk(i10, i11);
    }

    /* JADX INFO: renamed from: getStrokeLineJoin-kLtJ_vA, reason: not valid java name */
    private static final int m2136getStrokeLineJoinkLtJ_vA(int i10, int i11) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i11 : StrokeJoin.Companion.m1895getBevelLxFBmk8() : StrokeJoin.Companion.m1897getRoundLxFBmk8() : StrokeJoin.Companion.m1896getMiterLxFBmk8();
    }

    /* JADX INFO: renamed from: getStrokeLineJoin-kLtJ_vA$default, reason: not valid java name */
    static /* synthetic */ int m2137getStrokeLineJoinkLtJ_vA$default(int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = StrokeJoin.Companion.m1896getMiterLxFBmk8();
        }
        return m2136getStrokeLineJoinkLtJ_vA(i10, i11);
    }

    public static final boolean isAtEnd(@NotNull XmlPullParser xmlPullParser) {
        t.i(xmlPullParser, "<this>");
        if (xmlPullParser.getEventType() != 1) {
            return xmlPullParser.getDepth() < 1 && xmlPullParser.getEventType() == 3;
        }
        return true;
    }

    private static final Brush obtainBrushFromComplexColor(ComplexColorCompat complexColorCompat) {
        if (!complexColorCompat.willDraw()) {
            return null;
        }
        Shader shader = complexColorCompat.getShader();
        return shader != null ? BrushKt.ShaderBrush(shader) : new SolidColor(ColorKt.Color(complexColorCompat.getColor()), null);
    }

    public static final void parseClipPath(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources res, @Nullable Resources.Theme theme, @NotNull AttributeSet attrs, @NotNull ImageVector.Builder builder) {
        t.i(androidVectorParser, "<this>");
        t.i(res, "res");
        t.i(attrs, "attrs");
        t.i(builder, "builder");
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(res, theme, attrs, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH());
        String string = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_NAME());
        if (string == null) {
            string = "";
        }
        List<PathNode> listAddPathNodes = VectorKt.addPathNodes(androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_PATH_DATA()));
        typedArrayObtainAttributes.recycle();
        builder.addGroup((254 & 1) != 0 ? "" : string, (254 & 2) != 0 ? 0.0f : 0.0f, (254 & 4) != 0 ? 0.0f : 0.0f, (254 & 8) != 0 ? 0.0f : 0.0f, (254 & 16) != 0 ? 1.0f : 0.0f, (254 & 32) == 0 ? 0.0f : 1.0f, (254 & 64) != 0 ? 0.0f : 0.0f, (254 & 128) == 0 ? 0.0f : 0.0f, (254 & 256) != 0 ? VectorKt.getEmptyPath() : listAddPathNodes);
    }

    public static final int parseCurrentVectorNode(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources res, @NotNull AttributeSet attrs, @Nullable Resources.Theme theme, @NotNull ImageVector.Builder builder, int i10) throws XmlPullParserException {
        t.i(androidVectorParser, "<this>");
        t.i(res, "res");
        t.i(attrs, "attrs");
        t.i(builder, "builder");
        int eventType = androidVectorParser.getXmlParser().getEventType();
        if (eventType != 2) {
            if (eventType != 3 || !t.d(SHAPE_GROUP, androidVectorParser.getXmlParser().getName())) {
                return i10;
            }
            int i11 = i10 + 1;
            for (int i12 = 0; i12 < i11; i12++) {
                builder.clearGroup();
            }
            return 0;
        }
        String name = androidVectorParser.getXmlParser().getName();
        if (name == null) {
            return i10;
        }
        int iHashCode = name.hashCode();
        if (iHashCode == -1649314686) {
            if (!name.equals(SHAPE_CLIP_PATH)) {
                return i10;
            }
            parseClipPath(androidVectorParser, res, theme, attrs, builder);
            return i10 + 1;
        }
        if (iHashCode == 3433509) {
            if (!name.equals("path")) {
                return i10;
            }
            parsePath(androidVectorParser, res, theme, attrs, builder);
            return i10;
        }
        if (iHashCode != 98629247 || !name.equals(SHAPE_GROUP)) {
            return i10;
        }
        parseGroup(androidVectorParser, res, theme, attrs, builder);
        return i10;
    }

    public static /* synthetic */ int parseCurrentVectorNode$default(AndroidVectorParser androidVectorParser, Resources resources, AttributeSet attributeSet, Resources.Theme theme, ImageVector.Builder builder, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            theme = null;
        }
        return parseCurrentVectorNode(androidVectorParser, resources, attributeSet, theme, builder, i10);
    }

    public static final void parseGroup(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources res, @Nullable Resources.Theme theme, @NotNull AttributeSet attrs, @NotNull ImageVector.Builder builder) {
        t.i(androidVectorParser, "<this>");
        t.i(res, "res");
        t.i(attrs, "attrs");
        t.i(builder, "builder");
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(res, theme, attrs, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP());
        float namedFloat = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, Key.ROTATION, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_ROTATION(), 0.0f);
        float f10 = androidVectorParser.getFloat(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_X(), 0.0f);
        float f11 = androidVectorParser.getFloat(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_Y(), 0.0f);
        float namedFloat2 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "scaleX", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_X(), 1.0f);
        float namedFloat3 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "scaleY", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_Y(), 1.0f);
        float namedFloat4 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "translateX", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_X(), 0.0f);
        float namedFloat5 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "translateY", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_Y(), 0.0f);
        String string = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_NAME());
        if (string == null) {
            string = "";
        }
        typedArrayObtainAttributes.recycle();
        builder.addGroup(string, namedFloat, f10, f11, namedFloat2, namedFloat3, namedFloat4, namedFloat5, VectorKt.getEmptyPath());
    }

    public static final void parsePath(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources res, @Nullable Resources.Theme theme, @NotNull AttributeSet attrs, @NotNull ImageVector.Builder builder) throws IllegalArgumentException {
        t.i(androidVectorParser, "<this>");
        t.i(res, "res");
        t.i(attrs, "attrs");
        t.i(builder, "builder");
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(res, theme, attrs, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH());
        if (!TypedArrayUtils.hasAttribute(androidVectorParser.getXmlParser(), "pathData")) {
            throw new IllegalArgumentException("No path data available");
        }
        String string = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_NAME());
        if (string == null) {
            string = "";
        }
        String str = string;
        List<PathNode> listAddPathNodes = VectorKt.addPathNodes(androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_PATH_DATA()));
        ComplexColorCompat namedComplexColor = androidVectorParser.getNamedComplexColor(typedArrayObtainAttributes, theme, "fillColor", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_COLOR(), 0);
        float namedFloat = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "fillAlpha", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_ALPHA(), 1.0f);
        int iM2134getStrokeLineCapCSYIeUk = m2134getStrokeLineCapCSYIeUk(androidVectorParser.getNamedInt(typedArrayObtainAttributes, "strokeLineCap", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_CAP(), -1), StrokeCap.Companion.m1885getButtKaPHkGw());
        int iM2136getStrokeLineJoinkLtJ_vA = m2136getStrokeLineJoinkLtJ_vA(androidVectorParser.getNamedInt(typedArrayObtainAttributes, "strokeLineJoin", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_JOIN(), -1), StrokeJoin.Companion.m1895getBevelLxFBmk8());
        float namedFloat2 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "strokeMiterLimit", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_MITER_LIMIT(), 1.0f);
        ComplexColorCompat namedComplexColor2 = androidVectorParser.getNamedComplexColor(typedArrayObtainAttributes, theme, "strokeColor", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_COLOR(), 0);
        float namedFloat3 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "strokeAlpha", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_ALPHA(), 1.0f);
        float namedFloat4 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "strokeWidth", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_WIDTH(), 1.0f);
        float namedFloat5 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "trimPathEnd", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_END(), 1.0f);
        float namedFloat6 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "trimPathOffset", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_OFFSET(), 0.0f);
        float namedFloat7 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "trimPathStart", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_START(), 0.0f);
        int namedInt = androidVectorParser.getNamedInt(typedArrayObtainAttributes, "fillType", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_FILLTYPE(), FILL_TYPE_WINDING);
        typedArrayObtainAttributes.recycle();
        Brush brushObtainBrushFromComplexColor = obtainBrushFromComplexColor(namedComplexColor);
        Brush brushObtainBrushFromComplexColor2 = obtainBrushFromComplexColor(namedComplexColor2);
        PathFillType.Companion companion = PathFillType.Companion;
        builder.m2102addPathoIyEayM(listAddPathNodes, namedInt == 0 ? companion.m1825getNonZeroRgk1Os() : companion.m1824getEvenOddRgk1Os(), str, brushObtainBrushFromComplexColor, namedFloat, brushObtainBrushFromComplexColor2, namedFloat3, namedFloat4, iM2134getStrokeLineCapCSYIeUk, iM2136getStrokeLineJoinkLtJ_vA, namedFloat2, namedFloat7, namedFloat5, namedFloat6);
    }

    @NotNull
    public static final XmlPullParser seekToStartTag(@NotNull XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        t.i(xmlPullParser, "<this>");
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }
}
