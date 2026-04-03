package com.moloco.sdk.internal.services.init;

import android.net.Uri;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.g0;
import com.moloco.sdk.internal.services.h0;
import com.moloco.sdk.internal.services.init.h;
import com.moloco.sdk.internal.services.t;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.publisher.MediationInfo;
import h9.p;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.v;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import y7.w;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final h0 f18713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final u f18714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.usertracker.e f18715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f18716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f18717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final s7.a f18718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Uri f18719g;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitApiImpl", f = "InitApi.kt", l = {65, 141, 93}, m = "invoke")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18720j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18721k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18722l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f18723m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f18724n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f18725o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public /* synthetic */ Object f18726p;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f18728r;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18726p = obj;
            this.f18728r |= Integer.MIN_VALUE;
            return e.this.b(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitApiImpl$invoke$2", f = "InitApi.kt", l = {137}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super com.moloco.sdk.i>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18729j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ b8.c f18730k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b8.c cVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f18730k = cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.i> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f18730k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18729j;
            if (i10 == 0) {
                v8.u.b(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "InitApi", "Successful Init", null, false, 12, null);
                t7.b bVarR = this.f18730k.R();
                KType kTypeJ = kotlin.jvm.internal.o0.j(byte[].class);
                m8.a aVarB = m8.b.b(TypesJVMKt.getJavaType(kTypeJ), kotlin.jvm.internal.o0.b(byte[].class), kTypeJ);
                this.f18729j = 1;
                obj = bVarR.b(aVarB, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            if (obj != null) {
                return com.moloco.sdk.i.l((byte[]) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        }
    }

    public static final class c extends v implements h9.l<e8.l, k0> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ g0 f18732h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ MediationInfo f18733i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ t f18734j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g0 g0Var, MediationInfo mediationInfo, t tVar) {
            super(1);
            this.f18732h = g0Var;
            this.f18733i = mediationInfo;
            this.f18734j = tVar;
        }

        public final void a(@NotNull e8.l headers) {
            kotlin.jvm.internal.t.i(headers, "$this$headers");
            com.moloco.sdk.internal.m.a(headers, e.this.f18716d, this.f18732h.j(), this.f18733i);
            headers.f("X-Moloco-App-Bundle", this.f18734j.a());
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(e8.l lVar) {
            a(lVar);
            return k0.f35197a;
        }
    }

    public e(@NotNull h0 deviceInfoService, @NotNull u appInfoService, @NotNull com.moloco.sdk.internal.services.usertracker.e userTrackerService, @NotNull String sdkVersion, @NotNull String endpoint, long j10, @NotNull s7.a httpClient) {
        kotlin.jvm.internal.t.i(deviceInfoService, "deviceInfoService");
        kotlin.jvm.internal.t.i(appInfoService, "appInfoService");
        kotlin.jvm.internal.t.i(userTrackerService, "userTrackerService");
        kotlin.jvm.internal.t.i(sdkVersion, "sdkVersion");
        kotlin.jvm.internal.t.i(endpoint, "endpoint");
        kotlin.jvm.internal.t.i(httpClient, "httpClient");
        this.f18713a = deviceInfoService;
        this.f18714b = appInfoService;
        this.f18715c = userTrackerService;
        this.f18716d = sdkVersion;
        this.f18717e = j10;
        this.f18718f = httpClient;
        this.f18719g = Uri.parse(endpoint);
    }

    public final com.moloco.sdk.internal.t<com.moloco.sdk.i, h> a(Exception exc, com.moloco.sdk.acm.f fVar) {
        com.moloco.sdk.internal.services.init.b bVar = exc instanceof w ? com.moloco.sdk.internal.services.init.b.RequestTimeout : exc instanceof SSLHandshakeException ? com.moloco.sdk.internal.services.init.b.HttpSslError : exc instanceof SocketException ? com.moloco.sdk.internal.services.init.b.HttpSocketError : exc instanceof UnknownHostException ? com.moloco.sdk.internal.services.init.b.UnknownHostHttpError : com.moloco.sdk.internal.services.init.b.Unknown;
        MolocoLogger.error$default(MolocoLogger.INSTANCE, "InitApi", "SDK Init failed with client exception", exc, false, 8, null);
        com.moloco.sdk.acm.a.f17293a.u(fVar.f(com.moloco.sdk.internal.client_metrics_data.b.Result.c(), "failure").f(com.moloco.sdk.internal.client_metrics_data.b.Reason.c(), bVar.name()));
        return new t.a(new h.a(bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0144 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0159 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #3 {Exception -> 0x0055, blocks: (B:21:0x0050, B:39:0x0147, B:41:0x0159, B:47:0x0193, B:50:0x019f, B:51:0x01f1), top: B:67:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0193 A[Catch: Exception -> 0x0055, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0055, blocks: (B:21:0x0050, B:39:0x0147, B:41:0x0159, B:47:0x0193, B:50:0x019f, B:51:0x01f1), top: B:67:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.init.d
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.Nullable com.moloco.sdk.publisher.MediationInfo r22, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h>> r23) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.e.b(java.lang.String, com.moloco.sdk.publisher.MediationInfo, z8.d):java.lang.Object");
    }
}
