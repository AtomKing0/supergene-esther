package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import h9.q;
import h9.r;
import j9.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SpannableExtensions.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableExtensions_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpannableExtensions.android.kt */
    static final class AnonymousClass1 extends v implements q<SpanStyle, Integer, Integer, k0> {
        final /* synthetic */ r<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> $resolveTypeface;
        final /* synthetic */ Spannable $this_setFontAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Spannable spannable, r<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> rVar) {
            super(3);
            this.$this_setFontAttributes = spannable;
            this.$resolveTypeface = rVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(SpanStyle spanStyle, Integer num, Integer num2) {
            invoke(spanStyle, num.intValue(), num2.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull SpanStyle spanStyle, int i10, int i11) {
            t.i(spanStyle, "spanStyle");
            Spannable spannable = this.$this_setFontAttributes;
            r<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> rVar = this.$resolveTypeface;
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle fontStyleM3310getFontStyle4Lr2A7w = spanStyle.m3310getFontStyle4Lr2A7w();
            FontStyle fontStyleM3410boximpl = FontStyle.m3410boximpl(fontStyleM3310getFontStyle4Lr2A7w != null ? fontStyleM3310getFontStyle4Lr2A7w.m3416unboximpl() : FontStyle.Companion.m3418getNormal_LCdwA());
            FontSynthesis fontSynthesisM3311getFontSynthesisZQGJjVo = spanStyle.m3311getFontSynthesisZQGJjVo();
            spannable.setSpan(new TypefaceSpan(rVar.invoke(fontFamily, fontWeight, fontStyleM3410boximpl, FontSynthesis.m3419boximpl(fontSynthesisM3311getFontSynthesisZQGJjVo != null ? fontSynthesisM3311getFontSynthesisZQGJjVo.m3427unboximpl() : FontSynthesis.Companion.m3428getAllGVVA2EU()))), i10, i11, 33);
        }
    }

    /* JADX INFO: renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m3532createLetterSpacingSpaneAf_CNQ(long j10, Density density) {
        long jM3853getTypeUIouoOA = TextUnit.m3853getTypeUIouoOA(j10);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3887getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo295toPxR2X_6o(j10));
        }
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3886getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m3854getValueimpl(j10));
        }
        return null;
    }

    public static final void flattenFontStylesAndApply(@Nullable SpanStyle spanStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull q<? super SpanStyle, ? super Integer, ? super Integer, k0> block) {
        t.i(spanStyles, "spanStyles");
        t.i(block, "block");
        if (spanStyles.size() <= 1) {
            if (!spanStyles.isEmpty()) {
                block.invoke(merge(spanStyle, spanStyles.get(0).getItem()), Integer.valueOf(spanStyles.get(0).getStart()), Integer.valueOf(spanStyles.get(0).getEnd()));
                return;
            }
            return;
        }
        int size = spanStyles.size();
        int i10 = size * 2;
        Integer[] numArr = new Integer[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            numArr[i11] = 0;
        }
        int size2 = spanStyles.size();
        for (int i12 = 0; i12 < size2; i12++) {
            AnnotatedString.Range<SpanStyle> range = spanStyles.get(i12);
            numArr[i12] = Integer.valueOf(range.getStart());
            numArr[i12 + size] = Integer.valueOf(range.getEnd());
        }
        o.z(numArr);
        int iIntValue = ((Number) p.N(numArr)).intValue();
        for (int i13 = 0; i13 < i10; i13++) {
            int iIntValue2 = numArr[i13].intValue();
            if (iIntValue2 != iIntValue) {
                int size3 = spanStyles.size();
                SpanStyle spanStyleMerge = spanStyle;
                for (int i14 = 0; i14 < size3; i14++) {
                    AnnotatedString.Range<SpanStyle> range2 = spanStyles.get(i14);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(iIntValue, iIntValue2, range2.getStart(), range2.getEnd())) {
                        spanStyleMerge = merge(spanStyleMerge, range2.getItem());
                    }
                }
                if (spanStyleMerge != null) {
                    block.invoke(spanStyleMerge, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                }
                iIntValue = iIntValue2;
            }
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m3354getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* JADX INFO: renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m3533resolveLineHeightInPxo2QH7mI(long j10, float f10, Density density) {
        long jM3853getTypeUIouoOA = TextUnit.m3853getTypeUIouoOA(j10);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3887getSpUIouoOA())) {
            return density.mo295toPxR2X_6o(j10);
        }
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3886getEmUIouoOA())) {
            return TextUnit.m3854getValueimpl(j10) * f10;
        }
        return Float.NaN;
    }

    /* JADX INFO: renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m3534setBackgroundRPmYEkk(@NotNull Spannable setBackground, long j10, int i10, int i11) {
        t.i(setBackground, "$this$setBackground");
        if (j10 != Color.Companion.m1634getUnspecified0d7_KjU()) {
            setSpan(setBackground, new BackgroundColorSpan(ColorKt.m1653toArgb8_81llA(j10)), i10, i11);
        }
    }

    /* JADX INFO: renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m3535setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i10, int i11) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m3548unboximpl()), i10, i11);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, int i10, int i11) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m3536setColorRPmYEkk(spannable, ((SolidColor) brush).m1867getValue0d7_KjU(), i10, i11);
            } else if (brush instanceof ShaderBrush) {
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush), i10, i11);
            }
        }
    }

    /* JADX INFO: renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m3536setColorRPmYEkk(@NotNull Spannable setColor, long j10, int i10, int i11) {
        t.i(setColor, "$this$setColor");
        if (j10 != Color.Companion.m1634getUnspecified0d7_KjU()) {
            setSpan(setColor, new ForegroundColorSpan(ColorKt.m1653toArgb8_81llA(j10)), i10, i11);
        }
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, r<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> rVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i10);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes(range2.getItem()) || range2.getItem().m3311getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m3353getFontStyle4Lr2A7w(), textStyle.m3354getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16323, (k) null) : null, arrayList, new AnonymousClass1(spannable, rVar));
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i10, int i11) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i10, i11);
        }
    }

    /* JADX INFO: renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m3537setFontSizeKmRG4DE(@NotNull Spannable setFontSize, long j10, @NotNull Density density, int i10, int i11) {
        t.i(setFontSize, "$this$setFontSize");
        t.i(density, "density");
        long jM3853getTypeUIouoOA = TextUnit.m3853getTypeUIouoOA(j10);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3887getSpUIouoOA())) {
            setSpan(setFontSize, new AbsoluteSizeSpan(c.c(density.mo295toPxR2X_6o(j10)), false), i10, i11);
        } else if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3886getEmUIouoOA())) {
            setSpan(setFontSize, new RelativeSizeSpan(TextUnit.m3854getValueimpl(j10)), i10, i11);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i10, int i11) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i10, i11);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i10, i11);
        }
    }

    /* JADX INFO: renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m3538setLineHeightKmRG4DE(@NotNull Spannable setLineHeight, long j10, float f10, @NotNull Density density, @NotNull LineHeightStyle lineHeightStyle) {
        t.i(setLineHeight, "$this$setLineHeight");
        t.i(density, "density");
        t.i(lineHeightStyle, "lineHeightStyle");
        float fM3533resolveLineHeightInPxo2QH7mI = m3533resolveLineHeightInPxo2QH7mI(j10, f10, density);
        if (Float.isNaN(fM3533resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(setLineHeight, new LineHeightStyleSpan(fM3533resolveLineHeightInPxo2QH7mI, 0, setLineHeight.length(), LineHeightStyle.Trim.m3578isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m3561getTrimEVpEnUU()), LineHeightStyle.Trim.m3579isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m3561getTrimEVpEnUU()), lineHeightStyle.m3560getAlignmentPIaL0Z0()), 0, setLineHeight.length());
    }

    /* JADX INFO: renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m3539setLineHeightr9BaKPg(@NotNull Spannable setLineHeight, long j10, float f10, @NotNull Density density) {
        t.i(setLineHeight, "$this$setLineHeight");
        t.i(density, "density");
        float fM3533resolveLineHeightInPxo2QH7mI = m3533resolveLineHeightInPxo2QH7mI(j10, f10, density);
        if (Float.isNaN(fM3533resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(setLineHeight, new LineHeightSpan(fM3533resolveLineHeightInPxo2QH7mI), 0, setLineHeight.length());
    }

    public static final void setLocaleList(@NotNull Spannable spannable, @Nullable LocaleList localeList, int i10, int i11) {
        Object localeSpan;
        t.i(spannable, "<this>");
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                localeSpan = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                localeSpan = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0)));
            }
            setSpan(spannable, localeSpan, i10, i11);
        }
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i10, int i11) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m1653toArgb8_81llA(shadow.m1865getColor0d7_KjU()), Offset.m1367getXimpl(shadow.m1866getOffsetF1C5BW0()), Offset.m1368getYimpl(shadow.m1866getOffsetF1C5BW0()), shadow.getBlurRadius()), i10, i11);
        }
    }

    public static final void setSpan(@NotNull Spannable spannable, @NotNull Object span, int i10, int i11) {
        t.i(spannable, "<this>");
        t.i(span, "span");
        spannable.setSpan(span, i10, i11, 33);
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density, ArrayList<SpanRange> arrayList) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m3535setBaselineShift0ocSgnM(spannable, item.m3307getBaselineShift5SSeXJ0(), start, end);
        m3536setColorRPmYEkk(spannable, item.m3308getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m3537setFontSizeKmRG4DE(spannable, item.m3309getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m3534setBackgroundRPmYEkk(spannable, item.m3306getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        MetricAffectingSpan metricAffectingSpanM3532createLetterSpacingSpaneAf_CNQ = m3532createLetterSpacingSpaneAf_CNQ(item.m3312getLetterSpacingXSAIIZE(), density);
        if (metricAffectingSpanM3532createLetterSpacingSpaneAf_CNQ != null) {
            arrayList.add(new SpanRange(metricAffectingSpanM3532createLetterSpacingSpaneAf_CNQ, start, end));
        }
    }

    public static final void setSpanStyles(@NotNull Spannable spannable, @NotNull TextStyle contextTextStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull Density density, @NotNull r<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface) {
        t.i(spannable, "<this>");
        t.i(contextTextStyle, "contextTextStyle");
        t.i(spanStyles, "spanStyles");
        t.i(density, "density");
        t.i(resolveTypeface, "resolveTypeface");
        setFontAttributes(spannable, contextTextStyle, spanStyles, resolveTypeface);
        ArrayList arrayList = new ArrayList();
        int size = spanStyles.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<SpanStyle> range = spanStyles.get(i10);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density, arrayList);
            }
        }
        int size2 = arrayList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            SpanRange spanRange = (SpanRange) arrayList.get(i11);
            setSpan(spannable, spanRange.component1(), spanRange.component2(), spanRange.component3());
        }
    }

    public static final void setTextDecoration(@NotNull Spannable spannable, @Nullable TextDecoration textDecoration, int i10, int i11) {
        t.i(spannable, "<this>");
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.Companion;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i10, i11);
        }
    }

    public static final void setTextIndent(@NotNull Spannable spannable, @Nullable TextIndent textIndent, float f10, @NotNull Density density) {
        t.i(spannable, "<this>");
        t.i(density, "density");
        if (textIndent != null) {
            if ((TextUnit.m3851equalsimpl0(textIndent.m3614getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) && TextUnit.m3851equalsimpl0(textIndent.m3615getRestLineXSAIIZE(), TextUnitKt.getSp(0))) || TextUnitKt.m3872isUnspecifiedR2X_6o(textIndent.m3614getFirstLineXSAIIZE()) || TextUnitKt.m3872isUnspecifiedR2X_6o(textIndent.m3615getRestLineXSAIIZE())) {
                return;
            }
            long jM3853getTypeUIouoOA = TextUnit.m3853getTypeUIouoOA(textIndent.m3614getFirstLineXSAIIZE());
            TextUnitType.Companion companion = TextUnitType.Companion;
            float fM3854getValueimpl = 0.0f;
            float fMo295toPxR2X_6o = TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3887getSpUIouoOA()) ? density.mo295toPxR2X_6o(textIndent.m3614getFirstLineXSAIIZE()) : TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3886getEmUIouoOA()) ? TextUnit.m3854getValueimpl(textIndent.m3614getFirstLineXSAIIZE()) * f10 : 0.0f;
            long jM3853getTypeUIouoOA2 = TextUnit.m3853getTypeUIouoOA(textIndent.m3615getRestLineXSAIIZE());
            if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA2, companion.m3887getSpUIouoOA())) {
                fM3854getValueimpl = density.mo295toPxR2X_6o(textIndent.m3615getRestLineXSAIIZE());
            } else if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA2, companion.m3886getEmUIouoOA())) {
                fM3854getValueimpl = TextUnit.m3854getValueimpl(textIndent.m3615getRestLineXSAIIZE()) * f10;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fMo295toPxR2X_6o), (int) Math.ceil(fM3854getValueimpl)), 0, spannable.length());
        }
    }
}
