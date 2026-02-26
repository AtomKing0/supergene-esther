package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzv extends zza {
    private final TaskCompletionSource zza;

    zzv(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzd(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z10 = statusCode == 3;
        if (statusCode == 0 || z10) {
            this.zza.setResult(new AnnotatedData(new EventBuffer(dataHolder), z10));
        } else {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
        }
    }
}
