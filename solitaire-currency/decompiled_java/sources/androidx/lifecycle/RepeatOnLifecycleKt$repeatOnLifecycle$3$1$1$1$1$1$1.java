package androidx.lifecycle;

import h9.p;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: RepeatOnLifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {111}, m = "invokeSuspend")
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ p<o0, z8.d<? super k0>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(p<? super o0, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> dVar) {
        super(2, dVar);
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.$block, dVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            o0 o0Var = (o0) this.L$0;
            p<o0, z8.d<? super k0>, Object> pVar = this.$block;
            this.label = 1;
            if (pVar.mo4invoke(o0Var, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
