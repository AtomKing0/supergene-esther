package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzpf;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public class zzho implements zzio {
    private static volatile zzho zzb;

    @VisibleForTesting
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;

    @VisibleForTesting
    private Boolean zzad;

    @VisibleForTesting
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private int zzah;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzad zzh;
    private final zzae zzi;
    private final zzgm zzj;
    private final zzgb zzk;
    private final zzhh zzl;
    private final zzmi zzm;
    private final zznt zzn;
    private final zzfw zzo;
    private final Clock zzp;
    private final zzkv zzq;
    private final zziy zzr;
    private final zza zzs;
    private final zzkm zzt;
    private final String zzu;
    private zzfu zzv;
    private zzla zzw;
    private zzaz zzx;
    private zzfv zzy;
    private boolean zzz = false;
    private AtomicInteger zzai = new AtomicInteger(0);

    private zzho(zziw zziwVar) {
        Bundle bundle;
        boolean z10 = false;
        Preconditions.checkNotNull(zziwVar);
        zzad zzadVar = new zzad(zziwVar.zza);
        this.zzh = zzadVar;
        zzfp.zza = zzadVar;
        Context context = zziwVar.zza;
        this.zzc = context;
        this.zzd = zziwVar.zzb;
        this.zze = zziwVar.zzc;
        this.zzf = zziwVar.zzd;
        this.zzg = zziwVar.zzh;
        this.zzac = zziwVar.zze;
        this.zzu = zziwVar.zzj;
        this.zzaf = true;
        com.google.android.gms.internal.measurement.zzdq zzdqVar = zziwVar.zzg;
        if (zzdqVar != null && (bundle = zzdqVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzdqVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzhg.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        Long l10 = zziwVar.zzi;
        this.zza = l10 != null ? l10.longValue() : defaultClock.currentTimeMillis();
        this.zzi = new zzae(this);
        zzgm zzgmVar = new zzgm(this);
        zzgmVar.zzad();
        this.zzj = zzgmVar;
        zzgb zzgbVar = new zzgb(this);
        zzgbVar.zzad();
        this.zzk = zzgbVar;
        zznt zzntVar = new zznt(this);
        zzntVar.zzad();
        this.zzn = zzntVar;
        this.zzo = new zzfw(new zziz(zziwVar, this));
        this.zzs = new zza(this);
        zzkv zzkvVar = new zzkv(this);
        zzkvVar.zzv();
        this.zzq = zzkvVar;
        zziy zziyVar = new zziy(this);
        zziyVar.zzv();
        this.zzr = zziyVar;
        zzmi zzmiVar = new zzmi(this);
        zzmiVar.zzv();
        this.zzm = zzmiVar;
        zzkm zzkmVar = new zzkm(this);
        zzkmVar.zzad();
        this.zzt = zzkmVar;
        zzhh zzhhVar = new zzhh(this);
        zzhhVar.zzad();
        this.zzl = zzhhVar;
        com.google.android.gms.internal.measurement.zzdq zzdqVar2 = zziwVar.zzg;
        if (zzdqVar2 != null && zzdqVar2.zzb != 0) {
            z10 = true;
        }
        boolean z11 = !z10;
        if (context.getApplicationContext() instanceof Application) {
            zziy zziyVarZzp = zzp();
            if (zziyVarZzp.zza().getApplicationContext() instanceof Application) {
                Application application = (Application) zziyVarZzp.zza().getApplicationContext();
                if (zziyVarZzp.zza == null) {
                    zziyVarZzp.zza = new zzkl(zziyVarZzp);
                }
                if (z11) {
                    application.unregisterActivityLifecycleCallbacks(zziyVarZzp.zza);
                    application.registerActivityLifecycleCallbacks(zziyVarZzp.zza);
                    zziyVarZzp.zzj().zzp().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzj().zzu().zza("Application context is not an Application");
        }
        zzhhVar.zzb(new zzhp(this, zziwVar));
    }

    private final zzkm zzai() {
        zza((zzil) this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final Context zza() {
        return this.zzc;
    }

    final void zzaa() {
        this.zzag++;
    }

    @WorkerThread
    public final boolean zzab() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    @WorkerThread
    public final boolean zzac() {
        return zzc() == 0;
    }

    @WorkerThread
    public final boolean zzad() {
        zzl().zzt();
        return this.zzaf;
    }

    public final boolean zzae() {
        return TextUtils.isEmpty(this.zzd);
    }

    @WorkerThread
    protected final boolean zzaf() {
        if (!this.zzz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzl().zzt();
        Boolean bool = this.zzaa;
        if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
            this.zzab = this.zzp.elapsedRealtime();
            boolean z10 = true;
            Boolean boolValueOf = Boolean.valueOf(zzt().zze("android.permission.INTERNET") && zzt().zze("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzx() || (zznt.zza(this.zzc) && zznt.zza(this.zzc, false))));
            this.zzaa = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!zzt().zza(zzh().zzae(), zzh().zzac()) && TextUtils.isEmpty(zzh().zzac())) {
                    z10 = false;
                }
                this.zzaa = Boolean.valueOf(z10);
            }
        }
        return this.zzaa.booleanValue();
    }

    public final boolean zzag() {
        return this.zzg;
    }

    @WorkerThread
    public final boolean zzah() {
        zzl().zzt();
        zza((zzil) zzai());
        String strZzad = zzh().zzad();
        Pair<String, Boolean> pairZza = zzn().zza(strZzad);
        if (!this.zzi.zzu() || ((Boolean) pairZza.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZza.first)) {
            zzj().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!zzai().zzc()) {
            zzj().zzu().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        if (zzon.zza() && this.zzi.zza(zzbh.zzcp)) {
            zzla zzlaVarZzr = zzr();
            zzlaVarZzr.zzt();
            zzlaVarZzr.zzu();
            if (!zzlaVarZzr.zzak() || zzlaVarZzr.zzq().zzg() >= 234200) {
                zziy zziyVarZzp = zzp();
                zziyVarZzp.zzt();
                zzal zzalVarZzaa = zziyVarZzp.zzo().zzaa();
                Bundle bundle = zzalVarZzaa != null ? zzalVarZzaa.zza : null;
                if (bundle == null) {
                    int i10 = this.zzah;
                    this.zzah = i10 + 1;
                    boolean z10 = i10 < 10;
                    zzj().zzc().zza("Failed to retrieve DMA consent from the service, " + (z10 ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.zzah));
                    return z10;
                }
                zziq zziqVarZza = zziq.zza(bundle, 100);
                sb.append("&gcs=");
                sb.append(zziqVarZza.zzg());
                zzax zzaxVarZza = zzax.zza(bundle, 100);
                sb.append("&dma=");
                sb.append(zzaxVarZza.zzd() == Boolean.FALSE ? 0 : 1);
                if (!TextUtils.isEmpty(zzaxVarZza.zze())) {
                    sb.append("&dma_cps=");
                    sb.append(zzaxVarZza.zze());
                }
                int i11 = zzax.zza(bundle) == Boolean.TRUE ? 0 : 1;
                sb.append("&npa=");
                sb.append(i11);
                zzj().zzp().zza("Consent query parameters to Bow", sb);
            }
        }
        zznt zzntVarZzt = zzt();
        zzh();
        URL urlZza = zzntVarZzt.zza(87000L, strZzad, (String) pairZza.first, zzn().zzp.zza() - 1, sb.toString());
        if (urlZza != null) {
            zzkm zzkmVarZzai = zzai();
            zzkp zzkpVar = new zzkp() { // from class: com.google.android.gms.measurement.internal.zzhq
                @Override // com.google.android.gms.measurement.internal.zzkp
                public final void zza(String str, int i12, Throwable th, byte[] bArr, Map map) {
                    this.zza.zza(str, i12, th, bArr, map);
                }
            };
            zzkmVarZzai.zzt();
            zzkmVarZzai.zzac();
            Preconditions.checkNotNull(urlZza);
            Preconditions.checkNotNull(zzkpVar);
            zzkmVarZzai.zzl().zza(new zzko(zzkmVarZzai, strZzad, urlZza, null, null, zzkpVar));
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final Clock zzb() {
        return this.zzp;
    }

    @WorkerThread
    public final int zzc() {
        zzl().zzt();
        if (this.zzi.zzw()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!zzad()) {
            return 8;
        }
        Boolean boolZzv = zzn().zzv();
        if (boolZzv != null) {
            return boolZzv.booleanValue() ? 0 : 3;
        }
        Boolean boolZzf = this.zzi.zzf("firebase_analytics_collection_enabled");
        if (boolZzf != null) {
            return boolZzf.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzad;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.zzac == null || this.zzac.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final zzad zzd() {
        return this.zzh;
    }

    public final zza zze() {
        zza zzaVar = this.zzs;
        if (zzaVar != null) {
            return zzaVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final zzae zzf() {
        return this.zzi;
    }

    public final zzaz zzg() {
        zza((zzil) this.zzx);
        return this.zzx;
    }

    public final zzfv zzh() {
        zza((zzg) this.zzy);
        return this.zzy;
    }

    public final zzfu zzi() {
        zza((zzg) this.zzv);
        return this.zzv;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final zzgb zzj() {
        zza((zzil) this.zzk);
        return this.zzk;
    }

    public final zzfw zzk() {
        return this.zzo;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final zzhh zzl() {
        zza((zzil) this.zzl);
        return this.zzl;
    }

    public final zzgb zzm() {
        zzgb zzgbVar = this.zzk;
        if (zzgbVar == null || !zzgbVar.zzaf()) {
            return null;
        }
        return this.zzk;
    }

    public final zzgm zzn() {
        zza((zzim) this.zzj);
        return this.zzj;
    }

    final zzhh zzo() {
        return this.zzl;
    }

    public final zziy zzp() {
        zza((zzg) this.zzr);
        return this.zzr;
    }

    public final zzkv zzq() {
        zza((zzg) this.zzq);
        return this.zzq;
    }

    public final zzla zzr() {
        zza((zzg) this.zzw);
        return this.zzw;
    }

    public final zzmi zzs() {
        zza((zzg) this.zzm);
        return this.zzm;
    }

    public final zznt zzt() {
        zza((zzim) this.zzn);
        return this.zzn;
    }

    public final String zzu() {
        return this.zzd;
    }

    public final String zzv() {
        return this.zze;
    }

    public final String zzw() {
        return this.zzf;
    }

    public final String zzx() {
        return this.zzu;
    }

    final void zzy() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zzz() {
        this.zzai.incrementAndGet();
    }

    public static zzho zza(Context context, com.google.android.gms.internal.measurement.zzdq zzdqVar, Long l10) {
        Bundle bundle;
        if (zzdqVar != null && (zzdqVar.zze == null || zzdqVar.zzf == null)) {
            zzdqVar = new com.google.android.gms.internal.measurement.zzdq(zzdqVar.zza, zzdqVar.zzb, zzdqVar.zzc, zzdqVar.zzd, null, null, zzdqVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzho.class) {
                if (zzb == null) {
                    zzb = new zzho(new zziw(context, zzdqVar, l10));
                }
            }
        } else if (zzdqVar != null && (bundle = zzdqVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zza(zzdqVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    @WorkerThread
    public final void zzb(boolean z10) {
        zzl().zzt();
        this.zzaf = z10;
    }

    static /* synthetic */ void zza(zzho zzhoVar, zziw zziwVar) {
        zzhoVar.zzl().zzt();
        zzaz zzazVar = new zzaz(zzhoVar);
        zzazVar.zzad();
        zzhoVar.zzx = zzazVar;
        zzfv zzfvVar = new zzfv(zzhoVar, zziwVar.zzf);
        zzfvVar.zzv();
        zzhoVar.zzy = zzfvVar;
        zzfu zzfuVar = new zzfu(zzhoVar);
        zzfuVar.zzv();
        zzhoVar.zzv = zzfuVar;
        zzla zzlaVar = new zzla(zzhoVar);
        zzlaVar.zzv();
        zzhoVar.zzw = zzlaVar;
        zzhoVar.zzn.zzae();
        zzhoVar.zzj.zzae();
        zzhoVar.zzy.zzw();
        zzhoVar.zzj().zzn().zza("App measurement initialized, version", 87000L);
        zzhoVar.zzj().zzn().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzad = zzfvVar.zzad();
        if (TextUtils.isEmpty(zzhoVar.zzd)) {
            if (zzhoVar.zzt().zzd(strZzad, zzhoVar.zzi.zzp())) {
                zzhoVar.zzj().zzn().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzhoVar.zzj().zzn().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + strZzad);
            }
        }
        zzhoVar.zzj().zzc().zza("Debug-level message logging enabled");
        if (zzhoVar.zzag != zzhoVar.zzai.get()) {
            zzhoVar.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzhoVar.zzag), Integer.valueOf(zzhoVar.zzai.get()));
        }
        zzhoVar.zzz = true;
    }

    private static void zza(zzim zzimVar) {
        if (zzimVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzg zzgVar) {
        if (zzgVar != null) {
            if (zzgVar.zzy()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: " + String.valueOf(zzgVar.getClass()));
        }
        throw new IllegalStateException("Component not created");
    }

    private static void zza(zzil zzilVar) {
        if (zzilVar != null) {
            if (zzilVar.zzaf()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: " + String.valueOf(zzilVar.getClass()));
        }
        throw new IllegalStateException("Component not created");
    }

    final /* synthetic */ void zza(String str, int i10, Throwable th, byte[] bArr, Map map) {
        if (!((i10 == 200 || i10 == 204 || i10 == 304) && th == null)) {
            zzj().zzu().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th);
            return;
        }
        zzn().zzo.zza(true);
        if (bArr != null && bArr.length != 0) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String strOptString = jSONObject.optString(NotificationSchedulerKeys.KEY_DEEPLINK, "");
                String strOptString2 = jSONObject.optString("gclid", "");
                String strOptString3 = jSONObject.optString("gbraid", "");
                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                if (TextUtils.isEmpty(strOptString)) {
                    zzj().zzc().zza("Deferred Deep Link is empty.");
                    return;
                }
                Bundle bundle = new Bundle();
                if (zzpf.zza() && this.zzi.zza(zzbh.zzcu)) {
                    if (!zzt().zzi(strOptString)) {
                        zzj().zzu().zza("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                        return;
                    }
                    bundle.putString("gbraid", strOptString3);
                } else if (!zzt().zzi(strOptString)) {
                    zzj().zzu().zza("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                    return;
                }
                bundle.putString("gclid", strOptString2);
                bundle.putString("_cis", "ddp");
                this.zzr.zzc(TtmlNode.TEXT_EMPHASIS_AUTO, "_cmp", bundle);
                zznt zzntVarZzt = zzt();
                if (TextUtils.isEmpty(strOptString) || !zzntVarZzt.zza(strOptString, dOptDouble)) {
                    return;
                }
                zzntVarZzt.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                return;
            } catch (JSONException e10) {
                zzj().zzg().zza("Failed to parse the Deferred Deep Link response. exception", e10);
                return;
            }
        }
        zzj().zzc().zza("Deferred Deep Link response empty.");
    }

    @WorkerThread
    final void zza(boolean z10) {
        this.zzac = Boolean.valueOf(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x01f7  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zza(com.google.android.gms.internal.measurement.zzdq r13) {
        /*
            Method dump skipped, instruction units count: 1314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzho.zza(com.google.android.gms.internal.measurement.zzdq):void");
    }
}
