package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzkv extends zzg {

    @VisibleForTesting
    protected zzks zza;
    private volatile zzks zzb;
    private volatile zzks zzc;
    private final Map<Activity, zzks> zzd;

    @GuardedBy("activityLock")
    private Activity zze;

    @GuardedBy("activityLock")
    private volatile boolean zzf;
    private volatile zzks zzg;
    private zzks zzh;

    @GuardedBy("activityLock")
    private boolean zzi;
    private final Object zzj;

    public zzkv(zzho zzhoVar) {
        super(zzhoVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    public final zzks zzaa() {
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zziy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkv zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzla zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmi zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    @MainThread
    private final zzks zzd(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzks zzksVar = this.zzd.get(activity);
        if (zzksVar == null) {
            zzks zzksVar2 = new zzks(null, zza(activity.getClass(), "Activity"), zzq().zzm());
            this.zzd.put(activity, zzksVar2);
            zzksVar = zzksVar2;
        }
        return this.zzg != null ? this.zzg : zzksVar;
    }

    @MainThread
    public final void zzb(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzv()) {
            this.zzb = null;
            zzl().zzb(new zzkz(this, jElapsedRealtime));
        } else {
            zzks zzksVarZzd = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzl().zzb(new zzky(this, zzksVarZzd, jElapsedRealtime));
        }
    }

    @MainThread
    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (zze().zzv()) {
                    this.zzg = null;
                    zzl().zzb(new zzlb(this));
                }
            }
        }
        if (!zze().zzv()) {
            this.zzb = this.zzg;
            zzl().zzb(new zzkw(this));
        } else {
            zza(activity, zzd(activity), false);
            zza zzaVarZzc = zzc();
            zzaVarZzc.zzl().zzb(new zze(zzaVarZzc, zzaVarZzc.zzb().elapsedRealtime()));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @WorkerThread
    public final zzks zza(boolean z10) {
        zzu();
        zzt();
        if (!z10) {
            return this.zza;
        }
        zzks zzksVar = this.zza;
        return zzksVar != null ? zzksVar : this.zzh;
    }

    @VisibleForTesting
    private final String zza(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] strArrSplit = canonicalName.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str2.length() > zze().zza((String) null, false) ? str2.substring(0, zze().zza((String) null, false)) : str2;
    }

    static /* synthetic */ void zza(zzkv zzkvVar, Bundle bundle, zzks zzksVar, zzks zzksVar2, long j10) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        zzkvVar.zza(zzksVar, zzksVar2, j10, true, zzkvVar.zzq().zza((String) null, "screen_view", bundle, (List<String>) null, false));
    }

    @MainThread
    public final void zzb(Activity activity, Bundle bundle) {
        zzks zzksVar;
        if (!zze().zzv() || bundle == null || (zzksVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzksVar.zzc);
        bundle2.putString("name", zzksVar.zza);
        bundle2.putString("referrer_name", zzksVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @MainThread
    private final void zza(Activity activity, zzks zzksVar, boolean z10) {
        zzks zzksVar2;
        zzks zzksVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzksVar.zzb == null) {
            zzksVar2 = new zzks(zzksVar.zza, activity != null ? zza(activity.getClass(), "Activity") : null, zzksVar.zzc, zzksVar.zze, zzksVar.zzf);
        } else {
            zzksVar2 = zzksVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzksVar2;
        zzl().zzb(new zzkx(this, zzksVar2, zzksVar3, zzb().elapsedRealtime(), z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.measurement.internal.zzks r16, com.google.android.gms.measurement.internal.zzks r17, long r18, boolean r20, android.os.Bundle r21) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkv.zza(com.google.android.gms.measurement.internal.zzks, com.google.android.gms.measurement.internal.zzks, long, boolean, android.os.Bundle):void");
    }

    @MainThread
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzv() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzks(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    @MainThread
    public final void zza(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zze().zzv()) {
            this.zzd.remove(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzks zzksVar, boolean z10, long j10) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzp().zza(zzksVar != null && zzksVar.zzd, z10, j10) || zzksVar == null) {
            return;
        }
        zzksVar.zzd = false;
    }

    @Deprecated
    public final void zza(@NonNull Activity activity, @Size(max = 36, min = 1) String str, @Size(max = 36, min = 1) String str2) {
        if (!zze().zzv()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzks zzksVar = this.zzb;
        if (zzksVar == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass(), "Activity");
        }
        boolean zEquals = Objects.equals(zzksVar.zzb, str2);
        boolean zEquals2 = Objects.equals(zzksVar.zza, str);
        if (zEquals && zEquals2) {
            zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzp().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzks zzksVar2 = new zzks(str, str2, zzq().zzm());
        this.zzd.put(activity, zzksVar2);
        zza(activity, zzksVar2, true);
    }

    public final void zza(Bundle bundle, long j10) {
        String str;
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzj().zzv().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String strZza = null;
            if (bundle != null) {
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    strZza = string2;
                }
            } else {
                str = null;
            }
            if (strZza == null) {
                Activity activity = this.zze;
                strZza = activity != null ? zza(activity.getClass(), "Activity") : "Activity";
            }
            String str2 = strZza;
            zzks zzksVar = this.zzb;
            if (this.zzf && zzksVar != null) {
                this.zzf = false;
                boolean zEquals = Objects.equals(zzksVar.zzb, str2);
                boolean zEquals2 = Objects.equals(zzksVar.zza, str);
                if (zEquals && zEquals2) {
                    zzj().zzv().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzj().zzp().zza("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
            zzks zzksVar2 = this.zzb == null ? this.zzc : this.zzb;
            zzks zzksVar3 = new zzks(str, str2, zzq().zzm(), true, j10);
            this.zzb = zzksVar3;
            this.zzc = zzksVar2;
            this.zzg = zzksVar3;
            zzl().zzb(new zzku(this, bundle, zzksVar3, zzksVar2, zzb().elapsedRealtime()));
        }
    }
}
