package com.unity3d.ads.core.domain;

import android.opengl.GLES20;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gl.EglCore;
import com.unity3d.ads.gl.OffscreenSurface;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetAndroidOpenGLRendererInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidOpenGLRendererInfo implements GetOpenGLRendererInfo {

    @NotNull
    private final SessionRepository sessionRepository;

    public GetAndroidOpenGLRendererInfo(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetOpenGLRendererInfo
    @NotNull
    public ByteString invoke() {
        if (!this.sessionRepository.getFeatureFlags().getOpenglGpuEnabled()) {
            ByteString byteStringEmpty = ByteString.empty();
            t.h(byteStringEmpty, "{\n            ByteString.empty()\n        }");
            return byteStringEmpty;
        }
        EglCore eglCore = new EglCore(null, 2);
        OffscreenSurface offscreenSurface = new OffscreenSurface(eglCore, 1, 1);
        offscreenSurface.makeCurrent();
        String renderer = GLES20.glGetString(7937);
        t.h(renderer, "renderer");
        byte[] bytes = renderer.getBytes(p9.d.f32957g);
        t.h(bytes, "this as java.lang.String).getBytes(charset)");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bytes);
        offscreenSurface.release();
        eglCore.release();
        t.h(byteStringCopyFrom, "{\n            // We need…dererByteString\n        }");
        return byteStringCopyFrom;
    }
}
