package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfny extends zzfnu {
    public zzfny(zzfnn zzfnnVar, HashSet hashSet, JSONObject jSONObject, long j10) {
        super(zzfnnVar, hashSet, jSONObject, j10);
    }

    private final void zzc(String str) {
        zzfml zzfmlVarZza = zzfml.zza();
        if (zzfmlVarZza != null) {
            for (zzflu zzfluVar : zzfmlVarZza.zzc()) {
                if (((zzfnu) this).zza.contains(zzfluVar.zzh())) {
                    zzfluVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfnv, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfnv
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
