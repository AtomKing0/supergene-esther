package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.onetrust.otpublishers.headless.Public.OTBannerHeightRatio;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeog implements zzevn {
    public final com.google.android.gms.ads.internal.client.zzq zza;

    @Nullable
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;

    @Nullable
    public final String zzh;
    public final boolean zzi;

    public zzeog(com.google.android.gms.ads.internal.client.zzq zzqVar, @Nullable String str, boolean z10, String str2, float f10, int i10, int i11, @Nullable String str3, boolean z11) {
        Preconditions.checkNotNull(zzqVar, "the adSize must not be null");
        this.zza = zzqVar;
        this.zzb = str;
        this.zzc = z10;
        this.zzd = str2;
        this.zze = f10;
        this.zzf = i10;
        this.zzg = i11;
        this.zzh = str3;
        this.zzi = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzffu.zzf(bundle, "smart_w", OTBannerHeightRatio.FULL, this.zza.zze == -1);
        zzffu.zzf(bundle, "smart_h", TtmlNode.TEXT_EMPHASIS_AUTO, this.zza.zzb == -2);
        zzffu.zzg(bundle, "ene", true, this.zza.zzj);
        zzffu.zzf(bundle, "rafmt", "102", this.zza.zzm);
        zzffu.zzf(bundle, "rafmt", "103", this.zza.zzn);
        zzffu.zzf(bundle, "rafmt", "105", this.zza.zzo);
        zzffu.zzg(bundle, "inline_adaptive_slot", true, this.zzi);
        zzffu.zzg(bundle, "interscroller_slot", true, this.zza.zzo);
        zzffu.zzc(bundle, "format", this.zzb);
        zzffu.zzf(bundle, "fluid", "height", this.zzc);
        zzffu.zzf(bundle, "sz", this.zzd, !TextUtils.isEmpty(this.zzd));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        zzffu.zzf(bundle, "sc", this.zzh, !TextUtils.isEmpty(this.zzh));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        com.google.android.gms.ads.internal.client.zzq[] zzqVarArr = this.zza.zzg;
        if (zzqVarArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.zzb);
            bundle2.putInt("width", this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (com.google.android.gms.ads.internal.client.zzq zzqVar : zzqVarArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzqVar.zzi);
                bundle3.putInt("height", zzqVar.zzb);
                bundle3.putInt("width", zzqVar.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
