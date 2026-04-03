package io.sentry.util;

import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.sentry.p0;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: HttpUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f28359a = Arrays.asList("X-FORWARDED-FOR", "AUTHORIZATION", "COOKIE", "SET-COOKIE", "X-API-KEY", "X-REAL-IP", "REMOTE-ADDR", "FORWARDED", "PROXY-AUTHORIZATION", "X-CSRF-TOKEN", "X-CSRFTOKEN", "X-XSRF-TOKEN");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f28360b = Arrays.asList("JSESSIONID", "JSESSIONIDSSO", "JSSOSESSIONID", "SESSIONID", "SID", "CSRFTOKEN", "XSRF-TOKEN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final p0 f28361c = new p0(400, 499);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final p0 f28362d = new p0(500, CommonGatewayClient.CODE_599);

    public static boolean a(int i10) {
        return f28361c.a(i10);
    }

    public static boolean b(int i10) {
        return f28362d.a(i10);
    }
}
