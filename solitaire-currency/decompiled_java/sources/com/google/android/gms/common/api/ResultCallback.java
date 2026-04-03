package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface ResultCallback<R extends Result> {
    void onResult(@NonNull R r10);
}
