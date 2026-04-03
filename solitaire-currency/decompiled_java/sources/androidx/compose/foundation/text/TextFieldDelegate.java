package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.x;

/* JADX INFO: compiled from: TextFieldDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDelegate {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: TextFieldDelegate.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: layout-_EkL_-Y$foundation_release$default, reason: not valid java name */
        public static /* synthetic */ x m722layout_EkL_Y$foundation_release$default(Companion companion, TextDelegate textDelegate, long j10, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                textLayoutResult = null;
            }
            return companion.m724layout_EkL_Y$foundation_release(textDelegate, j10, layoutDirection, textLayoutResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onEditCommand(List<? extends EditCommand> list, EditProcessor editProcessor, l<? super TextFieldValue, k0> lVar) {
            lVar.invoke(editProcessor.apply(list));
        }

        @NotNull
        /* JADX INFO: renamed from: applyCompositionDecoration-72CqOWE, reason: not valid java name */
        public final TransformedText m723applyCompositionDecoration72CqOWE(long j10, @NotNull TransformedText transformed) {
            t.i(transformed, "transformed");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(transformed.getText());
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getUnderline(), (Shadow) null, 12287, (k) null), transformed.getOffsetMapping().originalToTransformed(TextRange.m3335getStartimpl(j10)), transformed.getOffsetMapping().originalToTransformed(TextRange.m3330getEndimpl(j10)));
            return new TransformedText(builder.toAnnotatedString(), transformed.getOffsetMapping());
        }

        public final void draw$foundation_release(@NotNull Canvas canvas, @NotNull TextFieldValue value, @NotNull OffsetMapping offsetMapping, @NotNull TextLayoutResult textLayoutResult, @NotNull Paint selectionPaint) {
            int iOriginalToTransformed;
            int iOriginalToTransformed2;
            t.i(canvas, "canvas");
            t.i(value, "value");
            t.i(offsetMapping, "offsetMapping");
            t.i(textLayoutResult, "textLayoutResult");
            t.i(selectionPaint, "selectionPaint");
            if (!TextRange.m3329getCollapsedimpl(value.m3510getSelectiond9O1mEE()) && (iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m3333getMinimpl(value.m3510getSelectiond9O1mEE()))) != (iOriginalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m3332getMaximpl(value.m3510getSelectiond9O1mEE())))) {
                canvas.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed, iOriginalToTransformed2), selectionPaint);
            }
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }

        @NotNull
        /* JADX INFO: renamed from: layout-_EkL_-Y$foundation_release, reason: not valid java name */
        public final x<Integer, Integer, TextLayoutResult> m724layout_EkL_Y$foundation_release(@NotNull TextDelegate textDelegate, long j10, @NotNull LayoutDirection layoutDirection, @Nullable TextLayoutResult textLayoutResult) {
            t.i(textDelegate, "textDelegate");
            t.i(layoutDirection, "layoutDirection");
            TextLayoutResult textLayoutResultM719layoutNN6EwU = textDelegate.m719layoutNN6EwU(j10, layoutDirection, textLayoutResult);
            return new x<>(Integer.valueOf(IntSize.m3833getWidthimpl(textLayoutResultM719layoutNN6EwU.m3321getSizeYbymL2g())), Integer.valueOf(IntSize.m3832getHeightimpl(textLayoutResultM719layoutNN6EwU.m3321getSizeYbymL2g())), textLayoutResultM719layoutNN6EwU);
        }

        public final void onBlur$foundation_release(@NotNull TextInputSession textInputSession, @NotNull EditProcessor editProcessor, @NotNull l<? super TextFieldValue, k0> onValueChange) {
            t.i(textInputSession, "textInputSession");
            t.i(editProcessor, "editProcessor");
            t.i(onValueChange, "onValueChange");
            onValueChange.invoke(TextFieldValue.m3505copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null));
            textInputSession.dispose();
        }

        @NotNull
        public final TextInputSession onFocus$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue value, @NotNull EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull l<? super TextFieldValue, k0> onValueChange, @NotNull l<? super ImeAction, k0> onImeActionPerformed) {
            t.i(textInputService, "textInputService");
            t.i(value, "value");
            t.i(editProcessor, "editProcessor");
            t.i(imeOptions, "imeOptions");
            t.i(onValueChange, "onValueChange");
            t.i(onImeActionPerformed, "onImeActionPerformed");
            return restartInput$foundation_release(textInputService, value, editProcessor, imeOptions, onValueChange, onImeActionPerformed);
        }

        @NotNull
        public final TextInputSession restartInput$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue value, @NotNull EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull l<? super TextFieldValue, k0> onValueChange, @NotNull l<? super ImeAction, k0> onImeActionPerformed) {
            t.i(textInputService, "textInputService");
            t.i(value, "value");
            t.i(editProcessor, "editProcessor");
            t.i(imeOptions, "imeOptions");
            t.i(onValueChange, "onValueChange");
            t.i(onImeActionPerformed, "onImeActionPerformed");
            return textInputService.startInput(value, imeOptions, new TextFieldDelegate$Companion$restartInput$1(editProcessor, onValueChange), onImeActionPerformed);
        }

        /* JADX INFO: renamed from: setCursorOffset-ULxng0E$foundation_release, reason: not valid java name */
        public final void m725setCursorOffsetULxng0E$foundation_release(long j10, @NotNull TextLayoutResultProxy textLayoutResult, @NotNull EditProcessor editProcessor, @NotNull OffsetMapping offsetMapping, @NotNull l<? super TextFieldValue, k0> onValueChange) {
            t.i(textLayoutResult, "textLayoutResult");
            t.i(editProcessor, "editProcessor");
            t.i(offsetMapping, "offsetMapping");
            t.i(onValueChange, "onValueChange");
            onValueChange.invoke(TextFieldValue.m3505copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, TextRangeKt.TextRange(offsetMapping.transformedToOriginal(TextLayoutResultProxy.m743getOffsetForPosition3MmeM6k$default(textLayoutResult, j10, false, 2, null))), (TextRange) null, 5, (Object) null));
        }
    }

    private static final void onEditCommand(List<? extends EditCommand> list, EditProcessor editProcessor, l<? super TextFieldValue, k0> lVar) {
        Companion.onEditCommand(list, editProcessor, lVar);
    }
}
