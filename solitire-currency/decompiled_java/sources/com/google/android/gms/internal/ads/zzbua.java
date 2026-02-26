package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbua implements Parcelable.Creator {
    public static final zzbtz zza(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundleCreateBundle = null;
        com.google.android.gms.ads.internal.client.zzl zzlVar = null;
        com.google.android.gms.ads.internal.client.zzq zzqVar = null;
        String strCreateString = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundleCreateBundle2 = null;
        ArrayList<String> arrayListCreateStringList = null;
        Bundle bundleCreateBundle3 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        ArrayList<String> arrayListCreateStringList2 = null;
        String strCreateString7 = null;
        zzbes zzbesVar = null;
        ArrayList<String> arrayListCreateStringList3 = null;
        String strCreateString8 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        Bundle bundleCreateBundle4 = null;
        String strCreateString11 = null;
        com.google.android.gms.ads.internal.client.zzdu zzduVar = null;
        Bundle bundleCreateBundle5 = null;
        String strCreateString12 = null;
        String strCreateString13 = null;
        String strCreateString14 = null;
        ArrayList<Integer> arrayListCreateIntegerList = null;
        String strCreateString15 = null;
        ArrayList<String> arrayListCreateStringList4 = null;
        ArrayList<String> arrayListCreateStringList5 = null;
        String strCreateString16 = null;
        zzblh zzblhVar = null;
        String strCreateString17 = null;
        Bundle bundleCreateBundle6 = null;
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        int i13 = 0;
        boolean z11 = false;
        int i14 = 0;
        int i15 = 0;
        boolean z12 = false;
        boolean z13 = false;
        int i16 = 0;
        boolean z14 = false;
        boolean z15 = false;
        int i17 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        float f10 = 0.0f;
        float f11 = 0.0f;
        long j10 = 0;
        long j11 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 3:
                    zzlVar = (com.google.android.gms.ads.internal.client.zzl) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    break;
                case 4:
                    zzqVar = (com.google.android.gms.ads.internal.client.zzq) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    break;
                case 5:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.createParcelable(parcel, header, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.createParcelable(parcel, header, PackageInfo.CREATOR);
                    break;
                case 8:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) SafeParcelReader.createParcelable(parcel, header, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundleCreateBundle2 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 13:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 15:
                    bundleCreateBundle3 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 16:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                case 38:
                case 62:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 18:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 19:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 20:
                    f10 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 21:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 25:
                    j10 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 26:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 27:
                    arrayListCreateStringList2 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 28:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case 29:
                    zzbesVar = (zzbes) SafeParcelReader.createParcelable(parcel, header, zzbes.CREATOR);
                    break;
                case 30:
                    arrayListCreateStringList3 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 31:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 33:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 34:
                    f11 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 35:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 36:
                    i15 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 37:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 39:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case 40:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 41:
                    strCreateString10 = SafeParcelReader.createString(parcel, header);
                    break;
                case 42:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 43:
                    i16 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 44:
                    bundleCreateBundle4 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 45:
                    strCreateString11 = SafeParcelReader.createString(parcel, header);
                    break;
                case 46:
                    zzduVar = (com.google.android.gms.ads.internal.client.zzdu) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzdu.CREATOR);
                    break;
                case 47:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 48:
                    bundleCreateBundle5 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 49:
                    strCreateString12 = SafeParcelReader.createString(parcel, header);
                    break;
                case 50:
                    strCreateString13 = SafeParcelReader.createString(parcel, header);
                    break;
                case 51:
                    strCreateString14 = SafeParcelReader.createString(parcel, header);
                    break;
                case 52:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 53:
                    arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
                    break;
                case 54:
                    strCreateString15 = SafeParcelReader.createString(parcel, header);
                    break;
                case 55:
                    arrayListCreateStringList4 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 56:
                    i17 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 57:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 58:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 59:
                    z18 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 60:
                    arrayListCreateStringList5 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 61:
                    strCreateString16 = SafeParcelReader.createString(parcel, header);
                    break;
                case 63:
                    zzblhVar = (zzblh) SafeParcelReader.createParcelable(parcel, header, zzblh.CREATOR);
                    break;
                case 64:
                    strCreateString17 = SafeParcelReader.createString(parcel, header);
                    break;
                case 65:
                    bundleCreateBundle6 = SafeParcelReader.createBundle(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbtz(i10, bundleCreateBundle, zzlVar, zzqVar, strCreateString, applicationInfo, packageInfo, strCreateString2, strCreateString3, strCreateString4, versionInfoParcel, bundleCreateBundle2, i11, arrayListCreateStringList, bundleCreateBundle3, z10, i12, i13, f10, strCreateString5, j10, strCreateString6, arrayListCreateStringList2, strCreateString7, zzbesVar, arrayListCreateStringList3, j11, strCreateString8, f11, z11, i14, i15, z12, strCreateString9, strCreateString10, z13, i16, bundleCreateBundle4, strCreateString11, zzduVar, z14, bundleCreateBundle5, strCreateString12, strCreateString13, strCreateString14, z15, arrayListCreateIntegerList, strCreateString15, arrayListCreateStringList4, i17, z16, z17, z18, arrayListCreateStringList5, strCreateString16, zzblhVar, strCreateString17, bundleCreateBundle6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbtz[i10];
    }
}
