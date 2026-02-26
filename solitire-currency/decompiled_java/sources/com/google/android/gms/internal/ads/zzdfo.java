package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdfo extends zzcru {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzddu zze;
    private final zzdgx zzf;
    private final zzcsp zzg;
    private final zzfos zzh;
    private final zzcxd zzi;
    private final zzbzi zzj;
    private boolean zzk;

    zzdfo(zzcrt zzcrtVar, Context context, zzcej zzcejVar, zzddu zzdduVar, zzdgx zzdgxVar, zzcsp zzcspVar, zzfos zzfosVar, zzcxd zzcxdVar, zzbzi zzbziVar) {
        super(zzcrtVar);
        this.zzk = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcejVar);
        this.zze = zzdduVar;
        this.zzf = zzdgxVar;
        this.zzg = zzcspVar;
        this.zzh = zzfosVar;
        this.zzi = zzcxdVar;
        this.zzj = zzbziVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcej zzcejVar = (zzcej) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzga)).booleanValue()) {
                if (!this.zzk && zzcejVar != null) {
                    zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdfn
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcejVar.destroy();
                        }
                    });
                }
            } else if (zzcejVar != null) {
                zzcejVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(boolean r5, android.app.Activity r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzddu r0 = r4.zze
            r0.zzb()
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzat
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L4e
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r0 = r4.zzc
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzG(r0)
            if (r0 == 0) goto L4e
            java.lang.String r5 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)
            com.google.android.gms.internal.ads.zzcxd r5 = r4.zzi
            r5.zzb()
            com.google.android.gms.internal.ads.zzbbn r5 = com.google.android.gms.internal.ads.zzbbw.zzau
            com.google.android.gms.internal.ads.zzbbu r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto Lc4
            com.google.android.gms.internal.ads.zzfos r5 = r4.zzh
            com.google.android.gms.internal.ads.zzfex r6 = r4.zza
            com.google.android.gms.internal.ads.zzfew r6 = r6.zzb
            com.google.android.gms.internal.ads.zzfeo r6 = r6.zzb
            java.lang.String r6 = r6.zzb
            r5.zza(r6)
            goto Lc4
        L4e:
            java.lang.ref.WeakReference r0 = r4.zzd
            java.lang.Object r0 = r0.get()
            com.google.android.gms.internal.ads.zzcej r0 = (com.google.android.gms.internal.ads.zzcej) r0
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzkU
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r3 = 0
            if (r2 == 0) goto L92
            if (r0 == 0) goto L92
            com.google.android.gms.internal.ads.zzfel r0 = r0.zzD()
            if (r0 == 0) goto L92
            boolean r2 = r0.zzar
            if (r2 == 0) goto L92
            int r0 = r0.zzas
            com.google.android.gms.internal.ads.zzbzi r2 = r4.zzj
            int r2 = r2.zzb()
            if (r0 == r2) goto L92
            java.lang.String r5 = "The interstitial consent form has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)
            com.google.android.gms.internal.ads.zzcxd r5 = r4.zzi
            r6 = 12
            java.lang.String r0 = "The consent form has already been shown."
            com.google.android.gms.ads.internal.client.zze r6 = com.google.android.gms.internal.ads.zzfgi.zzd(r6, r0, r3)
            r5.zza(r6)
            goto Lc4
        L92:
            boolean r0 = r4.zzk
            if (r0 == 0) goto La6
            java.lang.String r0 = "The interstitial ad has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            com.google.android.gms.internal.ads.zzcxd r0 = r4.zzi
            r2 = 10
            com.google.android.gms.ads.internal.client.zze r2 = com.google.android.gms.internal.ads.zzfgi.zzd(r2, r3, r3)
            r0.zza(r2)
        La6:
            boolean r0 = r4.zzk
            if (r0 != 0) goto Lc4
            if (r6 != 0) goto Lae
            android.content.Context r6 = r4.zzc
        Lae:
            com.google.android.gms.internal.ads.zzdgx r0 = r4.zzf     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbe
            com.google.android.gms.internal.ads.zzcxd r2 = r4.zzi     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbe
            r0.zza(r5, r6, r2)     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbe
            com.google.android.gms.internal.ads.zzddu r5 = r4.zze     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbe
            r5.zza()     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbe
            r5 = 1
            r4.zzk = r5
            return r5
        Lbe:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzcxd r6 = r4.zzi
            r6.zzc(r5)
        Lc4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdfo.zzc(boolean, android.app.Activity):boolean");
    }
}
