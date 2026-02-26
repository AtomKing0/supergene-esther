package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import io.sentry.protocol.SentryStackFrame;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhm implements zzle, zzlh {
    private final int zzb;

    @Nullable
    private zzli zzd;
    private int zze;
    private zznz zzf;
    private zzdj zzg;
    private int zzh;

    @Nullable
    private zzvx zzi;

    @Nullable
    private zzaf[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private zzlg zzq;
    private final Object zza = new Object();
    private final zzjz zzc = new zzjz();
    private long zzm = Long.MIN_VALUE;
    private zzcc zzp = zzcc.zza;

    public zzhm(int i10) {
        this.zzb = i10;
    }

    private final void zzZ(long j10, boolean z10) throws zzhw {
        this.zzn = false;
        this.zzl = j10;
        this.zzm = j10;
        zzz(j10, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzB() {
        zzlg zzlgVar;
        synchronized (this.zza) {
            zzlgVar = this.zzq;
        }
        if (zzlgVar != null) {
            zzlgVar.zza(this);
        }
    }

    protected void zzF(zzaf[] zzafVarArr, long j10, long j11, zzui zzuiVar) throws zzhw {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzG() {
        zzdi.zzf(this.zzh == 0);
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzH(zzaf[] zzafVarArr, zzvx zzvxVar, long j10, long j11, zzui zzuiVar) throws zzhw {
        zzdi.zzf(!this.zzn);
        this.zzi = zzvxVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j10;
        }
        this.zzj = zzafVarArr;
        this.zzk = j11;
        zzF(zzafVarArr, j10, j11, zzuiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzI() {
        zzdi.zzf(this.zzh == 0);
        zzjz zzjzVar = this.zzc;
        zzjzVar.zzb = null;
        zzjzVar.zza = null;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzJ(long j10) throws zzhw {
        zzZ(j10, false);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzK() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzL(zzlg zzlgVar) {
        synchronized (this.zza) {
            this.zzq = zzlgVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzN(zzcc zzccVar) {
        if (zzet.zzG(this.zzp, zzccVar)) {
            return;
        }
        this.zzp = zzccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzO() throws zzhw {
        zzdi.zzf(this.zzh == 1);
        this.zzh = 2;
        zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzP() {
        zzdi.zzf(this.zzh == 2);
        this.zzh = 1;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final boolean zzQ() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final boolean zzR() {
        return this.zzn;
    }

    protected final boolean zzS() {
        if (zzQ()) {
            return this.zzn;
        }
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        return zzvxVar.zze();
    }

    protected final zzaf[] zzT() {
        zzaf[] zzafVarArr = this.zzj;
        zzafVarArr.getClass();
        return zzafVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzle, com.google.android.gms.internal.ads.zzlh
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final int zzcV() {
        return this.zzh;
    }

    protected final int zzcW(zzjz zzjzVar, zzhd zzhdVar, int i10) {
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        int iZza = zzvxVar.zza(zzjzVar, zzhdVar, i10);
        if (iZza == -4) {
            if (zzhdVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j10 = zzhdVar.zze + this.zzk;
            zzhdVar.zze = j10;
            this.zzm = Math.max(this.zzm, j10);
        } else if (iZza == -5) {
            zzaf zzafVar = zzjzVar.zza;
            zzafVar.getClass();
            long j11 = zzafVar.zzq;
            if (j11 != Long.MAX_VALUE) {
                zzad zzadVarZzb = zzafVar.zzb();
                zzadVarZzb.zzab(j11 + this.zzk);
                zzjzVar.zza = zzadVarZzb.zzad();
                return -5;
            }
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final long zzcX() {
        return this.zzm;
    }

    protected final zzjz zzcY() {
        zzjz zzjzVar = this.zzc;
        zzjzVar.zzb = null;
        zzjzVar.zza = null;
        return zzjzVar;
    }

    protected final int zzd(long j10) {
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        return zzvxVar.zzb(j10 - this.zzk);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public int zze() throws zzhw {
        return 0;
    }

    protected final long zzf() {
        return this.zzl;
    }

    protected final zzdj zzh() {
        zzdj zzdjVar = this.zzg;
        zzdjVar.getClass();
        return zzdjVar;
    }

    protected final zzhw zzi(Throwable th, @Nullable zzaf zzafVar, boolean z10, int i10) {
        int iZzY = 4;
        if (zzafVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzY = zzY(zzafVar) & 7;
            } catch (zzhw unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzhw.zzb(th, zzU(), this.zze, zzafVar, iZzY, z10, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    @Nullable
    public zzkg zzk() {
        return null;
    }

    protected final zzli zzm() {
        zzli zzliVar = this.zzd;
        zzliVar.getClass();
        return zzliVar;
    }

    protected final zznz zzn() {
        zznz zznzVar = this.zzf;
        zznzVar.getClass();
        return zznzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    @Nullable
    public final zzvx zzo() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzp() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzq() {
        zzdi.zzf(this.zzh == 1);
        zzjz zzjzVar = this.zzc;
        zzjzVar.zzb = null;
        zzjzVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzr(zzli zzliVar, zzaf[] zzafVarArr, zzvx zzvxVar, long j10, boolean z10, boolean z11, long j11, long j12, zzui zzuiVar) throws zzhw {
        zzdi.zzf(this.zzh == 0);
        this.zzd = zzliVar;
        this.zzh = 1;
        zzx(z10, z11);
        zzH(zzafVarArr, zzvxVar, j11, j12, zzuiVar);
        zzZ(j11, z10);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzu(int i10, zznz zznzVar, zzdj zzdjVar) {
        this.zze = i10;
        this.zzf = zznzVar;
        this.zzg = zzdjVar;
        zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzv() throws IOException {
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        zzvxVar.zzd();
    }

    protected void zzw() {
        throw null;
    }

    protected void zzz(long j10, boolean z10) throws zzhw {
        throw null;
    }

    protected void zzA() {
    }

    protected void zzC() {
    }

    protected void zzD() throws zzhw {
    }

    protected void zzE() {
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final zzlh zzl() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public /* synthetic */ void zzs() {
    }

    protected void zzy() {
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public /* synthetic */ void zzM(float f10, float f11) {
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public void zzt(int i10, @Nullable Object obj) throws zzhw {
    }

    protected void zzx(boolean z10, boolean z11) throws zzhw {
    }
}
