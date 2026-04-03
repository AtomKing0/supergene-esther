package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfvh {
    private final zzfvg zza;

    private zzfvh(zzfvg zzfvgVar) {
        this.zza = zzfvgVar;
    }

    public static zzfvh zza(int i10) {
        return new zzfvh(new zzfvd(4000));
    }

    public static zzfvh zzb(zzfui zzfuiVar) {
        return new zzfvh(new zzfvb(zzfuiVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzf(CharSequence charSequence) {
        return this.zza.zza(this, charSequence);
    }

    public final Iterable zzc(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfve(this, charSequence);
    }

    public final List zze(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itZzf = zzf(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZzf.hasNext()) {
            arrayList.add((String) itZzf.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
