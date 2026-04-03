package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.TsExtractor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqv extends zzso implements zzkg {
    private final Context zzb;
    private final zzpd zzc;
    private final zzpl zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;

    @Nullable
    private zzaf zzh;

    @Nullable
    private zzaf zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;

    public zzqv(Context context, zzsa zzsaVar, zzsq zzsqVar, boolean z10, @Nullable Handler handler, @Nullable zzpe zzpeVar, zzpl zzplVar) {
        super(1, zzsaVar, zzsqVar, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzplVar;
        this.zzn = -1000;
        this.zzc = new zzpd(handler, zzpeVar);
        zzplVar.zzp(new zzqu(this, null));
    }

    private final int zzaO(zzsf zzsfVar, zzaf zzafVar) {
        int i10;
        if (!"OMX.google.raw.decoder".equals(zzsfVar.zza) || (i10 = zzet.zza) >= 24 || (i10 == 23 && zzet.zzN(this.zzb))) {
            return zzafVar.zzn;
        }
        return -1;
    }

    private static List zzaP(zzsq zzsqVar, zzaf zzafVar, boolean z10, zzpl zzplVar) throws zzsw {
        zzsf zzsfVarZzb;
        return zzafVar.zzm == null ? zzfxr.zzm() : (!zzplVar.zzz(zzafVar) || (zzsfVarZzb = zztc.zzb()) == null) ? zztc.zzf(zzsqVar, zzafVar, false, false) : zzfxr.zzn(zzsfVarZzb);
    }

    private final void zzaQ() {
        long jZzb = this.zzd.zzb(zzW());
        if (jZzb != Long.MIN_VALUE) {
            if (!this.zzk) {
                jZzb = Math.max(this.zzj, jZzb);
            }
            this.zzj = jZzb;
            this.zzk = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    protected final void zzA() {
        this.zzd.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzC() {
        this.zzm = false;
        try {
            super.zzC();
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
        } catch (Throwable th) {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    protected final void zzD() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    protected final void zzE() {
        zzaQ();
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzle, com.google.android.gms.internal.ads.zzlh
    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzW() {
        return super.zzW() && this.zzd.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzX() {
        return this.zzd.zzx() || super.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final float zzZ(float f10, zzaf zzafVar, zzaf[] zzafVarArr) {
        int iMax = -1;
        for (zzaf zzafVar2 : zzafVarArr) {
            int i10 = zzafVar2.zzA;
            if (i10 != -1) {
                iMax = Math.max(iMax, i10);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f10;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final long zza() {
        if (zzcV() == 2) {
            zzaQ();
        }
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final int zzaa(zzsq zzsqVar, zzaf zzafVar) throws zzsw {
        int i10;
        boolean z10;
        if (!zzbn.zzg(zzafVar.zzm)) {
            return 128;
        }
        int i11 = zzet.zza;
        int i12 = zzafVar.zzG;
        boolean zZzaN = zzso.zzaN(zzafVar);
        int i13 = 1;
        if (!zZzaN || (i12 != 0 && zztc.zzb() == null)) {
            i10 = 0;
        } else {
            zzoq zzoqVarZzd = this.zzd.zzd(zzafVar);
            if (zzoqVarZzd.zzb) {
                i10 = true != zzoqVarZzd.zzc ? 512 : 1536;
                if (zzoqVarZzd.zzd) {
                    i10 |= 2048;
                }
            } else {
                i10 = 0;
            }
            if (this.zzd.zzz(zzafVar)) {
                return i10 | TsExtractor.TS_STREAM_TYPE_AC4;
            }
        }
        if ((!MimeTypes.AUDIO_RAW.equals(zzafVar.zzm) || this.zzd.zzz(zzafVar)) && this.zzd.zzz(zzet.zzz(2, zzafVar.zzz, zzafVar.zzA))) {
            List listZzaP = zzaP(zzsqVar, zzafVar, false, this.zzd);
            if (!listZzaP.isEmpty()) {
                if (zZzaN) {
                    zzsf zzsfVar = (zzsf) listZzaP.get(0);
                    boolean zZze = zzsfVar.zze(zzafVar);
                    if (zZze) {
                        z10 = true;
                    } else {
                        for (int i14 = 1; i14 < listZzaP.size(); i14++) {
                            zzsf zzsfVar2 = (zzsf) listZzaP.get(i14);
                            if (zzsfVar2.zze(zzafVar)) {
                                z10 = false;
                                zZze = true;
                                zzsfVar = zzsfVar2;
                                break;
                            }
                        }
                        z10 = true;
                    }
                    int i15 = true != zZze ? 3 : 4;
                    int i16 = 8;
                    if (zZze && zzsfVar.zzf(zzafVar)) {
                        i16 = 16;
                    }
                    return i15 | i16 | 32 | (true != zzsfVar.zzg ? 0 : 64) | (true != z10 ? 0 : 128) | i10;
                }
                i13 = 2;
            }
        }
        return i13 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final zzho zzab(zzsf zzsfVar, zzaf zzafVar, zzaf zzafVar2) {
        int i10;
        int i11;
        zzho zzhoVarZzb = zzsfVar.zzb(zzafVar, zzafVar2);
        int i12 = zzhoVarZzb.zze;
        if (zzaL(zzafVar2)) {
            i12 |= 32768;
        }
        if (zzaO(zzsfVar, zzafVar2) > this.zze) {
            i12 |= 64;
        }
        String str = zzsfVar.zza;
        if (i12 != 0) {
            i11 = i12;
            i10 = 0;
        } else {
            i10 = zzhoVarZzb.zzd;
            i11 = 0;
        }
        return new zzho(str, zzafVar, zzafVar2, i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    @Nullable
    protected final zzho zzac(zzjz zzjzVar) throws zzhw {
        zzaf zzafVar = zzjzVar.zza;
        zzafVar.getClass();
        this.zzh = zzafVar;
        zzho zzhoVarZzac = super.zzac(zzjzVar);
        this.zzc.zzi(zzafVar, zzhoVarZzac);
        return zzhoVarZzac;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d2  */
    @Override // com.google.android.gms.internal.ads.zzso
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.google.android.gms.internal.ads.zzrz zzaf(com.google.android.gms.internal.ads.zzsf r8, com.google.android.gms.internal.ads.zzaf r9, @androidx.annotation.Nullable android.media.MediaCrypto r10, float r11) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqv.zzaf(com.google.android.gms.internal.ads.zzsf, com.google.android.gms.internal.ads.zzaf, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrz");
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final List zzag(zzsq zzsqVar, zzaf zzafVar, boolean z10) throws zzsw {
        return zztc.zzg(zzaP(zzsqVar, zzafVar, false, this.zzd), zzafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzaj(zzhd zzhdVar) {
        zzaf zzafVar;
        if (zzet.zza < 29 || (zzafVar = zzhdVar.zza) == null || !Objects.equals(zzafVar.zzm, MimeTypes.AUDIO_OPUS) || !zzaK()) {
            return;
        }
        ByteBuffer byteBuffer = zzhdVar.zzf;
        byteBuffer.getClass();
        zzaf zzafVar2 = zzhdVar.zza;
        zzafVar2.getClass();
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzq(zzafVar2.zzC, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / C.NANOS_PER_SECOND));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzak(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzal(String str, zzrz zzrzVar, long j10, long j11) {
        this.zzc.zze(str, j10, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzam(String str) {
        this.zzc.zzf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzan(zzaf zzafVar, @Nullable MediaFormat mediaFormat) throws zzhw {
        int[] iArr;
        int i10;
        zzaf zzafVar2 = this.zzi;
        int[] iArr2 = null;
        if (zzafVar2 != null) {
            zzafVar = zzafVar2;
        } else if (zzay() != null) {
            mediaFormat.getClass();
            int iZzl = MimeTypes.AUDIO_RAW.equals(zzafVar.zzm) ? zzafVar.zzB : (zzet.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? zzet.zzl(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding");
            zzad zzadVar = new zzad();
            zzadVar.zzX(MimeTypes.AUDIO_RAW);
            zzadVar.zzR(iZzl);
            zzadVar.zzF(zzafVar.zzC);
            zzadVar.zzG(zzafVar.zzD);
            zzadVar.zzQ(zzafVar.zzk);
            zzadVar.zzK(zzafVar.zza);
            zzadVar.zzM(zzafVar.zzb);
            zzadVar.zzN(zzafVar.zzc);
            zzadVar.zzO(zzafVar.zzd);
            zzadVar.zzZ(zzafVar.zze);
            zzadVar.zzV(zzafVar.zzf);
            zzadVar.zzy(mediaFormat.getInteger("channel-count"));
            zzadVar.zzY(mediaFormat.getInteger("sample-rate"));
            zzaf zzafVarZzad = zzadVar.zzad();
            if (this.zzf && zzafVarZzad.zzz == 6 && (i10 = zzafVar.zzz) < 6) {
                iArr2 = new int[i10];
                for (int i11 = 0; i11 < zzafVar.zzz; i11++) {
                    iArr2[i11] = i11;
                }
            } else if (this.zzg) {
                int i12 = zzafVarZzad.zzz;
                if (i12 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i12 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i12 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i12 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i12 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzafVar = zzafVarZzad;
        }
        try {
            int i13 = zzet.zza;
            if (i13 >= 29) {
                if (zzaK()) {
                    zzm();
                }
                zzdi.zzf(i13 >= 29);
            }
            this.zzd.zze(zzafVar, 0, iArr2);
        } catch (zzpg e10) {
            throw zzi(e10, e10.zza, false, 5001);
        }
    }

    @CallSuper
    protected final void zzao() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzap() {
        this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzaq() throws zzhw {
        try {
            this.zzd.zzj();
        } catch (zzpk e10) {
            throw zzi(e10, e10.zzc, e10.zzb, true != zzaK() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final boolean zzar(long j10, long j11, @Nullable zzsc zzscVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, zzaf zzafVar) throws zzhw {
        byteBuffer.getClass();
        if (this.zzi != null && (i11 & 2) != 0) {
            zzscVar.getClass();
            zzscVar.zzn(i10, false);
            return true;
        }
        if (z10) {
            if (zzscVar != null) {
                zzscVar.zzn(i10, false);
            }
            ((zzso) this).zza.zzf += i12;
            this.zzd.zzg();
            return true;
        }
        try {
            if (!this.zzd.zzw(byteBuffer, j12, i12)) {
                return false;
            }
            if (zzscVar != null) {
                zzscVar.zzn(i10, false);
            }
            ((zzso) this).zza.zze += i12;
            return true;
        } catch (zzph e10) {
            zzaf zzafVar2 = this.zzh;
            if (zzaK()) {
                zzm();
            }
            throw zzi(e10, zzafVar2, e10.zzb, 5001);
        } catch (zzpk e11) {
            if (zzaK()) {
                zzm();
            }
            throw zzi(e11, zzafVar, e11.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final boolean zzas(zzaf zzafVar) {
        zzm();
        return this.zzd.zzz(zzafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final zzbq zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zzg(zzbq zzbqVar) {
        this.zzd.zzr(zzbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final boolean zzj() {
        boolean z10 = this.zzm;
        this.zzm = false;
        return z10;
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzkz
    public final void zzt(int i10, @Nullable Object obj) throws zzhw {
        if (i10 == 2) {
            zzpl zzplVar = this.zzd;
            obj.getClass();
            zzplVar.zzv(((Float) obj).floatValue());
            return;
        }
        if (i10 == 3) {
            zzh zzhVar = (zzh) obj;
            zzpl zzplVar2 = this.zzd;
            zzhVar.getClass();
            zzplVar2.zzm(zzhVar);
            return;
        }
        if (i10 == 6) {
            zzi zziVar = (zzi) obj;
            zzpl zzplVar3 = this.zzd;
            zziVar.getClass();
            zzplVar3.zzo(zziVar);
            return;
        }
        if (i10 == 12) {
            if (zzet.zza >= 23) {
                zzqs.zza(this.zzd, obj);
                return;
            }
            return;
        }
        if (i10 == 16) {
            obj.getClass();
            this.zzn = ((Integer) obj).intValue();
            zzsc zzscVarZzay = zzay();
            if (zzscVarZzay != null && zzet.zza >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.zzn));
                zzscVarZzay.zzp(bundle);
                return;
            }
            return;
        }
        if (i10 == 9) {
            zzpl zzplVar4 = this.zzd;
            obj.getClass();
            zzplVar4.zzu(((Boolean) obj).booleanValue());
        } else {
            if (i10 != 10) {
                super.zzt(i10, obj);
                return;
            }
            zzpl zzplVar5 = this.zzd;
            obj.getClass();
            zzplVar5.zzn(((Integer) obj).intValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzw() {
        this.zzl = true;
        this.zzh = null;
        try {
            this.zzd.zzf();
            super.zzw();
        } catch (Throwable th) {
            super.zzw();
            throw th;
        } finally {
            this.zzc.zzg(((zzso) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzx(boolean z10, boolean z11) throws zzhw {
        super.zzx(z10, z11);
        this.zzc.zzh(((zzso) this).zza);
        zzm();
        this.zzd.zzs(zzn());
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzz(long j10, boolean z10) throws zzhw {
        super.zzz(j10, z10);
        this.zzd.zzf();
        this.zzj = j10;
        this.zzm = false;
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzle
    @Nullable
    public final zzkg zzk() {
        return this;
    }
}
