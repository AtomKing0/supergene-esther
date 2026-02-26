package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.media3.extractor.ts.PsExtractor;
import h9.l;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldState {

    @NotNull
    private final MutableState handleState$delegate;

    @NotNull
    private final MutableState hasFocus$delegate;

    @Nullable
    private TextInputSession inputSession;

    @NotNull
    private final KeyboardActionRunner keyboardActionRunner;

    @Nullable
    private LayoutCoordinates layoutCoordinates;

    @NotNull
    private final MutableState layoutResult$delegate;

    @NotNull
    private final l<ImeAction, k0> onImeActionPerformed;

    @NotNull
    private final l<TextFieldValue, k0> onValueChange;

    @NotNull
    private l<? super TextFieldValue, k0> onValueChangeOriginal;

    @NotNull
    private final EditProcessor processor;

    @NotNull
    private final RecomposeScope recomposeScope;

    @NotNull
    private final Paint selectionPaint;

    @NotNull
    private final MutableState showCursorHandle$delegate;
    private boolean showFloatingToolbar;

    @NotNull
    private final MutableState showSelectionHandleEnd$delegate;

    @NotNull
    private final MutableState showSelectionHandleStart$delegate;

    @NotNull
    private TextDelegate textDelegate;

    public TextFieldState(@NotNull TextDelegate textDelegate, @NotNull RecomposeScope recomposeScope) {
        t.i(textDelegate, "textDelegate");
        t.i(recomposeScope, "recomposeScope");
        this.textDelegate = textDelegate;
        this.recomposeScope = recomposeScope;
        this.processor = new EditProcessor();
        Boolean bool = Boolean.FALSE;
        this.hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.layoutResult$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.handleState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(HandleState.None, null, 2, null);
        this.showSelectionHandleStart$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showSelectionHandleEnd$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showCursorHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.keyboardActionRunner = new KeyboardActionRunner();
        this.onValueChangeOriginal = TextFieldState$onValueChangeOriginal$1.INSTANCE;
        this.onValueChange = new TextFieldState$onValueChange$1(this);
        this.onImeActionPerformed = new TextFieldState$onImeActionPerformed$1(this);
        this.selectionPaint = AndroidPaint_androidKt.Paint();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final HandleState getHandleState() {
        return (HandleState) this.handleState$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    @Nullable
    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final TextLayoutResultProxy getLayoutResult() {
        return (TextLayoutResultProxy) this.layoutResult$delegate.getValue();
    }

    @NotNull
    public final l<ImeAction, k0> getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    @NotNull
    public final l<TextFieldValue, k0> getOnValueChange() {
        return this.onValueChange;
    }

    @NotNull
    public final EditProcessor getProcessor() {
        return this.processor;
    }

    @NotNull
    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    @NotNull
    public final Paint getSelectionPaint() {
        return this.selectionPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    public final boolean getShowFloatingToolbar() {
        return this.showFloatingToolbar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSelectionHandleEnd() {
        return ((Boolean) this.showSelectionHandleEnd$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSelectionHandleStart() {
        return ((Boolean) this.showSelectionHandleStart$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setHandleState(@NotNull HandleState handleState) {
        t.i(handleState, "<set-?>");
        this.handleState$delegate.setValue(handleState);
    }

    public final void setHasFocus(boolean z10) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setInputSession(@Nullable TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    public final void setLayoutCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates = layoutCoordinates;
    }

    public final void setLayoutResult(@Nullable TextLayoutResultProxy textLayoutResultProxy) {
        this.layoutResult$delegate.setValue(textLayoutResultProxy);
    }

    public final void setShowCursorHandle(boolean z10) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setShowFloatingToolbar(boolean z10) {
        this.showFloatingToolbar = z10;
    }

    public final void setShowSelectionHandleEnd(boolean z10) {
        this.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setShowSelectionHandleStart(boolean z10) {
        this.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setTextDelegate(@NotNull TextDelegate textDelegate) {
        t.i(textDelegate, "<set-?>");
        this.textDelegate = textDelegate;
    }

    /* JADX INFO: renamed from: update-aKPr-nQ, reason: not valid java name */
    public final void m739updateaKPrnQ(@NotNull AnnotatedString visualText, @NotNull TextStyle textStyle, boolean z10, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, @NotNull l<? super TextFieldValue, k0> onValueChange, @NotNull KeyboardActions keyboardActions, @NotNull FocusManager focusManager, long j10) {
        t.i(visualText, "visualText");
        t.i(textStyle, "textStyle");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(onValueChange, "onValueChange");
        t.i(keyboardActions, "keyboardActions");
        t.i(focusManager, "focusManager");
        this.onValueChangeOriginal = onValueChange;
        this.selectionPaint.mo1488setColor8_81llA(j10);
        KeyboardActionRunner keyboardActionRunner = this.keyboardActionRunner;
        keyboardActionRunner.setKeyboardActions(keyboardActions);
        keyboardActionRunner.setFocusManager(focusManager);
        this.textDelegate = CoreTextKt.m667updateTextDelegatex_uQXYA(this.textDelegate, visualText, textStyle, density, fontFamilyResolver, (PsExtractor.AUDIO_STREAM & 32) != 0 ? true : z10, (PsExtractor.AUDIO_STREAM & 64) != 0 ? TextOverflow.Companion.m3626getClipgIe3tQ8() : 0, (PsExtractor.AUDIO_STREAM & 128) != 0 ? Integer.MAX_VALUE : 0, v.l());
    }
}
