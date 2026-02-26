package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaco {
    public static int zza(zzacl zzaclVar, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int iZzb = zzaclVar.zzb(bArr, i10 + i12, i11 - i12);
            if (iZzb == -1) {
                break;
            }
            i12 += iZzb;
        }
        return i12;
    }

    public static void zzb(boolean z10, @Nullable String str) throws zzbo {
        if (!z10) {
            throw zzbo.zza(str, null);
        }
    }

    public static boolean zzc(zzacl zzaclVar, byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        try {
            return zzaclVar.zzm(bArr, 0, i11, z10);
        } catch (EOFException e10) {
            if (z10) {
                return false;
            }
            throw e10;
        }
    }

    public static boolean zzd(zzacl zzaclVar, byte[] bArr, int i10, int i11) throws IOException {
        try {
            ((zzaby) zzaclVar).zzn(bArr, i10, i11, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzacl zzaclVar, int i10) throws IOException {
        try {
            ((zzaby) zzaclVar).zzo(i10, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
