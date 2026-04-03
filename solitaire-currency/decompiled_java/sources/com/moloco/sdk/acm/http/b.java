package com.moloco.sdk.acm.http;

import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static s7.a f17437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f17438c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f17436a = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final l f17439d = n.a(a.f17440g);

    public static final class a extends v implements h9.a<f> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f17440g = new a();

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f invoke() {
            s7.a aVar = b.f17437b;
            String str = null;
            if (aVar == null) {
                t.A("httpClient");
                aVar = null;
            }
            String str2 = b.f17438c;
            if (str2 == null) {
                t.A("apiUrl");
            } else {
                str = str2;
            }
            return new f(aVar, str);
        }
    }

    public final void b(@NotNull s7.a httpClient, @NotNull String apiUrl) {
        t.i(httpClient, "httpClient");
        t.i(apiUrl, "apiUrl");
        if (f17437b == null) {
            f17437b = httpClient;
            f17438c = apiUrl;
        }
    }

    @NotNull
    public final e d() {
        return (e) f17439d.getValue();
    }
}
