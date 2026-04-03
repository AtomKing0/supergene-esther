package r9;

import kotlinx.coroutines.j0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: compiled from: Produce.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33404j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33405k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33406l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33407m;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33406l = obj;
            this.f33407m |= Integer.MIN_VALUE;
            return p.a(null, null, this);
        }
    }

    /* JADX INFO: compiled from: Produce.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.o<k0> f33408g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(kotlinx.coroutines.o<? super k0> oVar) {
            super(1);
            this.f33408g = oVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            kotlinx.coroutines.o<k0> oVar = this.f33408g;
            t.a aVar = v8.t.f35208b;
            oVar.resumeWith(v8.t.b(k0.f35197a));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull r9.r<?> r4, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
        /*
            boolean r0 = r6 instanceof r9.p.a
            if (r0 == 0) goto L13
            r0 = r6
            r9.p$a r0 = (r9.p.a) r0
            int r1 = r0.f33407m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33407m = r1
            goto L18
        L13:
            r9.p$a r0 = new r9.p$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f33406l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33407m
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f33405k
            r5 = r4
            h9.a r5 = (h9.a) r5
            java.lang.Object r4 = r0.f33404j
            r9.r r4 = (r9.r) r4
            v8.u.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L7a
        L32:
            r4 = move-exception
            goto L80
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            v8.u.b(r6)
            z8.g r6 = r0.getContext()
            kotlinx.coroutines.b2$b r2 = kotlinx.coroutines.b2.O7
            z8.g$b r6 = r6.get(r2)
            if (r6 != r4) goto L4d
            r6 = r3
            goto L4e
        L4d:
            r6 = 0
        L4e:
            if (r6 == 0) goto L84
            r0.f33404j = r4     // Catch: java.lang.Throwable -> L32
            r0.f33405k = r5     // Catch: java.lang.Throwable -> L32
            r0.f33407m = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.p r6 = new kotlinx.coroutines.p     // Catch: java.lang.Throwable -> L32
            z8.d r2 = a9.b.c(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.C()     // Catch: java.lang.Throwable -> L32
            r9.p$b r2 = new r9.p$b     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.g(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.z()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = a9.b.e()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L77
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch: java.lang.Throwable -> L32
        L77:
            if (r4 != r1) goto L7a
            return r1
        L7a:
            r5.invoke()
            v8.k0 r4 = v8.k0.f35197a
            return r4
        L80:
            r5.invoke()
            throw r4
        L84:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.p.a(r9.r, h9.a, z8.d):java.lang.Object");
    }

    @NotNull
    public static final <E> t<E> b(@NotNull o0 o0Var, @NotNull z8.g gVar, int i10, @NotNull h9.p<? super r<? super E>, ? super z8.d<? super k0>, ? extends Object> pVar) {
        return c(o0Var, gVar, i10, r9.a.SUSPEND, q0.DEFAULT, null, pVar);
    }

    @NotNull
    public static final <E> t<E> c(@NotNull o0 o0Var, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar, @NotNull q0 q0Var, @Nullable h9.l<? super Throwable, k0> lVar, @NotNull h9.p<? super r<? super E>, ? super z8.d<? super k0>, ? extends Object> pVar) {
        q qVar = new q(j0.d(o0Var, gVar), g.b(i10, aVar, null, 4, null));
        if (lVar != null) {
            qVar.J(lVar);
        }
        qVar.T0(q0Var, qVar, pVar);
        return qVar;
    }

    public static /* synthetic */ t d(o0 o0Var, z8.g gVar, int i10, h9.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return b(o0Var, gVar, i10, pVar);
    }

    public static /* synthetic */ t e(o0 o0Var, z8.g gVar, int i10, r9.a aVar, q0 q0Var, h9.l lVar, h9.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        z8.g gVar2 = gVar;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            aVar = r9.a.SUSPEND;
        }
        r9.a aVar2 = aVar;
        if ((i11 & 8) != 0) {
            q0Var = q0.DEFAULT;
        }
        q0 q0Var2 = q0Var;
        if ((i11 & 16) != 0) {
            lVar = null;
        }
        return c(o0Var, gVar2, i12, aVar2, q0Var2, lVar, pVar);
    }
}
