package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean[] zArrCreateBooleanArray = null;
        boolean[] zArrCreateBooleanArray2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                z10 = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId == 2) {
                z11 = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId == 3) {
                z12 = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId == 4) {
                zArrCreateBooleanArray = SafeParcelReader.createBooleanArray(parcel, header);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zArrCreateBooleanArray2 = SafeParcelReader.createBooleanArray(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new VideoCapabilities(z10, z11, z12, zArrCreateBooleanArray, zArrCreateBooleanArray2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new VideoCapabilities[i10];
    }
}
