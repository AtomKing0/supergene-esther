package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaaa extends zzso implements zzaag {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private zzcp zzA;

    @Nullable
    private zzcp zzB;
    private boolean zzC;
    private int zzD;
    private int zzE;

    @Nullable
    private zzaae zzF;
    private final Context zze;
    private final zzabc zzf;
    private final zzaax zzg;
    private final boolean zzh;
    private final zzaah zzi;
    private final zzaaf zzj;
    private boolean zzk;
    private boolean zzl;
    private zzzz zzm;
    private boolean zzn;
    private boolean zzo;

    @Nullable
    private Surface zzp;

    @Nullable
    private zzaad zzq;
    private boolean zzr;
    private int zzs;
    private long zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    public zzaaa(Context context, zzsa zzsaVar, zzsq zzsqVar, long j10, boolean z10, @Nullable Handler handler, @Nullable zzaay zzaayVar, int i10, float f10) {
        super(2, zzsaVar, zzsqVar, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzg = new zzaax(handler, zzaayVar);
        zzzt zzztVarZzc = new zzzg(applicationContext, new zzaah(applicationContext, this, 0L)).zzc();
        this.zzf = zzztVarZzc.zzi();
        zzaah zzaahVarZzh = zzztVarZzc.zzh();
        zzdi.zzb(zzaahVarZzh);
        this.zzi = zzaahVarZzh;
        this.zzj = new zzaaf();
        this.zzh = "NVIDIA".equals(zzet.zzc);
        this.zzs = 1;
        this.zzA = zzcp.zza;
        this.zzE = 0;
        this.zzB = null;
        this.zzD = -1000;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static final boolean zzaS(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 2922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzaS(java.lang.String):boolean");
    }

    private static List zzaT(Context context, zzsq zzsqVar, zzaf zzafVar, boolean z10, boolean z11) throws zzsw {
        String str = zzafVar.zzm;
        if (str == null) {
            return zzfxr.zzm();
        }
        if (zzet.zza >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(str) && !zzzy.zza(context)) {
            List listZzd = zztc.zzd(zzsqVar, zzafVar, z10, z11);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zztc.zzf(zzsqVar, zzafVar, z10, z11);
    }

    private final void zzaU() {
        zzcp zzcpVar = this.zzB;
        if (zzcpVar != null) {
            this.zzg.zzt(zzcpVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaV() {
        this.zzg.zzq(this.zzp);
        this.zzr = true;
    }

    private final void zzaW() {
        Surface surface = this.zzp;
        zzaad zzaadVar = this.zzq;
        if (surface == zzaadVar) {
            this.zzp = null;
        }
        if (zzaadVar != null) {
            zzaadVar.release();
            this.zzq = null;
        }
    }

    private final boolean zzaX(zzsf zzsfVar) {
        if (zzet.zza < 23 || zzaS(zzsfVar.zza)) {
            return false;
        }
        return !zzsfVar.zzf || zzaad.zzb(this.zze);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int zzad(zzsf zzsfVar, zzaf zzafVar) {
        int i10;
        int iIntValue;
        int i11 = zzafVar.zzr;
        int i12 = zzafVar.zzs;
        if (i11 != -1 && i12 != -1) {
            String str = zzafVar.zzm;
            str.getClass();
            if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
                Pair pairZza = zztc.zza(zzafVar);
                str = (pairZza == null || !((iIntValue = ((Integer) pairZza.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
            }
            i10 = 4;
            switch (str) {
                case "video/3gpp":
                case "video/mp4v-es":
                case "video/av01":
                case "video/x-vnd.on2.vp8":
                    return ((i11 * i12) * 3) / i10;
                case "video/hevc":
                    return Math.max(2097152, ((i11 * i12) * 3) / 4);
                case "video/avc":
                    String str2 = zzet.zzd;
                    if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(zzet.zzc) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !zzsfVar.zzf)))) {
                        return ((((i11 + 15) / 16) * ((i12 + 15) / 16)) * 768) / 4;
                    }
                    break;
                case "video/x-vnd.on2.vp9":
                    i10 = 8;
                    return ((i11 * i12) * 3) / i10;
            }
        }
        return -1;
    }

    protected static int zzae(zzsf zzsfVar, zzaf zzafVar) {
        if (zzafVar.zzn == -1) {
            return zzad(zzsfVar, zzafVar);
        }
        int size = zzafVar.zzo.size();
        int length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            length += ((byte[]) zzafVar.zzo.get(i10)).length;
        }
        return zzafVar.zzn + length;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    protected final void zzA() {
        ((zzzr) this.zzf).zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzC() {
        try {
            super.zzC();
            this.zzl = false;
            if (this.zzq != null) {
                zzaW();
            }
        } catch (Throwable th) {
            this.zzl = false;
            if (this.zzq != null) {
                zzaW();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    protected final void zzD() {
        this.zzu = 0;
        zzh();
        this.zzt = SystemClock.elapsedRealtime();
        this.zzx = 0L;
        this.zzy = 0;
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzg();
        } else {
            this.zzi.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    protected final void zzE() {
        if (this.zzu > 0) {
            zzh();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzu, jElapsedRealtime - this.zzt);
            this.zzu = 0;
            this.zzt = jElapsedRealtime;
        }
        int i10 = this.zzy;
        if (i10 != 0) {
            this.zzg.zzr(this.zzx, i10);
            this.zzx = 0L;
            this.zzy = 0;
        }
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzh();
        } else {
            this.zzi.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzle
    public final void zzM(float f10, float f11) throws zzhw {
        super.zzM(f10, f11);
        this.zzi.zzm(f10);
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zze.zzd(f10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzle, com.google.android.gms.internal.ads.zzlh
    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    @CallSuper
    public final void zzV(long j10, long j11) throws zzhw {
        super.zzV(j10, j11);
        if (this.zzk) {
            try {
                this.zzf.zzg(j10, j11);
            } catch (zzabb e10) {
                throw zzi(e10, e10.zza, false, 7001);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzW() {
        return super.zzW() && !this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzX() {
        zzaad zzaadVar;
        boolean z10 = false;
        if (super.zzX() && !this.zzk) {
            z10 = true;
        }
        if (!z10 || (((zzaadVar = this.zzq) == null || this.zzp != zzaadVar) && zzay() != null)) {
            return this.zzi.zzn(z10);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final float zzZ(float f10, zzaf zzafVar, zzaf[] zzafVarArr) {
        float fMax = -1.0f;
        for (zzaf zzafVar2 : zzafVarArr) {
            float f11 = zzafVar2.zzt;
            if (f11 != -1.0f) {
                fMax = Math.max(fMax, f11);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f10;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    @CallSuper
    protected final void zzaC(long j10) {
        super.zzaC(j10);
        this.zzw--;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    @CallSuper
    protected final void zzaD(zzhd zzhdVar) throws zzhw {
        this.zzw++;
        int i10 = zzet.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    @CallSuper
    protected final void zzaE(zzaf zzafVar) throws zzhw {
        if (this.zzk) {
            try {
                zzabc zzabcVar = this.zzf;
                zzzt.zzd(((zzzr) zzabcVar).zza, zzafVar, zzh());
                this.zzf.zzh(new zzzx(this), zzgda.zzb());
            } catch (zzabb e10) {
                throw zzi(e10, zzafVar, false, 7000);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    @CallSuper
    protected final void zzaG() {
        super.zzaG();
        this.zzw = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final boolean zzaM(zzsf zzsfVar) {
        return this.zzp != null || zzaX(zzsfVar);
    }

    protected final void zzaO(zzsc zzscVar, int i10, long j10) {
        Trace.beginSection("skipVideoBuffer");
        zzscVar.zzn(i10, false);
        Trace.endSection();
        ((zzso) this).zza.zzf++;
    }

    protected final void zzaP(int i10, int i11) {
        zzhn zzhnVar = ((zzso) this).zza;
        zzhnVar.zzh += i10;
        int i12 = i10 + i11;
        zzhnVar.zzg += i12;
        this.zzu += i12;
        int i13 = this.zzv + i12;
        this.zzv = i13;
        zzhnVar.zzi = Math.max(i13, zzhnVar.zzi);
    }

    protected final void zzaQ(long j10) {
        zzhn zzhnVar = ((zzso) this).zza;
        zzhnVar.zzk += j10;
        zzhnVar.zzl++;
        this.zzx += j10;
        this.zzy++;
    }

    protected final boolean zzaR(long j10, boolean z10) throws zzhw {
        int iZzd = zzd(j10);
        if (iZzd == 0) {
            return false;
        }
        if (z10) {
            zzhn zzhnVar = ((zzso) this).zza;
            zzhnVar.zzd += iZzd;
            zzhnVar.zzf += this.zzw;
        } else {
            ((zzso) this).zza.zzj++;
            zzaP(iZzd, this.zzw);
        }
        zzaI();
        if (this.zzk) {
            this.zzf.zze();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final int zzaa(zzsq zzsqVar, zzaf zzafVar) throws zzsw {
        boolean z10;
        if (!zzbn.zzi(zzafVar.zzm)) {
            return 128;
        }
        int i10 = 1;
        int i11 = 0;
        boolean z11 = zzafVar.zzp != null;
        List listZzaT = zzaT(this.zze, zzsqVar, zzafVar, z11, false);
        if (z11 && listZzaT.isEmpty()) {
            listZzaT = zzaT(this.zze, zzsqVar, zzafVar, false, false);
        }
        if (!listZzaT.isEmpty()) {
            if (zzso.zzaN(zzafVar)) {
                zzsf zzsfVar = (zzsf) listZzaT.get(0);
                boolean zZze = zzsfVar.zze(zzafVar);
                if (zZze) {
                    z10 = true;
                } else {
                    for (int i12 = 1; i12 < listZzaT.size(); i12++) {
                        zzsf zzsfVar2 = (zzsf) listZzaT.get(i12);
                        if (zzsfVar2.zze(zzafVar)) {
                            zZze = true;
                            z10 = false;
                            zzsfVar = zzsfVar2;
                            break;
                        }
                    }
                    z10 = true;
                }
                int i13 = true != zZze ? 3 : 4;
                int i14 = true != zzsfVar.zzf(zzafVar) ? 8 : 16;
                int i15 = true != zzsfVar.zzg ? 0 : 64;
                int i16 = true != z10 ? 0 : 128;
                if (zzet.zza >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(zzafVar.zzm) && !zzzy.zza(this.zze)) {
                    i16 = 256;
                }
                if (zZze) {
                    List listZzaT2 = zzaT(this.zze, zzsqVar, zzafVar, z11, true);
                    if (!listZzaT2.isEmpty()) {
                        zzsf zzsfVar3 = (zzsf) zztc.zzg(listZzaT2, zzafVar).get(0);
                        if (zzsfVar3.zze(zzafVar) && zzsfVar3.zzf(zzafVar)) {
                            i11 = 32;
                        }
                    }
                }
                return i13 | i14 | i11 | i15 | i16;
            }
            i10 = 2;
        }
        return i10 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final zzho zzab(zzsf zzsfVar, zzaf zzafVar, zzaf zzafVar2) {
        int i10;
        int i11;
        zzho zzhoVarZzb = zzsfVar.zzb(zzafVar, zzafVar2);
        int i12 = zzhoVarZzb.zze;
        zzzz zzzzVar = this.zzm;
        zzzzVar.getClass();
        if (zzafVar2.zzr > zzzzVar.zza || zzafVar2.zzs > zzzzVar.zzb) {
            i12 |= 256;
        }
        if (zzae(zzsfVar, zzafVar2) > zzzzVar.zzc) {
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
        zzho zzhoVarZzac = super.zzac(zzjzVar);
        zzaf zzafVar = zzjzVar.zza;
        zzafVar.getClass();
        this.zzg.zzf(zzafVar, zzhoVarZzac);
        return zzhoVarZzac;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ff, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x020d  */
    @Override // com.google.android.gms.internal.ads.zzso
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.google.android.gms.internal.ads.zzrz zzaf(com.google.android.gms.internal.ads.zzsf r20, com.google.android.gms.internal.ads.zzaf r21, @androidx.annotation.Nullable android.media.MediaCrypto r22, float r23) {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzaf(com.google.android.gms.internal.ads.zzsf, com.google.android.gms.internal.ads.zzaf, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrz");
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final List zzag(zzsq zzsqVar, zzaf zzafVar, boolean z10) throws zzsw {
        return zztc.zzg(zzaT(this.zze, zzsqVar, zzafVar, false, false), zzafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    @TargetApi(29)
    protected final void zzaj(zzhd zzhdVar) throws zzhw {
        if (this.zzo) {
            ByteBuffer byteBuffer = zzhdVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b10 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                byteBuffer.position(0);
                if (b10 == -75 && s10 == 60 && s11 == 1 && b11 == 4) {
                    if (b12 == 0 || b12 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzsc zzscVarZzay = zzay();
                        zzscVarZzay.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzscVarZzay.zzp(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzak(Exception exc) {
        zzea.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzal(String str, zzrz zzrzVar, long j10, long j11) {
        this.zzg.zza(str, j10, j11);
        this.zzn = zzaS(str);
        zzsf zzsfVarZzaA = zzaA();
        zzsfVarZzaA.getClass();
        boolean z10 = false;
        if (zzet.zza >= 29 && MimeTypes.VIDEO_VP9.equals(zzsfVarZzaA.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzh = zzsfVarZzaA.zzh();
            int length = codecProfileLevelArrZzh.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (codecProfileLevelArrZzh[i10].profile == 16384) {
                    z10 = true;
                    break;
                }
                i10++;
            }
        }
        this.zzo = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzam(String str) {
        this.zzg.zzb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzan(zzaf zzafVar, @Nullable MediaFormat mediaFormat) {
        zzsc zzscVarZzay = zzay();
        if (zzscVarZzay != null) {
            zzscVarZzay.zzq(this.zzs);
        }
        mediaFormat.getClass();
        boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z10 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z10 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f10 = zzafVar.zzv;
        int i10 = zzet.zza;
        int i11 = zzafVar.zzu;
        if (i11 == 90 || i11 == 270) {
            f10 = 1.0f / f10;
            int i12 = integer2;
            integer2 = integer;
            integer = i12;
        }
        this.zzA = new zzcp(integer, integer2, 0, f10);
        if (!this.zzk) {
            this.zzi.zzk(zzafVar.zzt);
            return;
        }
        zzabc zzabcVar = this.zzf;
        zzad zzadVarZzb = zzafVar.zzb();
        zzadVarZzb.zzac(integer);
        zzadVarZzb.zzI(integer2);
        zzadVarZzb.zzW(0);
        zzadVarZzb.zzT(f10);
        zzabcVar.zzf(1, zzadVarZzb.zzad());
    }

    @RequiresApi(21)
    protected final void zzao(zzsc zzscVar, int i10, long j10, long j11) {
        Trace.beginSection("releaseOutputBuffer");
        zzscVar.zzm(i10, j11);
        Trace.endSection();
        ((zzso) this).zza.zze++;
        this.zzv = 0;
        if (this.zzk) {
            return;
        }
        zzcp zzcpVar = this.zzA;
        if (!zzcpVar.equals(zzcp.zza) && !zzcpVar.equals(this.zzB)) {
            this.zzB = zzcpVar;
            this.zzg.zzt(zzcpVar);
        }
        if (!this.zzi.zzo() || this.zzp == null) {
            return;
        }
        zzaV();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final void zzap() {
        if (this.zzk) {
            this.zzf.zzi(zzau());
        } else {
            this.zzi.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final boolean zzar(long j10, long j11, @Nullable zzsc zzscVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, zzaf zzafVar) throws zzhw {
        zzscVar.getClass();
        long jZzau = j12 - zzau();
        int iZza = this.zzi.zza(j12, j10, j11, zzav(), z11, this.zzj);
        if (iZza != 4) {
            if (z10 && !z11) {
                zzaO(zzscVar, i10, jZzau);
                return true;
            }
            if (this.zzp != this.zzq || this.zzk) {
                if (this.zzk) {
                    try {
                        this.zzf.zzg(j10, j11);
                        long jZzd = this.zzf.zzd(jZzau, z11);
                        if (jZzd != C.TIME_UNSET) {
                            int i13 = zzet.zza;
                            zzao(zzscVar, i10, jZzau, jZzd);
                            return true;
                        }
                    } catch (zzabb e10) {
                        throw zzi(e10, e10.zza, false, 7001);
                    }
                } else {
                    if (iZza == 0) {
                        zzh();
                        long jNanoTime = System.nanoTime();
                        int i14 = zzet.zza;
                        zzao(zzscVar, i10, jZzau, jNanoTime);
                        zzaQ(this.zzj.zzc());
                        return true;
                    }
                    if (iZza == 1) {
                        zzaaf zzaafVar = this.zzj;
                        long jZzd2 = zzaafVar.zzd();
                        long jZzc = zzaafVar.zzc();
                        int i15 = zzet.zza;
                        if (jZzd2 == this.zzz) {
                            zzaO(zzscVar, i10, jZzau);
                        } else {
                            zzao(zzscVar, i10, jZzau, jZzd2);
                        }
                        zzaQ(jZzc);
                        this.zzz = jZzd2;
                        return true;
                    }
                    if (iZza == 2) {
                        Trace.beginSection("dropVideoBuffer");
                        zzscVar.zzn(i10, false);
                        Trace.endSection();
                        zzaP(0, 1);
                        zzaQ(this.zzj.zzc());
                        return true;
                    }
                    if (iZza == 3) {
                        zzaO(zzscVar, i10, jZzau);
                        zzaQ(this.zzj.zzc());
                        return true;
                    }
                    if (iZza != 5) {
                        throw new IllegalStateException(String.valueOf(iZza));
                    }
                }
            } else if (this.zzj.zzc() < 30000) {
                zzaO(zzscVar, i10, jZzau);
                zzaQ(this.zzj.zzc());
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final int zzat(zzhd zzhdVar) {
        int i10 = zzet.zza;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    protected final zzse zzaz(Throwable th, @Nullable zzsf zzsfVar) {
        return new zzzw(th, zzsfVar, this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzle
    public final void zzs() {
        this.zzi.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzsc] */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.google.android.gms.internal.ads.zzaah] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [com.google.android.gms.internal.ads.zzaad] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzkz
    public final void zzt(int i10, @Nullable Object obj) throws zzhw {
        if (i10 != 1) {
            if (i10 == 7) {
                obj.getClass();
                zzaae zzaaeVar = (zzaae) obj;
                this.zzF = zzaaeVar;
                ((zzzr) this.zzf).zza.zzj = zzaaeVar;
                return;
            }
            if (i10 == 10) {
                obj.getClass();
                int iIntValue = ((Integer) obj).intValue();
                if (this.zzE != iIntValue) {
                    this.zzE = iIntValue;
                    return;
                }
                return;
            }
            if (i10 == 16) {
                obj.getClass();
                this.zzD = ((Integer) obj).intValue();
                zzsc zzscVarZzay = zzay();
                if (zzscVarZzay == null || zzet.zza < 35) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.zzD));
                zzscVarZzay.zzp(bundle);
                return;
            }
            if (i10 == 4) {
                obj.getClass();
                int iIntValue2 = ((Integer) obj).intValue();
                this.zzs = iIntValue2;
                zzsc zzscVarZzay2 = zzay();
                if (zzscVarZzay2 != null) {
                    zzscVarZzay2.zzq(iIntValue2);
                    return;
                }
                return;
            }
            if (i10 == 5) {
                zzaah zzaahVar = this.zzi;
                obj.getClass();
                zzaahVar.zzj(((Integer) obj).intValue());
                return;
            }
            if (i10 == 13) {
                obj.getClass();
                this.zzf.zzj((List) obj);
                this.zzC = true;
                return;
            } else {
                if (i10 != 14) {
                    super.zzt(i10, obj);
                    return;
                }
                obj.getClass();
                zzel zzelVar = (zzel) obj;
                if (zzelVar.zzb() == 0 || zzelVar.zza() == 0) {
                    return;
                }
                zzabc zzabcVar = this.zzf;
                Surface surface = this.zzp;
                zzdi.zzb(surface);
                ((zzzr) zzabcVar).zza.zzu(surface, zzelVar);
                return;
            }
        }
        ?? Zza = obj instanceof Surface ? (Surface) obj : 0;
        if (Zza == 0) {
            zzaad zzaadVar = this.zzq;
            if (zzaadVar != null) {
                Zza = zzaadVar;
            } else {
                zzsf zzsfVarZzaA = zzaA();
                if (zzsfVarZzaA != null && zzaX(zzsfVarZzaA)) {
                    Zza = zzaad.zza(this.zze, zzsfVarZzaA.zzf);
                    this.zzq = Zza;
                }
            }
        }
        if (this.zzp == Zza) {
            if (Zza == 0 || Zza == this.zzq) {
                return;
            }
            zzaU();
            Surface surface2 = this.zzp;
            if (surface2 == null || !this.zzr) {
                return;
            }
            this.zzg.zzq(surface2);
            return;
        }
        this.zzp = Zza;
        if (!this.zzk) {
            this.zzi.zzl(Zza);
        }
        this.zzr = false;
        int iZzcV = zzcV();
        ?? Zzay = zzay();
        ?? r72 = Zza;
        if (Zzay != 0) {
            r72 = Zza;
            if (!this.zzk) {
                ?? r73 = Zza;
                if (zzet.zza < 23) {
                    zzaF();
                    zzaB();
                    r72 = r73;
                } else {
                    if (Zza != 0) {
                        r73 = Zza;
                        if (!this.zzn) {
                            Zzay.zzo(Zza);
                            r72 = Zza;
                        }
                    } else {
                        r73 = 0;
                    }
                    zzaF();
                    zzaB();
                    r72 = r73;
                }
            }
        }
        if (r72 == 0 || r72 == this.zzq) {
            this.zzB = null;
            if (this.zzk) {
                ((zzzr) this.zzf).zza.zzr();
                return;
            }
            return;
        }
        zzaU();
        if (iZzcV == 2) {
            this.zzi.zzc(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzw() {
        this.zzB = null;
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzd();
        } else {
            this.zzi.zzd();
        }
        this.zzr = false;
        try {
            super.zzw();
        } finally {
            this.zzg.zzc(((zzso) this).zza);
            this.zzg.zzt(zzcp.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzx(boolean z10, boolean z11) throws zzhw {
        super.zzx(z10, z11);
        zzm();
        this.zzg.zze(((zzso) this).zza);
        if (!this.zzl) {
            this.zzk = this.zzC;
            this.zzl = true;
        }
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zze(z11);
        } else {
            this.zzi.zze(z11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    protected final void zzy() {
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    protected final void zzz(long j10, boolean z10) throws zzhw {
        this.zzf.zze();
        this.zzf.zzi(zzau());
        super.zzz(j10, z10);
        this.zzi.zzi();
        if (z10) {
            this.zzi.zzc(false);
        }
        this.zzv = 0;
    }
}
