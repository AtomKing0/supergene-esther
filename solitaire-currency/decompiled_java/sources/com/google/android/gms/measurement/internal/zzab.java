package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfh;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzab {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    zzab(String str, int i10) {
        this.zza = str;
        this.zzb = i10;
    }

    @VisibleForTesting
    private static Boolean zza(BigDecimal bigDecimal, zzfh.zzd zzdVar, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzdVar);
        if (zzdVar.zzh() && zzdVar.zza() != zzfh.zzd.zzb.UNKNOWN_COMPARISON_TYPE) {
            zzfh.zzd.zzb zzbVarZza = zzdVar.zza();
            zzfh.zzd.zzb zzbVar = zzfh.zzd.zzb.BETWEEN;
            if (zzbVarZza == zzbVar) {
                if (!zzdVar.zzl() || !zzdVar.zzk()) {
                    return null;
                }
            } else if (!zzdVar.zzi()) {
                return null;
            }
            zzfh.zzd.zzb zzbVarZza2 = zzdVar.zza();
            if (zzdVar.zza() == zzbVar) {
                if (zznm.zzb(zzdVar.zzf()) && zznm.zzb(zzdVar.zze())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzdVar.zzf());
                        bigDecimal4 = new BigDecimal(zzdVar.zze());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zznm.zzb(zzdVar.zzd())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzdVar.zzd());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zzbVarZza2 == zzbVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i10 = zzv.zzb[zzbVarZza2.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4 || bigDecimal3 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    if (bigDecimal2 != null) {
                        if (d10 == 0.0d) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                        }
                        if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) < 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal2 != null) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
            } else if (bigDecimal2 != null) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
            }
        }
        return null;
    }

    abstract int zza();

    abstract boolean zzb();

    abstract boolean zzc();

    @VisibleForTesting
    static Boolean zza(String str, zzfh.zzf zzfVar, zzgb zzgbVar) {
        String strZze;
        List<String> list;
        Preconditions.checkNotNull(zzfVar);
        if (str == null || !zzfVar.zzj() || zzfVar.zzb() == zzfh.zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzfh.zzf.zza zzaVarZzb = zzfVar.zzb();
        zzfh.zzf.zza zzaVar = zzfh.zzf.zza.IN_LIST;
        if (zzaVarZzb == zzaVar) {
            if (zzfVar.zza() == 0) {
                return null;
            }
        } else if (!zzfVar.zzi()) {
            return null;
        }
        zzfh.zzf.zza zzaVarZzb2 = zzfVar.zzb();
        boolean zZzg = zzfVar.zzg();
        if (!zZzg && zzaVarZzb2 != zzfh.zzf.zza.REGEXP && zzaVarZzb2 != zzaVar) {
            strZze = zzfVar.zze().toUpperCase(Locale.ENGLISH);
        } else {
            strZze = zzfVar.zze();
        }
        String str2 = strZze;
        if (zzfVar.zza() == 0) {
            list = null;
        } else {
            List<String> listZzf = zzfVar.zzf();
            if (!zZzg) {
                ArrayList arrayList = new ArrayList(listZzf.size());
                Iterator<String> it = listZzf.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listZzf = Collections.unmodifiableList(arrayList);
            }
            list = listZzf;
        }
        return zza(str, zzaVarZzb2, zZzg, str2, list, zzaVarZzb2 == zzfh.zzf.zza.REGEXP ? str2 : null, zzgbVar);
    }

    private static Boolean zza(String str, zzfh.zzf.zza zzaVar, boolean z10, String str2, List<String> list, String str3, zzgb zzgbVar) {
        if (str == null) {
            return null;
        }
        if (zzaVar == zzfh.zzf.zza.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && zzaVar != zzfh.zzf.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzv.zza[zzaVar.ordinal()]) {
            case 1:
                if (str3 != null) {
                    try {
                    } catch (PatternSyntaxException unused) {
                        if (zzgbVar != null) {
                            zzgbVar.zzu().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                        }
                        return null;
                    }
                    break;
                }
                break;
            case 6:
                if (list != null) {
                    break;
                }
                break;
        }
        return null;
    }

    static Boolean zza(double d10, zzfh.zzd zzdVar) {
        try {
            return zza(new BigDecimal(d10), zzdVar, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(long j10, zzfh.zzd zzdVar) {
        try {
            return zza(new BigDecimal(j10), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(String str, zzfh.zzd zzdVar) {
        if (!zznm.zzb(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    static Boolean zza(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }
}
