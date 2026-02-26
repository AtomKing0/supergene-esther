package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zznf implements zzgh {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zznd zzb;

    zznf(zznd zzndVar, String str) {
        this.zza = str;
        this.zzb = zzndVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgh
    public final void zza(String str, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(true, i10, th, bArr, this.zza);
    }
}
