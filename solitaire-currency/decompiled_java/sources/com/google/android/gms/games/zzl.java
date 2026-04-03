package com.google.android.gms.games;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzl {
    private static final AtomicInteger zzf = new AtomicInteger(0);
    int zza;
    final ArrayList zzb;
    GoogleSignInAccount zzc;

    @Nullable
    String zzd;
    com.google.android.gms.games.internal.zzl zze;

    private zzl() {
        this.zza = 4368;
        this.zzb = new ArrayList();
        this.zzc = null;
        this.zzd = null;
        throw null;
    }

    public final zzl zza(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    public final zzl zzb(com.google.android.gms.games.internal.zzl zzlVar) {
        this.zze = (com.google.android.gms.games.internal.zzl) Preconditions.checkNotNull(zzlVar);
        return this;
    }

    public final zzl zzc(@NonNull GoogleSignInAccount googleSignInAccount) {
        this.zzc = googleSignInAccount;
        return this;
    }

    public final zzl zzd(int i10) {
        this.zza = 2101523;
        return this;
    }

    public final zzn zze() {
        return new zzn(false, true, 17, false, this.zza, null, this.zzb, false, false, false, this.zzc, null, 0, 9, this.zzd, this.zze, null);
    }

    /* synthetic */ zzl(zzk zzkVar) {
        this.zza = 4368;
        this.zzb = new ArrayList();
        this.zzc = null;
        this.zzd = null;
        this.zze = com.google.android.gms.games.internal.zzl.zza;
    }
}
