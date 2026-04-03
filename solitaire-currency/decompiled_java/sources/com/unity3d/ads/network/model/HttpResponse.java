package com.unity3d.ads.network.model;

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
    private final Map<String, Object> headers;
    private final int statusCode;

    @NotNull
    private final String urlString;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body) {
        this(body, 0, null, null, 14, null);
        t.i(body, "body");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResponse copy$default(HttpResponse httpResponse, Object obj, int i10, Map map, String str, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = httpResponse.body;
        }
        if ((i11 & 2) != 0) {
            i10 = httpResponse.statusCode;
        }
        if ((i11 & 4) != 0) {
            map = httpResponse.headers;
        }
        if ((i11 & 8) != 0) {
            str = httpResponse.urlString;
        }
        return httpResponse.copy(obj, i10, map, str);
    }

    @NotNull
    public final Object component1() {
        return this.body;
    }

    public final int component2() {
        return this.statusCode;
    }

    @NotNull
    public final Map<String, Object> component3() {
        return this.headers;
    }

    @NotNull
    public final String component4() {
        return this.urlString;
    }

    @NotNull
    public final HttpResponse copy(@NotNull Object body, int i10, @NotNull Map<String, ? extends Object> headers, @NotNull String urlString) {
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(urlString, "urlString");
        return new HttpResponse(body, i10, headers, urlString);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return t.d(this.body, httpResponse.body) && this.statusCode == httpResponse.statusCode && t.d(this.headers, httpResponse.headers) && t.d(this.urlString, httpResponse.urlString);
    }

    @NotNull
    public final Object getBody() {
        return this.body;
    }

    @NotNull
    public final Map<String, Object> getHeaders() {
        return this.headers;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    @NotNull
    public final String getUrlString() {
        return this.urlString;
    }

    public int hashCode() {
        return (((((this.body.hashCode() * 31) + this.statusCode) * 31) + this.headers.hashCode()) * 31) + this.urlString.hashCode();
    }

    @NotNull
    public String toString() {
        return "HttpResponse(body=" + this.body + ", statusCode=" + this.statusCode + ", headers=" + this.headers + ", urlString=" + this.urlString + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body, int i10) {
        this(body, i10, null, null, 12, null);
        t.i(body, "body");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(@NotNull Object body, int i10, @NotNull Map<String, ? extends Object> headers) {
        this(body, i10, headers, null, 8, null);
        t.i(body, "body");
        t.i(headers, "headers");
    }

    public HttpResponse(@NotNull Object body, int i10, @NotNull Map<String, ? extends Object> headers, @NotNull String urlString) {
        t.i(body, "body");
        t.i(headers, "headers");
        t.i(urlString, "urlString");
        this.body = body;
        this.statusCode = i10;
        this.headers = headers;
        this.urlString = urlString;
    }

    public /* synthetic */ HttpResponse(Object obj, int i10, Map map, String str, int i11, k kVar) {
        this(obj, (i11 & 2) != 0 ? 200 : i10, (i11 & 4) != 0 ? r0.g() : map, (i11 & 8) != 0 ? "" : str);
    }
}
