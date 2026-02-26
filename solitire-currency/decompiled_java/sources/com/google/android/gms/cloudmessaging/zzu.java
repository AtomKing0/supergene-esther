package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzu {

    @Nullable
    private static zzu zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private zzn zzd = new zzn(this, null);
    private int zze = 1;

    @VisibleForTesting
    zzu(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzu zzb(Context context) {
        if (zza == null) {
            com.google.android.gms.internal.cloudmessaging.zze.zza();
            zza = new zzu(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
        }
        return zza;
    }

    private final synchronized int zzf() {
        int i10;
        i10 = this.zze;
        this.zze = i10 + 1;
        return i10;
    }

    private final synchronized Task zzg(zzr zzrVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Queueing ".concat(zzrVar.toString()));
        }
        if (!this.zzd.zzg(zzrVar)) {
            zzn zznVar = new zzn(this, null);
            this.zzd = zznVar;
            zznVar.zzg(zzrVar);
        }
        return zzrVar.zzb.getTask();
    }

    public final Task zzc(int i10, Bundle bundle) {
        return zzg(new zzq(zzf(), i10, bundle));
    }

    public final Task zzd(int i10, Bundle bundle) {
        return zzg(new zzt(zzf(), 1, bundle));
    }
}
