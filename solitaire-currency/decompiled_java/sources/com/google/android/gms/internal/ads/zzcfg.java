package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfg implements zzbix {
    final /* synthetic */ zzcfi zza;

    zzcfg(zzcfi zzcfiVar) {
        this.zza = zzcfiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i10 = Integer.parseInt(str);
                synchronized (this.zza) {
                    zzcfi zzcfiVar = this.zza;
                    if (zzcfiVar.zzI != i10) {
                        zzcfiVar.zzI = i10;
                        this.zza.requestLayout();
                    }
                }
            } catch (Exception e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Exception occurred while getting webview content height", e10);
            }
        }
    }
}
