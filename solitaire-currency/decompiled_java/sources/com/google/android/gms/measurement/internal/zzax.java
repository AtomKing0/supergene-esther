package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zziq;
import com.ironsource.v8;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzax {
    public static final zzax zza = new zzax(null, 100);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap<zziq.zza, zzip> zzf;

    zzax(Boolean bool, int i10) {
        this(bool, i10, (Boolean) null, (String) null);
    }

    private final String zzh() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zziq.zza zzaVar : zzir.DMA.zza()) {
            sb.append(":");
            sb.append(zziq.zza(this.zzf.get(zzaVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzax)) {
            return false;
        }
        zzax zzaxVar = (zzax) obj;
        if (this.zzc.equalsIgnoreCase(zzaxVar.zzc) && Objects.equals(this.zzd, zzaxVar.zzd)) {
            return Objects.equals(this.zze, zzaxVar.zze);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.zzd;
        int i10 = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.zze;
        return this.zzc.hashCode() + (i10 * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zziq.zza(this.zzb));
        for (zziq.zza zzaVar : zzir.DMA.zza()) {
            sb.append(",");
            sb.append(zzaVar.zze);
            sb.append(v8.i.f15833b);
            zzip zzipVar = this.zzf.get(zzaVar);
            if (zzipVar == null) {
                sb.append("uninitialized");
            } else {
                int i10 = zzaw.zza[zzipVar.ordinal()];
                if (i10 == 1) {
                    sb.append("uninitialized");
                } else if (i10 == 2) {
                    sb.append("default");
                } else if (i10 == 3) {
                    sb.append("denied");
                } else if (i10 == 4) {
                    sb.append("granted");
                }
            }
        }
        if (this.zzd != null) {
            sb.append(",isDmaRegion=");
            sb.append(this.zzd);
        }
        if (this.zze != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(this.zze);
        }
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it = this.zzf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strZzb = zziq.zzb((zzip) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zziq.zza) entry.getKey()).zze, strZzb);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final zzip zzc() {
        zzip zzipVar = this.zzf.get(zziq.zza.AD_USER_DATA);
        return zzipVar == null ? zzip.UNINITIALIZED : zzipVar;
    }

    public final Boolean zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        Iterator<zzip> it = this.zzf.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzip.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    zzax(Boolean bool, int i10, Boolean bool2, String str) {
        EnumMap<zziq.zza, zzip> enumMap = new EnumMap<>(zziq.zza.class);
        this.zzf = enumMap;
        enumMap.put(zziq.zza.AD_USER_DATA, zziq.zza(bool));
        this.zzb = i10;
        this.zzc = zzh();
        this.zzd = bool2;
        this.zze = str;
    }

    public static zzax zza(Bundle bundle, int i10) {
        if (bundle == null) {
            return new zzax(null, i10);
        }
        EnumMap enumMap = new EnumMap(zziq.zza.class);
        for (zziq.zza zzaVar : zzir.DMA.zza()) {
            enumMap.put(zzaVar, zziq.zza(bundle.getString(zzaVar.zze)));
        }
        return new zzax((EnumMap<zziq.zza, zzip>) enumMap, i10, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    private zzax(EnumMap<zziq.zza, zzip> enumMap, int i10, Boolean bool, String str) {
        EnumMap<zziq.zza, zzip> enumMap2 = new EnumMap<>(zziq.zza.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i10;
        this.zzc = zzh();
        this.zzd = bool;
        this.zze = str;
    }

    static zzax zza(zzip zzipVar, int i10) {
        EnumMap enumMap = new EnumMap(zziq.zza.class);
        enumMap.put(zziq.zza.AD_USER_DATA, zzipVar);
        return new zzax((EnumMap<zziq.zza, zzip>) enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzax zza(String str) {
        if (str != null && str.length() > 0) {
            String[] strArrSplit = str.split(":");
            int i10 = Integer.parseInt(strArrSplit[0]);
            EnumMap enumMap = new EnumMap(zziq.zza.class);
            zziq.zza[] zzaVarArrZza = zzir.DMA.zza();
            int length = zzaVarArrZza.length;
            int i11 = 1;
            int i12 = 0;
            while (i12 < length) {
                enumMap.put(zzaVarArrZza[i12], zziq.zza(strArrSplit[i11].charAt(0)));
                i12++;
                i11++;
            }
            return new zzax((EnumMap<zziq.zza, zzip>) enumMap, i10, (Boolean) null, (String) null);
        }
        return zza;
    }

    public static Boolean zza(Bundle bundle) {
        zzip zzipVarZza;
        if (bundle == null || (zzipVarZza = zziq.zza(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i10 = zzaw.zza[zzipVarZza.ordinal()];
        if (i10 == 3) {
            return Boolean.FALSE;
        }
        if (i10 != 4) {
            return null;
        }
        return Boolean.TRUE;
    }
}
