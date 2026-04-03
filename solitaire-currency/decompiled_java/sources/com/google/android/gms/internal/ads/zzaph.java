package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaph implements Comparable {
    private final zzaps zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;

    @Nullable
    @GuardedBy("mLock")
    private final zzapl zzf;
    private Integer zzg;
    private zzapk zzh;

    @GuardedBy("mLock")
    private boolean zzi;

    @Nullable
    private zzaoq zzj;

    @GuardedBy("mLock")
    private zzapg zzk;
    private final zzaov zzl;

    public zzaph(int i10, String str, @Nullable zzapl zzaplVar) {
        Uri uri;
        String host;
        this.zza = zzaps.zza ? new zzaps() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i10;
        this.zzc = str;
        this.zzf = zzaplVar;
        this.zzl = new zzaov();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzaph) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(strValueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    @Nullable
    public final zzaoq zzd() {
        return this.zzj;
    }

    public final zzaph zze(zzaoq zzaoqVar) {
        this.zzj = zzaoqVar;
        return this;
    }

    public final zzaph zzf(zzapk zzapkVar) {
        this.zzh = zzapkVar;
        return this;
    }

    public final zzaph zzg(int i10) {
        this.zzg = Integer.valueOf(i10);
        return this;
    }

    protected abstract zzapn zzh(zzapd zzapdVar);

    public final String zzj() {
        int i10 = this.zzb;
        String str = this.zzc;
        if (i10 == 0) {
            return str;
        }
        return Integer.toString(1) + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzaop {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzaps.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzapq zzapqVar) {
        zzapl zzaplVar;
        synchronized (this.zze) {
            zzaplVar = this.zzf;
        }
        zzaplVar.zza(zzapqVar);
    }

    protected abstract void zzo(Object obj);

    final void zzp(String str) {
        zzapk zzapkVar = this.zzh;
        if (zzapkVar != null) {
            zzapkVar.zzb(this);
        }
        if (zzaps.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzapf(this, str, id));
            } else {
                this.zza.zza(str, id);
                this.zza.zzb(toString());
            }
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    final void zzr() {
        zzapg zzapgVar;
        synchronized (this.zze) {
            zzapgVar = this.zzk;
        }
        if (zzapgVar != null) {
            zzapgVar.zza(this);
        }
    }

    final void zzs(zzapn zzapnVar) {
        zzapg zzapgVar;
        synchronized (this.zze) {
            zzapgVar = this.zzk;
        }
        if (zzapgVar != null) {
            zzapgVar.zzb(this, zzapnVar);
        }
    }

    final void zzt(int i10) {
        zzapk zzapkVar = this.zzh;
        if (zzapkVar != null) {
            zzapkVar.zzc(this, i10);
        }
    }

    final void zzu(zzapg zzapgVar) {
        synchronized (this.zze) {
            this.zzk = zzapgVar;
        }
    }

    public final boolean zzv() {
        boolean z10;
        synchronized (this.zze) {
            z10 = this.zzi;
        }
        return z10;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaop {
        return null;
    }

    public final zzaov zzy() {
        return this.zzl;
    }
}
