package androidx.compose.runtime;

import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$insertMovableContentReferences$1$1$5$1$1$1 extends v implements h9.a<k0> {
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentReferences$1$1$5$1$1$1(ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.this$0 = composerImpl;
        this.$to = movableContentStateReference;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.invokeMovableContentLambda(this.$to.getContent$runtime_release(), this.$to.getLocals$runtime_release(), this.$to.getParameter$runtime_release(), true);
    }
}
