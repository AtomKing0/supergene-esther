package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdnh implements zzber {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdni zzb;

    zzdnh(zzdni zzdniVar, String str) {
        this.zzb = zzdniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final void zzc() {
        zzdni zzdniVar = this.zzb;
        if (zzdniVar.zzd != null) {
            zzdniVar.zzd.zzF(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final void zzd(MotionEvent motionEvent) {
    }
}
