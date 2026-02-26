package com.unity3d.services.core.network.model;

import com.unity3d.ads.core.data.model.OperationType;
import java.io.File;
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
    public static final String DEFAULT_SCHEME = "https";
    public static final int DEFAULT_TIMEOUT = 30000;

    @NotNull
    private final String baseURL;

    @Nullable
    private final Object body;

    @NotNull
    private final BodyType bodyType;
    private final int callTimeout;
    private final int connectTimeout;

    @Nullable
    private final File downloadDestination;

    @NotNull
    private final Map<String, List<String>> headers;
    private final boolean isProtobuf;

    @NotNull
    private final RequestType method;

    @NotNull
    private final OperationType operationType;

    @NotNull
    private final Map<String, String> parameters;

    @NotNull
    private final String path;

    @Nullable
    private final Integer port;
    private final int priority;
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
        this(baseURL, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131070, null);
        t.i(baseURL, "baseURL");
    }

    @NotNull
    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.connectTimeout;
    }

    public final int component11() {
        return this.readTimeout;
    }

    public final int component12() {
        return this.writeTimeout;
    }

    public final int component13() {
        return this.callTimeout;
    }

    public final boolean component14() {
        return this.isProtobuf;
    }

    @NotNull
    public final OperationType component15() {
        return this.operationType;
    }

    @Nullable
    public final File component16() {
        return this.downloadDestination;
    }

    public final int component17() {
        return this.priority;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    @NotNull
    public final RequestType component3() {
        return this.method;
    }

    @Nullable
    public final Object component4() {
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
    public final BodyType component7() {
        return this.bodyType;
    }

    @NotNull
    public final String component8() {
        return this.scheme;
    }

    @Nullable
    public final Integer component9() {
        return this.port;
    }

    @NotNull
    public final HttpRequest copy(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13, boolean z10, @NotNull OperationType operationType, @Nullable File file, int i14) {
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
        t.i(operationType, "operationType");
        return new HttpRequest(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, i11, i12, i13, z10, operationType, file, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return t.d(this.baseURL, httpRequest.baseURL) && t.d(this.path, httpRequest.path) && this.method == httpRequest.method && t.d(this.body, httpRequest.body) && t.d(this.headers, httpRequest.headers) && t.d(this.parameters, httpRequest.parameters) && this.bodyType == httpRequest.bodyType && t.d(this.scheme, httpRequest.scheme) && t.d(this.port, httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout && this.isProtobuf == httpRequest.isProtobuf && this.operationType == httpRequest.operationType && t.d(this.downloadDestination, httpRequest.downloadDestination) && this.priority == httpRequest.priority;
    }

    @NotNull
    public final String getBaseURL() {
        return this.baseURL;
    }

    @Nullable
    public final Object getBody() {
        return this.body;
    }

    @NotNull
    public final BodyType getBodyType() {
        return this.bodyType;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    @Nullable
    public final File getDownloadDestination() {
        return this.downloadDestination;
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
    public final OperationType getOperationType() {
        return this.operationType;
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

    public final int getPriority() {
        return this.priority;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v31 */
    public int hashCode() {
        int iHashCode = ((((this.baseURL.hashCode() * 31) + this.path.hashCode()) * 31) + this.method.hashCode()) * 31;
        Object obj = this.body;
        int iHashCode2 = (((((((((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.bodyType.hashCode()) * 31) + this.scheme.hashCode()) * 31;
        Integer num = this.port;
        int iHashCode3 = (((((((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout) * 31;
        boolean z10 = this.isProtobuf;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int iHashCode4 = (((iHashCode3 + r12) * 31) + this.operationType.hashCode()) * 31;
        File file = this.downloadDestination;
        return ((iHashCode4 + (file != null ? file.hashCode() : 0)) * 31) + this.priority;
    }

    public final boolean isProtobuf() {
        return this.isProtobuf;
    }

    @NotNull
    public String toString() {
        return "HttpRequest(baseURL=" + this.baseURL + ", path=" + this.path + ", method=" + this.method + ", body=" + this.body + ", headers=" + this.headers + ", parameters=" + this.parameters + ", bodyType=" + this.bodyType + ", scheme=" + this.scheme + ", port=" + this.port + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", callTimeout=" + this.callTimeout + ", isProtobuf=" + this.isProtobuf + ", operationType=" + this.operationType + ", downloadDestination=" + this.downloadDestination + ", priority=" + this.priority + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path) {
        this(baseURL, path, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131068, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method) {
        this(baseURL, path, method, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131064, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj) {
        this(baseURL, path, method, obj, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131056, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers) {
        this(baseURL, path, method, obj, headers, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131040, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters) {
        this(baseURL, path, method, obj, headers, parameters, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131008, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, null, null, 0, 0, 0, 0, false, null, null, 0, 130944, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, null, 0, 0, 0, 0, false, null, null, 0, 130816, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, 0, 0, 0, 0, false, null, null, 0, 130560, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, 0, 0, 0, false, null, null, 0, 130048, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, i11, 0, 0, false, null, null, 0, 129024, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, i11, i12, 0, false, null, null, 0, 126976, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, i11, i12, i13, false, null, null, 0, 122880, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13, boolean z10) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, i11, i12, i13, z10, null, null, 0, 114688, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13, boolean z10, @NotNull OperationType operationType) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, i11, i12, i13, z10, operationType, null, 0, 98304, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
        t.i(operationType, "operationType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13, boolean z10, @NotNull OperationType operationType, @Nullable File file) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i10, i11, i12, i13, z10, operationType, file, 0, 65536, null);
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
        t.i(operationType, "operationType");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest(@NotNull String baseURL, @NotNull String path, @NotNull RequestType method, @Nullable Object obj, @NotNull Map<String, ? extends List<String>> headers, @NotNull Map<String, String> parameters, @NotNull BodyType bodyType, @NotNull String scheme, @Nullable Integer num, int i10, int i11, int i12, int i13, boolean z10, @NotNull OperationType operationType, @Nullable File file, int i14) {
        t.i(baseURL, "baseURL");
        t.i(path, "path");
        t.i(method, "method");
        t.i(headers, "headers");
        t.i(parameters, "parameters");
        t.i(bodyType, "bodyType");
        t.i(scheme, "scheme");
        t.i(operationType, "operationType");
        this.baseURL = baseURL;
        this.path = path;
        this.method = method;
        this.body = obj;
        this.headers = headers;
        this.parameters = parameters;
        this.bodyType = bodyType;
        this.scheme = scheme;
        this.port = num;
        this.connectTimeout = i10;
        this.readTimeout = i11;
        this.writeTimeout = i12;
        this.callTimeout = i13;
        this.isProtobuf = z10;
        this.operationType = operationType;
        this.downloadDestination = file;
        this.priority = i14;
    }

    public /* synthetic */ HttpRequest(String str, String str2, RequestType requestType, Object obj, Map map, Map map2, BodyType bodyType, String str3, Integer num, int i10, int i11, int i12, int i13, boolean z10, OperationType operationType, File file, int i14, int i15, k kVar) {
        this(str, (i15 & 2) != 0 ? "" : str2, (i15 & 4) != 0 ? RequestType.GET : requestType, (i15 & 8) != 0 ? null : obj, (i15 & 16) != 0 ? r0.g() : map, (i15 & 32) != 0 ? r0.g() : map2, (i15 & 64) != 0 ? BodyType.UNKNOWN : bodyType, (i15 & 128) != 0 ? "https" : str3, (i15 & 256) != 0 ? null : num, (i15 & 512) != 0 ? 30000 : i10, (i15 & 1024) != 0 ? 30000 : i11, (i15 & 2048) != 0 ? 30000 : i12, (i15 & 4096) == 0 ? i13 : 30000, (i15 & 8192) != 0 ? false : z10, (i15 & 16384) != 0 ? OperationType.UNKNOWN : operationType, (i15 & 32768) != 0 ? null : file, (i15 & 65536) == 0 ? i14 : 0);
    }
}
