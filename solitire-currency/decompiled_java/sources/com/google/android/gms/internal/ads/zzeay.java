package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeay extends zzbuj {
    private final Context zza;
    private final zzgcu zzb;
    private final zzebq zzc;
    private final zzclv zzd;
    private final ArrayDeque zze;
    private final zzfki zzf;
    private final zzbvj zzg;

    public zzeay(Context context, zzgcu zzgcuVar, zzbvj zzbvjVar, zzclv zzclvVar, zzebq zzebqVar, ArrayDeque arrayDeque, zzebn zzebnVar, zzfki zzfkiVar) {
        zzbbw.zza(context);
        this.zza = context;
        this.zzb = zzgcuVar;
        this.zzg = zzbvjVar;
        this.zzc = zzebqVar;
        this.zzd = zzclvVar;
        this.zze = arrayDeque;
        this.zzf = zzfkiVar;
    }

    @Nullable
    private final synchronized zzeav zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzeav zzeavVar = (zzeav) it.next();
            if (zzeavVar.zzc.equals(str)) {
                it.remove();
                return zzeavVar;
            }
        }
        return null;
    }

    private static m zzl(m mVar, zzfjl zzfjlVar, zzbno zzbnoVar, zzfkf zzfkfVar, zzfju zzfjuVar) {
        zzbne zzbneVarZza = zzbnoVar.zza("AFMA_getAdDictionary", zzbnl.zza, new zzbng() { // from class: com.google.android.gms.internal.ads.zzeaq
            @Override // com.google.android.gms.internal.ads.zzbng
            public final Object zza(JSONObject jSONObject) {
                return new zzbvd(jSONObject);
            }
        });
        zzfke.zzd(mVar, zzfjuVar);
        zzfiq zzfiqVarZza = zzfjlVar.zzb(zzfjf.BUILD_URL, mVar).zzf(zzbneVarZza).zza();
        zzfke.zzc(zzfiqVarZza, zzfkfVar, zzfjuVar);
        return zzfiqVarZza;
    }

    private static m zzm(final zzbvb zzbvbVar, zzfjl zzfjlVar, final zzewr zzewrVar) {
        zzgbq zzgbqVar = new zzgbq() { // from class: com.google.android.gms.internal.ads.zzeak
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzewrVar.zzb().zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzi((Bundle) obj), zzbvbVar.zzm);
            }
        };
        return zzfjlVar.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzh(zzbvbVar.zza)).zzf(zzgbqVar).zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzeal
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzn(zzeav zzeavVar) {
        zzo();
        this.zze.addLast(zzeavVar);
    }

    private final synchronized void zzo() {
        int iIntValue = ((Long) zzbdz.zzc.zze()).intValue();
        while (this.zze.size() >= iIntValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(m mVar, zzbuu zzbuuVar, zzbvb zzbvbVar) {
        zzgcj.zzr(zzgcj.zzn(mVar, new zzgbq(this) { // from class: com.google.android.gms.internal.ads.zzear
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh(zzfgh.zza((InputStream) obj));
            }
        }, zzbzo.zza), new zzeau(this, zzbuuVar, zzbvbVar), zzbzo.zzf);
    }

    public final m zzb(final zzbvb zzbvbVar, int i10) {
        if (!((Boolean) zzbdz.zza.zze()).booleanValue()) {
            return zzgcj.zzg(new Exception("Split request is disabled."));
        }
        zzfhb zzfhbVar = zzbvbVar.zzi;
        if (zzfhbVar == null) {
            return zzgcj.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfhbVar.zzc == 0 || zzfhbVar.zzd == 0) {
            return zzgcj.zzg(new Exception("Caching is disabled."));
        }
        zzbno zzbnoVarZzb = com.google.android.gms.ads.internal.zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzewr zzewrVarZzr = this.zzd.zzr(zzbvbVar, i10);
        zzfjl zzfjlVarZzc = zzewrVarZzr.zzc();
        final m mVarZzm = zzm(zzbvbVar, zzfjlVarZzc, zzewrVarZzr);
        zzfkf zzfkfVarZzd = zzewrVarZzr.zzd();
        final zzfju zzfjuVarZza = zzfjt.zza(this.zza, 9);
        final m mVarZzl = zzl(mVarZzm, zzfjlVarZzc, zzbnoVarZzb, zzfkfVarZzd, zzfjuVarZza);
        return zzfjlVarZzc.zza(zzfjf.GET_URL_AND_CACHE_KEY, mVarZzm, mVarZzl).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeao
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzj(mVarZzl, mVarZzm, zzbvbVar, zzfjuVarZza);
            }
        }).zza();
    }

    public final m zzc(final zzbvb zzbvbVar, int i10) {
        zzeav zzeavVarZzk;
        zzfiq zzfiqVarZza;
        zzbno zzbnoVarZzb = com.google.android.gms.ads.internal.zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzewr zzewrVarZzr = this.zzd.zzr(zzbvbVar, i10);
        zzbne zzbneVarZza = zzbnoVarZzb.zza("google.afma.response.normalize", zzeax.zza, zzbnl.zzb);
        if (((Boolean) zzbdz.zza.zze()).booleanValue()) {
            zzeavVarZzk = zzk(zzbvbVar.zzh);
            if (zzeavVarZzk == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbvbVar.zzj;
            zzeavVarZzk = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzfju zzfjuVarZza = zzeavVarZzk == null ? zzfjt.zza(this.zza, 9) : zzeavVarZzk.zzd;
        zzfkf zzfkfVarZzd = zzewrVarZzr.zzd();
        zzfkfVarZzd.zzd(zzbvbVar.zza.getStringArrayList("ad_types"));
        zzebp zzebpVar = new zzebp(zzbvbVar.zzg, zzfkfVarZzd, zzfjuVarZza);
        zzebm zzebmVar = new zzebm(this.zza, zzbvbVar.zzb.afmaVersion, this.zzg, i10);
        zzfjl zzfjlVarZzc = zzewrVarZzr.zzc();
        zzfju zzfjuVarZza2 = zzfjt.zza(this.zza, 11);
        if (zzeavVarZzk == null) {
            final m mVarZzm = zzm(zzbvbVar, zzfjlVarZzc, zzewrVarZzr);
            final m mVarZzl = zzl(mVarZzm, zzfjlVarZzc, zzbnoVarZzb, zzfkfVarZzd, zzfjuVarZza);
            zzfju zzfjuVarZza3 = zzfjt.zza(this.zza, 10);
            final zzfiq zzfiqVarZza2 = zzfjlVarZzc.zza(zzfjf.HTTP, mVarZzl, mVarZzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeam
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzbvb zzbvbVar2;
                    Bundle bundle;
                    zzbvd zzbvdVar = (zzbvd) mVarZzl.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && (bundle = (zzbvbVar2 = zzbvbVar).zzm) != null) {
                        bundle.putLong(zzdrt.GET_AD_DICTIONARY_SDKCORE_START.zza(), zzbvdVar.zzc());
                        zzbvbVar2.zzm.putLong(zzdrt.GET_AD_DICTIONARY_SDKCORE_END.zza(), zzbvdVar.zzb());
                    }
                    return new zzebo((JSONObject) mVarZzm.get(), zzbvdVar);
                }
            }).zze(zzebpVar).zze(new zzfka(zzfjuVarZza3)).zze(zzebmVar).zza();
            zzfke.zza(zzfiqVarZza2, zzfkfVarZzd, zzfjuVarZza3);
            zzfke.zzd(zzfiqVarZza2, zzfjuVarZza2);
            zzfiqVarZza = zzfjlVarZzc.zza(zzfjf.PRE_PROCESS, mVarZzm, mVarZzl, zzfiqVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzean
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvbVar.zzm) != null) {
                        bundle.putLong(zzdrt.HTTP_RESPONSE_READY.zza(), com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis());
                    }
                    return new zzeax((zzebl) zzfiqVarZza2.get(), (JSONObject) mVarZzm.get(), (zzbvd) mVarZzl.get());
                }
            }).zzf(zzbneVarZza).zza();
        } else {
            zzebo zzeboVar = new zzebo(zzeavVarZzk.zzb, zzeavVarZzk.zza);
            zzfju zzfjuVarZza4 = zzfjt.zza(this.zza, 10);
            final zzfiq zzfiqVarZza3 = zzfjlVarZzc.zzb(zzfjf.HTTP, zzgcj.zzh(zzeboVar)).zze(zzebpVar).zze(new zzfka(zzfjuVarZza4)).zze(zzebmVar).zza();
            zzfke.zza(zzfiqVarZza3, zzfkfVarZzd, zzfjuVarZza4);
            final m mVarZzh = zzgcj.zzh(zzeavVarZzk);
            zzfke.zzd(zzfiqVarZza3, zzfjuVarZza2);
            zzfiqVarZza = zzfjlVarZzc.zza(zzfjf.PRE_PROCESS, zzfiqVarZza3, mVarZzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeaj
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzebl zzeblVar = (zzebl) zzfiqVarZza3.get();
                    m mVar = mVarZzh;
                    return new zzeax(zzeblVar, ((zzeav) mVar.get()).zzb, ((zzeav) mVar.get()).zza);
                }
            }).zzf(zzbneVarZza).zza();
        }
        zzfke.zza(zzfiqVarZza, zzfkfVarZzd, zzfjuVarZza2);
        return zzfiqVarZza;
    }

    public final m zzd(final zzbvb zzbvbVar, int i10) {
        zzbno zzbnoVarZzb = com.google.android.gms.ads.internal.zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbee.zza.zze()).booleanValue()) {
            return zzgcj.zzg(new Exception("Signal collection disabled."));
        }
        zzewr zzewrVarZzr = this.zzd.zzr(zzbvbVar, i10);
        final zzevr zzevrVarZza = zzewrVarZzr.zza();
        zzbne zzbneVarZza = zzbnoVarZzb.zza("google.afma.request.getSignals", zzbnl.zza, zzbnl.zzb);
        zzfju zzfjuVarZza = zzfjt.zza(this.zza, 22);
        zzfiq zzfiqVarZza = zzewrVarZzr.zzc().zzb(zzfjf.GET_SIGNALS, zzgcj.zzh(zzbvbVar.zza)).zze(new zzfka(zzfjuVarZza)).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzeas
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) throws JSONException {
                return zzevrVarZza.zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzi((Bundle) obj), zzbvbVar.zzm);
            }
        }).zzb(zzfjf.JS_SIGNALS).zzf(zzbneVarZza).zza();
        zzfkf zzfkfVarZzd = zzewrVarZzr.zzd();
        zzfkfVarZzd.zzd(zzbvbVar.zza.getStringArrayList("ad_types"));
        zzfkfVarZzd.zzf(zzbvbVar.zza.getBundle("extras"));
        zzfke.zzb(zzfiqVarZza, zzfkfVarZzd, zzfjuVarZza);
        if (((Boolean) zzbds.zzg.zze()).booleanValue()) {
            zzebq zzebqVar = this.zzc;
            Objects.requireNonNull(zzebqVar);
            zzfiqVarZza.addListener(new zzeap(zzebqVar), this.zzb);
        }
        return zzfiqVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zze(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        zzp(zzb(zzbvbVar, Binder.getCallingUid()), zzbuuVar, zzbvbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzf(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvbVar.zzm) != null) {
            bundle.putLong(zzdrt.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis());
        }
        zzp(zzd(zzbvbVar, Binder.getCallingUid()), zzbuuVar, zzbvbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzg(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvbVar.zzm) != null) {
            bundle.putLong(zzdrt.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis());
        }
        m mVarZzc = zzc(zzbvbVar, Binder.getCallingUid());
        zzp(mVarZzc, zzbuuVar, zzbvbVar);
        if (((Boolean) zzbds.zze.zze()).booleanValue()) {
            zzebq zzebqVar = this.zzc;
            Objects.requireNonNull(zzebqVar);
            mVarZzc.addListener(new zzeap(zzebqVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzh(String str, zzbuu zzbuuVar) {
        zzp(zzi(str), zzbuuVar, null);
    }

    public final m zzi(String str) {
        if (((Boolean) zzbdz.zza.zze()).booleanValue()) {
            return zzk(str) == null ? zzgcj.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzgcj.zzh(new zzeat(this));
        }
        return zzgcj.zzg(new Exception("Split request is disabled."));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream zzj(m mVar, m mVar2, zzbvb zzbvbVar, zzfju zzfjuVar) throws Exception {
        String strZze = ((zzbvd) mVar.get()).zze();
        zzn(new zzeav((zzbvd) mVar.get(), (JSONObject) mVar2.get(), zzbvbVar.zzh, strZze, zzfjuVar));
        return new ByteArrayInputStream(strZze.getBytes(zzfuj.zzc));
    }
}
