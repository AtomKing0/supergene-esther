package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzmd extends zzmy {
    public final zzgr zza;
    public final zzgr zzb;
    public final zzgr zzc;
    public final zzgr zzd;
    public final zzgr zze;
    private final Map<String, zzmc> zzg;

    zzmd(zznd zzndVar) {
        super(zzndVar);
        this.zzg = new HashMap();
        zzgm zzgmVarZzk = zzk();
        Objects.requireNonNull(zzgmVarZzk);
        this.zza = new zzgr(zzgmVarZzk, "last_delete_stale", 0L);
        zzgm zzgmVarZzk2 = zzk();
        Objects.requireNonNull(zzgmVarZzk2);
        this.zzb = new zzgr(zzgmVarZzk2, "backoff", 0L);
        zzgm zzgmVarZzk3 = zzk();
        Objects.requireNonNull(zzgmVarZzk3);
        this.zzc = new zzgr(zzgmVarZzk3, "last_upload", 0L);
        zzgm zzgmVarZzk4 = zzk();
        Objects.requireNonNull(zzgmVarZzk4);
        this.zzd = new zzgr(zzgmVarZzk4, "last_upload_attempt", 0L);
        zzgm zzgmVarZzk5 = zzk();
        Objects.requireNonNull(zzgmVarZzk5);
        this.zze = new zzgr(zzgmVarZzk5, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    protected final boolean zzc() {
        return false;
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

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzs zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzan zzh() {
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

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzgy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzmd zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznb zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @WorkerThread
    @Deprecated
    private final Pair<String, Boolean> zza(String str) {
        zzmc zzmcVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        zzt();
        long jElapsedRealtime = zzb().elapsedRealtime();
        zzmc zzmcVar2 = this.zzg.get(str);
        if (zzmcVar2 != null && jElapsedRealtime < zzmcVar2.zzc) {
            return new Pair<>(zzmcVar2.zza, Boolean.valueOf(zzmcVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long jZzd = zze().zzd(str) + jElapsedRealtime;
        try {
            long jZzc = zze().zzc(str, zzbh.zzb);
            if (jZzc > 0) {
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (zzmcVar2 != null && jElapsedRealtime < zzmcVar2.zzc + jZzc) {
                        return new Pair<>(zzmcVar2.zza, Boolean.valueOf(zzmcVar2.zzb));
                    }
                    advertisingIdInfo = null;
                }
            } else {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            }
        } catch (Exception e10) {
            zzj().zzc().zza("Unable to get advertising id", e10);
            zzmcVar = new zzmc("", false, jZzd);
        }
        if (advertisingIdInfo == null) {
            return new Pair<>("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String id = advertisingIdInfo.getId();
        zzmcVar = id != null ? new zzmc(id, advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd) : new zzmc("", advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd);
        this.zzg.put(str, zzmcVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(zzmcVar.zza, Boolean.valueOf(zzmcVar.zzb));
    }

    @WorkerThread
    final Pair<String, Boolean> zza(String str, zziq zziqVar) {
        if (zziqVar.zzi()) {
            return zza(str);
        }
        return new Pair<>("", Boolean.FALSE);
    }

    @WorkerThread
    @Deprecated
    final String zza(String str, boolean z10) {
        zzt();
        String str2 = z10 ? (String) zza(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestZzu = zznt.zzu();
        if (messageDigestZzu == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzu.digest(str2.getBytes())));
    }
}
