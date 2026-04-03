package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzla extends zzg {
    private final zzlx zza;
    private zzfq zzb;
    private volatile Boolean zzc;
    private final zzav zzd;
    private final zzms zze;
    private final List<Runnable> zzf;
    private final zzav zzg;

    protected zzla(zzho zzhoVar) {
        super(zzhoVar);
        this.zzf = new ArrayList();
        this.zze = new zzms(zzhoVar.zzb());
        this.zza = new zzlx(this);
        this.zzd = new zzld(this, zzhoVar);
        this.zzg = new zzlm(this, zzhoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzal() {
        zzt();
        zzj().zzp().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (RuntimeException e10) {
                zzj().zzg().zza("Task exception while flushing queue", e10);
            }
        }
        this.zzf.clear();
        this.zzg.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzam() {
        zzt();
        this.zze.zzb();
        this.zzd.zza(zzbh.zzaj.zza(null).longValue());
    }

    @WorkerThread
    protected final zzal zzaa() {
        zzt();
        zzu();
        zzfq zzfqVar = this.zzb;
        if (zzfqVar == null) {
            zzad();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzn zznVarZzb = zzb(false);
        Preconditions.checkNotNull(zznVarZzb);
        try {
            zzal zzalVarZza = zzfqVar.zza(zznVarZzb);
            zzam();
            return zzalVarZza;
        } catch (RemoteException e10) {
            zzj().zzg().zza("Failed to get consents; remote exception", e10);
            return null;
        }
    }

    final Boolean zzab() {
        return this.zzc;
    }

    @WorkerThread
    protected final void zzac() {
        zzt();
        zzu();
        zzn zznVarZzb = zzb(true);
        zzh().zzab();
        zza(new zzll(this, zznVarZzb));
    }

    @WorkerThread
    final void zzad() {
        zzt();
        zzu();
        if (zzah()) {
            return;
        }
        if (zzak()) {
            this.zza.zza();
            return;
        }
        if (zze().zzx()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!((listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true)) {
            zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
        this.zza.zza(intent);
    }

    @WorkerThread
    public final void zzae() {
        zzt();
        zzu();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    @WorkerThread
    protected final void zzaf() {
        zzt();
        zzu();
        zzn zznVarZzb = zzb(false);
        zzh().zzaa();
        zza(new zzlg(this, zznVarZzb));
    }

    @WorkerThread
    protected final void zzag() {
        zzt();
        zzu();
        zza(new zzlo(this, zzb(true)));
    }

    @WorkerThread
    public final boolean zzah() {
        zzt();
        zzu();
        return this.zzb != null;
    }

    @WorkerThread
    final boolean zzai() {
        zzt();
        zzu();
        return !zzak() || zzq().zzg() >= 200900;
    }

    @WorkerThread
    final boolean zzaj() {
        zzt();
        zzu();
        return !zzak() || zzq().zzg() >= zzbh.zzbn.zza(null).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean zzak() {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzla.zzak():boolean");
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zziy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkv zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzla zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmi zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    static /* synthetic */ void zzd(zzla zzlaVar) {
        zzlaVar.zzt();
        if (zzlaVar.zzah()) {
            zzlaVar.zzj().zzp().zza("Inactivity, disconnecting from the service");
            zzlaVar.zzae();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @WorkerThread
    private final zzn zzb(boolean z10) {
        return zzg().zza(z10 ? zzj().zzx() : null);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static /* synthetic */ void zza(zzla zzlaVar, ComponentName componentName) {
        zzlaVar.zzt();
        if (zzlaVar.zzb != null) {
            zzlaVar.zzb = null;
            zzlaVar.zzj().zzp().zza("Disconnected from device MeasurementService", componentName);
            zzlaVar.zzt();
            zzlaVar.zzad();
        }
    }

    @WorkerThread
    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        zzt();
        zzu();
        zza(new zzli(this, zzb(false), zzdiVar));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzt();
        zzu();
        zza(new zzlj(this, atomicReference, zzb(false)));
    }

    @WorkerThread
    protected final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2) {
        zzt();
        zzu();
        zza(new zzlv(this, str, str2, zzb(false), zzdiVar));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzac>> atomicReference, String str, String str2, String str3) {
        zzt();
        zzu();
        zza(new zzls(this, atomicReference, str, str2, str3, zzb(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzmv>> atomicReference, Bundle bundle) {
        zzt();
        zzu();
        zza(new zzle(this, atomicReference, zzb(false), bundle));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzno>> atomicReference, boolean z10) {
        zzt();
        zzu();
        zza(new zzlf(this, atomicReference, zzb(false), z10));
    }

    @WorkerThread
    protected final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2, boolean z10) {
        zzt();
        zzu();
        zza(new zzlc(this, str, str2, zzb(false), z10, zzdiVar));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzno>> atomicReference, String str, String str2, String str3, boolean z10) {
        zzt();
        zzu();
        zza(new zzlu(this, atomicReference, str, str2, str3, zzb(false), z10));
    }

    @WorkerThread
    protected final void zza(zzbf zzbfVar, String str) {
        Preconditions.checkNotNull(zzbfVar);
        zzt();
        zzu();
        zza(new zzlq(this, true, zzb(true), zzh().zza(zzbfVar), zzbfVar, str));
    }

    @WorkerThread
    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, zzbf zzbfVar, String str) {
        zzt();
        zzu();
        if (zzq().zza(12451000) != 0) {
            zzj().zzu().zza("Not bundling data. Service unavailable or out of date");
            zzq().zza(zzdiVar, new byte[0]);
        } else {
            zza(new zzlp(this, zzbfVar, str, zzdiVar));
        }
    }

    @WorkerThread
    private final void zza(Runnable runnable) throws IllegalStateException {
        zzt();
        if (zzah()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzj().zzg().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzad();
        }
    }

    @WorkerThread
    final void zza(zzfq zzfqVar, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) throws Throwable {
        int size;
        zzt();
        zzu();
        int i10 = 100;
        int i11 = 0;
        while (i11 < 1001 && i10 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> listZza = zzh().zza(100);
            if (listZza != null) {
                arrayList.addAll(listZza);
                size = listZza.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj = arrayList.get(i12);
                i12++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzbf) {
                    try {
                        zzfqVar.zza((zzbf) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e10) {
                        zzj().zzg().zza("Failed to send event to the service", e10);
                    }
                } else if (abstractSafeParcelable2 instanceof zzno) {
                    try {
                        zzfqVar.zza((zzno) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e11) {
                        zzj().zzg().zza("Failed to send user property to the service", e11);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzfqVar.zza((zzac) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e12) {
                        zzj().zzg().zza("Failed to send conditional user property to the service", e12);
                    }
                } else {
                    zzj().zzg().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i11++;
            i10 = size;
        }
    }

    @WorkerThread
    protected final void zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzu();
        zza(new zzlt(this, true, zzb(true), zzh().zza(zzacVar), new zzac(zzacVar), zzacVar));
    }

    @WorkerThread
    protected final void zza(boolean z10) {
        zzt();
        zzu();
        if (z10) {
            zzh().zzaa();
        }
        if (zzaj()) {
            zza(new zzlr(this, zzb(false)));
        }
    }

    @WorkerThread
    protected final void zza(zzks zzksVar) {
        zzt();
        zzu();
        zza(new zzlk(this, zzksVar));
    }

    @WorkerThread
    public final void zza(Bundle bundle) {
        zzt();
        zzu();
        zza(new zzln(this, zzb(false), bundle));
    }

    @WorkerThread
    protected final void zza(zzfq zzfqVar) {
        zzt();
        Preconditions.checkNotNull(zzfqVar);
        this.zzb = zzfqVar;
        zzam();
        zzal();
    }

    @WorkerThread
    protected final void zza(zzno zznoVar) {
        zzt();
        zzu();
        zza(new zzlh(this, zzb(true), zzh().zza(zznoVar), zznoVar));
    }
}
