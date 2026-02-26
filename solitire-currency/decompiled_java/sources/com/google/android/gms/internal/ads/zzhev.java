package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhev {
    public static final zzhev zza = new zzhev(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzhev zzb = new zzhev(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzhev zzc = new zzhev(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzhev zzd = new zzhev(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public final double zze;
    public final double zzf;
    public final double zzg;
    public final double zzh;
    public final double zzi;
    public final double zzj;
    public final double zzk;
    public final double zzl;
    public final double zzm;

    public zzhev(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
        this.zze = d14;
        this.zzf = d15;
        this.zzg = d16;
        this.zzh = d10;
        this.zzi = d11;
        this.zzj = d12;
        this.zzk = d13;
        this.zzl = d17;
        this.zzm = d18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzhev.class != obj.getClass()) {
            return false;
        }
        zzhev zzhevVar = (zzhev) obj;
        return Double.compare(zzhevVar.zzh, this.zzh) == 0 && Double.compare(zzhevVar.zzi, this.zzi) == 0 && Double.compare(zzhevVar.zzj, this.zzj) == 0 && Double.compare(zzhevVar.zzk, this.zzk) == 0 && Double.compare(zzhevVar.zzl, this.zzl) == 0 && Double.compare(zzhevVar.zzm, this.zzm) == 0 && Double.compare(zzhevVar.zze, this.zze) == 0 && Double.compare(zzhevVar.zzf, this.zzf) == 0 && Double.compare(zzhevVar.zzg, this.zzg) == 0;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zze);
        long j10 = jDoubleToLongBits ^ (jDoubleToLongBits >>> 32);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zzf);
        long j11 = jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32);
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.zzg);
        long j12 = jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32);
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.zzh);
        long j13 = jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32);
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.zzi);
        long j14 = jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32);
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.zzj);
        long j15 = jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32);
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.zzk);
        long j16 = jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32);
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.zzl);
        long j17 = jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32);
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.zzm);
        return (((((((((((((((((int) j10) * 31) + ((int) j11)) * 31) + ((int) j12)) * 31) + ((int) j13)) * 31) + ((int) j14)) * 31) + ((int) j15)) * 31) + ((int) j16)) * 31) + ((int) j17)) * 31) + ((int) (jDoubleToLongBits9 ^ (jDoubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zza)) {
            return "Rotate 0°";
        }
        if (equals(zzb)) {
            return "Rotate 90°";
        }
        if (equals(zzc)) {
            return "Rotate 180°";
        }
        if (equals(zzd)) {
            return "Rotate 270°";
        }
        double d10 = this.zze;
        double d11 = this.zzf;
        double d12 = this.zzg;
        double d13 = this.zzh;
        double d14 = this.zzi;
        double d15 = this.zzj;
        double d16 = this.zzk;
        double d17 = this.zzl;
        double d18 = this.zzm;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d10);
        sb.append(", v=");
        sb.append(d11);
        sb.append(", w=");
        sb.append(d12);
        sb.append(", a=");
        sb.append(d13);
        sb.append(", b=");
        sb.append(d14);
        sb.append(", c=");
        sb.append(d15);
        sb.append(", d=");
        sb.append(d16);
        sb.append(", tx=");
        sb.append(d17);
        sb.append(", ty=");
        sb.append(d18);
        sb.append("}");
        return sb.toString();
    }
}
