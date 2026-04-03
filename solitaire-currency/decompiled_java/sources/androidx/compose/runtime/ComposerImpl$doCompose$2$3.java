package androidx.compose.runtime;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$doCompose$2$3 extends v implements l<State<?>, k0> {
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$doCompose$2$3(ComposerImpl composerImpl) {
        super(1);
        this.this$0 = composerImpl;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(State<?> state) {
        invoke2(state);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull State<?> it) {
        t.i(it, "it");
        this.this$0.childrenComposing++;
    }
}
