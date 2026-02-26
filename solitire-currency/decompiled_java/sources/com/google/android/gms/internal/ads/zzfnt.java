package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfnt implements zzfmu {
    private static final zzfnt zza = new zzfnt();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzfnp();
    private static final Runnable zze = new zzfnq();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfnm zzk = new zzfnm();
    private final zzfmw zzj = new zzfmw();
    private final zzfnn zzl = new zzfnn(new zzfnw());

    zzfnt() {
    }

    public static zzfnt zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfnt zzfntVar) {
        zzfntVar.zzg = 0;
        zzfntVar.zzi.clear();
        zzfntVar.zzh = false;
        for (zzflu zzfluVar : zzfml.zza().zzb()) {
        }
        zzfntVar.zzm = System.nanoTime();
        zzfntVar.zzk.zzi();
        long jNanoTime = System.nanoTime();
        zzfmv zzfmvVarZza = zzfntVar.zzj.zza();
        if (zzfntVar.zzk.zze().size() > 0) {
            for (String str : zzfntVar.zzk.zze()) {
                JSONObject jSONObjectZza = zzfmvVarZza.zza(null);
                View viewZza = zzfntVar.zzk.zza(str);
                zzfmv zzfmvVarZzb = zzfntVar.zzj.zzb();
                String strZzc = zzfntVar.zzk.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfmvVarZzb.zza(viewZza);
                    zzfnf.zzb(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e10) {
                        zzfng.zza("Error with setting not visible reason", e10);
                    }
                    zzfnf.zzc(jSONObjectZza, jSONObjectZza2);
                }
                zzfnf.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfntVar.zzl.zzc(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        if (zzfntVar.zzk.zzf().size() > 0) {
            JSONObject jSONObjectZza3 = zzfmvVarZza.zza(null);
            zzfntVar.zzk(null, zzfmvVarZza, jSONObjectZza3, 1, false);
            zzfnf.zzf(jSONObjectZza3);
            zzfntVar.zzl.zzd(jSONObjectZza3, zzfntVar.zzk.zzf(), jNanoTime);
        } else {
            zzfntVar.zzl.zzb();
        }
        zzfntVar.zzk.zzg();
        long jNanoTime2 = System.nanoTime() - zzfntVar.zzm;
        if (zzfntVar.zzf.size() > 0) {
            for (zzfns zzfnsVar : zzfntVar.zzf) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfnsVar.zzb();
                if (zzfnsVar instanceof zzfnr) {
                    ((zzfnr) zzfnsVar).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfmv zzfmvVar, JSONObject jSONObject, int i10, boolean z10) {
        zzfmvVar.zzb(view, jSONObject, this, i10 == 1, z10);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final void zza(View view, zzfmv zzfmvVar, JSONObject jSONObject, boolean z10) {
        int iZzk;
        boolean z11;
        if (zzfnk.zza(view) != null || (iZzk = this.zzk.zzk(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfmvVar.zza(view);
        zzfnf.zzc(jSONObject, jSONObjectZza);
        String strZzd = this.zzk.zzd(view);
        if (strZzd != null) {
            zzfnf.zzb(jSONObjectZza, strZzd);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
            } catch (JSONException e10) {
                zzfng.zza("Error with setting has window focus", e10);
            }
            this.zzk.zzh();
        } else {
            zzfnl zzfnlVarZzb = this.zzk.zzb(view);
            if (zzfnlVarZzb != null) {
                zzfmo zzfmoVarZza = zzfnlVarZzb.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzb = zzfnlVarZzb.zzb();
                int size = arrayListZzb.size();
                for (int i10 = 0; i10 < size; i10++) {
                    jSONArray.put((String) arrayListZzb.get(i10));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfmoVarZza.zzd());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfmoVarZza.zza());
                    jSONObjectZza.put("friendlyObstructionReason", zzfmoVarZza.zzc());
                } catch (JSONException e11) {
                    zzfng.zza("Error with setting friendly obstruction", e11);
                }
                z11 = true;
            } else {
                z11 = false;
            }
            zzk(view, zzfmvVar, jSONObjectZza, iZzk, z10 || z11);
        }
        this.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfno(this));
    }
}
