package b8;

import java.nio.charset.Charset;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: HttpResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: compiled from: HttpResponse.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {97}, m = "bodyAsChannel")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f2248j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f2249k;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2248j = obj;
            this.f2249k |= Integer.MIN_VALUE;
            return e.a(null, this);
        }
    }

    /* JADX INFO: compiled from: HttpResponse.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {97}, m = "bodyAsText")
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f2250j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f2251k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f2252l;

        b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2251k = obj;
            this.f2252l |= Integer.MIN_VALUE;
            return e.b(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull b8.c r5, @org.jetbrains.annotations.NotNull z8.d<? super io.ktor.utils.io.g> r6) {
        /*
            boolean r0 = r6 instanceof b8.e.a
            if (r0 == 0) goto L13
            r0 = r6
            b8.e$a r0 = (b8.e.a) r0
            int r1 = r0.f2249k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2249k = r1
            goto L18
        L13:
            b8.e$a r0 = new b8.e$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f2248j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f2249k
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r6)
            goto L53
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            v8.u.b(r6)
            t7.b r5 = r5.R()
            java.lang.Class<io.ktor.utils.io.g> r6 = io.ktor.utils.io.g.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.o0.j(r6)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.o0.b(r6)
            m8.a r6 = m8.b.b(r4, r6, r2)
            r0.f2249k = r3
            java.lang.Object r6 = r5.b(r6, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            if (r6 == 0) goto L58
            io.ktor.utils.io.g r6 = (io.ktor.utils.io.g) r6
            return r6
        L58:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.e.a(b8.c, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(@org.jetbrains.annotations.NotNull b8.c r5, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r6, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.String> r7) {
        /*
            boolean r0 = r7 instanceof b8.e.b
            if (r0 == 0) goto L13
            r0 = r7
            b8.e$b r0 = (b8.e.b) r0
            int r1 = r0.f2252l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2252l = r1
            goto L18
        L13:
            b8.e$b r0 = new b8.e$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f2251k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f2252l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2250j
            java.nio.charset.CharsetDecoder r5 = (java.nio.charset.CharsetDecoder) r5
            v8.u.b(r7)
            goto L66
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r7)
            java.nio.charset.Charset r7 = e8.s.a(r5)
            if (r7 != 0) goto L3f
            goto L40
        L3f:
            r6 = r7
        L40:
            java.nio.charset.CharsetDecoder r6 = r6.newDecoder()
            t7.b r5 = r5.R()
            java.lang.Class<p8.j> r7 = p8.j.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.o0.j(r7)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.o0.b(r7)
            m8.a r7 = m8.b.b(r4, r7, r2)
            r0.f2250j = r6
            r0.f2252l = r3
            java.lang.Object r7 = r5.b(r7, r0)
            if (r7 != r1) goto L65
            return r1
        L65:
            r5 = r6
        L66:
            if (r7 == 0) goto L77
            p8.j r7 = (p8.j) r7
            java.lang.String r6 = "decoder"
            kotlin.jvm.internal.t.h(r5, r6)
            r6 = 2
            r0 = 0
            r1 = 0
            java.lang.String r5 = o8.b.b(r5, r7, r1, r6, r0)
            return r5
        L77:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.core.ByteReadPacket"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.e.b(b8.c, java.nio.charset.Charset, z8.d):java.lang.Object");
    }

    public static /* synthetic */ Object c(c cVar, Charset charset, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = p9.d.f32952b;
        }
        return b(cVar, charset, dVar);
    }

    public static final void d(@NotNull c cVar) {
        t.i(cVar, "<this>");
        g.b bVar = cVar.getCoroutineContext().get(b2.O7);
        t.f(bVar);
        ((a0) bVar).complete();
    }

    @NotNull
    public static final a8.b e(@NotNull c cVar) {
        t.i(cVar, "<this>");
        return cVar.R().e();
    }
}
