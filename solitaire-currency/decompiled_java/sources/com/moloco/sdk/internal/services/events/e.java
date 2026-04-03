package com.moloco.sdk.internal.services.events;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f18671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f18672d;

    public e(boolean z10, boolean z11, @NotNull String appForegroundUrl, @NotNull String appBackgroundUrl) {
        t.i(appForegroundUrl, "appForegroundUrl");
        t.i(appBackgroundUrl, "appBackgroundUrl");
        this.f18669a = z10;
        this.f18670b = z11;
        this.f18671c = appForegroundUrl;
        this.f18672d = appBackgroundUrl;
    }

    @NotNull
    public final String a() {
        return this.f18672d;
    }

    @NotNull
    public final String b() {
        return this.f18671c;
    }

    public final boolean c() {
        return this.f18669a;
    }

    public final boolean d() {
        return this.f18670b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f18669a == eVar.f18669a && this.f18670b == eVar.f18670b && t.d(this.f18671c, eVar.f18671c) && t.d(this.f18672d, eVar.f18672d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean z10 = this.f18669a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.f18670b;
        return ((((i10 + (z11 ? 1 : z11)) * 31) + this.f18671c.hashCode()) * 31) + this.f18672d.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserEventConfig(eventReportingEnabled=" + this.f18669a + ", userTrackingEnabled=" + this.f18670b + ", appForegroundUrl=" + this.f18671c + ", appBackgroundUrl=" + this.f18672d + ')';
    }
}
