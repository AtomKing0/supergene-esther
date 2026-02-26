package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClickableKt$clickable$2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ h9.a<k0> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$2(boolean z10, String str, Role role, h9.a<k0> aVar) {
        super(3);
        this.$enabled = z10;
        this.$onClickLabel = str;
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
        composer.startReplaceableGroup(-756081143);
        Modifier.Companion companion = Modifier.Companion;
        Indication indication = (Indication) composer.consume(IndicationKt.getLocalIndication());
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierM182clickableO2vRcR0 = ClickableKt.m182clickableO2vRcR0(companion, (MutableInteractionSource) objRememberedValue, indication, this.$enabled, this.$onClickLabel, this.$role, this.$onClick);
        composer.endReplaceableGroup();
        return modifierM182clickableO2vRcR0;
    }
}
