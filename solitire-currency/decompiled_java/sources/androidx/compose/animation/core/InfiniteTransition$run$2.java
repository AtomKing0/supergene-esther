package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: InfiniteTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class InfiniteTransition$run$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ InfiniteTransition $tmp0_rcvr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InfiniteTransition$run$2(InfiniteTransition infiniteTransition, int i10) {
        super(2);
        this.$tmp0_rcvr = infiniteTransition;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        this.$tmp0_rcvr.run$animation_core_release(composer, this.$$changed | 1);
    }
}
