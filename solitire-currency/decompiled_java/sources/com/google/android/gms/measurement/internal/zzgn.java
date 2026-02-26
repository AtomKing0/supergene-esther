package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgn {
    private final zzip zza;

    zzgn(zzip zzipVar) {
        this.zza = zzipVar;
    }

    static zzgn zza(String str) {
        return new zzgn((TextUtils.isEmpty(str) || str.length() > 1) ? zzip.UNINITIALIZED : zziq.zza(str.charAt(0)));
    }

    final String zzb() {
        return String.valueOf(zziq.zza(this.zza));
    }

    final zzip zza() {
        return this.zza;
    }
}
