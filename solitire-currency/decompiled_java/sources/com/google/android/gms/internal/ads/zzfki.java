package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfki implements Runnable {

    @GuardedBy("enabledLock")
    @VisibleForTesting
    public static Boolean zzb;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private int zzi;
    private final zzdpy zzj;
    private final List zzk;
    private final zzbvj zzm;

    @VisibleForTesting
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();

    @GuardedBy("protoLock")
    private final zzfko zzg = zzfkr.zzc();
    private String zzh = "";

    @GuardedBy("initLock")
    private boolean zzl = false;

    public zzfki(Context context, VersionInfoParcel versionInfoParcel, zzdpy zzdpyVar, zzebn zzebnVar, zzbvj zzbvjVar) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdpyVar;
        this.zzm = zzbvjVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhW)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzt.zzd();
        } else {
            this.zzk = zzfxr.zzm();
        }
    }

    public static boolean zza() {
        boolean zBooleanValue;
        synchronized (zza) {
            if (zzb == null) {
                if (((Boolean) zzbdl.zzb.zze()).booleanValue()) {
                    zzb = Boolean.valueOf(Math.random() < ((Double) zzbdl.zza.zze()).doubleValue());
                } else {
                    zzb = Boolean.FALSE;
                }
            }
            zBooleanValue = zzb.booleanValue();
        }
        return zBooleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() == 0) {
                    return;
                }
                try {
                    synchronized (obj) {
                        bArrZzaV = ((zzfkr) this.zzg.zzbr()).zzaV();
                        this.zzg.zzc();
                    }
                    new zzebm(this.zze, this.zzf.afmaVersion, this.zzm, Binder.getCallingUid()).zza(new zzebk((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhQ), 60000, new HashMap(), bArrZzaV, "application/x-protobuf", false));
                } catch (Exception e10) {
                    if ((e10 instanceof zzdwl) && ((zzdwl) e10).zza() == 3) {
                        return;
                    }
                    com.google.android.gms.ads.internal.zzu.zzo().zzv(e10, "CuiMonitor.sendCuiPing");
                }
            }
        }
    }

    public final void zzb(@Nullable final zzfjy zzfjyVar) {
        zzbzo.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfkh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(zzfjyVar);
            }
        });
    }

    final /* synthetic */ void zzc(zzfjy zzfjyVar) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    try {
                        com.google.android.gms.ads.internal.zzu.zzp();
                        this.zzh = com.google.android.gms.ads.internal.util.zzt.zzp(this.zze);
                    } catch (RemoteException | RuntimeException e10) {
                        com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhR)).intValue();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkT)).booleanValue()) {
                        long j10 = iIntValue;
                        zzbzo.zzd.scheduleWithFixedDelay(this, j10, j10, TimeUnit.MILLISECONDS);
                    } else {
                        long j11 = iIntValue;
                        zzbzo.zzd.scheduleAtFixedRate(this, j11, j11, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfjyVar != null) {
            synchronized (zzc) {
                if (this.zzg.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhS)).intValue()) {
                    return;
                }
                zzfkk zzfkkVarZza = zzfkm.zza();
                zzfkkVarZza.zzu(zzfjyVar.zzm());
                zzfkkVarZza.zzq(zzfjyVar.zzl());
                zzfkkVarZza.zzg(zzfjyVar.zzb());
                zzfkkVarZza.zzw(3);
                zzfkkVarZza.zzn(this.zzf.afmaVersion);
                zzfkkVarZza.zzb(this.zzh);
                zzfkkVarZza.zzk(Build.VERSION.RELEASE);
                zzfkkVarZza.zzr(Build.VERSION.SDK_INT);
                zzfkkVarZza.zzv(zzfjyVar.zzo());
                zzfkkVarZza.zzj(zzfjyVar.zza());
                zzfkkVarZza.zze(this.zzi);
                zzfkkVarZza.zzt(zzfjyVar.zzn());
                zzfkkVarZza.zzc(zzfjyVar.zze());
                zzfkkVarZza.zzf(zzfjyVar.zzg());
                zzfkkVarZza.zzh(zzfjyVar.zzh());
                zzfkkVarZza.zzi(this.zzj.zzb(zzfjyVar.zzh()));
                zzfkkVarZza.zzl(zzfjyVar.zzi());
                zzfkkVarZza.zzm(zzfjyVar.zzd());
                zzfkkVarZza.zzd(zzfjyVar.zzf());
                zzfkkVarZza.zzs(zzfjyVar.zzk());
                zzfkkVarZza.zzo(zzfjyVar.zzj());
                zzfkkVarZza.zzp(zzfjyVar.zzc());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhW)).booleanValue()) {
                    zzfkkVarZza.zza(this.zzk);
                }
                zzfko zzfkoVar = this.zzg;
                zzfkp zzfkpVarZza = zzfkq.zza();
                zzfkpVarZza.zza(zzfkkVarZza);
                zzfkoVar.zzb(zzfkpVarZza);
            }
        }
    }
}
