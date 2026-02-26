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
final class ClickableKt$combinedClickable$2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ h9.a<k0> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ h9.a<k0> $onDoubleClick;
    final /* synthetic */ h9.a<k0> $onLongClick;
    final /* synthetic */ String $onLongClickLabel;
    final /* synthetic */ Role $role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$combinedClickable$2(boolean z10, String str, Role role, String str2, h9.a<k0> aVar, h9.a<k0> aVar2, h9.a<k0> aVar3) {
        super(3);
        this.$enabled = z10;
        this.$onClickLabel = str;
        this.$role = role;
        this.$onLongClickLabel = str2;
        this.$onLongClick = aVar;
        this.$onDoubleClick = aVar2;
        this.$onClick = aVar3;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
        t.i(composed, "$this$composed");
        composer.startReplaceableGroup(1969174843);
        Modifier.Companion companion = Modifier.Companion;
        Indication indication = (Indication) composer.consume(IndicationKt.getLocalIndication());
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierM186combinedClickableXVZzFYc = ClickableKt.m186combinedClickableXVZzFYc(companion, (MutableInteractionSource) objRememberedValue, indication, this.$enabled, this.$onClickLabel, this.$role, this.$onLongClickLabel, this.$onLongClick, this.$onDoubleClick, this.$onClick);
        composer.endReplaceableGroup();
        return modifierM186combinedClickableXVZzFYc;
    }
}
