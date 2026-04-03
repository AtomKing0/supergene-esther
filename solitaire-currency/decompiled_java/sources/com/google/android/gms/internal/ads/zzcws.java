package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcws extends zzdch implements zzcwt {
    public zzcws(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcwr
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcwt) obj).zzdB(zzeVar);
            }
        });
    }
}
