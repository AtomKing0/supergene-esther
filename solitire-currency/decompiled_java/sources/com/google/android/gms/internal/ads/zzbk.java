package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbk implements Parcelable {
    public static final Parcelable.Creator<zzbk> CREATOR = new zzbi();
    public final long zza;
    private final zzbj[] zzb;

    public zzbk(long j10, zzbj... zzbjVarArr) {
        this.zza = j10;
        this.zzb = zzbjVarArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbk.class == obj.getClass()) {
            zzbk zzbkVar = (zzbk) obj;
            if (Arrays.equals(this.zzb, zzbkVar.zzb) && this.zza == zzbkVar.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.zzb) * 31;
        long j10 = this.zza;
        return iHashCode + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        String str;
        long j10 = this.zza;
        String string = Arrays.toString(this.zzb);
        if (j10 == C.TIME_UNSET) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j10;
        }
        return "entries=" + string + str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.zzb.length);
        for (zzbj zzbjVar : this.zzb) {
            parcel.writeParcelable(zzbjVar, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzbj zzb(int i10) {
        return this.zzb[i10];
    }

    public final zzbk zzc(zzbj... zzbjVarArr) {
        int length = zzbjVarArr.length;
        if (length == 0) {
            return this;
        }
        long j10 = this.zza;
        zzbj[] zzbjVarArr2 = this.zzb;
        int i10 = zzet.zza;
        int length2 = zzbjVarArr2.length;
        Object[] objArrCopyOf = Arrays.copyOf(zzbjVarArr2, length2 + length);
        System.arraycopy(zzbjVarArr, 0, objArrCopyOf, length2, length);
        return new zzbk(j10, (zzbj[]) objArrCopyOf);
    }

    public final zzbk zzd(@Nullable zzbk zzbkVar) {
        return zzbkVar == null ? this : zzc(zzbkVar.zzb);
    }

    zzbk(Parcel parcel) {
        this.zzb = new zzbj[parcel.readInt()];
        int i10 = 0;
        while (true) {
            zzbj[] zzbjVarArr = this.zzb;
            if (i10 >= zzbjVarArr.length) {
                this.zza = parcel.readLong();
                return;
            } else {
                zzbjVarArr[i10] = (zzbj) parcel.readParcelable(zzbj.class.getClassLoader());
                i10++;
            }
        }
    }

    public zzbk(List list) {
        this(C.TIME_UNSET, (zzbj[]) list.toArray(new zzbj[0]));
    }
}
