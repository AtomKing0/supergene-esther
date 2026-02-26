package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzfpr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfpr> CREATOR = new zzfps();

    @SafeParcelable.VersionField(id = 1)
    public final int zza;

    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzasj zzb = null;
    private byte[] zzc;

    @SafeParcelable.Constructor
    zzfpr(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i10;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzasj zzasjVar = this.zzb;
        if (zzasjVar != null || this.zzc == null) {
            if (zzasjVar == null || this.zzc != null) {
                if (zzasjVar != null && this.zzc != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzasjVar != null || this.zzc != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i11);
        byte[] bArrZzaV = this.zzc;
        if (bArrZzaV == null) {
            bArrZzaV = this.zzb.zzaV();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArrZzaV, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzasj zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzasj.zze(this.zzc, zzgxi.zza());
                this.zzc = null;
            } catch (zzgyn | NullPointerException e10) {
                throw new IllegalStateException(e10);
            }
        }
        zzb();
        return this.zzb;
    }
}
