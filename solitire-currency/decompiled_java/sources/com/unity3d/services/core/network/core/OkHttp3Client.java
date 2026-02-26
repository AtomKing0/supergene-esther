package com.unity3d.services.core.network.core;

import a9.c;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import ga.b0;
import ga.d0;
import ga.e0;
import ga.z;
import h9.p;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.e;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: OkHttp3Client.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OkHttp3Client implements HttpClient {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String MSG_CONNECTION_FAILED = "Network request failed";

    @NotNull
    private static final String NETWORK_CLIENT_OKHTTP = "okhttp";

    @NotNull
    private final z client;

    @NotNull
    private final ISDKDispatchers dispatchers;

    /* JADX INFO: compiled from: OkHttp3Client.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: OkHttp3Client.kt */
    @f(c = "com.unity3d.services.core.network.core.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", l = {49}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpRequest httpRequest, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$request = httpRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return OkHttp3Client.this.new AnonymousClass2(this.$request, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            e eVarSource;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                OkHttp3Client okHttp3Client = OkHttp3Client.this;
                HttpRequest httpRequest = this.$request;
                long connectTimeout = httpRequest.getConnectTimeout();
                long readTimeout = this.$request.getReadTimeout();
                this.label = 1;
                obj = okHttp3Client.makeRequest(httpRequest, connectTimeout, readTimeout, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            d0 d0Var = (d0) obj;
            Object objString = null;
            if (this.$request.isProtobuf()) {
                e0 e0VarA = d0Var.a();
                if (e0VarA != null && (eVarSource = e0VarA.source()) != null) {
                    objString = eVarSource.l0();
                }
            } else {
                e0 e0VarA2 = d0Var.a();
                if (e0VarA2 != null) {
                    objString = e0VarA2.string();
                }
            }
            int iQ = d0Var.q();
            Map<String, List<String>> mapH = d0Var.L().h();
            String string = d0Var.I0().k().toString();
            if (objString == null) {
                objString = "";
            }
            String string2 = d0Var.i0().toString();
            t.h(mapH, "toMultimap()");
            t.h(string, "toString()");
            t.h(string2, "toString()");
            return new HttpResponse(objString, iQ, mapH, string, string2, OkHttp3Client.NETWORK_CLIENT_OKHTTP, 0L, 64, null);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super HttpResponse> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$executeBlocking$1, reason: invalid class name */
    /* JADX INFO: compiled from: OkHttp3Client.kt */
    @f(c = "com.unity3d.services.core.network.core.OkHttp3Client$executeBlocking$1", f = "OkHttp3Client.kt", l = {39}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HttpRequest httpRequest, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$request = httpRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return OkHttp3Client.this.new AnonymousClass1(this.$request, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                OkHttp3Client okHttp3Client = OkHttp3Client.this;
                HttpRequest httpRequest = this.$request;
                this.label = 1;
                obj = okHttp3Client.execute(httpRequest, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super HttpResponse> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public OkHttp3Client(@NotNull ISDKDispatchers dispatchers, @NotNull z client) {
        t.i(dispatchers, "dispatchers");
        t.i(client, "client");
        this.dispatchers = dispatchers;
        this.client = client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeRequest(final HttpRequest httpRequest, long j10, long j11, d<? super d0> dVar) throws Throwable {
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(c.c(dVar), 1);
        pVar.C();
        b0 okHttpProtoRequest = httpRequest.isProtobuf() ? HttpRequestToOkHttpRequestKt.toOkHttpProtoRequest(httpRequest) : HttpRequestToOkHttpRequestKt.toOkHttpRequest(httpRequest);
        z.a aVarZ = this.client.z();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVarZ.d(j10, timeUnit).L(j11, timeUnit).b().b(okHttpProtoRequest).n(new ga.f() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1
            @Override // ga.f
            public void onFailure(@NotNull ga.e call, @NotNull IOException e10) {
                t.i(call, "call");
                t.i(e10, "e");
                UnityAdsNetworkException unityAdsNetworkException = new UnityAdsNetworkException("Network request failed", null, null, call.a().k().toString(), null, null, "okhttp", 54, null);
                o<d0> oVar = pVar;
                t.a aVar = v8.t.f35208b;
                oVar.resumeWith(v8.t.b(u.a(unityAdsNetworkException)));
            }

            @Override // ga.f
            public void onResponse(@NotNull ga.e call, @NotNull d0 response) throws IOException {
                e eVarSource;
                kotlin.jvm.internal.t.i(call, "call");
                kotlin.jvm.internal.t.i(response, "response");
                File downloadDestination = httpRequest.getDownloadDestination();
                boolean z10 = false;
                if (downloadDestination != null && downloadDestination.exists()) {
                    z10 = true;
                }
                if (z10) {
                    ua.d dVarC = ua.k0.c(ua.k0.f(downloadDestination));
                    e0 e0VarA = response.a();
                    if (e0VarA != null && (eVarSource = e0VarA.source()) != null) {
                        dVarC.s(eVarSource);
                    }
                    dVarC.close();
                }
                pVar.resumeWith(v8.t.b(response));
            }
        });
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    @Nullable
    public Object execute(@NotNull HttpRequest httpRequest, @NotNull d<? super HttpResponse> dVar) {
        return i.g(this.dispatchers.getIo(), new AnonymousClass2(httpRequest, null), dVar);
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    @NotNull
    public HttpResponse executeBlocking(@NotNull HttpRequest request) {
        kotlin.jvm.internal.t.i(request, "request");
        return (HttpResponse) i.e(this.dispatchers.getIo(), new AnonymousClass1(request, null));
    }
}
