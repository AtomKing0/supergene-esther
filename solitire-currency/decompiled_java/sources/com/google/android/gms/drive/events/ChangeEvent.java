package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "ChangeEventCreator")
@SafeParcelable.Reserved({1})
public final class ChangeEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();

    @SafeParcelable.Field(id = 3)
    private final int zzbu;

    @SafeParcelable.Field(id = 2)
    private final DriveId zzk;

    @SafeParcelable.Constructor
    public ChangeEvent(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) int i10) {
        this.zzk = driveId;
        this.zzbu = i10;
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        return this.zzk;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 1;
    }

    public final boolean hasBeenDeleted() {
        return (this.zzbu & 4) != 0;
    }

    public final boolean hasContentChanged() {
        return (this.zzbu & 2) != 0;
    }

    public final boolean hasMetadataChanged() {
        return (this.zzbu & 1) != 0;
    }

    public final String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", this.zzk, Integer.valueOf(this.zzbu));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbu);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
