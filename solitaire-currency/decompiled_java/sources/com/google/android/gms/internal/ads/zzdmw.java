package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmw {
    private final zzffg zza;
    private final Executor zzb;
    private final zzdpl zzc;
    private final zzdog zzd;
    private final Context zze;
    private final zzdsk zzf;
    private final zzfll zzg;
    private final zzedh zzh;

    public zzdmw(zzffg zzffgVar, Executor executor, zzdpl zzdplVar, Context context, zzdsk zzdskVar, zzfll zzfllVar, zzedh zzedhVar, zzdog zzdogVar) {
        this.zza = zzffgVar;
        this.zzb = executor;
        this.zzc = zzdplVar;
        this.zze = context;
        this.zzf = zzdskVar;
        this.zzg = zzfllVar;
        this.zzh = zzedhVar;
        this.zzd = zzdogVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzh(zzcej zzcejVar) {
        zzj(zzcejVar);
        zzcejVar.zzag("/video", zzbiw.zzl);
        zzcejVar.zzag("/videoMeta", zzbiw.zzm);
        zzcejVar.zzag("/precache", new zzccw());
        zzcejVar.zzag("/delayPageLoaded", zzbiw.zzp);
        zzcejVar.zzag("/instrument", zzbiw.zzn);
        zzcejVar.zzag("/log", zzbiw.zzg);
        zzcejVar.zzag("/click", new zzbhv(null, 0 == true ? 1 : 0));
        if (this.zza.zzb != null) {
            zzcejVar.zzN().zzE(true);
            zzcejVar.zzag("/open", new zzbjj(null, null, null, null, null));
        } else {
            zzcejVar.zzN().zzE(false);
        }
        if (com.google.android.gms.ads.internal.zzu.zzn().zzp(zzcejVar.getContext())) {
            Map map = new HashMap();
            if (zzcejVar.zzD() != null) {
                map = zzcejVar.zzD().zzaw;
            }
            zzcejVar.zzag("/logScionEvent", new zzbjd(zzcejVar.getContext(), map));
        }
    }

    private final void zzi(zzcej zzcejVar, zzbzs zzbzsVar) {
        if (this.zza.zza != null && zzcejVar.zzq() != null) {
            zzcejVar.zzq().zzs(this.zza.zza);
        }
        zzbzsVar.zzb();
    }

    private static final void zzj(zzcej zzcejVar) {
        zzcejVar.zzag("/videoClicked", zzbiw.zzh);
        zzcejVar.zzN().zzG(true);
        zzcejVar.zzag("/getNativeAdViewSignals", zzbiw.zzs);
        zzcejVar.zzag("/getNativeClickMeta", zzbiw.zzt);
    }

    public final m zza(final JSONObject jSONObject) {
        return zzgcj.zzn(zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdmn
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zze(obj);
            }
        }, this.zzb), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdmm
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc(jSONObject, (zzcej) obj);
            }
        }, this.zzb);
    }

    public final m zzb(final String str, final String str2, final zzfel zzfelVar, final zzfeo zzfeoVar, final com.google.android.gms.ads.internal.client.zzq zzqVar) {
        return zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdml
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzd(zzqVar, zzfelVar, zzfeoVar, str, str2, obj);
            }
        }, this.zzb);
    }

    final /* synthetic */ m zzc(JSONObject jSONObject, final zzcej zzcejVar) throws Exception {
        final zzbzs zzbzsVarZza = zzbzs.zza(zzcejVar);
        if (this.zza.zzb != null) {
            zzcejVar.zzaj(zzcgd.zzd());
        } else {
            zzcejVar.zzaj(zzcgd.zze());
        }
        zzcejVar.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdmo
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z10, int i10, String str, String str2) {
                this.zza.zzf(zzcejVar, zzbzsVarZza, z10, i10, str, str2);
            }
        });
        zzcejVar.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zzbzsVarZza;
    }

    final /* synthetic */ m zzd(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfel zzfelVar, zzfeo zzfeoVar, String str, String str2, Object obj) throws Exception {
        final zzcej zzcejVarZza = this.zzc.zza(zzqVar, zzfelVar, zzfeoVar);
        final zzbzs zzbzsVarZza = zzbzs.zza(zzcejVarZza);
        if (this.zza.zzb != null) {
            zzh(zzcejVarZza);
            zzcejVarZza.zzaj(zzcgd.zzd());
        } else {
            zzdod zzdodVarZzb = this.zzd.zzb();
            zzcejVarZza.zzN().zzR(zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(this.zze, null, null), null, null, this.zzh, this.zzg, this.zzf, null, zzdodVarZzb, null, null, null, null);
            zzj(zzcejVarZza);
        }
        zzcejVarZza.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdmp
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z10, int i10, String str3, String str4) {
                this.zza.zzg(zzcejVarZza, zzbzsVarZza, z10, i10, str3, str4);
            }
        });
        zzcejVarZza.zzae(str, str2, null);
        return zzbzsVarZza;
    }

    final /* synthetic */ m zze(Object obj) throws Exception {
        zzcej zzcejVarZza = this.zzc.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        final zzbzs zzbzsVarZza = zzbzs.zza(zzcejVarZza);
        zzh(zzcejVarZza);
        zzcejVarZza.zzN().zzH(new zzcga() { // from class: com.google.android.gms.internal.ads.zzdmq
            @Override // com.google.android.gms.internal.ads.zzcga
            public final void zza() {
                zzbzsVarZza.zzb();
            }
        });
        zzcejVarZza.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzds));
        return zzbzsVarZza;
    }

    final /* synthetic */ void zzf(zzcej zzcejVar, zzbzs zzbzsVar, boolean z10, int i10, String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdA)).booleanValue()) {
            zzi(zzcejVar, zzbzsVar);
            return;
        }
        if (z10) {
            zzi(zzcejVar, zzbzsVar);
            return;
        }
        zzbzsVar.zzd(new zzeir(1, "Native Video WebView failed to load. Error code: " + i10 + ", Description: " + str + ", Failing URL: " + str2));
    }

    final /* synthetic */ void zzg(zzcej zzcejVar, zzbzs zzbzsVar, boolean z10, int i10, String str, String str2) {
        if (z10) {
            if (this.zza.zza != null && zzcejVar.zzq() != null) {
                zzcejVar.zzq().zzs(this.zza.zza);
            }
            zzbzsVar.zzb();
            return;
        }
        zzbzsVar.zzd(new zzeir(1, "Html video Web View failed to load. Error code: " + i10 + ", Description: " + str + ", Failing URL: " + str2));
    }
}
