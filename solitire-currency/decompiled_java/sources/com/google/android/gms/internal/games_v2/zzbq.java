package com.google.android.gms.internal.games_v2;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbq {

    @Nullable
    private final String zza;
    private final Status zzb;

    private zzbq(Status status, @Nullable String str) {
        this.zzb = status;
        this.zza = str;
    }

    public static zzbq zzb(Status status) {
        Preconditions.checkArgument(!status.isSuccess());
        return new zzbq(status, null);
    }

    public static zzbq zzc(String str) {
        return new zzbq(Status.RESULT_SUCCESS, str);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbq)) {
            return false;
        }
        zzbq zzbqVar = (zzbq) obj;
        return Objects.equal(this.zzb, zzbqVar.zzb) && Objects.equal(this.zza, zzbqVar.zza);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("status", this.zzb).add("gameRunToken", this.zza).toString();
    }

    @Nullable
    public final PendingIntent zza() {
        return this.zzb.getResolution();
    }

    @Nullable
    public final String zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzb.isSuccess();
    }
}
