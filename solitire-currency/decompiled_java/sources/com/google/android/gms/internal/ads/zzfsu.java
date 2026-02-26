package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfsu extends zzftm {
    private final int zza;

    @Nullable
    private final String zzb;

    /* synthetic */ zzfsu(int i10, String str, zzfst zzfstVar) {
        this.zza = i10;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzftm) {
            zzftm zzftmVar = (zzftm) obj;
            if (this.zza == zzftmVar.zza() && ((str = this.zzb) != null ? str.equals(zzftmVar.zzb()) : zzftmVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "OverlayDisplayState{statusCode=" + this.zza + ", sessionToken=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
