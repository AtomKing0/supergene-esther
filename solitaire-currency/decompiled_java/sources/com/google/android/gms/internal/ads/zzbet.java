package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbet implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        boolean z12 = false;
        int i13 = 0;
        int i14 = 0;
        boolean z13 = false;
        int i15 = 0;
        com.google.android.gms.ads.internal.client.zzfk zzfkVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzfkVar = (com.google.android.gms.ads.internal.client.zzfk) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzfk.CREATOR);
                    break;
                case 7:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 9:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    i15 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbes(i10, z10, i11, z11, i12, zzfkVar, z12, i13, i14, z13, i15);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbes[i10];
    }
}
