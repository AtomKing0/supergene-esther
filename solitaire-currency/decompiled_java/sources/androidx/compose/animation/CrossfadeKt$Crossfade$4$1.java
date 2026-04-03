package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Crossfade.kt */
/* JADX INFO: loaded from: classes.dex */
final class CrossfadeKt$Crossfade$4$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ q<T, Composer, Integer, k0> $content;
    final /* synthetic */ T $stateForContent;
    final /* synthetic */ Transition<T> $this_Crossfade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CrossfadeKt$Crossfade$4$1(Transition<T> transition, int i10, FiniteAnimationSpec<Float> finiteAnimationSpec, T t10, q<? super T, ? super Composer, ? super Integer, k0> qVar) {
        super(2);
        this.$this_Crossfade = transition;
        this.$$dirty = i10;
        this.$animationSpec = finiteAnimationSpec;
        this.$stateForContent = t10;
        this.$content = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
    public static final float m42invoke$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        Transition<T> transition = this.$this_Crossfade;
        CrossfadeKt$Crossfade$4$1$alpha$2 crossfadeKt$Crossfade$4$1$alpha$2 = new CrossfadeKt$Crossfade$4$1$alpha$2(this.$animationSpec);
        T t10 = this.$stateForContent;
        int i11 = this.$$dirty & 14;
        composer.startReplaceableGroup(-1338768149);
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(m.f29832a);
        int i12 = i11 & 14;
        int i13 = i11 << 3;
        int i14 = (i13 & 57344) | i12 | (i13 & 896) | (i13 & 7168);
        composer.startReplaceableGroup(-142660079);
        Object currentState = transition.getCurrentState();
        composer.startReplaceableGroup(-438678252);
        float f10 = t.d(currentState, t10) ? 1.0f : 0.0f;
        composer.endReplaceableGroup();
        Float fValueOf = Float.valueOf(f10);
        Object targetState = transition.getTargetState();
        composer.startReplaceableGroup(-438678252);
        float f11 = t.d(targetState, t10) ? 1.0f : 0.0f;
        composer.endReplaceableGroup();
        State stateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(f11), crossfadeKt$Crossfade$4$1$alpha$2.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, "FloatAnimation", composer, (i14 & 14) | (57344 & (i14 << 9)) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        Modifier.Companion companion = Modifier.Companion;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(stateCreateTransitionAnimation);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new CrossfadeKt$Crossfade$4$1$1$1(stateCreateTransitionAnimation);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (l) objRememberedValue);
        q<T, Composer, Integer, k0> qVar = this.$content;
        T t11 = this.$stateForContent;
        int i15 = this.$$dirty;
        composer.startReplaceableGroup(-1990474327);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(1376089335);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion2.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierGraphicsLayer);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-1253629305);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-222715758);
        qVar.invoke(t11, composer, Integer.valueOf((i15 >> 9) & 112));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
