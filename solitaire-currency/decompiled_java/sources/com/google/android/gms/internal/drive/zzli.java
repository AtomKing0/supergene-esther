package com.google.android.gms.internal.drive;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzli<K, V> {
    static <K, V> void zza(zzjr zzjrVar, zzlj<K, V> zzljVar, K k10, V v10) throws IOException {
        zzkb.zza(zzjrVar, zzljVar.zztu, 1, k10);
        zzkb.zza(zzjrVar, zzljVar.zztw, 2, v10);
    }

    static <K, V> int zza(zzlj<K, V> zzljVar, K k10, V v10) {
        return zzkb.zza(zzljVar.zztu, 1, k10) + zzkb.zza(zzljVar.zztw, 2, v10);
    }
}
