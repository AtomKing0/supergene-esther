package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzam {
    public final int zzb;
    public int zzc = -1;
    public int zzd = 0;
    public int zze = 0;
    public int zzf = 0;
    public int zzg = 0;

    @Nullable
    public IBinder zza = null;

    public zzam(int i10, @Nullable IBinder iBinder) {
        this.zzb = i10;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt("popupLocationInfo.gravity", this.zzb);
        bundle.putInt("popupLocationInfo.displayId", this.zzc);
        bundle.putInt("popupLocationInfo.left", this.zzd);
        bundle.putInt("popupLocationInfo.top", this.zze);
        bundle.putInt("popupLocationInfo.right", this.zzf);
        bundle.putInt("popupLocationInfo.bottom", this.zzg);
        return bundle;
    }
}
