package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzgcf;
import com.google.common.util.concurrent.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzag implements zzgcf {
    final /* synthetic */ m zza;
    final /* synthetic */ zzbyq zzb;
    final /* synthetic */ zzbyj zzc;
    final /* synthetic */ zzfju zzd;
    final /* synthetic */ zzak zze;

    zzag(zzak zzakVar, m mVar, zzbyq zzbyqVar, zzbyj zzbyjVar, zzfju zzfjuVar) {
        this.zza = mVar;
        this.zzb = zzbyqVar;
        this.zzc = zzbyjVar;
        this.zzd = zzfjuVar;
        this.zze = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgT)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzo().zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfkf zzfkfVarZzr = zzak.zzr(this.zza, this.zzb);
        if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzfkfVarZzr != null) {
            zzfju zzfjuVar = this.zzd;
            zzfjuVar.zzh(th);
            zzfjuVar.zzg(false);
            zzfkfVarZzr.zza(zzfjuVar);
            zzfkfVarZzr.zzh();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            this.zzc.zzb(message);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        zzay zzayVar = (zzay) obj;
        zzfkf zzfkfVarZzr = zzak.zzr(this.zza, this.zzb);
        this.zze.zzG.set(true);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("QueryInfo generation has been disabled.".concat(e10.toString()));
            }
            if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarZzr == null) {
                return;
            }
            zzfju zzfjuVar = this.zzd;
            zzfjuVar.zzc("QueryInfo generation has been disabled.");
            zzfjuVar.zzg(false);
            zzfkfVarZzr.zza(zzfjuVar);
            zzfkfVarZzr.zzh();
            return;
        }
        try {
            try {
                if (zzayVar == null) {
                    this.zzc.zzc(null, null, null);
                    this.zzd.zzg(true);
                    if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarZzr == null) {
                        return;
                    }
                    zzfkfVarZzr.zza(this.zzd);
                    zzfkfVarZzr.zzh();
                    return;
                }
                try {
                    if (TextUtils.isEmpty(new JSONObject(zzayVar.zzb).optString("request_id", ""))) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzj("The request ID is empty in request JSON.");
                        this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                        zzfju zzfjuVar2 = this.zzd;
                        zzfjuVar2.zzc("Request ID empty");
                        zzfjuVar2.zzg(false);
                        if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarZzr == null) {
                            return;
                        }
                        zzfkfVarZzr.zza(this.zzd);
                        zzfkfVarZzr.zzh();
                        return;
                    }
                    Bundle bundle = zzayVar.zzd;
                    zzak zzakVar = this.zze;
                    if (zzakVar.zzu && bundle != null && bundle.getInt(zzakVar.zzw, -1) == -1) {
                        zzak zzakVar2 = this.zze;
                        bundle.putInt(zzakVar2.zzw, zzakVar2.zzx.get());
                    }
                    zzak zzakVar3 = this.zze;
                    if (zzakVar3.zzt && bundle != null && TextUtils.isEmpty(bundle.getString(zzakVar3.zzv))) {
                        if (TextUtils.isEmpty(this.zze.zzz)) {
                            zzak zzakVar4 = this.zze;
                            com.google.android.gms.ads.internal.util.zzt zztVarZzp = com.google.android.gms.ads.internal.zzu.zzp();
                            zzak zzakVar5 = this.zze;
                            zzakVar4.zzz = zztVarZzp.zzc(zzakVar5.zzg, zzakVar5.zzy.afmaVersion);
                        }
                        zzak zzakVar6 = this.zze;
                        bundle.putString(zzakVar6.zzv, zzakVar6.zzz);
                    }
                    this.zzc.zzc(zzayVar.zza, zzayVar.zzb, bundle);
                    this.zzd.zzg(true);
                    if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarZzr == null) {
                        return;
                    }
                    zzfkfVarZzr.zza(this.zzd);
                    zzfkfVarZzr.zzh();
                } catch (JSONException e11) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to create JSON object from the request string.");
                    this.zzc.zzb("Internal error for request JSON: " + e11.toString());
                    zzfju zzfjuVar3 = this.zzd;
                    zzfjuVar3.zzh(e11);
                    zzfjuVar3.zzg(false);
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e11, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarZzr == null) {
                        return;
                    }
                    zzfkfVarZzr.zza(this.zzd);
                    zzfkfVarZzr.zzh();
                }
            } catch (RemoteException e12) {
                zzfju zzfjuVar4 = this.zzd;
                zzfjuVar4.zzh(e12);
                zzfjuVar4.zzg(false);
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e12);
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e12, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarZzr == null) {
                    return;
                }
                zzfkfVarZzr.zza(this.zzd);
                zzfkfVarZzr.zzh();
            }
        } catch (Throwable th) {
            if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzfkfVarZzr != null) {
                zzfkfVarZzr.zza(this.zzd);
                zzfkfVarZzr.zzh();
            }
            throw th;
        }
    }
}
