package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldKeyInput.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInputKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInputKt$textFieldKeyInput$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInputKt$textFieldKeyInput$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldKeyInput.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $editable;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ OffsetMapping $offsetMapping;
        final /* synthetic */ l<TextFieldValue, k0> $onValueChange;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ UndoManager $undoManager;
        final /* synthetic */ TextFieldValue $value;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInputKt$textFieldKeyInput$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldKeyInput.kt */
        /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.q implements l<KeyEvent, Boolean> {
            AnonymousClass1(Object obj) {
                super(1, obj, TextFieldKeyInput.class, "process", "process-ZmokQxo(Landroid/view/KeyEvent;)Z", 0);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m728invokeZmokQxo(keyEvent.m2749unboximpl());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m728invokeZmokQxo(@NotNull android.view.KeyEvent p02) {
                t.i(p02, "p0");
                return Boolean.valueOf(((TextFieldKeyInput) this.receiver).m727processZmokQxo(p02));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z10, boolean z11, OffsetMapping offsetMapping, UndoManager undoManager, l<? super TextFieldValue, k0> lVar) {
            super(3);
            this.$state = textFieldState;
            this.$manager = textFieldSelectionManager;
            this.$value = textFieldValue;
            this.$editable = z10;
            this.$singleLine = z11;
            this.$offsetMapping = offsetMapping;
            this.$undoManager = undoManager;
            this.$onValueChange = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(58482146);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TextPreparedSelectionState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.Companion, new AnonymousClass1(new TextFieldKeyInput(this.$state, this.$manager, this.$value, this.$editable, this.$singleLine, (TextPreparedSelectionState) objRememberedValue, this.$offsetMapping, this.$undoManager, null, this.$onValueChange, 256, null)));
            composer.endReplaceableGroup();
            return modifierOnKeyEvent;
        }
    }

    @NotNull
    public static final Modifier textFieldKeyInput(@NotNull Modifier modifier, @NotNull TextFieldState state, @NotNull TextFieldSelectionManager manager, @NotNull TextFieldValue value, @NotNull l<? super TextFieldValue, k0> onValueChange, boolean z10, boolean z11, @NotNull OffsetMapping offsetMapping, @NotNull UndoManager undoManager) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        t.i(manager, "manager");
        t.i(value, "value");
        t.i(onValueChange, "onValueChange");
        t.i(offsetMapping, "offsetMapping");
        t.i(undoManager, "undoManager");
        return ComposedModifierKt.composed$default(modifier, null, new AnonymousClass2(state, manager, value, z10, z11, offsetMapping, undoManager, onValueChange), 1, null);
    }
}
