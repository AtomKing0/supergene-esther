package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.ChapterFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaft extends zzagd {
    public static final Parcelable.Creator<zzaft> CREATOR = new zzafs();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzagd[] zzg;

    zzaft(Parcel parcel) {
        super(ChapterFrame.ID);
        String string = parcel.readString();
        int i10 = zzet.zza;
        this.zza = string;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int i11 = parcel.readInt();
        this.zzg = new zzagd[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            this.zzg[i12] = (zzagd) parcel.readParcelable(zzagd.class.getClassLoader());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagd, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaft.class == obj.getClass()) {
            zzaft zzaftVar = (zzaft) obj;
            if (this.zzb == zzaftVar.zzb && this.zzc == zzaftVar.zzc && this.zzd == zzaftVar.zzd && this.zze == zzaftVar.zze && zzet.zzG(this.zza, zzaftVar.zza) && Arrays.equals(this.zzg, zzaftVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return ((((((((this.zzb + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzagd zzagdVar : this.zzg) {
            parcel.writeParcelable(zzagdVar, 0);
        }
    }

    public zzaft(String str, int i10, int i11, long j10, long j11, zzagd[] zzagdVarArr) {
        super(ChapterFrame.ID);
        this.zza = str;
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = j10;
        this.zze = j11;
        this.zzg = zzagdVarArr;
    }
}
