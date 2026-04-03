package androidx.compose.runtime;

import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Updater$reconcile$1<T> extends v implements p<T, k0, k0> {
    final /* synthetic */ l<T, k0> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Updater$reconcile$1(l<? super T, k0> lVar) {
        super(2);
        this.$block = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Object obj, k0 k0Var) {
        invoke2(obj, k0Var);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(T t10, @NotNull k0 it) {
        t.i(it, "it");
        this.$block.invoke(t10);
    }
}
