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
import androidx.compose.ui.state.ToggleableStateKt;
import h9.a;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ToggleableKt$toggleable$2 extends v implements q<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ l<Boolean, k0> $onValueChange;
    final /* synthetic */ Role $role;
    final /* synthetic */ boolean $value;

    /* JADX INFO: renamed from: androidx.compose.foundation.selection.ToggleableKt$toggleable$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: Toggleable.kt */
    static final class AnonymousClass2 extends v implements a<k0> {
        final /* synthetic */ l<Boolean, k0> $onValueChange;
        final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super Boolean, k0> lVar, boolean z10) {
            super(0);
            this.$onValueChange = lVar;
            this.$value = z10;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onValueChange.invoke(Boolean.valueOf(!this.$value));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ToggleableKt$toggleable$2(boolean z10, boolean z11, Role role, l<? super Boolean, k0> lVar) {
        super(3);
        this.$value = z10;
        this.$enabled = z11;
        this.$role = role;
        this.$onValueChange = lVar;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
        t.i(composed, "$this$composed");
        composer.startReplaceableGroup(290332169);
        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(this.$value);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierM621toggleableImpl3WzHGRc = ToggleableKt.m621toggleableImpl3WzHGRc(composed, ToggleableState, this.$enabled, this.$role, (MutableInteractionSource) objRememberedValue, (Indication) composer.consume(IndicationKt.getLocalIndication()), new AnonymousClass2(this.$onValueChange, this.$value));
        composer.endReplaceableGroup();
        return modifierM621toggleableImpl3WzHGRc;
    }
}
