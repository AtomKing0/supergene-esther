package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.measurement.internal.zziq;
import com.ironsource.v8;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgy extends zzmy implements zzag {

    @VisibleForTesting
    final LruCache<String, com.google.android.gms.internal.measurement.zzb> zza;
    final com.google.android.gms.internal.measurement.zzv zzb;
    private final Map<String, Map<String, String>> zzc;

    @VisibleForTesting
    private final Map<String, Set<String>> zzd;

    @VisibleForTesting
    private final Map<String, Map<String, Boolean>> zze;

    @VisibleForTesting
    private final Map<String, Map<String, Boolean>> zzg;
    private final Map<String, zzfn.zzd> zzh;
    private final Map<String, Map<String, Integer>> zzi;
    private final Map<String, String> zzj;
    private final Map<String, String> zzk;
    private final Map<String, String> zzl;

    zzgy(zznd zzndVar) {
        super(zzndVar);
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zza = new zzhe(this, 20);
        this.zzb = new zzhd(this);
    }

    @WorkerThread
    private final void zzv(String str) throws Throwable {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        if (this.zzh.get(str) == null) {
            zzap zzapVarZzf = zzh().zzf(str);
            if (zzapVarZzf != null) {
                zzfn.zzd.zza zzaVarZzby = zza(str, zzapVarZzf.zza).zzby();
                zza(str, zzaVarZzby);
                this.zzc.put(str, zza((zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah())));
                this.zzh.put(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
                zza(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
                this.zzj.put(str, zzaVarZzby.zzc());
                this.zzk.put(str, zzapVarZzf.zzb);
                this.zzl.put(str, zzapVarZzf.zzc);
                return;
            }
            this.zzc.put(str, null);
            this.zze.put(str, null);
            this.zzd.put(str, null);
            this.zzg.put(str, null);
            this.zzh.put(str, null);
            this.zzj.put(str, null);
            this.zzk.put(str, null);
            this.zzl.put(str, null);
            this.zzi.put(str, null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @WorkerThread
    final int zzb(String str, String str2) throws Throwable {
        Integer num;
        zzt();
        zzv(str);
        Map<String, Integer> map = this.zzi.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
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

    @WorkerThread
    final boolean zzp(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("app_instance_id");
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
    final boolean zzu(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("user_id");
    }

    @WorkerThread
    final long zza(String str) throws Throwable {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e10) {
            zzj().zzu().zza("Unable to parse timezone offset. appId", zzgb.zza(str), e10);
            return 0L;
        }
    }

    @WorkerThread
    protected final zzfn.zzd zzc(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzv(str);
        return this.zzh.get(str);
    }

    @WorkerThread
    protected final String zzd(String str) {
        zzt();
        return this.zzl.get(str);
    }

    @WorkerThread
    protected final String zze(String str) {
        zzt();
        return this.zzk.get(str);
    }

    @WorkerThread
    final String zzf(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzj.get(str);
    }

    @WorkerThread
    final Set<String> zzg(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str);
    }

    @WorkerThread
    final SortedSet<String> zzh(String str) {
        zzt();
        zzv(str);
        TreeSet treeSet = new TreeSet();
        zzfn.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return treeSet;
        }
        Iterator<zzfn.zza.zzf> it = zzaVarZzb.zzc().iterator();
        while (it.hasNext()) {
            treeSet.add(it.next().zzb());
        }
        return treeSet;
    }

    @WorkerThread
    protected final void zzi(String str) {
        zzt();
        this.zzk.put(str, null);
    }

    @WorkerThread
    final void zzj(String str) {
        zzt();
        this.zzh.remove(str);
    }

    @WorkerThread
    final boolean zzk(String str) {
        zzt();
        zzfn.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null) {
            return false;
        }
        return zzdVarZzc.zzo();
    }

    public final boolean zzl(String str) {
        zzfn.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.zzh.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    final boolean zzm(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    @WorkerThread
    final boolean zzn(String str) {
        zzt();
        zzv(str);
        zzfn.zza zzaVarZzb = zzb(str);
        return zzaVarZzb == null || !zzaVarZzb.zzh() || zzaVarZzb.zzg();
    }

    final boolean zzo(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @WorkerThread
    final boolean zzq(String str) throws Throwable {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("device_model") || this.zzd.get(str).contains("device_info");
        }
        return false;
    }

    @WorkerThread
    final boolean zzr(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("enhanced_user_id");
    }

    @WorkerThread
    final boolean zzs(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("google_signals");
    }

    @WorkerThread
    final boolean zzt(String str) throws Throwable {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("os_version") || this.zzd.get(str).contains("device_info");
        }
        return false;
    }

    @WorkerThread
    final boolean zzd(String str, String str2) throws Throwable {
        Boolean bool;
        zzt();
        zzv(str);
        if (zzm(str) && zznt.zzg(str2)) {
            return true;
        }
        if (zzo(str) && zznt.zzh(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @WorkerThread
    final zziq.zza zzb(String str, zziq.zza zzaVar) {
        zzt();
        zzv(str);
        zzfn.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return null;
        }
        for (zzfn.zza.zzc zzcVar : zzaVarZzb.zze()) {
            if (zzaVar == zza(zzcVar.zzc())) {
                return zza(zzcVar.zzb());
            }
        }
        return null;
    }

    @WorkerThread
    final boolean zzc(String str, zziq.zza zzaVar) throws Throwable {
        zzt();
        zzv(str);
        zzfn.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return false;
        }
        Iterator<zzfn.zza.zzb> it = zzaVarZzb.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfn.zza.zzb next = it.next();
            if (zzaVar == zza(next.zzc())) {
                if (next.zzb() == zzfn.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static /* synthetic */ com.google.android.gms.internal.measurement.zzb zza(zzgy zzgyVar, String str) throws Throwable {
        zzgyVar.zzak();
        Preconditions.checkNotEmpty(str);
        if (!zzgyVar.zzl(str)) {
            return null;
        }
        if (zzgyVar.zzh.containsKey(str) && zzgyVar.zzh.get(str) != null) {
            zzgyVar.zza(str, zzgyVar.zzh.get(str));
        } else {
            zzgyVar.zzv(str);
        }
        return zzgyVar.zza.snapshot().get(str);
    }

    @WorkerThread
    final zzfn.zza zzb(String str) throws Throwable {
        zzt();
        zzv(str);
        zzfn.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null || !zzdVarZzc.zzp()) {
            return null;
        }
        return zzdVarZzc.zzd();
    }

    @WorkerThread
    final boolean zzc(String str, String str2) throws Throwable {
        Boolean bool;
        zzt();
        zzv(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzg.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    final zzip zza(String str, zziq.zza zzaVar) {
        zzt();
        zzv(str);
        zzfn.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return zzip.UNINITIALIZED;
        }
        for (zzfn.zza.zzb zzbVar : zzaVarZzb.zzf()) {
            if (zza(zzbVar.zzc()) == zzaVar) {
                int i10 = zzhf.zzc[zzbVar.zzb().ordinal()];
                if (i10 == 1) {
                    return zzip.DENIED;
                }
                if (i10 != 2) {
                    return zzip.UNINITIALIZED;
                }
                return zzip.GRANTED;
            }
        }
        return zzip.UNINITIALIZED;
    }

    private static zziq.zza zza(zzfn.zza.zze zzeVar) {
        int i10 = zzhf.zzb[zzeVar.ordinal()];
        if (i10 == 1) {
            return zziq.zza.AD_STORAGE;
        }
        if (i10 == 2) {
            return zziq.zza.ANALYTICS_STORAGE;
        }
        if (i10 == 3) {
            return zziq.zza.AD_USER_DATA;
        }
        if (i10 != 4) {
            return null;
        }
        return zziq.zza.AD_PERSONALIZATION;
    }

    @WorkerThread
    private final zzfn.zzd zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzfn.zzd.zzg();
        }
        try {
            zzfn.zzd zzdVar = (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) ((zzfn.zzd.zza) zznm.zza(zzfn.zzd.zze(), bArr)).zzah());
            zzj().zzp().zza("Parsed config. version, gmp_app_id", zzdVar.zzs() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzq() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzkb e10) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgb.zza(str), e10);
            return zzfn.zzd.zzg();
        } catch (RuntimeException e11) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgb.zza(str), e11);
            return zzfn.zzd.zzg();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzag
    @WorkerThread
    public final String zza(String str, String str2) throws Throwable {
        zzt();
        zzv(str);
        Map<String, String> map = this.zzc.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    private static Map<String, String> zza(zzfn.zzd zzdVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzdVar != null) {
            for (zzfn.zzg zzgVar : zzdVar.zzn()) {
                arrayMap.put(zzgVar.zzb(), zzgVar.zzc());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzfn.zzd.zza zzaVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            Iterator<zzfn.zzb> it = zzaVar.zze().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().zzb());
            }
            for (int i10 = 0; i10 < zzaVar.zza(); i10++) {
                zzfn.zzc.zza zzaVarZzby = zzaVar.zza(i10).zzby();
                if (zzaVarZzby.zzb().isEmpty()) {
                    zzj().zzu().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzaVarZzby.zzb();
                    String strZzb2 = zzit.zzb(zzaVarZzby.zzb());
                    if (!TextUtils.isEmpty(strZzb2)) {
                        zzaVarZzby = zzaVarZzby.zza(strZzb2);
                        zzaVar.zza(i10, zzaVarZzby);
                    }
                    if (zzaVarZzby.zze() && zzaVarZzby.zzc()) {
                        arrayMap.put(strZzb, Boolean.TRUE);
                    }
                    if (zzaVarZzby.zzf() && zzaVarZzby.zzd()) {
                        arrayMap2.put(zzaVarZzby.zzb(), Boolean.TRUE);
                    }
                    if (zzaVarZzby.zzg()) {
                        if (zzaVarZzby.zza() >= 2 && zzaVarZzby.zza() <= 65535) {
                            arrayMap3.put(zzaVarZzby.zzb(), Integer.valueOf(zzaVarZzby.zza()));
                        } else {
                            zzj().zzu().zza("Invalid sampling rate. Event name, sample rate", zzaVarZzby.zzb(), Integer.valueOf(zzaVarZzby.zza()));
                        }
                    }
                }
            }
        }
        this.zzd.put(str, hashSet);
        this.zze.put(str, arrayMap);
        this.zzg.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    @WorkerThread
    private final void zza(final String str, zzfn.zzd zzdVar) {
        if (zzdVar.zza() == 0) {
            this.zza.remove(str);
            return;
        }
        zzj().zzp().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzgb.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgz
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzhg(this.zza, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhc
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzgy zzgyVar = this.zza;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzha
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzgy zzgyVar2 = zzgyVar;
                            String str3 = str2;
                            zzf zzfVarZze = zzgyVar2.zzh().zze(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put(v8.h.V, str3);
                            map.put("gmp_version", 87000L);
                            if (zzfVarZze != null) {
                                String strZzad = zzfVarZze.zzad();
                                if (strZzad != null) {
                                    map.put(App.JsonKeys.APP_VERSION, strZzad);
                                }
                                map.put("app_version_int", Long.valueOf(zzfVarZze.zze()));
                                map.put("dynamite_version", Long.valueOf(zzfVarZze.zzo()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzr(this.zza.zzb);
                }
            });
            zzbVar.zza(zzcVar);
            this.zza.put(str, zzbVar);
            zzj().zzp().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<zzgb.zzb> it = zzcVar.zza().zzd().iterator();
            while (it.hasNext()) {
                zzj().zzp().zza("EES program activity", it.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    @WorkerThread
    protected final boolean zza(String str, byte[] bArr, String str2, String str3) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzfn.zzd.zza zzaVarZzby = zza(str, bArr).zzby();
        if (zzaVarZzby == null) {
            return false;
        }
        zza(str, zzaVarZzby);
        zza(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
        this.zzh.put(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
        this.zzj.put(str, zzaVarZzby.zzc());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzc.put(str, zza((zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah())));
        zzh().zza(str, new ArrayList(zzaVarZzby.zzd()));
        try {
            zzaVarZzby.zzb();
            bArr = ((zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah())).zzbv();
        } catch (RuntimeException e10) {
            zzj().zzu().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzgb.zza(str), e10);
        }
        zzan zzanVarZzh = zzh();
        Preconditions.checkNotEmpty(str);
        zzanVarZzh.zzt();
        zzanVarZzh.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzanVarZzh.e_().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzanVarZzh.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzgb.zza(str));
            }
        } catch (SQLiteException e11) {
            zzanVarZzh.zzj().zzg().zza("Error storing remote config. appId", zzgb.zza(str), e11);
        }
        this.zzh.put(str, (zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzby.zzah()));
        return true;
    }
}
