package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzauj {

    @VisibleForTesting
    protected volatile Boolean zzb;
    private final zzavp zze;
    private static final ConditionVariable zzc = new ConditionVariable();

    @VisibleForTesting
    protected static volatile zzfqj zza = null;
    private static volatile Random zzd = null;

    public zzauj(zzavp zzavpVar) {
        this.zze = zzavpVar;
        zzavpVar.zzk().execute(new zzaui(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zzd == null) {
                synchronized (zzauj.class) {
                    if (zzd == null) {
                        zzd = new Random();
                    }
                }
            }
            return zzd.nextInt();
        }
    }

    public final void zzc(int i10, int i11, long j10, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzara zzaraVarZza = zzare.zza();
            zzaraVarZza.zza(this.zze.zza.getPackageName());
            zzaraVarZza.zze(j10);
            if (str != null) {
                zzaraVarZza.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzaraVarZza.zzf(stringWriter.toString());
                zzaraVarZza.zzd(exc.getClass().getName());
            }
            zzfqi zzfqiVarZza = zza.zza(((zzare) zzaraVarZza.zzbr()).zzaV());
            zzfqiVarZza.zza(i10);
            if (i11 != -1) {
                zzfqiVarZza.zzb(i11);
            }
            zzfqiVarZza.zzc();
        } catch (Exception unused) {
        }
    }
}
