package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.util.Patterns;
import com.moloco.sdk.internal.MolocoLogger;
import e8.s;
import e8.t;
import e8.v;
import h9.p;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", l = {34}, m = "sendGetRequest")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f21711j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f21712k;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21711j = obj;
            this.f21712k |= Integer.MIN_VALUE;
            return e.a(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendGetRequest$2", f = "HttpRequestClient.kt", l = {64}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21713j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ s7.a f21714k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f21715l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s7.a aVar, String str, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f21714k = aVar;
            this.f21715l = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super Boolean> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f21714k, this.f21715l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21713j;
            boolean z10 = true;
            if (i10 == 0) {
                u.b(obj);
                s7.a aVar = this.f21714k;
                String str = this.f21715l;
                a8.c cVar = new a8.c();
                a8.e.b(cVar, str);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.b.a(cVar, 5000L);
                cVar.n(t.f25351b.a());
                b8.g gVar = new b8.g(cVar, aVar);
                this.f21713j = 1;
                obj = gVar.d(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            v vVarF = ((b8.c) obj).f();
            v.a aVar2 = v.f25372c;
            if (!kotlin.jvm.internal.t.d(vVarF, aVar2.B()) && !kotlin.jvm.internal.t.d(vVarF, aVar2.v())) {
                z10 = false;
            }
            return kotlin.coroutines.jvm.internal.b.a(z10);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", l = {46}, m = "sendPostRequest")
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f21716j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f21717k;

        public c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21716j = obj;
            this.f21717k |= Integer.MIN_VALUE;
            return e.b(null, null, null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendPostRequest$2", f = "HttpRequestClient.kt", l = {81}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21718j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ s7.a f21719k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f21720l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ byte[] f21721m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ e8.c f21722n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(s7.a aVar, String str, byte[] bArr, e8.c cVar, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f21719k = aVar;
            this.f21720l = str;
            this.f21721m = bArr;
            this.f21722n = cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super Boolean> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new d(this.f21719k, this.f21720l, this.f21721m, this.f21722n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21718j;
            boolean z10 = true;
            if (i10 == 0) {
                u.b(obj);
                s7.a aVar = this.f21719k;
                String str = this.f21720l;
                byte[] bArr = this.f21721m;
                e8.c cVar = this.f21722n;
                a8.c cVar2 = new a8.c();
                a8.e.b(cVar2, str);
                if (bArr == null) {
                    cVar2.j(f8.a.f25730a);
                    KType kTypeJ = kotlin.jvm.internal.o0.j(byte[].class);
                    cVar2.k(m8.b.b(TypesJVMKt.getJavaType(kTypeJ), kotlin.jvm.internal.o0.b(byte[].class), kTypeJ));
                } else if (bArr instanceof f8.b) {
                    cVar2.j(bArr);
                    cVar2.k(null);
                } else {
                    cVar2.j(bArr);
                    KType kTypeJ2 = kotlin.jvm.internal.o0.j(byte[].class);
                    cVar2.k(m8.b.b(TypesJVMKt.getJavaType(kTypeJ2), kotlin.jvm.internal.o0.b(byte[].class), kTypeJ2));
                }
                s.e(cVar2, cVar);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.b.a(cVar2, 5000L);
                cVar2.n(t.f25351b.c());
                b8.g gVar = new b8.g(cVar2, aVar);
                this.f21718j = 1;
                obj = gVar.d(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            v vVarF = ((b8.c) obj).f();
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "HttpClient", "Response status: " + vVarF + " for url: " + this.f21720l, false, 4, null);
            v.a aVar2 = v.f25372c;
            if (!kotlin.jvm.internal.t.d(vVarF, aVar2.B()) && !kotlin.jvm.internal.t.d(vVarF, aVar2.v())) {
                z10 = false;
            }
            return kotlin.coroutines.jvm.internal.b.a(z10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull s7.a r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a) r0
            int r1 = r0.f21712k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21712k = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f21711j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f21712k
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r7)     // Catch: java.lang.Exception -> L52
            goto L4b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            v8.u.b(r7)
            com.moloco.sdk.internal.scheduling.a r7 = com.moloco.sdk.internal.scheduling.c.a()     // Catch: java.lang.Exception -> L52
            z8.g r7 = r7.getIo()     // Catch: java.lang.Exception -> L52
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$b r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$b     // Catch: java.lang.Exception -> L52
            r4 = 0
            r2.<init>(r5, r6, r4)     // Catch: java.lang.Exception -> L52
            r0.f21712k = r3     // Catch: java.lang.Exception -> L52
            java.lang.Object r7 = kotlinx.coroutines.i.g(r7, r2, r0)     // Catch: java.lang.Exception -> L52
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> L52
            boolean r5 = r7.booleanValue()     // Catch: java.lang.Exception -> L52
            goto L53
        L52:
            r5 = 0
        L53:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(s7.a, java.lang.String, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(@org.jetbrains.annotations.NotNull s7.a r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull byte[] r12, @org.jetbrains.annotations.NotNull e8.c r13, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r14) {
        /*
            boolean r0 = r14 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.c
            if (r0 == 0) goto L13
            r0 = r14
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$c r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.c) r0
            int r1 = r0.f21717k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21717k = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$c r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$c
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f21716j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f21717k
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r14)     // Catch: java.lang.Exception -> L57
            goto L50
        L29:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L31:
            v8.u.b(r14)
            com.moloco.sdk.internal.scheduling.a r14 = com.moloco.sdk.internal.scheduling.c.a()     // Catch: java.lang.Exception -> L57
            z8.g r14 = r14.getIo()     // Catch: java.lang.Exception -> L57
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$d r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$d     // Catch: java.lang.Exception -> L57
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L57
            r0.f21717k = r3     // Catch: java.lang.Exception -> L57
            java.lang.Object r14 = kotlinx.coroutines.i.g(r14, r2, r0)     // Catch: java.lang.Exception -> L57
            if (r14 != r1) goto L50
            return r1
        L50:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Exception -> L57
            boolean r10 = r14.booleanValue()     // Catch: java.lang.Exception -> L57
            goto L58
        L57:
            r10 = 0
        L58:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.b.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.b(s7.a, java.lang.String, byte[], e8.c, z8.d):java.lang.Object");
    }

    public static final boolean c(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        boolean zMatches = Patterns.WEB_URL.matcher(str).matches();
        if (!zMatches) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "HttpRequestClient", "URL is invalid. " + str, null, false, 12, null);
        }
        return zMatches;
    }
}
