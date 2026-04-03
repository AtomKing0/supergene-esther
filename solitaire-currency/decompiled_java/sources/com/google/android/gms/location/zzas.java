package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.Reserved({1000})
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzat();

    @SafeParcelable.Field(getter = "getStartHour", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getStartMinute", id = 2)
    private final int zzb;

    @SafeParcelable.Field(getter = "getEndHour", id = 3)
    private final int zzc;

    @SafeParcelable.Field(getter = "getEndMinute", id = 4)
    private final int zzd;

    @SafeParcelable.Constructor
    public zzas(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) int i13) {
        Preconditions.checkState(i10 >= 0 && i10 <= 23, "Start hour must be in range [0, 23].");
        Preconditions.checkState(i11 >= 0 && i11 <= 59, "Start minute must be in range [0, 59].");
        Preconditions.checkState(i12 >= 0 && i12 <= 23, "End hour must be in range [0, 23].");
        Preconditions.checkState(i13 >= 0 && i13 <= 59, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i10 + i11) + i12) + i13 > 0, "Parameters can't be all 0.");
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        return this.zza == zzasVar.zza && this.zzb == zzasVar.zzb && this.zzc == zzasVar.zzc && this.zzd == zzasVar.zzd;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i10 = this.zza;
        int length = String.valueOf(i10).length();
        int i11 = this.zzb;
        int length2 = String.valueOf(i11).length();
        int i12 = this.zzc;
        int length3 = String.valueOf(i12).length();
        int i13 = this.zzd;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 10 + length3 + 12 + String.valueOf(i13).length() + 1);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i10);
        sb.append(", startMinute=");
        sb.append(i11);
        sb.append(", endHour=");
        sb.append(i12);
        sb.append(", endMinute=");
        sb.append(i13);
        sb.append(v8.i.f15839e);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        Preconditions.checkNotNull(parcel);
        int i11 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i11);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
