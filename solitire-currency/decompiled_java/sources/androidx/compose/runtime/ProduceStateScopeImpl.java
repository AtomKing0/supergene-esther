package androidx.compose.runtime;

import h9.l;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: ProduceState.kt */
/* JADX INFO: loaded from: classes.dex */
final class ProduceStateScopeImpl<T> implements ProduceStateScope<T>, MutableState<T> {
    private final /* synthetic */ MutableState<T> $$delegate_0;

    @NotNull
    private final g coroutineContext;

    /* JADX INFO: renamed from: androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProduceState.kt */
    @f(c = "androidx.compose.runtime.ProduceStateScopeImpl", f = "ProduceState.kt", l = {227}, m = "awaitDispose")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProduceStateScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProduceStateScopeImpl<T> produceStateScopeImpl, z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
            this.this$0 = produceStateScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitDispose(null, this);
        }
    }

    public ProduceStateScopeImpl(@NotNull MutableState<T> state, @NotNull g coroutineContext) {
        t.i(state, "state");
        t.i(coroutineContext, "coroutineContext");
        this.coroutineContext = coroutineContext;
        this.$$delegate_0 = state;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.runtime.ProduceStateScope
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object awaitDispose(@org.jetbrains.annotations.NotNull h9.a<v8.k0> r5, @org.jetbrains.annotations.NotNull z8.d<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.runtime.ProduceStateScopeImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1 r0 = (androidx.compose.runtime.ProduceStateScopeImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1 r0 = new androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            java.lang.Object r5 = r0.L$0
            h9.a r5 = (h9.a) r5
            v8.u.b(r6)     // Catch: java.lang.Throwable -> L5e
            goto L58
        L35:
            v8.u.b(r6)
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L5e
            r0.label = r3     // Catch: java.lang.Throwable -> L5e
            kotlinx.coroutines.p r6 = new kotlinx.coroutines.p     // Catch: java.lang.Throwable -> L5e
            z8.d r2 = a9.b.c(r0)     // Catch: java.lang.Throwable -> L5e
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L5e
            r6.C()     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r6.z()     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r2 = a9.b.e()     // Catch: java.lang.Throwable -> L5e
            if (r6 != r2) goto L55
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch: java.lang.Throwable -> L5e
        L55:
            if (r6 != r1) goto L58
            return r1
        L58:
            v8.h r6 = new v8.h     // Catch: java.lang.Throwable -> L5e
            r6.<init>()     // Catch: java.lang.Throwable -> L5e
            throw r6     // Catch: java.lang.Throwable -> L5e
        L5e:
            r6 = move-exception
            r5.invoke()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProduceStateScopeImpl.awaitDispose(h9.a, z8.d):java.lang.Object");
    }

    @Override // androidx.compose.runtime.MutableState
    public T component1() {
        return this.$$delegate_0.component1();
    }

    @Override // androidx.compose.runtime.MutableState
    @NotNull
    public l<T, k0> component2() {
        return this.$$delegate_0.component2();
    }

    @Override // androidx.compose.runtime.ProduceStateScope, kotlinx.coroutines.o0
    @NotNull
    public g getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public T getValue() {
        return this.$$delegate_0.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public void setValue(T t10) {
        this.$$delegate_0.setValue(t10);
    }
}
