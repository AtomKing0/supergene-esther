package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CursorAnchorInfoBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CursorAnchorInfoBuilderKt {
    @NotNull
    public static final CursorAnchorInfo build(@NotNull CursorAnchorInfo.Builder builder, @NotNull TextFieldValue textFieldValue, @NotNull TextLayoutResult textLayoutResult, @NotNull Matrix matrix) {
        t.i(builder, "<this>");
        t.i(textFieldValue, "textFieldValue");
        t.i(textLayoutResult, "textLayoutResult");
        t.i(matrix, "matrix");
        builder.reset();
        builder.setMatrix(matrix);
        int iM3333getMinimpl = TextRange.m3333getMinimpl(textFieldValue.m3510getSelectiond9O1mEE());
        builder.setSelectionRange(iM3333getMinimpl, TextRange.m3332getMaximpl(textFieldValue.m3510getSelectiond9O1mEE()));
        setInsertionMarker(builder, iM3333getMinimpl, textLayoutResult);
        TextRange textRangeM3509getCompositionMzsxiRA = textFieldValue.m3509getCompositionMzsxiRA();
        int iM3333getMinimpl2 = textRangeM3509getCompositionMzsxiRA != null ? TextRange.m3333getMinimpl(textRangeM3509getCompositionMzsxiRA.m3339unboximpl()) : -1;
        TextRange textRangeM3509getCompositionMzsxiRA2 = textFieldValue.m3509getCompositionMzsxiRA();
        int iM3332getMaximpl = textRangeM3509getCompositionMzsxiRA2 != null ? TextRange.m3332getMaximpl(textRangeM3509getCompositionMzsxiRA2.m3339unboximpl()) : -1;
        boolean z10 = false;
        if (iM3333getMinimpl2 >= 0 && iM3333getMinimpl2 < iM3332getMaximpl) {
            z10 = true;
        }
        if (z10) {
            builder.setComposingText(iM3333getMinimpl2, textFieldValue.getText().subSequence(iM3333getMinimpl2, iM3332getMaximpl));
        }
        CursorAnchorInfo cursorAnchorInfoBuild = builder.build();
        t.h(cursorAnchorInfoBuild, "build()");
        return cursorAnchorInfoBuild;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i10, TextLayoutResult textLayoutResult) {
        if (i10 < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i10);
        builder.setInsertionMarkerLocation(cursorRect.getLeft(), cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), textLayoutResult.getBidiRunDirection(i10) == ResolvedTextDirection.Rtl ? 4 : 0);
        return builder;
    }
}
