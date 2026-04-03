package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzni {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzip.values().length];
        zza = iArr;
        try {
            iArr[zzip.DEFAULT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzip.GRANTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzip.DENIED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zza[zzip.UNINITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
