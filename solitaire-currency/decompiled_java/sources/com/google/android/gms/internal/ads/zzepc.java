package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepc implements zzevo {
    private final Executor zza;
    private final zzbze zzb;

    zzepc(Executor executor, zzbze zzbzeVar) {
        this.zza = executor;
        this.zzb = zzbzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcv)).booleanValue() ? zzgcj.zzh(null) : zzgcj.zzm(this.zzb.zzk(), new zzful() { // from class: com.google.android.gms.internal.ads.zzepb
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                final ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new zzevn() { // from class: com.google.android.gms.internal.ads.zzepa
                    @Override // com.google.android.gms.internal.ads.zzevn
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putStringArrayList("android_permissions", arrayList);
                    }
                };
            }
        }, this.zza);
    }
}
