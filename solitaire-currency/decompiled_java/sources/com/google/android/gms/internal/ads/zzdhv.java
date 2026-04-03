package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdhv implements zzbix {
    private final WeakReference zza;

    /* synthetic */ zzdhv(zzdhy zzdhyVar, zzdhu zzdhuVar) {
        this.zza = new WeakReference(zzdhyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzdhy zzdhyVar = (zzdhy) this.zza.get();
        if (zzdhyVar == null) {
            return;
        }
        zzdhyVar.zzh.onAdClicked();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjR)).booleanValue()) {
            zzdhyVar.zzi.zzdG();
            if (TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                return;
            }
            zzdhyVar.zzi.zzdf();
        }
    }
}
