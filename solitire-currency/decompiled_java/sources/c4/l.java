package c4;

import a4.o;
import a4.o0;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import c4.d;
import c4.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SphericalGLSurfaceView.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends GLSurfaceView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f4567m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f4568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f4569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Sensor f4570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f4571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f4572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m f4573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f4574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private SurfaceTexture f4575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Surface f4576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f4577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4579l;

    /* JADX INFO: compiled from: SphericalGLSurfaceView.java */
    @VisibleForTesting
    final class a implements GLSurfaceView.Renderer, m.a, d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i f4580a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f4583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float[] f4584e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float[] f4585f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f4586g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f4587h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f4581b = new float[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f4582c = new float[16];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float[] f4588i = new float[16];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f4589j = new float[16];

        public a(i iVar) {
            float[] fArr = new float[16];
            this.f4583d = fArr;
            float[] fArr2 = new float[16];
            this.f4584e = fArr2;
            float[] fArr3 = new float[16];
            this.f4585f = fArr3;
            this.f4580a = iVar;
            o.j(fArr);
            o.j(fArr2);
            o.j(fArr3);
            this.f4587h = 3.1415927f;
        }

        private float a(float f10) {
            if (f10 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f10))) * 2.0d);
            }
            return 90.0f;
        }

        @AnyThread
        private void b() {
            Matrix.setRotateM(this.f4584e, 0, -this.f4586g, (float) Math.cos(this.f4587h), (float) Math.sin(this.f4587h), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f4589j, 0, this.f4583d, 0, this.f4585f, 0);
                Matrix.multiplyMM(this.f4588i, 0, this.f4584e, 0, this.f4589j, 0);
            }
            Matrix.multiplyMM(this.f4582c, 0, this.f4581b, 0, this.f4588i, 0);
            this.f4580a.c(this.f4582c, false);
        }

        @Override // c4.d.a
        @BinderThread
        public synchronized void onOrientationChange(float[] fArr, float f10) {
            float[] fArr2 = this.f4583d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f4587h = -f10;
            b();
        }

        @Override // c4.m.a
        @UiThread
        public synchronized void onScrollChange(PointF pointF) {
            this.f4586g = pointF.y;
            b();
            Matrix.setRotateM(this.f4585f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // c4.m.a
        @UiThread
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return l.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
            GLES20.glViewport(0, 0, i10, i11);
            float f10 = i10 / i11;
            Matrix.perspectiveM(this.f4581b, 0, a(f10), f10, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            l.this.g(this.f4580a.d());
        }
    }

    /* JADX INFO: compiled from: SphericalGLSurfaceView.java */
    public interface b {
        void onVideoSurfaceCreated(Surface surface);

        void onVideoSurfaceDestroyed(Surface surface);
    }

    public l(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        Surface surface = this.f4576i;
        if (surface != null) {
            Iterator<b> it = this.f4568a.iterator();
            while (it.hasNext()) {
                it.next().onVideoSurfaceDestroyed(surface);
            }
        }
        h(this.f4575h, surface);
        this.f4575h = null;
        this.f4576i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f4575h;
        Surface surface = this.f4576i;
        Surface surface2 = new Surface(surfaceTexture);
        this.f4575h = surfaceTexture;
        this.f4576i = surface2;
        Iterator<b> it = this.f4568a.iterator();
        while (it.hasNext()) {
            it.next().onVideoSurfaceCreated(surface2);
        }
        h(surfaceTexture2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final SurfaceTexture surfaceTexture) {
        this.f4572e.post(new Runnable() { // from class: c4.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f4564a.f(surfaceTexture);
            }
        });
    }

    private static void h(@Nullable SurfaceTexture surfaceTexture, @Nullable Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void j() {
        boolean z10 = this.f4577j && this.f4578k;
        Sensor sensor = this.f4570c;
        if (sensor == null || z10 == this.f4579l) {
            return;
        }
        if (z10) {
            this.f4569b.registerListener(this.f4571d, sensor, 0);
        } else {
            this.f4569b.unregisterListener(this.f4571d);
        }
        this.f4579l = z10;
    }

    public void d(b bVar) {
        this.f4568a.add(bVar);
    }

    public c4.a getCameraMotionListener() {
        return this.f4574g;
    }

    public b4.l getVideoFrameMetadataListener() {
        return this.f4574g;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f4576i;
    }

    public void i(b bVar) {
        this.f4568a.remove(bVar);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4572e.post(new Runnable() { // from class: c4.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f4566a.e();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f4578k = false;
        j();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f4578k = true;
        j();
    }

    public void setDefaultStereoMode(int i10) {
        this.f4574g.f(i10);
    }

    public void setUseSensorRotation(boolean z10) {
        this.f4577j = z10;
        j();
    }

    public l(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4568a = new CopyOnWriteArrayList<>();
        this.f4572e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) a4.a.e(context.getSystemService("sensor"));
        this.f4569b = sensorManager;
        Sensor defaultSensor = o0.f214a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f4570c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        i iVar = new i();
        this.f4574g = iVar;
        a aVar = new a(iVar);
        m mVar = new m(context, aVar, 25.0f);
        this.f4573f = mVar;
        this.f4571d = new d(((WindowManager) a4.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), mVar, aVar);
        this.f4577j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(mVar);
    }
}
