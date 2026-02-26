package s9;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Transform.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class v {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f33904a;

        /* JADX INFO: renamed from: s9.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Emitters.kt */
        public static final class C0685a<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f33905a;

            /* JADX INFO: renamed from: s9.v$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
            public static final class C0686a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                /* synthetic */ Object f33906j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                int f33907k;

                public C0686a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f33906j = obj;
                    this.f33907k |= Integer.MIN_VALUE;
                    return C0685a.this.emit(null, this);
                }
            }

            public C0685a(i iVar) {
                this.f33905a = iVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof s9.v.a.C0685a.C0686a
                    if (r0 == 0) goto L13
                    r0 = r6
                    s9.v$a$a$a r0 = (s9.v.a.C0685a.C0686a) r0
                    int r1 = r0.f33907k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f33907k = r1
                    goto L18
                L13:
                    s9.v$a$a$a r0 = new s9.v$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f33906j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f33907k
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r6)
                    goto L41
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    v8.u.b(r6)
                    s9.i r6 = r4.f33905a
                    if (r5 == 0) goto L41
                    r0.f33907k = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L41
                    return r1
                L41:
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: s9.v.a.C0685a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public a(h hVar) {
            this.f33904a = hVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull i iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f33904a.collect(new C0685a(iVar), dVar);
            return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class b<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f33909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h9.p f33910b;

        /* JADX INFO: compiled from: Emitters.kt */
        public static final class a<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f33911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ h9.p f33912b;

            /* JADX INFO: renamed from: s9.v$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE, 224}, m = "emit")
            public static final class C0687a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                /* synthetic */ Object f33913j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                int f33914k;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                Object f33916m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                Object f33917n;

                public C0687a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f33913j = obj;
                    this.f33914k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(i iVar, h9.p pVar) {
                this.f33911a = iVar;
                this.f33912b = pVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(T r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof s9.v.b.a.C0687a
                    if (r0 == 0) goto L13
                    r0 = r7
                    s9.v$b$a$a r0 = (s9.v.b.a.C0687a) r0
                    int r1 = r0.f33914k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f33914k = r1
                    goto L18
                L13:
                    s9.v$b$a$a r0 = new s9.v$b$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f33913j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f33914k
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3e
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    v8.u.b(r7)
                    goto L6a
                L2c:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L34:
                    java.lang.Object r6 = r0.f33917n
                    s9.i r6 = (s9.i) r6
                    java.lang.Object r2 = r0.f33916m
                    v8.u.b(r7)
                    goto L5c
                L3e:
                    v8.u.b(r7)
                    s9.i r7 = r5.f33911a
                    h9.p r2 = r5.f33912b
                    r0.f33916m = r6
                    r0.f33917n = r7
                    r0.f33914k = r4
                    r4 = 6
                    kotlin.jvm.internal.r.c(r4)
                    java.lang.Object r2 = r2.mo4invoke(r6, r0)
                    r4 = 7
                    kotlin.jvm.internal.r.c(r4)
                    if (r2 != r1) goto L5a
                    return r1
                L5a:
                    r2 = r6
                    r6 = r7
                L5c:
                    r7 = 0
                    r0.f33916m = r7
                    r0.f33917n = r7
                    r0.f33914k = r3
                    java.lang.Object r6 = r6.emit(r2, r0)
                    if (r6 != r1) goto L6a
                    return r1
                L6a:
                    v8.k0 r6 = v8.k0.f35197a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: s9.v.b.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public b(h hVar, h9.p pVar) {
            this.f33909a = hVar;
            this.f33910b = pVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull i iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f33909a.collect(new a(iVar, this.f33910b), dVar);
            return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
        }
    }

    @NotNull
    public static final <T> h<T> a(@NotNull h<? extends T> hVar) {
        return new a(hVar);
    }

    @NotNull
    public static final <T> h<T> b(@NotNull h<? extends T> hVar, @NotNull h9.p<? super T, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        return new b(hVar, pVar);
    }
}
