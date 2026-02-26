package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import h9.a;
import h9.l;
import h9.q;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class CoreTextFieldKt$CoreTextField$semanticsModifier$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ boolean $isPassword;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TransformedText $transformedText;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass1 extends v implements l<List<TextLayoutResult>, Boolean> {
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextFieldState textFieldState) {
            super(1);
            this.$state = textFieldState;
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull List<TextLayoutResult> it) {
            boolean z10;
            t.i(it, "it");
            if (this.$state.getLayoutResult() != null) {
                TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
                t.f(layoutResult);
                it.add(layoutResult.getValue());
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass2 extends v implements l<AnnotatedString, Boolean> {
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TextFieldState textFieldState) {
            super(1);
            this.$state = textFieldState;
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull AnnotatedString it) {
            t.i(it, "it");
            this.$state.getOnValueChange().invoke(new TextFieldValue(it.getText(), TextRangeKt.TextRange(it.getText().length()), (TextRange) null, 4, (k) null));
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass3 extends v implements q<Integer, Integer, Boolean, Boolean> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ OffsetMapping $offsetMapping;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ TextFieldValue $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(OffsetMapping offsetMapping, boolean z10, TextFieldValue textFieldValue, TextFieldSelectionManager textFieldSelectionManager, TextFieldState textFieldState) {
            super(3);
            this.$offsetMapping = offsetMapping;
            this.$enabled = z10;
            this.$value = textFieldValue;
            this.$manager = textFieldSelectionManager;
            this.$state = textFieldState;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
            return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
        }

        @NotNull
        public final Boolean invoke(int i10, int i11, boolean z10) {
            if (!z10) {
                i10 = this.$offsetMapping.transformedToOriginal(i10);
            }
            if (!z10) {
                i11 = this.$offsetMapping.transformedToOriginal(i11);
            }
            boolean z11 = false;
            if (this.$enabled && (i10 != TextRange.m3335getStartimpl(this.$value.m3510getSelectiond9O1mEE()) || i11 != TextRange.m3330getEndimpl(this.$value.m3510getSelectiond9O1mEE()))) {
                if (o.j(i10, i11) < 0 || o.e(i10, i11) > this.$value.getAnnotatedString().length()) {
                    this.$manager.exitSelectionMode$foundation_release();
                } else {
                    if (z10 || i10 == i11) {
                        this.$manager.exitSelectionMode$foundation_release();
                    } else {
                        this.$manager.enterSelectionMode$foundation_release();
                    }
                    this.$state.getOnValueChange().invoke(new TextFieldValue(this.$value.getAnnotatedString(), TextRangeKt.TextRange(i10, i11), (TextRange) null, 4, (k) null));
                    z11 = true;
                }
            }
            return Boolean.valueOf(z11);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass4 extends v implements a<Boolean> {
        final /* synthetic */ FocusRequester $focusRequester;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(TextFieldState textFieldState, FocusRequester focusRequester, boolean z10) {
            super(0);
            this.$state = textFieldState;
            this.$focusRequester = focusRequester;
            this.$readOnly = z10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            CoreTextFieldKt.tapToFocus(this.$state, this.$focusRequester, !this.$readOnly);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$5, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass5 extends v implements a<Boolean> {
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(TextFieldSelectionManager textFieldSelectionManager) {
            super(0);
            this.$manager = textFieldSelectionManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            this.$manager.enterSelectionMode$foundation_release();
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$6, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass6 extends v implements a<Boolean> {
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(TextFieldSelectionManager textFieldSelectionManager) {
            super(0);
            this.$manager = textFieldSelectionManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            TextFieldSelectionManager.copy$foundation_release$default(this.$manager, false, 1, null);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$7, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass7 extends v implements a<Boolean> {
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(TextFieldSelectionManager textFieldSelectionManager) {
            super(0);
            this.$manager = textFieldSelectionManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            this.$manager.cut$foundation_release();
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$8, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass8 extends v implements a<Boolean> {
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(TextFieldSelectionManager textFieldSelectionManager) {
            super(0);
            this.$manager = textFieldSelectionManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            this.$manager.paste$foundation_release();
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$semanticsModifier$1(ImeOptions imeOptions, TransformedText transformedText, TextFieldValue textFieldValue, boolean z10, boolean z11, boolean z12, TextFieldState textFieldState, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, FocusRequester focusRequester) {
        super(1);
        this.$imeOptions = imeOptions;
        this.$transformedText = transformedText;
        this.$value = textFieldValue;
        this.$enabled = z10;
        this.$isPassword = z11;
        this.$readOnly = z12;
        this.$state = textFieldState;
        this.$offsetMapping = offsetMapping;
        this.$manager = textFieldSelectionManager;
        this.$focusRequester = focusRequester;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        SemanticsPropertiesKt.m3245setImeAction4L7nppU(semantics, this.$imeOptions.m3474getImeActioneUduSuo());
        SemanticsPropertiesKt.setEditableText(semantics, this.$transformedText.getText());
        SemanticsPropertiesKt.m3248setTextSelectionRangeFDrldGo(semantics, this.$value.m3510getSelectiond9O1mEE());
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled(semantics);
        }
        if (this.$isPassword) {
            SemanticsPropertiesKt.password(semantics);
        }
        SemanticsPropertiesKt.getTextLayoutResult$default(semantics, null, new AnonymousClass1(this.$state), 1, null);
        SemanticsPropertiesKt.setText$default(semantics, null, new AnonymousClass2(this.$state), 1, null);
        SemanticsPropertiesKt.setSelection$default(semantics, null, new AnonymousClass3(this.$offsetMapping, this.$enabled, this.$value, this.$manager, this.$state), 1, null);
        SemanticsPropertiesKt.onClick$default(semantics, null, new AnonymousClass4(this.$state, this.$focusRequester, this.$readOnly), 1, null);
        SemanticsPropertiesKt.onLongClick$default(semantics, null, new AnonymousClass5(this.$manager), 1, null);
        if (!TextRange.m3329getCollapsedimpl(this.$value.m3510getSelectiond9O1mEE()) && !this.$isPassword) {
            SemanticsPropertiesKt.copyText$default(semantics, null, new AnonymousClass6(this.$manager), 1, null);
            if (this.$enabled && !this.$readOnly) {
                SemanticsPropertiesKt.cutText$default(semantics, null, new AnonymousClass7(this.$manager), 1, null);
            }
        }
        if (!this.$enabled || this.$readOnly) {
            return;
        }
        SemanticsPropertiesKt.pasteText$default(semantics, null, new AnonymousClass8(this.$manager), 1, null);
    }
}
