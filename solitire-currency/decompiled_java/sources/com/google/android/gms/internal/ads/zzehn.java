package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzehn implements zzehh {
    private final zzdhl zza;
    private final zzgcu zzb;
    private final zzdlr zzc;
    private final zzfgf zzd;
    private final zzdog zze;

    public zzehn(zzdhl zzdhlVar, zzgcu zzgcuVar, zzdlr zzdlrVar, zzfgf zzfgfVar, zzdog zzdogVar) {
        this.zza = zzdhlVar;
        this.zzb = zzgcuVar;
        this.zzc = zzdlrVar;
        this.zzd = zzfgfVar;
        this.zze = zzdogVar;
    }

    private final m zzg(final zzfex zzfexVar, final zzfel zzfelVar, final JSONObject jSONObject) {
        zzdlr zzdlrVar = this.zzc;
        final m mVarZza = this.zzd.zza();
        final m mVarZza2 = zzdlrVar.zza(zzfexVar, zzfelVar, jSONObject);
        return zzgcj.zzc(mVarZza, mVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzehi
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(mVarZza2, mVarZza, zzfexVar, zzfelVar, jSONObject);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final m zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        return zzgcj.zzn(zzgcj.zzn(this.zzd.zza(), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzehk
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zze(zzfelVar, (zzdoa) obj);
            }
        }, this.zzb), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzehl
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzf(zzfexVar, zzfelVar, (JSONArray) obj);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzfeq zzfeqVar = zzfelVar.zzs;
        return (zzfeqVar == null || zzfeqVar.zzc == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzdiw zzc(m mVar, m mVar2, zzfex zzfexVar, zzfel zzfelVar, JSONObject jSONObject) throws Exception {
        zzdjb zzdjbVar = (zzdjb) mVar.get();
        zzdoa zzdoaVar = (zzdoa) mVar2.get();
        zzdjc zzdjcVarZzd = this.zza.zzd(new zzcsk(zzfexVar, zzfelVar, null), new zzdjn(zzdjbVar), new zzdia(jSONObject, zzdoaVar));
        zzdjcVarZzd.zzh().zzb();
        zzdjcVarZzd.zzi().zza(zzdoaVar);
        zzdjcVarZzd.zzg().zza(zzdjbVar.zzs());
        zzdjcVarZzd.zzl().zza(this.zze, zzdjbVar.zzq());
        return zzdjcVarZzd.zza();
    }

    final /* synthetic */ m zzd(zzdoa zzdoaVar, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzgcj.zzh(zzdoaVar));
        if (jSONObject.optBoolean("success")) {
            return zzgcj.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbnd("process json failed");
    }

    final /* synthetic */ m zze(zzfel zzfelVar, final zzdoa zzdoaVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhN)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfelVar.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgcj.zzn(zzdoaVar.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzehj
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzd(zzdoaVar, (JSONObject) obj);
            }
        }, this.zzb);
    }

    final /* synthetic */ m zzf(zzfex zzfexVar, zzfel zzfelVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzgcj.zzg(new zzdwl(3));
        }
        if (zzfexVar.zza.zza.zzk <= 1) {
            return zzgcj.zzm(zzg(zzfexVar, zzfelVar, jSONArray.getJSONObject(0)), new zzful() { // from class: com.google.android.gms.internal.ads.zzehm
                @Override // com.google.android.gms.internal.ads.zzful
                public final Object apply(Object obj) {
                    return Collections.singletonList(zzgcj.zzh((zzdiw) obj));
                }
            }, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfexVar.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfexVar.zza.zza.zzk);
        for (int i10 = 0; i10 < zzfexVar.zza.zza.zzk; i10++) {
            if (i10 < length) {
                arrayList.add(zzg(zzfexVar, zzfelVar, jSONArray.getJSONObject(i10)));
            } else {
                arrayList.add(zzgcj.zzg(new zzdwl(3)));
            }
        }
        return zzgcj.zzh(arrayList);
    }
}
