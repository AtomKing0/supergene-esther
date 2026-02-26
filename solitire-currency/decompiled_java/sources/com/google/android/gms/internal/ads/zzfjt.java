package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzfjt {
    public static zzfju zza(Context context, int i10) {
        boolean zBooleanValue;
        if (zzfki.zza()) {
            int i11 = i10 - 2;
            if (i11 != 20 && i11 != 21) {
                switch (i11) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbdl.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbdl.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbdl.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) zzbdl.zze.zze()).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfjw(context, i10);
            }
        }
        return new zzfky();
    }

    public static zzfju zzb(Context context, int i10, int i11, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        zzfju zzfjuVarZza = zza(context, i10);
        if (zzfjuVarZza instanceof zzfjw) {
            zzfjuVarZza.zzi();
            zzfjuVarZza.zzn(i11);
            zzfjuVarZza.zzf(com.google.android.gms.ads.nonagon.signalgeneration.zzq.zza(zzlVar.zzm));
            if (zzfke.zze(zzlVar.zzp)) {
                zzfjuVarZza.zze(zzlVar.zzp);
            }
        }
        return zzfjuVarZza;
    }
}
