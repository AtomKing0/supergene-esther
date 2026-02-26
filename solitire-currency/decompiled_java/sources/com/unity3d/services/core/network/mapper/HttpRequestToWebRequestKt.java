package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.request.WebRequest;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpRequestToWebRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpRequestToWebRequestKt {
    @NotNull
    public static final WebRequest toWebRequest(@NotNull HttpRequest httpRequest) {
        t.i(httpRequest, "<this>");
        WebRequest webRequest = new WebRequest(httpRequest.getBaseURL(), httpRequest.getMethod().toString(), httpRequest.getHeaders(), httpRequest.getConnectTimeout(), httpRequest.getReadTimeout());
        Object body = httpRequest.getBody();
        if (body instanceof String) {
            webRequest.setBody((String) httpRequest.getBody());
        } else if (body instanceof byte[]) {
            webRequest.setBody((byte[]) httpRequest.getBody());
        }
        return webRequest;
    }
}
