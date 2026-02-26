package com.google.android.gms.internal.drive;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzmj extends zzmi {
    zzmj(int i10) {
        super(i10, null);
    }

    @Override // com.google.android.gms.internal.drive.zzmi
    public final void zzbp() {
        if (!isImmutable()) {
            for (int i10 = 0; i10 < zzer(); i10++) {
                Map.Entry entryZzaw = zzaw(i10);
                if (((zzkd) entryZzaw.getKey()).zzcs()) {
                    entryZzaw.setValue(Collections.unmodifiableList((List) entryZzaw.getValue()));
                }
            }
            for (Map.Entry entry : zzes()) {
                if (((zzkd) entry.getKey()).zzcs()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbp();
    }
}
