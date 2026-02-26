package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games_v2.zzez;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzw extends com.google.android.gms.internal.games_v2.zzaj {
    final /* synthetic */ zzak zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzw(zzak zzakVar) {
        super(zzakVar.getContext().getMainLooper(), 1000);
        this.zza = zzakVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.games_v2.zzaj
    protected final void zza(String str, int i10) {
        try {
            if (this.zza.isConnected()) {
                ((zzap) this.zza.getService()).zzw(str, i10);
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 89);
            sb.append("Unable to increment event ");
            sb.append(str);
            sb.append(" by ");
            sb.append(i10);
            sb.append(" because the games client is no longer connected");
            zzez.zzc("GamesGmsClientImpl", sb.toString());
        } catch (RemoteException e10) {
            zzak.zzU(e10);
        } catch (SecurityException e11) {
            int i11 = zzak.zze;
            zzez.zzd("GamesGmsClientImpl", "Is player signed out?", e11);
        }
    }
}
