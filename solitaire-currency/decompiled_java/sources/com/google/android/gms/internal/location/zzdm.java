package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdm extends zzn {
    final /* synthetic */ TaskCompletionSource zza;

    zzdm(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzb(Status status, boolean z10) {
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z10), this.zza);
    }
}
