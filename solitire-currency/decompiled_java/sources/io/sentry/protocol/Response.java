package io.sentry.protocol;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Response implements h2 {
    public static final String TYPE = "response";

    @Nullable
    private Long bodySize;

    @Nullable
    private String cookies;

    @Nullable
    private Object data;

    @Nullable
    private Map<String, String> headers;

    @Nullable
    private Integer statusCode;

    @Nullable
    private Map<String, Object> unknown;

    public static final class Deserializer implements x1<Response> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Response deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            Response response = new Response();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "status_code":
                        response.statusCode = l3Var.g0();
                        break;
                    case "data":
                        response.data = l3Var.A0();
                        break;
                    case "headers":
                        Map map = (Map) l3Var.A0();
                        if (map == null) {
                            break;
                        } else {
                            response.headers = io.sentry.util.c.b(map);
                            break;
                        }
                        break;
                    case "cookies":
                        response.cookies = l3Var.o0();
                        break;
                    case "body_size":
                        response.bodySize = l3Var.j0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            response.setUnknown(concurrentHashMap);
            l3Var.k();
            return response;
        }
    }

    public static final class JsonKeys {
        public static final String BODY_SIZE = "body_size";
        public static final String COOKIES = "cookies";
        public static final String DATA = "data";
        public static final String HEADERS = "headers";
        public static final String STATUS_CODE = "status_code";
    }

    public Response() {
    }

    public Response(@NotNull Response response) {
        this.cookies = response.cookies;
        this.headers = io.sentry.util.c.b(response.headers);
        this.unknown = io.sentry.util.c.b(response.unknown);
        this.statusCode = response.statusCode;
        this.bodySize = response.bodySize;
        this.data = response.data;
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
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public Integer getStatusCode() {
        return this.statusCode;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.cookies != null) {
            m3Var.e("cookies").g(this.cookies);
        }
        if (this.headers != null) {
            m3Var.e("headers").o(w0Var, this.headers);
        }
        if (this.statusCode != null) {
            m3Var.e(JsonKeys.STATUS_CODE).o(w0Var, this.statusCode);
        }
        if (this.bodySize != null) {
            m3Var.e("body_size").o(w0Var, this.bodySize);
        }
        if (this.data != null) {
            m3Var.e("data").o(w0Var, this.data);
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

    public void setBodySize(@Nullable Long l10) {
        this.bodySize = l10;
    }

    public void setCookies(@Nullable String str) {
        this.cookies = str;
    }

    public void setData(@Nullable Object obj) {
        this.data = obj;
    }

    public void setHeaders(@Nullable Map<String, String> map) {
        this.headers = io.sentry.util.c.b(map);
    }

    public void setStatusCode(@Nullable Integer num) {
        this.statusCode = num;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }
}
