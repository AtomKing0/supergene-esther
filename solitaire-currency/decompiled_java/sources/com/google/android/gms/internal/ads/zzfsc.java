package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsc extends zzfrz {
    private static zzfsc zzc;

    private zzfsc(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfsc zzi(Context context) {
        zzfsc zzfscVar;
        synchronized (zzfsc.class) {
            if (zzc == null) {
                zzc = new zzfsc(context);
            }
            zzfscVar = zzc;
        }
        return zzfscVar;
    }

    public final zzfry zzh(long j10, boolean z10) throws IOException {
        synchronized (zzfsc.class) {
            if (zzo()) {
                return zzb(null, null, j10, z10);
            }
            return new zzfry();
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfsc.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }

    public final void zzk() throws IOException {
        this.zzb.zze("paidv2_publisher_option");
    }

    public final void zzl() throws IOException {
        this.zzb.zze("paidv2_user_option");
    }

    public final void zzm(boolean z10) throws IOException {
        this.zzb.zzd("paidv2_user_option", Boolean.valueOf(z10));
    }

    public final void zzn(boolean z10) throws IOException {
        this.zzb.zzd("paidv2_publisher_option", Boolean.valueOf(z10));
        if (z10) {
            return;
        }
        zzj();
    }

    public final boolean zzo() {
        return this.zzb.zzf("paidv2_publisher_option", true);
    }

    public final boolean zzp() {
        return this.zzb.zzf("paidv2_user_option", true);
    }
}
