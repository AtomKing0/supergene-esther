package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes3.dex */
public final class zzi implements Parcelable.Creator<zzh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        int i11 = 0;
        DriveId driveId = null;
        long j10 = 0;
        long j11 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 2) {
                i10 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 3) {
                driveId = (DriveId) SafeParcelReader.createParcelable(parcel, header, DriveId.CREATOR);
            } else if (fieldId == 4) {
                i11 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 5) {
                j10 = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                j11 = SafeParcelReader.readLong(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzh(i10, driveId, i11, j10, j11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i10) {
        return new zzh[i10];
    }
}
