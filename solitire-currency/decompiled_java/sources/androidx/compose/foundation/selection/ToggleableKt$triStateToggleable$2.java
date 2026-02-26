package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import h9.a;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ToggleableKt$triStateToggleable$2 extends v implements q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ ToggleableState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ToggleableKt$triStateToggleable$2(ToggleableState toggleableState, boolean z10, Role role, a<k0> aVar) {
        super(3);
        this.$state = toggleableState;
        this.$enabled = z10;
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
        composer.startReplaceableGroup(-1808118329);
        ToggleableState toggleableState = this.$state;
        boolean z10 = this.$enabled;
        Role role = this.$role;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierM621toggleableImpl3WzHGRc = ToggleableKt.m621toggleableImpl3WzHGRc(composed, toggleableState, z10, role, (MutableInteractionSource) objRememberedValue, (Indication) composer.consume(IndicationKt.getLocalIndication()), this.$onClick);
        composer.endReplaceableGroup();
        return modifierM621toggleableImpl3WzHGRc;
    }
}
