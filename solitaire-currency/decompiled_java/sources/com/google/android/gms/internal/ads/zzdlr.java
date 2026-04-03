package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import com.ironsource.w8;
import io.sentry.protocol.DebugMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdlr {
    private final zzgcu zza;
    private final zzdme zzb;
    private final zzdmj zzc;

    public zzdlr(zzgcu zzgcuVar, zzdme zzdmeVar, zzdmj zzdmjVar) {
        this.zza = zzgcuVar;
        this.zzb = zzdmeVar;
        this.zzc = zzdmjVar;
    }

    public final m zza(final zzfex zzfexVar, final zzfel zzfelVar, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        m mVarZzn;
        final m mVarZzb = this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdlp
            @Override // java.util.concurrent.Callable
            public final Object call() throws zzeir {
                zzdjb zzdjbVar = new zzdjb();
                JSONObject jSONObject2 = jSONObject;
                zzdjbVar.zzaa(jSONObject2.optInt("template_id", -1));
                zzdjbVar.zzK(jSONObject2.optString("custom_template_id"));
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("omid_partner_name") : null;
                zzfex zzfexVar2 = zzfexVar;
                zzdjbVar.zzV(strOptString);
                zzffg zzffgVar = zzfexVar2.zza.zza;
                if (!zzffgVar.zzg.contains(Integer.toString(zzdjbVar.zzc()))) {
                    throw new zzeir(1, "Invalid template ID: " + zzdjbVar.zzc());
                }
                if (zzdjbVar.zzc() == 3) {
                    if (zzdjbVar.zzA() == null) {
                        throw new zzeir(1, "No custom template id for custom template ad response.");
                    }
                    if (!zzffgVar.zzh.contains(zzdjbVar.zzA())) {
                        throw new zzeir(1, "Unexpected custom template id in the response.");
                    }
                }
                zzfel zzfelVar2 = zzfelVar;
                zzdjbVar.zzY(jSONObject2.optDouble("rating", -1.0d));
                String strOptString2 = jSONObject2.optString("headline", null);
                if (zzfelVar2.zzM) {
                    com.google.android.gms.ads.internal.zzu.zzp();
                    strOptString2 = com.google.android.gms.ads.internal.util.zzt.zzy() + " : " + strOptString2;
                }
                zzdjbVar.zzZ("headline", strOptString2);
                zzdjbVar.zzZ("body", jSONObject2.optString("body", null));
                zzdjbVar.zzZ("call_to_action", jSONObject2.optString("call_to_action", null));
                zzdjbVar.zzZ(v8.h.U, jSONObject2.optString(v8.h.U, null));
                zzdjbVar.zzZ("price", jSONObject2.optString("price", null));
                zzdjbVar.zzZ(v8.h.F0, jSONObject2.optString(v8.h.F0, null));
                return zzdjbVar;
            }
        });
        final m mVarZzf = this.zzb.zzf(jSONObject, DebugMeta.JsonKeys.IMAGES);
        zzfeo zzfeoVar = zzfexVar.zzb.zzb;
        zzdme zzdmeVar = this.zzb;
        final m mVarZzg = zzdmeVar.zzg(jSONObject, DebugMeta.JsonKeys.IMAGES, zzfelVar, zzfeoVar);
        final m mVarZze = zzdmeVar.zze(jSONObject, "secondary_image");
        final m mVarZze2 = zzdmeVar.zze(jSONObject, "app_icon");
        final m mVarZzd = zzdmeVar.zzd(jSONObject, w8.f16020c);
        final m mVarZzh = this.zzb.zzh(jSONObject, zzfelVar, zzfexVar.zzb.zzb);
        final m mVarZza = this.zzc.zza(jSONObject, "custom_assets");
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            if (TextUtils.isEmpty(strOptString)) {
                mVarZzn = zzgcj.zzh(null);
            } else {
                final zzdme zzdmeVar2 = this.zzb;
                mVarZzn = zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlt
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final m zza(Object obj) {
                        return zzdmeVar2.zzc(strOptString, obj);
                    }
                }, zzbzo.zze);
            }
        } else {
            mVarZzn = zzgcj.zzh(null);
        }
        final m mVar = mVarZzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(mVarZzb);
        arrayList.add(mVarZzf);
        arrayList.add(mVarZzg);
        arrayList.add(mVarZze);
        arrayList.add(mVarZze2);
        arrayList.add(mVarZzd);
        arrayList.add(mVarZzh);
        arrayList.add(mVarZza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
            arrayList.add(mVar);
        }
        return zzgcj.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdlq
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdjb zzdjbVar = (zzdjb) mVarZzb.get();
                zzdjbVar.zzP((List) mVarZzf.get());
                zzdjbVar.zzM((zzbfd) mVarZze2.get());
                zzdjbVar.zzQ((zzbfd) mVarZze.get());
                zzdjbVar.zzJ((zzbew) mVarZzd.get());
                JSONObject jSONObject2 = jSONObject;
                zzdjbVar.zzS(zzdme.zzj(jSONObject2));
                zzdjbVar.zzL(zzdme.zzi(jSONObject2));
                zzcej zzcejVar = (zzcej) mVarZzh.get();
                if (zzcejVar != null) {
                    zzdjbVar.zzad(zzcejVar);
                    zzdjbVar.zzac(zzcejVar.zzF());
                    zzdjbVar.zzab(zzcejVar.zzq());
                }
                zzcej zzcejVar2 = (zzcej) mVarZzg.get();
                if (zzcejVar2 != null) {
                    zzdjbVar.zzO(zzcejVar2);
                    zzdjbVar.zzae(zzcejVar2.zzF());
                }
                m mVar2 = mVar;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
                    zzdjbVar.zzU(mVar2);
                    zzdjbVar.zzX(new zzbzt());
                } else {
                    zzcej zzcejVar3 = (zzcej) mVar2.get();
                    if (zzcejVar3 != null) {
                        zzdjbVar.zzT(zzcejVar3);
                    }
                }
                for (zzdmi zzdmiVar : (List) mVarZza.get()) {
                    if (zzdmiVar.zza != 1) {
                        zzdjbVar.zzN(zzdmiVar.zzb, zzdmiVar.zzd);
                    } else {
                        zzdjbVar.zzZ(zzdmiVar.zzb, zzdmiVar.zzc);
                    }
                }
                return zzdjbVar;
            }
        }, this.zza);
    }
}
