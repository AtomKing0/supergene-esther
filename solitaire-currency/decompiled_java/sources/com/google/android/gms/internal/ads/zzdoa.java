package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdoa {
    private final com.google.android.gms.ads.internal.zza zzb;
    private final Context zzc;
    private final zzdsk zzd;
    private final Executor zze;
    private final zzauo zzf;
    private final VersionInfoParcel zzg;
    private final zzedh zzi;
    private final zzfll zzj;
    private final zzeds zzk;
    private final zzffk zzl;
    private m zzm;
    private final zzdnn zza = new zzdnn();
    private final zzbjn zzh = new zzbjn();

    zzdoa(zzdnx zzdnxVar) {
        this.zzc = zzdnxVar.zzb;
        this.zze = zzdnxVar.zze;
        this.zzf = zzdnxVar.zzf;
        this.zzg = zzdnxVar.zzg;
        this.zzb = zzdnxVar.zza;
        this.zzi = zzdnxVar.zzd;
        this.zzj = zzdnxVar.zzh;
        this.zzd = zzdnxVar.zzc;
        this.zzk = zzdnxVar.zzi;
        this.zzl = zzdnxVar.zzj;
    }

    final /* synthetic */ zzcej zza(zzcej zzcejVar) {
        zzcejVar.zzag("/result", this.zzh);
        zzcgb zzcgbVarZzN = zzcejVar.zzN();
        com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzc, null, null);
        zzedh zzedhVar = this.zzi;
        zzfll zzfllVar = this.zzj;
        zzdsk zzdskVar = this.zzd;
        zzdnn zzdnnVar = this.zza;
        zzcgbVarZzN.zzR(null, zzdnnVar, zzdnnVar, zzdnnVar, zzdnnVar, false, null, zzbVar, null, null, zzedhVar, zzfllVar, zzdskVar, null, null, null, null, null, null);
        return zzcejVar;
    }

    final /* synthetic */ m zzf(String str, JSONObject jSONObject, zzcej zzcejVar) throws Exception {
        return this.zzh.zzb(zzcejVar, str, jSONObject);
    }

    public final synchronized m zzg(final String str, final JSONObject jSONObject) {
        m mVar = this.zzm;
        if (mVar == null) {
            return zzgcj.zzh(null);
        }
        return zzgcj.zzn(mVar, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdno
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzf(str, jSONObject, (zzcej) obj);
            }
        }, this.zze);
    }

    public final synchronized void zzh(zzfel zzfelVar, zzfeo zzfeoVar, zzcni zzcniVar) {
        m mVar = this.zzm;
        if (mVar == null) {
            return;
        }
        zzgcj.zzr(mVar, new zzdnu(this, zzfelVar, zzfeoVar, zzcniVar), this.zze);
    }

    public final synchronized void zzi() {
        m mVar = this.zzm;
        if (mVar == null) {
            return;
        }
        zzgcj.zzr(mVar, new zzdnq(this), this.zze);
        this.zzm = null;
    }

    public final synchronized void zzj(String str, Map map) {
        m mVar = this.zzm;
        if (mVar == null) {
            return;
        }
        zzgcj.zzr(mVar, new zzdnt(this, "sendMessageToNativeJs", map), this.zze);
    }

    public final synchronized void zzk() {
        final String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdr);
        final Context context = this.zzc;
        final zzauo zzauoVar = this.zzf;
        final VersionInfoParcel versionInfoParcel = this.zzg;
        final com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        final zzeds zzedsVar = this.zzk;
        final zzffk zzffkVar = this.zzl;
        m mVarZzm = zzgcj.zzm(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzceu
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final m zza() throws zzcev {
                com.google.android.gms.ads.internal.zzu.zzz();
                Context context2 = context;
                zzcgd zzcgdVarZza = zzcgd.zza();
                zzauo zzauoVar2 = zzauoVar;
                zzeds zzedsVar2 = zzedsVar;
                com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                zzcej zzcejVarZza = zzcew.zza(context2, zzcgdVarZza, "", false, false, zzauoVar2, null, versionInfoParcel, null, null, zzaVar2, zzbav.zza(), null, null, zzedsVar2, zzffkVar);
                final zzbzs zzbzsVarZza = zzbzs.zza(zzcejVarZza);
                zzcejVarZza.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzcet
                    @Override // com.google.android.gms.internal.ads.zzcfz
                    public final void zza(boolean z10, int i10, String str2, String str3) {
                        zzbzsVarZza.zzb();
                    }
                });
                zzcejVarZza.loadUrl(str);
                return zzbzsVarZza;
            }
        }, zzbzo.zze), new zzful() { // from class: com.google.android.gms.internal.ads.zzdnp
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzcej zzcejVar = (zzcej) obj;
                this.zza.zza(zzcejVar);
                return zzcejVar;
            }
        }, this.zze);
        this.zzm = mVarZzm;
        zzbzr.zza(mVarZzm, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzbix zzbixVar) {
        m mVar = this.zzm;
        if (mVar == null) {
            return;
        }
        zzgcj.zzr(mVar, new zzdnr(this, str, zzbixVar), this.zze);
    }

    public final void zzm(WeakReference weakReference, String str, zzbix zzbixVar) {
        zzl(str, new zzdnz(this, weakReference, str, zzbixVar, null));
    }

    public final synchronized void zzn(String str, zzbix zzbixVar) {
        m mVar = this.zzm;
        if (mVar == null) {
            return;
        }
        zzgcj.zzr(mVar, new zzdns(this, str, zzbixVar), this.zze);
    }
}
