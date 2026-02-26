package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfyy extends zzfvt {
    final transient zzfvk zza;

    zzfyy(Map map, zzfvk zzfvkVar) {
        super(map);
        this.zza = zzfvkVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Collection] */
    @Override // com.google.android.gms.internal.ads.zzfvt, com.google.android.gms.internal.ads.zzfwk
    protected final /* bridge */ /* synthetic */ Collection zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfwk, com.google.android.gms.internal.ads.zzfwn
    final Map zzj() {
        return zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzfwk, com.google.android.gms.internal.ads.zzfwn
    final Set zzl() {
        return zzm();
    }
}
