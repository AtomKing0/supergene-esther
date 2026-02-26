package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqp implements zzpl {
    private static final Object zza = new Object();

    @Nullable
    @GuardedBy("releaseExecutorLock")
    private static ExecutorService zzb;

    @GuardedBy("releaseExecutorLock")
    private static int zzc;
    private zzbq zzA;
    private boolean zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private int zzG;
    private boolean zzH;
    private boolean zzI;
    private long zzJ;
    private float zzK;

    @Nullable
    private ByteBuffer zzL;
    private int zzM;

    @Nullable
    private ByteBuffer zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private int zzS;
    private zzi zzT;

    @Nullable
    private zzon zzU;
    private long zzV;
    private boolean zzW;
    private boolean zzX;

    @Nullable
    private Looper zzY;
    private long zzZ;
    private long zzaa;
    private Handler zzab;
    private final zzqd zzac;
    private final zzpt zzad;

    @Nullable
    private final Context zzd;
    private final zzpq zze;
    private final zzqz zzf;
    private final zzfxr zzg;
    private final zzfxr zzh;
    private final zzdm zzi;
    private final zzpp zzj;
    private final ArrayDeque zzk;
    private zzqn zzl;
    private final zzqi zzm;
    private final zzqi zzn;

    @Nullable
    private zznz zzo;

    @Nullable
    private zzpi zzp;

    @Nullable
    private zzqc zzq;
    private zzqc zzr;
    private zzcq zzs;

    @Nullable
    private AudioTrack zzt;
    private zzof zzu;
    private zzom zzv;

    @Nullable
    private zzqh zzw;
    private zzh zzx;

    @Nullable
    private zzqf zzy;
    private zzqf zzz;

    /* synthetic */ zzqp(zzqb zzqbVar, zzqo zzqoVar) {
        zzof zzofVarZzc;
        Context context = zzqbVar.zza;
        this.zzd = context;
        zzh zzhVar = zzh.zza;
        this.zzx = zzhVar;
        if (context != null) {
            zzof zzofVar = zzof.zza;
            int i10 = zzet.zza;
            zzofVarZzc = zzof.zzc(context, zzhVar, null);
        } else {
            zzofVarZzc = zzqbVar.zzb;
        }
        this.zzu = zzofVarZzc;
        this.zzac = zzqbVar.zze;
        int i11 = zzet.zza;
        zzpt zzptVar = zzqbVar.zzf;
        zzptVar.getClass();
        this.zzad = zzptVar;
        zzdm zzdmVar = new zzdm(zzdj.zza);
        this.zzi = zzdmVar;
        zzdmVar.zze();
        this.zzj = new zzpp(new zzqk(this, null));
        zzpq zzpqVar = new zzpq();
        this.zze = zzpqVar;
        zzqz zzqzVar = new zzqz();
        this.zzf = zzqzVar;
        this.zzg = zzfxr.zzp(new zzcx(), zzpqVar, zzqzVar);
        this.zzh = zzfxr.zzn(new zzqy());
        this.zzK = 1.0f;
        this.zzS = 0;
        this.zzT = new zzi(0, 0.0f);
        zzbq zzbqVar = zzbq.zza;
        this.zzz = new zzqf(zzbqVar, 0L, 0L, null);
        this.zzA = zzbqVar;
        this.zzB = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzqi(100L);
        this.zzn = new zzqi(100L);
    }

    public static /* synthetic */ void zzF(zzqp zzqpVar) {
        if (zzqpVar.zzaa >= 300000) {
            ((zzqu) zzqpVar.zzp).zza.zzm = true;
            zzqpVar.zzaa = 0L;
        }
    }

    static /* synthetic */ void zzH(AudioTrack audioTrack, final zzpi zzpiVar, Handler handler, final zzpf zzpfVar, zzdm zzdmVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzpiVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpv
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzqu) zzpiVar).zza.zzc.zzd(zzpfVar);
                    }
                });
            }
            zzdmVar.zze();
            synchronized (zza) {
                int i10 = zzc - 1;
                zzc = i10;
                if (i10 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzpiVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpv
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzqu) zzpiVar).zza.zzc.zzd(zzpfVar);
                    }
                });
            }
            zzdmVar.zze();
            synchronized (zza) {
                int i11 = zzc - 1;
                zzc = i11;
                if (i11 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzJ() {
        zzqc zzqcVar = this.zzr;
        return zzqcVar.zzc == 0 ? this.zzC / ((long) zzqcVar.zzb) : this.zzD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzK() {
        zzqc zzqcVar = this.zzr;
        if (zzqcVar.zzc != 0) {
            return this.zzF;
        }
        long j10 = this.zzE;
        long j11 = zzqcVar.zzd;
        int i10 = zzet.zza;
        return ((j10 + j11) - 1) / j11;
    }

    private final AudioTrack zzL(zzqc zzqcVar) throws zzph {
        try {
            return zzqcVar.zza(this.zzx, this.zzS);
        } catch (zzph e10) {
            zzpi zzpiVar = this.zzp;
            if (zzpiVar != null) {
                zzpiVar.zza(e10);
            }
            throw e10;
        }
    }

    private final void zzM(long j10) {
        zzbq zzbqVar;
        boolean z10;
        if (zzY()) {
            zzqd zzqdVar = this.zzac;
            zzbqVar = this.zzA;
            zzqdVar.zzc(zzbqVar);
        } else {
            zzbqVar = zzbq.zza;
        }
        zzbq zzbqVar2 = zzbqVar;
        this.zzA = zzbqVar2;
        if (zzY()) {
            zzqd zzqdVar2 = this.zzac;
            z10 = this.zzB;
            zzqdVar2.zzd(z10);
        } else {
            z10 = false;
        }
        this.zzB = z10;
        this.zzk.add(new zzqf(zzbqVar2, Math.max(0L, j10), zzet.zzs(zzK(), this.zzr.zze), null));
        zzT();
        zzpi zzpiVar = this.zzp;
        if (zzpiVar != null) {
            ((zzqu) zzpiVar).zza.zzc.zzw(this.zzB);
        }
    }

    private final void zzN() {
        if (this.zzr.zzc()) {
            this.zzW = true;
        }
    }

    private final void zzO() {
        if (this.zzv != null || this.zzd == null) {
            return;
        }
        this.zzY = Looper.myLooper();
        zzom zzomVar = new zzom(this.zzd, new zzpx(this), this.zzx, this.zzU);
        this.zzv = zzomVar;
        this.zzu = zzomVar.zzc();
    }

    private final void zzP() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        this.zzj.zzb(zzK());
        if (zzX(this.zzt)) {
            this.zzQ = false;
        }
        this.zzt.stop();
    }

    private final void zzQ(long j10) throws Exception {
        ByteBuffer byteBufferZzb;
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzL;
            if (byteBuffer == null) {
                byteBuffer = zzct.zza;
            }
            zzU(byteBuffer, j10);
            return;
        }
        while (!this.zzs.zzg()) {
            do {
                byteBufferZzb = this.zzs.zzb();
                if (byteBufferZzb.hasRemaining()) {
                    zzU(byteBufferZzb, j10);
                } else {
                    ByteBuffer byteBuffer2 = this.zzL;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzs.zze(this.zzL);
                    }
                }
            } while (!byteBufferZzb.hasRemaining());
            return;
        }
    }

    private final void zzR(zzbq zzbqVar) {
        zzqf zzqfVar = new zzqf(zzbqVar, C.TIME_UNSET, C.TIME_UNSET, null);
        if (zzW()) {
            this.zzy = zzqfVar;
        } else {
            this.zzz = zzqfVar;
        }
    }

    private final void zzS() {
        if (zzW()) {
            int i10 = zzet.zza;
            this.zzt.setVolume(this.zzK);
        }
    }

    private final void zzT() {
        zzcq zzcqVar = this.zzr.zzi;
        this.zzs = zzcqVar;
        zzcqVar.zzc();
    }

    private final void zzU(ByteBuffer byteBuffer, long j10) throws Exception {
        zzpi zzpiVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzN;
            if (byteBuffer2 != null) {
                zzdi.zzd(byteBuffer2 == byteBuffer);
            } else {
                this.zzN = byteBuffer;
                int i10 = zzet.zza;
            }
            int iRemaining = byteBuffer.remaining();
            int i11 = zzet.zza;
            int iWrite = this.zzt.write(byteBuffer, iRemaining, 1);
            this.zzV = SystemClock.elapsedRealtime();
            if (iWrite < 0) {
                if ((zzet.zza >= 24 && iWrite == -6) || iWrite == -32) {
                    if (zzK() > 0) {
                        z = true;
                    } else if (zzX(this.zzt)) {
                        zzN();
                        z = true;
                    }
                }
                zzpk zzpkVar = new zzpk(iWrite, this.zzr.zza, z);
                zzpi zzpiVar2 = this.zzp;
                if (zzpiVar2 != null) {
                    zzpiVar2.zza(zzpkVar);
                }
                if (zzpkVar.zzb) {
                    this.zzu = zzof.zza;
                    throw zzpkVar;
                }
                this.zzn.zzb(zzpkVar);
                return;
            }
            this.zzn.zza();
            if (zzX(this.zzt)) {
                if (this.zzF > 0) {
                    this.zzX = false;
                }
                if (this.zzR && (zzpiVar = this.zzp) != null && iWrite < iRemaining) {
                }
            }
            int i12 = this.zzr.zzc;
            if (i12 == 0) {
                this.zzE += (long) iWrite;
            }
            if (iWrite == iRemaining) {
                if (i12 != 0) {
                    zzdi.zzf(byteBuffer == this.zzL);
                    this.zzF += ((long) this.zzG) * ((long) this.zzM);
                }
                this.zzN = null;
            }
        }
    }

    private final boolean zzV() throws Exception {
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzN;
            if (byteBuffer == null) {
                return true;
            }
            zzU(byteBuffer, Long.MIN_VALUE);
            return this.zzN == null;
        }
        this.zzs.zzd();
        zzQ(Long.MIN_VALUE);
        if (!this.zzs.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzN;
        return byteBuffer2 == null || !byteBuffer2.hasRemaining();
    }

    private final boolean zzW() {
        return this.zzt != null;
    }

    private static boolean zzX(AudioTrack audioTrack) {
        return zzet.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzY() {
        zzqc zzqcVar = this.zzr;
        if (zzqcVar.zzc != 0) {
            return false;
        }
        int i10 = zzqcVar.zza.zzB;
        return true;
    }

    public final void zzI(zzof zzofVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zzY;
        if (looper == looperMyLooper) {
            if (zzofVar.equals(this.zzu)) {
                return;
            }
            this.zzu = zzofVar;
            zzpi zzpiVar = this.zzp;
            if (zzpiVar != null) {
                ((zzqu) zzpiVar).zza.zzB();
                return;
            }
            return;
        }
        String name = looper == null ? "null" : looper.getThread().getName();
        throw new IllegalStateException("Current looper (" + (looperMyLooper != null ? looperMyLooper.getThread().getName() : "null") + ") is not the playback looper (" + name + ")");
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final int zza(zzaf zzafVar) {
        zzO();
        if (!MimeTypes.AUDIO_RAW.equals(zzafVar.zzm)) {
            return this.zzu.zzb(zzafVar, this.zzx) != null ? 2 : 0;
        }
        if (zzet.zzK(zzafVar.zzB)) {
            return zzafVar.zzB != 2 ? 1 : 2;
        }
        zzea.zzf("DefaultAudioSink", "Invalid PCM encoding: " + zzafVar.zzB);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final long zzb(boolean z10) {
        long jZzp;
        if (!zzW() || this.zzI) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzj.zza(z10), zzet.zzs(zzK(), this.zzr.zze));
        while (!this.zzk.isEmpty() && jMin >= ((zzqf) this.zzk.getFirst()).zzc) {
            this.zzz = (zzqf) this.zzk.remove();
        }
        long j10 = jMin - this.zzz.zzc;
        if (this.zzk.isEmpty()) {
            jZzp = this.zzz.zzb + this.zzac.zza(j10);
        } else {
            zzqf zzqfVar = (zzqf) this.zzk.getFirst();
            jZzp = zzqfVar.zzb - zzet.zzp(zzqfVar.zzc - jMin, this.zzz.zza.zzb);
        }
        long jZzb = this.zzac.zzb();
        long jZzs = jZzp + zzet.zzs(jZzb, this.zzr.zze);
        long j11 = this.zzZ;
        if (jZzb > j11) {
            long jZzs2 = zzet.zzs(jZzb - j11, this.zzr.zze);
            this.zzZ = jZzb;
            this.zzaa += jZzs2;
            if (this.zzab == null) {
                this.zzab = new Handler(Looper.myLooper());
            }
            this.zzab.removeCallbacksAndMessages(null);
            this.zzab.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpw
                @Override // java.lang.Runnable
                public final void run() {
                    zzqp.zzF(this.zza);
                }
            }, 100L);
        }
        return jZzs;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final zzbq zzc() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final zzoq zzd(zzaf zzafVar) {
        return this.zzW ? zzoq.zza : this.zzad.zza(zzafVar, this.zzx);
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zze(zzaf zzafVar, int i10, @Nullable int[] iArr) throws zzpg {
        int iIntValue;
        zzcq zzcqVar;
        int iZzm;
        int iIntValue2;
        int iZzm2;
        int i11;
        int i12;
        int i13;
        int iMax;
        zzO();
        if (MimeTypes.AUDIO_RAW.equals(zzafVar.zzm)) {
            zzdi.zzd(zzet.zzK(zzafVar.zzB));
            iZzm = zzet.zzm(zzafVar.zzB, zzafVar.zzz);
            zzfxo zzfxoVar = new zzfxo();
            zzfxoVar.zzh(this.zzg);
            zzfxoVar.zzg(this.zzac.zze());
            zzcq zzcqVar2 = new zzcq(zzfxoVar.zzi());
            if (zzcqVar2.equals(this.zzs)) {
                zzcqVar2 = this.zzs;
            }
            this.zzf.zzq(zzafVar.zzC, zzafVar.zzD);
            this.zze.zzo(iArr);
            try {
                zzcr zzcrVarZza = zzcqVar2.zza(new zzcr(zzafVar.zzA, zzafVar.zzz, zzafVar.zzB));
                iIntValue = zzcrVarZza.zzd;
                i11 = zzcrVarZza.zzb;
                int i14 = zzcrVarZza.zzc;
                iIntValue2 = zzet.zzh(i14);
                zzcqVar = zzcqVar2;
                iZzm2 = zzet.zzm(iIntValue, i14);
                i12 = 0;
            } catch (zzcs e10) {
                throw new zzpg(e10, zzafVar);
            }
        } else {
            zzcq zzcqVar3 = new zzcq(zzfxr.zzm());
            int i15 = zzafVar.zzA;
            zzoq zzoqVar = zzoq.zza;
            Pair pairZzb = this.zzu.zzb(zzafVar, this.zzx);
            if (pairZzb == null) {
                throw new zzpg("Unable to configure passthrough for: ".concat(String.valueOf(zzafVar)), zzafVar);
            }
            iIntValue = ((Integer) pairZzb.first).intValue();
            zzcqVar = zzcqVar3;
            iZzm = -1;
            iIntValue2 = ((Integer) pairZzb.second).intValue();
            iZzm2 = -1;
            i11 = i15;
            i12 = 2;
        }
        if (iIntValue == 0) {
            throw new zzpg("Invalid output encoding (mode=" + i12 + ") for: " + String.valueOf(zzafVar), zzafVar);
        }
        if (iIntValue2 == 0) {
            throw new zzpg("Invalid output channel config (mode=" + i12 + ") for: " + String.valueOf(zzafVar), zzafVar);
        }
        int i16 = zzafVar.zzi;
        if (MimeTypes.AUDIO_DTS_EXPRESS.equals(zzafVar.zzm) && i16 == -1) {
            i16 = 768000;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i11, iIntValue2, iIntValue);
        zzdi.zzf(minBufferSize != -2);
        int i17 = iZzm2 != -1 ? iZzm2 : 1;
        int i18 = 250000;
        if (i12 == 0) {
            i13 = i12;
            iMax = Math.max(zzqr.zza(250000, i11, i17), Math.min(minBufferSize * 4, zzqr.zza(750000, i11, i17)));
        } else if (i12 != 1) {
            if (iIntValue == 5) {
                i18 = 500000;
            } else if (iIntValue == 8) {
                i18 = PlaybackException.CUSTOM_ERROR_CODE_BASE;
                iIntValue = 8;
            }
            i13 = i12;
            iMax = zzgap.zzb((((long) i18) * ((long) (i16 != -1 ? zzgah.zzb(i16, 8, RoundingMode.CEILING) : zzqr.zzb(iIntValue)))) / 1000000);
        } else {
            i13 = i12;
            iMax = zzgap.zzb((((long) zzqr.zzb(iIntValue)) * 50000000) / 1000000);
        }
        this.zzW = false;
        zzqc zzqcVar = new zzqc(zzafVar, iZzm, i13, iZzm2, i11, iIntValue2, iIntValue, (((Math.max(minBufferSize, iMax) + i17) - 1) / i17) * i17, zzcqVar, false, false, false);
        if (zzW()) {
            this.zzq = zzqcVar;
        } else {
            this.zzr = zzqcVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzf() {
        zzqh zzqhVar;
        if (zzW()) {
            this.zzC = 0L;
            this.zzD = 0L;
            this.zzE = 0L;
            this.zzF = 0L;
            this.zzX = false;
            this.zzG = 0;
            this.zzz = new zzqf(this.zzA, 0L, 0L, null);
            this.zzJ = 0L;
            this.zzy = null;
            this.zzk.clear();
            this.zzL = null;
            this.zzM = 0;
            this.zzN = null;
            this.zzP = false;
            this.zzO = false;
            this.zzQ = false;
            this.zzf.zzp();
            zzT();
            if (this.zzj.zzg()) {
                this.zzt.pause();
            }
            if (zzX(this.zzt)) {
                zzqn zzqnVar = this.zzl;
                zzqnVar.getClass();
                zzqnVar.zzb(this.zzt);
            }
            int i10 = zzet.zza;
            final zzpf zzpfVarZzb = this.zzr.zzb();
            zzqc zzqcVar = this.zzq;
            if (zzqcVar != null) {
                this.zzr = zzqcVar;
                this.zzq = null;
            }
            this.zzj.zzc();
            if (zzet.zza >= 24 && (zzqhVar = this.zzw) != null) {
                zzqhVar.zzb();
                this.zzw = null;
            }
            final AudioTrack audioTrack = this.zzt;
            final zzdm zzdmVar = this.zzi;
            final zzpi zzpiVar = this.zzp;
            zzdmVar.zzc();
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzet.zzE("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpu
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzqp.zzH(audioTrack, zzpiVar, handler, zzpfVarZzb, zzdmVar);
                    }
                });
            }
            this.zzt = null;
        }
        this.zzn.zza();
        this.zzm.zza();
        this.zzZ = 0L;
        this.zzaa = 0L;
        Handler handler2 = this.zzab;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzg() {
        this.zzH = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzh() {
        this.zzR = false;
        if (zzW()) {
            if (this.zzj.zzj() || zzX(this.zzt)) {
                this.zzt.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzi() {
        this.zzR = true;
        if (zzW()) {
            this.zzj.zze();
            this.zzt.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzj() throws zzpk {
        if (!this.zzO && zzW() && zzV()) {
            zzP();
            this.zzO = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzk() {
        zzom zzomVar = this.zzv;
        if (zzomVar != null) {
            zzomVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzl() {
        zzf();
        zzfxr zzfxrVar = this.zzg;
        int size = zzfxrVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((zzct) zzfxrVar.get(i10)).zzf();
        }
        zzfxr zzfxrVar2 = this.zzh;
        int size2 = zzfxrVar2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((zzct) zzfxrVar2.get(i11)).zzf();
        }
        zzcq zzcqVar = this.zzs;
        if (zzcqVar != null) {
            zzcqVar.zzf();
        }
        this.zzR = false;
        this.zzW = false;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzm(zzh zzhVar) {
        if (this.zzx.equals(zzhVar)) {
            return;
        }
        this.zzx = zzhVar;
        zzom zzomVar = this.zzv;
        if (zzomVar != null) {
            zzomVar.zzg(zzhVar);
        }
        zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzn(int i10) {
        if (this.zzS != i10) {
            this.zzS = i10;
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzo(zzi zziVar) {
        if (this.zzT.equals(zziVar)) {
            return;
        }
        if (this.zzt != null) {
            int i10 = this.zzT.zza;
        }
        this.zzT = zziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzp(zzpi zzpiVar) {
        this.zzp = zzpiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    @RequiresApi(29)
    public final void zzq(int i10, int i11) {
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzX(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzr(zzbq zzbqVar) {
        this.zzA = new zzbq(Math.max(0.1f, Math.min(zzbqVar.zzb, 8.0f)), Math.max(0.1f, Math.min(zzbqVar.zzc, 8.0f)));
        zzR(zzbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzs(@Nullable zznz zznzVar) {
        this.zzo = zznzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    @RequiresApi(23)
    public final void zzt(@Nullable AudioDeviceInfo audioDeviceInfo) {
        this.zzU = audioDeviceInfo == null ? null : new zzon(audioDeviceInfo);
        zzom zzomVar = this.zzv;
        if (zzomVar != null) {
            zzomVar.zzh(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzpy.zza(audioTrack, this.zzU);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzu(boolean z10) {
        this.zzB = z10;
        zzR(this.zzA);
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final void zzv(float f10) {
        if (this.zzK != f10) {
            this.zzK = f10;
            zzS();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:134:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0262  */
    @Override // com.google.android.gms.internal.ads.zzpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzw(java.nio.ByteBuffer r28, long r29, int r31) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqp.zzw(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final boolean zzx() {
        if (zzW()) {
            return !(zzet.zza >= 29 && this.zzt.isOffloadedPlayback() && this.zzQ) && this.zzj.zzf(zzK());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final boolean zzy() {
        if (zzW()) {
            return this.zzO && !zzx();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzpl
    public final boolean zzz(zzaf zzafVar) {
        return zza(zzafVar) != 0;
    }
}
