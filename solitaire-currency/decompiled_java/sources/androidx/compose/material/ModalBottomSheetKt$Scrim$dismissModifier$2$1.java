package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.a;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
final class ModalBottomSheetKt$Scrim$dismissModifier$2$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ String $closeSheet;
    final /* synthetic */ a<k0> $onDismiss;

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass1 extends v implements a<Boolean> {
        final /* synthetic */ a<k0> $onDismiss;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(a<k0> aVar) {
            super(0);
            this.$onDismiss = aVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            this.$onDismiss.invoke();
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$Scrim$dismissModifier$2$1(String str, a<k0> aVar) {
        super(1);
        this.$closeSheet = str;
        this.$onDismiss = aVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, this.$closeSheet);
        SemanticsPropertiesKt.onClick$default(semantics, null, new AnonymousClass1(this.$onDismiss), 1, null);
    }
}
