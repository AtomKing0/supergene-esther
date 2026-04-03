package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.unity3d.player.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C3269w {
    private static CameraManager B;
    private static String[] C;
    private static Semaphore D = new Semaphore(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y6.b f24196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CameraDevice f24197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerThread f24198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f24199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Rect f24200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Rect f24201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24203h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f24207l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Range f24209n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Image f24211p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CaptureRequest.Builder f24212q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f24215t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SurfaceTexture f24216u;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f24204i = -1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f24205j = -1.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f24208m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageReader f24210o = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CameraCaptureSession f24213r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Object f24214s = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Surface f24217v = null;
    private int A = 3;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CameraCaptureSession.CaptureCallback f24218w = new C3259r(this);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final CameraDevice.StateCallback f24219x = new C3263t(this);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final ImageReader.OnImageAvailableListener f24220y = new C3265u(this);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final SurfaceTexture.OnFrameAvailableListener f24221z = new C3267v(this);

    protected C3269w(y6.b bVar) {
        this.f24196a = null;
        this.f24196a = bVar;
        e();
    }

    public static int a(Context context) {
        return b(context).length;
    }

    private void b() {
        try {
            Semaphore semaphore = D;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!semaphore.tryAcquire(4L, timeUnit)) {
                AbstractC3275z.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f24197b.close();
            try {
                if (!D.tryAcquire(4L, timeUnit)) {
                    AbstractC3275z.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e10) {
                AbstractC3275z.Log(6, "Camera2: Interrupted while waiting to close camera " + e10);
            }
            this.f24197b = null;
            D.release();
        } catch (InterruptedException e11) {
            AbstractC3275z.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e11);
        }
    }

    public static int c(Context context, int i10) {
        try {
            return ((Integer) c(context).getCameraCharacteristics(b(context)[i10]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e10) {
            AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
            return 0;
        }
    }

    private void e() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f24198c = handlerThread;
        handlerThread.start();
        this.f24199d = new Handler(this.f24198c.getLooper());
    }

    private void f() {
        try {
            CameraCaptureSession cameraCaptureSession = this.f24213r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                this.f24212q.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.f24212q.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.f24212q.setTag("Cancel focus");
                this.f24213r.capture(this.f24212q.build(), this.f24218w, this.f24199d);
            }
        } catch (CameraAccessException e10) {
            AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bc A[Catch: CameraAccessException -> 0x00e1, TryCatch #0 {CameraAccessException -> 0x00e1, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0011, B:13:0x001d, B:14:0x00bc, B:16:0x00d3), top: B:22:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g() {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C3269w.g():void");
    }

    public final void d() {
        synchronized (this.f24214s) {
            CameraCaptureSession cameraCaptureSession = this.f24213r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                    this.A = 2;
                } catch (CameraAccessException e10) {
                    AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
                }
            }
        }
    }

    public void h() {
        Surface surface;
        if (this.f24215t != 0) {
            if (this.f24217v == null) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.f24215t);
                this.f24216u = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.f24200e.width(), this.f24200e.height());
                this.f24216u.setOnFrameAvailableListener(this.f24221z, this.f24199d);
                surface = new Surface(this.f24216u);
                this.f24217v = surface;
            }
        } else if (this.f24217v == null && this.f24210o == null) {
            ImageReader imageReaderNewInstance = ImageReader.newInstance(this.f24200e.width(), this.f24200e.height(), 35, 2);
            this.f24210o = imageReaderNewInstance;
            imageReaderNewInstance.setOnImageAvailableListener(this.f24220y, this.f24199d);
            this.f24211p = null;
            surface = this.f24210o.getSurface();
            this.f24217v = surface;
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.f24213r;
            if (cameraCaptureSession == null) {
                this.f24197b.createCaptureSession(Arrays.asList(this.f24217v), new C3261s(this), this.f24199d);
            } else if (this.A == 2) {
                cameraCaptureSession.setRepeatingRequest(this.f24212q.build(), this.f24218w, this.f24199d);
            }
            this.A = 1;
        } catch (CameraAccessException e10) {
            AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
        }
    }

    public final void i() {
        synchronized (this.f24214s) {
            CameraCaptureSession cameraCaptureSession = this.f24213r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.abortCaptures();
                } catch (CameraAccessException e10) {
                    AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
                }
                this.f24213r.close();
                this.f24213r = null;
                this.A = 3;
            }
        }
    }

    public static int a(Context context, int i10) {
        try {
            CameraCharacteristics cameraCharacteristics = c(context).getCameraCharacteristics(b(context)[i10]);
            float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (fArr.length > 0) {
                return (int) ((fArr[0] * 36.0f) / sizeF.getWidth());
            }
        } catch (CameraAccessException e10) {
            AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] b(android.content.Context r3, int r4) {
        /*
            r0 = 6
            r1 = 0
            android.hardware.camera2.CameraManager r2 = c(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            java.lang.String[] r3 = b(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            r3 = r3[r4]     // Catch: android.hardware.camera2.CameraAccessException -> L51
            android.hardware.camera2.CameraCharacteristics r3 = r2.getCameraCharacteristics(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
            java.lang.Object r3 = r3.get(r4)
            android.hardware.camera2.params.StreamConfigurationMap r3 = (android.hardware.camera2.params.StreamConfigurationMap) r3
            if (r3 != 0) goto L21
            java.lang.String r3 = "Camera2: configuration map is not available."
            com.unity3d.player.AbstractC3275z.Log(r0, r3)
        L1f:
            r3 = r1
            goto L2d
        L21:
            r4 = 35
            android.util.Size[] r3 = r3.getOutputSizes(r4)
            if (r3 == 0) goto L1f
            int r4 = r3.length
            if (r4 != 0) goto L2d
            goto L1f
        L2d:
            if (r3 == 0) goto L50
            int r4 = r3.length
            int r4 = r4 * 2
            int[] r4 = new int[r4]
            r0 = 0
        L35:
            int r1 = r3.length
            if (r0 >= r1) goto L4f
            int r1 = r0 * 2
            r2 = r3[r0]
            int r2 = r2.getWidth()
            r4[r1] = r2
            int r1 = r1 + 1
            r2 = r3[r0]
            int r2 = r2.getHeight()
            r4[r1] = r2
            int r0 = r0 + 1
            goto L35
        L4f:
            return r4
        L50:
            return r1
        L51:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r2 = "Camera2: CameraAccessException "
            r4.<init>(r2)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.unity3d.player.AbstractC3275z.Log(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C3269w.b(android.content.Context, int):int[]");
    }

    public static boolean d(Context context, int i10) {
        try {
            return ((Integer) c(context).getCameraCharacteristics(b(context)[i10]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e10) {
            AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
            return false;
        }
    }

    public static boolean e(Context context, int i10) {
        try {
            return ((Integer) c(context).getCameraCharacteristics(b(context)[i10]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e10) {
            AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
            return false;
        }
    }

    public final Rect c() {
        return this.f24200e;
    }

    private static String[] b(Context context) {
        if (C == null) {
            try {
                C = c(context).getCameraIdList();
            } catch (CameraAccessException e10) {
                AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
                C = new String[0];
            }
        }
        return C;
    }

    private static CameraManager c(Context context) {
        if (B == null) {
            B = (CameraManager) context.getSystemService("camera");
        }
        return B;
    }

    public final void a() {
        if (this.f24197b != null) {
            i();
            b();
            this.f24218w = null;
            this.f24217v = null;
            this.f24216u = null;
            Image image = this.f24211p;
            if (image != null) {
                image.close();
                this.f24211p = null;
            }
            ImageReader imageReader = this.f24210o;
            if (imageReader != null) {
                imageReader.close();
                this.f24210o = null;
            }
        }
        this.f24198c.quit();
        try {
            this.f24198c.join(4000L);
            this.f24198c = null;
            this.f24199d = null;
        } catch (InterruptedException e10) {
            this.f24198c.interrupt();
            AbstractC3275z.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CameraDevice cameraDevice) {
        synchronized (this.f24214s) {
            this.f24213r = null;
        }
        cameraDevice.close();
        this.f24197b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        if (obj != "Focus") {
            if (obj == "Cancel focus") {
                synchronized (this.f24214s) {
                    if (this.f24213r != null) {
                        g();
                    }
                }
                return;
            }
            return;
        }
        this.f24208m = false;
        synchronized (this.f24214s) {
            if (this.f24213r != null) {
                try {
                    this.f24212q.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                    this.f24212q.setTag("Regular");
                    this.f24213r.setRepeatingRequest(this.f24212q.build(), this.f24218w, this.f24199d);
                } catch (CameraAccessException e10) {
                    AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e10);
                }
            }
        }
    }

    public final boolean a(float f10, float f11) {
        if (this.f24203h <= 0) {
            return false;
        }
        if (this.f24208m) {
            AbstractC3275z.Log(5, "Camera2: Setting manual focus point already started.");
            return false;
        }
        this.f24204i = f10;
        this.f24205j = f11;
        synchronized (this.f24214s) {
            if (this.f24213r != null && this.A != 2) {
                f();
            }
        }
        return true;
    }

    public final boolean a(Context context, int i10, int i11, int i12, int i13, int i14, Surface surface) {
        int iIntValue = i13;
        try {
            CameraCharacteristics cameraCharacteristics = B.getCameraCharacteristics(b(context)[i10]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                AbstractC3275z.Log(5, "Camera2: only LEGACY hardware level is supported.");
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            Size[] sizeArr = null;
            if (streamConfigurationMap == null) {
                AbstractC3275z.Log(6, "Camera2: configuration map is not available.");
            } else {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (outputSizes != null && outputSizes.length != 0) {
                    sizeArr = outputSizes;
                }
            }
            if (sizeArr == null || sizeArr.length == 0) {
                return false;
            }
            double d10 = i11;
            double d11 = i12;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            double d12 = Double.MAX_VALUE;
            while (i15 < sizeArr.length) {
                int width = sizeArr[i15].getWidth();
                int height = sizeArr[i15].getHeight();
                CameraCharacteristics cameraCharacteristics2 = cameraCharacteristics;
                double d13 = d10;
                double dAbs = Math.abs(Math.log(d11 / ((double) height))) + Math.abs(Math.log(d10 / ((double) width)));
                if (dAbs < d12) {
                    i16 = height;
                    d12 = dAbs;
                    i17 = width;
                }
                i15++;
                cameraCharacteristics = cameraCharacteristics2;
                d10 = d13;
            }
            CameraCharacteristics cameraCharacteristics3 = cameraCharacteristics;
            this.f24200e = new Rect(0, 0, i17, i16);
            Range[] rangeArr = (Range[]) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null || rangeArr.length == 0) {
                AbstractC3275z.Log(6, "Camera2: target FPS ranges are not avialable.");
                return false;
            }
            int i18 = -1;
            int i19 = 0;
            double d14 = Double.MAX_VALUE;
            while (true) {
                if (i19 < rangeArr.length) {
                    int iIntValue2 = ((Integer) rangeArr[i19].getLower()).intValue();
                    int iIntValue3 = ((Integer) rangeArr[i19].getUpper()).intValue();
                    float f10 = iIntValue;
                    if (f10 + 0.1f > iIntValue2 && f10 - 0.1f < iIntValue3) {
                        break;
                    }
                    if (dMin < d14) {
                        i18 = i19;
                        d14 = dMin;
                    }
                    i19++;
                } else {
                    iIntValue = ((Integer) (iIntValue > ((Integer) rangeArr[i18].getUpper()).intValue() ? rangeArr[i18].getUpper() : rangeArr[i18].getLower())).intValue();
                }
            }
            this.f24209n = new Range(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            try {
                Semaphore semaphore = D;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (!semaphore.tryAcquire(4L, timeUnit)) {
                    AbstractC3275z.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                    return false;
                }
                try {
                    B.openCamera(b(context)[i10], this.f24219x, this.f24199d);
                    try {
                    } catch (InterruptedException e10) {
                        AbstractC3275z.Log(6, "Camera2: Interrupted while waiting to open camera " + e10);
                    }
                    if (!D.tryAcquire(4L, timeUnit)) {
                        AbstractC3275z.Log(5, "Camera2: Timeout waiting to open camera.");
                        return false;
                    }
                    D.release();
                    this.f24215t = i14;
                    this.f24217v = surface;
                    int iIntValue4 = ((Integer) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
                    this.f24203h = iIntValue4;
                    if (iIntValue4 > 0) {
                        this.f24201f = (Rect) cameraCharacteristics3.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        float fWidth = this.f24200e.width() / this.f24200e.height();
                        if (fWidth > r0.width() / this.f24201f.height()) {
                            this.f24206k = 0;
                            this.f24207l = (int) ((this.f24201f.height() - (this.f24201f.width() / fWidth)) / 2.0f);
                        } else {
                            this.f24207l = 0;
                            this.f24206k = (int) ((this.f24201f.width() - (this.f24201f.height() * fWidth)) / 2.0f);
                        }
                        this.f24202g = Math.min(this.f24201f.width(), this.f24201f.height()) / 20;
                    }
                    return this.f24197b != null;
                } catch (CameraAccessException e11) {
                    AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e11);
                    D.release();
                    return false;
                }
            } catch (InterruptedException e12) {
                AbstractC3275z.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e12);
                return false;
            }
        } catch (CameraAccessException e13) {
            AbstractC3275z.Log(6, "Camera2: CameraAccessException " + e13);
            return false;
        }
    }
}
