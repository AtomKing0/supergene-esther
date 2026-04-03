package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza implements Parcelable.Creator {
    static void zza(PlayerStatsEntity playerStatsEntity, Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 1, playerStatsEntity.getAverageSessionLength());
        SafeParcelWriter.writeFloat(parcel, 2, playerStatsEntity.getChurnProbability());
        SafeParcelWriter.writeInt(parcel, 3, playerStatsEntity.getDaysSinceLastPlayed());
        SafeParcelWriter.writeInt(parcel, 4, playerStatsEntity.getNumberOfPurchases());
        SafeParcelWriter.writeInt(parcel, 5, playerStatsEntity.getNumberOfSessions());
        SafeParcelWriter.writeFloat(parcel, 6, playerStatsEntity.getSessionPercentile());
        SafeParcelWriter.writeFloat(parcel, 7, playerStatsEntity.getSpendPercentile());
        SafeParcelWriter.writeBundle(parcel, 8, playerStatsEntity.zza(), false);
        SafeParcelWriter.writeFloat(parcel, 9, playerStatsEntity.getSpendProbability());
        SafeParcelWriter.writeFloat(parcel, 10, playerStatsEntity.getHighSpenderProbability());
        SafeParcelWriter.writeFloat(parcel, 11, playerStatsEntity.getTotalSpendNext28Days());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Bundle bundleCreateBundle = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    f10 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 2:
                    f11 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    f12 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 7:
                    f13 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 9:
                    f14 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 10:
                    f15 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 11:
                    f16 = SafeParcelReader.readFloat(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlayerStatsEntity(f10, f11, i10, i11, i12, f12, f13, bundleCreateBundle, f14, f15, f16);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new PlayerStatsEntity[i10];
    }
}
