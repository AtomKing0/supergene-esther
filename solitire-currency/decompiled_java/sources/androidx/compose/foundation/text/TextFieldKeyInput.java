package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.u;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldKeyInput.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInput {
    private final boolean editable;

    @NotNull
    private final KeyMapping keyMapping;

    @NotNull
    private final OffsetMapping offsetMapping;

    @NotNull
    private final l<TextFieldValue, k0> onValueChange;

    @NotNull
    private final TextPreparedSelectionState preparedSelectionState;

    @NotNull
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;

    @NotNull
    private final TextFieldState state;

    @Nullable
    private final UndoManager undoManager;

    @NotNull
    private final TextFieldValue value;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass1 extends v implements l<TextFieldValue, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull TextFieldValue it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(TextFieldValue textFieldValue) {
            invoke2(textFieldValue);
            return k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldKeyInput(@NotNull TextFieldState state, @NotNull TextFieldSelectionManager selectionManager, @NotNull TextFieldValue value, boolean z10, boolean z11, @NotNull TextPreparedSelectionState preparedSelectionState, @NotNull OffsetMapping offsetMapping, @Nullable UndoManager undoManager, @NotNull KeyMapping keyMapping, @NotNull l<? super TextFieldValue, k0> onValueChange) {
        t.i(state, "state");
        t.i(selectionManager, "selectionManager");
        t.i(value, "value");
        t.i(preparedSelectionState, "preparedSelectionState");
        t.i(offsetMapping, "offsetMapping");
        t.i(keyMapping, "keyMapping");
        t.i(onValueChange, "onValueChange");
        this.state = state;
        this.selectionManager = selectionManager;
        this.value = value;
        this.editable = z10;
        this.singleLine = z11;
        this.preparedSelectionState = preparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyMapping = keyMapping;
        this.onValueChange = onValueChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(List<? extends EditCommand> list) {
        EditProcessor processor = this.state.getProcessor();
        List<? extends EditCommand> listR0 = d0.R0(list);
        listR0.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(processor.apply(listR0));
    }

    private final void commandExecutionContext(l<? super TextFieldPreparedSelection, k0> lVar) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        lVar.invoke(textFieldPreparedSelection);
        if (TextRange.m3328equalsimpl0(textFieldPreparedSelection.m756getSelectiond9O1mEE(), this.value.m3510getSelectiond9O1mEE()) && t.d(textFieldPreparedSelection.getAnnotatedString(), this.value.getAnnotatedString())) {
            return;
        }
        this.onValueChange.invoke(textFieldPreparedSelection.getValue());
    }

    /* JADX INFO: renamed from: typedCommand-ZmokQxo, reason: not valid java name */
    private final CommitTextCommand m726typedCommandZmokQxo(KeyEvent keyEvent) {
        if (!TextFieldKeyInput_androidKt.m729isTypedEventZmokQxo(keyEvent)) {
            return null;
        }
        String string = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), KeyEvent_androidKt.m2762getUtf16CodePointZmokQxo(keyEvent)).toString();
        t.h(string, "StringBuilder().appendCo…              .toString()");
        return new CommitTextCommand(string, 1);
    }

    public final boolean getEditable() {
        return this.editable;
    }

    @NotNull
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    @NotNull
    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    @NotNull
    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    @NotNull
    public final TextFieldState getState() {
        return this.state;
    }

    @Nullable
    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    @NotNull
    public final TextFieldValue getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: process-ZmokQxo, reason: not valid java name */
    public final boolean m727processZmokQxo(@NotNull KeyEvent event) {
        KeyCommand keyCommandMo672mapZmokQxo;
        t.i(event, "event");
        CommitTextCommand commitTextCommandM726typedCommandZmokQxo = m726typedCommandZmokQxo(event);
        if (commitTextCommandM726typedCommandZmokQxo != null) {
            if (!this.editable) {
                return false;
            }
            apply(commitTextCommandM726typedCommandZmokQxo);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        if (!KeyEventType.m2753equalsimpl0(KeyEvent_androidKt.m2761getTypeZmokQxo(event), KeyEventType.Companion.m2757getKeyDownCS__XNY()) || (keyCommandMo672mapZmokQxo = this.keyMapping.mo672mapZmokQxo(event)) == null || (keyCommandMo672mapZmokQxo.getEditsText() && !this.editable)) {
            return false;
        }
        i0 i0Var = new i0();
        i0Var.f29826a = true;
        commandExecutionContext(new TextFieldKeyInput$process$2(keyCommandMo672mapZmokQxo, this, i0Var));
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
        return i0Var.f29826a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(EditCommand editCommand) {
        apply(u.e(editCommand));
    }

    public /* synthetic */ TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z10, boolean z11, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, KeyMapping keyMapping, l lVar, int i10, k kVar) {
        this(textFieldState, textFieldSelectionManager, (i10 & 4) != 0 ? new TextFieldValue((String) null, 0L, (TextRange) null, 7, (k) null) : textFieldValue, (i10 & 8) != 0 ? true : z10, (i10 & 16) != 0 ? false : z11, textPreparedSelectionState, (i10 & 64) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, (i10 & 128) != 0 ? null : undoManager, (i10 & 256) != 0 ? KeyMapping_androidKt.getPlatformDefaultKeyMapping() : keyMapping, (i10 & 512) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }
}
