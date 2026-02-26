package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzauh;
import com.google.android.gms.internal.ads.zzauk;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzfoh;
import com.google.android.gms.internal.ads.zzfpj;
import com.google.android.gms.internal.ads.zzfqd;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzj implements Runnable, zzauk {

    @VisibleForTesting
    protected boolean zza;
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    private final zzfoh zzi;
    private Context zzj;
    private final Context zzk;
    private VersionInfoParcel zzl;
    private final VersionInfoParcel zzm;
    private final boolean zzn;
    private int zzo;
    private final List zzc = new Vector();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    final CountDownLatch zzb = new CountDownLatch(1);

    public zzj(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = versionInfoParcel;
        this.zzm = versionInfoParcel;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.zzh = executorServiceNewCachedThreadPool;
        boolean zBooleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzce)).booleanValue();
        this.zzn = zBooleanValue;
        this.zzi = zzfoh.zza(context, executorServiceNewCachedThreadPool, zBooleanValue);
        this.zzf = ((Boolean) zzba.zzc().zza(zzbbw.zzcb)).booleanValue();
        this.zzg = ((Boolean) zzba.zzc().zza(zzbbw.zzcf)).booleanValue();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcd)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzdc)).booleanValue()) {
            this.zza = zzc();
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcW)).booleanValue()) {
            zzbzo.zza.execute(this);
            return;
        }
        zzay.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzv()) {
            zzbzo.zza.execute(this);
        } else {
            run();
        }
    }

    @Nullable
    private final zzauk zzm() {
        return zzi() == 2 ? (zzauk) this.zze.get() : (zzauk) this.zzd.get();
    }

    private final void zzp() {
        List list = this.zzc;
        zzauk zzaukVarZzm = zzm();
        if (list.isEmpty() || zzaukVarZzm == null) {
            return;
        }
        for (Object[] objArr : this.zzc) {
            int length = objArr.length;
            if (length == 1) {
                zzaukVarZzm.zzk((MotionEvent) objArr[0]);
            } else if (length == 3) {
                zzaukVarZzm.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzc.clear();
    }

    private final void zzq(boolean z10) {
        this.zzd.set(zzaun.zzu(this.zzl.afmaVersion, zzr(this.zzj), z10, this.zzo));
    }

    private static final Context zzr(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdc)).booleanValue()) {
                this.zza = zzc();
            }
            boolean z10 = this.zzl.isClientJar;
            final boolean z11 = false;
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzaN)).booleanValue() && z10) {
                z11 = true;
            }
            if (zzi() == 1) {
                zzq(z11);
                if (this.zzo == 2) {
                    this.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.zzh
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzb(z11);
                        }
                    });
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    zzauh zzauhVarZza = zzauh.zza(this.zzl.afmaVersion, zzr(this.zzj), z11, this.zzn);
                    this.zze.set(zzauhVarZza);
                    if (this.zzg && !zzauhVarZza.zzr()) {
                        this.zzo = 1;
                        zzq(z11);
                    }
                } catch (NullPointerException e10) {
                    this.zzo = 1;
                    zzq(z11);
                    this.zzi.zzc(2031, System.currentTimeMillis() - jCurrentTimeMillis, e10);
                }
            }
        } finally {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
        }
    }

    final /* synthetic */ void zzb(boolean z10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            zzauh.zza(this.zzm.afmaVersion, zzr(this.zzk), z10, this.zzn).zzp();
        } catch (NullPointerException e10) {
            this.zzi.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e10);
        }
    }

    protected final boolean zzc() {
        Context context = this.zzj;
        zzi zziVar = new zzi(this);
        zzfoh zzfohVar = this.zzi;
        return new zzfqd(this.zzj, zzfpj.zzb(context, zzfohVar), zziVar, ((Boolean) zzba.zzc().zza(zzbbw.zzcc)).booleanValue()).zzd(1);
    }

    public final boolean zzd() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Interrupted during GADSignals creation.", e10);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zzd()) {
            return "";
        }
        zzauk zzaukVarZzm = zzm();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjM)).booleanValue()) {
            zzu.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzJ(view, 4, null);
        }
        if (zzaukVarZzm == null) {
            return "";
        }
        zzp();
        return zzaukVarZzm.zzf(zzr(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzg(Context context) {
        zzauk zzaukVarZzm;
        if (!zzd() || (zzaukVarZzm = zzm()) == null) {
            return "";
        }
        zzp();
        return zzaukVarZzm.zzg(zzr(context));
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjL)).booleanValue()) {
            zzauk zzaukVarZzm = zzm();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzjM)).booleanValue()) {
                zzu.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzJ(view, 2, null);
            }
            return zzaukVarZzm != null ? zzaukVarZzm.zzh(context, view, activity) : "";
        }
        if (!zzd()) {
            return "";
        }
        zzauk zzaukVarZzm2 = zzm();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjM)).booleanValue()) {
            zzu.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzJ(view, 2, null);
        }
        return zzaukVarZzm2 != null ? zzaukVarZzm2.zzh(context, view, activity) : "";
    }

    protected final int zzi() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    public final int zzj() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzk(MotionEvent motionEvent) {
        zzauk zzaukVarZzm = zzm();
        if (zzaukVarZzm == null) {
            this.zzc.add(new Object[]{motionEvent});
        } else {
            zzp();
            zzaukVarZzm.zzk(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzl(int i10, int i11, int i12) {
        zzauk zzaukVarZzm = zzm();
        if (zzaukVarZzm == null) {
            this.zzc.add(new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)});
        } else {
            zzp();
            zzaukVarZzm.zzl(i10, i11, i12);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzauk zzaukVarZzm;
        if (!zzd() || (zzaukVarZzm = zzm()) == null) {
            return;
        }
        zzaukVarZzm.zzn(stackTraceElementArr);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzo(View view) {
        zzauk zzaukVarZzm = zzm();
        if (zzaukVarZzm != null) {
            zzaukVarZzm.zzo(view);
        }
    }
}
