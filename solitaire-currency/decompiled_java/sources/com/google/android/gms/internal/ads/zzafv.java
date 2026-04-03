package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafv extends zzagd {
    public static final Parcelable.Creator<zzafv> CREATOR = new zzafu();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzagd[] zze;

    zzafv(Parcel parcel) {
        super(ChapterTocFrame.ID);
        String string = parcel.readString();
        int i10 = zzet.zza;
        this.zza = string;
        this.zzb = parcel.readByte() != 0;
        this.zzc = parcel.readByte() != 0;
        this.zzd = parcel.createStringArray();
        int i11 = parcel.readInt();
        this.zze = new zzagd[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            this.zze[i12] = (zzagd) parcel.readParcelable(zzagd.class.getClassLoader());
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafv.class == obj.getClass()) {
            zzafv zzafvVar = (zzafv) obj;
            if (this.zzb == zzafvVar.zzb && this.zzc == zzafvVar.zzc && zzet.zzG(this.zza, zzafvVar.zza) && Arrays.equals(this.zzd, zzafvVar.zzd) && Arrays.equals(this.zze, zzafvVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return (((((this.zzb ? 1 : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (this.zzc ? 1 : 0)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zza);
        parcel.writeByte(this.zzb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zzc ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        for (zzagd zzagdVar : this.zze) {
            parcel.writeParcelable(zzagdVar, 0);
        }
    }

    public zzafv(String str, boolean z10, boolean z11, String[] strArr, zzagd[] zzagdVarArr) {
        super(ChapterTocFrame.ID);
        this.zza = str;
        this.zzb = z10;
        this.zzc = z11;
        this.zzd = strArr;
        this.zze = zzagdVarArr;
    }
}
