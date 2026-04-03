package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzr extends zza {
    private final TaskCompletionSource zza;

    zzr(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzb(int i10, String str) {
        if (i10 == 0 || i10 == 3003) {
            this.zza.setResult(null);
        } else {
            GamesStatusUtils.zza(this.zza, i10);
        }
    }
}
