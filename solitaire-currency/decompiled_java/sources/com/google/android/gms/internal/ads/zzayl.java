package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayl {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzaza zze;
    private final zzazi zzf;
    private int zzn;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzayl(int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z10) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = z10;
        this.zze = new zzaza(i13);
        this.zzf = new zzazi(i14, i15, i16);
    }

    private final void zzp(@Nullable String str, boolean z10, float f10, float f11, float f12, float f13) {
        if (str != null) {
            if (str.length() < this.zzc) {
                return;
            }
            synchronized (this.zzg) {
                this.zzh.add(str);
                this.zzk += str.length();
                if (z10) {
                    this.zzi.add(str);
                    this.zzj.add(new zzayw(f10, f11, f12, f13, this.zzi.size() - 1));
                }
            }
        }
    }

    private static final String zzq(ArrayList arrayList, int i10) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            sb.append((String) arrayList.get(i11));
            sb.append(' ');
            i11++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzayl)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzayl) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        ArrayList arrayList = this.zzh;
        return "ActivityContent fetchId: " + this.zzl + " score:" + this.zzn + " total_length:" + this.zzk + "\n text: " + zzq(arrayList, 100) + "\n viewableText" + zzq(this.zzi, 100) + "\n signture: " + this.zzo + "\n viewableSignture: " + this.zzp + "\n viewableSignatureForVertical: " + this.zzq;
    }

    @VisibleForTesting
    final int zza(int i10, int i11) {
        return this.zzd ? this.zzb : (i10 * this.zza) + (i11 * this.zzb);
    }

    public final int zzb() {
        return this.zzn;
    }

    @VisibleForTesting
    final int zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzo;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final void zzg() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzh() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzi() {
        synchronized (this.zzg) {
            this.zzn -= 100;
        }
    }

    public final void zzj(int i10) {
        this.zzl = i10;
    }

    public final void zzk(String str, boolean z10, float f10, float f11, float f12, float f13) {
        zzp(str, z10, f10, f11, f12, f13);
    }

    public final void zzl(String str, boolean z10, float f10, float f11, float f12, float f13) {
        zzp(str, z10, f10, f11, f12, f13);
        synchronized (this.zzg) {
            if (this.zzm < 0) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("ActivityContent: negative number of WebViews.");
            }
            zzm();
        }
    }

    public final void zzm() {
        synchronized (this.zzg) {
            int iZza = zza(this.zzk, this.zzl);
            if (iZza > this.zzn) {
                this.zzn = iZza;
                if (!com.google.android.gms.ads.internal.zzu.zzo().zzi().zzP()) {
                    this.zzo = this.zze.zza(this.zzh);
                    this.zzp = this.zze.zza(this.zzi);
                }
                if (!com.google.android.gms.ads.internal.zzu.zzo().zzi().zzQ()) {
                    this.zzq = this.zzf.zza(this.zzi, this.zzj);
                }
            }
        }
    }

    public final void zzn() {
        synchronized (this.zzg) {
            int iZza = zza(this.zzk, this.zzl);
            if (iZza > this.zzn) {
                this.zzn = iZza;
            }
        }
    }

    public final boolean zzo() {
        boolean z10;
        synchronized (this.zzg) {
            z10 = this.zzm == 0;
        }
        return z10;
    }
}
