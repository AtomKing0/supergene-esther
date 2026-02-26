package com.moloco.sdk.acm;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f17355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f17356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Context f17357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f17358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f17359e;

    public e(@NotNull String appId, @NotNull String postAnalyticsUrl, @NotNull Context context, long j10, @NotNull Map<String, String> clientOptions) {
        t.i(appId, "appId");
        t.i(postAnalyticsUrl, "postAnalyticsUrl");
        t.i(context, "context");
        t.i(clientOptions, "clientOptions");
        this.f17355a = appId;
        this.f17356b = postAnalyticsUrl;
        this.f17357c = context;
        this.f17358d = j10;
        this.f17359e = clientOptions;
    }

    @NotNull
    public final String a() {
        return this.f17355a;
    }

    @NotNull
    public final Map<String, String> b() {
        return this.f17359e;
    }

    @NotNull
    public final Context c() {
        return this.f17357c;
    }

    @NotNull
    public final String d() {
        return this.f17356b;
    }

    public final long e() {
        return this.f17358d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return t.d(this.f17355a, eVar.f17355a) && t.d(this.f17356b, eVar.f17356b) && t.d(this.f17357c, eVar.f17357c) && this.f17358d == eVar.f17358d && t.d(this.f17359e, eVar.f17359e);
    }

    public int hashCode() {
        return (((((((this.f17355a.hashCode() * 31) + this.f17356b.hashCode()) * 31) + this.f17357c.hashCode()) * 31) + androidx.compose.animation.a.a(this.f17358d)) * 31) + this.f17359e.hashCode();
    }

    @NotNull
    public String toString() {
        return "InitConfig(appId=" + this.f17355a + ", postAnalyticsUrl=" + this.f17356b + ", context=" + this.f17357c + ", requestPeriodSeconds=" + this.f17358d + ", clientOptions=" + this.f17359e + ')';
    }
}
