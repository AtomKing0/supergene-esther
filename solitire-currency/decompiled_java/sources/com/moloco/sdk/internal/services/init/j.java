package com.moloco.sdk.internal.services.init;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.MediationInfo;
import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.init.d f18755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final f f18756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f18757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.i f18758d;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", l = {93, 106}, m = "fetchInitResponse")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18759j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18760k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18761l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18762m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18764o;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18762m = obj;
            this.f18764o |= Integer.MIN_VALUE;
            return j.this.e(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitServiceImpl$fetchInitResponse$3", f = "InitService.kt", l = {99}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18765j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f18767l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ MediationInfo f18768m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, MediationInfo mediationInfo, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f18767l = str;
            this.f18768m = mediationInfo;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return j.this.new b(this.f18767l, this.f18768m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18765j;
            if (i10 == 0) {
                u.b(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "InitService", "Async fetching init response", null, false, 12, null);
                j jVar = j.this;
                String str = this.f18767l;
                MediationInfo mediationInfo = this.f18768m;
                this.f18765j = 1;
                if (jVar.d(str, mediationInfo, true, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", l = {133, 142, 144, 181, 194}, m = "fetchServerInitResponse$moloco_sdk_release")
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18769j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18770k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18771l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f18772m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f18773n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f18774o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f18775p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f18776q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f18777r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public /* synthetic */ Object f18778s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f18780u;

        public c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18778s = obj;
            this.f18780u |= Integer.MIN_VALUE;
            return j.this.d(null, null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", l = {67}, m = "performInit")
    public static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18781j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18782k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18784m;

        public d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18782k = obj;
            this.f18784m |= Integer.MIN_VALUE;
            return j.this.b(null, null, this);
        }
    }

    public j(@NotNull com.moloco.sdk.internal.services.init.d initApi, @NotNull f initCache, @NotNull o0 scope) {
        t.i(initApi, "initApi");
        t.i(initCache, "initCache");
        t.i(scope, "scope");
        this.f18755a = initApi;
        this.f18756b = initCache;
        this.f18757c = scope;
    }

    @Override // com.moloco.sdk.internal.services.init.i
    @VisibleForTesting(otherwise = 5)
    @Nullable
    public Object a(@NotNull z8.d<? super k0> dVar) {
        this.f18758d = null;
        Object objA = this.f18756b.a(dVar);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.init.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull com.moloco.sdk.publisher.MediationInfo r8, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h>> r9) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.j.b(java.lang.String, com.moloco.sdk.publisher.MediationInfo, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x034d -> B:81:0x0354). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.String r32, @org.jetbrains.annotations.NotNull com.moloco.sdk.publisher.MediationInfo r33, boolean r34, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h>> r35) {
        /*
            Method dump skipped, instruction units count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.j.d(java.lang.String, com.moloco.sdk.publisher.MediationInfo, boolean, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r23, com.moloco.sdk.publisher.MediationInfo r24, z8.d<? super com.moloco.sdk.internal.services.init.c> r25) {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.j.e(java.lang.String, com.moloco.sdk.publisher.MediationInfo, z8.d):java.lang.Object");
    }
}
