package com.google.android.gms.ads.initialization;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface AdapterStatus {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public enum State {
        NOT_READY,
        READY
    }

    @NonNull
    String getDescription();

    @NonNull
    State getInitializationState();

    int getLatency();
}
