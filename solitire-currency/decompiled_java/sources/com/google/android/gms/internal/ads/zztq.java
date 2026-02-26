package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zztq extends zzth {
    private final HashMap zza = new HashMap();

    @Nullable
    private Handler zzb;

    @Nullable
    private zzgu zzc;

    protected zztq() {
    }

    protected abstract void zzA(Object obj, zzuk zzukVar, zzcc zzccVar);

    protected final void zzB(final Object obj, zzuk zzukVar) {
        zzdi.zzd(!this.zza.containsKey(obj));
        zzuj zzujVar = new zzuj() { // from class: com.google.android.gms.internal.ads.zztn
            @Override // com.google.android.gms.internal.ads.zzuj
            public final void zza(zzuk zzukVar2, zzcc zzccVar) {
                this.zza.zzA(obj, zzukVar2, zzccVar);
            }
        };
        zzto zztoVar = new zzto(this, obj);
        this.zza.put(obj, new zztp(zzukVar, zzujVar, zztoVar));
        Handler handler = this.zzb;
        handler.getClass();
        zzukVar.zzh(handler, zztoVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzukVar.zzg(handler2, zztoVar);
        zzukVar.zzm(zzujVar, this.zzc, zzb());
        if (zzu()) {
            return;
        }
        zzukVar.zzi(zzujVar);
    }

    @Override // com.google.android.gms.internal.ads.zzth
    @CallSuper
    protected final void zzj() {
        for (zztp zztpVar : this.zza.values()) {
            zztpVar.zza.zzi(zztpVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzth
    @CallSuper
    protected final void zzl() {
        for (zztp zztpVar : this.zza.values()) {
            zztpVar.zza.zzk(zztpVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzth
    @CallSuper
    protected void zzn(@Nullable zzgu zzguVar) {
        this.zzc = zzguVar;
        this.zzb = zzet.zzx(null);
    }

    @Override // com.google.android.gms.internal.ads.zzth
    @CallSuper
    protected void zzq() {
        for (zztp zztpVar : this.zza.values()) {
            zztpVar.zza.zzp(zztpVar.zzb);
            zztpVar.zza.zzs(zztpVar.zzc);
            zztpVar.zza.zzr(zztpVar.zzc);
        }
        this.zza.clear();
    }

    protected int zzw(Object obj, int i10) {
        return 0;
    }

    @Nullable
    protected zzui zzy(Object obj, zzui zzuiVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    @CallSuper
    public void zzz() throws IOException {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zztp) it.next()).zza.zzz();
        }
    }

    protected long zzx(Object obj, long j10, @Nullable zzui zzuiVar) {
        return j10;
    }
}
