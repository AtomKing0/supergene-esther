package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcdj extends zzfl {
    private final Context zza;
    private final zzfs zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbah zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private m zzo;
    private final AtomicLong zzp;
    private final zzcdu zzq;

    public zzcdj(Context context, zzfs zzfsVar, String str, int i10, zzgu zzguVar, zzcdu zzcduVar) {
        super(false);
        this.zza = context;
        this.zzb = zzfsVar;
        this.zzq = zzcduVar;
        this.zzc = str;
        this.zzd = i10;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = 0L;
        this.zzp = new AtomicLong(-1L);
        this.zzo = null;
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue();
        zzf(zzguVar);
    }

    private final boolean zzr() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdT)).booleanValue() || this.zzl) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdU)).booleanValue() && !this.zzm;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        int iZza = inputStream != null ? inputStream.read(bArr, i10, i11) : this.zzb.zza(bArr, i10, i11);
        if (!this.zze || this.zzf != null) {
            zzg(iZza);
        }
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzcdw] */
    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws Throwable {
        zzbae zzbaeVarZzb;
        Long l10;
        boolean z10;
        boolean z11;
        long jElapsedRealtime;
        zzbat zzbatVar;
        String string = "ms";
        if (this.zzg) {
            throw new IOException("Attempt to open an already open GcacheDataSource.");
        }
        ?? r22 = 1;
        this.zzg = true;
        this.zzh = zzfyVar.zza;
        if (!this.zze) {
            zzj(zzfyVar);
        }
        this.zzi = zzbah.zza(zzfyVar.zza);
        ?? sb = -1;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdQ)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzfyVar.zze;
                this.zzi.zzi = zzfvj.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbaeVarZzb = com.google.android.gms.ads.internal.zzu.zzc().zzb(this.zzi);
            } else {
                zzbaeVarZzb = null;
            }
            if (zzbaeVarZzb != null && zzbaeVarZzb.zze()) {
                this.zzj = zzbaeVarZzb.zzd();
                this.zzl = zzbaeVarZzb.zzg();
                this.zzm = zzbaeVarZzb.zzf();
                this.zzn = zzbaeVarZzb.zza();
                this.zzk = true;
                if (!zzr()) {
                    this.zzf = zzbaeVarZzb.zzc();
                    if (this.zze) {
                        zzj(zzfyVar);
                    }
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzfyVar.zze;
            this.zzi.zzi = zzfvj.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l10 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdS);
            } else {
                l10 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdR);
            }
            long jLongValue = l10.longValue();
            long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
            com.google.android.gms.ads.internal.zzu.zzd();
            Future futureZza = zzbas.zza(this.zza, this.zzi);
            try {
                try {
                    zzbatVar = (zzbat) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th = th;
                    r22 = sb;
                }
                try {
                    this.zzj = zzbatVar.zzd();
                    this.zzl = zzbatVar.zzf();
                    this.zzm = zzbatVar.zze();
                    this.zzn = zzbatVar.zza();
                    if (!zzr()) {
                        this.zzf = zzbatVar.zzc();
                        if (this.zze) {
                            zzj(zzfyVar);
                        }
                        long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime2;
                        this.zzq.zza.zzab(true, jElapsedRealtime3);
                        this.zzk = true;
                        com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime3 + "ms");
                        return -1L;
                    }
                    long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(true, jElapsedRealtime4);
                    this.zzk = true;
                    string = "Cache connection took " + jElapsedRealtime4 + "ms";
                } catch (InterruptedException unused) {
                    z11 = true;
                    futureZza.cancel(true);
                    Thread.currentThread().interrupt();
                    jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(z11, jElapsedRealtime);
                    this.zzk = z11;
                    sb = new StringBuilder();
                    sb.append("Cache connection took ");
                    sb.append(jElapsedRealtime);
                    sb.append("ms");
                    string = sb.toString();
                } catch (ExecutionException | TimeoutException unused2) {
                    z10 = true;
                    futureZza.cancel(true);
                    jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(z10, jElapsedRealtime);
                    this.zzk = z10;
                    sb = new StringBuilder();
                    sb.append("Cache connection took ");
                    sb.append(jElapsedRealtime);
                    sb.append("ms");
                    string = sb.toString();
                } catch (Throwable th2) {
                    th = th2;
                    long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(r22, jElapsedRealtime5);
                    this.zzk = r22;
                    com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime5 + string);
                    throw th;
                }
            } catch (InterruptedException unused3) {
                z11 = false;
            } catch (ExecutionException | TimeoutException unused4) {
                z10 = false;
            } catch (Throwable th3) {
                th = th3;
                r22 = 0;
            }
            com.google.android.gms.ads.internal.util.zze.zza(string);
        }
        this.zzk = false;
        if (this.zzi != null) {
            zzfw zzfwVarZza = zzfyVar.zza();
            zzfwVarZza.zzd(Uri.parse(this.zzi.zza));
            zzfyVar = zzfwVarZza.zze();
        }
        return this.zzb.zzb(zzfyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        boolean z10 = (this.zze && this.zzf == null) ? false : true;
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        } else {
            this.zzb.zzd();
        }
        if (z10) {
            zzh();
        }
    }

    public final long zzk() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long zzl() {
        if (this.zzi != null) {
            if (this.zzp.get() != -1) {
                return this.zzp.get();
            }
            synchronized (this) {
                if (this.zzo == null) {
                    this.zzo = zzbzo.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcdi
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zza.zzm();
                        }
                    });
                }
            }
            if (this.zzo.isDone()) {
                try {
                    this.zzp.compareAndSet(-1L, ((Long) this.zzo.get()).longValue());
                    return this.zzp.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
        return -1L;
    }

    final /* synthetic */ Long zzm() throws Exception {
        return Long.valueOf(com.google.android.gms.ads.internal.zzu.zzc().zza(this.zzi));
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return this.zzl;
    }

    public final boolean zzq() {
        return this.zzk;
    }
}
