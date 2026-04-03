package com.unity3d.services.core.extensions;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: CoroutineExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$deferred$2", f = "CoroutineExtensions.kt", l = {39}, m = "invokeSuspend")
public final class CoroutineExtensionsKt$memoize$2$deferred$2<T> extends l implements p<o0, d<? super T>, Object> {
    final /* synthetic */ p<o0, d<? super T>, Object> $action;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineExtensionsKt$memoize$2$deferred$2(p<? super o0, ? super d<? super T>, ? extends Object> pVar, d<? super CoroutineExtensionsKt$memoize$2$deferred$2> dVar) {
        super(2, dVar);
        this.$action = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        CoroutineExtensionsKt$memoize$2$deferred$2 coroutineExtensionsKt$memoize$2$deferred$2 = new CoroutineExtensionsKt$memoize$2$deferred$2(this.$action, dVar);
        coroutineExtensionsKt$memoize$2$deferred$2.L$0 = obj;
        return coroutineExtensionsKt$memoize$2$deferred$2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            o0 o0Var = (o0) this.L$0;
            p<o0, d<? super T>, Object> pVar = this.$action;
            this.label = 1;
            obj = pVar.mo4invoke(o0Var, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return obj;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        return this.$action.mo4invoke((o0) this.L$0, this);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super T> dVar) {
        return ((CoroutineExtensionsKt$memoize$2$deferred$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
