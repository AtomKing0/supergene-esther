package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j10 = 0;
        long j11 = 0;
        PlayerLevel playerLevel = null;
        PlayerLevel playerLevel2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                j10 = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId == 2) {
                j11 = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId == 3) {
                playerLevel = (PlayerLevel) SafeParcelReader.createParcelable(parcel, header, PlayerLevel.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                playerLevel2 = (PlayerLevel) SafeParcelReader.createParcelable(parcel, header, PlayerLevel.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlayerLevelInfo(j10, j11, playerLevel, playerLevel2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new PlayerLevelInfo[i10];
    }
}
