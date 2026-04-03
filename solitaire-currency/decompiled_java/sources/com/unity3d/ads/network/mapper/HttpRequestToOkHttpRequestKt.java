package com.unity3d.ads.network.mapper;

import com.unity3d.ads.network.model.HttpBody;
import com.unity3d.ads.network.model.HttpRequest;
import com.unity3d.services.UnityAdsConstants;
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
import v8.q;

/* JADX INFO: compiled from: HttpRequestToOkHttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpRequestToOkHttpRequestKt {
    private static final c0 generateOkHttpBody(HttpBody httpBody) {
        if (httpBody instanceof HttpBody.StringBody) {
            return c0.create(x.g("text/plain;charset=utf-8"), ((HttpBody.StringBody) httpBody).getContent());
        }
        if (httpBody instanceof HttpBody.ByteArrayBody) {
            return c0.create(x.g("text/plain;charset=utf-8"), ((HttpBody.ByteArrayBody) httpBody).getContent());
        }
        if (httpBody instanceof HttpBody.EmptyBody) {
            return null;
        }
        throw new q();
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

    @NotNull
    public static final b0 toOkHttpRequest(@NotNull HttpRequest httpRequest) {
        t.i(httpRequest, "<this>");
        b0 b0VarB = new b0.a().s(r.w0(r.c1(httpRequest.getBaseURL(), '/') + '/' + r.c1(httpRequest.getPath(), '/'), UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)).i(httpRequest.getMethod().toString(), generateOkHttpBody(httpRequest.getBody())).h(generateOkHttpHeaders(httpRequest)).b();
        t.h(b0VarB, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return b0VarB;
    }
}
