package ab;

import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ab.b f436g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ab.b bVar) {
            super(1);
            this.f436g = bVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f436g.cancel();
        }
    }

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ab.b f437g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ab.b bVar) {
            super(1);
            this.f437g = bVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f437g.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    public static final class c<T> implements ab.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.o f438a;

        c(kotlinx.coroutines.o oVar) {
            this.f438a = oVar;
        }

        @Override // ab.d
        public void a(@NotNull ab.b<T> call, @NotNull y<T> response) {
            kotlin.jvm.internal.t.j(call, "call");
            kotlin.jvm.internal.t.j(response, "response");
            if (!response.d()) {
                kotlinx.coroutines.o oVar = this.f438a;
                l lVar = new l(response);
                t.a aVar = v8.t.f35208b;
                oVar.resumeWith(v8.t.b(v8.u.a(lVar)));
                return;
            }
            T tA = response.a();
            if (tA != null) {
                this.f438a.resumeWith(v8.t.b(tA));
                return;
            }
            Object objJ = call.a().j(n.class);
            if (objJ == null) {
                kotlin.jvm.internal.t.u();
            }
            kotlin.jvm.internal.t.e(objJ, "call.request().tag(Invocation::class.java)!!");
            Method method = ((n) objJ).a();
            StringBuilder sb = new StringBuilder();
            sb.append("Response from ");
            kotlin.jvm.internal.t.e(method, "method");
            Class<?> declaringClass = method.getDeclaringClass();
            kotlin.jvm.internal.t.e(declaringClass, "method.declaringClass");
            sb.append(declaringClass.getName());
            sb.append('.');
            sb.append(method.getName());
            sb.append(" was null but response body type was declared as non-null");
            v8.i iVar = new v8.i(sb.toString());
            kotlinx.coroutines.o oVar2 = this.f438a;
            t.a aVar2 = v8.t.f35208b;
            oVar2.resumeWith(v8.t.b(v8.u.a(iVar)));
        }

        @Override // ab.d
        public void b(@NotNull ab.b<T> call, @NotNull Throwable t10) {
            kotlin.jvm.internal.t.j(call, "call");
            kotlin.jvm.internal.t.j(t10, "t");
            kotlinx.coroutines.o oVar = this.f438a;
            t.a aVar = v8.t.f35208b;
            oVar.resumeWith(v8.t.b(v8.u.a(t10)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    public static final class d<T> implements ab.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.o f439a;

        d(kotlinx.coroutines.o oVar) {
            this.f439a = oVar;
        }

        @Override // ab.d
        public void a(@NotNull ab.b<T> call, @NotNull y<T> response) {
            kotlin.jvm.internal.t.j(call, "call");
            kotlin.jvm.internal.t.j(response, "response");
            if (response.d()) {
                this.f439a.resumeWith(v8.t.b(response.a()));
                return;
            }
            kotlinx.coroutines.o oVar = this.f439a;
            l lVar = new l(response);
            t.a aVar = v8.t.f35208b;
            oVar.resumeWith(v8.t.b(v8.u.a(lVar)));
        }

        @Override // ab.d
        public void b(@NotNull ab.b<T> call, @NotNull Throwable t10) {
            kotlin.jvm.internal.t.j(call, "call");
            kotlin.jvm.internal.t.j(t10, "t");
            kotlinx.coroutines.o oVar = this.f439a;
            t.a aVar = v8.t.f35208b;
            oVar.resumeWith(v8.t.b(v8.u.a(t10)));
        }
    }

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class e extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ab.b f440g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ab.b bVar) {
            super(1);
            this.f440g = bVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f440g.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    public static final class f<T> implements ab.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.o f441a;

        f(kotlinx.coroutines.o oVar) {
            this.f441a = oVar;
        }

        @Override // ab.d
        public void a(@NotNull ab.b<T> call, @NotNull y<T> response) {
            kotlin.jvm.internal.t.j(call, "call");
            kotlin.jvm.internal.t.j(response, "response");
            this.f441a.resumeWith(v8.t.b(response));
        }

        @Override // ab.d
        public void b(@NotNull ab.b<T> call, @NotNull Throwable t10) {
            kotlin.jvm.internal.t.j(call, "call");
            kotlin.jvm.internal.t.j(t10, "t");
            kotlinx.coroutines.o oVar = this.f441a;
            t.a aVar = v8.t.f35208b;
            oVar.resumeWith(v8.t.b(v8.u.a(t10)));
        }
    }

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z8.d f442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception f443b;

        g(z8.d dVar, Exception exc) {
            this.f442a = dVar;
            this.f443b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            z8.d dVarC = a9.c.c(this.f442a);
            Exception exc = this.f443b;
            t.a aVar = v8.t.f35208b;
            dVarC.resumeWith(v8.t.b(v8.u.a(exc)));
        }
    }

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    @kotlin.coroutines.jvm.internal.f(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    static final class h extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f444j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f445k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f446l;

        h(z8.d dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f444j = obj;
            this.f445k |= Integer.MIN_VALUE;
            return o.d(null, this);
        }
    }

    @Nullable
    public static final <T> Object a(@NotNull ab.b<T> bVar, @NotNull z8.d<? super T> dVar) throws Throwable {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.m(new a(bVar));
        bVar.i0(new c(pVar));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    @Nullable
    public static final <T> Object b(@NotNull ab.b<T> bVar, @NotNull z8.d<? super T> dVar) throws Throwable {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.m(new b(bVar));
        bVar.i0(new d(pVar));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    @Nullable
    public static final <T> Object c(@NotNull ab.b<T> bVar, @NotNull z8.d<? super y<T>> dVar) throws Throwable {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.m(new e(bVar));
        bVar.i0(new f(pVar));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.Exception r4, @org.jetbrains.annotations.NotNull z8.d<?> r5) {
        /*
            boolean r0 = r5 instanceof ab.o.h
            if (r0 == 0) goto L13
            r0 = r5
            ab.o$h r0 = (ab.o.h) r0
            int r1 = r0.f445k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f445k = r1
            goto L18
        L13:
            ab.o$h r0 = new ab.o$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f444j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f445k
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f446l
            java.lang.Exception r4 = (java.lang.Exception) r4
            v8.u.b(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            v8.u.b(r5)
            r0.f446l = r4
            r0.f445k = r3
            kotlinx.coroutines.k0 r5 = kotlinx.coroutines.e1.a()
            z8.g r2 = r0.getContext()
            ab.o$g r3 = new ab.o$g
            r3.<init>(r0, r4)
            r5.dispatch(r2, r3)
            java.lang.Object r4 = a9.b.e()
            java.lang.Object r5 = a9.b.e()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.h.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            v8.k0 r4 = v8.k0.f35197a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.o.d(java.lang.Exception, z8.d):java.lang.Object");
    }
}
