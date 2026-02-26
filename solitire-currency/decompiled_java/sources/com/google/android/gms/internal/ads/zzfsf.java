package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsf {
    public static m zza(Task task, CancellationTokenSource cancellationTokenSource) {
        final zzfse zzfseVar = new zzfse(task, null);
        task.addOnCompleteListener(zzgda.zzb(), new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfsd
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                zzfse zzfseVar2 = zzfseVar;
                if (task2.isCanceled()) {
                    zzfseVar2.cancel(false);
                    return;
                }
                if (task2.isSuccessful()) {
                    zzfseVar2.zzc(task2.getResult());
                    return;
                }
                Exception exception = task2.getException();
                if (exception == null) {
                    throw new IllegalStateException();
                }
                zzfseVar2.zzd(exception);
            }
        });
        return zzfseVar;
    }
}
