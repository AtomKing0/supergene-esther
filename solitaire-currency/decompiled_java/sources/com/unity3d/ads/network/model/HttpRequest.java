package com.unity3d.ads.network.model;

import androidx.media3.exoplayer.RendererCapabilities;
import com.unity3d.ads.network.model.HttpBody;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpRequest {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String DEFAULT_SCHEME = "https";
    private static final int DEFAULT_TIMEOUT = 30000;

    @NotNull
    private final String baseURL;

    @NotNull
    private final HttpBody body;
    private final int callTimeout;
    private final int connectTimeout;

    @NotNull
    private final Map<String, List<String>> headers;

    @NotNull
    private final RequestType method;

    @NotNull
    private final Map<String, String> parameters;

    @NotNull
    private final String path;

    @Nullable
    private final Integer port;
    private final int readTimeout;

    @NotNull
    private final String scheme;
    private final int writeTimeout;

    /* JADX INFO: compiled from: HttpRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL) {
        this(baseURL, null, null, null, null, null, null, null, 0, 0, 0, 0, 4094, null);
        t.i(baseURL, "baseURL");
    }

    @NotNull
    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.readTimeout;
    }

    public final int component11() {
        return this.writeTimeout;
    }

    public final int component12() {
        return this.callTimeout;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    @NotNull
    public final RequestType component3() {
        return this.method;
    }

    @NotNull
    public final HttpBody component4() {
        return this.body;
    }

    @NotNull
    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    @NotNull
    public final Map<String, String> component6() {
        return this.parameters;
    }

    @NotNull
    public final String component7() {
        return this.scheme;
    }

    @Nullable
    public final Integer component8() {
        return this.port;
    }

    public final int component9() {
        return this.connectTimeout;
    }

    @NotNull
    public final HttpRequest copy(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13) {
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(scheme, "scheme");
        return new HttpRequest(baseURL, path, method, body, headers, parameters, scheme, num, i10, i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return t.d(this.baseURL, httpRequest.baseURL) && t.d(this.path, httpRequest.path) && this.method == httpRequest.method && t.d(this.body, httpRequest.body) && t.d(this.headers, httpRequest.headers) && t.d(this.parameters, httpRequest.parameters) && t.d(this.scheme, httpRequest.scheme) && t.d(this.port, httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout;
    }

    @NotNull
    public final String getBaseURL() {
        return this.baseURL;
    }

    @NotNull
    public final HttpBody getBody() {
        return this.body;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    @NotNull
    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final RequestType getMethod() {
        return this.method;
    }

    @NotNull
    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final Integer getPort() {
        return this.port;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.baseURL.hashCode() * 31) + this.path.hashCode()) * 31) + this.method.hashCode()) * 31) + this.body.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.scheme.hashCode()) * 31;
        Integer num = this.port;
        return ((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout;
    }

    @NotNull
    public String toString() {
        return "HttpRequest(baseURL=" + this.baseURL + ", path=" + this.path + ", method=" + this.method + ", body=" + this.body + ", headers=" + this.headers + ", parameters=" + this.parameters + ", scheme=" + this.scheme + ", port=" + this.port + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", callTimeout=" + this.callTimeout + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path) {
        this(baseURL, path, null, null, null, null, null, null, 0, 0, 0, 0, 4092, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method) {
        this(baseURL, path, method, null, null, null, null, null, 0, 0, 0, 0, 4088, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body) {
        this(baseURL, path, method, body, null, null, null, null, 0, 0, 0, 0, 4080, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers) {
        this(baseURL, path, method, body, headers, null, null, null, 0, 0, 0, 0, 4064, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters) {
        this(baseURL, path, method, body, headers, parameters, null, null, 0, 0, 0, 0, 4032, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull String scheme) {
        this(baseURL, path, method, body, headers, parameters, scheme, null, 0, 0, 0, 0, 3968, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull String scheme, @Nullable Integer num) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, 0, 0, 0, 0, 3840, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull String scheme, @Nullable Integer num, int i10) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, i10, 0, 0, 0, RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull String scheme, @Nullable Integer num, int i10, int i11) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, i10, i11, 0, 0, 3072, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, i10, i11, i12, 0, 2048, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @NotNull HttpBody body, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13) {
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(scheme, "scheme");
        this.baseURL = baseURL;
        this.path = path;
        this.method = method;
        this.body = body;
        this.headers = headers;
        this.parameters = parameters;
        this.scheme = scheme;
        this.port = num;
        this.connectTimeout = i10;
        this.readTimeout = i11;
        this.writeTimeout = i12;
        this.callTimeout = i13;
    }

    public /* synthetic */ HttpRequest(String str, String str2, RequestType requestType, HttpBody httpBody, Map map, Map map2, String str3, Integer num, int i10, int i11, int i12, int i13, int i14, k kVar) {
        this(str, (i14 & 2) != 0 ? "" : str2, (i14 & 4) != 0 ? RequestType.GET : requestType, (i14 & 8) != 0 ? HttpBody.EmptyBody.INSTANCE : httpBody, (i14 & 16) != 0 ? r0.g() : map, (i14 & 32) != 0 ? r0.g() : map2, (i14 & 64) != 0 ? "https" : str3, (i14 & 128) != 0 ? null : num, (i14 & 256) != 0 ? 30000 : i10, (i14 & 512) != 0 ? 30000 : i11, (i14 & 1024) != 0 ? 30000 : i12, (i14 & 2048) == 0 ? i13 : 30000);
    }
}
