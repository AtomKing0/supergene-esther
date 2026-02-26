package androidx.compose.ui.text.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.text.TextRange;
import androidx.media3.extractor.ts.PsExtractor;
import j9.c;
import java.util.List;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.d;
import r9.g;
import v8.k0;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {

    @NotNull
    private final l baseInputConnection$delegate;
    private boolean editorHasFocus;

    @Nullable
    private Rect focusedRect;

    @Nullable
    private RecordingInputConnection ic;

    @NotNull
    private ImeOptions imeOptions;

    @NotNull
    private final InputMethodManager inputMethodManager;

    @NotNull
    private h9.l<? super List<? extends EditCommand>, k0> onEditCommand;

    @NotNull
    private h9.l<? super ImeAction, k0> onImeActionPerformed;

    @NotNull
    private TextFieldValue state;

    @NotNull
    private final d<TextInputCommand> textInputCommandChannel;

    @NotNull
    private final View view;

    /* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
    private enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    /* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            iArr[TextInputCommand.StartInput.ordinal()] = 1;
            iArr[TextInputCommand.StopInput.ordinal()] = 2;
            iArr[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            iArr[TextInputCommand.HideKeyboard.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
    static final class C10081 extends v implements h9.l<List<? extends EditCommand>, k0> {
        public static final C10081 INSTANCE = new C10081();

        C10081() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<? extends EditCommand> it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(List<? extends EditCommand> list) {
            invoke2(list);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
    @f(c = "androidx.compose.ui.text.input.TextInputServiceAndroid", f = "TextInputServiceAndroid.android.kt", l = {PsExtractor.PRIVATE_STREAM_1}, m = "textInputCommandEventLoop")
    static final class C10091 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10091(z8.d<? super C10091> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextInputServiceAndroid.this.textInputCommandEventLoop(this);
        }
    }

    public TextInputServiceAndroid(@NotNull View view, @NotNull InputMethodManager inputMethodManager) {
        t.i(view, "view");
        t.i(inputMethodManager, "inputMethodManager");
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.onEditCommand = TextInputServiceAndroid$onEditCommand$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$onImeActionPerformed$1.INSTANCE;
        this.state = new TextFieldValue("", TextRange.Companion.m3340getZerod9O1mEE(), (TextRange) null, 4, (k) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.baseInputConnection$delegate = n.b(p.f35203c, new TextInputServiceAndroid$baseInputConnection$2(this));
        this.textInputCommandChannel = g.b(Integer.MAX_VALUE, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput(this.view);
    }

    private final void setKeyboardVisibleImmediately(boolean z10) {
        if (z10) {
            this.inputMethodManager.showSoftInput(this.view);
        } else {
            this.inputMethodManager.hideSoftInputFromWindow(this.view.getWindowToken());
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Boolean] */
    private static final void textInputCommandEventLoop$applyToState(TextInputCommand textInputCommand, n0<Boolean> n0Var, n0<Boolean> n0Var2) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[textInputCommand.ordinal()];
        if (i10 == 1) {
            ?? r32 = Boolean.TRUE;
            n0Var.f29834a = r32;
            n0Var2.f29834a = r32;
        } else if (i10 == 2) {
            ?? r33 = Boolean.FALSE;
            n0Var.f29834a = r33;
            n0Var2.f29834a = r33;
        } else if ((i10 == 3 || i10 == 4) && !t.d(n0Var.f29834a, Boolean.FALSE)) {
            n0Var2.f29834a = Boolean.valueOf(textInputCommand == TextInputCommand.ShowKeyboard);
        }
    }

    @Nullable
    public final InputConnection createInputConnection(@NotNull EditorInfo outAttrs) {
        t.i(outAttrs, "outAttrs");
        if (!this.editorHasFocus) {
            return null;
        }
        TextInputServiceAndroid_androidKt.update(outAttrs, this.imeOptions, this.state);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new InputEventCallback2() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid.createInputConnection.1
            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void onEditCommands(@NotNull List<? extends EditCommand> editCommands) {
                t.i(editCommands, "editCommands");
                TextInputServiceAndroid.this.onEditCommand.invoke(editCommands);
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            /* JADX INFO: renamed from: onImeAction-KlQnJC8 */
            public void mo3477onImeActionKlQnJC8(int i10) {
                TextInputServiceAndroid.this.onImeActionPerformed.invoke(ImeAction.m3456boximpl(i10));
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void onKeyEvent(@NotNull KeyEvent event) {
                t.i(event, "event");
                TextInputServiceAndroid.this.getBaseInputConnection().sendKeyEvent(event);
            }
        }, this.imeOptions.getAutoCorrect());
        this.ic = recordingInputConnection;
        return recordingInputConnection;
    }

    @NotNull
    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void hideSoftwareKeyboard() {
        this.textInputCommandChannel.f(TextInputCommand.HideKeyboard);
    }

    public final boolean isEditorFocused() {
        return this.editorHasFocus;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void notifyFocusedRect(@NotNull androidx.compose.ui.geometry.Rect rect) {
        t.i(rect, "rect");
        Rect rect2 = new Rect(c.c(rect.getLeft()), c.c(rect.getTop()), c.c(rect.getRight()), c.c(rect.getBottom()));
        this.focusedRect = rect2;
        if (this.ic == null) {
            this.view.requestRectangleOnScreen(new Rect(rect2));
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void showSoftwareKeyboard() {
        this.textInputCommandChannel.f(TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void startInput(@NotNull TextFieldValue value, @NotNull ImeOptions imeOptions, @NotNull h9.l<? super List<? extends EditCommand>, k0> onEditCommand, @NotNull h9.l<? super ImeAction, k0> onImeActionPerformed) {
        t.i(value, "value");
        t.i(imeOptions, "imeOptions");
        t.i(onEditCommand, "onEditCommand");
        t.i(onImeActionPerformed, "onImeActionPerformed");
        this.editorHasFocus = true;
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = onEditCommand;
        this.onImeActionPerformed = onImeActionPerformed;
        this.textInputCommandChannel.f(TextInputCommand.StartInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = C10081.INSTANCE;
        this.onImeActionPerformed = AnonymousClass2.INSTANCE;
        this.focusedRect = null;
        this.textInputCommandChannel.f(TextInputCommand.StopInput);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object textInputCommandEventLoop(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.text.input.TextInputServiceAndroid.C10091
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1 r0 = (androidx.compose.ui.text.input.TextInputServiceAndroid.C10091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1 r0 = new androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r2 = r0.L$1
            r9.f r2 = (r9.f) r2
            java.lang.Object r4 = r0.L$0
            androidx.compose.ui.text.input.TextInputServiceAndroid r4 = (androidx.compose.ui.text.input.TextInputServiceAndroid) r4
            v8.u.b(r9)
            goto L51
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L39:
            v8.u.b(r9)
            r9.d<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r8.textInputCommandChannel
            r9.f r9 = r9.iterator()
            r4 = r8
            r2 = r9
        L44:
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = r2.b(r0)
            if (r9 != r1) goto L51
            return r1
        L51:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lbd
            java.lang.Object r9 = r2.next()
            androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r9 = (androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand) r9
            android.view.View r5 = r4.view
            boolean r5 = r5.isFocused()
            if (r5 != 0) goto L74
        L67:
            r9.d<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r4.textInputCommandChannel
            java.lang.Object r9 = r9.h()
            boolean r9 = r9.h.i(r9)
            if (r9 != 0) goto L67
            goto L44
        L74:
            kotlin.jvm.internal.n0 r5 = new kotlin.jvm.internal.n0
            r5.<init>()
            kotlin.jvm.internal.n0 r6 = new kotlin.jvm.internal.n0
            r6.<init>()
        L7e:
            if (r9 == 0) goto L90
            textInputCommandEventLoop$applyToState(r9, r5, r6)
            r9.d<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r4.textInputCommandChannel
            java.lang.Object r9 = r9.h()
            java.lang.Object r9 = r9.h.f(r9)
            androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r9 = (androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand) r9
            goto L7e
        L90:
            T r9 = r5.f29834a
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.b.a(r3)
            boolean r9 = kotlin.jvm.internal.t.d(r9, r7)
            if (r9 == 0) goto L9f
            r4.restartInputImmediately()
        L9f:
            T r9 = r6.f29834a
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            if (r9 == 0) goto Lac
            boolean r9 = r9.booleanValue()
            r4.setKeyboardVisibleImmediately(r9)
        Lac:
            T r9 = r5.f29834a
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r5)
            boolean r9 = kotlin.jvm.internal.t.d(r9, r5)
            if (r9 == 0) goto L44
            r4.restartInputImmediately()
            goto L44
        Lbd:
            v8.k0 r9 = v8.k0.f35197a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.textInputCommandEventLoop(z8.d):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void updateState(@Nullable TextFieldValue textFieldValue, @NotNull TextFieldValue newValue) {
        t.i(newValue, "newValue");
        boolean z10 = true;
        boolean z11 = false;
        boolean z12 = (TextRange.m3328equalsimpl0(this.state.m3510getSelectiond9O1mEE(), newValue.m3510getSelectiond9O1mEE()) && t.d(this.state.m3509getCompositionMzsxiRA(), newValue.m3509getCompositionMzsxiRA())) ? false : true;
        this.state = newValue;
        RecordingInputConnection recordingInputConnection = this.ic;
        if (recordingInputConnection != null) {
            recordingInputConnection.setMTextFieldValue$ui_release(newValue);
        }
        if (t.d(textFieldValue, newValue)) {
            if (z12) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                View view = this.view;
                int iM3333getMinimpl = TextRange.m3333getMinimpl(newValue.m3510getSelectiond9O1mEE());
                int iM3332getMaximpl = TextRange.m3332getMaximpl(newValue.m3510getSelectiond9O1mEE());
                TextRange textRangeM3509getCompositionMzsxiRA = this.state.m3509getCompositionMzsxiRA();
                int iM3333getMinimpl2 = textRangeM3509getCompositionMzsxiRA != null ? TextRange.m3333getMinimpl(textRangeM3509getCompositionMzsxiRA.m3339unboximpl()) : -1;
                TextRange textRangeM3509getCompositionMzsxiRA2 = this.state.m3509getCompositionMzsxiRA();
                inputMethodManager.updateSelection(view, iM3333getMinimpl, iM3332getMaximpl, iM3333getMinimpl2, textRangeM3509getCompositionMzsxiRA2 != null ? TextRange.m3332getMaximpl(textRangeM3509getCompositionMzsxiRA2.m3339unboximpl()) : -1);
                return;
            }
            return;
        }
        if (textFieldValue != null) {
            if (t.d(textFieldValue.getText(), newValue.getText()) && (!TextRange.m3328equalsimpl0(textFieldValue.m3510getSelectiond9O1mEE(), newValue.m3510getSelectiond9O1mEE()) || t.d(textFieldValue.m3509getCompositionMzsxiRA(), newValue.m3509getCompositionMzsxiRA()))) {
                z10 = false;
            }
            z11 = z10;
        }
        if (z11) {
            restartInputImmediately();
            return;
        }
        RecordingInputConnection recordingInputConnection2 = this.ic;
        if (recordingInputConnection2 != null) {
            recordingInputConnection2.updateInputState(this.state, this.inputMethodManager, this.view);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputServiceAndroid(@NotNull View view) {
        t.i(view, "view");
        Context context = view.getContext();
        t.h(context, "view.context");
        this(view, new InputMethodManagerImpl(context));
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
    static final class AnonymousClass2 extends v implements h9.l<ImeAction, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(ImeAction imeAction) {
            m3512invokeKlQnJC8(imeAction.m3462unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
        public final void m3512invokeKlQnJC8(int i10) {
        }
    }
}
