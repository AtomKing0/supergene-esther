package com.google.android.play.core.review.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:review@@2.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzj implements Runnable {

    @Nullable
    private final TaskCompletionSource zza;

    zzj() {
        this.zza = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zza();
        } catch (Exception e10) {
            zzc(e10);
        }
    }

    protected abstract void zza();

    @Nullable
    final TaskCompletionSource zzb() {
        return this.zza;
    }

    public final void zzc(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    public zzj(@Nullable TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }
}
