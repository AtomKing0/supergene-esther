package com.google.android.gms.internal.games_v2;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzv extends zzm {
    final /* synthetic */ TaskCompletionSource zza;

    zzv(zzw zzwVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.games_v2.zzm, com.google.android.gms.internal.games_v2.zzad
    public final void zzb(Status status, @Nullable zzaa zzaaVar) {
        if (zzaaVar == null) {
            this.zza.setException(new ApiException(status));
        } else {
            this.zza.setResult(zzaaVar);
        }
    }
}
