package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewFeature;
import com.ironsource.v8;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrr implements zzczo, zzcye, zzcwt, zzdfc {
    private final zzdsf zza;
    private final zzdsp zzb;

    public zzdrr(zzdsf zzdsfVar, zzdsp zzdspVar) {
        this.zza = zzdsfVar;
        this.zzb = zzdspVar;
    }

    private final void zzc(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            long j10 = bundle.getLong(str);
            if (j10 >= 0) {
                this.zza.zzc(str, String.valueOf(j10));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzd(Bundle bundle, zzfxr zzfxrVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue() || bundle == null) {
            return;
        }
        bundle.putLong(zzdrt.PUBLIC_API_CALLBACK.zza(), com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis());
        this.zza.zzc("ls", true != bundle.getBoolean("ls") ? "0" : "1");
        int size = zzfxrVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            zzdru zzdruVar = (zzdru) zzfxrVar.get(i10);
            long j10 = bundle.getLong(zzdruVar.zza().zza(), -1L);
            long j11 = bundle.getLong(zzdruVar.zzb().zza(), -1L);
            if (j10 > 0 && j11 > 0) {
                this.zza.zzc(zzdruVar.zzc(), String.valueOf(j11 - j10));
            }
        }
        zzc(bundle.getBundle("client_sig_latency_key"));
        zzc(bundle.getBundle("gms_sig_latency_key"));
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zza.zzb().put("action", "ftl");
        this.zza.zzc("ftl", String.valueOf(zzeVar.zza));
        this.zza.zzc("ed", zzeVar.zzc);
        this.zzb.zzf(this.zza.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
        this.zza.zze(zzbvbVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
        this.zza.zzd(zzfexVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zze(@Nullable com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar) {
        String str;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgo)).booleanValue()) {
            if (zzayVar == null) {
                this.zza.zzb().put("action", "sgs");
                this.zza.zzb().put("request_id", "-1");
                this.zzb.zzf(this.zza.zzb());
                return;
            }
            zzbvb zzbvbVar = zzayVar.zzc;
            if (zzbvbVar != null) {
                zzd(zzbvbVar.zzm, zzdru.zza);
            }
            try {
                JSONObject jSONObject = new JSONObject(zzayVar.zzb);
                this.zza.zzb().put("action", "sgs");
                Map mapZzb = this.zza.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziM)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e10) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzh("Error retrieving JSONObject from the requestJson, ", e10);
                        str = "na";
                    }
                } else {
                    str = "na";
                }
                mapZzb.put("tpc", str);
                zzbvb zzbvbVar2 = zzayVar.zzc;
                if (zzbvbVar2 != null) {
                    this.zza.zze(zzbvbVar2.zza);
                }
                this.zzb.zzf(this.zza.zzb());
            } catch (JSONException unused) {
                this.zza.zzb().put("action", "sgf");
                this.zza.zzb().put("sgf_reason", "request_invalid");
                this.zzb.zzf(this.zza.zzb());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zzf(@Nullable String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgo)).booleanValue()) {
            this.zza.zzb().put("action", "sgf");
            this.zza.zzc("sgf_reason", str);
            this.zzb.zzf(this.zza.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        this.zza.zzb().put("action", v8.h.f15813r);
        zzd(this.zza.zza(), zzdru.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlG)).booleanValue()) {
            this.zza.zzb().put("mafe", true != WebViewFeature.isFeatureSupported(WebViewFeature.MUTE_AUDIO) ? "0" : "1");
        }
        this.zzb.zzf(this.zza.zzb());
    }
}
