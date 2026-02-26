package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class CallbackExecutor {
    private CallbackExecutor() {
    }

    @NonNull
    @KeepForSdk
    public static ExecutorService executorService() {
        return zzj.zza;
    }
}
