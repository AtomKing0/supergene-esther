package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzq extends zzr {
    zzq(int i10, int i11, Bundle bundle) {
        super(i10, i11, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd(null);
        } else {
            zzc(new zzs(4, "Invalid response to one way request", null));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final boolean zzb() {
        return true;
    }
}
