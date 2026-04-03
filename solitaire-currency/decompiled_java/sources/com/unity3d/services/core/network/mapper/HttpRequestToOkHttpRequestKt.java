package com.unity3d.services.core.network.mapper;

import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.network.model.HttpRequest;
import ga.b0;
import ga.c0;
import ga.u;
import ga.x;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: compiled from: HttpRequestToOkHttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpRequestToOkHttpRequestKt {
    private static final c0 generateOkHttpBody(Object obj) {
        if (obj instanceof byte[]) {
            c0 c0VarCreate = c0.create(x.g("text/plain;charset=utf-8"), (byte[]) obj);
            t.h(c0VarCreate, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return c0VarCreate;
        }
        if (obj instanceof String) {
            c0 c0VarCreate2 = c0.create(x.g("text/plain;charset=utf-8"), (String) obj);
            t.h(c0VarCreate2, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return c0VarCreate2;
        }
        c0 c0VarCreate3 = c0.create(x.g("text/plain;charset=utf-8"), "");
        t.h(c0VarCreate3, "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")");
        return c0VarCreate3;
    }

    private static final u generateOkHttpHeaders(HttpRequest httpRequest) {
        u.a aVar = new u.a();
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            aVar.a(entry.getKey(), d0.r0(entry.getValue(), ",", null, null, 0, null, null, 62, null));
        }
        u uVarF = aVar.f();
        t.h(uVarF, "Builder()\n    .also { he…ng(\",\")) } }\n    .build()");
        return uVarF;
    }

    private static final c0 generateOkHttpProtobufBody(Object obj) {
        if (obj instanceof byte[]) {
            c0 c0VarCreate = c0.create(x.g("application/x-protobuf"), (byte[]) obj);
            t.h(c0VarCreate, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return c0VarCreate;
        }
        if (obj instanceof String) {
            c0 c0VarCreate2 = c0.create(x.g("application/x-protobuf"), (String) obj);
            t.h(c0VarCreate2, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return c0VarCreate2;
        }
        c0 c0VarCreate3 = c0.create(x.g("application/x-protobuf"), "");
        t.h(c0VarCreate3, "create(MediaType.parse(\"…ication/x-protobuf\"), \"\")");
        return c0VarCreate3;
    }

    @NotNull
    public static final b0 toOkHttpProtoRequest(@NotNull HttpRequest httpRequest) {
        t.i(httpRequest, "<this>");
        b0.a aVarS = new b0.a().s(r.w0(r.c1(httpRequest.getBaseURL(), '/') + '/' + r.c1(httpRequest.getPath(), '/'), UnityAdsConstants.DefaultUrls.AD_ASSET_PATH));
        String string = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        b0 b0VarB = aVarS.i(string, body != null ? generateOkHttpProtobufBody(body) : null).h(generateOkHttpHeaders(httpRequest)).b();
        t.h(b0VarB, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return b0VarB;
    }

    @NotNull
    public static final b0 toOkHttpRequest(@NotNull HttpRequest httpRequest) {
        t.i(httpRequest, "<this>");
        b0.a aVarS = new b0.a().s(r.w0(r.c1(httpRequest.getBaseURL(), '/') + '/' + r.c1(httpRequest.getPath(), '/'), UnityAdsConstants.DefaultUrls.AD_ASSET_PATH));
        String string = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        b0 b0VarB = aVarS.i(string, body != null ? generateOkHttpBody(body) : null).h(generateOkHttpHeaders(httpRequest)).b();
        t.h(b0VarB, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return b0VarB;
    }
}
