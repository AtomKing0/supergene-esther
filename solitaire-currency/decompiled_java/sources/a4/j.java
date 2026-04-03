package a4;

import a4.o;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: EGLSurfaceTexture.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(17)
public final class j implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f176g = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private EGLDisplay f179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private EGLContext f180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private EGLSurface f181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private SurfaceTexture f182f;

    /* JADX INFO: compiled from: EGLSurfaceTexture.java */
    public interface a {
    }

    public j(Handler handler) {
        this(handler, null);
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) throws o.a {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f176g, 0, eGLConfigArr, 0, 1, iArr, 0);
        o.c(zEglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null, o0.z("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        return eGLConfigArr[0];
    }

    private static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10) throws o.a {
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i10 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        o.c(eGLContextEglCreateContext != null, "eglCreateContext failed");
        return eGLContextEglCreateContext;
    }

    private static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i10) throws o.a {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        if (i10 == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i10 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            o.c(eGLSurfaceEglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
        }
        o.c(EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext), "eglMakeCurrent failed");
        return eGLSurfaceEglCreatePbufferSurface;
    }

    private static void e(int[] iArr) throws o.a {
        GLES20.glGenTextures(1, iArr, 0);
        o.b();
    }

    private static EGLDisplay f() throws o.a {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        o.c(eGLDisplayEglGetDisplay != null, "eglGetDisplay failed");
        int[] iArr = new int[2];
        o.c(EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
        return eGLDisplayEglGetDisplay;
    }

    public SurfaceTexture g() {
        return (SurfaceTexture) a4.a.e(this.f182f);
    }

    public void h(int i10) throws o.a {
        EGLDisplay eGLDisplayF = f();
        this.f179c = eGLDisplayF;
        EGLConfig eGLConfigA = a(eGLDisplayF);
        EGLContext eGLContextB = b(this.f179c, eGLConfigA, i10);
        this.f180d = eGLContextB;
        this.f181e = c(this.f179c, eGLConfigA, eGLContextB, i10);
        e(this.f178b);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f178b[0]);
        this.f182f = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        this.f177a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f182f;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f178b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f179c;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f179c;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f181e;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f179c, this.f181e);
            }
            EGLContext eGLContext = this.f180d;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f179c, eGLContext);
            }
            if (o0.f214a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f179c;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f179c);
            }
            this.f179c = null;
            this.f180d = null;
            this.f181e = null;
            this.f182f = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f177a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.f182f;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public j(Handler handler, @Nullable a aVar) {
        this.f177a = handler;
        this.f178b = new int[1];
    }

    private void d() {
    }
}
