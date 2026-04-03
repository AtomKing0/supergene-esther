package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "GamesSignInRequestCreator")
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();

    @SafeParcelable.Field(getter = "getSignInType", id = 1)
    private final int zza;

    @Nullable
    @SafeParcelable.Field(getter = "getPreviousStepResolutionResult", id = 2)
    private final zzaf zzb;

    @SafeParcelable.Constructor
    zzy(@SafeParcelable.Param(id = 1) int i10, @Nullable @SafeParcelable.Param(id = 2) zzaf zzafVar) {
        this.zza = i10;
        this.zzb = zzafVar;
    }

    public static zzy zzb(int i10) {
        return new zzy(i10, null);
    }

    public static zzy zzc(int i10, zzaf zzafVar) {
        return new zzy(i10, zzafVar);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy zzyVar = (zzy) obj;
        return this.zza == zzyVar.zza && Objects.equal(this.zzb, zzyVar.zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("signInType", Integer.valueOf(this.zza)).add("previousStepResolutionResult", this.zzb).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb == null;
    }
}
