package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaeb implements zzack {
    private final zzek zza;
    private final zzaea zzb;
    private final boolean zzc;
    private final zzajy zzd;
    private int zze;
    private zzacn zzf;
    private zzaec zzg;
    private long zzh;
    private zzaee[] zzi;
    private long zzj;

    @Nullable
    private zzaee zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaeb() {
        this(1, zzajy.zza);
    }

    @Nullable
    private final zzaee zzg(int i10) {
        for (zzaee zzaeeVar : this.zzi) {
            if (zzaeeVar.zzg(i10)) {
                return zzaeeVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x030d  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r28, com.google.android.gms.internal.ads.zzadf r29) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeb.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zze = 0;
        if (this.zzc) {
            zzacnVar = new zzakc(zzacnVar, this.zzd);
        }
        this.zzf = zzacnVar;
        this.zzj = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzaee zzaeeVar : this.zzi) {
            zzaeeVar.zzf(j10);
        }
        if (j10 == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        ((zzaby) zzaclVar).zzm(this.zza.zzM(), 0, 12, false);
        this.zza.zzK(0);
        if (this.zza.zzi() != 1179011410) {
            return false;
        }
        this.zza.zzL(4);
        return this.zza.zzi() == 541677121;
    }

    public zzaeb(int i10, zzajy zzajyVar) {
        this.zzd = zzajyVar;
        this.zzc = 1 == (i10 ^ 1);
        this.zza = new zzek(12);
        this.zzb = new zzaea(null);
        this.zzf = new zzaci();
        this.zzi = new zzaee[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
