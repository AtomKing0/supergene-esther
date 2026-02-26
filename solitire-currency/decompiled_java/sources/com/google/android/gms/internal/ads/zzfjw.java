package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjw implements zzfju {
    private final Context zza;
    private final int zzp;
    private long zzb = 0;
    private long zzc = -1;
    private boolean zzd = false;
    private int zzq = 2;
    private int zzr = 2;
    private int zze = 0;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzfkl zzj = zzfkl.SCAR_REQUEST_TYPE_UNSPECIFIED;
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private boolean zzn = false;
    private boolean zzo = false;

    zzfjw(Context context, int i10) {
        this.zza = context;
        this.zzp = i10;
    }

    public final synchronized zzfjw zzA() {
        this.zzc = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
        return this;
    }

    public final synchronized zzfjw zzK(int i10) {
        this.zzq = i10;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzr(zzeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzb(zzfew zzfewVar) {
        zzs(zzfewVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzc(String str) {
        zzt(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzd(String str) {
        zzu(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zze(String str) {
        zzv(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzf(zzfkl zzfklVar) {
        zzw(zzfklVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzg(boolean z10) {
        zzx(z10);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzh(Throwable th) {
        zzy(th);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzi() {
        zzz();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzj() {
        zzA();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final synchronized boolean zzk() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    @Nullable
    public final synchronized zzfjy zzm() {
        zzfjx zzfjxVar = null;
        if (this.zzn) {
            return null;
        }
        this.zzn = true;
        if (!this.zzo) {
            zzz();
        }
        if (this.zzc < 0) {
            zzA();
        }
        return new zzfjy(this, zzfjxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfju
    public final /* bridge */ /* synthetic */ zzfju zzn(int i10) {
        zzK(i10);
        return this;
    }

    public final synchronized zzfjw zzr(com.google.android.gms.ads.internal.client.zze zzeVar) {
        IBinder iBinder = zzeVar.zze;
        if (iBinder != null) {
            zzcwj zzcwjVar = (zzcwj) iBinder;
            String strZzk = zzcwjVar.zzk();
            if (!TextUtils.isEmpty(strZzk)) {
                this.zzf = strZzk;
            }
            String strZzi = zzcwjVar.zzi();
            if (!TextUtils.isEmpty(strZzi)) {
                this.zzg = strZzi;
            }
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        r2.zzg = r0.zzab;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.google.android.gms.internal.ads.zzfjw zzs(com.google.android.gms.internal.ads.zzfew r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzfeo r0 = r3.zzb     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r0.zzb     // Catch: java.lang.Throwable -> L31
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L31
            if (r0 != 0) goto L11
            com.google.android.gms.internal.ads.zzfeo r0 = r3.zzb     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r0.zzb     // Catch: java.lang.Throwable -> L31
            r2.zzf = r0     // Catch: java.lang.Throwable -> L31
        L11:
            java.util.List r3 = r3.zza     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L31
        L17:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r0 == 0) goto L2f
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.internal.ads.zzfel r0 = (com.google.android.gms.internal.ads.zzfel) r0     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = r0.zzab     // Catch: java.lang.Throwable -> L31
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L31
            if (r1 != 0) goto L17
            java.lang.String r3 = r0.zzab     // Catch: java.lang.Throwable -> L31
            r2.zzg = r3     // Catch: java.lang.Throwable -> L31
        L2f:
            monitor-exit(r2)
            return r2
        L31:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfjw.zzs(com.google.android.gms.internal.ads.zzfew):com.google.android.gms.internal.ads.zzfjw");
    }

    public final synchronized zzfjw zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhV)).booleanValue()) {
            this.zzm = str;
        }
        return this;
    }

    public final synchronized zzfjw zzu(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfjw zzv(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfjw zzw(zzfkl zzfklVar) {
        this.zzj = zzfklVar;
        return this;
    }

    public final synchronized zzfjw zzx(boolean z10) {
        this.zzd = z10;
        return this;
    }

    public final synchronized zzfjw zzy(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhV)).booleanValue()) {
            this.zzl = zzbtq.zzf(th);
            this.zzk = (String) zzfvh.zzb(zzfui.zzc('\n')).zzc(zzbtq.zze(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfjw zzz() {
        Configuration configuration;
        this.zze = com.google.android.gms.ads.internal.zzu.zzq().zzm(this.zza);
        Resources resources = this.zza.getResources();
        int i10 = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i10 = configuration.orientation == 2 ? 4 : 3;
        }
        this.zzr = i10;
        this.zzb = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
        this.zzo = true;
        return this;
    }
}
