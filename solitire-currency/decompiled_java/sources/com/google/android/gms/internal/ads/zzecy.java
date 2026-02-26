package com.google.android.gms.internal.ads;

import android.app.Activity;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzecy extends zzedu {
    private final Activity zza;

    @Nullable
    private final com.google.android.gms.ads.internal.overlay.zzm zzb;

    @Nullable
    private final String zzc;

    @Nullable
    private final String zzd;

    /* synthetic */ zzecy(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, String str, String str2, zzecx zzecxVar) {
        this.zza = activity;
        this.zzb = zzmVar;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzedu) {
            zzedu zzeduVar = (zzedu) obj;
            if (this.zza.equals(zzeduVar.zza()) && ((zzmVar = this.zzb) != null ? zzmVar.equals(zzeduVar.zzb()) : zzeduVar.zzb() == null) && ((str = this.zzc) != null ? str.equals(zzeduVar.zzc()) : zzeduVar.zzc() == null) && ((str2 = this.zzd) != null ? str2.equals(zzeduVar.zzd()) : zzeduVar.zzd() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzb;
        int iHashCode2 = ((iHashCode * 1000003) ^ (zzmVar == null ? 0 : zzmVar.hashCode())) * 1000003;
        String str = this.zzc;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzd;
        return iHashCode3 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzb;
        return "OfflineUtilsParams{activity=" + this.zza.toString() + ", adOverlay=" + String.valueOf(zzmVar) + ", gwsQueryId=" + this.zzc + ", uri=" + this.zzd + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    public final Activity zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    @Nullable
    public final com.google.android.gms.ads.internal.overlay.zzm zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    @Nullable
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    @Nullable
    public final String zzd() {
        return this.zzd;
    }
}
