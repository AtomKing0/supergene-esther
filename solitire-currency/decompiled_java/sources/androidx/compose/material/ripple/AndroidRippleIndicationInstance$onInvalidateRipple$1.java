package androidx.compose.material.ripple;

import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Ripple.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidRippleIndicationInstance$onInvalidateRipple$1 extends v implements h9.a<k0> {
    final /* synthetic */ AndroidRippleIndicationInstance this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidRippleIndicationInstance$onInvalidateRipple$1(AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        super(0);
        this.this$0 = androidRippleIndicationInstance;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.setInvalidateTick(!r0.getInvalidateTick());
    }
}
