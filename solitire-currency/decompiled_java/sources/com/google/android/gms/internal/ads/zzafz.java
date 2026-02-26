package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.GeobFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafz extends zzagd {
    public static final Parcelable.Creator<zzafz> CREATOR = new zzafy();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    zzafz(Parcel parcel) {
        super(GeobFrame.ID);
        String string = parcel.readString();
        int i10 = zzet.zza;
        this.zza = string;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafz.class == obj.getClass()) {
            zzafz zzafzVar = (zzafz) obj;
            if (zzet.zzG(this.zza, zzafzVar.zza) && zzet.zzG(this.zzb, zzafzVar.zzb) && zzet.zzG(this.zzc, zzafzVar.zzc) && Arrays.equals(this.zzd, zzafzVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str != null ? str.hashCode() : 0;
        String str2 = this.zzb;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        int i10 = iHashCode + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        String str3 = this.zzc;
        return (((((i10 * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final String toString() {
        return this.zzf + ": mimeType=" + this.zza + ", filename=" + this.zzb + ", description=" + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzafz(String str, String str2, String str3, byte[] bArr) {
        super(GeobFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }
}
