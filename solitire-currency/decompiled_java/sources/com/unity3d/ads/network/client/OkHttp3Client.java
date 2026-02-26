package com.unity3d.ads.network.client;

import a9.c;
import com.unity3d.ads.network.HttpClient;
import com.unity3d.ads.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.ads.network.model.HttpRequest;
import com.unity3d.ads.network.model.HttpResponse;
import com.unity3d.services.core.domain.ISDKDispatchers;
import ga.b0;
import ga.d0;
import ga.e;
import ga.e0;
import ga.z;
import h9.p;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: OkHttp3Client.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OkHttp3Client implements HttpClient {

    @NotNull
    private final z client;

    @NotNull
    private final ISDKDispatchers dispatchers;

    /* JADX INFO: renamed from: com.unity3d.ads.network.client.OkHttp3Client$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: OkHttp3Client.kt */
    @f(c = "com.unity3d.ads.network.client.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", l = {35}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;
        final /* synthetic */ OkHttp3Client this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpRequest httpRequest, OkHttp3Client okHttp3Client, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$request = httpRequest;
            this.this$0 = okHttp3Client;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass2(this.$request, this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                b0 okHttpRequest = HttpRequestToOkHttpRequestKt.toOkHttpRequest(this.$request);
                OkHttp3Client okHttp3Client = this.this$0;
                long connectTimeout = this.$request.getConnectTimeout();
                long readTimeout = this.$request.getReadTimeout();
                this.label = 1;
                obj = okHttp3Client.makeRequest(okHttpRequest, connectTimeout, readTimeout, this);
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
            int iQ = d0Var.q();
            Map<String, List<String>> mapH = d0Var.L().h();
            String string = d0Var.I0().k().toString();
            e0 e0VarA = d0Var.a();
            String strString = e0VarA != null ? e0VarA.string() : null;
            if (strString == null) {
                strString = "";
            }
            t.h(mapH, "toMultimap()");
            t.h(string, "toString()");
            return new HttpResponse(strString, iQ, mapH, string);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super HttpResponse> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public OkHttp3Client(@NotNull ISDKDispatchers dispatchers, @NotNull z client) {
        t.i(dispatchers, "dispatchers");
        t.i(client, "client");
        this.dispatchers = dispatchers;
        this.client = client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeRequest(b0 b0Var, long j10, long j11, d<? super d0> dVar) throws Throwable {
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(c.c(dVar), 1);
        pVar.C();
        z.a aVarZ = this.client.z();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVarZ.d(j10, timeUnit).L(j11, timeUnit).b().b(b0Var).n(new ga.f() { // from class: com.unity3d.ads.network.client.OkHttp3Client$makeRequest$2$1
            @Override // ga.f
            public void onFailure(@NotNull e call, @NotNull IOException e10) {
                t.i(call, "call");
                t.i(e10, "e");
                o<d0> oVar = pVar;
                t.a aVar = v8.t.f35208b;
                oVar.resumeWith(v8.t.b(u.a(e10)));
            }

            @Override // ga.f
            public void onResponse(@NotNull e call, @NotNull d0 response) {
                kotlin.jvm.internal.t.i(call, "call");
                kotlin.jvm.internal.t.i(response, "response");
                pVar.resumeWith(v8.t.b(response));
            }
        });
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    @Override // com.unity3d.ads.network.HttpClient
    @Nullable
    public Object execute(@NotNull HttpRequest httpRequest, @NotNull d<? super HttpResponse> dVar) {
        return i.g(this.dispatchers.getIo(), new AnonymousClass2(httpRequest, this, null), dVar);
    }
}
