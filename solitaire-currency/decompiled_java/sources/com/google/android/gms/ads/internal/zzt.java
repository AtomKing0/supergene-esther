package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzazs;
import com.google.android.gms.internal.ads.zzbcr;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbvt;
import com.google.android.gms.internal.ads.zzbzo;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzt extends zzbt {
    private final VersionInfoParcel zza;
    private final com.google.android.gms.ads.internal.client.zzq zzb;
    private final Future zzc = zzbzo.zza.zzb(new zzp(this));
    private final Context zzd;
    private final zzs zze;

    @Nullable
    private WebView zzf;

    @Nullable
    private zzbh zzg;

    @Nullable
    private zzauo zzh;
    private AsyncTask zzi;

    public zzt(Context context, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, VersionInfoParcel versionInfoParcel) {
        this.zzd = context;
        this.zza = versionInfoParcel;
        this.zzb = zzqVar;
        this.zzf = new WebView(context);
        this.zze = new zzs(context, str);
        zzV(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzn(this));
        this.zzf.setOnTouchListener(new zzo(this));
    }

    static /* bridge */ /* synthetic */ String zzo(zzt zztVar, String str) {
        if (zztVar.zzh == null) {
            return str;
        }
        Uri uriZza = Uri.parse(str);
        try {
            uriZza = zztVar.zzh.zza(uriZza, zztVar.zzd, null, null);
        } catch (zzaup e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Unable to process ad data", e10);
        }
        return uriZza.toString();
    }

    static /* bridge */ /* synthetic */ void zzw(zzt zztVar, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zztVar.zzd.startActivity(intent);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzA() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(zzbe zzbeVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(zzbh zzbhVar) throws RemoteException {
        this.zzg = zzbhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(zzby zzbyVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzF(com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(zzcb zzcbVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(zzazs zzazsVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(zzw zzwVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(zzdu zzduVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzL(boolean z10) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzM(zzbsw zzbswVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzO(zzbcr zzbcrVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(zzbsz zzbszVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(zzbvt zzbvtVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzU(zzfk zzfkVar) {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    final void zzV(int i10) {
        if (this.zzf == null) {
            return;
        }
        this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i10));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzX() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzY() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzZ() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzaa() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzab(com.google.android.gms.ads.internal.client.zzl zzlVar) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zzf(zzlVar, this.zza);
        this.zzi = new zzr(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzac(zzcf zzcfVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    final int zzb(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzay.zzb();
            return com.google.android.gms.ads.internal.util.client.zzf.zzy(this.zzd, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzd() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzq zzg() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzbh zzi() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzcb zzj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    @Nullable
    public final zzdn zzk() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    @Nullable
    public final zzdq zzl() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzn() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    @VisibleForTesting
    final String zzp() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbde.zzd.zze());
        builder.appendQueryParameter("query", this.zze.zzd());
        builder.appendQueryParameter("pubId", this.zze.zzc());
        builder.appendQueryParameter("mappver", this.zze.zza());
        Map mapZze = this.zze.zze();
        for (String str : mapZze.keySet()) {
            builder.appendQueryParameter(str, (String) mapZze.get(str));
        }
        Uri uriBuild = builder.build();
        zzauo zzauoVar = this.zzh;
        if (zzauoVar != null) {
            try {
                uriBuild = zzauoVar.zzb(uriBuild, this.zzd);
            } catch (zzaup e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Unable to process ad data", e10);
            }
        }
        return zzq() + "#" + uriBuild.getEncodedQuery();
    }

    @VisibleForTesting
    final String zzq() {
        String strZzb = this.zze.zzb();
        if (true == TextUtils.isEmpty(strZzb)) {
            strZzb = "www.google.com";
        }
        return "https://" + strZzb + ((String) zzbde.zzd.zze());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzr() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    @Nullable
    public final String zzs() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    @Nullable
    public final String zzt() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(false);
        this.zzf.destroy();
        this.zzf = null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(zzci zzciVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzN(boolean z10) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(zzdg zzdgVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbk zzbkVar) {
    }
}
