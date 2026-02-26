package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.Contents;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfi implements Parcelable.Creator<zzfh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfh createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Contents contents = null;
        boolean z10 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 2) {
                contents = (Contents) SafeParcelReader.createParcelable(parcel, header, Contents.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                z10 = SafeParcelReader.readBoolean(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfh(contents, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfh[] newArray(int i10) {
        return new zzfh[i10];
    }
}
