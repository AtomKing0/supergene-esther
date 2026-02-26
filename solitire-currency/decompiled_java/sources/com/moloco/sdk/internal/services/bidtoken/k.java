package com.moloco.sdk.internal.services.bidtoken;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18465c;

    public k(long j10, int i10, long j11) {
        this.f18463a = j10;
        this.f18464b = i10;
        this.f18465c = j11;
    }

    public final long a() {
        return this.f18465c;
    }

    public final int b() {
        return this.f18464b;
    }

    public final long c() {
        return this.f18463a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f18463a == kVar.f18463a && this.f18464b == kVar.f18464b && this.f18465c == kVar.f18465c;
    }

    public int hashCode() {
        return (((androidx.compose.animation.a.a(this.f18463a) * 31) + this.f18464b) * 31) + androidx.compose.animation.a.a(this.f18465c);
    }

    @NotNull
    public String toString() {
        return "BidTokenHttpRequestInfo(requestTimeoutMillis=" + this.f18463a + ", fetchRetryMax=" + this.f18464b + ", fetchRetryDelayMillis=" + this.f18465c + ')';
    }
}
