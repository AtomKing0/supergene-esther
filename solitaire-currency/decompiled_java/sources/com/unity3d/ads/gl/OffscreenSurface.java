package com.unity3d.ads.gl;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OffscreenSurface.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OffscreenSurface extends EglSurfaceBase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OffscreenSurface(@NotNull EglCore eglCore, int i10, int i11) {
        super(eglCore);
        t.i(eglCore, "eglCore");
        createOffscreenSurface(i10, i11);
    }

    public final void release() {
        releaseEglSurface();
    }
}
