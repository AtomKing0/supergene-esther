package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzgl extends zzft {
    public final int zzb;

    public zzgl(zzfy zzfyVar, int i10, int i11) {
        super(zzb(2008, 1));
        this.zzb = 1;
    }

    public static zzgl zza(IOException iOException, zzfy zzfyVar, int i10) {
        String message = iOException.getMessage();
        int i11 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !zzfuf.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i11 == 2007 ? new zzgk(iOException, zzfyVar) : new zzgl(iOException, zzfyVar, i11, i10);
    }

    private static int zzb(int i10, int i11) {
        return i10 == 2000 ? i11 != 1 ? 2000 : 2001 : i10;
    }

    public zzgl(IOException iOException, zzfy zzfyVar, int i10, int i11) {
        super(iOException, zzb(i10, i11));
        this.zzb = i11;
    }

    public zzgl(String str, zzfy zzfyVar, int i10, int i11) {
        super(str, zzb(i10, i11));
        this.zzb = i11;
    }

    public zzgl(String str, @Nullable IOException iOException, zzfy zzfyVar, int i10, int i11) {
        super(str, iOException, zzb(i10, i11));
        this.zzb = i11;
    }
}
