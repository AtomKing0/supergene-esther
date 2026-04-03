package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbyr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        com.google.android.gms.ads.internal.client.zzq zzqVar = null;
        com.google.android.gms.ads.internal.client.zzl zzlVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                strCreateString2 = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 3) {
                zzqVar = (com.google.android.gms.ads.internal.client.zzq) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzq.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzlVar = (com.google.android.gms.ads.internal.client.zzl) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzl.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbyq(strCreateString, strCreateString2, zzqVar, zzlVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbyq[i10];
    }
}
