package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxg extends zzch {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    @Deprecated
    public zzxg() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    private final void zzx() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    public final zzxg zzp(int i10, boolean z10) {
        if (this.zzi.get(i10) != z10) {
            if (z10) {
                this.zzi.put(i10, true);
            } else {
                this.zzi.delete(i10);
            }
        }
        return this;
    }

    public zzxg(Context context) {
        super.zze(context);
        Point pointZzv = zzet.zzv(context);
        super.zzf(pointZzv.x, pointZzv.y, true);
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    /* synthetic */ zzxg(zzxi zzxiVar, zzxf zzxfVar) {
        super(zzxiVar);
        this.zza = zzxiVar.zzC;
        this.zzb = zzxiVar.zzE;
        this.zzc = zzxiVar.zzG;
        this.zzd = zzxiVar.zzL;
        this.zze = zzxiVar.zzM;
        this.zzf = zzxiVar.zzN;
        this.zzg = zzxiVar.zzP;
        SparseArray sparseArray = zzxiVar.zzR;
        SparseArray sparseArray2 = new SparseArray();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            sparseArray2.put(sparseArray.keyAt(i10), new HashMap((Map) sparseArray.valueAt(i10)));
        }
        this.zzh = sparseArray2;
        this.zzi = zzxiVar.zzS.clone();
    }
}
