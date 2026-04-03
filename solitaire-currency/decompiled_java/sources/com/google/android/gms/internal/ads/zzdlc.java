package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdlc implements zzdjj {

    @Nullable
    private final zzbpb zza;
    private final zzcxi zzb;
    private final zzcwo zzc;
    private final zzdeo zzd;
    private final Context zze;
    private final zzfel zzf;
    private final VersionInfoParcel zzg;
    private final zzffg zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;

    @Nullable
    private final zzbox zzl;

    @Nullable
    private final zzboy zzm;

    public zzdlc(@Nullable zzbox zzboxVar, @Nullable zzboy zzboyVar, @Nullable zzbpb zzbpbVar, zzcxi zzcxiVar, zzcwo zzcwoVar, zzdeo zzdeoVar, Context context, zzfel zzfelVar, VersionInfoParcel versionInfoParcel, zzffg zzffgVar) {
        this.zzl = zzboxVar;
        this.zzm = zzboyVar;
        this.zza = zzbpbVar;
        this.zzb = zzcxiVar;
        this.zzc = zzcwoVar;
        this.zzd = zzdeoVar;
        this.zze = context;
        this.zzf = zzfelVar;
        this.zzg = versionInfoParcel;
        this.zzh = zzffgVar;
    }

    private final void zzb(View view) {
        try {
            zzbpb zzbpbVar = this.zza;
            if (zzbpbVar != null && !zzbpbVar.zzA()) {
                this.zza.zzw(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjR)).booleanValue()) {
                    this.zzd.zzdG();
                    return;
                }
                return;
            }
            zzbox zzboxVar = this.zzl;
            if (zzboxVar != null && !zzboxVar.zzx()) {
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjR)).booleanValue()) {
                    this.zzd.zzdG();
                    return;
                }
                return;
            }
            zzboy zzboyVar = this.zzm;
            if (zzboyVar == null || zzboyVar.zzv()) {
                return;
            }
            this.zzm.zzq(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjR)).booleanValue()) {
                this.zzd.zzdG();
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to call handleClick", e10);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            synchronized (map) {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzA() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzB() {
        return this.zzf.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzC(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    @Nullable
    public final JSONObject zze(View view, Map map, Map map2, @Nullable ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    @Nullable
    public final JSONObject zzf(View view, Map map, Map map2, @Nullable ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzj(@Nullable com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzk(View view, @Nullable View view2, @Nullable Map map, @Nullable Map map2, boolean z10, @Nullable ImageView.ScaleType scaleType) {
        if (this.zzj && this.zzf.zzL) {
            return;
        }
        zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzo(View view, View view2, Map map, Map map2, boolean z10, @Nullable ImageView.ScaleType scaleType, int i10) {
        if (!this.zzj) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzf.zzL) {
            zzb(view2);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzq(@Nullable View view, @Nullable Map map, @Nullable Map map2, @Nullable ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = com.google.android.gms.ads.internal.zzu.zzs().zzn(this.zze, this.zzg.afmaVersion, this.zzf.zzC.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbpb zzbpbVar = this.zza;
                if (zzbpbVar != null && !zzbpbVar.zzB()) {
                    this.zza.zzx();
                    this.zzb.zza();
                    return;
                }
                zzbox zzboxVar = this.zzl;
                if (zzboxVar != null && !zzboxVar.zzy()) {
                    this.zzl.zzt();
                    this.zzb.zza();
                    return;
                }
                zzboy zzboyVar = this.zzm;
                if (zzboyVar == null || zzboyVar.zzw()) {
                    return;
                }
                this.zzm.zzr();
                this.zzb.zza();
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to call recordImpression", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzv() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzw(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc A[Catch: JSONException -> 0x0044, RemoteException -> 0x0122, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0044, blocks: (B:47:0x00b1, B:48:0x00c6, B:50:0x00cc), top: B:72:0x00b1 }] */
    @Override // com.google.android.gms.internal.ads.zzdjj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzy(android.view.View r9, @androidx.annotation.Nullable java.util.Map r10, @androidx.annotation.Nullable java.util.Map r11, android.view.View.OnTouchListener r12, android.view.View.OnClickListener r13) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlc.zzy(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzz(View view, @Nullable Map map) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            zzbpb zzbpbVar = this.zza;
            if (zzbpbVar != null) {
                zzbpbVar.zzz(iObjectWrapperWrap);
                return;
            }
            zzbox zzboxVar = this.zzl;
            if (zzboxVar != null) {
                zzboxVar.zzw(iObjectWrapperWrap);
                return;
            }
            zzboy zzboyVar = this.zzm;
            if (zzboyVar != null) {
                zzboyVar.zzu(iObjectWrapperWrap);
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to call untrackView", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzm(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzt(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzu(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzx(zzbgx zzbgxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzs(View view, MotionEvent motionEvent, @Nullable View view2) {
    }
}
