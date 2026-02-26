package androidx.compose.foundation.selection;

import h9.a;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ToggleableKt$toggleable$4$1 extends v implements a<k0> {
    final /* synthetic */ l<Boolean, k0> $onValueChange;
    final /* synthetic */ boolean $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ToggleableKt$toggleable$4$1(l<? super Boolean, k0> lVar, boolean z10) {
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
