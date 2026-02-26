package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpc {
    private Integer zza = null;
    private Integer zzb = null;
    private zzgpd zzc = null;
    private zzgpe zzd = zzgpe.zzd;

    private zzgpc() {
    }

    public final zzgpc zza(zzgpd zzgpdVar) {
        this.zzc = zzgpdVar;
        return this;
    }

    public final zzgpc zzb(int i10) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i10);
        return this;
    }

    public final zzgpc zzc(int i10) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i10);
        return this;
    }

    public final zzgpc zzd(zzgpe zzgpeVar) {
        this.zzd = zzgpeVar;
        return this;
    }

    public final zzgpg zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
        }
        int iIntValue = this.zzb.intValue();
        zzgpd zzgpdVar = this.zzc;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(iIntValue)));
        }
        if (zzgpdVar == zzgpd.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(iIntValue)));
            }
        } else if (zzgpdVar == zzgpd.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(iIntValue)));
            }
        } else if (zzgpdVar == zzgpd.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(iIntValue)));
            }
        } else if (zzgpdVar == zzgpd.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(iIntValue)));
            }
        } else {
            if (zzgpdVar != zzgpd.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(iIntValue)));
            }
        }
        return new zzgpg(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
    }

    /* synthetic */ zzgpc(zzgpb zzgpbVar) {
    }
}
