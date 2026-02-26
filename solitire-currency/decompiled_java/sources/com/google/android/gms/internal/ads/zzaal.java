package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaal {
    private final zzzv zza = new zzzv();

    @Nullable
    private final zzaaj zzb;

    @Nullable
    private final zzaak zzc;
    private boolean zzd;

    @Nullable
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzaal(@Nullable Context context) {
        DisplayManager displayManager;
        zzaaj zzaajVar = (context == null || (displayManager = (DisplayManager) context.getSystemService(v8.h.f15785d)) == null) ? null : new zzaaj(this, displayManager);
        this.zzb = zzaajVar;
        this.zzc = zzaajVar != null ? zzaak.zza() : null;
        this.zzk = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    static /* bridge */ /* synthetic */ void zzb(zzaal zzaalVar, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzaalVar.zzk = refreshRate;
            zzaalVar.zzl = (refreshRate * 80) / 100;
        } else {
            zzea.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            zzaalVar.zzk = C.TIME_UNSET;
            zzaalVar.zzl = C.TIME_UNSET;
        }
    }

    private final void zzk() {
        Surface surface;
        if (zzet.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f) {
            return;
        }
        this.zzh = 0.0f;
        zzaai.zza(surface, 0.0f);
    }

    private final void zzl() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzm() {
        /*
            r9 = this;
            int r0 = com.google.android.gms.internal.ads.zzet.zza
            r1 = 30
            if (r0 < r1) goto L6a
            android.view.Surface r0 = r9.zze
            if (r0 != 0) goto Lb
            goto L6a
        Lb:
            com.google.android.gms.internal.ads.zzzv r0 = r9.zza
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzzv r0 = r9.zza
            float r0 = r0.zza()
            goto L1c
        L1a:
            float r0 = r9.zzf
        L1c:
            float r2 = r9.zzg
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 == 0) goto L6a
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L57
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L57
            com.google.android.gms.internal.ads.zzzv r1 = r9.zza
            boolean r1 = r1.zzg()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L4a
            com.google.android.gms.internal.ads.zzzv r1 = r9.zza
            long r3 = r1.zzd()
            r7 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L4a
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L4a:
            float r1 = r9.zzg
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L62
            goto L63
        L57:
            if (r4 != 0) goto L65
            com.google.android.gms.internal.ads.zzzv r2 = r9.zza
            int r2 = r2.zzb()
            if (r2 < r1) goto L62
            goto L63
        L62:
            r5 = r6
        L63:
            if (r5 == 0) goto L6a
        L65:
            r9.zzg = r0
            r9.zzn(r6)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaal.zzm():void");
    }

    private final void zzn(boolean z10) {
        Surface surface;
        if (zzet.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE) {
            return;
        }
        float f10 = 0.0f;
        if (this.zzd) {
            float f11 = this.zzg;
            if (f11 != -1.0f) {
                f10 = this.zzi * f11;
            }
        }
        if (z10 || this.zzh != f10) {
            this.zzh = f10;
            zzaai.zza(surface, f10);
        }
    }

    public final long zza(long j10) {
        long j11;
        if (this.zzp != -1 && this.zza.zzg()) {
            long jZzc = this.zza.zzc();
            long j12 = this.zzq + ((long) ((jZzc * (this.zzm - this.zzp)) / this.zzi));
            if (Math.abs(j10 - j12) > 20000000) {
                zzl();
            } else {
                j10 = j12;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j10;
        zzaak zzaakVar = this.zzc;
        if (zzaakVar != null && this.zzk != C.TIME_UNSET) {
            long j13 = zzaakVar.zza;
            if (j13 != C.TIME_UNSET) {
                long j14 = this.zzk;
                long j15 = j13 + (((j10 - j13) / j14) * j14);
                if (j10 <= j15) {
                    j11 = j15 - j14;
                } else {
                    j15 = j14 + j15;
                    j11 = j15;
                }
                long j16 = this.zzl;
                if (j15 - j10 >= j10 - j11) {
                    j15 = j11;
                }
                return j15 - j16;
            }
        }
        return j10;
    }

    public final void zzc(float f10) {
        this.zzf = f10;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j10) {
        long j11 = this.zzn;
        if (j11 != -1) {
            this.zzp = j11;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j10 * 1000);
        zzm();
    }

    public final void zze(float f10) {
        this.zzi = f10;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzaak zzaakVar = this.zzc;
            zzaakVar.getClass();
            zzaakVar.zzb();
            this.zzb.zza();
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzaaj zzaajVar = this.zzb;
        if (zzaajVar != null) {
            zzaajVar.zzb();
            zzaak zzaakVar = this.zzc;
            zzaakVar.getClass();
            zzaakVar.zzc();
        }
        zzk();
    }

    public final void zzi(@Nullable Surface surface) {
        if (true == (surface instanceof zzaad)) {
            surface = null;
        }
        if (this.zze == surface) {
            return;
        }
        zzk();
        this.zze = surface;
        zzn(true);
    }

    public final void zzj(int i10) {
        if (this.zzj == i10) {
            return;
        }
        this.zzj = i10;
        zzn(true);
    }
}
