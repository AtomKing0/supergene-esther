package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "PermissionCreator")
@SafeParcelable.Reserved({1})
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    @SafeParcelable.Field(getter = "getAccountType", id = 3)
    private int accountType;

    @Nullable
    @SafeParcelable.Field(getter = "getAccountIdentifier", id = 2)
    private String zzbg;

    @Nullable
    @SafeParcelable.Field(getter = "getAccountDisplayName", id = 4)
    private String zzbh;

    @Nullable
    @SafeParcelable.Field(getter = "getPhotoLink", id = 5)
    private String zzbi;

    @SafeParcelable.Field(getter = "getRole", id = 6)
    private int zzbj;

    @SafeParcelable.Field(getter = "isLinkRequiredForAccess", id = 7)
    private boolean zzbk;

    @SafeParcelable.Constructor
    public zzr(@Nullable @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i10, @Nullable @SafeParcelable.Param(id = 4) String str2, @Nullable @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) int i11, @SafeParcelable.Param(id = 7) boolean z10) {
        this.zzbg = str;
        this.accountType = i10;
        this.zzbh = str2;
        this.zzbi = str3;
        this.zzbj = i11;
        this.zzbk = z10;
    }

    private static boolean zzb(int i10) {
        switch (i10) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzr.class) {
            if (obj == this) {
                return true;
            }
            zzr zzrVar = (zzr) obj;
            if (Objects.equal(this.zzbg, zzrVar.zzbg) && this.accountType == zzrVar.accountType && this.zzbj == zzrVar.zzbj && this.zzbk == zzrVar.zzbk) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbg, Integer.valueOf(this.accountType), Integer.valueOf(this.zzbj), Boolean.valueOf(this.zzbk));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, !zzb(this.accountType) ? null : this.zzbg, false);
        SafeParcelWriter.writeInt(parcel, 3, !zzb(this.accountType) ? -1 : this.accountType);
        SafeParcelWriter.writeString(parcel, 4, this.zzbh, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbi, false);
        int i11 = this.zzbj;
        SafeParcelWriter.writeInt(parcel, 6, i11 == 0 || i11 == 1 || i11 == 2 || i11 == 3 ? i11 : -1);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
