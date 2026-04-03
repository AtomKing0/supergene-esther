package com.google.android.gms.common.data;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface Freezable<T> {
    @NonNull
    T freeze();

    boolean isDataValid();
}
