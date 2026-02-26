package com.moloco.sdk.acm;

import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public String f17427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final Map<String, String> f17429d;

    public h(@NotNull String appId, @NotNull String postAnalyticsUrl, long j10, @NotNull Map<String, String> clientOptions) {
        t.i(appId, "appId");
        t.i(postAnalyticsUrl, "postAnalyticsUrl");
        t.i(clientOptions, "clientOptions");
        this.f17426a = appId;
        this.f17427b = postAnalyticsUrl;
        this.f17428c = j10;
        this.f17429d = clientOptions;
    }

    public final void a(long j10) {
        this.f17428c = j10;
    }

    public final void b(@NotNull String str) {
        t.i(str, "<set-?>");
        this.f17427b = str;
    }

    @NotNull
    public final Map<String, String> c() {
        return this.f17429d;
    }

    @NotNull
    public final String d() {
        return this.f17427b;
    }

    public final long e() {
        return this.f17428c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return t.d(this.f17426a, hVar.f17426a) && t.d(this.f17427b, hVar.f17427b) && this.f17428c == hVar.f17428c && t.d(this.f17429d, hVar.f17429d);
    }

    public int hashCode() {
        return (((((this.f17426a.hashCode() * 31) + this.f17427b.hashCode()) * 31) + androidx.compose.animation.a.a(this.f17428c)) * 31) + this.f17429d.hashCode();
    }

    @NotNull
    public String toString() {
        return "ACMConfig(appId=" + this.f17426a + ", postAnalyticsUrl=" + this.f17427b + ", requestPeriodSeconds=" + this.f17428c + ", clientOptions=" + this.f17429d + ')';
    }
}
