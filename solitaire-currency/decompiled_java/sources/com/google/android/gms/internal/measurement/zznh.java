package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zznh extends IllegalArgumentException {
    zznh(int i10, int i11) {
        super("Unpaired surrogate at index " + i10 + " of " + i11);
    }
}
