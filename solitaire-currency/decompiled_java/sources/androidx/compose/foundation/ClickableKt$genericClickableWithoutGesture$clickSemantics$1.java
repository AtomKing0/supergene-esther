package androidx.compose.foundation;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClickableKt$genericClickableWithoutGesture$clickSemantics$1 extends v implements h9.l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ h9.a<k0> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ h9.a<k0> $onLongClick;
    final /* synthetic */ String $onLongClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    static final class AnonymousClass1 extends v implements h9.a<Boolean> {
        final /* synthetic */ h9.a<k0> $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(h9.a<k0> aVar) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    static final class AnonymousClass2 extends v implements h9.a<Boolean> {
        final /* synthetic */ h9.a<k0> $onLongClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(h9.a<k0> aVar) {
            super(0);
            this.$onLongClick = aVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            this.$onLongClick.invoke();
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$clickSemantics$1(Role role, String str, h9.a<k0> aVar, String str2, boolean z10, h9.a<k0> aVar2) {
        super(1);
        this.$role = role;
        this.$onClickLabel = str;
        this.$onLongClick = aVar;
        this.$onLongClickLabel = str2;
        this.$enabled = z10;
        this.$onClick = aVar2;
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
        SemanticsPropertiesKt.onClick(semantics, this.$onClickLabel, new AnonymousClass1(this.$onClick));
        h9.a<k0> aVar = this.$onLongClick;
        if (aVar != null) {
            SemanticsPropertiesKt.onLongClick(semantics, this.$onLongClickLabel, new AnonymousClass2(aVar));
        }
        if (this.$enabled) {
            return;
        }
        SemanticsPropertiesKt.disabled(semantics);
    }
}
