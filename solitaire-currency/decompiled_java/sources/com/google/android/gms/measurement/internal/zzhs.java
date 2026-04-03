package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhs extends zzft {
    private final zznd zza;
    private Boolean zzb;
    private String zzc;

    public zzhs(zznd zzndVar) {
        this(zzndVar, null);
    }

    private final void zzd(zzbf zzbfVar, zzn zznVar) {
        this.zza.zzr();
        this.zza.zza(zzbfVar, zznVar);
    }

    @VisibleForTesting
    final zzbf zzb(zzbf zzbfVar, zzn zznVar) {
        zzba zzbaVar;
        boolean z10 = false;
        if ("_cmp".equals(zzbfVar.zza) && (zzbaVar = zzbfVar.zzb) != null && zzbaVar.zza() != 0) {
            String strZzd = zzbfVar.zzb.zzd("_cis");
            if ("referrer broadcast".equals(strZzd) || "referrer API".equals(strZzd)) {
                z10 = true;
            }
        }
        if (!z10) {
            return zzbfVar;
        }
        this.zza.zzj().zzn().zza("Event has been filtered ", zzbfVar.toString());
        return new zzbf("_cmpx", zzbfVar.zzb, zzbfVar.zzc, zzbfVar.zzd);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zzc(zzn zznVar) {
        zzb(zznVar, false);
        zza(new zzht(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zze(zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        Preconditions.checkNotNull(zznVar.zzt);
        zzie zzieVar = new zzie(this, zznVar);
        Preconditions.checkNotNull(zzieVar);
        if (this.zza.zzl().zzg()) {
            zzieVar.run();
        } else {
            this.zza.zzl().zzc(zzieVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zzf(zzn zznVar) {
        zzb(zznVar, false);
        zza(new zzhu(this, zznVar));
    }

    private zzhs(zznd zzndVar, String str) {
        Preconditions.checkNotNull(zzndVar);
        this.zza = zzndVar;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final zzal zza(zzn zznVar) {
        zzb(zznVar, false);
        Preconditions.checkNotEmpty(zznVar.zza);
        try {
            return (zzal) this.zza.zzl().zzb(new zzid(this, zznVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            this.zza.zzj().zzg().zza("Failed to get consent. appId", zzgb.zza(zznVar.zza), e10);
            return new zzal(null);
        }
    }

    final void zzc(zzbf zzbfVar, zzn zznVar) {
        boolean zZza;
        if (!this.zza.zzi().zzl(zznVar.zza)) {
            zzd(zzbfVar, zznVar);
            return;
        }
        this.zza.zzj().zzp().zza("EES config found for", zznVar.zza);
        zzgy zzgyVarZzi = this.zza.zzi();
        String str = zznVar.zza;
        com.google.android.gms.internal.measurement.zzb zzbVar = TextUtils.isEmpty(str) ? null : zzgyVarZzi.zza.get(str);
        if (zzbVar == null) {
            this.zza.zzj().zzp().zza("EES not loaded for", zznVar.zza);
            zzd(zzbfVar, zznVar);
            return;
        }
        try {
            Map<String, Object> mapZza = this.zza.zzp().zza(zzbfVar.zzb.zzb(), true);
            String strZza = zzit.zza(zzbfVar.zza);
            if (strZza == null) {
                strZza = zzbfVar.zza;
            }
            zZza = zzbVar.zza(new com.google.android.gms.internal.measurement.zzad(strZza, zzbfVar.zzd, mapZza));
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            this.zza.zzj().zzg().zza("EES error. appId, eventName", zznVar.zzb, zzbfVar.zza);
            zZza = false;
        }
        if (!zZza) {
            this.zza.zzj().zzp().zza("EES was not applied to event", zzbfVar.zza);
            zzd(zzbfVar, zznVar);
            return;
        }
        if (zzbVar.zzd()) {
            this.zza.zzj().zzp().zza("EES edited event", zzbfVar.zza);
            zzd(this.zza.zzp().zza(zzbVar.zza().zzb()), zznVar);
        } else {
            zzd(zzbfVar, zznVar);
        }
        if (zzbVar.zzc()) {
            for (com.google.android.gms.internal.measurement.zzad zzadVar : zzbVar.zza().zzc()) {
                this.zza.zzj().zzp().zza("EES logging created event", zzadVar.zzb());
                zzd(this.zza.zzp().zza(zzadVar), zznVar);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zzd(zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        zza(zznVar.zza, false);
        zza(new zzib(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final String zzb(zzn zznVar) {
        zzb(zznVar, false);
        return this.zza.zzb(zznVar);
    }

    @BinderThread
    private final void zzb(zzn zznVar, boolean z10) {
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.zza);
        zza(zznVar.zza, false);
        this.zza.zzq().zza(zznVar.zzb, zznVar.zzp);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final List<zzmv> zza(zzn zznVar, Bundle bundle) {
        zzb(zznVar, false);
        Preconditions.checkNotNull(zznVar.zza);
        try {
            return (List) this.zza.zzl().zza(new zzik(this, zznVar, bundle)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzj().zzg().zza("Failed to get trigger URIs. appId", zzgb.zza(zznVar.zza), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final List<zzno> zza(zzn zznVar, boolean z10) {
        zzb(zznVar, false);
        String str = zznVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zznq> list = (List) this.zza.zzl().zza(new zzij(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z10 || !zznt.zzg(zznqVar.zzc)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzj().zzg().zza("Failed to get user properties. appId", zzgb.zza(zznVar.zza), e10);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final List<zzac> zza(String str, String str2, zzn zznVar) {
        zzb(zznVar, false);
        String str3 = zznVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzl().zza(new zzhz(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final List<zzac> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzl().zza(new zzic(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties as", e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final List<zzno> zza(String str, String str2, boolean z10, zzn zznVar) {
        zzb(zznVar, false);
        String str3 = zznVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zznq> list = (List) this.zza.zzl().zza(new zzhx(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z10 || !zznt.zzg(zznqVar.zzc)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzj().zzg().zza("Failed to query user properties. appId", zzgb.zza(zznVar.zza), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final List<zzno> zza(String str, String str2, String str3, boolean z10) {
        zza(str, true);
        try {
            List<zznq> list = (List) this.zza.zzl().zza(new zzia(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z10 || !zznt.zzg(zznqVar.zzc)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzj().zzg().zza("Failed to get user properties as. appId", zzgb.zza(str), e10);
            return Collections.emptyList();
        }
    }

    @BinderThread
    private final void zza(String str, boolean z10) {
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                try {
                    if (this.zzb == null) {
                        this.zzb = Boolean.valueOf("com.google.android.gms".equals(this.zzc) || UidVerifier.isGooglePlayServicesUid(this.zza.zza(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zza.zza()).isUidGoogleSigned(Binder.getCallingUid()));
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e10) {
                    this.zza.zzj().zzg().zza("Measurement Service called with invalid calling package. appId", zzgb.zza(str));
                    throw e10;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zza(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (str.equals(this.zzc)) {
                return;
            } else {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
        }
        this.zza.zzj().zzg().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    final /* synthetic */ void zza(String str, Bundle bundle) {
        this.zza.zzf().zza(str, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zza(zzbf zzbfVar, zzn zznVar) {
        Preconditions.checkNotNull(zzbfVar);
        zzb(zznVar, false);
        zza(new zzig(this, zzbfVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zza(zzbf zzbfVar, String str, String str2) {
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzif(this, zzbfVar, str));
    }

    @VisibleForTesting
    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzg()) {
            runnable.run();
        } else {
            this.zza.zzl().zzb(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zza(zzac zzacVar, zzn zznVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        zzb(zznVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.zza = zznVar.zza;
        zza(new zzhv(this, zzacVar2, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zza);
        zza(zzacVar.zza, true);
        zza(new zzhy(this, new zzac(zzacVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zza(long j10, String str, String str2, String str3) {
        zza(new zzhw(this, str2, str3, str, j10));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zza(final Bundle bundle, zzn zznVar) {
        zzb(zznVar, false);
        final String str = zznVar.zza;
        Preconditions.checkNotNull(str);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(str, bundle);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final void zza(zzno zznoVar, zzn zznVar) {
        Preconditions.checkNotNull(zznoVar);
        zzb(zznVar, false);
        zza(new zzih(this, zznoVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    @BinderThread
    public final byte[] zza(zzbf zzbfVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbfVar);
        zza(str, true);
        this.zza.zzj().zzc().zza("Log and bundle. event", this.zza.zzg().zza(zzbfVar.zza));
        long jNanoTime = this.zza.zzb().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzl().zzb(new zzii(this, zzbfVar, str)).get();
            if (bArr == null) {
                this.zza.zzj().zzg().zza("Log and bundle returned null. appId", zzgb.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzj().zzc().zza("Log and bundle processed. event, size, time_ms", this.zza.zzg().zza(zzbfVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzb().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzgb.zza(str), this.zza.zzg().zza(zzbfVar.zza), e10);
            return null;
        }
    }
}
