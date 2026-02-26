package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.h;

/* JADX INFO: compiled from: AnimationModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationModifierKt {

    /* JADX INFO: renamed from: androidx.compose.animation.AnimationModifierKt$animateContentSize$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnimationModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ FiniteAnimationSpec<IntSize> $animationSpec;
        final /* synthetic */ p<IntSize, IntSize, k0> $finishedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(p<? super IntSize, ? super IntSize, k0> pVar, FiniteAnimationSpec<IntSize> finiteAnimationSpec) {
            super(3);
            this.$finishedListener = pVar;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-843180607);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            FiniteAnimationSpec<IntSize> finiteAnimationSpec = this.$animationSpec;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(coroutineScope);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SizeAnimationModifier(finiteAnimationSpec, coroutineScope);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            SizeAnimationModifier sizeAnimationModifier = (SizeAnimationModifier) objRememberedValue2;
            sizeAnimationModifier.setListener(this.$finishedListener);
            Modifier modifierThen = ClipKt.clipToBounds(composed).then(sizeAnimationModifier);
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    @NotNull
    public static final Modifier animateContentSize(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntSize> animationSpec, @Nullable p<? super IntSize, ? super IntSize, k0> pVar) {
        t.i(modifier, "<this>");
        t.i(animationSpec, "animationSpec");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AnimationModifierKt$animateContentSize$$inlined$debugInspectorInfo$1(animationSpec, pVar) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(pVar, animationSpec));
    }

    public static /* synthetic */ Modifier animateContentSize$default(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        return animateContentSize(modifier, finiteAnimationSpec, pVar);
    }
}
