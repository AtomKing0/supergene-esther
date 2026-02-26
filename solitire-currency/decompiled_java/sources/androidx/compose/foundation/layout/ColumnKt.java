package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import h9.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Column.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColumnKt {

    @NotNull
    private static final MeasurePolicy DefaultColumnMeasurePolicy;

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
        float fMo353getSpacingD9Ej5fM = Arrangement.INSTANCE.getTop().mo353getSpacingD9Ej5fM();
        CrossAxisAlignment crossAxisAlignmentHorizontal$foundation_layout_release = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(Alignment.Companion.getStart());
        DefaultColumnMeasurePolicy = RowColumnImplKt.m420rowColumnMeasurePolicyTDGSqEk(layoutOrientation, ColumnKt$DefaultColumnMeasurePolicy$1.INSTANCE, fMo353getSpacingD9Ej5fM, SizeMode.Wrap, crossAxisAlignmentHorizontal$foundation_layout_release);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Column(@Nullable Modifier modifier, @Nullable Arrangement.Vertical vertical, @Nullable Alignment.Horizontal horizontal, @NotNull q<? super ColumnScope, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        t.i(content, "content");
        composer.startReplaceableGroup(-483455358);
        if ((i11 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i11 & 2) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i11 & 4) != 0) {
            horizontal = Alignment.Companion.getStart();
        }
        int i12 = i10 >> 3;
        MeasurePolicy measurePolicyColumnMeasurePolicy = columnMeasurePolicy(vertical, horizontal, composer, (i12 & 112) | (i12 & 14));
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifier);
        int i13 = ((((i10 << 3) & 112) << 9) & 7168) | 6;
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i13 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-1163856341);
        if (((i13 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            content.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i10 >> 6) & 112) | 6));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    @NotNull
    public static final MeasurePolicy columnMeasurePolicy(@NotNull Arrangement.Vertical verticalArrangement, @NotNull Alignment.Horizontal horizontalAlignment, @Nullable Composer composer, int i10) {
        MeasurePolicy measurePolicyM420rowColumnMeasurePolicyTDGSqEk;
        t.i(verticalArrangement, "verticalArrangement");
        t.i(horizontalAlignment, "horizontalAlignment");
        composer.startReplaceableGroup(1089876336);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(verticalArrangement) | composer.changed(horizontalAlignment);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            if (t.d(verticalArrangement, Arrangement.INSTANCE.getTop()) && t.d(horizontalAlignment, Alignment.Companion.getStart())) {
                measurePolicyM420rowColumnMeasurePolicyTDGSqEk = DefaultColumnMeasurePolicy;
            } else {
                LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
                float fMo353getSpacingD9Ej5fM = verticalArrangement.mo353getSpacingD9Ej5fM();
                CrossAxisAlignment crossAxisAlignmentHorizontal$foundation_layout_release = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(horizontalAlignment);
                measurePolicyM420rowColumnMeasurePolicyTDGSqEk = RowColumnImplKt.m420rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new ColumnKt$columnMeasurePolicy$1$1(verticalArrangement), fMo353getSpacingD9Ej5fM, SizeMode.Wrap, crossAxisAlignmentHorizontal$foundation_layout_release);
            }
            objRememberedValue = measurePolicyM420rowColumnMeasurePolicyTDGSqEk;
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    @NotNull
    public static final MeasurePolicy getDefaultColumnMeasurePolicy() {
        return DefaultColumnMeasurePolicy;
    }

    public static /* synthetic */ void getDefaultColumnMeasurePolicy$annotations() {
    }
}
