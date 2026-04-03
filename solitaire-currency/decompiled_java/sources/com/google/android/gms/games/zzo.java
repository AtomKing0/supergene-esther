package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzo extends DataBufferRef {
    public zzo(DataHolder dataHolder, int i10) {
        super(dataHolder, i10);
    }

    protected final int zzp(String str, int i10) {
        return (!hasColumn(str) || hasNull(str)) ? i10 : getInteger(str);
    }

    protected final String zzq(String str, String str2) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getString(str);
    }
}
