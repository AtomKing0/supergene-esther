package androidx.compose.foundation.selection;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import h9.a;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ToggleableKt$toggleableImpl$1$semantics$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ ToggleableState $state;

    /* JADX INFO: renamed from: androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$semantics$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Toggleable.kt */
    static final class AnonymousClass1 extends v implements a<Boolean> {
        final /* synthetic */ a<k0> $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(a<k0> aVar) {
            super(0);
            this.$onClick = aVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            this.$onClick.invoke();
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleableImpl$1$semantics$1(Role role, ToggleableState toggleableState, boolean z10, a<k0> aVar) {
        super(1);
        this.$role = role;
        this.$state = toggleableState;
        this.$enabled = z10;
        this.$onClick = aVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        Role role = this.$role;
        if (role != null) {
            SemanticsPropertiesKt.m3247setRolekuIjeqM(semantics, role.m3233unboximpl());
        }
        SemanticsPropertiesKt.setToggleableState(semantics, this.$state);
        SemanticsPropertiesKt.onClick$default(semantics, null, new AnonymousClass1(this.$onClick), 1, null);
        if (this.$enabled) {
            return;
        }
        SemanticsPropertiesKt.disabled(semantics);
    }
}
