package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.ironsource.v8;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zziq {
    public static final zziq zza = new zziq(null, null, 100);
    private final EnumMap<zza, zzip> zzb;
    private final int zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    private zziq(EnumMap<zza, zzip> enumMap, int i10) {
        EnumMap<zza, zzip> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i10;
    }

    static String zza(int i10) {
        return i10 != -30 ? i10 != -20 ? i10 != -10 ? i10 != 0 ? i10 != 30 ? i10 != 90 ? i10 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zziq)) {
            return false;
        }
        zziq zziqVar = (zziq) obj;
        for (zza zzaVar : zzir.STORAGE.zzd) {
            if (this.zzb.get(zzaVar) != zziqVar.zzb.get(zzaVar)) {
                return false;
            }
        }
        return this.zzc == zziqVar.zzc;
    }

    public final int hashCode() {
        int iHashCode = this.zzc * 17;
        Iterator<zzip> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zza(this.zzc));
        for (zza zzaVar : zzir.STORAGE.zzd) {
            sb.append(",");
            sb.append(zzaVar.zze);
            sb.append(v8.i.f15833b);
            zzip zzipVar = this.zzb.get(zzaVar);
            if (zzipVar == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = zzipVar.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("default");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        return sb.toString();
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it = this.zzb.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strZzb = zzb((zzip) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zza) entry.getKey()).zze, strZzb);
            }
        }
        return bundle;
    }

    public final zzip zzc() {
        zzip zzipVar = this.zzb.get(zza.AD_STORAGE);
        return zzipVar == null ? zzip.UNINITIALIZED : zzipVar;
    }

    public final zzip zzd() {
        zzip zzipVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zzipVar == null ? zzip.UNINITIALIZED : zzipVar;
    }

    public final Boolean zze() {
        zzip zzipVar = this.zzb.get(zza.AD_STORAGE);
        if (zzipVar == null) {
            return null;
        }
        int iOrdinal = zzipVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    public final Boolean zzf() {
        zzip zzipVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        if (zzipVar == null) {
            return null;
        }
        int iOrdinal = zzipVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzg() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzir r1 = com.google.android.gms.measurement.internal.zzir.STORAGE
            com.google.android.gms.measurement.internal.zziq$zza[] r1 = r1.zza()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L3a
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zziq$zza, com.google.android.gms.measurement.internal.zzip> r5 = r7.zzb
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzip r4 = (com.google.android.gms.measurement.internal.zzip) r4
            r5 = 45
            if (r4 == 0) goto L34
            int r4 = r4.ordinal()
            if (r4 == 0) goto L34
            r6 = 1
            if (r4 == r6) goto L32
            r6 = 2
            if (r4 == r6) goto L2f
            r6 = 3
            if (r4 == r6) goto L32
            goto L34
        L2f:
            r5 = 48
            goto L34
        L32:
            r5 = 49
        L34:
            r0.append(r5)
            int r3 = r3 + 1
            goto Lf
        L3a:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziq.zzg():java.lang.String");
    }

    public final String zzh() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzir.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    public final boolean zzi() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zzj() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzk() {
        Iterator<zzip> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzip.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public static boolean zza(int i10, int i11) {
        return ((i10 == -20 && i11 == -30) || ((i10 == -30 && i11 == -20) || i10 == i11)) || i10 < i11;
    }

    static char zza(zzip zzipVar) {
        if (zzipVar == null) {
            return '-';
        }
        int iOrdinal = zzipVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public final boolean zzc(zziq zziqVar) {
        return zzb(zziqVar, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    public final int zza() {
        return this.zzc;
    }

    public zziq(Boolean bool, Boolean bool2, int i10) {
        EnumMap<zza, zzip> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put(zza.AD_STORAGE, zza(bool));
        enumMap.put(zza.ANALYTICS_STORAGE, zza(bool2));
        this.zzc = i10;
    }

    static zzip zza(String str) {
        if (str == null) {
            return zzip.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzip.GRANTED;
        }
        if (str.equals("denied")) {
            return zzip.DENIED;
        }
        return zzip.UNINITIALIZED;
    }

    public static zziq zzb(String str) {
        return zza(str, 100);
    }

    public final zziq zzb(zziq zziqVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzir.STORAGE.zzd) {
            zzip zzipVar = this.zzb.get(zzaVar);
            if (zzipVar == zzip.UNINITIALIZED) {
                zzipVar = zziqVar.zzb.get(zzaVar);
            }
            if (zzipVar != null) {
                enumMap.put(zzaVar, zzipVar);
            }
        }
        return new zziq(enumMap, this.zzc);
    }

    static zzip zza(char c10) {
        if (c10 == '+') {
            return zzip.DEFAULT;
        }
        if (c10 == '0') {
            return zzip.DENIED;
        }
        if (c10 != '1') {
            return zzip.UNINITIALIZED;
        }
        return zzip.GRANTED;
    }

    static String zzb(zzip zzipVar) {
        int iOrdinal = zzipVar.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public final boolean zzb(zziq zziqVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            zzip zzipVar = this.zzb.get(zzaVar);
            zzip zzipVar2 = zziqVar.zzb.get(zzaVar);
            zzip zzipVar3 = zzip.DENIED;
            if (zzipVar == zzipVar3 && zzipVar2 != zzipVar3) {
                return true;
            }
        }
        return false;
    }

    static zzip zza(Boolean bool) {
        if (bool == null) {
            return zzip.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzip.GRANTED;
        }
        return zzip.DENIED;
    }

    public static zziq zza(Bundle bundle, int i10) {
        if (bundle == null) {
            return new zziq(null, null, i10);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzir.STORAGE.zzd) {
            enumMap.put(zzaVar, zza(bundle.getString(zzaVar.zze)));
        }
        return new zziq(enumMap, i10);
    }

    public static zziq zza(zzip zzipVar, zzip zzipVar2, int i10) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put(zza.AD_STORAGE, zzipVar);
        enumMap.put(zza.ANALYTICS_STORAGE, zzipVar2);
        return new zziq(enumMap, -10);
    }

    public static zziq zza(String str, int i10) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zzaVarArrZza = zzir.STORAGE.zza();
        for (int i11 = 0; i11 < zzaVarArrZza.length; i11++) {
            zza zzaVar = zzaVarArrZza[i11];
            int i12 = i11 + 2;
            if (i12 < str.length()) {
                enumMap.put(zzaVar, zza(str.charAt(i12)));
            } else {
                enumMap.put(zzaVar, zzip.UNINITIALIZED);
            }
        }
        return new zziq(enumMap, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zziq zza(com.google.android.gms.measurement.internal.zziq r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zziq$zza> r1 = com.google.android.gms.measurement.internal.zziq.zza.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzir r1 = com.google.android.gms.measurement.internal.zzir.STORAGE
            com.google.android.gms.measurement.internal.zziq$zza[] r1 = com.google.android.gms.measurement.internal.zzir.zza(r1)
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L4d
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zziq$zza, com.google.android.gms.measurement.internal.zzip> r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzip r5 = (com.google.android.gms.measurement.internal.zzip) r5
            java.util.EnumMap<com.google.android.gms.measurement.internal.zziq$zza, com.google.android.gms.measurement.internal.zzip> r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzip r6 = (com.google.android.gms.measurement.internal.zzip) r6
            if (r5 != 0) goto L26
            goto L35
        L26:
            if (r6 != 0) goto L29
            goto L45
        L29:
            com.google.android.gms.measurement.internal.zzip r7 = com.google.android.gms.measurement.internal.zzip.UNINITIALIZED
            if (r5 != r7) goto L2e
            goto L35
        L2e:
            if (r6 != r7) goto L31
            goto L45
        L31:
            com.google.android.gms.measurement.internal.zzip r7 = com.google.android.gms.measurement.internal.zzip.DEFAULT
            if (r5 != r7) goto L37
        L35:
            r5 = r6
            goto L45
        L37:
            if (r6 != r7) goto L3a
            goto L45
        L3a:
            com.google.android.gms.measurement.internal.zzip r7 = com.google.android.gms.measurement.internal.zzip.DENIED
            if (r5 == r7) goto L44
            if (r6 != r7) goto L41
            goto L44
        L41:
            com.google.android.gms.measurement.internal.zzip r5 = com.google.android.gms.measurement.internal.zzip.GRANTED
            goto L45
        L44:
            r5 = r7
        L45:
            if (r5 == 0) goto L4a
            r0.put(r4, r5)
        L4a:
            int r3 = r3 + 1
            goto Lf
        L4d:
            com.google.android.gms.measurement.internal.zziq r9 = new com.google.android.gms.measurement.internal.zziq
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziq.zza(com.google.android.gms.measurement.internal.zziq):com.google.android.gms.measurement.internal.zziq");
    }

    public static String zza(Bundle bundle) {
        String string;
        zza[] zzaVarArr = zzir.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i10 = 0;
        while (true) {
            Boolean bool = null;
            if (i10 >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i10];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i10++;
        }
    }

    public final boolean zza(zziq zziqVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            if (!zziqVar.zza(zzaVar) && zza(zzaVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zzip.DENIED;
    }
}
