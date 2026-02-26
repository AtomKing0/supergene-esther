package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgbi extends zzgbo {
    private static final zzgct zza = new zzgct(zzgbi.class);
    private zzfxm zzb;
    private final boolean zzc;
    private final boolean zzf;

    zzgbi(zzfxm zzfxmVar, boolean z10, boolean z11) {
        super(zzfxmVar.size());
        this.zzb = zzfxmVar;
        this.zzc = z10;
        this.zzf = z11;
    }

    private final void zzG(int i10, Future future) {
        try {
            zzf(i10, zzgcj.zzp(future));
        } catch (ExecutionException e10) {
            zzI(e10.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzx(zzfxm zzfxmVar) {
        int iZzA = zzA();
        int i10 = 0;
        zzfuu.zzk(iZzA >= 0, "Less than 0 remaining futures");
        if (iZzA == 0) {
            if (zzfxmVar != null) {
                zzfzx it = zzfxmVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i10, future);
                    }
                    i10++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private final void zzI(Throwable th) {
        th.getClass();
        if (this.zzc && !zzd(th) && zzK(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }

    private static void zzJ(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final String zza() {
        zzfxm zzfxmVar = this.zzb;
        return zzfxmVar != null ? "futures=".concat(zzfxmVar.toString()) : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final void zzb() {
        zzfxm zzfxmVar = this.zzb;
        zzy(1);
        if ((zzfxmVar != null) && isCancelled()) {
            boolean zZzt = zzt();
            zzfzx it = zzfxmVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzt);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    final void zze(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thZzl = zzl();
        Objects.requireNonNull(thZzl);
        zzK(set, thZzl);
    }

    abstract void zzf(int i10, Object obj);

    abstract void zzu();

    final void zzv() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
            return;
        }
        if (!this.zzc) {
            final zzfxm zzfxmVar = this.zzf ? this.zzb : null;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgbh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx(zzfxmVar);
                }
            };
            zzfzx it = this.zzb.iterator();
            while (it.hasNext()) {
                ((m) it.next()).addListener(runnable, zzgbx.INSTANCE);
            }
            return;
        }
        zzfzx it2 = this.zzb.iterator();
        final int i10 = 0;
        while (it2.hasNext()) {
            final m mVar = (m) it2.next();
            mVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgbg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw(mVar, i10);
                }
            }, zzgbx.INSTANCE);
            i10++;
        }
    }

    final /* synthetic */ void zzw(m mVar, int i10) {
        try {
            if (mVar.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i10, mVar);
            }
        } finally {
            zzx(null);
        }
    }

    void zzy(int i10) {
        this.zzb = null;
    }
}
