package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhcl extends zzgxy implements zzgzk {
    private static final zzhcl zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgwm zzd;
    private zzgwm zze;
    private byte zzf = 2;

    static {
        zzhcl zzhclVar = new zzhcl();
        zza = zzhclVar;
        zzgxy.zzcb(zzhcl.class, zzhclVar);
    }

    private zzhcl() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zzd = zzgwmVar;
        this.zze = zzgwmVar;
    }

    public static zzhck zzc() {
        return (zzhck) zza.zzaZ();
    }

    static /* synthetic */ void zze(zzhcl zzhclVar, zzgwm zzgwmVar) {
        zzhclVar.zzc |= 1;
        zzhclVar.zzd = zzgwmVar;
    }

    static /* synthetic */ void zzf(zzhcl zzhclVar, zzgwm zzgwmVar) {
        zzhclVar.zzc |= 2;
        zzhclVar.zze = zzgwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzf);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzf = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhcl();
            case NEW_BUILDER:
                return new zzhck(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzhcl.class) {
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
