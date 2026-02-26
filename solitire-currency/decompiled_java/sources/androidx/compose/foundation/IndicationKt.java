package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Indication.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IndicationKt {

    @NotNull
    private static final ProvidableCompositionLocal<Indication> LocalIndication = CompositionLocalKt.staticCompositionLocalOf(IndicationKt$LocalIndication$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.foundation.IndicationKt$indication$2, reason: invalid class name */
    /* JADX INFO: compiled from: Indication.kt */
    static final class AnonymousClass2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ Indication $indication;
        final /* synthetic */ InteractionSource $interactionSource;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Indication indication, InteractionSource interactionSource) {
            super(3);
            this.$indication = indication;
            this.$interactionSource = interactionSource;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-353972293);
            Indication indication = this.$indication;
            if (indication == null) {
                indication = NoIndication.INSTANCE;
            }
            IndicationInstance indicationInstanceRememberUpdatedInstance = indication.rememberUpdatedInstance(this.$interactionSource, composer, 0);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(indicationInstanceRememberUpdatedInstance);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new IndicationModifier(indicationInstanceRememberUpdatedInstance);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            IndicationModifier indicationModifier = (IndicationModifier) objRememberedValue;
            composer.endReplaceableGroup();
            return indicationModifier;
        }
    }

    @NotNull
    public static final ProvidableCompositionLocal<Indication> getLocalIndication() {
        return LocalIndication;
    }

    @NotNull
    public static final Modifier indication(@NotNull Modifier modifier, @NotNull InteractionSource interactionSource, @Nullable Indication indication) {
        t.i(modifier, "<this>");
        t.i(interactionSource, "interactionSource");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new IndicationKt$indication$$inlined$debugInspectorInfo$1(indication, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(indication, interactionSource));
    }
}
