package b8;

import h9.p;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import y7.m;
import y7.n;

/* JADX INFO: compiled from: HttpStatement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a8.c f2260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final s7.a f2261b;

    /* JADX INFO: compiled from: HttpStatement.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {126}, m = "cleanup")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f2262j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f2263k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f2265m;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2263k = obj;
            this.f2265m |= Integer.MIN_VALUE;
            return g.this.b(null, this);
        }
    }

    /* JADX INFO: compiled from: HttpStatement.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {47, 50, 52, 52}, m = "execute")
    static final class b<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f2266j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f2267k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f2268l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f2270n;

        b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2268l = obj;
            this.f2270n |= Integer.MIN_VALUE;
            return g.this.c(null, this);
        }
    }

    /* JADX INFO: compiled from: HttpStatement.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", l = {63}, m = "invokeSuspend")
    static final class c extends l implements p<b8.c, z8.d<? super b8.c>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f2271j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f2272k;

        c(z8.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            c cVar = new c(dVar);
            cVar.f2272k = obj;
            return cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull b8.c cVar, @Nullable z8.d<? super b8.c> dVar) {
            return ((c) create(cVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f2271j;
            if (i10 == 0) {
                u.b(obj);
                t7.b bVarR = ((b8.c) this.f2272k).R();
                this.f2271j = 1;
                obj = t7.d.a(bVarR, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return ((t7.b) obj).f();
        }
    }

    /* JADX INFO: compiled from: HttpStatement.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {108}, m = "executeUnsafe")
    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f2273j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f2275l;

        d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2273j = obj;
            this.f2275l |= Integer.MIN_VALUE;
            return g.this.e(this);
        }
    }

    public g(@NotNull a8.c builder, @NotNull s7.a client) {
        t.i(builder, "builder");
        t.i(client, "client");
        this.f2260a = builder;
        this.f2261b = client;
        a();
    }

    private final void a() {
        Set setKeySet;
        Map map = (Map) this.f2260a.c().d(v7.f.a());
        if (map == null || (setKeySet = map.keySet()) == null) {
            return;
        }
        ArrayList<m> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof m) {
                arrayList.add(obj);
            }
        }
        for (m mVar : arrayList) {
            if (n.c(this.f2261b, mVar) == null) {
                throw new IllegalArgumentException(("Consider installing " + mVar + " plugin because the request requires it to be installed").toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull b8.c r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof b8.g.a
            if (r0 == 0) goto L13
            r0 = r6
            b8.g$a r0 = (b8.g.a) r0
            int r1 = r0.f2265m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2265m = r1
            goto L18
        L13:
            b8.g$a r0 = new b8.g$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f2263k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f2265m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2262j
            kotlinx.coroutines.a0 r5 = (kotlinx.coroutines.a0) r5
            v8.u.b(r6)
            goto L5c
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            z8.g r6 = r5.getCoroutineContext()
            kotlinx.coroutines.b2$b r2 = kotlinx.coroutines.b2.O7
            z8.g$b r6 = r6.get(r2)
            kotlin.jvm.internal.t.f(r6)
            kotlinx.coroutines.a0 r6 = (kotlinx.coroutines.a0) r6
            r6.complete()
            io.ktor.utils.io.g r5 = r5.c()     // Catch: java.lang.Throwable -> L51
            io.ktor.utils.io.i.a(r5)     // Catch: java.lang.Throwable -> L51
        L51:
            r0.f2262j = r6
            r0.f2265m = r3
            java.lang.Object r5 = r6.z(r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            v8.k0 r5 = v8.k0.f35197a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.g.b(b8.c, z8.d):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:57|(1:(1:(1:(1:(2:14|15)(3:16|17|49))(3:19|20|58))(5:22|53|23|40|(1:42)(2:43|44)))(2:27|28))(3:30|31|(1:33)(1:34))|35|55|36|(1:38)(3:39|40|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object c(@org.jetbrains.annotations.NotNull h9.p<? super b8.c, ? super z8.d<? super T>, ? extends java.lang.Object> r10, @org.jetbrains.annotations.NotNull z8.d<? super T> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof b8.g.b
            if (r0 == 0) goto L13
            r0 = r11
            b8.g$b r0 = (b8.g.b) r0
            int r1 = r0.f2270n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2270n = r1
            goto L18
        L13:
            b8.g$b r0 = new b8.g$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f2268l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f2270n
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L63
            if (r2 == r7) goto L57
            if (r2 == r6) goto L46
            if (r2 == r5) goto L40
            if (r2 == r4) goto L37
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            java.lang.Object r10 = r0.f2266j
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            v8.u.b(r11)     // Catch: java.util.concurrent.CancellationException -> La4
            goto La3
        L40:
            java.lang.Object r10 = r0.f2266j
            v8.u.b(r11)     // Catch: java.util.concurrent.CancellationException -> La4
            goto L94
        L46:
            java.lang.Object r10 = r0.f2267k
            b8.c r10 = (b8.c) r10
            java.lang.Object r2 = r0.f2266j
            b8.g r2 = (b8.g) r2
            v8.u.b(r11)     // Catch: java.lang.Throwable -> L52
            goto L86
        L52:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L96
        L57:
            java.lang.Object r10 = r0.f2267k
            h9.p r10 = (h9.p) r10
            java.lang.Object r2 = r0.f2266j
            b8.g r2 = (b8.g) r2
            v8.u.b(r11)     // Catch: java.util.concurrent.CancellationException -> La4
            goto L74
        L63:
            v8.u.b(r11)
            r0.f2266j = r9     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f2267k = r10     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f2270n = r7     // Catch: java.util.concurrent.CancellationException -> La4
            java.lang.Object r11 = r9.e(r0)     // Catch: java.util.concurrent.CancellationException -> La4
            if (r11 != r1) goto L73
            return r1
        L73:
            r2 = r9
        L74:
            b8.c r11 = (b8.c) r11     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f2266j = r2     // Catch: java.lang.Throwable -> L95
            r0.f2267k = r11     // Catch: java.lang.Throwable -> L95
            r0.f2270n = r6     // Catch: java.lang.Throwable -> L95
            java.lang.Object r10 = r10.mo4invoke(r11, r0)     // Catch: java.lang.Throwable -> L95
            if (r10 != r1) goto L83
            return r1
        L83:
            r8 = r11
            r11 = r10
            r10 = r8
        L86:
            r0.f2266j = r11     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f2267k = r3     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f2270n = r5     // Catch: java.util.concurrent.CancellationException -> La4
            java.lang.Object r10 = r2.b(r10, r0)     // Catch: java.util.concurrent.CancellationException -> La4
            if (r10 != r1) goto L93
            return r1
        L93:
            r10 = r11
        L94:
            return r10
        L95:
            r10 = move-exception
        L96:
            r0.f2266j = r10     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f2267k = r3     // Catch: java.util.concurrent.CancellationException -> La4
            r0.f2270n = r4     // Catch: java.util.concurrent.CancellationException -> La4
            java.lang.Object r11 = r2.b(r11, r0)     // Catch: java.util.concurrent.CancellationException -> La4
            if (r11 != r1) goto La3
            return r1
        La3:
            throw r10     // Catch: java.util.concurrent.CancellationException -> La4
        La4:
            r10 = move-exception
            java.lang.Throwable r10 = c8.d.a(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.g.c(h9.p, z8.d):java.lang.Object");
    }

    @Nullable
    public final Object d(@NotNull z8.d<? super b8.c> dVar) {
        return c(new c(null), dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull z8.d<? super b8.c> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof b8.g.d
            if (r0 == 0) goto L13
            r0 = r5
            b8.g$d r0 = (b8.g.d) r0
            int r1 = r0.f2275l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2275l = r1
            goto L18
        L13:
            b8.g$d r0 = new b8.g$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f2273j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f2275l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r5)     // Catch: java.util.concurrent.CancellationException -> L51
            goto L4a
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            v8.u.b(r5)
            a8.c r5 = new a8.c     // Catch: java.util.concurrent.CancellationException -> L51
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L51
            a8.c r2 = r4.f2260a     // Catch: java.util.concurrent.CancellationException -> L51
            a8.c r5 = r5.p(r2)     // Catch: java.util.concurrent.CancellationException -> L51
            s7.a r2 = r4.f2261b     // Catch: java.util.concurrent.CancellationException -> L51
            r0.f2275l = r3     // Catch: java.util.concurrent.CancellationException -> L51
            java.lang.Object r5 = r2.c(r5, r0)     // Catch: java.util.concurrent.CancellationException -> L51
            if (r5 != r1) goto L4a
            return r1
        L4a:
            t7.b r5 = (t7.b) r5     // Catch: java.util.concurrent.CancellationException -> L51
            b8.c r5 = r5.f()     // Catch: java.util.concurrent.CancellationException -> L51
            return r5
        L51:
            r5 = move-exception
            java.lang.Throwable r5 = c8.d.a(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.g.e(z8.d):java.lang.Object");
    }

    @NotNull
    public String toString() {
        return "HttpStatement[" + this.f2260a.i() + ']';
    }
}
