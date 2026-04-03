package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextPreparedSelection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {

    @NotNull
    private final TextFieldValue currentValue;

    @Nullable
    private final TextLayoutResultProxy layoutResultProxy;

    public /* synthetic */ TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy, TextPreparedSelectionState textPreparedSelectionState, int i10, k kVar) {
        this(textFieldValue, (i10 & 2) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, textLayoutResultProxy, (i10 & 8) != 0 ? new TextPreparedSelectionState() : textPreparedSelectionState);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy r6, int r7) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r6.getInnerTextFieldCoordinates()
            if (r0 == 0) goto L15
            androidx.compose.ui.layout.LayoutCoordinates r1 = r6.getDecorationBoxCoordinates()
            r2 = 0
            if (r1 == 0) goto L13
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.b.a(r1, r0, r3, r4, r2)
        L13:
            if (r2 != 0) goto L1b
        L15:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L1b:
            androidx.compose.ui.text.input.OffsetMapping r0 = r5.getOffsetMapping()
            androidx.compose.ui.text.input.TextFieldValue r1 = r5.currentValue
            long r3 = r1.m3510getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m3330getEndimpl(r3)
            int r0 = r0.originalToTransformed(r1)
            androidx.compose.ui.text.TextLayoutResult r1 = r6.getValue()
            androidx.compose.ui.geometry.Rect r0 = r1.getCursorRect(r0)
            float r1 = r0.getLeft()
            float r0 = r0.getTop()
            long r2 = r2.m1400getSizeNHjbRc()
            float r2 = androidx.compose.ui.geometry.Size.m1433getHeightimpl(r2)
            float r7 = (float) r7
            float r2 = r2 * r7
            float r0 = r0 + r2
            androidx.compose.ui.text.input.OffsetMapping r7 = r5.getOffsetMapping()
            androidx.compose.ui.text.TextLayoutResult r6 = r6.getValue()
            long r0 = androidx.compose.ui.geometry.OffsetKt.Offset(r1, r0)
            int r6 = r6.m3320getOffsetForPositionk4lQ0M(r0)
            int r6 = r7.transformedToOriginal(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy, int):int");
    }

    @Nullable
    public final List<EditCommand> deleteIfSelectedOr(@NotNull l<? super TextFieldPreparedSelection, ? extends EditCommand> or) {
        t.i(or, "or");
        if (!TextRange.m3329getCollapsedimpl(m756getSelectiond9O1mEE())) {
            return v.n(new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.m3333getMinimpl(m756getSelectiond9O1mEE()), TextRange.m3333getMinimpl(m756getSelectiond9O1mEE())));
        }
        EditCommand editCommandInvoke = or.invoke(this);
        if (editCommandInvoke != null) {
            return u.e(editCommandInvoke);
        }
        return null;
    }

    @NotNull
    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    @Nullable
    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    @NotNull
    public final TextFieldValue getValue() {
        return TextFieldValue.m3505copy3r_uNRQ$default(this.currentValue, getAnnotatedString(), m756getSelectiond9O1mEE(), (TextRange) null, 4, (Object) null);
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorDownByPage() {
        TextLayoutResultProxy textLayoutResultProxy;
        if ((getText$foundation_release().length() > 0) && (textLayoutResultProxy = this.layoutResultProxy) != null) {
            setCursor(jumpByPagesOffset(textLayoutResultProxy, 1));
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorUpByPage() {
        TextLayoutResultProxy textLayoutResultProxy;
        if ((getText$foundation_release().length() > 0) && (textLayoutResultProxy = this.layoutResultProxy) != null) {
            setCursor(jumpByPagesOffset(textLayoutResultProxy, -1));
        }
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldPreparedSelection(@NotNull TextFieldValue currentValue, @NotNull OffsetMapping offsetMapping, @Nullable TextLayoutResultProxy textLayoutResultProxy, @NotNull TextPreparedSelectionState state) {
        super(currentValue.getAnnotatedString(), currentValue.m3510getSelectiond9O1mEE(), textLayoutResultProxy != null ? textLayoutResultProxy.getValue() : null, offsetMapping, state, null);
        t.i(currentValue, "currentValue");
        t.i(offsetMapping, "offsetMapping");
        t.i(state, "state");
        this.currentValue = currentValue;
        this.layoutResultProxy = textLayoutResultProxy;
    }
}
