package androidx.compose.ui.text.input;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RecordingInputConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RecordingInputConnection implements InputConnection {
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;

    @NotNull
    private final List<EditCommand> editCommands;

    @NotNull
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive;

    @NotNull
    private TextFieldValue mTextFieldValue;

    public RecordingInputConnection(@NotNull TextFieldValue initState, @NotNull InputEventCallback2 eventCallback, boolean z10) {
        t.i(initState, "initState");
        t.i(eventCallback, "eventCallback");
        this.eventCallback = eventCallback;
        this.autoCorrect = z10;
        this.mTextFieldValue = initState;
        this.editCommands = new ArrayList();
        this.isActive = true;
    }

    private final void addEditCommandWithBatch(EditCommand editCommand) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    private final boolean endBatchEditInternal() {
        int i10 = this.batchDepth - 1;
        this.batchDepth = i10;
        if (i10 == 0 && (!this.editCommands.isEmpty())) {
            this.eventCallback.onEditCommands(d0.R0(this.editCommands));
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }

    private final boolean ensureActive(h9.a<k0> aVar) {
        boolean z10 = this.isActive;
        if (z10) {
            aVar.invoke();
        }
        return z10;
    }

    private final void sendSynthesizedKeyEvent(int i10) {
        sendKeyEvent(new KeyEvent(0, i10));
        sendKeyEvent(new KeyEvent(1, i10));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z10 = this.isActive;
        return z10 ? beginBatchEditInternal() : z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i10) {
        boolean z10 = this.isActive;
        if (z10) {
            return false;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(@Nullable CompletionInfo completionInfo) {
        boolean z10 = this.isActive;
        if (z10) {
            return false;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(@NotNull InputContentInfo inputContentInfo, int i10, @Nullable Bundle bundle) {
        t.i(inputContentInfo, "inputContentInfo");
        boolean z10 = this.isActive;
        if (z10) {
            return false;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(@Nullable CorrectionInfo correctionInfo) {
        boolean z10 = this.isActive;
        return z10 ? this.autoCorrect : z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(@Nullable CharSequence charSequence, int i10) {
        boolean z10 = this.isActive;
        if (z10) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(charSequence), i10));
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i10, int i11) {
        boolean z10 = this.isActive;
        if (!z10) {
            return z10;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(i10, i11));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i10, int i11) {
        boolean z10 = this.isActive;
        if (!z10) {
            return z10;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(i10, i11));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z10 = this.isActive;
        if (!z10) {
            return z10;
        }
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i10) {
        return TextUtils.getCapsMode(this.mTextFieldValue.getText(), TextRange.m3333getMinimpl(this.mTextFieldValue.m3510getSelectiond9O1mEE()), i10);
    }

    @NotNull
    public final InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public ExtractedText getExtractedText(@Nullable ExtractedTextRequest extractedTextRequest, int i10) {
        boolean z10 = (i10 & 1) != 0;
        this.extractedTextMonitorMode = z10;
        if (z10) {
            this.currentExtractedTextRequestToken = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return InputState_androidKt.toExtractedText(this.mTextFieldValue);
    }

    @Override // android.view.inputmethod.InputConnection
    @Nullable
    public Handler getHandler() {
        return null;
    }

    @NotNull
    public final TextFieldValue getMTextFieldValue$ui_release() {
        return this.mTextFieldValue;
    }

    @Override // android.view.inputmethod.InputConnection
    @Nullable
    public CharSequence getSelectedText(int i10) {
        if (TextRange.m3329getCollapsedimpl(this.mTextFieldValue.m3510getSelectiond9O1mEE())) {
            return null;
        }
        return TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public CharSequence getTextAfterCursor(int i10, int i11) {
        return TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, i10).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public CharSequence getTextBeforeCursor(int i10, int i11) {
        return TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, i10).toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i10) {
        boolean z10 = this.isActive;
        if (z10) {
            z10 = false;
            switch (i10) {
                case R.id.selectAll:
                    addEditCommandWithBatch(new SetSelectionCommand(0, this.mTextFieldValue.getText().length()));
                    break;
                case R.id.cut:
                    sendSynthesizedKeyEvent(277);
                    break;
                case R.id.copy:
                    sendSynthesizedKeyEvent(278);
                    break;
                case R.id.paste:
                    sendSynthesizedKeyEvent(279);
                    break;
            }
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i10) {
        int iM3463getDefaulteUduSuo;
        boolean z10 = this.isActive;
        if (!z10) {
            return z10;
        }
        if (i10 != 0) {
            switch (i10) {
                case 2:
                    iM3463getDefaulteUduSuo = ImeAction.Companion.m3465getGoeUduSuo();
                    break;
                case 3:
                    iM3463getDefaulteUduSuo = ImeAction.Companion.m3469getSearcheUduSuo();
                    break;
                case 4:
                    iM3463getDefaulteUduSuo = ImeAction.Companion.m3470getSendeUduSuo();
                    break;
                case 5:
                    iM3463getDefaulteUduSuo = ImeAction.Companion.m3466getNexteUduSuo();
                    break;
                case 6:
                    iM3463getDefaulteUduSuo = ImeAction.Companion.m3464getDoneeUduSuo();
                    break;
                case 7:
                    iM3463getDefaulteUduSuo = ImeAction.Companion.m3468getPreviouseUduSuo();
                    break;
                default:
                    Log.w(RecordingInputConnection_androidKt.TAG, "IME sends unsupported Editor Action: " + i10);
                    iM3463getDefaulteUduSuo = ImeAction.Companion.m3463getDefaulteUduSuo();
                    break;
            }
        } else {
            iM3463getDefaulteUduSuo = ImeAction.Companion.m3463getDefaulteUduSuo();
        }
        this.eventCallback.mo3477onImeActionKlQnJC8(iM3463getDefaulteUduSuo);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(@Nullable String str, @Nullable Bundle bundle) {
        boolean z10 = this.isActive;
        if (z10) {
            return true;
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z10) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i10) {
        boolean z10 = this.isActive;
        if (!z10) {
            return z10;
        }
        Log.w(RecordingInputConnection_androidKt.TAG, "requestCursorUpdates is not supported");
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(@NotNull KeyEvent event) {
        t.i(event, "event");
        boolean z10 = this.isActive;
        if (!z10) {
            return z10;
        }
        this.eventCallback.onKeyEvent(event);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i10, int i11) {
        boolean z10 = this.isActive;
        if (z10) {
            addEditCommandWithBatch(new SetComposingRegionCommand(i10, i11));
        }
        return z10;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(@Nullable CharSequence charSequence, int i10) {
        boolean z10 = this.isActive;
        if (z10) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(charSequence), i10));
        }
        return z10;
    }

    public final void setMTextFieldValue$ui_release(@NotNull TextFieldValue value) {
        t.i(value, "value");
        this.mTextFieldValue = value;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i10, int i11) {
        boolean z10 = this.isActive;
        if (!z10) {
            return z10;
        }
        addEditCommandWithBatch(new SetSelectionCommand(i10, i11));
        return true;
    }

    public final void updateInputState(@NotNull TextFieldValue state, @NotNull InputMethodManager inputMethodManager, @NotNull View view) {
        t.i(state, "state");
        t.i(inputMethodManager, "inputMethodManager");
        t.i(view, "view");
        if (this.isActive) {
            setMTextFieldValue$ui_release(state);
            if (this.extractedTextMonitorMode) {
                inputMethodManager.updateExtractedText(view, this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(state));
            }
            TextRange textRangeM3509getCompositionMzsxiRA = state.m3509getCompositionMzsxiRA();
            int iM3333getMinimpl = textRangeM3509getCompositionMzsxiRA != null ? TextRange.m3333getMinimpl(textRangeM3509getCompositionMzsxiRA.m3339unboximpl()) : -1;
            TextRange textRangeM3509getCompositionMzsxiRA2 = state.m3509getCompositionMzsxiRA();
            inputMethodManager.updateSelection(view, TextRange.m3333getMinimpl(state.m3510getSelectiond9O1mEE()), TextRange.m3332getMaximpl(state.m3510getSelectiond9O1mEE()), iM3333getMinimpl, textRangeM3509getCompositionMzsxiRA2 != null ? TextRange.m3332getMaximpl(textRangeM3509getCompositionMzsxiRA2.m3339unboximpl()) : -1);
        }
    }

    private final void logDebug(String str) {
    }
}
