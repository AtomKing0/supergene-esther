package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgyw {
    zzgyw() {
    }

    public static final List zza(Object obj, long j10) {
        zzgyk zzgykVar = (zzgyk) zzhaz.zzh(obj, j10);
        if (zzgykVar.zzc()) {
            return zzgykVar;
        }
        int size = zzgykVar.size();
        zzgyk zzgykVarZzf = zzgykVar.zzf(size == 0 ? 10 : size + size);
        zzhaz.zzv(obj, j10, zzgykVarZzf);
        return zzgykVarZzf;
    }
}
