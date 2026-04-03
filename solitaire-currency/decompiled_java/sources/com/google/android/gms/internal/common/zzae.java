package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzae extends zzz {
    private final zzag zza;

    zzae(zzag zzagVar, int i10) {
        super(zzagVar.size(), i10);
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    protected final Object zza(int i10) {
        return this.zza.get(i10);
    }
}
