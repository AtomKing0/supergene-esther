package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
public final class zza {
    private long zza = Long.MIN_VALUE;

    public final zza zza(long j10) {
        Preconditions.checkArgument(j10 >= 0, "intervalMillis can't be negative.");
        this.zza = j10;
        return this;
    }

    public final zzb zzb() {
        Preconditions.checkState(this.zza != Long.MIN_VALUE, "Must set intervalMillis.");
        return new zzb(this.zza, true, null, null, null, false, null, 0L, null);
    }
}
