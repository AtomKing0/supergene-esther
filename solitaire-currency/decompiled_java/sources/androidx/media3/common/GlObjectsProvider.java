package androidx.media3.common;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface GlObjectsProvider {
    GlTextureInfo createBuffersForTexture(int i10, int i11, int i12) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLContext createEglContext(EGLDisplay eGLDisplay, @IntRange(from = 2, to = 3) int i10, int[] iArr) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, int i10, boolean z10) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlUtil.GlException;
}
