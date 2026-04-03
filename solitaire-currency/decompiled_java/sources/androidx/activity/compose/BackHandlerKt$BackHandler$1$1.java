package androidx.activity.compose;

import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: BackHandler.kt */
/* JADX INFO: loaded from: classes.dex */
final class BackHandlerKt$BackHandler$1$1 extends v implements h9.a<k0> {
    final /* synthetic */ BackHandlerKt$BackHandler$backCallback$1$1 $backCallback;
    final /* synthetic */ boolean $enabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackHandlerKt$BackHandler$1$1(BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1, boolean z10) {
        super(0);
        this.$backCallback = backHandlerKt$BackHandler$backCallback$1$1;
        this.$enabled = z10;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        setEnabled(this.$enabled);
    }
}
