package o2;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.PlaybackException;
import o2.h;

/* JADX INFO: compiled from: DrmUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: compiled from: DrmUtil.java */
    @RequiresApi(18)
    private static final class a {
        @DoNotInline
        public static boolean a(@Nullable Throwable th) {
            return th instanceof DeniedByServerException;
        }

        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return th instanceof NotProvisionedException;
        }
    }

    /* JADX INFO: compiled from: DrmUtil.java */
    @RequiresApi(21)
    private static final class b {
        @DoNotInline
        public static boolean a(@Nullable Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        @DoNotInline
        public static int b(Throwable th) {
            return a4.o0.P(a4.o0.Q(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    /* JADX INFO: compiled from: DrmUtil.java */
    @RequiresApi(23)
    private static final class c {
        @DoNotInline
        public static boolean a(@Nullable Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    public static int a(Exception exc, int i10) {
        int i11 = a4.o0.f214a;
        if (i11 >= 21 && b.a(exc)) {
            return b.b(exc);
        }
        if (i11 >= 23 && c.a(exc)) {
            return PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR;
        }
        if (i11 >= 18 && a.b(exc)) {
            return 6002;
        }
        if (i11 >= 18 && a.a(exc)) {
            return PlaybackException.ERROR_CODE_DRM_DEVICE_REVOKED;
        }
        if (exc instanceof p0) {
            return 6001;
        }
        if (exc instanceof h.e) {
            return 6003;
        }
        if (exc instanceof m0) {
            return PlaybackException.ERROR_CODE_DRM_LICENSE_EXPIRED;
        }
        if (i10 == 1) {
            return PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR;
        }
        if (i10 == 2) {
            return PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED;
        }
        if (i10 == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }
}
