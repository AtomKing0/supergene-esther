package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgui extends zzgxy implements zzgzk {
    private static final zzgui zza;
    private static volatile zzgzr zzb;
    private int zzc;

    static {
        zzgui zzguiVar = new zzgui();
        zza = zzguiVar;
        zzgxy.zzcb(zzgui.class, zzguiVar);
    }

    private zzgui() {
    }

    public static zzgui zzd() {
        return zza;
    }

    public static zzgui zze(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgui) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgug zzgugVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgui();
            case NEW_BUILDER:
                return new zzguh(zzgugVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgui.class) {
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
