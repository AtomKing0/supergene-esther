package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzc implements Parcelable.Creator<SortOrder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SortOrder createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        boolean z10 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzf.CREATOR);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                z10 = SafeParcelReader.readBoolean(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new SortOrder(arrayListCreateTypedList, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SortOrder[] newArray(int i10) {
        return new SortOrder[i10];
    }
}
