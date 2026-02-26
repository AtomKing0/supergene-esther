package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "LocationRequestInternalCreator")
@SafeParcelable.Reserved({2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1000})
@Deprecated
public final class zzeg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeg> CREATOR = new zzeh();

    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 1)
    LocationRequest zza;

    @SafeParcelable.Constructor
    zzeg(@SafeParcelable.Param(id = 1) LocationRequest locationRequest, @Nullable @SafeParcelable.RemovedParam(defaultValueUnchecked = "null", id = 5) List list, @SafeParcelable.RemovedParam(defaultValue = "false", id = 8) boolean z10, @SafeParcelable.RemovedParam(defaultValue = "false", id = 9) boolean z11, @SafeParcelable.RemovedParam(defaultValue = "false", id = 11) boolean z12, @SafeParcelable.RemovedParam(defaultValue = "false", id = 12) boolean z13, @Nullable @SafeParcelable.RemovedParam(defaultValueUnchecked = "null", id = 13) String str, @SafeParcelable.RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 14) long j10) {
        WorkSource workSource;
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ClientIdentity clientIdentity = (ClientIdentity) it.next();
                    WorkSourceUtil.add(workSource, clientIdentity.uid, clientIdentity.packageName);
                }
            }
            builder.zzc(workSource);
        }
        if (z10) {
            builder.setGranularity(1);
        }
        if (z11) {
            builder.zza(2);
        }
        if (z12) {
            builder.zzb(true);
        }
        if (z13) {
            builder.setWaitForAccurateLocation(true);
        }
        if (j10 != Long.MAX_VALUE) {
            builder.setMaxUpdateAgeMillis(j10);
        }
        this.zza = builder.build();
    }

    @Deprecated
    public static zzeg zza(@Nullable String str, LocationRequest locationRequest) {
        return new zzeg(locationRequest, null, false, false, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzeg) {
            return Objects.equal(this.zza, ((zzeg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
