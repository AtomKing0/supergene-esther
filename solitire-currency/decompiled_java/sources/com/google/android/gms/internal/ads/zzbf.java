package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbf {

    @Nullable
    private CharSequence zza;

    @Nullable
    private CharSequence zzb;

    @Nullable
    private CharSequence zzc;

    @Nullable
    private CharSequence zzd;

    @Nullable
    private CharSequence zze;

    @Nullable
    private byte[] zzf;

    @Nullable
    private Integer zzg;

    @Nullable
    private Integer zzh;

    @Nullable
    private Integer zzi;

    @Nullable
    private Integer zzj;

    @Nullable
    private Boolean zzk;

    @Nullable
    private Integer zzl;

    @Nullable
    private Integer zzm;

    @Nullable
    private Integer zzn;

    @Nullable
    private Integer zzo;

    @Nullable
    private Integer zzp;

    @Nullable
    private Integer zzq;

    @Nullable
    private CharSequence zzr;

    @Nullable
    private CharSequence zzs;

    @Nullable
    private CharSequence zzt;

    @Nullable
    private CharSequence zzu;

    @Nullable
    private CharSequence zzv;

    @Nullable
    private Integer zzw;

    public zzbf() {
    }

    /* synthetic */ zzbf(zzbh zzbhVar, zzbe zzbeVar) {
        this.zza = zzbhVar.zzb;
        this.zzb = zzbhVar.zzc;
        this.zzc = zzbhVar.zzd;
        this.zzd = zzbhVar.zze;
        this.zze = zzbhVar.zzf;
        this.zzf = zzbhVar.zzg;
        this.zzg = zzbhVar.zzh;
        this.zzh = zzbhVar.zzi;
        this.zzi = zzbhVar.zzj;
        this.zzj = zzbhVar.zzk;
        this.zzk = zzbhVar.zzl;
        this.zzl = zzbhVar.zzn;
        this.zzm = zzbhVar.zzo;
        this.zzn = zzbhVar.zzp;
        this.zzo = zzbhVar.zzq;
        this.zzp = zzbhVar.zzr;
        this.zzq = zzbhVar.zzs;
        this.zzr = zzbhVar.zzt;
        this.zzs = zzbhVar.zzu;
        this.zzt = zzbhVar.zzv;
        this.zzu = zzbhVar.zzw;
        this.zzv = zzbhVar.zzx;
        this.zzw = zzbhVar.zzy;
    }

    public final zzbf zza(byte[] bArr, int i10) {
        if (this.zzf == null || zzet.zzG(Integer.valueOf(i10), 3) || !zzet.zzG(this.zzg, 3)) {
            this.zzf = (byte[]) bArr.clone();
            this.zzg = Integer.valueOf(i10);
        }
        return this;
    }

    public final zzbf zzb(@Nullable zzbh zzbhVar) {
        if (zzbhVar != null) {
            CharSequence charSequence = zzbhVar.zzb;
            if (charSequence != null) {
                this.zza = charSequence;
            }
            CharSequence charSequence2 = zzbhVar.zzc;
            if (charSequence2 != null) {
                this.zzb = charSequence2;
            }
            CharSequence charSequence3 = zzbhVar.zzd;
            if (charSequence3 != null) {
                this.zzc = charSequence3;
            }
            CharSequence charSequence4 = zzbhVar.zze;
            if (charSequence4 != null) {
                this.zzd = charSequence4;
            }
            CharSequence charSequence5 = zzbhVar.zzf;
            if (charSequence5 != null) {
                this.zze = charSequence5;
            }
            byte[] bArr = zzbhVar.zzg;
            if (bArr != null) {
                Integer num = zzbhVar.zzh;
                this.zzf = (byte[]) bArr.clone();
                this.zzg = num;
            }
            Integer num2 = zzbhVar.zzi;
            if (num2 != null) {
                this.zzh = num2;
            }
            Integer num3 = zzbhVar.zzj;
            if (num3 != null) {
                this.zzi = num3;
            }
            Integer num4 = zzbhVar.zzk;
            if (num4 != null) {
                this.zzj = num4;
            }
            Boolean bool = zzbhVar.zzl;
            if (bool != null) {
                this.zzk = bool;
            }
            Integer num5 = zzbhVar.zzm;
            if (num5 != null) {
                this.zzl = num5;
            }
            Integer num6 = zzbhVar.zzn;
            if (num6 != null) {
                this.zzl = num6;
            }
            Integer num7 = zzbhVar.zzo;
            if (num7 != null) {
                this.zzm = num7;
            }
            Integer num8 = zzbhVar.zzp;
            if (num8 != null) {
                this.zzn = num8;
            }
            Integer num9 = zzbhVar.zzq;
            if (num9 != null) {
                this.zzo = num9;
            }
            Integer num10 = zzbhVar.zzr;
            if (num10 != null) {
                this.zzp = num10;
            }
            Integer num11 = zzbhVar.zzs;
            if (num11 != null) {
                this.zzq = num11;
            }
            CharSequence charSequence6 = zzbhVar.zzt;
            if (charSequence6 != null) {
                this.zzr = charSequence6;
            }
            CharSequence charSequence7 = zzbhVar.zzu;
            if (charSequence7 != null) {
                this.zzs = charSequence7;
            }
            CharSequence charSequence8 = zzbhVar.zzv;
            if (charSequence8 != null) {
                this.zzt = charSequence8;
            }
            CharSequence charSequence9 = zzbhVar.zzw;
            if (charSequence9 != null) {
                this.zzu = charSequence9;
            }
            CharSequence charSequence10 = zzbhVar.zzx;
            if (charSequence10 != null) {
                this.zzv = charSequence10;
            }
            Integer num12 = zzbhVar.zzy;
            if (num12 != null) {
                this.zzw = num12;
            }
        }
        return this;
    }

    public final zzbf zzc(@Nullable CharSequence charSequence) {
        this.zzd = charSequence;
        return this;
    }

    public final zzbf zzd(@Nullable CharSequence charSequence) {
        this.zzc = charSequence;
        return this;
    }

    public final zzbf zze(@Nullable CharSequence charSequence) {
        this.zzb = charSequence;
        return this;
    }

    public final zzbf zzf(@Nullable CharSequence charSequence) {
        this.zzs = charSequence;
        return this;
    }

    public final zzbf zzg(@Nullable CharSequence charSequence) {
        this.zzt = charSequence;
        return this;
    }

    public final zzbf zzh(@Nullable CharSequence charSequence) {
        this.zze = charSequence;
        return this;
    }

    public final zzbf zzi(@Nullable CharSequence charSequence) {
        this.zzu = charSequence;
        return this;
    }

    public final zzbf zzj(@IntRange(from = 1, to = 31) @Nullable Integer num) {
        this.zzn = num;
        return this;
    }

    public final zzbf zzk(@IntRange(from = 1, to = 12) @Nullable Integer num) {
        this.zzm = num;
        return this;
    }

    public final zzbf zzl(@Nullable Integer num) {
        this.zzl = num;
        return this;
    }

    public final zzbf zzm(@IntRange(from = 1, to = 31) @Nullable Integer num) {
        this.zzq = num;
        return this;
    }

    public final zzbf zzn(@IntRange(from = 1, to = 12) @Nullable Integer num) {
        this.zzp = num;
        return this;
    }

    public final zzbf zzo(@Nullable Integer num) {
        this.zzo = num;
        return this;
    }

    public final zzbf zzp(@Nullable CharSequence charSequence) {
        this.zzv = charSequence;
        return this;
    }

    public final zzbf zzq(@Nullable CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzbf zzr(@Nullable Integer num) {
        this.zzi = num;
        return this;
    }

    public final zzbf zzs(@Nullable Integer num) {
        this.zzh = num;
        return this;
    }

    public final zzbf zzt(@Nullable CharSequence charSequence) {
        this.zzr = charSequence;
        return this;
    }

    public final zzbh zzu() {
        return new zzbh(this);
    }
}
