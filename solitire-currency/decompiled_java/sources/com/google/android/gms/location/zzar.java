package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzar {
    public static int zza(int i10) {
        boolean z10;
        if (i10 == 0 || i10 == 1) {
            z10 = true;
        } else if (i10 == 2) {
            i10 = 2;
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i10));
        return i10;
    }

    public static String zzb(int i10) {
        if (i10 == 0) {
            return "THROTTLE_BACKGROUND";
        }
        if (i10 == 1) {
            return "THROTTLE_ALWAYS";
        }
        if (i10 == 2) {
            return "THROTTLE_NEVER";
        }
        throw new IllegalArgumentException();
    }
}
