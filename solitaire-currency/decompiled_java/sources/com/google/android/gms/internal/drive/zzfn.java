package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "OnDriveIdResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfn> CREATOR = new zzfo();

    @SafeParcelable.Field(id = 2)
    DriveId zzdd;

    @SafeParcelable.Constructor
    public zzfn(@SafeParcelable.Param(id = 2) DriveId driveId) {
        this.zzdd = driveId;
    }

    public final DriveId getDriveId() {
        return this.zzdd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
