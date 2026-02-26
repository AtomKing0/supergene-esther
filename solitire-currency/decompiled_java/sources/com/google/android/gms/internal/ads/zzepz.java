package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepz implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    zzepz(zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
        this.zzb = context;
    }

    @SuppressLint({"UnprotectedReceiver"})
    private final Intent zzd() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        return (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) ? this.zzb.registerReceiver(null, intentFilter) : this.zzb.registerReceiver(null, intentFilter, 4);
    }

    private static final boolean zze(Intent intent) {
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    @SuppressLint({"UnprotectedReceiver"})
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzepy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeqa zzc() throws Exception {
        double intExtra;
        boolean zIsCharging;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlb)).booleanValue()) {
            BatteryManager batteryManager = (BatteryManager) this.zzb.getSystemService("batterymanager");
            intExtra = batteryManager != null ? ((double) batteryManager.getIntProperty(4)) / 100.0d : -1.0d;
            zIsCharging = batteryManager != null ? batteryManager.isCharging() : zze(zzd());
        } else {
            Intent intentZzd = zzd();
            boolean zZze = zze(intentZzd);
            intExtra = intentZzd != null ? ((double) intentZzd.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1)) / ((double) intentZzd.getIntExtra("scale", -1)) : -1.0d;
            zIsCharging = zZze;
        }
        return new zzeqa(intExtra, zIsCharging);
    }
}
