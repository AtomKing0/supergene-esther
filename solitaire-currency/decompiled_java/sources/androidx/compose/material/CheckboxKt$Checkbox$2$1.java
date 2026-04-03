package androidx.compose.material;

import h9.a;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
final class CheckboxKt$Checkbox$2$1 extends v implements a<k0> {
    final /* synthetic */ boolean $checked;
    final /* synthetic */ l<Boolean, k0> $onCheckedChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CheckboxKt$Checkbox$2$1(l<? super Boolean, k0> lVar, boolean z10) {
        super(0);
        this.$onCheckedChange = lVar;
        this.$checked = z10;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$onCheckedChange.invoke(Boolean.valueOf(!this.$checked));
    }
}
