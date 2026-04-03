package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafr extends zzagd {
    public static final Parcelable.Creator<zzafr> CREATOR = new zzafq();
    public final byte[] zza;

    /* JADX WARN: Illegal instructions before constructor call */
    zzafr(Parcel parcel) {
        String string = parcel.readString();
        int i10 = zzet.zza;
        super(string);
        this.zza = parcel.createByteArray();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafr.class == obj.getClass()) {
            zzafr zzafrVar = (zzafr) obj;
            if (this.zzf.equals(zzafrVar.zzf) && Arrays.equals(this.zza, zzafrVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzf.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + Arrays.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zzf);
        parcel.writeByteArray(this.zza);
    }

    public zzafr(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }
}
