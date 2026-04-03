package com.unity3d.services.core.network.core;

import a9.c;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import h9.p;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.s1;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: CronetClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CronetClient implements HttpClient {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String MSG_CONNECTION_FAILED = "Network request failed";

    @NotNull
    private static final String NETWORK_CLIENT_CRONET = "cronet";

    @NotNull
    private final ISDKDispatchers dispatchers;

    @NotNull
    private final CronetEngine engine;

    /* JADX INFO: compiled from: CronetClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.CronetClient$executeBlocking$1, reason: invalid class name */
    /* JADX INFO: compiled from: CronetClient.kt */
    @f(c = "com.unity3d.services.core.network.core.CronetClient$executeBlocking$1", f = "CronetClient.kt", l = {26}, m = "invokeSuspend")
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
            return CronetClient.this.new AnonymousClass1(this.$request, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                CronetClient cronetClient = CronetClient.this;
                HttpRequest httpRequest = this.$request;
                this.label = 1;
                obj = cronetClient.execute(httpRequest, this);
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

    public CronetClient(@NotNull CronetEngine engine, @NotNull ISDKDispatchers dispatchers) {
        t.i(engine, "engine");
        t.i(dispatchers, "dispatchers");
        this.engine = engine;
        this.dispatchers = dispatchers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildUrl(HttpRequest httpRequest) {
        return r.w0(r.c1(httpRequest.getBaseURL(), '/') + '/' + r.c1(httpRequest.getPath(), '/'), UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getContentSize(UrlResponseInfo urlResponseInfo) {
        String str;
        Long lN;
        List<String> list = urlResponseInfo.getAllHeaders().get("Content-Length");
        if (list == null || (str = list.get(0)) == null || (lN = p9.p.n(str)) == null) {
            return -1L;
        }
        return lN.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPriority(int i10) {
        if (i10 == 0) {
            return 4;
        }
        if (i10 != 1) {
            return i10 != 2 ? 1 : 2;
        }
        return 3;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    @Nullable
    public Object execute(@NotNull HttpRequest httpRequest, @NotNull d<? super HttpResponse> dVar) throws Throwable {
        byte[] bytes;
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(c.c(dVar), 1);
        pVar.C();
        CronetEngine cronetEngine = this.engine;
        String strBuildUrl = buildUrl(httpRequest);
        final File downloadDestination = httpRequest.getDownloadDestination();
        UrlRequest.Builder builderNewUrlRequestBuilder = cronetEngine.newUrlRequestBuilder(strBuildUrl, new UnityAdsUrlRequestCallback(downloadDestination) { // from class: com.unity3d.services.core.network.core.CronetClient$execute$2$cronetRequest$1
            @Override // org.chromium.net.UrlRequest.Callback
            public void onFailed(@Nullable UrlRequest urlRequest, @Nullable UrlResponseInfo urlResponseInfo, @Nullable CronetException cronetException) {
                NetworkException networkException = cronetException instanceof NetworkException ? (NetworkException) cronetException : null;
                UnityAdsNetworkException unityAdsNetworkException = new UnityAdsNetworkException("Network request failed", null, urlResponseInfo != null ? Integer.valueOf(urlResponseInfo.getHttpStatusCode()) : null, urlResponseInfo != null ? urlResponseInfo.getUrl() : null, urlResponseInfo != null ? urlResponseInfo.getNegotiatedProtocol() : null, networkException != null ? Integer.valueOf(networkException.getCronetInternalErrorCode()) : null, "cronet", 2, null);
                o<HttpResponse> oVar = pVar;
                t.a aVar = v8.t.f35208b;
                oVar.resumeWith(v8.t.b(u.a(unityAdsNetworkException)));
            }

            @Override // com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback
            public void onSucceeded(@NotNull UrlRequest request, @NotNull UrlResponseInfo info, @NotNull byte[] bodyBytes) {
                kotlin.jvm.internal.t.i(request, "request");
                kotlin.jvm.internal.t.i(info, "info");
                kotlin.jvm.internal.t.i(bodyBytes, "bodyBytes");
                o<HttpResponse> oVar = pVar;
                int httpStatusCode = info.getHttpStatusCode();
                Map<String, List<String>> allHeaders = info.getAllHeaders();
                String url = info.getUrl();
                String negotiatedProtocol = info.getNegotiatedProtocol();
                long contentSize = this.getContentSize(info);
                kotlin.jvm.internal.t.h(allHeaders, "allHeaders");
                kotlin.jvm.internal.t.h(url, "url");
                kotlin.jvm.internal.t.h(negotiatedProtocol, "negotiatedProtocol");
                oVar.resumeWith(v8.t.b(new HttpResponse(bodyBytes, httpStatusCode, allHeaders, url, negotiatedProtocol, "cronet", contentSize)));
            }
        }, s1.a(this.dispatchers.getIo()));
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            String key = entry.getKey();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                builderNewUrlRequestBuilder.addHeader(key, (String) it.next());
            }
        }
        if (httpRequest.getMethod() == RequestType.POST) {
            Object body = httpRequest.getBody();
            if (body instanceof byte[]) {
                bytes = (byte[]) httpRequest.getBody();
            } else if (body instanceof String) {
                bytes = ((String) httpRequest.getBody()).getBytes(p9.d.f32957g);
                kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
            } else {
                bytes = new byte[0];
            }
            builderNewUrlRequestBuilder.setUploadDataProvider(UploadDataProviders.create(bytes), s1.a(this.dispatchers.getIo()));
        }
        builderNewUrlRequestBuilder.setHttpMethod(httpRequest.getMethod().toString()).setPriority(getPriority(httpRequest.getPriority())).build().start();
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    @NotNull
    public HttpResponse executeBlocking(@NotNull HttpRequest request) {
        kotlin.jvm.internal.t.i(request, "request");
        return (HttpResponse) i.e(this.dispatchers.getIo(), new AnonymousClass1(request, null));
    }
}
