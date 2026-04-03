package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UndoManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UndoManager {
    private boolean forceNextSnapshot;

    @Nullable
    private Long lastSnapshot;
    private final int maxStoredCharacters;

    @Nullable
    private Entry redoStack;
    private int storedCharacters;

    @Nullable
    private Entry undoStack;

    public UndoManager() {
        this(0, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void removeLastUndo() {
        /*
            r3 = this;
            androidx.compose.foundation.text.UndoManager$Entry r0 = r3.undoStack
            r1 = 0
            if (r0 == 0) goto La
            androidx.compose.foundation.text.UndoManager$Entry r2 = r0.getNext()
            goto Lb
        La:
            r2 = r1
        Lb:
            if (r2 != 0) goto Le
            return
        Le:
            if (r0 == 0) goto L1b
            androidx.compose.foundation.text.UndoManager$Entry r2 = r0.getNext()
            if (r2 == 0) goto L1b
            androidx.compose.foundation.text.UndoManager$Entry r2 = r2.getNext()
            goto L1c
        L1b:
            r2 = r1
        L1c:
            if (r2 == 0) goto L23
            androidx.compose.foundation.text.UndoManager$Entry r0 = r0.getNext()
            goto Le
        L23:
            if (r0 != 0) goto L26
            goto L29
        L26:
            r0.setNext(r1)
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.UndoManager.removeLastUndo():void");
    }

    public static /* synthetic */ void snapshotIfNeeded$default(UndoManager undoManager, TextFieldValue textFieldValue, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = UndoManager_jvmKt.timeNowMillis();
        }
        undoManager.snapshotIfNeeded(textFieldValue, j10);
    }

    public final void forceNextSnapshot() {
        this.forceNextSnapshot = true;
    }

    public final int getMaxStoredCharacters() {
        return this.maxStoredCharacters;
    }

    public final void makeSnapshot(@NotNull TextFieldValue value) {
        TextFieldValue value2;
        t.i(value, "value");
        this.forceNextSnapshot = false;
        Entry entry = this.undoStack;
        if (t.d(value, entry != null ? entry.getValue() : null)) {
            return;
        }
        String text = value.getText();
        Entry entry2 = this.undoStack;
        if (t.d(text, (entry2 == null || (value2 = entry2.getValue()) == null) ? null : value2.getText())) {
            Entry entry3 = this.undoStack;
            if (entry3 == null) {
                return;
            }
            entry3.setValue(value);
            return;
        }
        this.undoStack = new Entry(this.undoStack, value);
        this.redoStack = null;
        int length = this.storedCharacters + value.getText().length();
        this.storedCharacters = length;
        if (length > this.maxStoredCharacters) {
            removeLastUndo();
        }
    }

    @Nullable
    public final TextFieldValue redo() {
        Entry entry = this.redoStack;
        if (entry == null) {
            return null;
        }
        this.redoStack = entry.getNext();
        this.undoStack = new Entry(this.undoStack, entry.getValue());
        this.storedCharacters += entry.getValue().getText().length();
        return entry.getValue();
    }

    public final void snapshotIfNeeded(@NotNull TextFieldValue value, long j10) {
        t.i(value, "value");
        if (!this.forceNextSnapshot) {
            Long l10 = this.lastSnapshot;
            if (j10 <= (l10 != null ? l10.longValue() : 0L) + ((long) UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS())) {
                return;
            }
        }
        this.lastSnapshot = Long.valueOf(j10);
        makeSnapshot(value);
    }

    @Nullable
    public final TextFieldValue undo() {
        Entry next;
        Entry entry = this.undoStack;
        if (entry == null || (next = entry.getNext()) == null) {
            return null;
        }
        this.undoStack = next;
        this.storedCharacters -= entry.getValue().getText().length();
        this.redoStack = new Entry(this.redoStack, entry.getValue());
        return next.getValue();
    }

    public UndoManager(int i10) {
        this.maxStoredCharacters = i10;
    }

    /* JADX INFO: compiled from: UndoManager.kt */
    private static final class Entry {

        @Nullable
        private Entry next;

        @NotNull
        private TextFieldValue value;

        public Entry(@Nullable Entry entry, @NotNull TextFieldValue value) {
            t.i(value, "value");
            this.next = entry;
            this.value = value;
        }

        @Nullable
        public final Entry getNext() {
            return this.next;
        }

        @NotNull
        public final TextFieldValue getValue() {
            return this.value;
        }

        public final void setNext(@Nullable Entry entry) {
            this.next = entry;
        }

        public final void setValue(@NotNull TextFieldValue textFieldValue) {
            t.i(textFieldValue, "<set-?>");
            this.value = textFieldValue;
        }

        public /* synthetic */ Entry(Entry entry, TextFieldValue textFieldValue, int i10, k kVar) {
            this((i10 & 1) != 0 ? null : entry, textFieldValue);
        }
    }

    public /* synthetic */ UndoManager(int i10, int i11, k kVar) {
        this((i11 & 1) != 0 ? 100000 : i10);
    }
}
