package s9;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q0<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i<T> f33788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.p<i<? super T>, z8.d<? super v8.k0>, Object> f33789b;

    /* JADX INFO: compiled from: Share.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "onSubscription")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33790j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33791k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33792l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ q0<T> f33793m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f33794n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(q0<T> q0Var, z8.d<? super a> dVar) {
            super(dVar);
            this.f33793m = q0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33792l = obj;
            this.f33794n |= Integer.MIN_VALUE;
            return this.f33793m.b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q0(@NotNull i<? super T> iVar, @NotNull h9.p<? super i<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        this.f33788a = iVar;
        this.f33789b = pVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [t9.t] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof s9.q0.a
            if (r0 == 0) goto L13
            r0 = r7
            s9.q0$a r0 = (s9.q0.a) r0
            int r1 = r0.f33794n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33794n = r1
            goto L18
        L13:
            s9.q0$a r0 = new s9.q0$a
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f33792l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33794n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r7)
            goto L77
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.f33791k
            t9.t r2 = (t9.t) r2
            java.lang.Object r4 = r0.f33790j
            s9.q0 r4 = (s9.q0) r4
            v8.u.b(r7)     // Catch: java.lang.Throwable -> L7d
            goto L5e
        L40:
            v8.u.b(r7)
            t9.t r2 = new t9.t
            s9.i<T> r7 = r6.f33788a
            z8.g r5 = r0.getContext()
            r2.<init>(r7, r5)
            h9.p<s9.i<? super T>, z8.d<? super v8.k0>, java.lang.Object> r7 = r6.f33789b     // Catch: java.lang.Throwable -> L7d
            r0.f33790j = r6     // Catch: java.lang.Throwable -> L7d
            r0.f33791k = r2     // Catch: java.lang.Throwable -> L7d
            r0.f33794n = r4     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r7 = r7.mo4invoke(r2, r0)     // Catch: java.lang.Throwable -> L7d
            if (r7 != r1) goto L5d
            return r1
        L5d:
            r4 = r6
        L5e:
            r2.releaseIntercepted()
            s9.i<T> r7 = r4.f33788a
            boolean r2 = r7 instanceof s9.q0
            if (r2 == 0) goto L7a
            s9.q0 r7 = (s9.q0) r7
            r2 = 0
            r0.f33790j = r2
            r0.f33791k = r2
            r0.f33794n = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L77
            return r1
        L77:
            v8.k0 r7 = v8.k0.f35197a
            return r7
        L7a:
            v8.k0 r7 = v8.k0.f35197a
            return r7
        L7d:
            r7 = move-exception
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.q0.b(z8.d):java.lang.Object");
    }

    @Override // s9.i
    @Nullable
    public Object emit(T t10, @NotNull z8.d<? super v8.k0> dVar) {
        return this.f33788a.emit(t10, dVar);
    }
}
