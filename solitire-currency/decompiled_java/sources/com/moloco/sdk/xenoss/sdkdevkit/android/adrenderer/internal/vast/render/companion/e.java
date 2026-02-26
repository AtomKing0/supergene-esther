package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i;
import s9.i0;
import s9.j;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final j0 f20869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final m0<d.a> f20870c;

    public static final class a implements s9.h<d.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.h f20871a;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e$a$a, reason: collision with other inner class name */
        public static final class C0437a<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f20872a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.CompanionGoNextActionImpl$special$$inlined$map$1$2", f = "CompanionGoNextAction.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
            public static final class C0438a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public /* synthetic */ Object f20873j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f20874k;

                public C0438a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f20873j = obj;
                    this.f20874k |= Integer.MIN_VALUE;
                    return C0437a.this.emit(null, this);
                }
            }

            public C0437a(i iVar) {
                this.f20872a = iVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull z8.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e.a.C0437a.C0438a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e$a$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e.a.C0437a.C0438a) r0
                    int r1 = r0.f20874k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f20874k = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e$a$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f20873j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f20874k
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    v8.u.b(r6)
                    s9.i r6 = r4.f20872a
                    v8.c0 r5 = (v8.c0) r5
                    int r5 = r5.g()
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d$a r5 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.f.b(r5)
                    r0.f20874k = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e.a.C0437a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public a(s9.h hVar) {
            this.f20871a = hVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull i<? super d.a> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f20871a.collect(new C0437a(iVar), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    public /* synthetic */ e(int i10, o0 o0Var, k kVar) {
        this(i10, o0Var);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    public m0<d.a> l() {
        return this.f20870c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d
    public void reset() {
        this.f20869b.c(this.f20868a);
    }

    public e(int i10, o0 scope) {
        t.i(scope, "scope");
        this.f20868a = i10;
        j0 j0Var = new j0(i10, scope, null);
        this.f20869b = j0Var;
        this.f20870c = j.L(new a(j0Var.b()), scope, i0.a.b(i0.f33702a, 0L, 0L, 3, null), f.c(i10));
    }
}
