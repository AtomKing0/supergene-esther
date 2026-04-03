package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 3:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    i15 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfhb(i10, i11, i12, i13, strCreateString, i14, i15);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzfhb[i10];
    }
}
