package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import androidx.media3.common.PlaybackException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepp implements zzevn {
    private final Integer zza;

    private zzepp(Integer num) {
        this.zza = num;
    }

    static /* bridge */ /* synthetic */ zzepp zzb(VersionInfoParcel versionInfoParcel) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjg)).booleanValue()) {
            return new zzepp(null);
        }
        com.google.android.gms.ads.internal.zzu.zzp();
        int extensionVersion = 0;
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjj)).booleanValue()) {
                    if (versionInfoParcel.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzji)).intValue() && i10 >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        extensionVersion = SdkExtensions.getExtensionVersion(31);
                    }
                }
            } else {
                extensionVersion = SdkExtensions.getExtensionVersion(PlaybackException.CUSTOM_ERROR_CODE_BASE);
            }
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdUtil.getAdServicesExtensionVersion");
        }
        return new zzepp(Integer.valueOf(extensionVersion));
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
