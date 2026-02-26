package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.ironsource.bt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "PoolConfigurationCreator")
public final class zzfhb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfhb> CREATOR = new zzfhc();
    public final Context zza;
    public final zzfgy zzb;

    @SafeParcelable.Field(id = 2)
    public final int zzc;

    @SafeParcelable.Field(id = 3)
    public final int zzd;

    @SafeParcelable.Field(id = 4)
    public final int zze;

    @SafeParcelable.Field(id = 5)
    public final String zzf;
    public final int zzg;
    private final zzfgy[] zzh;

    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzi;

    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzj;

    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    @SafeParcelable.Constructor
    public zzfhb(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) int i13, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i14, @SafeParcelable.Param(id = 7) int i15) {
        zzfgy[] zzfgyVarArrValues = zzfgy.values();
        this.zzh = zzfgyVarArrValues;
        int[] iArrZza = zzfgz.zza();
        this.zzl = iArrZza;
        int[] iArrZza2 = zzfha.zza();
        this.zzm = iArrZza2;
        this.zza = null;
        this.zzi = i10;
        this.zzb = zzfgyVarArrValues[i10];
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = str;
        this.zzj = i14;
        this.zzg = iArrZza[i14];
        this.zzk = i15;
        int i16 = iArrZza2[i15];
    }

    public static zzfhb zza(zzfgy zzfgyVar, Context context) {
        if (zzfgyVar == zzfgy.Rewarded) {
            return new zzfhb(context, zzfgyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfI)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfO)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfQ)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfS), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfK), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfM));
        }
        if (zzfgyVar == zzfgy.Interstitial) {
            return new zzfhb(context, zzfgyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfJ)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfP)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfR)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfT), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfL), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfN));
        }
        if (zzfgyVar != zzfgy.AppOpen) {
            return null;
        }
        return new zzfhb(context, zzfgyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfW)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfY)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfZ)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfU), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfV), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfX));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zzi;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i11);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    private zzfhb(Context context, zzfgy zzfgyVar, int i10, int i11, int i12, String str, String str2, String str3) {
        int i13;
        this.zzh = zzfgy.values();
        this.zzl = zzfgz.zza();
        this.zzm = zzfha.zza();
        this.zza = context;
        this.zzi = zzfgyVar.ordinal();
        this.zzb = zzfgyVar;
        this.zzc = i10;
        this.zzd = i11;
        this.zze = i12;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i13 = 1;
        } else {
            i13 = (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        }
        this.zzg = i13;
        this.zzj = i13 - 1;
        bt.f11467g.equals(str3);
        this.zzk = 0;
    }
}
