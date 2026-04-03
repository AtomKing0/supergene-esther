package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbze {
    private final Object zza = new Object();
    private final com.google.android.gms.ads.internal.util.zzj zzb;
    private final zzbzi zzc;
    private boolean zzd;
    private Context zze;
    private VersionInfoParcel zzf;
    private String zzg;

    @Nullable
    private zzbcb zzh;

    @Nullable
    private Boolean zzi;
    private final AtomicInteger zzj;
    private final AtomicInteger zzk;
    private final zzbzd zzl;
    private final Object zzm;

    @GuardedBy("grantedPermissionLock")
    private m zzn;
    private final AtomicBoolean zzo;

    public zzbze() {
        com.google.android.gms.ads.internal.util.zzj zzjVar = new com.google.android.gms.ads.internal.util.zzj();
        this.zzb = zzjVar;
        this.zzc = new zzbzi(com.google.android.gms.ads.internal.client.zzay.zzd(), zzjVar);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = new AtomicInteger(0);
        this.zzk = new AtomicInteger(0);
        this.zzl = new zzbzd(null);
        this.zzm = new Object();
        this.zzo = new AtomicBoolean();
    }

    public final boolean zzA(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhC)).booleanValue()) {
                return this.zzo.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final int zza() {
        return this.zzk.get();
    }

    public final int zzb() {
        return this.zzj.get();
    }

    @Nullable
    public final Context zzd() {
        return this.zze;
    }

    @Nullable
    public final Resources zze() {
        if (this.zzf.isClientJar) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjV)).booleanValue()) {
                return com.google.android.gms.ads.internal.util.client.zzq.zza(this.zze).getResources();
            }
            com.google.android.gms.ads.internal.util.client.zzq.zza(this.zze).getResources();
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzp e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot load resource from dynamite apk or local jar", e10);
            return null;
        }
    }

    @Nullable
    public final zzbcb zzg() {
        zzbcb zzbcbVar;
        synchronized (this.zza) {
            zzbcbVar = this.zzh;
        }
        return zzbcbVar;
    }

    public final zzbzi zzh() {
        return this.zzc;
    }

    public final com.google.android.gms.ads.internal.util.zzg zzi() {
        com.google.android.gms.ads.internal.util.zzj zzjVar;
        synchronized (this.zza) {
            zzjVar = this.zzb;
        }
        return zzjVar;
    }

    public final m zzk() {
        if (this.zze != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcv)).booleanValue()) {
                synchronized (this.zzm) {
                    m mVar = this.zzn;
                    if (mVar != null) {
                        return mVar;
                    }
                    m mVarZzb = zzbzo.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzbyz
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zza.zzo();
                        }
                    });
                    this.zzn = mVarZzb;
                    return mVarZzb;
                }
            }
        }
        return zzgcj.zzh(new ArrayList());
    }

    public final Boolean zzl() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzn() {
        return this.zzg;
    }

    final /* synthetic */ ArrayList zzo() throws Exception {
        Context contextZza = zzbvl.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(contextZza).getPackageInfo(contextZza.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i10 = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i10] & 2) != 0) {
                        arrayList.add(strArr[i10]);
                    }
                    i10++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzl.zza();
    }

    public final void zzr() {
        this.zzj.decrementAndGet();
    }

    public final void zzs() {
        this.zzk.incrementAndGet();
    }

    public final void zzt() {
        this.zzj.incrementAndGet();
    }

    @TargetApi(23)
    public final void zzu(Context context, VersionInfoParcel versionInfoParcel) {
        zzbcb zzbcbVar;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = versionInfoParcel;
                com.google.android.gms.ads.internal.zzu.zzb().zzc(this.zzc);
                this.zzb.zzs(this.zze);
                zzbtq.zzb(this.zze, this.zzf);
                com.google.android.gms.ads.internal.zzu.zze();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbN)).booleanValue()) {
                    zzbcbVar = new zzbcb();
                } else {
                    com.google.android.gms.ads.internal.util.zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbcbVar = null;
                }
                this.zzh = zzbcbVar;
                if (zzbcbVar != null) {
                    zzbzr.zza(new zzbza(this).zzb(), "AppState.registerCsiReporter");
                }
                if (PlatformVersion.isAtLeastO()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhC)).booleanValue()) {
                        try {
                            ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzbzb(this));
                        } catch (RuntimeException e10) {
                            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to register network callback", e10);
                            this.zzo.set(true);
                        }
                    }
                }
                this.zzd = true;
                zzk();
            }
        }
        com.google.android.gms.ads.internal.zzu.zzp().zzc(context, versionInfoParcel.afmaVersion);
    }

    public final void zzv(Throwable th, String str) {
        zzbtq.zzb(this.zze, this.zzf).zzi(th, str, ((Double) zzbeb.zzg.zze()).floatValue());
    }

    public final void zzw(Throwable th, String str) {
        zzbtq.zzb(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzx(Throwable th, String str) {
        zzbtq.zzd(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzy(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzz(String str) {
        this.zzg = str;
    }
}
