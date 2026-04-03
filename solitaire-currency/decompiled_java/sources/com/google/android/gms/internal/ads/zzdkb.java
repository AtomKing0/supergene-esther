package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkb {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzffg zzc;
    private final zzdjg zzd;
    private final zzdjb zze;

    @Nullable
    private final zzdkn zzf;

    @Nullable
    private final zzdkv zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbes zzj;
    private final zzdiy zzk;

    public zzdkb(com.google.android.gms.ads.internal.util.zzg zzgVar, zzffg zzffgVar, zzdjg zzdjgVar, zzdjb zzdjbVar, @Nullable zzdkn zzdknVar, @Nullable zzdkv zzdkvVar, Executor executor, Executor executor2, zzdiy zzdiyVar) {
        this.zzb = zzgVar;
        this.zzc = zzffgVar;
        this.zzj = zzffgVar.zzi;
        this.zzd = zzdjgVar;
        this.zze = zzdjbVar;
        this.zzf = zzdknVar;
        this.zzg = zzdkvVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdiyVar;
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i10) {
        if (i10 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i10 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i10 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzi(@NonNull ViewGroup viewGroup, boolean z10) {
        View viewZzf = z10 ? this.zze.zzf() : this.zze.zzg();
        if (viewZzf == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzf.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzf.getParent()).removeView(viewZzf);
        }
        viewGroup.addView(viewZzf, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdw)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    final /* synthetic */ void zza(ViewGroup viewGroup) {
        zzdjb zzdjbVar = this.zze;
        if (zzdjbVar.zzf() != null) {
            boolean z10 = viewGroup != null;
            if (zzdjbVar.zzc() == 2 || zzdjbVar.zzc() == 1) {
                this.zzb.zzK(this.zzc.zzf, String.valueOf(zzdjbVar.zzc()), z10);
            } else if (zzdjbVar.zzc() == 6) {
                this.zzb.zzK(this.zzc.zzf, "2", z10);
                this.zzb.zzK(this.zzc.zzf, "1", z10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzdkx r10) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdkb.zzb(com.google.android.gms.internal.ads.zzdkx):void");
    }

    public final void zzc(@Nullable zzdkx zzdkxVar) {
        if (zzdkxVar == null || this.zzf == null || zzdkxVar.zzh() == null || !this.zzd.zzg()) {
            return;
        }
        try {
            zzdkxVar.zzh().addView(this.zzf.zza());
        } catch (zzcev e10) {
            com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e10);
        }
    }

    public final void zzd(@Nullable zzdkx zzdkxVar) {
        if (zzdkxVar == null) {
            return;
        }
        Context context = zzdkxVar.zzf().getContext();
        if (com.google.android.gms.ads.internal.util.zzbv.zzh(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Activity context is needed for policy validator.");
                return;
            }
            if (this.zzg == null || zzdkxVar.zzh() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(this.zzg.zza(zzdkxVar.zzh(), windowManager), com.google.android.gms.ads.internal.util.zzbv.zzb());
            } catch (zzcev e10) {
                com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e10);
            }
        }
    }

    public final void zze(final zzdkx zzdkxVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(zzdkxVar);
            }
        });
    }

    public final boolean zzf(@NonNull ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(@NonNull ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }
}
