package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidSelectionHandles_androidKt$SelectionHandle$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidSelectionHandles_androidKt$SelectionHandle$1(p<? super Composer, ? super Integer, k0> pVar, Modifier modifier, boolean z10, long j10, int i10, ResolvedTextDirection resolvedTextDirection, boolean z11) {
        super(2);
        this.$content = pVar;
        this.$modifier = modifier;
        this.$isStartHandle = z10;
        this.$position = j10;
        this.$$dirty = i10;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z11;
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
        if (this.$content != null) {
            composer.startReplaceableGroup(386444465);
            this.$content.mo4invoke(composer, Integer.valueOf((this.$$dirty >> 15) & 14));
            composer.endReplaceableGroup();
            return;
        }
        composer.startReplaceableGroup(386443790);
        Modifier modifier = this.$modifier;
        Boolean boolValueOf = Boolean.valueOf(this.$isStartHandle);
        Offset offsetM1356boximpl = Offset.m1356boximpl(this.$position);
        boolean z10 = this.$isStartHandle;
        long j10 = this.$position;
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(boolValueOf) | composer.changed(offsetM1356boximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1(z10, j10);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (l) objRememberedValue, 1, null);
        boolean z11 = this.$isStartHandle;
        ResolvedTextDirection resolvedTextDirection = this.$direction;
        boolean z12 = this.$handlesCrossed;
        int i11 = this.$$dirty;
        AndroidSelectionHandles_androidKt.DefaultSelectionHandle(modifierSemantics$default, z11, resolvedTextDirection, z12, composer, (i11 & 112) | (i11 & 896) | (i11 & 7168));
        composer.endReplaceableGroup();
    }
}
