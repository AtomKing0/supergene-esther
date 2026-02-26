package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.ironsource.v8;
import com.unity3d.services.UnityAdsConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({2, 5})
public final class zze extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final int zzb;

    @SafeParcelable.Field(getter = "getPackageName", id = 3)
    @NotNull
    private final String zzc;

    @SafeParcelable.Field(getter = "getAttributionTag", id = 4)
    @Nullable
    private final String zzd;

    @SafeParcelable.Field(getter = "getListenerId", id = 6)
    @Nullable
    private final String zze;

    @SafeParcelable.Field(getter = "getClientFeatures", id = 8)
    @NotNull
    private final List zzf;

    @SafeParcelable.Field(getter = "getImpersonator", id = 7)
    @Nullable
    private final zze zzg;

    @NotNull
    public static final zzd zza = new zzd(null);

    @NotNull
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    static {
        Process.myUid();
        Process.myPid();
    }

    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 3) @NotNull String packageName, @SafeParcelable.Param(id = 4) @Nullable String str, @SafeParcelable.Param(id = 6) @Nullable String str2, @SafeParcelable.Param(id = 8) @Nullable List list, @SafeParcelable.Param(id = 7) @Nullable zze zzeVar) {
        t.i(packageName, "packageName");
        if (zzeVar != null && zzeVar.zza()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.zzb = i10;
        this.zzc = packageName;
        this.zzd = str;
        this.zze = str2 == null ? zzeVar != null ? zzeVar.zze : null : str2;
        if (list == null) {
            list = zzeVar != null ? zzeVar.zzf : null;
            if (list == null) {
                list = zzex.zzi();
                t.h(list, "of(...)");
            }
        }
        t.i(list, "<this>");
        zzex zzexVarZzj = zzex.zzj(list);
        t.h(zzexVarZzj, "copyOf(...)");
        this.zzf = zzexVarZzj;
        this.zzg = zzeVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (this.zzb == zzeVar.zzb && t.d(this.zzc, zzeVar.zzc) && t.d(this.zzd, zzeVar.zzd) && t.d(this.zze, zzeVar.zze) && t.d(this.zzg, zzeVar.zzg) && t.d(this.zzf, zzeVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzg});
    }

    @NotNull
    public final String toString() {
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        StringBuilder sb = new StringBuilder(length + (str != null ? str.length() : 0));
        sb.append(this.zzb);
        sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
        sb.append(this.zzc);
        String str2 = this.zzd;
        if (str2 != null) {
            sb.append(v8.i.f15837d);
            if (q.K(str2, this.zzc, false, 2, null)) {
                sb.append((CharSequence) str2, this.zzc.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append(v8.i.f15839e);
        }
        if (this.zze != null) {
            sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
            String str3 = this.zze;
            sb.append(Integer.toHexString(str3 != null ? str3.hashCode() : 0));
        }
        String string = sb.toString();
        t.h(string, "toString(...)");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int i10) {
        t.i(dest, "dest");
        int i11 = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, i11);
        SafeParcelWriter.writeString(dest, 3, this.zzc, false);
        SafeParcelWriter.writeString(dest, 4, this.zzd, false);
        SafeParcelWriter.writeString(dest, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(dest, 7, this.zzg, i10, false);
        SafeParcelWriter.writeTypedList(dest, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }

    public final boolean zza() {
        return this.zzg != null;
    }
}
