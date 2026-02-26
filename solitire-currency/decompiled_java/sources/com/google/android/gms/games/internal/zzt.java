package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzt extends zza {
    private final TaskCompletionSource zza;

    zzt(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzn(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode != 0) {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
            return;
        }
        SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
        try {
            SnapshotMetadataEntity snapshotMetadataEntity = snapshotMetadataBuffer.getCount() > 0 ? new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)) : null;
            snapshotMetadataBuffer.close();
            this.zza.setResult(snapshotMetadataEntity);
        } catch (Throwable th) {
            try {
                snapshotMetadataBuffer.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }
}
