package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzffe {
    private com.google.android.gms.ads.internal.client.zzl zza;
    private com.google.android.gms.ads.internal.client.zzq zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzfk zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzbes zzh;
    private com.google.android.gms.ads.internal.client.zzw zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzcb zzl;
    private zzblh zzn;

    @Nullable
    private zzemk zzr;
    private Bundle zzt;
    private com.google.android.gms.ads.internal.client.zzcf zzu;
    private int zzm = 1;
    private final zzfer zzo = new zzfer();
    private boolean zzp = false;
    private boolean zzq = false;
    private boolean zzs = false;

    public final zzffe zzA(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final zzffe zzB(boolean z10) {
        this.zze = z10;
        return this;
    }

    public final zzffe zzC(int i10) {
        this.zzm = i10;
        return this;
    }

    public final zzffe zzD(zzbes zzbesVar) {
        this.zzh = zzbesVar;
        return this;
    }

    public final zzffe zzE(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzffe zzF(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzffe zzG(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzffe zzH(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zza = zzlVar;
        return this;
    }

    public final zzffe zzI(com.google.android.gms.ads.internal.client.zzfk zzfkVar) {
        this.zzd = zzfkVar;
        return this;
    }

    public final zzffg zzJ() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzffg(this, null);
    }

    public final String zzL() {
        return this.zzc;
    }

    public final boolean zzS() {
        return this.zzp;
    }

    public final boolean zzT() {
        return this.zzq;
    }

    public final zzffe zzV(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
        this.zzu = zzcfVar;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzl zzf() {
        return this.zza;
    }

    public final com.google.android.gms.ads.internal.client.zzq zzh() {
        return this.zzb;
    }

    public final zzfer zzp() {
        return this.zzo;
    }

    public final zzffe zzq(zzffg zzffgVar) {
        this.zzo.zza(zzffgVar.zzo.zza);
        this.zza = zzffgVar.zzd;
        this.zzb = zzffgVar.zze;
        this.zzu = zzffgVar.zzt;
        this.zzc = zzffgVar.zzf;
        this.zzd = zzffgVar.zza;
        this.zzf = zzffgVar.zzg;
        this.zzg = zzffgVar.zzh;
        this.zzh = zzffgVar.zzi;
        this.zzi = zzffgVar.zzj;
        zzr(zzffgVar.zzl);
        zzG(zzffgVar.zzm);
        this.zzp = zzffgVar.zzp;
        this.zzq = zzffgVar.zzq;
        this.zzr = zzffgVar.zzc;
        this.zzs = zzffgVar.zzr;
        this.zzt = zzffgVar.zzs;
        return this;
    }

    public final zzffe zzr(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzffe zzs(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzb = zzqVar;
        return this;
    }

    public final zzffe zzt(String str) {
        this.zzc = str;
        return this;
    }

    public final zzffe zzu(com.google.android.gms.ads.internal.client.zzw zzwVar) {
        this.zzi = zzwVar;
        return this;
    }

    public final zzffe zzv(zzemk zzemkVar) {
        this.zzr = zzemkVar;
        return this;
    }

    public final zzffe zzw(zzblh zzblhVar) {
        this.zzn = zzblhVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzfk(false, true, false);
        return this;
    }

    public final zzffe zzx(boolean z10) {
        this.zzp = z10;
        return this;
    }

    public final zzffe zzy(boolean z10) {
        this.zzq = z10;
        return this;
    }

    public final zzffe zzz(boolean z10) {
        this.zzs = true;
        return this;
    }
}
