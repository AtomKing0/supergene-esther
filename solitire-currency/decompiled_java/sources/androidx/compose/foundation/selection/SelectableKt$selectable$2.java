package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import h9.a;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Selectable.kt */
/* JADX INFO: loaded from: classes.dex */
final class SelectableKt$selectable$2 extends v implements q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ boolean $selected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectableKt$selectable$2(boolean z10, boolean z11, Role role, a<k0> aVar) {
        super(3);
        this.$selected = z10;
        this.$enabled = z11;
        this.$role = role;
        this.$onClick = aVar;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
        t.i(composed, "$this$composed");
        composer.startReplaceableGroup(-2124609672);
        Modifier.Companion companion = Modifier.Companion;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierM612selectableO2vRcR0 = SelectableKt.m612selectableO2vRcR0(companion, this.$selected, (MutableInteractionSource) objRememberedValue, (Indication) composer.consume(IndicationKt.getLocalIndication()), this.$enabled, this.$role, this.$onClick);
        composer.endReplaceableGroup();
        return modifierM612selectableO2vRcR0;
    }
}
