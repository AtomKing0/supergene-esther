package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
enum zzai {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzl;

    zzai(char c10) {
        this.zzl = c10;
    }

    public static zzai zza(char c10) {
        for (zzai zzaiVar : values()) {
            if (zzaiVar.zzl == c10) {
                return zzaiVar;
            }
        }
        return UNSET;
    }
}
