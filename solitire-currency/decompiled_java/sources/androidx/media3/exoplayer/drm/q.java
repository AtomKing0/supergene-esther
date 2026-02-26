package androidx.media3.exoplayer.drm;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;

/* JADX INFO: compiled from: DrmSessionManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q {
    static {
        DrmSessionManager drmSessionManager = DrmSessionManager.DRM_UNSUPPORTED;
    }

    public static DrmSessionManager.DrmSessionReference a(DrmSessionManager drmSessionManager, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionManager.DrmSessionReference.EMPTY;
    }

    @Deprecated
    public static DrmSessionManager d() {
        return DrmSessionManager.DRM_UNSUPPORTED;
    }

    public static void b(DrmSessionManager drmSessionManager) {
    }

    public static void c(DrmSessionManager drmSessionManager) {
    }
}
