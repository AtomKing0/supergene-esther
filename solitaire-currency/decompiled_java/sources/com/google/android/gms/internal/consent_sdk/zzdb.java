package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdb extends zzcy {
    private final zzdd zza;

    zzdb(zzdd zzddVar, int i10) {
        super(zzddVar.size(), i10);
        this.zza = zzddVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzcy
    protected final Object zza(int i10) {
        return this.zza.get(i10);
    }
}
