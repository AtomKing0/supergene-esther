package com.moloco.sdk.internal.configs;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17596b;

    public a(@NotNull String reportingUrl, int i10) {
        t.i(reportingUrl, "reportingUrl");
        this.f17595a = reportingUrl;
        this.f17596b = i10;
    }

    public final int a() {
        return this.f17596b;
    }

    @NotNull
    public final String b() {
        return this.f17595a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.d(this.f17595a, aVar.f17595a) && this.f17596b == aVar.f17596b;
    }

    public int hashCode() {
        return (this.f17595a.hashCode() * 31) + this.f17596b;
    }

    @NotNull
    public String toString() {
        return "OperationalMetricsConfig(reportingUrl=" + this.f17595a + ", pollingIntervalSeconds=" + this.f17596b + ')';
    }
}
