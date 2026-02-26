package com.google.android.gms.internal.ads;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbiv implements zzbix {
    zzbiv() {
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        if (map.keySet().contains(TtmlNode.START)) {
            zzcejVar.zzax(true);
        }
        if (map.keySet().contains("stop")) {
            zzcejVar.zzax(false);
        }
    }
}
