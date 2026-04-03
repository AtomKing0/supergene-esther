package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "OpenContentsRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgj> CREATOR = new zzgk();

    @SafeParcelable.Field(id = 3)
    private final int mode;

    @SafeParcelable.Field(id = 2)
    private final DriveId zzdd;

    @SafeParcelable.Field(id = 4)
    private final int zzip;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgj(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) int i10, @SafeParcelable.Param(id = 4) int i11) {
        this.zzdd = driveId;
        this.mode = i10;
        this.zzip = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, this.mode);
        SafeParcelWriter.writeInt(parcel, 4, this.zzip);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
