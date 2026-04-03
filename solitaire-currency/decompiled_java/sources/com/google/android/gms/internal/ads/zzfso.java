package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfso extends zzfsz {

    @Nullable
    private final String zza;

    @Nullable
    private final String zzb;

    /* synthetic */ zzfso(String str, String str2, zzfsn zzfsnVar) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfsz) {
            zzfsz zzfszVar = (zzfsz) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfszVar.zzb()) : zzfszVar.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfszVar.zza()) : zzfszVar.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        return ((iHashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "OverlayDisplayDismissRequest{sessionToken=" + this.zza + ", appId=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfsz
    @Nullable
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfsz
    @Nullable
    public final String zzb() {
        return this.zza;
    }
}
