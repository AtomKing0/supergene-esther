package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcmo implements zzcly {
    private final Context zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb = com.google.android.gms.ads.internal.zzu.zzo().zzi();

    public zzcmo(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        String str;
        if (map.isEmpty() || (str = (String) map.get("gad_idless")) == null) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzb;
        boolean z10 = Boolean.parseBoolean(str);
        zzgVar.zzI(z10);
        if (z10) {
            com.google.android.gms.ads.internal.util.zzad.zzc(this.zza);
        }
    }
}
