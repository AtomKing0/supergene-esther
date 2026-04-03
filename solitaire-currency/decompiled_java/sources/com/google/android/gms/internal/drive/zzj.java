package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "AddEventListenerRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    @Nullable
    @SafeParcelable.Field(id = 4)
    private final com.google.android.gms.drive.events.zze zzbv;

    @SafeParcelable.Field(id = 3)
    final int zzda;

    @Nullable
    @SafeParcelable.Field(id = 5)
    private final com.google.android.gms.drive.events.zzx zzdb;

    @Nullable
    @SafeParcelable.Field(id = 6)
    private final com.google.android.gms.drive.events.zzt zzdc;

    @Nullable
    @SafeParcelable.Field(id = 2)
    final DriveId zzk;

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) int i10, @SafeParcelable.Param(id = 4) com.google.android.gms.drive.events.zze zzeVar, @SafeParcelable.Param(id = 5) com.google.android.gms.drive.events.zzx zzxVar, @SafeParcelable.Param(id = 6) com.google.android.gms.drive.events.zzt zztVar) {
        this.zzk = driveId;
        this.zzda = i10;
        this.zzbv = zzeVar;
        this.zzdb = zzxVar;
        this.zzdc = zztVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbv, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzdb, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdc, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzj(int i10, DriveId driveId) {
        this((DriveId) Preconditions.checkNotNull(driveId), 1, null, null, null);
    }
}
