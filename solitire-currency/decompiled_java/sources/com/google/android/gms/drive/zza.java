package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.drive.zzez;
import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "ChangeSequenceNumberCreator")
@SafeParcelable.Reserved({1})
public class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    @SafeParcelable.Field(id = 2)
    private final long zze;

    @SafeParcelable.Field(id = 3)
    private final long zzf;

    @SafeParcelable.Field(id = 4)
    private final long zzg;
    private volatile String zzh = null;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 2) long j10, @SafeParcelable.Param(id = 3) long j11, @SafeParcelable.Param(id = 4) long j12) {
        Preconditions.checkArgument(j10 != -1);
        Preconditions.checkArgument(j11 != -1);
        Preconditions.checkArgument(j12 != -1);
        this.zze = j10;
        this.zzf = j11;
        this.zzg = j12;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zza.class) {
            zza zzaVar = (zza) obj;
            if (zzaVar.zzf == this.zzf && zzaVar.zzg == this.zzg && zzaVar.zze == this.zze) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String strValueOf = String.valueOf(this.zze);
        String strValueOf2 = String.valueOf(this.zzf);
        String strValueOf3 = String.valueOf(this.zzg);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length());
        sb.append(strValueOf);
        sb.append(strValueOf2);
        sb.append(strValueOf3);
        return sb.toString().hashCode();
    }

    public String toString() {
        if (this.zzh == null) {
            String strValueOf = String.valueOf(Base64.encodeToString(((zzez) ((zzkk) zzez.zzaj().zzk(1).zzc(this.zze).zzd(this.zzf).zze(this.zzg).zzdf())).toByteArray(), 10));
            this.zzh = strValueOf.length() != 0 ? "ChangeSequenceNumber:".concat(strValueOf) : new String("ChangeSequenceNumber:");
        }
        return this.zzh;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.zze);
        SafeParcelWriter.writeLong(parcel, 3, this.zzf);
        SafeParcelWriter.writeLong(parcel, 4, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
