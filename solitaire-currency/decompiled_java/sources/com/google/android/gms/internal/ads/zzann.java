package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzann implements zzang {
    final /* synthetic */ zzano zza;
    private final zzej zzb = new zzej(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzann(zzano zzanoVar, int i10) {
        this.zza = zzanoVar;
        this.zze = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzek zzekVar) {
        zzer zzerVar;
        zzer zzerVar2;
        int i10;
        if (zzekVar.zzm() != 2) {
            return;
        }
        zzer zzerVar3 = (zzer) this.zza.zzb.get(0);
        if ((zzekVar.zzm() & 128) != 0) {
            zzekVar.zzL(1);
            int iZzq = zzekVar.zzq();
            int i11 = 3;
            zzekVar.zzL(3);
            zzekVar.zzF(this.zzb, 2);
            this.zzb.zzn(3);
            int i12 = 13;
            this.zza.zzr = this.zzb.zzd(13);
            zzekVar.zzF(this.zzb, 2);
            int i13 = 4;
            this.zzb.zzn(4);
            int i14 = 12;
            zzekVar.zzL(this.zzb.zzd(12));
            this.zzc.clear();
            this.zzd.clear();
            int iZzb = zzekVar.zzb();
            while (iZzb > 0) {
                int i15 = 5;
                zzekVar.zzF(this.zzb, 5);
                zzej zzejVar = this.zzb;
                int iZzd = zzejVar.zzd(8);
                zzejVar.zzn(i11);
                int iZzd2 = this.zzb.zzd(i12);
                this.zzb.zzn(i13);
                int iZzd3 = this.zzb.zzd(i14);
                int iZzd4 = zzekVar.zzd();
                int i16 = iZzd4 + iZzd3;
                int iZzm = 0;
                String str = null;
                ArrayList arrayList = null;
                int i17 = -1;
                while (zzekVar.zzd() < i16) {
                    int iZzm2 = zzekVar.zzm();
                    int iZzd5 = zzekVar.zzd() + zzekVar.zzm();
                    if (iZzd5 > i16) {
                        break;
                    }
                    if (iZzm2 == i15) {
                        long jZzu = zzekVar.zzu();
                        if (jZzu != 1094921523) {
                            if (jZzu != 1161904947) {
                                if (jZzu != 1094921524) {
                                    if (jZzu == 1212503619) {
                                        i10 = 36;
                                        zzerVar2 = zzerVar3;
                                        i17 = i10;
                                    }
                                    zzerVar2 = zzerVar3;
                                }
                                zzerVar2 = zzerVar3;
                                i17 = 172;
                            }
                            zzerVar2 = zzerVar3;
                            i17 = 135;
                        }
                        zzerVar2 = zzerVar3;
                        i17 = 129;
                    } else if (iZzm2 == 106) {
                        zzerVar2 = zzerVar3;
                        i17 = 129;
                    } else if (iZzm2 == 122) {
                        zzerVar2 = zzerVar3;
                        i17 = 135;
                    } else {
                        if (iZzm2 == 127) {
                            int iZzm3 = zzekVar.zzm();
                            if (iZzm3 != 21) {
                                if (iZzm3 == 14) {
                                    i10 = 136;
                                } else {
                                    if (iZzm3 == 33) {
                                        i10 = TsExtractor.TS_STREAM_TYPE_DTS_UHD;
                                    }
                                    zzerVar2 = zzerVar3;
                                }
                            }
                            zzerVar2 = zzerVar3;
                            i17 = 172;
                        } else if (iZzm2 == 123) {
                            i10 = 138;
                        } else if (iZzm2 == 10) {
                            String strTrim = zzekVar.zzA(i11, zzfuj.zzc).trim();
                            iZzm = zzekVar.zzm();
                            zzerVar2 = zzerVar3;
                            str = strTrim;
                        } else if (iZzm2 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (zzekVar.zzd() < iZzd5) {
                                String strTrim2 = zzekVar.zzA(i11, zzfuj.zzc).trim();
                                int iZzm4 = zzekVar.zzm();
                                zzer zzerVar4 = zzerVar3;
                                byte[] bArr = new byte[i13];
                                zzekVar.zzG(bArr, 0, i13);
                                arrayList2.add(new zzanp(strTrim2, iZzm4, bArr));
                                zzerVar3 = zzerVar4;
                                i11 = 3;
                                i13 = 4;
                            }
                            zzerVar2 = zzerVar3;
                            arrayList = arrayList2;
                            i17 = 89;
                        } else {
                            zzerVar2 = zzerVar3;
                            if (iZzm2 == 111) {
                                i17 = 257;
                            }
                        }
                        zzerVar2 = zzerVar3;
                        i17 = i10;
                    }
                    zzekVar.zzL(iZzd5 - zzekVar.zzd());
                    zzerVar3 = zzerVar2;
                    i11 = 3;
                    i13 = 4;
                    i15 = 5;
                }
                zzer zzerVar5 = zzerVar3;
                zzekVar.zzK(i16);
                zzanq zzanqVar = new zzanq(i17, str, iZzm, arrayList, Arrays.copyOfRange(zzekVar.zzM(), iZzd4, i16));
                if (iZzd == 6 || iZzd == 5) {
                    iZzd = zzanqVar.zza;
                }
                iZzb -= iZzd3 + 5;
                if (!this.zza.zzh.get(iZzd2)) {
                    zzant zzantVarZza = this.zza.zze.zza(iZzd, zzanqVar);
                    this.zzd.put(iZzd2, iZzd2);
                    this.zzc.put(iZzd2, zzantVarZza);
                }
                zzerVar3 = zzerVar5;
                i11 = 3;
                i13 = 4;
                i14 = 12;
                i12 = 13;
            }
            zzer zzerVar6 = zzerVar3;
            int size = this.zzd.size();
            int i18 = 0;
            while (i18 < size) {
                SparseIntArray sparseIntArray = this.zzd;
                zzano zzanoVar = this.zza;
                int iKeyAt = sparseIntArray.keyAt(i18);
                int iValueAt = sparseIntArray.valueAt(i18);
                zzanoVar.zzh.put(iKeyAt, true);
                this.zza.zzi.put(iValueAt, true);
                zzant zzantVar = (zzant) this.zzc.valueAt(i18);
                if (zzantVar != null) {
                    zzacn zzacnVar = this.zza.zzl;
                    zzans zzansVar = new zzans(iZzq, iKeyAt, 8192);
                    zzerVar = zzerVar6;
                    zzantVar.zzb(zzerVar, zzacnVar, zzansVar);
                    this.zza.zzg.put(iValueAt, zzantVar);
                } else {
                    zzerVar = zzerVar6;
                }
                i18++;
                zzerVar6 = zzerVar;
            }
            this.zza.zzg.remove(this.zze);
            this.zza.zzm = 0;
            zzano zzanoVar2 = this.zza;
            if (zzanoVar2.zzm == 0) {
                zzanoVar2.zzl.zzD();
                this.zza.zzn = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzb(zzer zzerVar, zzacn zzacnVar, zzans zzansVar) {
    }
}
