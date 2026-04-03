package com.google.android.gms.games;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class GamesStatusUtils {
    private GamesStatusUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zza(@androidx.annotation.NonNull com.google.android.gms.tasks.TaskCompletionSource r4, int r5) {
        /*
            Method dump skipped, instruction units count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.GamesStatusUtils.zza(com.google.android.gms.tasks.TaskCompletionSource, int):void");
    }

    public static void zzb(@Nullable TaskCompletionSource taskCompletionSource, @NonNull SecurityException securityException) {
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(new ApiException(GamesClientStatusCodes.zza(4)));
        }
    }
}
