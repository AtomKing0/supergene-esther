package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesu implements zzevn {

    @Nullable
    private final Boolean zza;

    public zzesu(@Nullable Boolean bool) {
        this.zza = bool;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Boolean bool = this.zza;
        Bundle bundle = (Bundle) obj;
        if (bool == null) {
            bundle.putInt("lft", -1);
        } else if (bool.booleanValue()) {
            bundle.putInt("lft", 1);
        } else {
            bundle.putInt("lft", 0);
        }
    }
}
