package s9;

import com.ironsource.c3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes5.dex */
final class r0<T> implements c0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final c0<T> f33843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.p<i<? super T>, z8.d<? super v8.k0>, Object> f33844b;

    /* JADX INFO: compiled from: Share.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", l = {c3.a.b.f11500i}, m = "collect")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f33845j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ r0<T> f33846k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33847l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(r0<T> r0Var, z8.d<? super a> dVar) {
            super(dVar);
            this.f33846k = r0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33845j = obj;
            this.f33847l |= Integer.MIN_VALUE;
            return this.f33846k.collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r0(@NotNull c0<? extends T> c0Var, @NotNull h9.p<? super i<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        this.f33843a = c0Var;
        this.f33844b = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // s9.c0, s9.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull s9.i<? super T> r6, @org.jetbrains.annotations.NotNull z8.d<?> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof s9.r0.a
            if (r0 == 0) goto L13
            r0 = r7
            s9.r0$a r0 = (s9.r0.a) r0
            int r1 = r0.f33847l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33847l = r1
            goto L18
        L13:
            s9.r0$a r0 = new s9.r0$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f33845j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33847l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            v8.u.b(r7)
            goto L46
        L31:
            v8.u.b(r7)
            s9.c0<T> r7 = r5.f33843a
            s9.q0 r2 = new s9.q0
            h9.p<s9.i<? super T>, z8.d<? super v8.k0>, java.lang.Object> r4 = r5.f33844b
            r2.<init>(r6, r4)
            r0.f33847l = r3
            java.lang.Object r6 = r7.collect(r2, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            v8.h r6 = new v8.h
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.r0.collect(s9.i, z8.d):java.lang.Object");
    }
}
