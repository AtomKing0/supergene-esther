package com.google.android.gms.drive.events;

import androidx.annotation.Nullable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes3.dex */
public final class zzj {
    public static boolean zza(int i10, @Nullable DriveId driveId) {
        if (i10 != 1) {
            if (i10 == 4 || i10 == 7) {
                return driveId == null;
            }
            if (i10 != 8) {
                return false;
            }
        }
        return driveId != null;
    }
}
