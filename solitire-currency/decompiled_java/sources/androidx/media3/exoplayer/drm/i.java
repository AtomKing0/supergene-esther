package androidx.media3.exoplayer.drm;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DrmSession.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i {
    public static boolean a(DrmSession drmSession) {
        return false;
    }

    public static void b(@Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }
}
