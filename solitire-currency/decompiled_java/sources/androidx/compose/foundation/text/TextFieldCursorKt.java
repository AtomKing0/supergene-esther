package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: TextFieldCursor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldCursorKt {
    private static final float DefaultCursorThickness = Dp.m3673constructorimpl(2);

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldCursor.kt */
    static final class AnonymousClass1 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ Brush $cursorBrush;
        final /* synthetic */ OffsetMapping $offsetMapping;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ TextFieldValue $value;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TextFieldCursor.kt */
        @f(c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1", f = "TextFieldCursor.kt", l = {49}, m = "invokeSuspend")
        static final class C00621 extends l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ Animatable<Float, AnimationVector1D> $cursorAlpha;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00621(Animatable<Float, AnimationVector1D> animatable, d<? super C00621> dVar) {
                super(2, dVar);
                this.$cursorAlpha = animatable;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C00621(this.$cursorAlpha, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    Animatable<Float, AnimationVector1D> animatable = this.$cursorAlpha;
                    Float fC = b.c(0.0f);
                    AnimationSpec cursorAnimationSpec = TextFieldCursorKt.getCursorAnimationSpec();
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fC, cursorAnimationSpec, null, null, this, 12, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C00621) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldCursor.kt */
        static final class AnonymousClass2 extends v implements h9.l<ContentDrawScope, k0> {
            final /* synthetic */ Animatable<Float, AnimationVector1D> $cursorAlpha;
            final /* synthetic */ Brush $cursorBrush;
            final /* synthetic */ OffsetMapping $offsetMapping;
            final /* synthetic */ TextFieldState $state;
            final /* synthetic */ TextFieldValue $value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Animatable<Float, AnimationVector1D> animatable, OffsetMapping offsetMapping, TextFieldValue textFieldValue, TextFieldState textFieldState, Brush brush) {
                super(1);
                this.$cursorAlpha = animatable;
                this.$offsetMapping = offsetMapping;
                this.$value = textFieldValue;
                this.$state = textFieldState;
                this.$cursorBrush = brush;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ContentDrawScope drawWithContent) {
                Rect rect;
                TextLayoutResult value;
                t.i(drawWithContent, "$this$drawWithContent");
                drawWithContent.drawContent();
                float fM = o.m(this.$cursorAlpha.getValue().floatValue(), 0.0f, 1.0f);
                if (fM == 0.0f) {
                    return;
                }
                int iOriginalToTransformed = this.$offsetMapping.originalToTransformed(TextRange.m3335getStartimpl(this.$value.m3510getSelectiond9O1mEE()));
                TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
                if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(iOriginalToTransformed)) == null) {
                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                }
                float fMo296toPx0680j_4 = drawWithContent.mo296toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                float f10 = fMo296toPx0680j_4 / 2;
                float fI = o.i(rect.getLeft() + f10, Size.m1436getWidthimpl(drawWithContent.mo1996getSizeNHjbRc()) - f10);
                androidx.compose.ui.graphics.drawscope.b.B(drawWithContent, this.$cursorBrush, OffsetKt.Offset(fI, rect.getTop()), OffsetKt.Offset(fI, rect.getBottom()), fMo296toPx0680j_4, 0, null, fM, null, 0, 432, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Brush brush, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
            super(3);
            this.$cursorBrush = brush;
            this.$state = textFieldState;
            this.$value = textFieldValue;
            this.$offsetMapping = offsetMapping;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            Modifier modifierDrawWithContent;
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1634330012);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Animatable animatable = (Animatable) objRememberedValue;
            Brush brush = this.$cursorBrush;
            boolean z10 = true;
            if (brush instanceof SolidColor) {
                if (((SolidColor) brush).m1867getValue0d7_KjU() == Color.Companion.m1634getUnspecified0d7_KjU()) {
                    z10 = false;
                }
            }
            if (this.$state.getHasFocus() && TextRange.m3329getCollapsedimpl(this.$value.m3510getSelectiond9O1mEE()) && z10) {
                EffectsKt.LaunchedEffect(this.$cursorBrush, this.$value.getAnnotatedString(), TextRange.m3323boximpl(this.$value.m3510getSelectiond9O1mEE()), new C00621(animatable, null), composer, 0);
                modifierDrawWithContent = DrawModifierKt.drawWithContent(composed, new AnonymousClass2(animatable, this.$offsetMapping, this.$value, this.$state, this.$cursorBrush));
            } else {
                modifierDrawWithContent = Modifier.Companion;
            }
            composer.endReplaceableGroup();
            return modifierDrawWithContent;
        }
    }

    @NotNull
    public static final Modifier cursor(@NotNull Modifier modifier, @NotNull TextFieldState state, @NotNull TextFieldValue value, @NotNull OffsetMapping offsetMapping, @NotNull Brush cursorBrush, boolean z10) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        t.i(value, "value");
        t.i(offsetMapping, "offsetMapping");
        t.i(cursorBrush, "cursorBrush");
        return z10 ? ComposedModifierKt.composed$default(modifier, null, new AnonymousClass1(cursorBrush, state, value, offsetMapping), 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> getCursorAnimationSpec() {
        return AnimationSpecKt.m103infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(TextFieldCursorKt$cursorAnimationSpec$1.INSTANCE), null, 0L, 6, null);
    }

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }
}
