package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        int i13 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        String strCreateString = null;
        zzq[] zzqVarArr = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    zzqVarArr = (zzq[]) SafeParcelReader.createTypedArray(parcel, header, zzq.CREATOR);
                    break;
                case 9:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 14:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 16:
                    z18 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzq(strCreateString, i10, i11, z10, i12, i13, zzqVarArr, z11, z12, z13, z14, z15, z16, z17, z18);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzq[i10];
    }
}
