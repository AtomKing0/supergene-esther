package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzx extends zza {
    private final TaskCompletionSource zza;

    zzx(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzl(Status status, String str) {
        if (status.isSuccess()) {
            this.zza.setResult(str);
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zza;
        int i10 = zzak.zze;
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
    }
}
