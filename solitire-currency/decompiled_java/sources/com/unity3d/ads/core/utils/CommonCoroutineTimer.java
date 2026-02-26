package com.unity3d.ads.core.utils;

import h9.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: CommonCoroutineTimer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonCoroutineTimer implements CoroutineTimer {

    @NotNull
    private final k0 dispatcher;

    @NotNull
    private final a0 job;

    @NotNull
    private final o0 scope;

    /* JADX INFO: renamed from: com.unity3d.ads.core.utils.CommonCoroutineTimer$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonCoroutineTimer.kt */
    @f(c = "com.unity3d.ads.core.utils.CommonCoroutineTimer$start$1", f = "CommonCoroutineTimer.kt", l = {21, 24}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super v8.k0>, Object> {
        final /* synthetic */ a<v8.k0> $action;
        final /* synthetic */ long $delayStartMillis;
        final /* synthetic */ long $repeatMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j10, a<v8.k0> aVar, long j11, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$delayStartMillis = j10;
            this.$action = aVar;
            this.$repeatMillis = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$delayStartMillis, this.$action, this.$repeatMillis, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            o0 o0Var;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0Var = (o0) this.L$0;
                long j10 = this.$delayStartMillis;
                this.L$0 = o0Var;
                this.label = 1;
                if (y0.a(j10, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o0Var = (o0) this.L$0;
                u.b(obj);
            }
            while (p0.h(o0Var)) {
                this.$action.invoke();
                long j11 = this.$repeatMillis;
                this.L$0 = o0Var;
                this.label = 2;
                if (y0.a(j11, this) == objE) {
                    return objE;
                }
            }
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public CommonCoroutineTimer(@NotNull k0 dispatcher) {
        t.i(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        a0 a0VarB = y2.b(null, 1, null);
        this.job = a0VarB;
        this.scope = p0.a(dispatcher.plus(a0VarB));
    }

    @Override // com.unity3d.ads.core.utils.CoroutineTimer
    @NotNull
    public b2 start(long j10, long j11, @NotNull a<v8.k0> action) {
        t.i(action, "action");
        return k.d(this.scope, this.dispatcher, null, new AnonymousClass1(j10, action, j11, null), 2, null);
    }
}
