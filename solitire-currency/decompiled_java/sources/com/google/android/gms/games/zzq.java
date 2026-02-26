package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new PlayerEntity[i10];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        Uri uri = null;
        Uri uri2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        Uri uri3 = null;
        String strCreateString8 = null;
        Uri uri4 = null;
        String strCreateString9 = null;
        zzt zztVar = null;
        zza zzaVar = null;
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        long j12 = -1;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 29) {
                j12 = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId == 33) {
                zztVar = (zzt) SafeParcelReader.createParcelable(parcel, header, zzt.CREATOR);
            } else if (fieldId == 35) {
                zzaVar = (zza) SafeParcelReader.createParcelable(parcel, header, zza.CREATOR);
            } else if (fieldId != 36) {
                switch (fieldId) {
                    case 1:
                        strCreateString = SafeParcelReader.createString(parcel, header);
                        break;
                    case 2:
                        strCreateString2 = SafeParcelReader.createString(parcel, header);
                        break;
                    case 3:
                        uri = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                        break;
                    case 4:
                        uri2 = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                        break;
                    case 5:
                        j10 = SafeParcelReader.readLong(parcel, header);
                        break;
                    case 6:
                        i10 = SafeParcelReader.readInt(parcel, header);
                        break;
                    case 7:
                        j11 = SafeParcelReader.readLong(parcel, header);
                        break;
                    case 8:
                        strCreateString3 = SafeParcelReader.createString(parcel, header);
                        break;
                    case 9:
                        strCreateString4 = SafeParcelReader.createString(parcel, header);
                        break;
                    default:
                        switch (fieldId) {
                            case 14:
                                strCreateString5 = SafeParcelReader.createString(parcel, header);
                                break;
                            case 15:
                                mostRecentGameInfoEntity = (MostRecentGameInfoEntity) SafeParcelReader.createParcelable(parcel, header, MostRecentGameInfoEntity.CREATOR);
                                break;
                            case 16:
                                playerLevelInfo = (PlayerLevelInfo) SafeParcelReader.createParcelable(parcel, header, PlayerLevelInfo.CREATOR);
                                break;
                            default:
                                switch (fieldId) {
                                    case 18:
                                        z10 = SafeParcelReader.readBoolean(parcel, header);
                                        break;
                                    case 19:
                                        z11 = SafeParcelReader.readBoolean(parcel, header);
                                        break;
                                    case 20:
                                        strCreateString6 = SafeParcelReader.createString(parcel, header);
                                        break;
                                    case 21:
                                        strCreateString7 = SafeParcelReader.createString(parcel, header);
                                        break;
                                    case 22:
                                        uri3 = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                                        break;
                                    case 23:
                                        strCreateString8 = SafeParcelReader.createString(parcel, header);
                                        break;
                                    case 24:
                                        uri4 = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                                        break;
                                    case 25:
                                        strCreateString9 = SafeParcelReader.createString(parcel, header);
                                        break;
                                    default:
                                        SafeParcelReader.skipUnknownField(parcel, header);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                z12 = SafeParcelReader.readBoolean(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlayerEntity(strCreateString, strCreateString2, uri, uri2, j10, i10, j11, strCreateString3, strCreateString4, strCreateString5, mostRecentGameInfoEntity, playerLevelInfo, z10, z11, strCreateString6, strCreateString7, uri3, strCreateString8, uri4, strCreateString9, j12, zztVar, zzaVar, z12);
    }
}
