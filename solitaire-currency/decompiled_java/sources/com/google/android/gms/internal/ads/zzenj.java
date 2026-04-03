package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenj implements zzevn {
    private final boolean zza;

    public zzenj(boolean z10) {
        this.zza = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        ((Bundle) obj).putString("adid_p", true != this.zza ? "0" : "1");
    }
}
