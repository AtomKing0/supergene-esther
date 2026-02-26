package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SaversKt {

    @NotNull
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(SaversKt$AnnotatedStringSaver$1.INSTANCE, SaversKt$AnnotatedStringSaver$2.INSTANCE);

    @NotNull
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(SaversKt$AnnotationRangeListSaver$1.INSTANCE, SaversKt$AnnotationRangeListSaver$2.INSTANCE);

    @NotNull
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(SaversKt$AnnotationRangeSaver$1.INSTANCE, SaversKt$AnnotationRangeSaver$2.INSTANCE);

    @NotNull
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(SaversKt$VerbatimTtsAnnotationSaver$1.INSTANCE, SaversKt$VerbatimTtsAnnotationSaver$2.INSTANCE);

    @NotNull
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(SaversKt$ParagraphStyleSaver$1.INSTANCE, SaversKt$ParagraphStyleSaver$2.INSTANCE);

    @NotNull
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(SaversKt$SpanStyleSaver$1.INSTANCE, SaversKt$SpanStyleSaver$2.INSTANCE);

    @NotNull
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(SaversKt$TextDecorationSaver$1.INSTANCE, SaversKt$TextDecorationSaver$2.INSTANCE);

    @NotNull
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(SaversKt$TextGeometricTransformSaver$1.INSTANCE, SaversKt$TextGeometricTransformSaver$2.INSTANCE);

    @NotNull
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(SaversKt$TextIndentSaver$1.INSTANCE, SaversKt$TextIndentSaver$2.INSTANCE);

    @NotNull
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(SaversKt$FontWeightSaver$1.INSTANCE, SaversKt$FontWeightSaver$2.INSTANCE);

    @NotNull
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(SaversKt$BaselineShiftSaver$1.INSTANCE, SaversKt$BaselineShiftSaver$2.INSTANCE);

    @NotNull
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(SaversKt$TextRangeSaver$1.INSTANCE, SaversKt$TextRangeSaver$2.INSTANCE);

    @NotNull
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(SaversKt$ShadowSaver$1.INSTANCE, SaversKt$ShadowSaver$2.INSTANCE);

    @NotNull
    private static final Saver<Color, Object> ColorSaver = SaverKt.Saver(SaversKt$ColorSaver$1.INSTANCE, SaversKt$ColorSaver$2.INSTANCE);

    @NotNull
    private static final Saver<TextUnit, Object> TextUnitSaver = SaverKt.Saver(SaversKt$TextUnitSaver$1.INSTANCE, SaversKt$TextUnitSaver$2.INSTANCE);

    @NotNull
    private static final Saver<Offset, Object> OffsetSaver = SaverKt.Saver(SaversKt$OffsetSaver$1.INSTANCE, SaversKt$OffsetSaver$2.INSTANCE);

    @NotNull
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(SaversKt$LocaleListSaver$1.INSTANCE, SaversKt$LocaleListSaver$2.INSTANCE);

    @NotNull
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(SaversKt$LocaleSaver$1.INSTANCE, SaversKt$LocaleSaver$2.INSTANCE);

    @NotNull
    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    @NotNull
    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    @NotNull
    public static final Saver<TextDecoration, Object> getSaver(@NotNull TextDecoration.Companion companion) {
        t.i(companion, "<this>");
        return TextDecorationSaver;
    }

    @NotNull
    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T saver) {
        t.i(saver, "saver");
        if (t.d(saveable, Boolean.FALSE) || saveable == null) {
            return null;
        }
        Result result = (Result) saver.restore(saveable);
        t.o(1, "Result");
        return result;
    }

    @Nullable
    public static final <T> T save(@Nullable T t10) {
        return t10;
    }

    @NotNull
    public static final Saver<TextGeometricTransform, Object> getSaver(@NotNull TextGeometricTransform.Companion companion) {
        t.i(companion, "<this>");
        return TextGeometricTransformSaver;
    }

    @NotNull
    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(@Nullable Original original, @NotNull T saver, @NotNull SaverScope scope) {
        Object objSave;
        t.i(saver, "saver");
        t.i(scope, "scope");
        return (original == null || (objSave = saver.save(scope, original)) == null) ? Boolean.FALSE : objSave;
    }

    @NotNull
    public static final Saver<TextIndent, Object> getSaver(@NotNull TextIndent.Companion companion) {
        t.i(companion, "<this>");
        return TextIndentSaver;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj == 0) {
            return null;
        }
        t.o(1, "Result");
        return obj;
    }

    @NotNull
    public static final Saver<FontWeight, Object> getSaver(@NotNull FontWeight.Companion companion) {
        t.i(companion, "<this>");
        return FontWeightSaver;
    }

    @NotNull
    public static final Saver<BaselineShift, Object> getSaver(@NotNull BaselineShift.Companion companion) {
        t.i(companion, "<this>");
        return BaselineShiftSaver;
    }

    @NotNull
    public static final Saver<TextRange, Object> getSaver(@NotNull TextRange.Companion companion) {
        t.i(companion, "<this>");
        return TextRangeSaver;
    }

    @NotNull
    public static final Saver<Shadow, Object> getSaver(@NotNull Shadow.Companion companion) {
        t.i(companion, "<this>");
        return ShadowSaver;
    }

    @NotNull
    public static final Saver<Color, Object> getSaver(@NotNull Color.Companion companion) {
        t.i(companion, "<this>");
        return ColorSaver;
    }

    @NotNull
    public static final Saver<TextUnit, Object> getSaver(@NotNull TextUnit.Companion companion) {
        t.i(companion, "<this>");
        return TextUnitSaver;
    }

    @NotNull
    public static final Saver<Offset, Object> getSaver(@NotNull Offset.Companion companion) {
        t.i(companion, "<this>");
        return OffsetSaver;
    }

    @NotNull
    public static final Saver<LocaleList, Object> getSaver(@NotNull LocaleList.Companion companion) {
        t.i(companion, "<this>");
        return LocaleListSaver;
    }

    @NotNull
    public static final Saver<Locale, Object> getSaver(@NotNull Locale.Companion companion) {
        t.i(companion, "<this>");
        return LocaleSaver;
    }

    private static /* synthetic */ void getTextUnitSaver$annotations() {
    }
}
