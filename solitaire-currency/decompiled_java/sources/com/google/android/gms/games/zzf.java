package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GameEntity[i10];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public GameEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        String strCreateString11 = null;
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                    break;
                case 10:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 15:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 16:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 17:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 18:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 19:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case 20:
                    strCreateString10 = SafeParcelReader.createString(parcel, header);
                    break;
                case 21:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 22:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 23:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 24:
                    strCreateString11 = SafeParcelReader.createString(parcel, header);
                    break;
                case 25:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new GameEntity(strCreateString, strCreateString2, strCreateString3, strCreateString4, strCreateString5, strCreateString6, uri, uri2, uri3, z10, z11, strCreateString7, i10, i11, i12, z12, z13, strCreateString8, strCreateString9, strCreateString10, z14, z15, z16, strCreateString11, z17);
    }
}
