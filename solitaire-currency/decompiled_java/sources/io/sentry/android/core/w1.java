package io.sentry.android.core;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: NdkHandlerStrategy.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public enum w1 {
    SENTRY_HANDLER_STRATEGY_DEFAULT(0),
    SENTRY_HANDLER_STRATEGY_CHAIN_AT_START(1);

    private final int value;

    w1(int i10) {
        this.value = i10;
    }

    public int getValue() {
        return this.value;
    }
}
