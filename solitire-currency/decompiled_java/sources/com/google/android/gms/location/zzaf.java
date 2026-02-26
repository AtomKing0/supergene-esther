package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        com.google.android.gms.internal.location.zze zzeVar = null;
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        boolean z11 = false;
        long j10 = -1;
        float f10 = 0.0f;
        int i12 = Integer.MAX_VALUE;
        long j11 = Long.MAX_VALUE;
        long j12 = Long.MAX_VALUE;
        long j13 = 0;
        long j14 = 600000;
        long j15 = 3600000;
        int i13 = 102;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    j15 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 3:
                    j14 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 4:
                case 14:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 5:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    f10 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    j13 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 9:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    j12 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 11:
                    j10 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 12:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 15:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel, header, WorkSource.CREATOR);
                    break;
                case 17:
                    zzeVar = (com.google.android.gms.internal.location.zze) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.internal.location.zze.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new LocationRequest(i13, j15, j14, j13, j11, j12, i12, f10, z10, j10, i10, i11, z11, workSource, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationRequest[i10];
    }
}
