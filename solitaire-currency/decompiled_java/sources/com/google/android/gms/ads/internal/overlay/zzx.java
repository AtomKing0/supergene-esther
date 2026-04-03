package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzfsy;
import com.google.android.gms.internal.ads.zzfsz;
import com.google.android.gms.internal.ads.zzfta;
import com.google.android.gms.internal.ads.zzftb;
import com.google.android.gms.internal.ads.zzftk;
import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzftn;
import com.google.android.gms.internal.ads.zzfto;
import com.google.android.gms.internal.ads.zzftp;
import com.google.android.gms.internal.ads.zzfuc;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzx {
    private zzftn zzf;

    @Nullable
    private zzcej zzc = null;
    private boolean zze = false;

    @Nullable
    private String zza = null;

    @Nullable
    private zzfta zzd = null;

    @Nullable
    private String zzb = null;

    private final zzftp zzl() {
        zzfto zzftoVarZzc = zzftp.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzftoVarZzc.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzftoVarZzc.zza(this.zzb);
        }
        return zzftoVarZzc.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzw(this);
        }
    }

    public final synchronized void zza(@Nullable zzcej zzcejVar, Context context) {
        this.zzc = zzcejVar;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap map = new HashMap();
        map.put("action", "fetch_completed");
        zze("on_play_store_bind", map);
    }

    public final void zzb() {
        zzfta zzftaVar;
        if (!this.zze || (zzftaVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzftaVar.zza(zzl(), this.zzf);
            zzd("onLMDOverlayCollapse");
        }
    }

    public final void zzc() {
        zzfta zzftaVar;
        if (!this.zze || (zzftaVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfsy zzfsyVarZzc = zzfsz.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzfsyVarZzc.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfsyVarZzc.zza(this.zzb);
        }
        zzftaVar.zzb(zzfsyVarZzc.zzc(), this.zzf);
    }

    @VisibleForTesting
    final void zzd(String str) {
        zze(str, new HashMap());
    }

    @VisibleForTesting
    final void zze(final String str, final Map map) {
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzv
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(str, map);
            }
        });
    }

    @VisibleForTesting
    final void zzf(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.zza(str);
        if (this.zzc != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            zze("onError", map);
        }
    }

    public final void zzg() {
        zzfta zzftaVar;
        if (!this.zze || (zzftaVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzftaVar.zzc(zzl(), this.zzf);
            zzd("onLMDOverlayExpand");
        }
    }

    final /* synthetic */ void zzh(String str, Map map) {
        zzcej zzcejVar = this.zzc;
        if (zzcejVar != null) {
            zzcejVar.zzd(str, map);
        }
    }

    @VisibleForTesting
    final void zzi(zzftm zzftmVar) {
        if (!TextUtils.isEmpty(zzftmVar.zzb())) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue()) {
                this.zza = zzftmVar.zzb();
            }
        }
        switch (zzftmVar.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                break;
            case 8153:
                zzd("onLMDOverlayClicked");
                break;
            case 8155:
                zzd("onLMDOverlayClose");
                break;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzftmVar.zza()));
                zze("onLMDOverlayFailedToOpen", map);
                break;
        }
    }

    public final void zzj(@Nullable zzcej zzcejVar, @Nullable zzftk zzftkVar) {
        if (zzcejVar == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcejVar;
        if (!this.zze && !zzk(zzcejVar.getContext())) {
            zzf("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkC)).booleanValue()) {
            this.zzb = zzftkVar.zzh();
        }
        zzm();
        zzfta zzftaVar = this.zzd;
        if (zzftaVar != null) {
            zzftaVar.zzd(zzftkVar, this.zzf);
        }
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfuc.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzftb.zza(context);
        } catch (NullPointerException e10) {
            com.google.android.gms.ads.internal.util.zze.zza("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
