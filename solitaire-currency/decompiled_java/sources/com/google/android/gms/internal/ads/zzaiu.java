package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaiu {
    private static final zzfvh zza = zzfvh.zzb(zzfui.zzc(':'));
    private static final zzfvh zzb = zzfvh.zzb(zzfui.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int zza(zzacl zzaclVar, zzadf zzadfVar, List list) throws IOException {
        int i10;
        byte b10;
        char c10;
        int i11 = this.zzd;
        if (i11 == 0) {
            long jZzd = zzaclVar.zzd();
            zzadfVar.zza = (jZzd == -1 || jZzd < 8) ? 0L : jZzd - 8;
            this.zzd = 1;
            return 1;
        }
        int i12 = 2;
        if (i11 != 1) {
            short s10 = 2817;
            short s11 = 2816;
            short s12 = 2192;
            if (i11 != 2) {
                long jZzf = zzaclVar.zzf();
                int iZzd = (int) ((zzaclVar.zzd() - zzaclVar.zzf()) - ((long) this.zze));
                zzek zzekVar = new zzek(iZzd);
                zzaclVar.zzi(zzekVar.zzM(), 0, iZzd);
                for (int i13 = 0; i13 < this.zzc.size(); i13++) {
                    zzait zzaitVar = (zzait) this.zzc.get(i13);
                    zzekVar.zzK((int) (zzaitVar.zza - jZzf));
                    zzekVar.zzL(4);
                    int iZzi = zzekVar.zzi();
                    Charset charset = zzfuj.zzc;
                    String strZzA = zzekVar.zzA(iZzi, charset);
                    switch (strZzA.hashCode()) {
                        case -1711564334:
                            b10 = strZzA.equals("SlowMotion_Data") ? (byte) 0 : (byte) -1;
                            break;
                        case -1332107749:
                            b10 = strZzA.equals("Super_SlowMotion_Edit_Data") ? (byte) 3 : (byte) -1;
                            break;
                        case -1251387154:
                            b10 = strZzA.equals("Super_SlowMotion_Data") ? (byte) 1 : (byte) -1;
                            break;
                        case -830665521:
                            b10 = strZzA.equals("Super_SlowMotion_Deflickering_On") ? (byte) 4 : (byte) -1;
                            break;
                        case 1760745220:
                            b10 = strZzA.equals("Super_SlowMotion_BGM") ? (byte) 2 : (byte) -1;
                            break;
                        default:
                            b10 = -1;
                            break;
                    }
                    if (b10 == 0) {
                        c10 = 2192;
                    } else if (b10 == 1) {
                        c10 = 2816;
                    } else if (b10 == 2) {
                        c10 = 2817;
                    } else if (b10 == 3) {
                        c10 = 2819;
                    } else {
                        if (b10 != 4) {
                            throw zzbo.zza("Invalid SEF name", null);
                        }
                        c10 = 2820;
                    }
                    int i14 = zzaitVar.zzb - (iZzi + 8);
                    if (c10 == 2192) {
                        ArrayList arrayList = new ArrayList();
                        List listZze = zzb.zze(zzekVar.zzA(i14, charset));
                        for (int i15 = 0; i15 < listZze.size(); i15++) {
                            List listZze2 = zza.zze((CharSequence) listZze.get(i15));
                            if (listZze2.size() != 3) {
                                throw zzbo.zza(null, null);
                            }
                            try {
                                arrayList.add(new zzagu(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                            } catch (NumberFormatException e10) {
                                throw zzbo.zza(null, e10);
                            }
                        }
                        list.add(new zzagv(arrayList));
                    } else if (c10 != 2816 && c10 != 2817 && c10 != 2819 && c10 != 2820) {
                        throw new IllegalStateException();
                    }
                }
                zzadfVar.zza = 0L;
                return 1;
            }
            long jZzd2 = zzaclVar.zzd();
            int i16 = this.zze - 20;
            zzek zzekVar2 = new zzek(i16);
            zzaclVar.zzi(zzekVar2.zzM(), 0, i16);
            int i17 = 0;
            while (i17 < i16 / 12) {
                zzekVar2.zzL(i12);
                short sZzC = zzekVar2.zzC();
                if (sZzC == s12 || sZzC == s11 || sZzC == s10 || sZzC == 2819 || sZzC == 2820) {
                    i10 = i16;
                    this.zzc.add(new zzait(sZzC, (jZzd2 - ((long) this.zze)) - ((long) zzekVar2.zzi()), zzekVar2.zzi()));
                } else {
                    zzekVar2.zzL(8);
                    i10 = i16;
                }
                i17++;
                i16 = i10;
                i12 = 2;
                s10 = 2817;
                s11 = 2816;
                s12 = 2192;
            }
            if (this.zzc.isEmpty()) {
                zzadfVar.zza = 0L;
            } else {
                this.zzd = 3;
                zzadfVar.zza = ((zzait) this.zzc.get(0)).zza;
            }
        } else {
            zzek zzekVar3 = new zzek(8);
            zzaclVar.zzi(zzekVar3.zzM(), 0, 8);
            this.zze = zzekVar3.zzi() + 8;
            if (zzekVar3.zzg() != 1397048916) {
                zzadfVar.zza = 0L;
            } else {
                zzadfVar.zza = zzaclVar.zzf() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }

    public final void zzb() {
        this.zzc.clear();
        this.zzd = 0;
    }
}
