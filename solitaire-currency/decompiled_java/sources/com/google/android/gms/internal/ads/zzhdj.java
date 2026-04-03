package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhdj extends zzgxy implements zzgzk {
    private static final zzhdj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgwm zzf;
    private zzgwm zzg;

    static {
        zzhdj zzhdjVar = new zzhdj();
        zza = zzhdjVar;
        zzgxy.zzcb(zzhdj.class, zzhdjVar);
    }

    private zzhdj() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zzf = zzgwmVar;
        this.zzg = zzgwmVar;
    }

    public static zzhdh zzc() {
        return (zzhdh) zza.zzaZ();
    }

    static /* synthetic */ void zze(zzhdj zzhdjVar, String str) {
        zzhdjVar.zzc |= 2;
        zzhdjVar.zze = MimeTypes.IMAGE_PNG;
    }

    static /* synthetic */ void zzf(zzhdj zzhdjVar, zzgwm zzgwmVar) {
        zzgwmVar.getClass();
        zzhdjVar.zzc |= 4;
        zzhdjVar.zzf = zzgwmVar;
    }

    static /* synthetic */ void zzg(zzhdj zzhdjVar, int i10) {
        zzhdjVar.zzd = 1;
        zzhdjVar.zzc = 1 | zzhdjVar.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", zzhdi.zza, "zze", "zzf", "zzg"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdj();
            case NEW_BUILDER:
                return new zzhdh(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzhdj.class) {
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
}
