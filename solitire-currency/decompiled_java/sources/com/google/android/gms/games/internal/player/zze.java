package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Status status = null;
        String strCreateString = null;
        StockProfileImageEntity stockProfileImageEntity = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        int i10 = 0;
        boolean z15 = false;
        boolean z16 = false;
        int i11 = 0;
        int i12 = 0;
        boolean z17 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    status = (Status) SafeParcelReader.createParcelable(parcel, header, Status.CREATOR);
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 4:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    stockProfileImageEntity = (StockProfileImageEntity) SafeParcelReader.createParcelable(parcel, header, StockProfileImageEntity.CREATOR);
                    break;
                case 7:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ProfileSettingsEntity(status, strCreateString, z10, z11, z12, stockProfileImageEntity, z13, z14, i10, z15, z16, i11, i12, z17);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new ProfileSettingsEntity[i10];
    }
}
