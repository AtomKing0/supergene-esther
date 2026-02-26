package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaza {
    private final int zza;
    private final zzayx zzb = new zzazc();

    public zzaza(int i10) {
        this.zza = i10;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb.append(((String) arrayList.get(i10)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] strArrSplit = sb.toString().split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zzayz zzayzVar = new zzayz();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzayy(this));
        for (String str : strArrSplit) {
            String[] strArrZzb = zzazb.zzb(str, false);
            if (strArrZzb.length != 0) {
                zzazf.zzc(strArrZzb, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzayzVar.zzb.write(this.zzb.zzb(((zzaze) it.next()).zzb));
            } catch (IOException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Error while writing hash to byteStream", e10);
            }
        }
        return zzayzVar.toString();
    }
}
