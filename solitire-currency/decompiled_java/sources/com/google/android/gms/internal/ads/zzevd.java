package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzevd implements zzevo {
    private final zzgcu zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;

    @Nullable
    private final String zzd;

    zzevd(zzgcu zzgcuVar, Context context, VersionInfoParcel versionInfoParcel, @Nullable String str) {
        this.zza = zzgcuVar;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 35;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeve zzc() throws Exception {
        boolean zIsCallerInstantApp = Wrappers.packageManager(this.zzb).isCallerInstantApp();
        com.google.android.gms.ads.internal.zzu.zzp();
        boolean zZzE = com.google.android.gms.ads.internal.util.zzt.zzE(this.zzb);
        String str = this.zzc.afmaVersion;
        com.google.android.gms.ads.internal.zzu.zzp();
        boolean zZzF = com.google.android.gms.ads.internal.util.zzt.zzF();
        com.google.android.gms.ads.internal.zzu.zzp();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        int i10 = applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
        Context context = this.zzb;
        return new zzeve(zIsCallerInstantApp, zZzE, str, zZzF, i10, DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID), this.zzd);
    }
}
