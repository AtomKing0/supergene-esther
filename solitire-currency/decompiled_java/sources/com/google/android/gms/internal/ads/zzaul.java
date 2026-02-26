package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaul implements zzauk {
    protected static volatile zzavp zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;

    @Nullable
    protected zzavh zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    protected zzaul(Context context) {
        try {
            zzatd.zzd();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzct)).booleanValue()) {
                this.zzr = new zzavh();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzj() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        if (this.zzc.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7 A[Catch: Exception -> 0x00ed, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ed, blocks: (B:45:0x00a6, B:48:0x00b3, B:57:0x00d7, B:58:0x00e7), top: B:73:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String zzm(android.content.Context r20, java.lang.String r21, int r22, android.view.View r23, android.app.Activity r24, byte[] r25) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaul.zzm(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzavf;

    protected abstract zzaro zzb(Context context, View view, Activity activity);

    protected abstract zzaro zzc(Context context, zzarh zzarhVar);

    protected abstract zzaro zzd(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zze(Context context, @Nullable String str, @Nullable View view) {
        return zzm(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzf(Context context, @Nullable String str, @Nullable View view, @Nullable Activity activity) {
        return zzm(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzg(Context context) {
        if (zzavs.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzm(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        return zzm(context, null, 2, view, activity, null);
    }

    protected abstract zzavr zzi(MotionEvent motionEvent) throws zzavf;

    @Override // com.google.android.gms.internal.ads.zzauk
    public final synchronized void zzk(@Nullable MotionEvent motionEvent) {
        Long l10;
        if (this.zzu) {
            zzj();
            this.zzu = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzs = motionEvent.getRawX();
            this.zzt = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d10 = rawX - this.zzs;
            double d11 = rawY - this.zzt;
            this.zzk += Math.sqrt((d10 * d10) + (d11 * d11));
            this.zzs = rawX;
            this.zzt = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    this.zzb = motionEventObtain;
                    this.zzc.add(motionEventObtain);
                    if (this.zzc.size() > 6) {
                        ((MotionEvent) this.zzc.remove()).recycle();
                    }
                    this.zzf++;
                    this.zzh = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zze += (long) (motionEvent.getHistorySize() + 1);
                    zzavr zzavrVarZzi = zzi(motionEvent);
                    Long l11 = zzavrVarZzi.zzd;
                    if (l11 != null && zzavrVarZzi.zzg != null) {
                        this.zzi += l11.longValue() + zzavrVarZzi.zzg.longValue();
                    }
                    if (this.zzq != null && (l10 = zzavrVarZzi.zze) != null && zzavrVarZzi.zzh != null) {
                        this.zzj += l10.longValue() + zzavrVarZzi.zzh.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzg++;
                }
            } catch (zzavf unused) {
            }
        } else {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final synchronized void zzl(int i10, int i11, int i12) {
        if (this.zzb != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzck)).booleanValue()) {
                zzj();
            } else {
                this.zzb.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzq;
        if (displayMetrics != null) {
            float f10 = displayMetrics.density;
            this.zzb = MotionEvent.obtain(0L, i12, 1, i10 * f10, i11 * f10, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzb = null;
        }
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavh zzavhVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzct)).booleanValue() || (zzavhVar = this.zzr) == null) {
            return;
        }
        zzavhVar.zzb(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public void zzo(View view) {
    }
}
