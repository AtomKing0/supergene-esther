package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztk implements zzuy {
    private final zzacp zza;

    @Nullable
    private zzack zzb;

    @Nullable
    private zzacl zzc;

    public zztk(zzacp zzacpVar) {
        this.zza = zzacpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final int zza(zzadf zzadfVar) throws IOException {
        zzack zzackVar = this.zzb;
        zzackVar.getClass();
        zzacl zzaclVar = this.zzc;
        zzaclVar.getClass();
        return zzackVar.zzb(zzaclVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final long zzb() {
        zzacl zzaclVar = this.zzc;
        if (zzaclVar != null) {
            return zzaclVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final void zzc() {
        zzack zzackVar = this.zzb;
        if (zzackVar == null) {
            return;
        }
        zzack zzackVarZzc = zzackVar.zzc();
        if (zzackVarZzc instanceof zzahp) {
            ((zzahp) zzackVarZzc).zza();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    @Override // com.google.android.gms.internal.ads.zzuy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(com.google.android.gms.internal.ads.zzp r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzacn r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzaby r6 = new com.google.android.gms.internal.ads.zzaby
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.zzc = r6
            com.google.android.gms.internal.ads.zzack r8 = r7.zzb
            if (r8 == 0) goto L10
            return
        L10:
            com.google.android.gms.internal.ads.zzacp r8 = r7.zza
            com.google.android.gms.internal.ads.zzack[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            com.google.android.gms.internal.ads.zzfxo r13 = com.google.android.gms.internal.ads.zzfxr.zzi(r10)
            r14 = 0
            r0 = 1
            if (r10 != r0) goto L24
            r8 = r8[r14]
            r7.zzb = r8
            goto L7e
        L24:
            r1 = r14
        L25:
            if (r1 >= r10) goto L7a
            r2 = r8[r1]
            boolean r3 = r2.zzj(r6)     // Catch: java.lang.Throwable -> L4c java.io.EOFException -> L61
            if (r3 == 0) goto L38
            r7.zzb = r2     // Catch: java.lang.Throwable -> L4c java.io.EOFException -> L61
            com.google.android.gms.internal.ads.zzdi.zzf(r0)
            r6.zzj()
            goto L7a
        L38:
            java.util.List r2 = r2.zzd()     // Catch: java.lang.Throwable -> L4c java.io.EOFException -> L61
            r13.zzh(r2)     // Catch: java.lang.Throwable -> L4c java.io.EOFException -> L61
            com.google.android.gms.internal.ads.zzack r2 = r7.zzb
            if (r2 != 0) goto L70
            long r2 = r6.zzf()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L6e
            goto L70
        L4c:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzack r9 = r7.zzb
            if (r9 != 0) goto L59
            long r9 = r6.zzf()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L5a
        L59:
            r14 = r0
        L5a:
            com.google.android.gms.internal.ads.zzdi.zzf(r14)
            r6.zzj()
            throw r8
        L61:
            com.google.android.gms.internal.ads.zzack r2 = r7.zzb
            if (r2 != 0) goto L70
            long r2 = r6.zzf()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L6e
            goto L70
        L6e:
            r2 = r14
            goto L71
        L70:
            r2 = r0
        L71:
            com.google.android.gms.internal.ads.zzdi.zzf(r2)
            r6.zzj()
            int r1 = r1 + 1
            goto L25
        L7a:
            com.google.android.gms.internal.ads.zzack r10 = r7.zzb
            if (r10 == 0) goto L84
        L7e:
            com.google.android.gms.internal.ads.zzack r8 = r7.zzb
            r8.zze(r15)
            return
        L84:
            com.google.android.gms.internal.ads.zzwj r10 = new com.google.android.gms.internal.ads.zzwj
            com.google.android.gms.internal.ads.zzfxr r8 = com.google.android.gms.internal.ads.zzfxr.zzl(r8)
            com.google.android.gms.internal.ads.zztj r11 = new com.google.android.gms.internal.ads.zztj
            r11.<init>()
            java.util.List r8 = com.google.android.gms.internal.ads.zzfyh.zzb(r8, r11)
            java.util.Iterator r8 = r8.iterator()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = ", "
            com.google.android.gms.internal.ads.zzfum.zzc(r11, r8, r12)
            java.lang.String r8 = r11.toString()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            com.google.android.gms.internal.ads.zzfxr r11 = r13.zzi()
            r10.<init>(r8, r9, r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztk.zzd(com.google.android.gms.internal.ads.zzp, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzacn):void");
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final void zze() {
        zzack zzackVar = this.zzb;
        if (zzackVar != null) {
            zzackVar.zzf();
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzuy
    public final void zzf(long j10, long j11) {
        zzack zzackVar = this.zzb;
        zzackVar.getClass();
        zzackVar.zzi(j10, j11);
    }
}
