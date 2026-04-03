package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfvo {
    public static zzfvk zza(zzfvk zzfvkVar) {
        return ((zzfvkVar instanceof zzfvn) || (zzfvkVar instanceof zzfvl)) ? zzfvkVar : zzfvkVar instanceof Serializable ? new zzfvl(zzfvkVar) : new zzfvn(zzfvkVar);
    }
}
