package androidx.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabKt$LeadingIconTab$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ p<Composer, Integer, k0> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ Indication $ripple;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ p<Composer, Integer, k0> $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabKt$LeadingIconTab$2(Modifier modifier, boolean z10, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, a<k0> aVar, p<? super Composer, ? super Integer, k0> pVar, int i10, p<? super Composer, ? super Integer, k0> pVar2) {
        super(2);
        this.$modifier = modifier;
        this.$selected = z10;
        this.$interactionSource = mutableInteractionSource;
        this.$ripple = indication;
        this.$enabled = z11;
        this.$onClick = aVar;
        this.$icon = pVar;
        this.$$dirty = i10;
        this.$text = pVar2;
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
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m401paddingVpY3zN4$default(SelectableKt.m612selectableO2vRcR0(SizeKt.m426height3ABfNKs(this.$modifier, TabKt.SmallTabHeight), this.$selected, this.$interactionSource, this.$ripple, this.$enabled, Role.m3227boximpl(Role.Companion.m3239getTabo7Vup1c()), this.$onClick), TabKt.HorizontalTextPadding, 0.0f, 2, null), 0.0f, 1, null);
        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        p<Composer, Integer, k0> pVar = this.$icon;
        int i11 = this.$$dirty;
        p<Composer, Integer, k0> pVar2 = this.$text;
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer.startReplaceableGroup(1002887383);
        pVar.mo4invoke(composer, Integer.valueOf((i11 >> 9) & 14));
        SpacerKt.Spacer(SizeKt.m437requiredWidth3ABfNKs(Modifier.Companion, TabKt.TextDistanceFromLeadingIcon), composer, 6);
        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer, 6).getButton();
        TextKt.ProvideTextStyle(button.m3346copyHL5avdY((262111 & 1) != 0 ? button.spanStyle.m3308getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? button.spanStyle.m3309getFontSizeXSAIIZE() : 0L, (262111 & 4) != 0 ? button.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? button.spanStyle.m3310getFontStyle4Lr2A7w() : null, (262111 & 16) != 0 ? button.spanStyle.m3311getFontSynthesisZQGJjVo() : null, (262111 & 32) != 0 ? button.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? button.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? button.spanStyle.m3312getLetterSpacingXSAIIZE() : 0L, (262111 & 256) != 0 ? button.spanStyle.m3307getBaselineShift5SSeXJ0() : null, (262111 & 512) != 0 ? button.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? button.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? button.spanStyle.m3306getBackground0d7_KjU() : 0L, (262111 & 4096) != 0 ? button.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? button.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? button.paragraphStyle.m3269getTextAlignbuA522U() : TextAlign.m3586boximpl(TextAlign.Companion.m3593getCentere0LSkKk()), (262111 & 32768) != 0 ? button.paragraphStyle.m3270getTextDirectionmmuk1to() : null, (262111 & 65536) != 0 ? button.paragraphStyle.m3268getLineHeightXSAIIZE() : 0L, (262111 & 131072) != 0 ? button.paragraphStyle.getTextIndent() : null), pVar2, composer, (i11 >> 3) & 112);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
