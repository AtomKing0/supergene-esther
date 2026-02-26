package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahj implements zzack {
    private static final byte[] zza = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final UUID zze;
    private static final Map zzf;
    private long zzA;
    private long zzB;

    @Nullable
    private zzahi zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private long zzJ;

    @Nullable
    private zzeb zzK;

    @Nullable
    private zzeb zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private long zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    private int[] zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private long zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private int zzag;
    private byte zzah;
    private boolean zzai;
    private zzacn zzaj;
    private final zzahf zzg;
    private final zzahl zzh;
    private final SparseArray zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final zzajy zzl;
    private final zzek zzm;
    private final zzek zzn;
    private final zzek zzo;
    private final zzek zzp;
    private final zzek zzq;
    private final zzek zzr;
    private final zzek zzs;
    private final zzek zzt;
    private final zzek zzu;
    private final zzek zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i10 = zzet.zza;
        zzb = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfuj.zzc);
        zzc = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zzd = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zze = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzahj() {
        this(new zzahd(), 2, zzajy.zza);
    }

    private static int[] zzA(@Nullable int[] iArr, int i10) {
        if (iArr == null) {
            return new int[i10];
        }
        int length = iArr.length;
        return length >= i10 ? iArr : new int[Math.max(length + length, i10)];
    }

    private final int zzq(zzacl zzaclVar, zzahi zzahiVar, int i10, boolean z10) throws IOException {
        int i11;
        if ("S_TEXT/UTF8".equals(zzahiVar.zzb)) {
            zzy(zzaclVar, zza, i10);
            int i12 = this.zzab;
            zzx();
            return i12;
        }
        if ("S_TEXT/ASS".equals(zzahiVar.zzb)) {
            zzy(zzaclVar, zzc, i10);
            int i13 = this.zzab;
            zzx();
            return i13;
        }
        if ("S_TEXT/WEBVTT".equals(zzahiVar.zzb)) {
            zzy(zzaclVar, zzd, i10);
            int i14 = this.zzab;
            zzx();
            return i14;
        }
        zzadp zzadpVar = zzahiVar.zzW;
        if (!this.zzad) {
            if (zzahiVar.zzg) {
                this.zzW &= -1073741825;
                if (!this.zzae) {
                    ((zzaby) zzaclVar).zzn(this.zzo.zzM(), 0, 1, false);
                    this.zzaa++;
                    if ((this.zzo.zzM()[0] & 128) == 128) {
                        throw zzbo.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzah = this.zzo.zzM()[0];
                    this.zzae = true;
                }
                byte b10 = this.zzah;
                if ((b10 & 1) == 1) {
                    int i15 = b10 & 2;
                    this.zzW |= 1073741824;
                    if (!this.zzai) {
                        ((zzaby) zzaclVar).zzn(this.zzt.zzM(), 0, 8, false);
                        this.zzaa += 8;
                        this.zzai = true;
                        this.zzo.zzM()[0] = (byte) ((i15 != 2 ? 0 : 128) | 8);
                        this.zzo.zzK(0);
                        zzadpVar.zzr(this.zzo, 1, 1);
                        this.zzab++;
                        this.zzt.zzK(0);
                        zzadpVar.zzr(this.zzt, 8, 1);
                        this.zzab += 8;
                    }
                    if (i15 == 2) {
                        if (!this.zzaf) {
                            ((zzaby) zzaclVar).zzn(this.zzo.zzM(), 0, 1, false);
                            this.zzaa++;
                            this.zzo.zzK(0);
                            this.zzag = this.zzo.zzm();
                            this.zzaf = true;
                        }
                        int i16 = this.zzag * 4;
                        this.zzo.zzH(i16);
                        ((zzaby) zzaclVar).zzn(this.zzo.zzM(), 0, i16, false);
                        this.zzaa += i16;
                        int i17 = (this.zzag >> 1) + 1;
                        int i18 = (i17 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzw;
                        if (byteBuffer == null || byteBuffer.capacity() < i18) {
                            this.zzw = ByteBuffer.allocate(i18);
                        }
                        this.zzw.position(0);
                        this.zzw.putShort((short) i17);
                        int i19 = 0;
                        int i20 = 0;
                        while (true) {
                            i11 = this.zzag;
                            if (i19 >= i11) {
                                break;
                            }
                            int iZzp = this.zzo.zzp();
                            int i21 = iZzp - i20;
                            if (i19 % 2 == 0) {
                                this.zzw.putShort((short) i21);
                            } else {
                                this.zzw.putInt(i21);
                            }
                            i19++;
                            i20 = iZzp;
                        }
                        int i22 = (i10 - this.zzaa) - i20;
                        if ((i11 & 1) == 1) {
                            this.zzw.putInt(i22);
                        } else {
                            this.zzw.putShort((short) i22);
                            this.zzw.putInt(0);
                        }
                        this.zzu.zzI(this.zzw.array(), i18);
                        zzadpVar.zzr(this.zzu, i18, 1);
                        this.zzab += i18;
                    }
                }
            } else {
                byte[] bArr = zzahiVar.zzh;
                if (bArr != null) {
                    this.zzr.zzI(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzahiVar.zzb) ? zzahiVar.zzf > 0 : z10) {
                this.zzW |= 268435456;
                this.zzv.zzH(0);
                int iZze = (this.zzr.zze() + i10) - this.zzaa;
                this.zzo.zzH(4);
                this.zzo.zzM()[0] = (byte) ((iZze >> 24) & 255);
                this.zzo.zzM()[1] = (byte) ((iZze >> 16) & 255);
                this.zzo.zzM()[2] = (byte) ((iZze >> 8) & 255);
                this.zzo.zzM()[3] = (byte) (iZze & 255);
                zzadpVar.zzr(this.zzo, 4, 2);
                this.zzab += 4;
            }
            this.zzad = true;
        }
        int iZze2 = i10 + this.zzr.zze();
        if (!"V_MPEG4/ISO/AVC".equals(zzahiVar.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzahiVar.zzb)) {
            if (zzahiVar.zzT != null) {
                zzdi.zzf(this.zzr.zze() == 0);
                zzahiVar.zzT.zzd(zzaclVar);
            }
            while (true) {
                int i23 = this.zzaa;
                if (i23 >= iZze2) {
                    break;
                }
                int iZzr = zzr(zzaclVar, zzadpVar, iZze2 - i23);
                this.zzaa += iZzr;
                this.zzab += iZzr;
            }
        } else {
            byte[] bArrZzM = this.zzn.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 0;
            bArrZzM[2] = 0;
            int i24 = zzahiVar.zzX;
            int i25 = 4 - i24;
            while (this.zzaa < iZze2) {
                int i26 = this.zzac;
                if (i26 == 0) {
                    int iMin = Math.min(i24, this.zzr.zzb());
                    ((zzaby) zzaclVar).zzn(bArrZzM, i25 + iMin, i24 - iMin, false);
                    if (iMin > 0) {
                        this.zzr.zzG(bArrZzM, i25, iMin);
                    }
                    this.zzaa += i24;
                    this.zzn.zzK(0);
                    this.zzac = this.zzn.zzp();
                    this.zzm.zzK(0);
                    zzadpVar.zzq(this.zzm, 4);
                    this.zzab += 4;
                } else {
                    int iZzr2 = zzr(zzaclVar, zzadpVar, i26);
                    this.zzaa += iZzr2;
                    this.zzab += iZzr2;
                    this.zzac -= iZzr2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahiVar.zzb)) {
            this.zzp.zzK(0);
            zzadpVar.zzq(this.zzp, 4);
            this.zzab += 4;
        }
        int i27 = this.zzab;
        zzx();
        return i27;
    }

    private final int zzr(zzacl zzaclVar, zzadp zzadpVar, int i10) throws IOException {
        int iZzb = this.zzr.zzb();
        if (iZzb <= 0) {
            return zzadpVar.zzf(zzaclVar, i10, false);
        }
        int iMin = Math.min(i10, iZzb);
        zzadpVar.zzq(this.zzr, iMin);
        return iMin;
    }

    private final long zzs(long j10) throws zzbo {
        long j11 = this.zzz;
        if (j11 != C.TIME_UNSET) {
            return zzet.zzt(j10, j11, 1000L, RoundingMode.FLOOR);
        }
        throw zzbo.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private final void zzt(int i10) throws zzbo {
        if (this.zzK == null || this.zzL == null) {
            throw zzbo.zza("Element " + i10 + " must be in a Cues", null);
        }
    }

    private final void zzu(int i10) throws zzbo {
        if (this.zzC != null) {
            return;
        }
        throw zzbo.zza("Element " + i10 + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0 A[EDGE_INSN: B:62:0x00e0->B:51:0x00e0 BREAK  A[LOOP:0: B:45:0x00c5->B:50:0x00dd], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzv(com.google.android.gms.internal.ads.zzahi r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zzv(com.google.android.gms.internal.ads.zzahi, long, int, int, int):void");
    }

    private final void zzw(zzacl zzaclVar, int i10) throws IOException {
        if (this.zzo.zze() >= i10) {
            return;
        }
        if (this.zzo.zzc() < i10) {
            zzek zzekVar = this.zzo;
            int iZzc = zzekVar.zzc();
            zzekVar.zzE(Math.max(iZzc + iZzc, i10));
        }
        zzek zzekVar2 = this.zzo;
        ((zzaby) zzaclVar).zzn(zzekVar2.zzM(), zzekVar2.zze(), i10 - zzekVar2.zze(), false);
        this.zzo.zzJ(i10);
    }

    private final void zzx() {
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = 0;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = false;
        this.zzag = 0;
        this.zzah = (byte) 0;
        this.zzai = false;
        this.zzr.zzH(0);
    }

    private final void zzy(zzacl zzaclVar, byte[] bArr, int i10) throws IOException {
        int length = bArr.length;
        int i11 = length + i10;
        if (this.zzs.zzc() < i11) {
            zzek zzekVar = this.zzs;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i11 + i10);
            zzekVar.zzI(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzs.zzM(), 0, length);
        }
        ((zzaby) zzaclVar).zzn(this.zzs.zzM(), length, i10, false);
        this.zzs.zzK(0);
        this.zzs.zzJ(i11);
    }

    private static byte[] zzz(long j10, String str, long j11) {
        zzdi.zzd(j10 != C.TIME_UNSET);
        int i10 = (int) (j10 / 3600000000L);
        long j12 = j10 - (((long) i10) * 3600000000L);
        int i11 = (int) (j12 / 60000000);
        long j13 = j12 - (((long) i11) * 60000000);
        int i12 = (int) (j13 / 1000000);
        String str2 = String.format(Locale.US, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf((int) ((j13 - (((long) i12) * 1000000)) / j11)));
        int i13 = zzet.zza;
        return str2.getBytes(zzfuj.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        this.zzN = false;
        while (!this.zzN) {
            if (!this.zzg.zzc(zzaclVar)) {
                for (int i10 = 0; i10 < this.zzi.size(); i10++) {
                    zzahi zzahiVar = (zzahi) this.zzi.valueAt(i10);
                    zzahiVar.zzW.getClass();
                    zzadq zzadqVar = zzahiVar.zzT;
                    if (zzadqVar != null) {
                        zzadqVar.zza(zzahiVar.zzW, zzahiVar.zzi);
                    }
                }
                return -1;
            }
            long jZzf = zzaclVar.zzf();
            if (this.zzG) {
                this.zzI = jZzf;
                zzadfVar.zza = this.zzH;
                this.zzG = false;
                return 1;
            }
            if (this.zzD) {
                long j10 = this.zzI;
                if (j10 != -1) {
                    zzadfVar.zza = j10;
                    this.zzI = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzaj = zzacnVar;
        if (this.zzk) {
            zzacnVar = new zzakc(zzacnVar, this.zzl);
        }
        this.zzaj = zzacnVar;
    }

    @CallSuper
    protected final void zzh(int i10, int i11, zzacl zzaclVar) throws IOException {
        int i12;
        long j10;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i10;
        int i18 = 1;
        int i19 = 0;
        if (i17 != 161 && i17 != 163) {
            if (i17 == 165) {
                if (this.zzO != 2) {
                    return;
                }
                zzahi zzahiVar = (zzahi) this.zzi.get(this.zzU);
                if (this.zzX != 4 || !"V_VP9".equals(zzahiVar.zzb)) {
                    ((zzaby) zzaclVar).zzo(i11, false);
                    return;
                }
                this.zzv.zzH(i11);
                ((zzaby) zzaclVar).zzn(this.zzv.zzM(), 0, i11, false);
                return;
            }
            if (i17 == 16877) {
                zzu(i10);
                zzahi zzahiVar2 = this.zzC;
                if (zzahiVar2.zzY != 1685485123 && zzahiVar2.zzY != 1685480259) {
                    ((zzaby) zzaclVar).zzo(i11, false);
                    return;
                }
                byte[] bArr = new byte[i11];
                zzahiVar2.zzN = bArr;
                ((zzaby) zzaclVar).zzn(bArr, 0, i11, false);
                return;
            }
            if (i17 == 16981) {
                zzu(i10);
                byte[] bArr2 = new byte[i11];
                this.zzC.zzh = bArr2;
                ((zzaby) zzaclVar).zzn(bArr2, 0, i11, false);
                return;
            }
            if (i17 == 18402) {
                byte[] bArr3 = new byte[i11];
                ((zzaby) zzaclVar).zzn(bArr3, 0, i11, false);
                zzu(i10);
                this.zzC.zzi = new zzado(1, bArr3, 0, 0);
                return;
            }
            if (i17 == 21419) {
                Arrays.fill(this.zzq.zzM(), (byte) 0);
                ((zzaby) zzaclVar).zzn(this.zzq.zzM(), 4 - i11, i11, false);
                this.zzq.zzK(0);
                this.zzE = (int) this.zzq.zzu();
                return;
            }
            if (i17 == 25506) {
                zzu(i10);
                byte[] bArr4 = new byte[i11];
                this.zzC.zzj = bArr4;
                ((zzaby) zzaclVar).zzn(bArr4, 0, i11, false);
                return;
            }
            if (i17 != 30322) {
                throw zzbo.zza("Unexpected id: " + i17, null);
            }
            zzu(i10);
            byte[] bArr5 = new byte[i11];
            this.zzC.zzv = bArr5;
            ((zzaby) zzaclVar).zzn(bArr5, 0, i11, false);
            return;
        }
        int i20 = 8;
        if (this.zzO == 0) {
            this.zzU = (int) this.zzh.zzd(zzaclVar, false, true, 8);
            this.zzV = this.zzh.zza();
            this.zzQ = C.TIME_UNSET;
            this.zzO = 1;
            this.zzo.zzH(0);
        }
        zzahi zzahiVar3 = (zzahi) this.zzi.get(this.zzU);
        if (zzahiVar3 == null) {
            ((zzaby) zzaclVar).zzo(i11 - this.zzV, false);
            this.zzO = 0;
            return;
        }
        zzahiVar3.zzW.getClass();
        if (this.zzO == 1) {
            zzw(zzaclVar, 3);
            int i21 = (this.zzo.zzM()[2] & 6) >> 1;
            if (i21 == 0) {
                this.zzS = 1;
                int[] iArrZzA = zzA(this.zzT, 1);
                this.zzT = iArrZzA;
                iArrZzA[0] = (i11 - this.zzV) - 3;
            } else {
                zzw(zzaclVar, 4);
                int i22 = (this.zzo.zzM()[3] & 255) + 1;
                this.zzS = i22;
                int[] iArrZzA2 = zzA(this.zzT, i22);
                this.zzT = iArrZzA2;
                if (i21 == 2) {
                    int i23 = (i11 - this.zzV) - 4;
                    int i24 = this.zzS;
                    Arrays.fill(iArrZzA2, 0, i24, i23 / i24);
                } else {
                    if (i21 != 1) {
                        if (i21 != 3) {
                            throw zzbo.zza("Unexpected lacing value: 2", null);
                        }
                        int i25 = 0;
                        int i26 = 0;
                        int i27 = 4;
                        while (true) {
                            int i28 = this.zzS - 1;
                            if (i25 >= i28) {
                                this.zzT[i28] = ((i11 - this.zzV) - i27) - i26;
                                break;
                            }
                            this.zzT[i25] = i19;
                            i27++;
                            zzw(zzaclVar, i27);
                            int i29 = i27 - 1;
                            if (this.zzo.zzM()[i29] == 0) {
                                throw zzbo.zza("No valid varint length mask found", null);
                            }
                            int i30 = i19;
                            while (true) {
                                if (i30 >= i20) {
                                    j10 = 0;
                                    break;
                                }
                                int i31 = i18 << (7 - i30);
                                if ((this.zzo.zzM()[i29] & i31) != 0) {
                                    i27 += i30;
                                    zzw(zzaclVar, i27);
                                    j10 = (~i31) & this.zzo.zzM()[i29] & 255;
                                    int i32 = i29 + 1;
                                    while (i32 < i27) {
                                        j10 = (j10 << i20) | ((long) (this.zzo.zzM()[i32] & 255));
                                        i32++;
                                        i20 = 8;
                                    }
                                    if (i25 > 0) {
                                        j10 -= (1 << ((i30 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i30++;
                                    i18 = 1;
                                    i20 = 8;
                                }
                            }
                            if (j10 < -2147483648L || j10 > 2147483647L) {
                                break;
                            }
                            int[] iArr = this.zzT;
                            int i33 = (int) j10;
                            if (i25 != 0) {
                                i33 += iArr[i25 - 1];
                            }
                            iArr[i25] = i33;
                            i26 += i33;
                            i25++;
                            i18 = 1;
                            i19 = 0;
                            i20 = 8;
                        }
                        throw zzbo.zza("EBML lacing sample size out of range.", null);
                    }
                    int i34 = 0;
                    int i35 = 0;
                    int i36 = 4;
                    while (true) {
                        i13 = this.zzS - 1;
                        if (i34 >= i13) {
                            break;
                        }
                        this.zzT[i34] = 0;
                        do {
                            i36++;
                            zzw(zzaclVar, i36);
                            i14 = this.zzo.zzM()[i36 - 1] & 255;
                            int[] iArr2 = this.zzT;
                            i15 = iArr2[i34] + i14;
                            iArr2[i34] = i15;
                        } while (i14 == 255);
                        i35 += i15;
                        i34++;
                    }
                    this.zzT[i13] = ((i11 - this.zzV) - i36) - i35;
                }
            }
            this.zzP = this.zzJ + zzs((this.zzo.zzM()[0] << 8) | (this.zzo.zzM()[1] & 255));
            if (zzahiVar3.zzd == 2) {
                i16 = 1;
                this.zzW = i16;
                this.zzO = 2;
                this.zzR = 0;
                i12 = 163;
            } else {
                if (i17 == 163) {
                    if ((this.zzo.zzM()[2] & 128) == 128) {
                        i17 = 163;
                        i16 = 1;
                        this.zzW = i16;
                        this.zzO = 2;
                        this.zzR = 0;
                        i12 = 163;
                    } else {
                        i17 = 163;
                    }
                }
                i16 = 0;
                this.zzW = i16;
                this.zzO = 2;
                this.zzR = 0;
                i12 = 163;
            }
        } else {
            i12 = 163;
        }
        if (i17 == i12) {
            while (true) {
                int i37 = this.zzR;
                if (i37 >= this.zzS) {
                    this.zzO = 0;
                    return;
                }
                zzv(zzahiVar3, ((long) ((this.zzR * zzahiVar3.zze) / 1000)) + this.zzP, this.zzW, zzq(zzaclVar, zzahiVar3, this.zzT[i37], false), 0);
                this.zzR++;
            }
        } else {
            while (true) {
                int i38 = this.zzR;
                if (i38 >= this.zzS) {
                    return;
                }
                int[] iArr3 = this.zzT;
                iArr3[i38] = zzq(zzaclVar, zzahiVar3, iArr3[i38], true);
                this.zzR++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    @CallSuper
    public final void zzi(long j10, long j11) {
        this.zzJ = C.TIME_UNSET;
        this.zzO = 0;
        this.zzg.zzb();
        this.zzh.zze();
        zzx();
        for (int i10 = 0; i10 < this.zzi.size(); i10++) {
            zzadq zzadqVar = ((zzahi) this.zzi.valueAt(i10)).zzT;
            if (zzadqVar != null) {
                zzadqVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        return new zzahk().zza(zzaclVar);
    }

    @CallSuper
    protected final void zzk(int i10) throws zzbo {
        int i11;
        int i12;
        zzadi zzadhVar;
        int i13;
        zzdi.zzb(this.zzaj);
        if (i10 == 160) {
            if (this.zzO == 2) {
                zzahi zzahiVar = (zzahi) this.zzi.get(this.zzU);
                zzahiVar.zzW.getClass();
                if (this.zzZ > 0 && "A_OPUS".equals(zzahiVar.zzb)) {
                    zzek zzekVar = this.zzv;
                    byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzZ).array();
                    zzekVar.zzI(bArrArray, bArrArray.length);
                }
                int i14 = 0;
                for (int i15 = 0; i15 < this.zzS; i15++) {
                    i14 += this.zzT[i15];
                }
                int i16 = 0;
                while (i16 < this.zzS) {
                    long j10 = this.zzP + ((long) ((zzahiVar.zze * i16) / 1000));
                    int i17 = this.zzW;
                    if (i16 == 0) {
                        if (!this.zzY) {
                            i17 |= 1;
                        }
                        i12 = i17;
                        i11 = 0;
                    } else {
                        i11 = i16;
                        i12 = i17;
                    }
                    int i18 = this.zzT[i11];
                    int i19 = i14 - i18;
                    zzv(zzahiVar, j10, i12, i18, i19);
                    i16 = i11 + 1;
                    i14 = i19;
                }
                this.zzO = 0;
                return;
            }
            return;
        }
        if (i10 != 174) {
            if (i10 == 19899) {
                int i20 = this.zzE;
                if (i20 != -1) {
                    long j11 = this.zzF;
                    if (j11 != -1) {
                        if (i20 == 475249515) {
                            this.zzH = j11;
                            return;
                        }
                        return;
                    }
                }
                throw zzbo.zza("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i10 == 25152) {
                zzu(i10);
                zzahi zzahiVar2 = this.zzC;
                if (zzahiVar2.zzg) {
                    if (zzahiVar2.zzi == null) {
                        throw zzbo.zza("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    zzahiVar2.zzk = new zzy(null, new zzx(zzk.zza, null, "video/webm", this.zzC.zzi.zzb));
                    return;
                }
                return;
            }
            if (i10 == 28032) {
                zzu(i10);
                zzahi zzahiVar3 = this.zzC;
                if (zzahiVar3.zzg && zzahiVar3.zzh != null) {
                    throw zzbo.zza("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i10 == 357149030) {
                if (this.zzz == C.TIME_UNSET) {
                    this.zzz = 1000000L;
                }
                long j12 = this.zzA;
                if (j12 != C.TIME_UNSET) {
                    this.zzB = zzs(j12);
                    return;
                }
                return;
            }
            if (i10 == 374648427) {
                if (this.zzi.size() == 0) {
                    throw zzbo.zza("No valid tracks were found", null);
                }
                this.zzaj.zzD();
                return;
            }
            if (i10 != 475249515) {
                return;
            }
            if (!this.zzD) {
                zzacn zzacnVar = this.zzaj;
                zzeb zzebVar = this.zzK;
                zzeb zzebVar2 = this.zzL;
                if (this.zzy == -1 || this.zzB == C.TIME_UNSET || zzebVar == null || zzebVar.zza() == 0 || zzebVar2 == null || zzebVar2.zza() != zzebVar.zza()) {
                    zzadhVar = new zzadh(this.zzB, 0L);
                } else {
                    int iZza = zzebVar.zza();
                    int[] iArrCopyOf = new int[iZza];
                    long[] jArrCopyOf = new long[iZza];
                    long[] jArrCopyOf2 = new long[iZza];
                    long[] jArrCopyOf3 = new long[iZza];
                    for (int i21 = 0; i21 < iZza; i21++) {
                        jArrCopyOf3[i21] = zzebVar.zzb(i21);
                        jArrCopyOf[i21] = this.zzy + zzebVar2.zzb(i21);
                    }
                    int i22 = 0;
                    while (true) {
                        i13 = iZza - 1;
                        if (i22 >= i13) {
                            break;
                        }
                        int i23 = i22 + 1;
                        iArrCopyOf[i22] = (int) (jArrCopyOf[i23] - jArrCopyOf[i22]);
                        jArrCopyOf2[i22] = jArrCopyOf3[i23] - jArrCopyOf3[i22];
                        i22 = i23;
                    }
                    iArrCopyOf[i13] = (int) ((this.zzy + this.zzx) - jArrCopyOf[i13]);
                    long j13 = this.zzB - jArrCopyOf3[i13];
                    jArrCopyOf2[i13] = j13;
                    if (j13 <= 0) {
                        zzea.zzf("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j13);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i13);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i13);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i13);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i13);
                    }
                    zzadhVar = new zzabw(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                zzacnVar.zzO(zzadhVar);
                this.zzD = true;
            }
            this.zzK = null;
            this.zzL = null;
            return;
        }
        zzahi zzahiVar4 = this.zzC;
        zzdi.zzb(zzahiVar4);
        String str = zzahiVar4.zzb;
        if (str == null) {
            throw zzbo.zza("CodecId is missing in TrackEntry element", null);
        }
        switch (str) {
            case "V_VP8":
            case "V_VP9":
            case "V_AV1":
            case "V_MPEG2":
            case "V_MPEG4/ISO/SP":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/AVC":
            case "V_MPEGH/ISO/HEVC":
            case "V_MS/VFW/FOURCC":
            case "V_THEORA":
            case "A_OPUS":
            case "A_VORBIS":
            case "A_AAC":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "A_AC3":
            case "A_EAC3":
            case "A_TRUEHD":
            case "A_DTS":
            case "A_DTS/EXPRESS":
            case "A_DTS/LOSSLESS":
            case "A_FLAC":
            case "A_MS/ACM":
            case "A_PCM/INT/LIT":
            case "A_PCM/INT/BIG":
            case "A_PCM/FLOAT/IEEE":
            case "S_TEXT/UTF8":
            case "S_TEXT/ASS":
            case "S_TEXT/WEBVTT":
            case "S_VOBSUB":
            case "S_HDMV/PGS":
            case "S_DVBSUB":
                zzahiVar4.zze(this.zzaj, zzahiVar4.zzc);
                this.zzi.put(zzahiVar4.zzc, zzahiVar4);
                break;
        }
        this.zzC = null;
    }

    @CallSuper
    protected final void zzl(int i10, double d10) throws zzbo {
        if (i10 == 181) {
            zzu(i10);
            this.zzC.zzQ = (int) d10;
            return;
        }
        if (i10 == 17545) {
            this.zzA = (long) d10;
            return;
        }
        switch (i10) {
            case 21969:
                zzu(i10);
                this.zzC.zzD = (float) d10;
                break;
            case 21970:
                zzu(i10);
                this.zzC.zzE = (float) d10;
                break;
            case 21971:
                zzu(i10);
                this.zzC.zzF = (float) d10;
                break;
            case 21972:
                zzu(i10);
                this.zzC.zzG = (float) d10;
                break;
            case 21973:
                zzu(i10);
                this.zzC.zzH = (float) d10;
                break;
            case 21974:
                zzu(i10);
                this.zzC.zzI = (float) d10;
                break;
            case 21975:
                zzu(i10);
                this.zzC.zzJ = (float) d10;
                break;
            case 21976:
                zzu(i10);
                this.zzC.zzK = (float) d10;
                break;
            case 21977:
                zzu(i10);
                this.zzC.zzL = (float) d10;
                break;
            case 21978:
                zzu(i10);
                this.zzC.zzM = (float) d10;
                break;
            default:
                switch (i10) {
                    case 30323:
                        zzu(i10);
                        this.zzC.zzs = (float) d10;
                        break;
                    case 30324:
                        zzu(i10);
                        this.zzC.zzt = (float) d10;
                        break;
                    case 30325:
                        zzu(i10);
                        this.zzC.zzu = (float) d10;
                        break;
                }
                break;
        }
    }

    @CallSuper
    protected final void zzm(int i10, long j10) throws zzbo {
        boolean z10;
        if (i10 == 20529) {
            if (j10 == 0) {
                return;
            }
            throw zzbo.zza("ContentEncodingOrder " + j10 + " not supported", null);
        }
        if (i10 == 20530) {
            if (j10 == 1) {
                return;
            }
            throw zzbo.zza("ContentEncodingScope " + j10 + " not supported", null);
        }
        switch (i10) {
            case 131:
                zzu(i10);
                this.zzC.zzd = (int) j10;
                return;
            case 136:
                z10 = j10 == 1;
                zzu(i10);
                this.zzC.zzV = z10;
                return;
            case 155:
                this.zzQ = zzs(j10);
                return;
            case 159:
                zzu(i10);
                this.zzC.zzO = (int) j10;
                return;
            case 176:
                zzu(i10);
                this.zzC.zzl = (int) j10;
                return;
            case 179:
                zzt(i10);
                this.zzK.zzc(zzs(j10));
                return;
            case 186:
                zzu(i10);
                this.zzC.zzm = (int) j10;
                return;
            case 215:
                zzu(i10);
                this.zzC.zzc = (int) j10;
                return;
            case 231:
                this.zzJ = zzs(j10);
                return;
            case 238:
                this.zzX = (int) j10;
                return;
            case 241:
                if (this.zzM) {
                    return;
                }
                zzt(i10);
                this.zzL.zzc(j10);
                this.zzM = true;
                return;
            case 251:
                this.zzY = true;
                return;
            case 16871:
                zzu(i10);
                this.zzC.zzY = (int) j10;
                return;
            case 16980:
                if (j10 == 3) {
                    return;
                }
                throw zzbo.zza("ContentCompAlgo " + j10 + " not supported", null);
            case 17029:
                if (j10 < 1 || j10 > 2) {
                    throw zzbo.zza("DocTypeReadVersion " + j10 + " not supported", null);
                }
                return;
            case 17143:
                if (j10 == 1) {
                    return;
                }
                throw zzbo.zza("EBMLReadVersion " + j10 + " not supported", null);
            case 18401:
                if (j10 == 5) {
                    return;
                }
                throw zzbo.zza("ContentEncAlgo " + j10 + " not supported", null);
            case 18408:
                if (j10 == 1) {
                    return;
                }
                throw zzbo.zza("AESSettingsCipherMode " + j10 + " not supported", null);
            case 21420:
                this.zzF = j10 + this.zzy;
                return;
            case 21432:
                int i11 = (int) j10;
                zzu(i10);
                if (i11 == 0) {
                    this.zzC.zzw = 0;
                    return;
                }
                if (i11 == 1) {
                    this.zzC.zzw = 2;
                    return;
                } else if (i11 == 3) {
                    this.zzC.zzw = 1;
                    return;
                } else {
                    if (i11 != 15) {
                        return;
                    }
                    this.zzC.zzw = 3;
                    return;
                }
            case 21680:
                zzu(i10);
                this.zzC.zzo = (int) j10;
                return;
            case 21682:
                zzu(i10);
                this.zzC.zzq = (int) j10;
                return;
            case 21690:
                zzu(i10);
                this.zzC.zzp = (int) j10;
                return;
            case 21930:
                z10 = j10 == 1;
                zzu(i10);
                this.zzC.zzU = z10;
                return;
            case 21938:
                zzu(i10);
                zzahi zzahiVar = this.zzC;
                zzahiVar.zzx = true;
                zzahiVar.zzn = (int) j10;
                return;
            case 21998:
                zzu(i10);
                this.zzC.zzf = (int) j10;
                return;
            case 22186:
                zzu(i10);
                this.zzC.zzR = j10;
                return;
            case 22203:
                zzu(i10);
                this.zzC.zzS = j10;
                return;
            case 25188:
                zzu(i10);
                this.zzC.zzP = (int) j10;
                return;
            case 30114:
                this.zzZ = j10;
                return;
            case 30321:
                int i12 = (int) j10;
                zzu(i10);
                if (i12 == 0) {
                    this.zzC.zzr = 0;
                    return;
                }
                if (i12 == 1) {
                    this.zzC.zzr = 1;
                    return;
                } else if (i12 == 2) {
                    this.zzC.zzr = 2;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.zzC.zzr = 3;
                    return;
                }
            case 2352003:
                zzu(i10);
                this.zzC.zze = (int) j10;
                return;
            case 2807729:
                this.zzz = j10;
                return;
            default:
                switch (i10) {
                    case 21945:
                        int i13 = (int) j10;
                        zzu(i10);
                        if (i13 == 1) {
                            this.zzC.zzA = 2;
                            return;
                        } else {
                            if (i13 != 2) {
                                return;
                            }
                            this.zzC.zzA = 1;
                            return;
                        }
                    case 21946:
                        zzu(i10);
                        int iZzb = zzo.zzb((int) j10);
                        if (iZzb != -1) {
                            this.zzC.zzz = iZzb;
                            return;
                        }
                        return;
                    case 21947:
                        zzu(i10);
                        this.zzC.zzx = true;
                        int iZza = zzo.zza((int) j10);
                        if (iZza != -1) {
                            this.zzC.zzy = iZza;
                            return;
                        }
                        return;
                    case 21948:
                        zzu(i10);
                        this.zzC.zzB = (int) j10;
                        return;
                    case 21949:
                        zzu(i10);
                        this.zzC.zzC = (int) j10;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    protected final void zzn(int i10, long j10, long j11) throws zzbo {
        zzdi.zzb(this.zzaj);
        if (i10 == 160) {
            this.zzY = false;
            this.zzZ = 0L;
            return;
        }
        if (i10 == 174) {
            this.zzC = new zzahi();
            return;
        }
        if (i10 == 187) {
            this.zzM = false;
            return;
        }
        if (i10 == 19899) {
            this.zzE = -1;
            this.zzF = -1L;
            return;
        }
        if (i10 == 20533) {
            zzu(i10);
            this.zzC.zzg = true;
            return;
        }
        if (i10 == 21968) {
            zzu(i10);
            this.zzC.zzx = true;
            return;
        }
        if (i10 == 408125543) {
            long j12 = this.zzy;
            if (j12 != -1 && j12 != j10) {
                throw zzbo.zza("Multiple Segment elements not supported", null);
            }
            this.zzy = j10;
            this.zzx = j11;
            return;
        }
        if (i10 == 475249515) {
            this.zzK = new zzeb(32);
            this.zzL = new zzeb(32);
        } else if (i10 == 524531317 && !this.zzD) {
            if (this.zzj && this.zzH != -1) {
                this.zzG = true;
            } else {
                this.zzaj.zzO(new zzadh(this.zzB, 0L));
                this.zzD = true;
            }
        }
    }

    @CallSuper
    protected final void zzo(int i10, String str) throws zzbo {
        if (i10 == 134) {
            zzu(i10);
            this.zzC.zzb = str;
            return;
        }
        if (i10 == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw zzbo.zza("DocType " + str + " not supported", null);
        }
        if (i10 == 21358) {
            zzu(i10);
            this.zzC.zza = str;
        } else {
            if (i10 != 2274716) {
                return;
            }
            zzu(i10);
            this.zzC.zzZ = str;
        }
    }

    zzahj(zzahf zzahfVar, int i10, zzajy zzajyVar) {
        this.zzy = -1L;
        this.zzz = C.TIME_UNSET;
        this.zzA = C.TIME_UNSET;
        this.zzB = C.TIME_UNSET;
        this.zzH = -1L;
        this.zzI = -1L;
        this.zzJ = C.TIME_UNSET;
        this.zzg = zzahfVar;
        zzahfVar.zza(new zzahh(this, null));
        this.zzl = zzajyVar;
        this.zzj = 1 == ((i10 & 1) ^ 1);
        this.zzk = (i10 & 2) == 0;
        this.zzh = new zzahl();
        this.zzi = new SparseArray();
        this.zzo = new zzek(4);
        this.zzp = new zzek(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzek(4);
        this.zzm = new zzek(zzfh.zza);
        this.zzn = new zzek(4);
        this.zzr = new zzek();
        this.zzs = new zzek();
        this.zzt = new zzek(8);
        this.zzu = new zzek();
        this.zzv = new zzek();
        this.zzT = new int[1];
    }

    public zzahj(zzajy zzajyVar, int i10) {
        this(new zzahd(), 0, zzajyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
