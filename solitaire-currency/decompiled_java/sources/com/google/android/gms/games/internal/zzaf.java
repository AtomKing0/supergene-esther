package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaf extends zza {
    private final TaskCompletionSource zza;

    zzaf(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzj(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode != 0 && statusCode != 3) {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
        } else {
            PlayerBuffer playerBuffer = new PlayerBuffer(dataHolder);
            try {
                this.zza.setResult(new AnnotatedData(playerBuffer.getCount() > 0 ? new PlayerEntity(playerBuffer.get(0)) : null, statusCode == 3));
            } finally {
                playerBuffer.release();
            }
        }
    }
}
