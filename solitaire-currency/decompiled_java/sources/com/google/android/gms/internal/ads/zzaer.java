package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaer extends zzaet {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzaer() {
        super(new zzacj());
        this.zzb = C.TIME_UNSET;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzek zzekVar) {
        return Double.valueOf(Double.longBitsToDouble(zzekVar.zzt()));
    }

    @Nullable
    private static Object zzh(zzek zzekVar, int i10) {
        if (i10 == 0) {
            return zzg(zzekVar);
        }
        if (i10 == 1) {
            return Boolean.valueOf(zzekVar.zzm() == 1);
        }
        if (i10 == 2) {
            return zzi(zzekVar);
        }
        if (i10 != 3) {
            if (i10 == 8) {
                return zzj(zzekVar);
            }
            if (i10 != 10) {
                if (i10 != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzekVar).doubleValue());
                zzekVar.zzL(2);
                return date;
            }
            int iZzp = zzekVar.zzp();
            ArrayList arrayList = new ArrayList(iZzp);
            for (int i11 = 0; i11 < iZzp; i11++) {
                Object objZzh = zzh(zzekVar, zzekVar.zzm());
                if (objZzh != null) {
                    arrayList.add(objZzh);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strZzi = zzi(zzekVar);
            int iZzm = zzekVar.zzm();
            if (iZzm == 9) {
                return map;
            }
            Object objZzh2 = zzh(zzekVar, iZzm);
            if (objZzh2 != null) {
                map.put(strZzi, objZzh2);
            }
        }
    }

    private static String zzi(zzek zzekVar) {
        int iZzq = zzekVar.zzq();
        int iZzd = zzekVar.zzd();
        zzekVar.zzL(iZzq);
        return new String(zzekVar.zzM(), iZzd, iZzq);
    }

    private static HashMap zzj(zzek zzekVar) {
        int iZzp = zzekVar.zzp();
        HashMap map = new HashMap(iZzp);
        for (int i10 = 0; i10 < iZzp; i10++) {
            String strZzi = zzi(zzekVar);
            Object objZzh = zzh(zzekVar, zzekVar.zzm());
            if (objZzh != null) {
                map.put(strZzi, objZzh);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    protected final boolean zza(zzek zzekVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    protected final boolean zzb(zzek zzekVar, long j10) {
        if (zzekVar.zzm() == 2 && "onMetaData".equals(zzi(zzekVar)) && zzekVar.zzb() != 0 && zzekVar.zzm() == 8) {
            HashMap mapZzj = zzj(zzekVar);
            Object obj = mapZzj.get("duration");
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.zzb = (long) (dDoubleValue * 1000000.0d);
                }
            }
            Object obj2 = mapZzj.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    for (int i10 = 0; i10 < size; i10++) {
                        Object obj5 = list.get(i10);
                        Object obj6 = list2.get(i10);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                            break;
                        }
                        this.zzc[i10] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i10] = ((Double) obj5).longValue();
                    }
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }
}
