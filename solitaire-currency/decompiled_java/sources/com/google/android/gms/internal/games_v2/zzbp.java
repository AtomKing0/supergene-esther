package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.app.Application;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbp implements zzbm {
    private final Application zza;
    private final com.google.android.gms.games.internal.zzg zzb;
    private final zzaw zzc;

    zzbp(Application application, com.google.android.gms.games.internal.zzg zzgVar, zzaw zzawVar, byte[] bArr) {
        this.zza = application;
        this.zzb = zzgVar;
        this.zzc = zzawVar;
    }

    private final zzs zzc() {
        Activity activityZza = this.zzb.zza();
        if (activityZza != null) {
            return zzr.zza(activityZza, this.zzc.zzb);
        }
        zzaw zzawVar = this.zzc;
        return zzr.zza(zzawVar.zza, zzawVar.zzb);
    }

    @Override // com.google.android.gms.internal.games_v2.zzbm
    public final Task zza(final zzy zzyVar) {
        final boolean z10 = false;
        if (zzyVar.zza() == 0 && !InstantApps.isInstantApp(this.zza)) {
            z10 = true;
        }
        Task taskZza = zzc().zza(zzyVar, z10);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskZza.continueWithTask(zzfe.zza(), new Continuation() { // from class: com.google.android.gms.internal.games_v2.zzbn
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzb(zzyVar, z10, task);
            }
        }).addOnCompleteListener(zzfe.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbo
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (task.isSuccessful()) {
                    taskCompletionSource2.trySetResult(zzbq.zzc(((zzaa) task.getResult()).zza()));
                    return;
                }
                Exception exception = task.getException();
                if (exception instanceof ApiException) {
                    taskCompletionSource2.trySetResult(zzbq.zzb(((ApiException) exception).getStatus()));
                } else {
                    zzfb.zza(exception);
                    taskCompletionSource2.trySetException(exception);
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ Task zzb(zzy zzyVar, boolean z10, Task task) throws Exception {
        if (task.isSuccessful()) {
            return task;
        }
        Exception exception = task.getException();
        if (!(exception instanceof ApiException) || ((ApiException) exception).getStatusCode() != 20) {
            return task;
        }
        zzez.zza("GamesAuthenticator", "Service connection suspended during the first sign-in attempt. Trying again.");
        return zzc().zza(zzyVar, z10);
    }
}
