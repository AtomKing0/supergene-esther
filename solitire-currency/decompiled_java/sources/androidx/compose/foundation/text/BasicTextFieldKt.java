package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BasicTextFieldKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1, reason: invalid class name */
    /* JADX INFO: compiled from: BasicTextField.kt */
    static final class AnonymousClass1 extends v implements l<TextLayoutResult, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull TextLayoutResult it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(TextLayoutResult textLayoutResult) {
            invoke2(textLayoutResult);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4, reason: invalid class name */
    /* JADX INFO: compiled from: BasicTextField.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ Brush $cursorBrush;
        final /* synthetic */ q<p<? super Composer, ? super Integer, k0>, Composer, Integer, k0> $decorationBox;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;
        final /* synthetic */ l<String, k0> $onValueChange;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(String str, l<? super String, k0> lVar, Modifier modifier, boolean z10, boolean z11, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z12, int i10, VisualTransformation visualTransformation, l<? super TextLayoutResult, k0> lVar2, MutableInteractionSource mutableInteractionSource, Brush brush, q<? super p<? super Composer, ? super Integer, k0>, ? super Composer, ? super Integer, k0> qVar, int i11, int i12, int i13) {
            super(2);
            this.$value = str;
            this.$onValueChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$readOnly = z11;
            this.$textStyle = textStyle;
            this.$keyboardOptions = keyboardOptions;
            this.$keyboardActions = keyboardActions;
            this.$singleLine = z12;
            this.$maxLines = i10;
            this.$visualTransformation = visualTransformation;
            this.$onTextLayout = lVar2;
            this.$interactionSource = mutableInteractionSource;
            this.$cursorBrush = brush;
            this.$decorationBox = qVar;
            this.$$changed = i11;
            this.$$changed1 = i12;
            this.$$default = i13;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            BasicTextFieldKt.BasicTextField(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$readOnly, this.$textStyle, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$visualTransformation, this.$onTextLayout, this.$interactionSource, this.$cursorBrush, this.$decorationBox, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5, reason: invalid class name */
    /* JADX INFO: compiled from: BasicTextField.kt */
    static final class AnonymousClass5 extends v implements l<TextLayoutResult, k0> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull TextLayoutResult it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(TextLayoutResult textLayoutResult) {
            invoke2(textLayoutResult);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8, reason: invalid class name */
    /* JADX INFO: compiled from: BasicTextField.kt */
    static final class AnonymousClass8 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ Brush $cursorBrush;
        final /* synthetic */ q<p<? super Composer, ? super Integer, k0>, Composer, Integer, k0> $decorationBox;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;
        final /* synthetic */ l<TextFieldValue, k0> $onValueChange;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass8(TextFieldValue textFieldValue, l<? super TextFieldValue, k0> lVar, Modifier modifier, boolean z10, boolean z11, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z12, int i10, VisualTransformation visualTransformation, l<? super TextLayoutResult, k0> lVar2, MutableInteractionSource mutableInteractionSource, Brush brush, q<? super p<? super Composer, ? super Integer, k0>, ? super Composer, ? super Integer, k0> qVar, int i11, int i12, int i13) {
            super(2);
            this.$value = textFieldValue;
            this.$onValueChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$readOnly = z11;
            this.$textStyle = textStyle;
            this.$keyboardOptions = keyboardOptions;
            this.$keyboardActions = keyboardActions;
            this.$singleLine = z12;
            this.$maxLines = i10;
            this.$visualTransformation = visualTransformation;
            this.$onTextLayout = lVar2;
            this.$interactionSource = mutableInteractionSource;
            this.$cursorBrush = brush;
            this.$decorationBox = qVar;
            this.$$changed = i11;
            this.$$changed1 = i12;
            this.$$default = i13;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            BasicTextFieldKt.BasicTextField(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$readOnly, this.$textStyle, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$visualTransformation, this.$onTextLayout, this.$interactionSource, this.$cursorBrush, this.$decorationBox, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:242:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0136  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(@org.jetbrains.annotations.NotNull java.lang.String r38, @org.jetbrains.annotations.NotNull h9.l<? super java.lang.String, v8.k0> r39, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r40, boolean r41, boolean r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r44, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r45, boolean r46, int r47, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r48, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.ui.text.TextLayoutResult, v8.k0> r49, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r50, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Brush r51, @org.jetbrains.annotations.Nullable h9.q<? super h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r52, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            Method dump skipped, instruction units count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, h9.l, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, h9.l, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, h9.q, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: renamed from: BasicTextField$lambda-2, reason: not valid java name */
    private static final TextFieldValue m650BasicTextField$lambda2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BasicTextField$lambda-5, reason: not valid java name */
    public static final String m652BasicTextField$lambda5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0136  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r35, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.ui.text.input.TextFieldValue, v8.k0> r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, boolean r38, boolean r39, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r40, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r41, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r42, boolean r43, int r44, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r45, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.ui.text.TextLayoutResult, v8.k0> r46, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r47, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Brush r48, @org.jetbrains.annotations.Nullable h9.q<? super h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r49, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r50, int r51, int r52, int r53) {
        /*
            Method dump skipped, instruction units count: 975
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, h9.l, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, h9.l, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, h9.q, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
