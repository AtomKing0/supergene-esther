package com.unity3d.ads.gatewayclient;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RequestPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RequestPolicy {
    private final int connectTimeout;
    private final int maxDuration;
    private final int readTimeout;
    private final float retryJitterPct;
    private final int retryMaxInterval;
    private final int retryWaitBase;
    private final boolean shouldStoreLocally;
    private final int writeTimeout;

    public RequestPolicy(int i10, int i11, int i12, float f10, int i13, int i14, int i15, boolean z10) {
        this.maxDuration = i10;
        this.retryMaxInterval = i11;
        this.retryWaitBase = i12;
        this.retryJitterPct = f10;
        this.connectTimeout = i13;
        this.readTimeout = i14;
        this.writeTimeout = i15;
        this.shouldStoreLocally = z10;
    }

    public final int component1() {
        return this.maxDuration;
    }

    public final int component2() {
        return this.retryMaxInterval;
    }

    public final int component3() {
        return this.retryWaitBase;
    }

    public final float component4() {
        return this.retryJitterPct;
    }

    public final int component5() {
        return this.connectTimeout;
    }

    public final int component6() {
        return this.readTimeout;
    }

    public final int component7() {
        return this.writeTimeout;
    }

    public final boolean component8() {
        return this.shouldStoreLocally;
    }

    @NotNull
    public final RequestPolicy copy(int i10, int i11, int i12, float f10, int i13, int i14, int i15, boolean z10) {
        return new RequestPolicy(i10, i11, i12, f10, i13, i14, i15, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestPolicy)) {
            return false;
        }
        RequestPolicy requestPolicy = (RequestPolicy) obj;
        return this.maxDuration == requestPolicy.maxDuration && this.retryMaxInterval == requestPolicy.retryMaxInterval && this.retryWaitBase == requestPolicy.retryWaitBase && Float.compare(this.retryJitterPct, requestPolicy.retryJitterPct) == 0 && this.connectTimeout == requestPolicy.connectTimeout && this.readTimeout == requestPolicy.readTimeout && this.writeTimeout == requestPolicy.writeTimeout && this.shouldStoreLocally == requestPolicy.shouldStoreLocally;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final int getMaxDuration() {
        return this.maxDuration;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final float getRetryJitterPct() {
        return this.retryJitterPct;
    }

    public final int getRetryMaxInterval() {
        return this.retryMaxInterval;
    }

    public final int getRetryWaitBase() {
        return this.retryWaitBase;
    }

    public final boolean getShouldStoreLocally() {
        return this.shouldStoreLocally;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iFloatToIntBits = ((((((((((((this.maxDuration * 31) + this.retryMaxInterval) * 31) + this.retryWaitBase) * 31) + Float.floatToIntBits(this.retryJitterPct)) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31;
        boolean z10 = this.shouldStoreLocally;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return iFloatToIntBits + r12;
    }

    @NotNull
    public String toString() {
        return "RequestPolicy(maxDuration=" + this.maxDuration + ", retryMaxInterval=" + this.retryMaxInterval + ", retryWaitBase=" + this.retryWaitBase + ", retryJitterPct=" + this.retryJitterPct + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", shouldStoreLocally=" + this.shouldStoreLocally + ')';
    }
}
