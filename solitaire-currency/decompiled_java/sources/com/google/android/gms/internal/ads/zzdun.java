package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import com.unity3d.ads.core.domain.InitializeAndroidBoldSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdun {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdqb zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdsu zzl;
    private final VersionInfoParcel zzm;
    private final zzddp zzo;
    private final zzfki zzp;
    private boolean zza = false;
    private boolean zzb = false;

    @GuardedBy("this")
    private boolean zzc = false;
    private final zzbzt zze = new zzbzt();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();

    public zzdun(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdqb zzdqbVar, ScheduledExecutorService scheduledExecutorService, zzdsu zzdsuVar, VersionInfoParcel versionInfoParcel, zzddp zzddpVar, zzfki zzfkiVar) {
        this.zzh = zzdqbVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdsuVar;
        this.zzm = versionInfoParcel;
        this.zzo = zzddpVar;
        this.zzp = zzfkiVar;
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* bridge */ /* synthetic */ void zzj(final zzdun zzdunVar, String str) {
        int i10 = 5;
        final zzfju zzfjuVarZza = zzfjt.zza(zzdunVar.zzf, 5);
        zzfjuVarZza.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final zzfju zzfjuVarZza2 = zzfjt.zza(zzdunVar.zzf, i10);
                zzfjuVarZza2.zzi();
                zzfjuVarZza2.zzd(next);
                final Object obj = new Object();
                final zzbzt zzbztVar = new zzbzt();
                m mVarZzo = zzgcj.zzo(zzbztVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbE)).longValue(), TimeUnit.SECONDS, zzdunVar.zzk);
                zzdunVar.zzl.zzc(next);
                zzdunVar.zzo.zzc(next);
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
                mVarZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdue
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzq(obj, zzbztVar, next, jElapsedRealtime, zzfjuVarZza2);
                    }
                }, zzdunVar.zzi);
                arrayList.add(mVarZzo);
                final zzdum zzdumVar = new zzdum(zzdunVar, obj, next, jElapsedRealtime, zzfjuVarZza2, zzbztVar);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (jSONObjectOptJSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                        int i11 = 0;
                        while (i11 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                            String strOptString = jSONObject2.optString("format", "");
                            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzblf(strOptString, bundle));
                            i11++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdunVar.zzv(next, false, "", 0);
                try {
                    try {
                        final zzfge zzfgeVarZzc = zzdunVar.zzh.zzc(next, new JSONObject());
                        zzdunVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdui
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzn(next, zzdumVar, zzfgeVarZzc, arrayList2);
                            }
                        });
                    } catch (zzffn unused2) {
                        zzdumVar.zze("Failed to create Adapter.");
                    }
                } catch (RemoteException e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                }
                i10 = 5;
            }
            zzgcj.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzduf
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.zza.zzf(zzfjuVarZza);
                    return null;
                }
            }, zzdunVar.zzi);
        } catch (JSONException e11) {
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e11);
            zzdunVar.zzo.zza("MalformedJson");
            zzdunVar.zzl.zza("MalformedJson");
            zzdunVar.zze.zzd(e11);
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e11, "AdapterInitializer.updateAdapterStatus");
            zzfki zzfkiVar = zzdunVar.zzp;
            zzfjuVarZza.zzh(e11);
            zzfjuVarZza.zzg(false);
            zzfkiVar.zzb(zzfjuVarZza.zzm());
        }
    }

    private final synchronized m zzu() {
        String strZzc = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzc();
        if (!TextUtils.isEmpty(strZzc)) {
            return zzgcj.zzh(strZzc);
        }
        final zzbzt zzbztVar = new zzbzt();
        com.google.android.gms.ads.internal.zzu.zzo().zzi().zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdug
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo(zzbztVar);
            }
        });
        return zzbztVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z10, String str2, int i10) {
        this.zzn.put(str, new zzbkv(str, z10, i10, str2));
    }

    final /* synthetic */ Object zzf(zzfju zzfjuVar) throws Exception {
        this.zze.zzc(Boolean.TRUE);
        zzfjuVar.zzg(true);
        this.zzp.zzb(zzfjuVar.zzm());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbkv zzbkvVar = (zzbkv) this.zzn.get(str);
            arrayList.add(new zzbkv(str, zzbkvVar.zzb, zzbkvVar.zzc, zzbkvVar.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    final /* synthetic */ void zzm() {
        synchronized (this) {
            if (this.zzc) {
                return;
            }
            zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - this.zzd));
            this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zze.zzd(new Exception());
        }
    }

    final /* synthetic */ void zzn(String str, zzbkz zzbkzVar, zzfge zzfgeVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzbkzVar.zzf();
                    return;
                }
                Context context = (Context) this.zzg.get();
                if (context == null) {
                    context = this.zzf;
                }
                zzfgeVar.zzi(context, zzbkzVar, list);
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            }
        } catch (RemoteException e11) {
            throw new zzfvq(e11);
        } catch (zzffn unused) {
            zzbkzVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
        }
    }

    final /* synthetic */ void zzo(final zzbzt zzbztVar) {
        this.zzi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdud
            @Override // java.lang.Runnable
            public final void run() {
                String strZzc = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzc();
                boolean zIsEmpty = TextUtils.isEmpty(strZzc);
                zzbzt zzbztVar2 = zzbztVar;
                if (zIsEmpty) {
                    zzbztVar2.zzd(new Exception());
                } else {
                    zzbztVar2.zzc(strZzc);
                }
            }
        });
    }

    final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    final /* synthetic */ void zzq(Object obj, zzbzt zzbztVar, String str, long j10, zzfju zzfjuVar) {
        synchronized (obj) {
            if (!zzbztVar.isDone()) {
                zzv(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - j10));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfki zzfkiVar = this.zzp;
                zzfjuVar.zzc(InitializeAndroidBoldSDK.MSG_TIMEOUT);
                zzfjuVar.zzg(false);
                zzfkiVar.zzb(zzfjuVar.zzm());
                zzbztVar.zzc(Boolean.FALSE);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbdy.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbD)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    if (this.zza) {
                        return;
                    }
                    this.zzl.zzf();
                    this.zzo.zzf();
                    this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduj
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzp();
                        }
                    }, this.zzi);
                    this.zza = true;
                    m mVarZzu = zzu();
                    this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduc
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzm();
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbF)).longValue(), TimeUnit.SECONDS);
                    zzgcj.zzr(mVarZzu, new zzdul(this), this.zzi);
                    return;
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(Boolean.FALSE);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzblc zzblcVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduh
            @Override // java.lang.Runnable
            public final void run() {
                zzdun zzdunVar = this.zza;
                try {
                    zzblcVar.zzb(zzdunVar.zzg());
                } catch (RemoteException e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
