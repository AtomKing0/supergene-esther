package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzpa;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpy;
import com.google.android.gms.internal.measurement.zzqk;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zziq;
import com.google.common.util.concurrent.i;
import com.google.common.util.concurrent.m;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import v8.k0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zziy extends zzg {

    @VisibleForTesting
    protected zzkl zza;
    final zzt zzb;
    private zziu zzc;
    private final Set<zzix> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private PriorityQueue<zzmv> zzi;

    @GuardedBy("consentLock")
    private zziq zzj;
    private final AtomicLong zzk;
    private long zzl;

    @VisibleForTesting
    private boolean zzm;
    private zzav zzn;
    private SharedPreferences.OnSharedPreferenceChangeListener zzo;
    private zzav zzp;
    private final zzns zzq;

    protected zziy(zzho zzhoVar) {
        super(zzhoVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzm = true;
        this.zzq = new zzkd(this);
        this.zzf = new AtomicReference<>();
        this.zzj = zziq.zza;
        this.zzl = -1L;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzt(zzhoVar);
    }

    @TargetApi(30)
    private final PriorityQueue<zzmv> zzaq() {
        if (this.zzi == null) {
            this.zzi = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzmv) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzja
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzar() {
        zzt();
        String strZza = zzk().zzh.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                zza(App.TYPE, "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza(App.TYPE, "_npa", Long.valueOf(com.ironsource.mediationsdk.metadata.a.f13688g.equals(strZza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (!this.zzu.zzac() || !this.zzm) {
            zzj().zzc().zza("Updating Scion state (FE)");
            zzo().zzag();
            return;
        }
        zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzaj();
        if (zzpa.zza() && zze().zza(zzbh.zzbm)) {
            zzp().zza.zza();
        }
        zzl().zzb(new zzjp(this));
    }

    public final Boolean zzaa() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzjl(this, atomicReference));
    }

    public final Double zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzke(this, atomicReference));
    }

    public final Integer zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzkf(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzkc(this, atomicReference));
    }

    public final String zzae() {
        return this.zzf.get();
    }

    public final String zzaf() {
        zzks zzksVarZzaa = this.zzu.zzq().zzaa();
        if (zzksVarZzaa != null) {
            return zzksVarZzaa.zzb;
        }
        return null;
    }

    public final String zzag() {
        zzks zzksVarZzaa = this.zzu.zzq().zzaa();
        if (zzksVarZzaa != null) {
            return zzksVarZzaa.zza;
        }
        return null;
    }

    public final String zzah() {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzhi(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e10) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e10);
            return null;
        }
    }

    public final String zzai() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzju(this, atomicReference));
    }

    @WorkerThread
    public final void zzaj() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            Boolean boolZzf = zze().zzf("google_analytics_deferred_deep_link_enabled");
            if (boolZzf != null && boolZzf.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjh
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzam();
                    }
                });
            }
            zzo().zzac();
            this.zzm = false;
            String strZzw = zzk().zzw();
            if (TextUtils.isEmpty(strZzw)) {
                return;
            }
            zzf().zzac();
            if (strZzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzw);
            zzc(TtmlNode.TEXT_EMPHASIS_AUTO, "_ou", bundle);
        }
    }

    public final void zzak() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    final void zzal() {
        if (zzpy.zza() && zze().zza(zzbh.zzch)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzad.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzu();
            zzj().zzp().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, 5000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjd
                @Override // java.lang.Runnable
                public final void run() {
                    zziy zziyVar = this.zza;
                    AtomicReference<List<zzmv>> atomicReference2 = atomicReference;
                    Bundle bundleZza = zziyVar.zzk().zzi.zza();
                    zzla zzlaVarZzo = zziyVar.zzo();
                    if (bundleZza == null) {
                        bundleZza = new Bundle();
                    }
                    zzlaVarZzo.zza(atomicReference2, bundleZza);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zza(list);
                    }
                });
            }
        }
    }

    @WorkerThread
    public final void zzam() {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jZza = zzk().zzp.zza();
        zzk().zzp.zza(1 + jZza);
        if (jZza >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (!zzon.zza() || !zze().zza(zzbh.zzcp)) {
                this.zzu.zzah();
                return;
            }
            if (this.zzn == null) {
                this.zzn = new zzjv(this, this.zzu);
            }
            this.zzn.zza(0L);
        }
    }

    @WorkerThread
    public final void zzan() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        zzmt zzmtVarZza = zzmt.zza(zzk().zzc());
        zzj().zzp().zza("Tcf preferences read", zzmtVarZza);
        if (zzk().zza(zzmtVarZza)) {
            Bundle bundleZza = zzmtVarZza.zza();
            zzj().zzp().zza("Consent generated from Tcf", bundleZza);
            if (bundleZza != Bundle.EMPTY) {
                zza(bundleZza, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zzmtVarZza.zzb());
            zzc(TtmlNode.TEXT_EMPHASIS_AUTO, "_tcf", bundle);
        }
    }

    @TargetApi(30)
    @WorkerThread
    final void zzao() {
        zzmv zzmvVarPoll;
        MeasurementManagerFutures measurementManagerFuturesZzn;
        zzt();
        if (zzaq().isEmpty() || this.zzh || (zzmvVarPoll = zzaq().poll()) == null || (measurementManagerFuturesZzn = zzq().zzn()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzp().zza("Registering trigger URI", zzmvVarPoll.zza);
        m<k0> mVarRegisterTriggerAsync = measurementManagerFuturesZzn.registerTriggerAsync(Uri.parse(zzmvVarPoll.zza));
        if (mVarRegisterTriggerAsync == null) {
            this.zzh = false;
            zzaq().add(zzmvVarPoll);
            return;
        }
        SparseArray<Long> sparseArrayZzh = zzk().zzh();
        sparseArrayZzh.put(zzmvVarPoll.zzc, Long.valueOf(zzmvVarPoll.zzb));
        zzgm zzgmVarZzk = zzk();
        int[] iArr = new int[sparseArrayZzh.size()];
        long[] jArr = new long[sparseArrayZzh.size()];
        for (int i10 = 0; i10 < sparseArrayZzh.size(); i10++) {
            iArr[i10] = sparseArrayZzh.keyAt(i10);
            jArr[i10] = sparseArrayZzh.valueAt(i10).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzgmVarZzk.zzi.zza(bundle);
        i.a(mVarRegisterTriggerAsync, new zzjn(this, zzmvVarPoll), new zzjk(this));
    }

    @WorkerThread
    public final void zzap() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzo == null) {
            this.zzp = new zzjr(this, this.zzu);
            this.zzo = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzjg
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    this.zza.zza(sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzo);
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

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @WorkerThread
    final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    private final void zzb(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        zzl().zzb(new zzjq(this, str, str2, j10, zznt.zza(bundle), z10, z11, z12, str3));
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get conditional user properties", new zzjy(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return zznt.zzb((List<zzac>) list);
    }

    public final void zzb(Bundle bundle) {
        zza(bundle, zzb().currentTimeMillis());
    }

    public final void zzb(zzix zzixVar) {
        zzu();
        Preconditions.checkNotNull(zzixVar);
        if (this.zzd.remove(zzixVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener had not been registered");
    }

    public final List<zzno> zza(boolean z10) {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzjs(this, atomicReference, z10));
        List<zzno> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z10));
        return Collections.emptyList();
    }

    public final Map<String, Object> zza(String str, String str2, boolean z10) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzkb(this, atomicReference, null, str, str2, z10));
        List<zzno> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzno zznoVar : list) {
            Object objZza = zznoVar.zza();
            if (objZza != null) {
                arrayMap.put(zznoVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    static /* synthetic */ void zza(zziy zziyVar, zziq zziqVar, zziq zziqVar2) {
        zziq.zza zzaVar = zziq.zza.ANALYTICS_STORAGE;
        zziq.zza zzaVar2 = zziq.zza.AD_STORAGE;
        boolean zZza = zziqVar.zza(zziqVar2, zzaVar, zzaVar2);
        boolean zZzb = zziqVar.zzb(zziqVar2, zzaVar, zzaVar2);
        if (zZza || zZzb) {
            zziyVar.zzg().zzag();
        }
    }

    static /* synthetic */ void zza(zziy zziyVar, zziq zziqVar, long j10, boolean z10, boolean z11) {
        zziyVar.zzt();
        zziyVar.zzu();
        zziq zziqVarZzn = zziyVar.zzk().zzn();
        if (j10 <= zziyVar.zzl && zziq.zza(zziqVarZzn.zza(), zziqVar.zza())) {
            zziyVar.zzj().zzn().zza("Dropped out-of-date consent setting, proposed settings", zziqVar);
            return;
        }
        if (zziyVar.zzk().zza(zziqVar)) {
            zziyVar.zzl = j10;
            zziyVar.zzo().zza(z10);
            if (z11) {
                zziyVar.zzo().zza(new AtomicReference<>());
                return;
            }
            return;
        }
        zziyVar.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zziqVar.zza()));
    }

    public final void zza(String str, String str2, Bundle bundle) {
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzjz(this, bundle2));
    }

    final /* synthetic */ void zza(List list) {
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> sparseArrayZzh = zzk().zzh();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzmv zzmvVar = (zzmv) it.next();
                if (!sparseArrayZzh.contains(zzmvVar.zzc) || sparseArrayZzh.get(zzmvVar.zzc).longValue() < zzmvVar.zzb) {
                    zzaq().add(zzmvVar);
                }
            }
            zzao();
        }
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            zzj().zzp().zza("IABTCF_TCString change picked up in listener.");
            ((zzav) Preconditions.checkNotNull(this.zzp)).zza(500L);
        }
    }

    final /* synthetic */ void zza(Bundle bundle) {
        if (bundle == null) {
            zzk().zzt.zza(new Bundle());
            return;
        }
        Bundle bundleZza = zzk().zzt.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                zzq();
                if (zznt.zza(obj)) {
                    zzq();
                    zznt.zza(this.zzq, 27, (String) null, (String) null, 0);
                }
                zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
            } else if (zznt.zzg(str)) {
                zzj().zzv().zza("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleZza.remove(str);
            } else if (zzq().zza("param", str, zze().zza((String) null, false), obj)) {
                zzq().zza(bundleZza, str, obj);
            }
        }
        zzq();
        if (zznt.zza(bundleZza, zze().zzg())) {
            zzq();
            zznt.zza(this.zzq, 26, (String) null, (String) null, 0);
            zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        zzk().zzt.zza(bundleZza);
        zzo().zza(bundleZza);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        String str3 = str == null ? App.TYPE : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, "screen_view")) {
            zzn().zza(bundle2, j10);
        } else {
            zzb(str3, str2, j10, bundle2, z11, !z11 || this.zzc == null || zznt.zzg(str2), z10, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    @WorkerThread
    final void zza(String str, String str2, long j10, Bundle bundle) {
        zzt();
        zza(str, str2, j10, bundle, true, this.zzc == null || zznt.zzg(str2), true, null);
    }

    @WorkerThread
    protected final void zza(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        boolean zZza;
        String str4;
        long j11;
        String str5;
        String str6;
        boolean z13;
        int length;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzt();
        zzu();
        if (!this.zzu.zzac()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> listZzaf = zzg().zzaf();
        if (listZzaf != null && !listZzaf.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        boolean z14 = true;
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzu.zzag()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod(MobileAdsBridgeBase.initializeMethodName, Context.class).invoke(null, zza());
                } catch (Exception e10) {
                    zzj().zzu().zza("Failed to invoke Tag Manager's initialize() method", e10);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzn().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2)) {
            if (bundle.containsKey("gclid")) {
                zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
            }
            if (zzpf.zza() && zze().zza(zzbh.zzcu) && bundle.containsKey("gbraid")) {
                zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_gbraid", bundle.getString("gbraid"), zzb().currentTimeMillis());
            }
        }
        if (z10 && zznt.zzj(str2)) {
            zzq().zza(bundle, zzk().zzt.zza());
        }
        if (!z12 && !"_iap".equals(str2)) {
            zznt zzntVarZzt = this.zzu.zzt();
            int i10 = 2;
            if (zzntVarZzt.zzc(NotificationCompat.CATEGORY_EVENT, str2)) {
                if (!zzntVarZzt.zza(NotificationCompat.CATEGORY_EVENT, zzit.zza, zzit.zzb, str2)) {
                    i10 = 13;
                } else if (zzntVarZzt.zza(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                    i10 = 0;
                }
            }
            if (i10 != 0) {
                zzj().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str2));
                this.zzu.zzt();
                String strZza = zznt.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zznt.zza(this.zzq, i10, "_ev", strZza, length);
                return;
            }
        }
        zzks zzksVarZza = zzn().zza(false);
        if (zzksVarZza != null && !bundle.containsKey("_sc")) {
            zzksVarZza.zzd = true;
        }
        zznt.zza(zzksVarZza, bundle, z10 && !z12);
        boolean zEquals = "am".equals(str);
        boolean zZzg = zznt.zzg(str2);
        if (z10 && this.zzc != null && !zZzg && !zEquals) {
            zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str2), zzi().zza(bundle));
            Preconditions.checkNotNull(this.zzc);
            this.zzc.interceptEvent(str, str2, bundle, j10);
            return;
        }
        if (this.zzu.zzaf()) {
            int iZza = zzq().zza(str2);
            if (iZza != 0) {
                zzj().zzh().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str2));
                zzq();
                String strZza2 = zznt.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zznt.zza(this.zzq, str3, iZza, "_ev", strZza2, length);
                return;
            }
            Bundle bundleZza = zzq().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z12);
            Preconditions.checkNotNull(bundleZza);
            if (zzn().zza(false) != null && "_ae".equals(str2)) {
                zzmo zzmoVar = zzp().zzb;
                long jElapsedRealtime = zzmoVar.zzb.zzb().elapsedRealtime();
                long j12 = jElapsedRealtime - zzmoVar.zza;
                zzmoVar.zza = jElapsedRealtime;
                if (j12 > 0) {
                    zzq().zza(bundleZza, j12);
                }
            }
            if (!TtmlNode.TEXT_EMPHASIS_AUTO.equals(str) && "_ssr".equals(str2)) {
                zznt zzntVarZzq = zzq();
                String string = bundleZza.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zzntVarZzq.zzk().zzq.zza())) {
                    zzntVarZzq.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    z13 = false;
                } else {
                    zzntVarZzq.zzk().zzq.zza(string);
                    z13 = true;
                }
                if (!z13) {
                    return;
                }
            } else if ("_ae".equals(str2)) {
                String strZza3 = zzq().zzk().zzq.zza();
                if (!TextUtils.isEmpty(strZza3)) {
                    bundleZza.putString("_ffr", strZza3);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZza);
            if (zze().zza(zzbh.zzcm)) {
                zZza = zzp().zzaa();
            } else {
                zZza = zzk().zzn.zza();
            }
            if (zzk().zzk.zza() > 0 && zzk().zza(j10) && zZza) {
                zzj().zzp().zza("Current session is expired, remove the session number, ID, and engagement time");
                j11 = 0;
                str4 = "_ae";
                zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_sid", (Object) null, zzb().currentTimeMillis());
                zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_sno", (Object) null, zzb().currentTimeMillis());
                zza(TtmlNode.TEXT_EMPHASIS_AUTO, "_se", (Object) null, zzb().currentTimeMillis());
                zzk().zzl.zza(0L);
            } else {
                str4 = "_ae";
                j11 = 0;
            }
            if (bundleZza.getLong("extend_session", j11) == 1) {
                zzj().zzp().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzu.zzs().zza.zza(j10, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleZza.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                String str7 = (String) obj;
                if (str7 != null) {
                    zzq();
                    Bundle[] bundleArrZzb = zznt.zzb(bundleZza.get(str7));
                    if (bundleArrZzb != null) {
                        bundleZza.putParcelableArray(str7, bundleArrZzb);
                    }
                }
            }
            int i12 = 0;
            while (i12 < arrayList.size()) {
                Bundle bundleZza2 = (Bundle) arrayList.get(i12);
                if (i12 != 0 ? z14 : false) {
                    str6 = "_ep";
                    str5 = str;
                } else {
                    str5 = str;
                    str6 = str2;
                }
                bundleZza2.putString("_o", str5);
                if (z11) {
                    bundleZza2 = zzq().zza(bundleZza2, (String) null);
                }
                Bundle bundle2 = bundleZza2;
                zzo().zza(new zzbf(str6, new zzba(bundle2), str, j10), str3);
                if (!zEquals) {
                    Iterator<zzix> it = this.zzd.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundle2), j10);
                    }
                }
                i12++;
                z14 = true;
            }
            if (zzn().zza(false) == null || !str4.equals(str2)) {
                return;
            }
            zzp().zza(true, true, zzb().elapsedRealtime());
        }
    }

    public final void zza(zzix zzixVar) {
        zzu();
        Preconditions.checkNotNull(zzixVar);
        if (this.zzd.add(zzixVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener already registered");
    }

    final void zza(long j10, boolean z10) {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zzmi zzmiVarZzp = zzp();
        zzmiVarZzp.zzt();
        zzmiVarZzp.zzb.zza();
        if (zzqk.zza() && zze().zza(zzbh.zzbr)) {
            zzg().zzag();
        }
        boolean zZzac = this.zzu.zzac();
        zzgm zzgmVarZzk = zzk();
        zzgmVarZzk.zzc.zza(j10);
        if (!TextUtils.isEmpty(zzgmVarZzk.zzk().zzq.zza())) {
            zzgmVarZzk.zzq.zza(null);
        }
        if (zzpa.zza() && zzgmVarZzk.zze().zza(zzbh.zzbm)) {
            zzgmVarZzk.zzk.zza(0L);
        }
        zzgmVarZzk.zzl.zza(0L);
        if (!zzgmVarZzk.zze().zzw()) {
            zzgmVarZzk.zzb(!zZzac);
        }
        zzgmVarZzk.zzr.zza(null);
        zzgmVarZzk.zzs.zza(0L);
        zzgmVarZzk.zzt.zza(null);
        if (z10) {
            zzo().zzaf();
        }
        if (zzpa.zza() && zze().zza(zzbh.zzbm)) {
            zzp().zza.zza();
        }
        this.zzm = !zZzac;
    }

    private final void zza(String str, String str2, long j10, Object obj) {
        zzl().zzb(new zzjt(this, str, str2, obj, j10));
    }

    final void zza(String str) {
        this.zzf.set(str);
    }

    public final void zza(Bundle bundle, long j10) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzin.zza(bundle2, "app_id", String.class, null);
        zzin.zza(bundle2, "origin", String.class, null);
        zzin.zza(bundle2, "name", String.class, null);
        zzin.zza(bundle2, "value", Object.class, null);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzin.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j10);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object objZzc = zzq().zzc(string, obj);
        if (objZzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzin.zza(bundle2, objZzc);
        long j11 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j11 > 15552000000L || j11 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j11));
            return;
        }
        long j12 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j12 <= 15552000000L && j12 >= 1) {
            zzl().zzb(new zzjw(this, bundle2));
        } else {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j12));
        }
    }

    @VisibleForTesting
    final void zza(Bundle bundle, int i10, long j10) {
        zzu();
        String strZza = zziq.zza(bundle);
        if (strZza != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", strZza);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        zziq zziqVarZza = zziq.zza(bundle, i10);
        if (zzon.zza() && zze().zza(zzbh.zzcn)) {
            if (zziqVarZza.zzk()) {
                zza(zziqVarZza, j10, false);
            }
            zzax zzaxVarZza = zzax.zza(bundle, i10);
            if (zzaxVarZza.zzg()) {
                zza(zzaxVarZza, false);
            }
            Boolean boolZza = zzax.zza(bundle);
            if (boolZza != null) {
                zza(i10 == -30 ? "tcf" : App.TYPE, "allow_personalized_ads", (Object) boolZza.toString(), false);
                return;
            }
            return;
        }
        zza(zziqVarZza, j10, false);
    }

    public final void zza(zziq zziqVar, long j10, boolean z10) {
        zziq zziqVar2;
        boolean z11;
        boolean zZzc;
        boolean z12;
        zziq zziqVarZzb = zziqVar;
        zzu();
        int iZza = zziqVar.zza();
        if (zznw.zza() && zze().zza(zzbh.zzdb)) {
            if (iZza != -10) {
                zzip zzipVarZzc = zziqVar.zzc();
                zzip zzipVar = zzip.UNINITIALIZED;
                if (zzipVarZzc == zzipVar && zziqVar.zzd() == zzipVar) {
                    zzj().zzv().zza("Ignoring empty consent settings");
                    return;
                }
            }
        } else if (iZza != -10 && zziqVar.zze() == null && zziqVar.zzf() == null) {
            zzj().zzv().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            zziqVar2 = this.zzj;
            z11 = false;
            if (zziq.zza(iZza, zziqVar2.zza())) {
                zZzc = zziqVar.zzc(this.zzj);
                if (zziqVar.zzj() && !this.zzj.zzj()) {
                    z11 = true;
                }
                zziqVarZzb = zziqVar.zzb(this.zzj);
                this.zzj = zziqVarZzb;
                z12 = z11;
                z11 = true;
            } else {
                zZzc = false;
                z12 = false;
            }
        }
        if (!z11) {
            zzj().zzn().zza("Ignoring lower-priority consent settings, proposed settings", zziqVarZzb);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (zZzc) {
            zza((String) null);
            zzkj zzkjVar = new zzkj(this, zziqVarZzb, j10, andIncrement, z12, zziqVar2);
            if (z10) {
                zzt();
                zzkjVar.run();
                return;
            } else {
                zzl().zzc(zzkjVar);
                return;
            }
        }
        zzki zzkiVar = new zzki(this, zziqVarZzb, andIncrement, z12, zziqVar2);
        if (z10) {
            zzt();
            zzkiVar.run();
        } else if (iZza != 30 && iZza != -10) {
            zzl().zzb(zzkiVar);
        } else {
            zzl().zzc(zzkiVar);
        }
    }

    final void zza(zzax zzaxVar, boolean z10) {
        zzkg zzkgVar = new zzkg(this, zzaxVar);
        if (z10) {
            zzt();
            zzkgVar.run();
        } else {
            zzl().zzb(zzkgVar);
        }
    }

    @WorkerThread
    public final void zza(zziu zziuVar) {
        zziu zziuVar2;
        zzt();
        zzu();
        if (zziuVar != null && zziuVar != (zziuVar2 = this.zzc)) {
            Preconditions.checkState(zziuVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zziuVar;
    }

    public final void zza(Boolean bool) {
        zzu();
        zzl().zzb(new zzkh(this, bool));
    }

    @WorkerThread
    final void zza(zziq zziqVar) {
        zzt();
        boolean z10 = (zziqVar.zzj() && zziqVar.zzi()) || zzo().zzaj();
        if (z10 != this.zzu.zzad()) {
            this.zzu.zzb(z10);
            Boolean boolZzu = zzk().zzu();
            if (!z10 || boolZzu == null || boolZzu.booleanValue()) {
                zza(Boolean.valueOf(z10), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(Boolean bool, boolean z10) {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z10) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || !(bool == null || bool.booleanValue())) {
            zzar();
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z10) {
        zza(str, str2, obj, z10, zzb().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.String r7, java.lang.String r8, java.lang.Object r9, boolean r10, long r11) {
        /*
            r6 = this;
            if (r7 != 0) goto L4
            java.lang.String r7 = "app"
        L4:
            r1 = r7
            r7 = 0
            r0 = 24
            if (r10 == 0) goto L13
            com.google.android.gms.measurement.internal.zznt r10 = r6.zzq()
            int r10 = r10.zzb(r8)
            goto L35
        L13:
            com.google.android.gms.measurement.internal.zznt r10 = r6.zzq()
            java.lang.String r2 = "user property"
            boolean r3 = r10.zzc(r2, r8)
            r4 = 6
            if (r3 != 0) goto L22
        L20:
            r10 = r4
            goto L35
        L22:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zziv.zza
            boolean r3 = r10.zza(r2, r3, r8)
            if (r3 != 0) goto L2d
            r10 = 15
            goto L35
        L2d:
            boolean r10 = r10.zza(r2, r0, r8)
            if (r10 != 0) goto L34
            goto L20
        L34:
            r10 = r7
        L35:
            java.lang.String r2 = "_ev"
            r3 = 1
            if (r10 == 0) goto L52
            r6.zzq()
            java.lang.String r9 = com.google.android.gms.measurement.internal.zznt.zza(r8, r0, r3)
            if (r8 == 0) goto L47
            int r7 = r8.length()
        L47:
            com.google.android.gms.measurement.internal.zzho r8 = r6.zzu
            r8.zzt()
            com.google.android.gms.measurement.internal.zzns r8 = r6.zzq
            com.google.android.gms.measurement.internal.zznt.zza(r8, r10, r2, r9, r7)
            return
        L52:
            if (r9 == 0) goto L91
            com.google.android.gms.measurement.internal.zznt r10 = r6.zzq()
            int r10 = r10.zza(r8, r9)
            if (r10 == 0) goto L80
            r6.zzq()
            java.lang.String r8 = com.google.android.gms.measurement.internal.zznt.zza(r8, r0, r3)
            boolean r11 = r9 instanceof java.lang.String
            if (r11 != 0) goto L6d
            boolean r11 = r9 instanceof java.lang.CharSequence
            if (r11 == 0) goto L75
        L6d:
            java.lang.String r7 = java.lang.String.valueOf(r9)
            int r7 = r7.length()
        L75:
            com.google.android.gms.measurement.internal.zzho r9 = r6.zzu
            r9.zzt()
            com.google.android.gms.measurement.internal.zzns r9 = r6.zzq
            com.google.android.gms.measurement.internal.zznt.zza(r9, r10, r2, r8, r7)
            return
        L80:
            com.google.android.gms.measurement.internal.zznt r7 = r6.zzq()
            java.lang.Object r5 = r7.zzc(r8, r9)
            if (r5 == 0) goto L90
            r0 = r6
            r2 = r8
            r3 = r11
            r0.zza(r1, r2, r3, r5)
        L90:
            return
        L91:
            r5 = 0
            r0 = r6
            r2 = r8
            r3 = r11
            r0.zza(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zza(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzt()
            r8.zzu()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L60
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L50
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L50
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L35
            r4 = r2
            goto L37
        L35:
            r4 = 0
        L37:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzgm r0 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgs r0 = r0.zzh
            long r4 = r10.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4b
            java.lang.String r11 = "true"
        L4b:
            r0.zza(r11)
            r6 = r10
            goto L5e
        L50:
            if (r11 != 0) goto L60
            com.google.android.gms.measurement.internal.zzgm r10 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgs r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L5e:
            r3 = r1
            goto L62
        L60:
            r3 = r10
            r6 = r11
        L62:
            com.google.android.gms.measurement.internal.zzho r10 = r8.zzu
            boolean r10 = r10.zzac()
            if (r10 != 0) goto L78
            com.google.android.gms.measurement.internal.zzgb r9 = r8.zzj()
            com.google.android.gms.measurement.internal.zzgd r9 = r9.zzp()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L78:
            com.google.android.gms.measurement.internal.zzho r10 = r8.zzu
            boolean r10 = r10.zzaf()
            if (r10 != 0) goto L81
            return
        L81:
            com.google.android.gms.measurement.internal.zzno r10 = new com.google.android.gms.measurement.internal.zzno
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzla r9 = r8.zzo()
            r9.zza(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }
}
