package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvt implements com.google.android.gms.ads.internal.overlay.zzp, zzcfz {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private zzdvi zzc;
    private zzcej zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzda zzh;
    private boolean zzi;

    zzdvt(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = versionInfoParcel;
    }

    private final synchronized boolean zzl(com.google.android.gms.ads.internal.client.zzda zzdaVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Ad inspector had an internal error.");
            try {
                zzdaVar.zze(zzfgi.zzd(16, null, null));
            } catch (RemoteException unused) {
            }
            return false;
        }
        if (this.zzc == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Ad inspector had an internal error.");
            try {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                zzdaVar.zze(zzfgi.zzd(16, null, null));
            } catch (RemoteException unused2) {
            }
            return false;
        }
        if (!this.zze && !this.zzf) {
            if (com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() >= this.zzg + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzid)).intValue())) {
                return true;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Ad inspector cannot be opened because it is already open.");
        try {
            zzdaVar.zze(zzfgi.zzd(19, null, null));
        } catch (RemoteException unused3) {
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfz
    public final synchronized void zza(boolean z10, int i10, String str, String str2) {
        if (z10) {
            com.google.android.gms.ads.internal.util.zze.zza("Ad inspector loaded.");
            this.zze = true;
            zzk("");
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Ad inspector failed to load.");
        try {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(new Exception("Failed to load UI. Error code: " + i10 + ", Description: " + str + ", Failing URL: " + str2), "InspectorUi.onAdWebViewFinishedLoading 0");
            com.google.android.gms.ads.internal.client.zzda zzdaVar = this.zzh;
            if (zzdaVar != null) {
                zzdaVar.zze(zzfgi.zzd(17, null, null));
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzdr() {
        this.zzf = true;
        zzk("");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzdu(int i10) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            com.google.android.gms.ads.internal.client.zzda zzdaVar = this.zzh;
            if (zzdaVar != null) {
                try {
                    zzdaVar.zze(null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0L;
        this.zzi = false;
        this.zzh = null;
    }

    @Nullable
    public final Activity zzg() {
        zzcej zzcejVar = this.zzd;
        if (zzcejVar == null || zzcejVar.zzaE()) {
            return null;
        }
        return this.zzd.zzi();
    }

    public final void zzh(zzdvi zzdviVar) {
        this.zzc = zzdviVar;
    }

    final /* synthetic */ void zzi(String str) {
        JSONObject jSONObjectZze = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObjectZze.put("redirectUrl", str);
            } catch (JSONException unused) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", jSONObjectZze.toString());
    }

    public final synchronized void zzj(com.google.android.gms.ads.internal.client.zzda zzdaVar, zzbjr zzbjrVar, zzbjk zzbjkVar, zzbiy zzbiyVar) {
        if (zzl(zzdaVar)) {
            try {
                com.google.android.gms.ads.internal.zzu.zzz();
                zzcej zzcejVarZza = zzcew.zza(this.zza, zzcgd.zza(), "", false, false, null, null, this.zzb, null, null, null, zzbav.zza(), null, null, null, null);
                this.zzd = zzcejVarZza;
                zzcgb zzcgbVarZzN = zzcejVarZza.zzN();
                if (zzcgbVarZzN == null) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to obtain a web view for the ad inspector");
                    try {
                        com.google.android.gms.ads.internal.zzu.zzo().zzw(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                        zzdaVar.zze(zzfgi.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                        return;
                    } catch (RemoteException e10) {
                        com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "InspectorUi.openInspector 3");
                        return;
                    }
                }
                this.zzh = zzdaVar;
                zzcgbVarZzN.zzR(null, null, null, null, null, false, null, null, null, null, null, null, null, zzbjrVar, null, new zzbjq(this.zza), zzbjkVar, zzbiyVar, null);
                zzcgbVarZzN.zzB(this);
                this.zzd.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzib));
                com.google.android.gms.ads.internal.zzu.zzi();
                com.google.android.gms.ads.internal.overlay.zzn.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                this.zzg = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
            } catch (zzcev e11) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to obtain a web view for the ad inspector", e11);
                try {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e11, "InspectorUi.openInspector 0");
                    zzdaVar.zze(zzfgi.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                } catch (RemoteException e12) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e12, "InspectorUi.openInspector 1");
                }
            }
        }
    }

    public final synchronized void zzk(final String str) {
        if (this.zze && this.zzf) {
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdvs
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(str);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdH() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdq() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdt() {
    }
}
