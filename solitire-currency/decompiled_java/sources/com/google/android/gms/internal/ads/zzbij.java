package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbij implements zzbix {
    zzbij() {
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        try {
            zzfsb.zzj(zzcejVar.getContext()).zzk();
            zzfsc.zzi(zzcejVar.getContext()).zzj();
        } catch (IOException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
