package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgrj extends zzgxy implements zzgzk {
    private static final zzgrj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgrp zze;
    private zzgwm zzf = zzgwm.zzb;

    static {
        zzgrj zzgrjVar = new zzgrj();
        zza = zzgrjVar;
        zzgxy.zzcb(zzgrj.class, zzgrjVar);
    }

    private zzgrj() {
    }

    public static zzgri zzc() {
        return (zzgri) zza.zzaZ();
    }

    public static zzgrj zze(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgrj) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzi(zzgrj zzgrjVar, zzgrp zzgrpVar) {
        zzgrpVar.getClass();
        zzgrjVar.zze = zzgrpVar;
        zzgrjVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgrh zzgrhVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgrj();
            case NEW_BUILDER:
                return new zzgri(zzgrhVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgrj.class) {
                        zzgxtVar = zzb;
                        if (zzgxtVar == null) {
                            zzgxtVar = new zzgxt(zza);
                            zzb = zzgxtVar;
                        }
                        break;
                    }
                }
                return zzgxtVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzgrp zzf() {
        zzgrp zzgrpVar = this.zze;
        return zzgrpVar == null ? zzgrp.zze() : zzgrpVar;
    }

    public final zzgwm zzg() {
        return this.zzf;
    }
}
