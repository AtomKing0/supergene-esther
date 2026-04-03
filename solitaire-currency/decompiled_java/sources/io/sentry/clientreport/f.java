package io.sentry.clientreport;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DiscardReason.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public enum f {
    QUEUE_OVERFLOW("queue_overflow"),
    CACHE_OVERFLOW("cache_overflow"),
    RATELIMIT_BACKOFF("ratelimit_backoff"),
    NETWORK_ERROR("network_error"),
    SAMPLE_RATE("sample_rate"),
    BEFORE_SEND("before_send"),
    EVENT_PROCESSOR("event_processor"),
    BACKPRESSURE("backpressure");

    private final String reason;

    f(String str) {
        this.reason = str;
    }

    public String getReason() {
        return this.reason;
    }
}
