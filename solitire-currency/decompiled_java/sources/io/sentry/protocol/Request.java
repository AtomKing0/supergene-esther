package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Request implements h2 {

    @Nullable
    private String apiTarget;

    @Nullable
    private Long bodySize;

    @Nullable
    private String cookies;

    @Nullable
    private Object data;

    @Nullable
    private Map<String, String> env;

    @Nullable
    private String fragment;

    @Nullable
    private Map<String, String> headers;

    @Nullable
    private String method;

    @Nullable
    private Map<String, String> other;

    @Nullable
    private String queryString;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String url;

    public static final class Deserializer implements x1<Request> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Request deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Request request = new Request();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "fragment":
                        request.fragment = l3Var.o0();
                        break;
                    case "method":
                        request.method = l3Var.o0();
                        break;
                    case "env":
                        Map map = (Map) l3Var.A0();
                        if (map == null) {
                            break;
                        } else {
                            request.env = io.sentry.util.c.b(map);
                            break;
                        }
                        break;
                    case "url":
                        request.url = l3Var.o0();
                        break;
                    case "data":
                        request.data = l3Var.A0();
                        break;
                    case "other":
                        Map map2 = (Map) l3Var.A0();
                        if (map2 == null) {
                            break;
                        } else {
                            request.other = io.sentry.util.c.b(map2);
                            break;
                        }
                        break;
                    case "headers":
                        Map map3 = (Map) l3Var.A0();
                        if (map3 == null) {
                            break;
                        } else {
                            request.headers = io.sentry.util.c.b(map3);
                            break;
                        }
                        break;
                    case "cookies":
                        request.cookies = l3Var.o0();
                        break;
                    case "body_size":
                        request.bodySize = l3Var.j0();
                        break;
                    case "query_string":
                        request.queryString = l3Var.o0();
                        break;
                    case "api_target":
                        request.apiTarget = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            request.setUnknown(concurrentHashMap);
            l3Var.k();
            return request;
        }
    }

    public static final class JsonKeys {
        public static final String API_TARGET = "api_target";
        public static final String BODY_SIZE = "body_size";
        public static final String COOKIES = "cookies";
        public static final String DATA = "data";
        public static final String ENV = "env";
        public static final String FRAGMENT = "fragment";
        public static final String HEADERS = "headers";
        public static final String METHOD = "method";
        public static final String OTHER = "other";
        public static final String QUERY_STRING = "query_string";
        public static final String URL = "url";
    }

    public Request() {
    }

    public Request(@NotNull Request request) {
        this.url = request.url;
        this.cookies = request.cookies;
        this.method = request.method;
        this.queryString = request.queryString;
        this.headers = io.sentry.util.c.b(request.headers);
        this.env = io.sentry.util.c.b(request.env);
        this.other = io.sentry.util.c.b(request.other);
        this.unknown = io.sentry.util.c.b(request.unknown);
        this.data = request.data;
        this.fragment = request.fragment;
        this.bodySize = request.bodySize;
        this.apiTarget = request.apiTarget;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Request.class != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        return w.a(this.url, request.url) && w.a(this.method, request.method) && w.a(this.queryString, request.queryString) && w.a(this.cookies, request.cookies) && w.a(this.headers, request.headers) && w.a(this.env, request.env) && w.a(this.bodySize, request.bodySize) && w.a(this.fragment, request.fragment) && w.a(this.apiTarget, request.apiTarget);
    }

    @Nullable
    public String getApiTarget() {
        return this.apiTarget;
    }

    @Nullable
    public Long getBodySize() {
        return this.bodySize;
    }

    @Nullable
    public String getCookies() {
        return this.cookies;
    }

    @Nullable
    public Object getData() {
        return this.data;
    }

    @Nullable
    public Map<String, String> getEnvs() {
        return this.env;
    }

    @Nullable
    public String getFragment() {
        return this.fragment;
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public String getMethod() {
        return this.method;
    }

    @Nullable
    public Map<String, String> getOthers() {
        return this.other;
    }

    @Nullable
    public String getQueryString() {
        return this.queryString;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return w.b(this.url, this.method, this.queryString, this.cookies, this.headers, this.env, this.bodySize, this.fragment, this.apiTarget);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.url != null) {
            m3Var.e("url").g(this.url);
        }
        if (this.method != null) {
            m3Var.e("method").g(this.method);
        }
        if (this.queryString != null) {
            m3Var.e(JsonKeys.QUERY_STRING).g(this.queryString);
        }
        if (this.data != null) {
            m3Var.e("data").o(w0Var, this.data);
        }
        if (this.cookies != null) {
            m3Var.e("cookies").g(this.cookies);
        }
        if (this.headers != null) {
            m3Var.e("headers").o(w0Var, this.headers);
        }
        if (this.env != null) {
            m3Var.e("env").o(w0Var, this.env);
        }
        if (this.other != null) {
            m3Var.e(JsonKeys.OTHER).o(w0Var, this.other);
        }
        if (this.fragment != null) {
            m3Var.e(JsonKeys.FRAGMENT).o(w0Var, this.fragment);
        }
        if (this.bodySize != null) {
            m3Var.e("body_size").o(w0Var, this.bodySize);
        }
        if (this.apiTarget != null) {
            m3Var.e(JsonKeys.API_TARGET).o(w0Var, this.apiTarget);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void setApiTarget(@Nullable String str) {
        this.apiTarget = str;
    }

    public void setBodySize(@Nullable Long l10) {
        this.bodySize = l10;
    }

    public void setCookies(@Nullable String str) {
        this.cookies = str;
    }

    public void setData(@Nullable Object obj) {
        this.data = obj;
    }

    public void setEnvs(@Nullable Map<String, String> map) {
        this.env = io.sentry.util.c.b(map);
    }

    public void setFragment(@Nullable String str) {
        this.fragment = str;
    }

    public void setHeaders(@Nullable Map<String, String> map) {
        this.headers = io.sentry.util.c.b(map);
    }

    public void setMethod(@Nullable String str) {
        this.method = str;
    }

    public void setOthers(@Nullable Map<String, String> map) {
        this.other = io.sentry.util.c.b(map);
    }

    public void setQueryString(@Nullable String str) {
        this.queryString = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUrl(@Nullable String str) {
        this.url = str;
    }
}
