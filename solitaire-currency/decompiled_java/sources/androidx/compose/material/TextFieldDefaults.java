package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextFieldDefaults {
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;

    @NotNull
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m3673constructorimpl(56);
    private static final float MinWidth = Dp.m3673constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m3673constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m3673constructorimpl(2);

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldDefaults.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z10, boolean z11, InteractionSource interactionSource, TextFieldColors textFieldColors, int i10, int i11) {
            super(2);
            this.$enabled = z10;
            this.$isError = z11;
            this.$interactionSource = interactionSource;
            this.$colors = textFieldColors;
            this.$$dirty = i10;
            this.$$dirty1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            boolean z10 = this.$enabled;
            boolean z11 = this.$isError;
            InteractionSource interactionSource = this.$interactionSource;
            TextFieldColors textFieldColors = this.$colors;
            int i11 = this.$$dirty;
            textFieldDefaults.m1190BorderBoxnbWgWpA(z10, z11, interactionSource, textFieldColors, null, 0.0f, 0.0f, composer, ((i11 >> 9) & 896) | ((i11 >> 6) & 14) | 12582912 | ((i11 >> 15) & 112) | ((this.$$dirty1 << 6) & 7168), 112);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldDefaults.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $border;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ p<Composer, Integer, k0> $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ p<Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, p<? super Composer, ? super Integer, k0> pVar, boolean z10, boolean z11, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z12, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, p<? super Composer, ? super Integer, k0> pVar5, TextFieldColors textFieldColors, PaddingValues paddingValues, p<? super Composer, ? super Integer, k0> pVar6, int i10, int i11, int i12) {
            super(2);
            this.$value = str;
            this.$innerTextField = pVar;
            this.$enabled = z10;
            this.$singleLine = z11;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = interactionSource;
            this.$isError = z12;
            this.$label = pVar2;
            this.$placeholder = pVar3;
            this.$leadingIcon = pVar4;
            this.$trailingIcon = pVar5;
            this.$colors = textFieldColors;
            this.$contentPadding = paddingValues;
            this.$border = pVar6;
            this.$$changed = i10;
            this.$$changed1 = i11;
            this.$$default = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            TextFieldDefaults.this.OutlinedTextFieldDecorationBox(this.$value, this.$innerTextField, this.$enabled, this.$singleLine, this.$visualTransformation, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$colors, this.$contentPadding, this.$border, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TextFieldDefaults.kt */
    static final class C09551 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ p<Composer, Integer, k0> $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ p<Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09551(String str, p<? super Composer, ? super Integer, k0> pVar, boolean z10, boolean z11, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z12, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, p<? super Composer, ? super Integer, k0> pVar5, TextFieldColors textFieldColors, PaddingValues paddingValues, int i10, int i11, int i12) {
            super(2);
            this.$value = str;
            this.$innerTextField = pVar;
            this.$enabled = z10;
            this.$singleLine = z11;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = interactionSource;
            this.$isError = z12;
            this.$label = pVar2;
            this.$placeholder = pVar3;
            this.$leadingIcon = pVar4;
            this.$trailingIcon = pVar5;
            this.$colors = textFieldColors;
            this.$contentPadding = paddingValues;
            this.$$changed = i10;
            this.$$changed1 = i11;
            this.$$default = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            TextFieldDefaults.this.TextFieldDecorationBox(this.$value, this.$innerTextField, this.$enabled, this.$singleLine, this.$visualTransformation, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$colors, this.$contentPadding, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    private TextFieldDefaults() {
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1187outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 2) != 0) {
            f11 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 4) != 0) {
            f12 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 8) != 0) {
            f13 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1197outlinedTextFieldPaddinga9UjIt4(f10, f11, f12, f13);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1188textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 2) != 0) {
            f11 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 4) != 0) {
            f12 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i10 & 8) != 0) {
            f13 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1199textFieldWithLabelPaddinga9UjIt4(f10, f11, f12, f13);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1189textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 2) != 0) {
            f11 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 4) != 0) {
            f12 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i10 & 8) != 0) {
            f13 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1200textFieldWithoutLabelPaddinga9UjIt4(f10, f11, f12, f13);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0109  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1190BorderBoxnbWgWpA(boolean r20, boolean r21, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.InteractionSource r22, @org.jetbrains.annotations.NotNull androidx.compose.material.TextFieldColors r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r24, float r25, float r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.m1190BorderBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013c  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OutlinedTextFieldDecorationBox(@org.jetbrains.annotations.NotNull java.lang.String r69, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r70, boolean r71, boolean r72, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.VisualTransformation r73, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.InteractionSource r74, boolean r75, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r76, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r77, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r78, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r79, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r80, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r81, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r82, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r83, int r84, int r85, int r86) {
        /*
            Method dump skipped, instruction units count: 948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, h9.p, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, h9.p, h9.p, h9.p, h9.p, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, h9.p, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0138  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void TextFieldDecorationBox(@org.jetbrains.annotations.NotNull java.lang.String r72, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r73, boolean r74, boolean r75, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.VisualTransformation r76, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.InteractionSource r77, boolean r78, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r79, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r80, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r81, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r82, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r83, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r84, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r85, int r86, int r87, int r88) {
        /*
            Method dump skipped, instruction units count: 889
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, h9.p, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, h9.p, h9.p, h9.p, h9.p, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1191getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1192getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1193getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public final Shape getOutlinedTextFieldShape(@Nullable Composer composer, int i10) {
        return MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public final Shape getTextFieldShape(@Nullable Composer composer, int i10) {
        return CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1194getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m1195indicatorLinegv0btCI(@NotNull Modifier indicatorLine, boolean z10, boolean z11, @NotNull InteractionSource interactionSource, @NotNull TextFieldColors colors, float f10, float f11) {
        t.i(indicatorLine, "$this$indicatorLine");
        t.i(interactionSource, "interactionSource");
        t.i(colors, "colors");
        return ComposedModifierKt.composed(indicatorLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(z10, z11, interactionSource, colors, f10, f11) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(z10, z11, interactionSource, colors, f10, f11));
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1196outlinedTextFieldColorsdx8h9Zs(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, @Nullable Composer composer, int i10, int i11, int i12, int i13) {
        composer.startReplaceableGroup(1762667317);
        long jM1597copywmQWz5c$default = (i13 & 1) != 0 ? Color.m1597copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM1597copywmQWz5c$default2 = (i13 & 2) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1633getTransparent0d7_KjU = (i13 & 4) != 0 ? Color.Companion.m1633getTransparent0d7_KjU() : j12;
        long jM951getPrimary0d7_KjU = (i13 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j13;
        long jM945getError0d7_KjU = (i13 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j14;
        long jM1597copywmQWz5c$default3 = (i13 & 32) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jM1597copywmQWz5c$default4 = (i13 & 64) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM1597copywmQWz5c$default5 = (i13 & 128) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM945getError0d7_KjU2 = (i13 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j18;
        long jM1597copywmQWz5c$default6 = (i13 & 512) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long jM1597copywmQWz5c$default7 = (i13 & 1024) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default6, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long j31 = (i13 & 2048) != 0 ? jM1597copywmQWz5c$default6 : j21;
        long jM1597copywmQWz5c$default8 = (i13 & 4096) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j22;
        long jM1597copywmQWz5c$default9 = (i13 & 8192) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default8, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        long jM945getError0d7_KjU3 = (i13 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j24;
        long jM1597copywmQWz5c$default10 = (32768 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j25;
        long jM1597copywmQWz5c$default11 = (65536 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j26;
        long jM1597copywmQWz5c$default12 = (131072 & i13) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        long jM945getError0d7_KjU4 = (262144 & i13) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j28;
        long jM1597copywmQWz5c$default13 = (524288 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j29;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM951getPrimary0d7_KjU, jM945getError0d7_KjU, jM1597copywmQWz5c$default3, jM1597copywmQWz5c$default4, jM945getError0d7_KjU2, jM1597copywmQWz5c$default5, jM1597copywmQWz5c$default6, jM1597copywmQWz5c$default7, j31, jM1597copywmQWz5c$default8, jM1597copywmQWz5c$default9, jM945getError0d7_KjU3, jM1633getTransparent0d7_KjU, jM1597copywmQWz5c$default10, jM1597copywmQWz5c$default11, jM1597copywmQWz5c$default12, jM945getError0d7_KjU4, jM1597copywmQWz5c$default13, (i13 & 1048576) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j30, null);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1197outlinedTextFieldPaddinga9UjIt4(float f10, float f11, float f12, float f13) {
        return PaddingKt.m395PaddingValuesa9UjIt4(f10, f11, f12, f13);
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1198textFieldColorsdx8h9Zs(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, @Nullable Composer composer, int i10, int i11, int i12, int i13) {
        composer.startReplaceableGroup(231892599);
        long jM1597copywmQWz5c$default = (i13 & 1) != 0 ? Color.m1597copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM1597copywmQWz5c$default2 = (i13 & 2) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1597copywmQWz5c$default3 = (i13 & 4) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long jM951getPrimary0d7_KjU = (i13 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j13;
        long jM945getError0d7_KjU = (i13 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j14;
        long jM1597copywmQWz5c$default4 = (i13 & 32) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jM1597copywmQWz5c$default5 = (i13 & 64) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM1597copywmQWz5c$default6 = (i13 & 128) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM945getError0d7_KjU2 = (i13 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j18;
        long jM1597copywmQWz5c$default7 = (i13 & 512) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long jM1597copywmQWz5c$default8 = (i13 & 1024) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long j31 = (i13 & 2048) != 0 ? jM1597copywmQWz5c$default7 : j21;
        long jM1597copywmQWz5c$default9 = (i13 & 4096) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j22;
        long jM1597copywmQWz5c$default10 = (i13 & 8192) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        long jM945getError0d7_KjU3 = (i13 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j24;
        long jM1597copywmQWz5c$default11 = (32768 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j25;
        long jM1597copywmQWz5c$default12 = (65536 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j26;
        long jM1597copywmQWz5c$default13 = (131072 & i13) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        long jM945getError0d7_KjU4 = (262144 & i13) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j28;
        long jM1597copywmQWz5c$default14 = (524288 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j29;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM951getPrimary0d7_KjU, jM945getError0d7_KjU, jM1597copywmQWz5c$default4, jM1597copywmQWz5c$default5, jM945getError0d7_KjU2, jM1597copywmQWz5c$default6, jM1597copywmQWz5c$default7, jM1597copywmQWz5c$default8, j31, jM1597copywmQWz5c$default9, jM1597copywmQWz5c$default10, jM945getError0d7_KjU3, jM1597copywmQWz5c$default3, jM1597copywmQWz5c$default11, jM1597copywmQWz5c$default12, jM1597copywmQWz5c$default13, jM945getError0d7_KjU4, jM1597copywmQWz5c$default14, (i13 & 1048576) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j30, null);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1199textFieldWithLabelPaddinga9UjIt4(float f10, float f11, float f12, float f13) {
        return PaddingKt.m395PaddingValuesa9UjIt4(f10, f12, f11, f13);
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1200textFieldWithoutLabelPaddinga9UjIt4(float f10, float f11, float f12, float f13) {
        return PaddingKt.m395PaddingValuesa9UjIt4(f10, f11, f12, f13);
    }
}
