package com.unity3d.services.core.network.model;

import androidx.compose.animation.a;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpResponse {

    @NotNull
    private final Object body;

    @NotNull
    private final String client;
    private final long contentSize;

    @NotNull
    private final Map<String, List<String>> headers;

    @NotNull
    private final String protocol;
    private final int statusCode;

    @NotNull
    private final String urlString;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body) {
        this(body, 0, null, null, null, null, 0L, 126, null);
        t.i(body, "body");
    }

    @NotNull
    public final Object component1() {
        return this.body;
    }

    public final int component2() {
        return this.statusCode;
    }

    @NotNull
    public final Map<String, List<String>> component3() {
        return this.headers;
    }

    @NotNull
    public final String component4() {
        return this.urlString;
    }

    @NotNull
    public final String component5() {
        return this.protocol;
    }

    @NotNull
    public final String component6() {
        return this.client;
    }

    public final long component7() {
        return this.contentSize;
    }

    @NotNull
    public final HttpResponse copy(@NotNull Object body, int i10, @NotNull Map<String, ? extends List<String>> headers, @NotNull String urlString, @NotNull String protocol, @NotNull String client, long j10) {
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(urlString, "urlString");
        t.i(protocol, "protocol");
        t.i(client, "client");
        return new HttpResponse(body, i10, headers, urlString, protocol, client, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return t.d(this.body, httpResponse.body) && this.statusCode == httpResponse.statusCode && t.d(this.headers, httpResponse.headers) && t.d(this.urlString, httpResponse.urlString) && t.d(this.protocol, httpResponse.protocol) && t.d(this.client, httpResponse.client) && this.contentSize == httpResponse.contentSize;
    }

    @NotNull
    public final Object getBody() {
        return this.body;
    }

    @NotNull
    public final String getClient() {
        return this.client;
    }

    public final long getContentSize() {
        return this.contentSize;
    }

    @NotNull
    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final String getProtocol() {
        return this.protocol;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    @NotNull
    public final String getUrlString() {
        return this.urlString;
    }

    public int hashCode() {
        return (((((((((((this.body.hashCode() * 31) + this.statusCode) * 31) + this.headers.hashCode()) * 31) + this.urlString.hashCode()) * 31) + this.protocol.hashCode()) * 31) + this.client.hashCode()) * 31) + a.a(this.contentSize);
    }

    @NotNull
    public String toString() {
        return "HttpResponse(body=" + this.body + ", statusCode=" + this.statusCode + ", headers=" + this.headers + ", urlString=" + this.urlString + ", protocol=" + this.protocol + ", client=" + this.client + ", contentSize=" + this.contentSize + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body, int i10) {
        this(body, i10, null, null, null, null, 0L, 124, null);
        t.i(body, "body");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body, int i10, @NotNull Map<String, ? extends List<String>> headers) {
        this(body, i10, headers, null, null, null, 0L, 120, null);
        t.i(body, "body");
        t.i(headers, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body, int i10, @NotNull Map<String, ? extends List<String>> headers, @NotNull String urlString) {
        this(body, i10, headers, urlString, null, null, 0L, 112, null);
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(urlString, "urlString");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body, int i10, @NotNull Map<String, ? extends List<String>> headers, @NotNull String urlString, @NotNull String protocol) {
        this(body, i10, headers, urlString, protocol, null, 0L, 96, null);
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(urlString, "urlString");
        t.i(protocol, "protocol");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body, int i10, @NotNull Map<String, ? extends List<String>> headers, @NotNull String urlString, @NotNull String protocol, @NotNull String client) {
        this(body, i10, headers, urlString, protocol, client, 0L, 64, null);
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(urlString, "urlString");
        t.i(protocol, "protocol");
        t.i(client, "client");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpResponse(@NotNull Object body, int i10, @NotNull Map<String, ? extends List<String>> headers, @NotNull String urlString, @NotNull String protocol, @NotNull String client, long j10) {
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(urlString, "urlString");
        t.i(protocol, "protocol");
        t.i(client, "client");
        this.body = body;
        this.statusCode = i10;
        this.headers = headers;
        this.urlString = urlString;
        this.protocol = protocol;
        this.client = client;
        this.contentSize = j10;
    }

    public /* synthetic */ HttpResponse(Object obj, int i10, Map map, String str, String str2, String str3, long j10, int i11, k kVar) {
        this(obj, (i11 & 2) != 0 ? 200 : i10, (i11 & 4) != 0 ? r0.g() : map, (i11 & 8) != 0 ? "" : str, (i11 & 16) == 0 ? str2 : "", (i11 & 32) != 0 ? "unknown" : str3, (i11 & 64) != 0 ? -1L : j10);
    }
}
