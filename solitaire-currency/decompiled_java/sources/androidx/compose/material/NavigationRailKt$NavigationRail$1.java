package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
final class NavigationRailKt$NavigationRail$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $content;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $header;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NavigationRailKt$NavigationRail$1(q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, int i10, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar2) {
        super(2);
        this.$header = qVar;
        this.$$dirty = i10;
        this.$content = qVar2;
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
        Modifier.Companion companion = Modifier.Companion;
        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m401paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
        q<ColumnScope, Composer, Integer, k0> qVar = this.$header;
        int i11 = this.$$dirty;
        q<ColumnScope, Composer, Integer, k0> qVar2 = this.$content;
        composer.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion2.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-1163856341);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-497173955);
        composer.startReplaceableGroup(65525382);
        if (qVar != null) {
            qVar.invoke(columnScopeInstance, composer, Integer.valueOf(((i11 >> 9) & 112) | 6));
            SpacerKt.Spacer(SizeKt.m426height3ABfNKs(companion, NavigationRailKt.HeaderPadding), composer, 6);
        }
        composer.endReplaceableGroup();
        qVar2.invoke(columnScopeInstance, composer, Integer.valueOf(((i11 >> 12) & 112) | 6));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
