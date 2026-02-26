package androidx.compose.runtime;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$doCompose$2$5 extends v implements h9.a<k0> {
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ Object $savedContent;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ComposerImpl$doCompose$2$5(p<? super Composer, ? super Integer, k0> pVar, ComposerImpl composerImpl, Object obj) {
        super(0);
        this.$content = pVar;
        this.this$0 = composerImpl;
        this.$savedContent = obj;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Object obj;
        if (this.$content != null) {
            this.this$0.startGroup(200, ComposerKt.getInvocation());
            ActualJvm_jvmKt.invokeComposable(this.this$0, this.$content);
            this.this$0.endGroup();
        } else {
            if (!this.this$0.forciblyRecompose || (obj = this.$savedContent) == null || t.d(obj, Composer.Companion.getEmpty())) {
                this.this$0.skipCurrentGroup();
                return;
            }
            this.this$0.startGroup(200, ComposerKt.getInvocation());
            ComposerImpl composerImpl = this.this$0;
            Object obj2 = this.$savedContent;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
            }
            ActualJvm_jvmKt.invokeComposable(composerImpl, (p) t0.f(obj2, 2));
            this.this$0.endGroup();
        }
    }
}
