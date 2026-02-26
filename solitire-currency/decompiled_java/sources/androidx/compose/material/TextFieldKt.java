package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m3673constructorimpl(20);
    private static final float TextFieldBottomPadding = Dp.m3673constructorimpl(10);
    private static final float TextFieldTopPadding = Dp.m3673constructorimpl(4);

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldKt$TextField$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextField.kt */
    static final class AnonymousClass2 extends v implements q<p<? super Composer, ? super Integer, ? extends k0>, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
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
        AnonymousClass2(String str, boolean z10, boolean z11, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z12, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, TextFieldColors textFieldColors, int i10, int i11) {
            super(3);
            this.$value = str;
            this.$enabled = z10;
            this.$singleLine = z11;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = mutableInteractionSource;
            this.$isError = z12;
            this.$label = pVar;
            this.$placeholder = pVar2;
            this.$leadingIcon = pVar3;
            this.$trailingIcon = pVar4;
            this.$colors = textFieldColors;
            this.$$dirty = i10;
            this.$$dirty1 = i11;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(p<? super Composer, ? super Integer, ? extends k0> pVar, Composer composer, Integer num) {
            invoke((p<? super Composer, ? super Integer, k0>) pVar, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        public final void invoke(@NotNull p<? super Composer, ? super Integer, k0> innerTextField, @Nullable Composer composer, int i10) {
            int i11;
            t.i(innerTextField, "innerTextField");
            if ((i10 & 14) == 0) {
                i11 = i10 | (composer.changed(innerTextField) ? 4 : 2);
            } else {
                i11 = i10;
            }
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String str = this.$value;
            boolean z10 = this.$enabled;
            boolean z11 = this.$singleLine;
            VisualTransformation visualTransformation = this.$visualTransformation;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            boolean z12 = this.$isError;
            p<Composer, Integer, k0> pVar = this.$label;
            p<Composer, Integer, k0> pVar2 = this.$placeholder;
            p<Composer, Integer, k0> pVar3 = this.$leadingIcon;
            p<Composer, Integer, k0> pVar4 = this.$trailingIcon;
            TextFieldColors textFieldColors = this.$colors;
            int i12 = this.$$dirty;
            int i13 = this.$$dirty1;
            textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z10, z11, visualTransformation, mutableInteractionSource, z12, pVar, pVar2, pVar3, pVar4, textFieldColors, null, composer, ((i13 >> 3) & 7168) | (i12 & 14) | ((i11 << 3) & 112) | ((i12 >> 3) & 896) | ((i13 << 9) & 57344) | ((i13 >> 3) & 458752) | ((i13 << 18) & 3670016) | ((i12 << 3) & 29360128) | ((i12 << 3) & 234881024) | ((i12 << 3) & 1879048192), ((i12 >> 27) & 14) | 3072 | ((i13 >> 21) & 112), 4096);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldKt$TextField$3, reason: invalid class name */
    /* JADX INFO: compiled from: TextField.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<String, k0> $onValueChange;
        final /* synthetic */ p<Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(String str, l<? super String, k0> lVar, Modifier modifier, boolean z10, boolean z11, TextStyle textStyle, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, boolean z12, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z13, int i10, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i11, int i12, int i13) {
            super(2);
            this.$value = str;
            this.$onValueChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$readOnly = z11;
            this.$textStyle = textStyle;
            this.$label = pVar;
            this.$placeholder = pVar2;
            this.$leadingIcon = pVar3;
            this.$trailingIcon = pVar4;
            this.$isError = z12;
            this.$visualTransformation = visualTransformation;
            this.$keyboardOptions = keyboardOptions;
            this.$keyboardActions = keyboardActions;
            this.$singleLine = z13;
            this.$maxLines = i10;
            this.$interactionSource = mutableInteractionSource;
            this.$shape = shape;
            this.$colors = textFieldColors;
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
            TextFieldKt.TextField(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$readOnly, this.$textStyle, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$isError, this.$visualTransformation, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$interactionSource, this.$shape, this.$colors, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldKt$TextField$5, reason: invalid class name */
    /* JADX INFO: compiled from: TextField.kt */
    static final class AnonymousClass5 extends v implements q<p<? super Composer, ? super Integer, ? extends k0>, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ p<Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(TextFieldValue textFieldValue, boolean z10, boolean z11, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z12, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, TextFieldColors textFieldColors, int i10, int i11) {
            super(3);
            this.$value = textFieldValue;
            this.$enabled = z10;
            this.$singleLine = z11;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = mutableInteractionSource;
            this.$isError = z12;
            this.$label = pVar;
            this.$placeholder = pVar2;
            this.$leadingIcon = pVar3;
            this.$trailingIcon = pVar4;
            this.$colors = textFieldColors;
            this.$$dirty = i10;
            this.$$dirty1 = i11;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(p<? super Composer, ? super Integer, ? extends k0> pVar, Composer composer, Integer num) {
            invoke((p<? super Composer, ? super Integer, k0>) pVar, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        public final void invoke(@NotNull p<? super Composer, ? super Integer, k0> innerTextField, @Nullable Composer composer, int i10) {
            int i11;
            t.i(innerTextField, "innerTextField");
            if ((i10 & 14) == 0) {
                i11 = i10 | (composer.changed(innerTextField) ? 4 : 2);
            } else {
                i11 = i10;
            }
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String text = this.$value.getText();
            boolean z10 = this.$enabled;
            boolean z11 = this.$singleLine;
            VisualTransformation visualTransformation = this.$visualTransformation;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            boolean z12 = this.$isError;
            p<Composer, Integer, k0> pVar = this.$label;
            p<Composer, Integer, k0> pVar2 = this.$placeholder;
            p<Composer, Integer, k0> pVar3 = this.$leadingIcon;
            p<Composer, Integer, k0> pVar4 = this.$trailingIcon;
            TextFieldColors textFieldColors = this.$colors;
            int i12 = this.$$dirty;
            int i13 = this.$$dirty1;
            textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z10, z11, visualTransformation, mutableInteractionSource, z12, pVar, pVar2, pVar3, pVar4, textFieldColors, null, composer, ((i13 >> 3) & 7168) | ((i11 << 3) & 112) | ((i12 >> 3) & 896) | ((i13 << 9) & 57344) | ((i13 >> 3) & 458752) | ((i13 << 18) & 3670016) | ((i12 << 3) & 29360128) | ((i12 << 3) & 234881024) | ((i12 << 3) & 1879048192), ((i12 >> 27) & 14) | 3072 | ((i13 >> 21) & 112), 4096);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldKt$TextField$6, reason: invalid class name */
    /* JADX INFO: compiled from: TextField.kt */
    static final class AnonymousClass6 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<TextFieldValue, k0> $onValueChange;
        final /* synthetic */ p<Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(TextFieldValue textFieldValue, l<? super TextFieldValue, k0> lVar, Modifier modifier, boolean z10, boolean z11, TextStyle textStyle, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, boolean z12, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z13, int i10, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i11, int i12, int i13) {
            super(2);
            this.$value = textFieldValue;
            this.$onValueChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$readOnly = z11;
            this.$textStyle = textStyle;
            this.$label = pVar;
            this.$placeholder = pVar2;
            this.$leadingIcon = pVar3;
            this.$trailingIcon = pVar4;
            this.$isError = z12;
            this.$visualTransformation = visualTransformation;
            this.$keyboardOptions = keyboardOptions;
            this.$keyboardActions = keyboardActions;
            this.$singleLine = z13;
            this.$maxLines = i10;
            this.$interactionSource = mutableInteractionSource;
            this.$shape = shape;
            this.$colors = textFieldColors;
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
            TextFieldKt.TextField(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$readOnly, this.$textStyle, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$isError, this.$visualTransformation, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$interactionSource, this.$shape, this.$colors, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldKt$TextFieldLayout$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TextField.kt */
    static final class C09562 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ float $animationProgress;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leading;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ PaddingValues $paddingValues;
        final /* synthetic */ q<Modifier, Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ p<Composer, Integer, k0> $textField;
        final /* synthetic */ p<Composer, Integer, k0> $trailing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09562(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, q<? super Modifier, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, boolean z10, float f10, PaddingValues paddingValues, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$textField = pVar;
            this.$label = pVar2;
            this.$placeholder = qVar;
            this.$leading = pVar3;
            this.$trailing = pVar4;
            this.$singleLine = z10;
            this.$animationProgress = f10;
            this.$paddingValues = paddingValues;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            TextFieldKt.TextFieldLayout(this.$modifier, this.$textField, this.$label, this.$placeholder, this.$leading, this.$trailing, this.$singleLine, this.$animationProgress, this.$paddingValues, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldKt$drawIndicatorLine$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextField.kt */
    static final class AnonymousClass1 extends v implements l<ContentDrawScope, k0> {
        final /* synthetic */ BorderStroke $indicatorBorder;
        final /* synthetic */ float $strokeWidthDp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f10, BorderStroke borderStroke) {
            super(1);
            this.$strokeWidthDp = f10;
            this.$indicatorBorder = borderStroke;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(ContentDrawScope contentDrawScope) {
            invoke2(contentDrawScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ContentDrawScope drawWithContent) {
            t.i(drawWithContent, "$this$drawWithContent");
            drawWithContent.drawContent();
            if (Dp.m3678equalsimpl0(this.$strokeWidthDp, Dp.Companion.m3691getHairlineD9Ej5fM())) {
                return;
            }
            float density = this.$strokeWidthDp * drawWithContent.getDensity();
            float fM1433getHeightimpl = Size.m1433getHeightimpl(drawWithContent.mo1996getSizeNHjbRc()) - (density / 2);
            b.B(drawWithContent, this.$indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, fM1433getHeightimpl), OffsetKt.Offset(Size.m1436getWidthimpl(drawWithContent.mo1996getSizeNHjbRc()), fM1433getHeightimpl), density, 0, null, 0.0f, null, 0, 496, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:301:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0134  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextField(@org.jetbrains.annotations.NotNull java.lang.String r71, @org.jetbrains.annotations.NotNull h9.l<? super java.lang.String, v8.k0> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r73, boolean r74, boolean r75, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r76, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r77, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r78, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r79, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r80, boolean r81, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r83, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r87, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r88, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r89, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r90, int r91, int r92, int r93) {
        /*
            Method dump skipped, instruction units count: 1542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, h9.l, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, h9.p, h9.p, h9.p, h9.p, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TextFieldLayout(@NotNull Modifier modifier, @NotNull p<? super Composer, ? super Integer, k0> textField, @Nullable p<? super Composer, ? super Integer, k0> pVar, @Nullable q<? super Modifier, ? super Composer, ? super Integer, k0> qVar, @Nullable p<? super Composer, ? super Integer, k0> pVar2, @Nullable p<? super Composer, ? super Integer, k0> pVar3, boolean z10, float f10, @NotNull PaddingValues paddingValues, @Nullable Composer composer, int i10) {
        int i11;
        t.i(modifier, "modifier");
        t.i(textField, "textField");
        t.i(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2112507061);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(textField) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(qVar) ? 2048 : 1024;
        }
        if ((57344 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar2) ? 16384 : 8192;
        }
        if ((458752 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar3) ? 131072 : 65536;
        }
        if ((3670016 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 1048576 : 524288;
        }
        if ((29360128 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(f10) ? 8388608 : 4194304;
        }
        if ((234881024 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(paddingValues) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((191739611 & i11) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Boolean boolValueOf = Boolean.valueOf(z10);
            Float fValueOf = Float.valueOf(f10);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(paddingValues);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TextFieldMeasurePolicy(z10, f10, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objRememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifier);
            int i12 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl, textFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection2, companion.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i12 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(642667778);
            if (((i12 >> 9) & 14 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                composerStartRestartGroup.startReplaceableGroup(254816194);
                if (pVar2 != null) {
                    Modifier modifierThen = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    a<ComposeUiNode> constructor2 = companion.getConstructor();
                    q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(modifierThen);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1258constructorimpl2 = Updater.m1258constructorimpl(composerStartRestartGroup);
                    Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion.getSetDensity());
                    Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection3, companion.getSetLayoutDirection());
                    Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(822730659);
                    pVar2.mo4invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 12) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(254816479);
                if (pVar3 != null) {
                    Modifier modifierThen2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    a<ComposeUiNode> constructor3 = companion.getConstructor();
                    q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf3 = LayoutKt.materializerOf(modifierThen2);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1258constructorimpl3 = Updater.m1258constructorimpl(composerStartRestartGroup);
                    Updater.m1265setimpl(composerM1258constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                    Updater.m1265setimpl(composerM1258constructorimpl3, density3, companion.getSetDensity());
                    Updater.m1265setimpl(composerM1258constructorimpl3, layoutDirection4, companion.getSetLayoutDirection());
                    Updater.m1265setimpl(composerM1258constructorimpl3, viewConfiguration3, companion.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    qVarMaterializerOf3.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-1007916070);
                    pVar3.mo4invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 15) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
                float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
                Modifier.Companion companion2 = Modifier.Companion;
                if (pVar2 != null) {
                    fCalculateStartPadding = Dp.m3673constructorimpl(o.d(Dp.m3673constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m3673constructorimpl(0)));
                }
                float f11 = fCalculateStartPadding;
                if (pVar3 != null) {
                    fCalculateEndPadding = Dp.m3673constructorimpl(o.d(Dp.m3673constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m3673constructorimpl(0)));
                }
                Modifier modifierM403paddingqDBjuR0$default = PaddingKt.m403paddingqDBjuR0$default(companion2, f11, 0.0f, fCalculateEndPadding, 0.0f, 10, null);
                composerStartRestartGroup.startReplaceableGroup(254817490);
                if (qVar != null) {
                    qVar.invoke(LayoutIdKt.layoutId(companion2, TextFieldImplKt.PlaceholderId).then(modifierM403paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i11 >> 6) & 112));
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(254817619);
                if (pVar != null) {
                    Modifier modifierThen3 = LayoutIdKt.layoutId(companion2, TextFieldImplKt.LabelId).then(modifierM403paddingqDBjuR0$default);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    a<ComposeUiNode> constructor4 = companion.getConstructor();
                    q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf4 = LayoutKt.materializerOf(modifierThen3);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM1258constructorimpl4 = Updater.m1258constructorimpl(composerStartRestartGroup);
                    Updater.m1265setimpl(composerM1258constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, companion.getSetMeasurePolicy());
                    Updater.m1265setimpl(composerM1258constructorimpl4, density4, companion.getSetDensity());
                    Updater.m1265setimpl(composerM1258constructorimpl4, layoutDirection5, companion.getSetLayoutDirection());
                    Updater.m1265setimpl(composerM1258constructorimpl4, viewConfiguration4, companion.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    qVarMaterializerOf4.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1319246300);
                    pVar.mo4invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 6) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen4 = LayoutIdKt.layoutId(companion2, TextFieldImplKt.TextFieldId).then(modifierM403paddingqDBjuR0$default);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                a<ComposeUiNode> constructor5 = companion.getConstructor();
                q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf5 = LayoutKt.materializerOf(modifierThen4);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1258constructorimpl5 = Updater.m1258constructorimpl(composerStartRestartGroup);
                Updater.m1265setimpl(composerM1258constructorimpl5, measurePolicyRememberBoxMeasurePolicy4, companion.getSetMeasurePolicy());
                Updater.m1265setimpl(composerM1258constructorimpl5, density5, companion.getSetDensity());
                Updater.m1265setimpl(composerM1258constructorimpl5, layoutDirection6, companion.getSetLayoutDirection());
                Updater.m1265setimpl(composerM1258constructorimpl5, viewConfiguration5, companion.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                qVarMaterializerOf5.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-2048931960);
                textField.mo4invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 3) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09562(modifier, textField, pVar, qVar, pVar2, pVar3, z10, f10, paddingValues, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1210calculateHeightO3s9Psw(int i10, boolean z10, int i11, int i12, int i13, int i14, long j10, float f10, PaddingValues paddingValues) {
        float f11 = TextFieldTopPadding * f10;
        float fMo382calculateTopPaddingD9Ej5fM = paddingValues.mo382calculateTopPaddingD9Ej5fM() * f10;
        float fMo379calculateBottomPaddingD9Ej5fM = paddingValues.mo379calculateBottomPaddingD9Ej5fM() * f10;
        int iMax = Math.max(i10, i14);
        return Math.max(c.c(z10 ? i11 + f11 + iMax + fMo379calculateBottomPaddingD9Ej5fM : fMo382calculateTopPaddingD9Ej5fM + iMax + fMo379calculateBottomPaddingD9Ej5fM), Math.max(Math.max(i12, i13), Constraints.m3642getMinHeightimpl(j10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m1211calculateWidthVsPV1Ek(int i10, int i11, int i12, int i13, int i14, long j10) {
        return Math.max(i10 + Math.max(i12, Math.max(i13, i14)) + i11, Constraints.m3643getMinWidthimpl(j10));
    }

    @NotNull
    public static final Modifier drawIndicatorLine(@NotNull Modifier modifier, @NotNull BorderStroke indicatorBorder) {
        t.i(modifier, "<this>");
        t.i(indicatorBorder, "indicatorBorder");
        return DrawModifierKt.drawWithContent(modifier, new AnonymousClass1(indicatorBorder.m179getWidthD9Ej5fM(), indicatorBorder));
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i10, int i11, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z10, int i12, int i13, float f10, float f11) {
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i11), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i10 - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i11), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), (z10 ? Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i11) : c.c(TextFieldImplKt.getTextFieldPadding() * f11)) - c.c((r0 - i12) * f10), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i13, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i13, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i10, int i11, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z10, float f10, PaddingValues paddingValues) {
        int iC = c.c(paddingValues.mo382calculateTopPaddingD9Ej5fM() * f10);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i11), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i10 - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i11), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z10 ? Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i11) : iC, 0.0f, 4, null);
        if (placeable2 != null) {
            if (z10) {
                iC = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i11);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), iC, 0.0f, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:301:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0134  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r71, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.ui.text.input.TextFieldValue, v8.k0> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r73, boolean r74, boolean r75, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r76, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r77, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r78, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r79, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r80, boolean r81, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r83, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r87, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r88, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r89, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r90, int r91, int r92, int r93) {
        /*
            Method dump skipped, instruction units count: 1505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, h9.l, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, h9.p, h9.p, h9.p, h9.p, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
