package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.ironsource.v8;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "LocationAvailabilityCreator")
@SafeParcelable.Reserved({1000})
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {

    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNSUCCESSFUL", id = 4)
    final int zzc;

    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getCellStatus", id = 1)
    private final int zzd;

    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getWifiStatus", id = 2)
    private final int zze;

    @SafeParcelable.Field(defaultValueUnchecked = "0", getter = "getElapsedRealtimeNs", id = 3)
    private final long zzf;

    @SafeParcelable.Field(getter = "getBatchedStatus", id = 5)
    private final zzal[] zzg;

    @NonNull
    public static final LocationAvailability zza = new LocationAvailability(0, 1, 1, 0, null, true);

    @NonNull
    public static final LocationAvailability zzb = new LocationAvailability(1000, 1, 1, 0, null, false);

    @NonNull
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzab();

    @SafeParcelable.Constructor
    LocationAvailability(@SafeParcelable.Param(id = 4) int i10, @SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) long j10, @SafeParcelable.Param(id = 5) zzal[] zzalVarArr, @SafeParcelable.Param(id = 6) boolean z10) {
        this.zzc = i10 < 1000 ? 0 : 1000;
        this.zzd = i11;
        this.zze = i12;
        this.zzf = j10;
        this.zzg = zzalVarArr;
    }

    @Nullable
    public static LocationAvailability extractLocationAvailability(@NonNull Intent intent) {
        if (!hasLocationAvailability(intent)) {
            return null;
        }
        try {
            return (LocationAvailability) intent.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public static boolean hasLocationAvailability(@Nullable Intent intent) {
        return intent != null && intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.zzd == locationAvailability.zzd && this.zze == locationAvailability.zze && this.zzf == locationAvailability.zzf && this.zzc == locationAvailability.zzc && Arrays.equals(this.zzg, locationAvailability.zzg)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzc));
    }

    public boolean isLocationAvailable() {
        return this.zzc < 1000;
    }

    @NonNull
    public String toString() {
        boolean zIsLocationAvailable = isLocationAvailable();
        StringBuilder sb = new StringBuilder(String.valueOf(zIsLocationAvailable).length() + 22);
        sb.append("LocationAvailability[");
        sb.append(zIsLocationAvailable);
        sb.append(v8.i.f15839e);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.zzd;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i11);
        SafeParcelWriter.writeInt(parcel, 2, this.zze);
        SafeParcelWriter.writeLong(parcel, 3, this.zzf);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zzg, i10, false);
        SafeParcelWriter.writeBoolean(parcel, 6, isLocationAvailable());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
