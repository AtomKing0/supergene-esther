package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.request.WebRequest;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WebRequestToHttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WebRequestToHttpRequestKt {
    @NotNull
    public static final HttpRequest toHttpRequest(@NotNull WebRequest webRequest) {
        t.i(webRequest, "<this>");
        String string = webRequest.getUrl().toString();
        String requestType = webRequest.getRequestType();
        t.h(requestType, "requestType");
        RequestType requestTypeValueOf = RequestType.valueOf(requestType);
        Map<String, List<String>> headers = webRequest.getHeaders();
        byte[] body = webRequest.getBody();
        t.h(string, "toString()");
        t.h(headers, "headers");
        return new HttpRequest(string, null, requestTypeValueOf, body, headers, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131042, null);
    }
}
