package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaad extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaab zzd;
    private boolean zze;

    /* synthetic */ zzaad(zzaab zzaabVar, SurfaceTexture surfaceTexture, boolean z10, zzaac zzaacVar) {
        super(surfaceTexture);
        this.zzd = zzaabVar;
        this.zza = z10;
    }

    public static zzaad zza(Context context, boolean z10) {
        boolean z11 = true;
        if (z10 && !zzb(context)) {
            z11 = false;
        }
        zzdi.zzf(z11);
        return new zzaab().zza(z10 ? zzb : 0);
    }

    public static synchronized boolean zzb(Context context) {
        if (!zzc) {
            zzb = zzdr.zzb(context) ? zzdr.zzc() ? 1 : 2 : 0;
            zzc = true;
        }
        return zzb != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
