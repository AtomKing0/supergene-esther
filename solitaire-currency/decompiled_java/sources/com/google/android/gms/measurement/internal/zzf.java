package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzf {
    private final zzho zza;
    private long zzaa;

    @Nullable
    private String zzab;
    private int zzac;
    private int zzad;
    private long zzae;
    private String zzaf;
    private long zzag;
    private long zzah;
    private long zzai;
    private long zzaj;
    private long zzak;
    private long zzal;

    @Nullable
    private String zzam;
    private boolean zzan;
    private long zzao;
    private long zzap;
    private final String zzb;

    @Nullable
    private String zzc;

    @Nullable
    private String zzd;

    @Nullable
    private String zze;

    @Nullable
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    @Nullable
    private String zzj;
    private long zzk;

    @Nullable
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;

    @Nullable
    private String zzq;

    @Nullable
    private Boolean zzr;
    private long zzs;

    @Nullable
    private List<String> zzt;

    @Nullable
    private String zzu;
    private boolean zzv;
    private long zzw;
    private long zzx;
    private int zzy;
    private boolean zzz;

    @WorkerThread
    zzf(zzho zzhoVar, String str) {
        Preconditions.checkNotNull(zzhoVar);
        Preconditions.checkNotEmpty(str);
        this.zza = zzhoVar;
        this.zzb = str;
        zzhoVar.zzl().zzt();
    }

    @WorkerThread
    public final int zza() {
        this.zza.zzl().zzt();
        return this.zzy;
    }

    @WorkerThread
    public final String zzaa() {
        this.zza.zzl().zzt();
        return this.zzb;
    }

    @Nullable
    @WorkerThread
    public final String zzab() {
        this.zza.zzl().zzt();
        return this.zzc;
    }

    @Nullable
    @WorkerThread
    public final String zzac() {
        this.zza.zzl().zzt();
        return this.zzl;
    }

    @Nullable
    @WorkerThread
    public final String zzad() {
        this.zza.zzl().zzt();
        return this.zzj;
    }

    @Nullable
    @WorkerThread
    public final String zzae() {
        this.zza.zzl().zzt();
        return this.zzf;
    }

    @Nullable
    @WorkerThread
    public final String zzaf() {
        this.zza.zzl().zzt();
        return this.zzd;
    }

    @Nullable
    @WorkerThread
    public final String zzag() {
        this.zza.zzl().zzt();
        return this.zzam;
    }

    @Nullable
    @WorkerThread
    public final String zzah() {
        this.zza.zzl().zzt();
        return this.zze;
    }

    @WorkerThread
    public final String zzai() {
        this.zza.zzl().zzt();
        return this.zzaf;
    }

    @Nullable
    @WorkerThread
    public final String zzaj() {
        this.zza.zzl().zzt();
        return this.zzu;
    }

    @Nullable
    @WorkerThread
    public final String zzak() {
        this.zza.zzl().zzt();
        return this.zzab;
    }

    @Nullable
    @WorkerThread
    public final List<String> zzal() {
        this.zza.zzl().zzt();
        return this.zzt;
    }

    @WorkerThread
    public final void zzam() {
        this.zza.zzl().zzt();
        this.zzan = false;
    }

    @WorkerThread
    public final void zzan() {
        this.zza.zzl().zzt();
        long j10 = this.zzg + 1;
        if (j10 > 2147483647L) {
            this.zza.zzj().zzu().zza("Bundle index overflow. appId", zzgb.zza(this.zzb));
            j10 = 0;
        }
        this.zzan = true;
        this.zzg = j10;
    }

    @WorkerThread
    public final boolean zzao() {
        this.zza.zzl().zzt();
        return this.zzp;
    }

    @WorkerThread
    public final boolean zzap() {
        this.zza.zzl().zzt();
        return this.zzo;
    }

    @WorkerThread
    public final boolean zzaq() {
        this.zza.zzl().zzt();
        return this.zzan;
    }

    @WorkerThread
    public final boolean zzar() {
        this.zza.zzl().zzt();
        return this.zzv;
    }

    @WorkerThread
    public final boolean zzas() {
        this.zza.zzl().zzt();
        return this.zzz;
    }

    @WorkerThread
    public final int zzb() {
        this.zza.zzl().zzt();
        return this.zzad;
    }

    @WorkerThread
    public final int zzc() {
        this.zza.zzl().zzt();
        return this.zzac;
    }

    @WorkerThread
    public final long zzd() {
        this.zza.zzl().zzt();
        return 0L;
    }

    @WorkerThread
    public final long zze() {
        this.zza.zzl().zzt();
        return this.zzk;
    }

    @WorkerThread
    public final long zzf() {
        this.zza.zzl().zzt();
        return this.zzaa;
    }

    @WorkerThread
    public final long zzg() {
        this.zza.zzl().zzt();
        return this.zzao;
    }

    @WorkerThread
    public final long zzh() {
        this.zza.zzl().zzt();
        return this.zzaj;
    }

    @WorkerThread
    public final long zzi() {
        this.zza.zzl().zzt();
        return this.zzak;
    }

    @WorkerThread
    public final long zzj() {
        this.zza.zzl().zzt();
        return this.zzai;
    }

    @WorkerThread
    public final long zzk() {
        this.zza.zzl().zzt();
        return this.zzah;
    }

    @WorkerThread
    public final long zzl() {
        this.zza.zzl().zzt();
        return this.zzal;
    }

    @WorkerThread
    public final long zzm() {
        this.zza.zzl().zzt();
        return this.zzag;
    }

    @WorkerThread
    public final long zzn() {
        this.zza.zzl().zzt();
        return this.zzn;
    }

    @WorkerThread
    public final long zzo() {
        this.zza.zzl().zzt();
        return this.zzs;
    }

    @WorkerThread
    public final long zzp() {
        this.zza.zzl().zzt();
        return this.zzap;
    }

    @WorkerThread
    public final long zzq() {
        this.zza.zzl().zzt();
        return this.zzm;
    }

    @WorkerThread
    public final long zzr() {
        this.zza.zzl().zzt();
        return this.zzae;
    }

    @WorkerThread
    public final long zzs() {
        this.zza.zzl().zzt();
        return this.zzi;
    }

    @WorkerThread
    public final long zzt() {
        this.zza.zzl().zzt();
        return this.zzg;
    }

    @WorkerThread
    public final long zzu() {
        this.zza.zzl().zzt();
        return this.zzh;
    }

    @WorkerThread
    public final long zzv() {
        this.zza.zzl().zzt();
        return this.zzx;
    }

    @WorkerThread
    public final long zzw() {
        this.zza.zzl().zzt();
        return this.zzw;
    }

    @Nullable
    @WorkerThread
    public final Boolean zzx() {
        this.zza.zzl().zzt();
        return this.zzr;
    }

    @Nullable
    @WorkerThread
    public final String zzy() {
        this.zza.zzl().zzt();
        return this.zzq;
    }

    @Nullable
    @WorkerThread
    public final String zzz() {
        this.zza.zzl().zzt();
        String str = this.zzam;
        zzg((String) null);
        return str;
    }

    @WorkerThread
    public final void zzd(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zzj, str);
        this.zzj = str;
    }

    @WorkerThread
    public final void zza(long j10) {
        this.zza.zzl().zzt();
        long j11 = this.zzg + j10;
        if (j11 > 2147483647L) {
            this.zza.zzj().zzu().zza("Bundle index overflow. appId", zzgb.zza(this.zzb));
            j11 = j10 - 1;
        }
        long j12 = this.zzae + 1;
        if (j12 > 2147483647L) {
            this.zza.zzj().zzu().zza("Delivery index overflow. appId", zzgb.zza(this.zzb));
            j12 = 0;
        }
        this.zzan = true;
        this.zzg = j11;
        this.zzae = j12;
    }

    @WorkerThread
    public final void zzb(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zzc, str);
        this.zzc = str;
    }

    @WorkerThread
    public final void zzc(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zzl, str);
        this.zzl = str;
    }

    @WorkerThread
    public final void zze(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzaj != j10;
        this.zzaj = j10;
    }

    @WorkerThread
    public final void zzf(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzak != j10;
        this.zzak = j10;
    }

    @WorkerThread
    public final void zzg(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzai != j10;
        this.zzai = j10;
    }

    @WorkerThread
    public final void zzh(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzah != j10;
        this.zzah = j10;
    }

    @WorkerThread
    public final void zzi(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzal != j10;
        this.zzal = j10;
    }

    @WorkerThread
    public final void zzj(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzag != j10;
        this.zzag = j10;
    }

    @WorkerThread
    public final void zzk(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzn != j10;
        this.zzn = j10;
    }

    @WorkerThread
    public final void zzl(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzs != j10;
        this.zzs = j10;
    }

    @WorkerThread
    public final void zzm(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzap != j10;
        this.zzap = j10;
    }

    @WorkerThread
    public final void zzn(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzm != j10;
        this.zzm = j10;
    }

    @WorkerThread
    public final void zzo(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzae != j10;
        this.zzae = j10;
    }

    @WorkerThread
    public final void zzp(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzi != j10;
        this.zzi = j10;
    }

    @WorkerThread
    public final void zzq(long j10) {
        Preconditions.checkArgument(j10 >= 0);
        this.zza.zzl().zzt();
        this.zzan |= this.zzg != j10;
        this.zzg = j10;
    }

    @WorkerThread
    public final void zzr(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzh != j10;
        this.zzh = j10;
    }

    @WorkerThread
    public final void zzs(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzx != j10;
        this.zzx = j10;
    }

    @WorkerThread
    public final void zzt(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzw != j10;
        this.zzw = j10;
    }

    @WorkerThread
    public final void zzd(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzao != j10;
        this.zzao = j10;
    }

    @WorkerThread
    public final void zzb(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzk != j10;
        this.zzk = j10;
    }

    @WorkerThread
    public final void zzc(long j10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzaa != j10;
        this.zzaa = j10;
    }

    @WorkerThread
    public final void zze(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zzf, str);
        this.zzf = str;
    }

    @WorkerThread
    public final void zzf(@Nullable String str) {
        this.zza.zzl().zzt();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzan |= !Objects.equals(this.zzd, str);
        this.zzd = str;
    }

    @WorkerThread
    public final void zzg(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zzam, str);
        this.zzam = str;
    }

    @WorkerThread
    public final void zzh(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zze, str);
        this.zze = str;
    }

    @WorkerThread
    public final void zzi(String str) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzaf != str;
        this.zzaf = str;
    }

    @WorkerThread
    public final void zzj(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zzu, str);
        this.zzu = str;
    }

    @WorkerThread
    public final void zzk(@Nullable String str) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzab != str;
        this.zzab = str;
    }

    @WorkerThread
    public final void zzd(boolean z10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzz != z10;
        this.zzz = z10;
    }

    @WorkerThread
    public final void zzb(int i10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzad != i10;
        this.zzad = i10;
    }

    @WorkerThread
    public final void zzc(int i10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzac != i10;
        this.zzac = i10;
    }

    @WorkerThread
    public final void zza(@Nullable String str) {
        this.zza.zzl().zzt();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzan |= !Objects.equals(this.zzq, str);
        this.zzq = str;
    }

    @WorkerThread
    public final void zzb(boolean z10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzo != z10;
        this.zzo = z10;
    }

    @WorkerThread
    public final void zzc(boolean z10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzv != z10;
        this.zzv = z10;
    }

    @WorkerThread
    public final void zza(int i10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzy != i10;
        this.zzy = i10;
    }

    @WorkerThread
    public final void zza(boolean z10) {
        this.zza.zzl().zzt();
        this.zzan |= this.zzp != z10;
        this.zzp = z10;
    }

    @WorkerThread
    public final void zza(@Nullable Boolean bool) {
        this.zza.zzl().zzt();
        this.zzan |= !Objects.equals(this.zzr, bool);
        this.zzr = bool;
    }

    @WorkerThread
    public final void zza(@Nullable List<String> list) {
        this.zza.zzl().zzt();
        if (Objects.equals(this.zzt, list)) {
            return;
        }
        this.zzan = true;
        this.zzt = list != null ? new ArrayList(list) : null;
    }
}
