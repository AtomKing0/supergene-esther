package androidx.compose.material;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
final class IconKt$Icon$semantics$1$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ String $contentDescription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IconKt$Icon$semantics$1$1(String str) {
        super(1);
        this.$contentDescription = str;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, this.$contentDescription);
        SemanticsPropertiesKt.m3247setRolekuIjeqM(semantics, Role.Companion.m3236getImageo7Vup1c());
    }
}
