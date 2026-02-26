package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldKeyInput.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldKeyInput$process$2 extends v implements l<TextFieldPreparedSelection, k0> {
    final /* synthetic */ KeyCommand $command;
    final /* synthetic */ i0 $consumed;
    final /* synthetic */ TextFieldKeyInput this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass1 extends v implements l<TextFieldPreparedSelection, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            invoke2(textFieldPreparedSelection);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull TextFieldPreparedSelection collapseLeftOr) {
            t.i(collapseLeftOr, "$this$collapseLeftOr");
            collapseLeftOr.moveCursorLeft();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass2 extends v implements l<TextFieldPreparedSelection, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            invoke2(textFieldPreparedSelection);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull TextFieldPreparedSelection collapseRightOr) {
            t.i(collapseRightOr, "$this$collapseRightOr");
            collapseRightOr.moveCursorRight();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$3, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass3 extends v implements l<TextFieldPreparedSelection, EditCommand> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final EditCommand invoke(@NotNull TextFieldPreparedSelection deleteIfSelectedOr) {
            t.i(deleteIfSelectedOr, "$this$deleteIfSelectedOr");
            return new DeleteSurroundingTextCommand(TextRange.m3330getEndimpl(deleteIfSelectedOr.m756getSelectiond9O1mEE()) - deleteIfSelectedOr.getPrecedingCharacterIndex(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$4, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass4 extends v implements l<TextFieldPreparedSelection, EditCommand> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final EditCommand invoke(@NotNull TextFieldPreparedSelection deleteIfSelectedOr) {
            t.i(deleteIfSelectedOr, "$this$deleteIfSelectedOr");
            int nextCharacterIndex = deleteIfSelectedOr.getNextCharacterIndex();
            if (nextCharacterIndex != -1) {
                return new DeleteSurroundingTextCommand(0, nextCharacterIndex - TextRange.m3330getEndimpl(deleteIfSelectedOr.m756getSelectiond9O1mEE()));
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$5, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass5 extends v implements l<TextFieldPreparedSelection, EditCommand> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final EditCommand invoke(@NotNull TextFieldPreparedSelection deleteIfSelectedOr) {
            t.i(deleteIfSelectedOr, "$this$deleteIfSelectedOr");
            Integer previousWordOffset = deleteIfSelectedOr.getPreviousWordOffset();
            if (previousWordOffset == null) {
                return null;
            }
            return new DeleteSurroundingTextCommand(TextRange.m3330getEndimpl(deleteIfSelectedOr.m756getSelectiond9O1mEE()) - previousWordOffset.intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$6, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass6 extends v implements l<TextFieldPreparedSelection, EditCommand> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        AnonymousClass6() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final EditCommand invoke(@NotNull TextFieldPreparedSelection deleteIfSelectedOr) {
            t.i(deleteIfSelectedOr, "$this$deleteIfSelectedOr");
            Integer nextWordOffset = deleteIfSelectedOr.getNextWordOffset();
            if (nextWordOffset != null) {
                return new DeleteSurroundingTextCommand(0, nextWordOffset.intValue() - TextRange.m3330getEndimpl(deleteIfSelectedOr.m756getSelectiond9O1mEE()));
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$7, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass7 extends v implements l<TextFieldPreparedSelection, EditCommand> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        AnonymousClass7() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final EditCommand invoke(@NotNull TextFieldPreparedSelection deleteIfSelectedOr) {
            t.i(deleteIfSelectedOr, "$this$deleteIfSelectedOr");
            Integer lineStartByOffset = deleteIfSelectedOr.getLineStartByOffset();
            if (lineStartByOffset == null) {
                return null;
            }
            return new DeleteSurroundingTextCommand(TextRange.m3330getEndimpl(deleteIfSelectedOr.m756getSelectiond9O1mEE()) - lineStartByOffset.intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$8, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass8 extends v implements l<TextFieldPreparedSelection, EditCommand> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        AnonymousClass8() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final EditCommand invoke(@NotNull TextFieldPreparedSelection deleteIfSelectedOr) {
            t.i(deleteIfSelectedOr, "$this$deleteIfSelectedOr");
            Integer lineEndByOffset = deleteIfSelectedOr.getLineEndByOffset();
            if (lineEndByOffset != null) {
                return new DeleteSurroundingTextCommand(0, lineEndByOffset.intValue() - TextRange.m3330getEndimpl(deleteIfSelectedOr.m756getSelectiond9O1mEE()));
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            iArr[KeyCommand.COPY.ordinal()] = 1;
            iArr[KeyCommand.PASTE.ordinal()] = 2;
            iArr[KeyCommand.CUT.ordinal()] = 3;
            iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            iArr[KeyCommand.UP.ordinal()] = 10;
            iArr[KeyCommand.DOWN.ordinal()] = 11;
            iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            iArr[KeyCommand.LINE_START.ordinal()] = 14;
            iArr[KeyCommand.LINE_END.ordinal()] = 15;
            iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            iArr[KeyCommand.HOME.ordinal()] = 18;
            iArr[KeyCommand.END.ordinal()] = 19;
            iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            iArr[KeyCommand.TAB.ordinal()] = 27;
            iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            iArr[KeyCommand.DESELECT.ordinal()] = 45;
            iArr[KeyCommand.UNDO.ordinal()] = 46;
            iArr[KeyCommand.REDO.ordinal()] = 47;
            iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldKeyInput$process$2(KeyCommand keyCommand, TextFieldKeyInput textFieldKeyInput, i0 i0Var) {
        super(1);
        this.$command = keyCommand;
        this.this$0 = textFieldKeyInput;
        this.$consumed = i0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
        invoke2(textFieldPreparedSelection);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TextFieldPreparedSelection commandExecutionContext) {
        TextFieldValue textFieldValueUndo;
        TextFieldValue textFieldValueRedo;
        t.i(commandExecutionContext, "$this$commandExecutionContext");
        switch (WhenMappings.$EnumSwitchMapping$0[this.$command.ordinal()]) {
            case 1:
                this.this$0.getSelectionManager().copy$foundation_release(false);
                break;
            case 2:
                this.this$0.getSelectionManager().paste$foundation_release();
                break;
            case 3:
                this.this$0.getSelectionManager().cut$foundation_release();
                break;
            case 4:
                commandExecutionContext.collapseLeftOr(AnonymousClass1.INSTANCE);
                break;
            case 5:
                commandExecutionContext.collapseRightOr(AnonymousClass2.INSTANCE);
                break;
            case 6:
                commandExecutionContext.moveCursorLeftByWord();
                break;
            case 7:
                commandExecutionContext.moveCursorRightByWord();
                break;
            case 8:
                commandExecutionContext.moveCursorPrevByParagraph();
                break;
            case 9:
                commandExecutionContext.moveCursorNextByParagraph();
                break;
            case 10:
                commandExecutionContext.moveCursorUpByLine();
                break;
            case 11:
                commandExecutionContext.moveCursorDownByLine();
                break;
            case 12:
                commandExecutionContext.moveCursorUpByPage();
                break;
            case 13:
                commandExecutionContext.moveCursorDownByPage();
                break;
            case 14:
                commandExecutionContext.moveCursorToLineStart();
                break;
            case 15:
                commandExecutionContext.moveCursorToLineEnd();
                break;
            case 16:
                commandExecutionContext.moveCursorToLineLeftSide();
                break;
            case 17:
                commandExecutionContext.moveCursorToLineRightSide();
                break;
            case 18:
                commandExecutionContext.moveCursorToHome();
                break;
            case 19:
                commandExecutionContext.moveCursorToEnd();
                break;
            case 20:
                List<EditCommand> listDeleteIfSelectedOr = commandExecutionContext.deleteIfSelectedOr(AnonymousClass3.INSTANCE);
                if (listDeleteIfSelectedOr != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr);
                }
                break;
            case 21:
                List<EditCommand> listDeleteIfSelectedOr2 = commandExecutionContext.deleteIfSelectedOr(AnonymousClass4.INSTANCE);
                if (listDeleteIfSelectedOr2 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr2);
                }
                break;
            case 22:
                List<EditCommand> listDeleteIfSelectedOr3 = commandExecutionContext.deleteIfSelectedOr(AnonymousClass5.INSTANCE);
                if (listDeleteIfSelectedOr3 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr3);
                }
                break;
            case 23:
                List<EditCommand> listDeleteIfSelectedOr4 = commandExecutionContext.deleteIfSelectedOr(AnonymousClass6.INSTANCE);
                if (listDeleteIfSelectedOr4 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr4);
                }
                break;
            case 24:
                List<EditCommand> listDeleteIfSelectedOr5 = commandExecutionContext.deleteIfSelectedOr(AnonymousClass7.INSTANCE);
                if (listDeleteIfSelectedOr5 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr5);
                }
                break;
            case 25:
                List<EditCommand> listDeleteIfSelectedOr6 = commandExecutionContext.deleteIfSelectedOr(AnonymousClass8.INSTANCE);
                if (listDeleteIfSelectedOr6 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr6);
                }
                break;
            case 26:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply(new CommitTextCommand("\n", 1));
                } else {
                    this.$consumed.f29826a = false;
                }
                break;
            case 27:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply(new CommitTextCommand("\t", 1));
                } else {
                    this.$consumed.f29826a = false;
                }
                break;
            case 28:
                commandExecutionContext.selectAll();
                break;
            case 29:
                commandExecutionContext.moveCursorLeft().selectMovement();
                break;
            case 30:
                commandExecutionContext.moveCursorRight().selectMovement();
                break;
            case 31:
                commandExecutionContext.moveCursorLeftByWord().selectMovement();
                break;
            case 32:
                commandExecutionContext.moveCursorRightByWord().selectMovement();
                break;
            case 33:
                commandExecutionContext.moveCursorPrevByParagraph().selectMovement();
                break;
            case 34:
                commandExecutionContext.moveCursorNextByParagraph().selectMovement();
                break;
            case 35:
                commandExecutionContext.moveCursorToLineStart().selectMovement();
                break;
            case 36:
                commandExecutionContext.moveCursorToLineEnd().selectMovement();
                break;
            case 37:
                commandExecutionContext.moveCursorToLineLeftSide().selectMovement();
                break;
            case 38:
                commandExecutionContext.moveCursorToLineRightSide().selectMovement();
                break;
            case 39:
                commandExecutionContext.moveCursorUpByLine().selectMovement();
                break;
            case 40:
                commandExecutionContext.moveCursorDownByLine().selectMovement();
                break;
            case 41:
                commandExecutionContext.moveCursorUpByPage().selectMovement();
                break;
            case 42:
                commandExecutionContext.moveCursorDownByPage().selectMovement();
                break;
            case 43:
                commandExecutionContext.moveCursorToHome().selectMovement();
                break;
            case 44:
                commandExecutionContext.moveCursorToEnd().selectMovement();
                break;
            case 45:
                commandExecutionContext.deselect();
                break;
            case 46:
                UndoManager undoManager = this.this$0.getUndoManager();
                if (undoManager != null) {
                    undoManager.makeSnapshot(commandExecutionContext.getValue());
                }
                UndoManager undoManager2 = this.this$0.getUndoManager();
                if (undoManager2 != null && (textFieldValueUndo = undoManager2.undo()) != null) {
                    this.this$0.onValueChange.invoke(textFieldValueUndo);
                    break;
                }
                break;
            case 47:
                UndoManager undoManager3 = this.this$0.getUndoManager();
                if (undoManager3 != null && (textFieldValueRedo = undoManager3.redo()) != null) {
                    this.this$0.onValueChange.invoke(textFieldValueRedo);
                    break;
                }
                break;
            case 48:
                KeyEventHelpers_androidKt.showCharacterPalette();
                break;
        }
    }
}
