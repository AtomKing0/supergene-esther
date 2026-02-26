package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzaph;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzbzt;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbn extends zzaph {
    private final zzbzt zza;
    private final com.google.android.gms.ads.internal.util.client.zzl zzb;

    public zzbn(String str, Map map, zzbzt zzbztVar) {
        super(0, str, new zzbm(zzbztVar));
        this.zza = zzbztVar;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        this.zzb = zzlVar;
        zzlVar.zzd(str, "GET", null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    protected final zzapn zzh(zzapd zzapdVar) {
        return zzapn.zzb(zzapdVar, zzaqe.zzb(zzapdVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    protected final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzapd zzapdVar = (zzapd) obj;
        this.zzb.zzf(zzapdVar.zzc, zzapdVar.zza);
        byte[] bArr = zzapdVar.zzb;
        if (com.google.android.gms.ads.internal.util.client.zzl.zzk() && bArr != null) {
            this.zzb.zzh(bArr);
        }
        this.zza.zzc(zzapdVar);
    }
}
