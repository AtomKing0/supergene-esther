package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzpy;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends BroadcastReceiver {
    private final zzho zza;

    public zzo(zzho zzhoVar) {
        this.zza = zzhoVar;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzj().zzu().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzj().zzu().zza("App receiver called with null action");
            return;
        }
        if (!action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            this.zza.zzj().zzu().zza("App receiver called with unknown action");
            return;
        }
        final zzho zzhoVar = this.zza;
        if (zzpy.zza() && zzhoVar.zzf().zzf(null, zzbh.zzch)) {
            zzhoVar.zzj().zzp().zza("App receiver notified triggers are available");
            zzhoVar.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzq
                @Override // java.lang.Runnable
                public final void run() {
                    zzho zzhoVar2 = zzhoVar;
                    if (!zzhoVar2.zzt().zzw()) {
                        zzhoVar2.zzj().zzu().zza("registerTrigger called but app not eligible");
                        return;
                    }
                    final zziy zziyVarZzp = zzhoVar2.zzp();
                    Objects.requireNonNull(zziyVarZzp);
                    new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzr
                        @Override // java.lang.Runnable
                        public final void run() {
                            zziyVarZzp.zzal();
                        }
                    }).start();
                }
            });
        }
    }
}
