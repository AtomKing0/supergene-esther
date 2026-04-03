package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdnm implements zzbix {

    @Nullable
    private final zzbgh zza;
    private final zzdoa zzb;
    private final zzhew zzc;

    public zzdnm(zzdjm zzdjmVar, zzdjb zzdjbVar, zzdoa zzdoaVar, zzhew zzhewVar) {
        this.zza = zzdjmVar.zzc(zzdjbVar.zzA());
        this.zzb = zzdoaVar;
        this.zzc = zzhewVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbfx) this.zzc.zzb(), str);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to call onCustomClick for asset " + str + ".", e10);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzl("/nativeAdCustomClick", this);
    }
}
