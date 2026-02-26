package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i0;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.CountdownFlowKt$countdownSecondsFlow$1", f = "CountdownFlow.kt", l = {26, 29, 30}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<s9.i<? super v8.c0>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19661j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19662k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f19663l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f19664m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19664m = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f19664m, dVar);
            aVar.f19663l = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull s9.i<? super v8.c0> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0077 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:17:0x004b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r7.f19662k
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2f
                if (r1 == r4) goto L25
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L25
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                int r1 = r7.f19661j
                java.lang.Object r4 = r7.f19663l
                s9.i r4 = (s9.i) r4
                v8.u.b(r8)
                r8 = r7
                goto L61
            L25:
                int r1 = r7.f19661j
                java.lang.Object r4 = r7.f19663l
                s9.i r4 = (s9.i) r4
                v8.u.b(r8)
                goto L4a
            L2f:
                v8.u.b(r8)
                java.lang.Object r8 = r7.f19663l
                s9.i r8 = (s9.i) r8
                int r1 = r7.f19664m
                v8.c0 r5 = v8.c0.a(r1)
                r7.f19663l = r8
                r7.f19661j = r1
                r7.f19662k = r4
                java.lang.Object r4 = r8.emit(r5, r7)
                if (r4 != r0) goto L49
                return r0
            L49:
                r4 = r8
            L4a:
                r8 = r7
            L4b:
                r5 = 0
                int r5 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m.a(r1, r5)
                if (r5 <= 0) goto L78
                r8.f19663l = r4
                r8.f19661j = r1
                r8.f19662k = r3
                r5 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r5 = kotlinx.coroutines.y0.a(r5, r8)
                if (r5 != r0) goto L61
                return r0
            L61:
                int r1 = r1 + (-1)
                int r1 = v8.c0.c(r1)
                v8.c0 r5 = v8.c0.a(r1)
                r8.f19663l = r4
                r8.f19661j = r1
                r8.f19662k = r2
                java.lang.Object r5 = r4.emit(r5, r8)
                if (r5 != r0) goto L4b
                return r0
            L78:
                v8.k0 r8 = v8.k0.f35197a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.n.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.CountdownFlowKt$countdownSecondsStateFlow$1", f = "CountdownFlow.kt", l = {53}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<s9.i<? super v8.c0>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19665j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19666k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.l0 f19667l;

        public static final class a implements s9.i<v8.c0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ kotlin.jvm.internal.l0 f19668a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s9.i<v8.c0> f19669b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(kotlin.jvm.internal.l0 l0Var, s9.i<? super v8.c0> iVar) {
                this.f19668a = l0Var;
                this.f19669b = iVar;
            }

            @Nullable
            public final Object b(int i10, @NotNull z8.d<? super v8.k0> dVar) {
                this.f19668a.f29831a = i10;
                Object objEmit = this.f19669b.emit(v8.c0.a(i10), dVar);
                return objEmit == a9.d.e() ? objEmit : v8.k0.f35197a;
            }

            @Override // s9.i
            public /* bridge */ /* synthetic */ Object emit(v8.c0 c0Var, z8.d dVar) {
                return b(c0Var.g(), dVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.jvm.internal.l0 l0Var, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19667l = l0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(this.f19667l, dVar);
            bVar.f19666k = obj;
            return bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull s9.i<? super v8.c0> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((b) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19665j;
            if (i10 == 0) {
                v8.u.b(obj);
                s9.i iVar = (s9.i) this.f19666k;
                s9.h<v8.c0> hVarA = n.a(this.f19667l.f29831a);
                a aVar = new a(this.f19667l, iVar);
                this.f19665j = 1;
                if (hVarA.collect(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    @NotNull
    public static final s9.h<v8.c0> a(int i10) {
        return s9.j.z(new a(i10, null));
    }

    @NotNull
    public static final m0<v8.c0> b(int i10, @NotNull o0 scope) {
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.l0 l0Var = new kotlin.jvm.internal.l0();
        l0Var.f29831a = i10;
        return s9.j.L(s9.j.z(new b(l0Var, null)), scope, i0.a.b(s9.i0.f33702a, 0L, 0L, 3, null), v8.c0.a(i10));
    }
}
