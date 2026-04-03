package b4;

import a4.o;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: VideoDecoderGLSurfaceView.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends GLSurfaceView implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2148b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f2149a;

    /* JADX INFO: compiled from: VideoDecoderGLSurfaceView.java */
    private static final class a implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final float[] f2150k = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final float[] f2151l = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final float[] f2152m = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String[] f2153n = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final FloatBuffer f2154o = a4.o.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GLSurfaceView f2155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f2156b = new int[3];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f2157c = new int[3];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f2158d = new int[3];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f2159e = new int[3];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicReference<n2.k> f2160f = new AtomicReference<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final FloatBuffer[] f2161g = new FloatBuffer[3];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private a4.n f2162h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2163i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private n2.k f2164j;

        public a(GLSurfaceView gLSurfaceView) {
            this.f2155a = gLSurfaceView;
            for (int i10 = 0; i10 < 3; i10++) {
                int[] iArr = this.f2158d;
                this.f2159e[i10] = -1;
                iArr[i10] = -1;
            }
        }

        private void b() {
            try {
                GLES20.glGenTextures(3, this.f2156b, 0);
                for (int i10 = 0; i10 < 3; i10++) {
                    GLES20.glUniform1i(this.f2162h.j(f2153n[i10]), i10);
                    GLES20.glActiveTexture(33984 + i10);
                    a4.o.a(3553, this.f2156b[i10]);
                }
                a4.o.b();
            } catch (o.a e10) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e10);
            }
        }

        public void a(n2.k kVar) {
            n2.k andSet = this.f2160f.getAndSet(kVar);
            if (andSet != null) {
                andSet.l();
            }
            this.f2155a.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            n2.k andSet = this.f2160f.getAndSet(null);
            if (andSet == null && this.f2164j == null) {
                return;
            }
            if (andSet != null) {
                n2.k kVar = this.f2164j;
                if (kVar != null) {
                    kVar.l();
                }
                this.f2164j = andSet;
            }
            n2.k kVar2 = (n2.k) a4.a.e(this.f2164j);
            float[] fArr = f2151l;
            int i10 = kVar2.f31619h;
            if (i10 == 1) {
                fArr = f2150k;
            } else if (i10 == 3) {
                fArr = f2152m;
            }
            GLES20.glUniformMatrix3fv(this.f2163i, 1, false, fArr, 0);
            int[] iArr = (int[]) a4.a.e(kVar2.f31618g);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) a4.a.e(kVar2.f31617f);
            int i11 = 0;
            while (i11 < 3) {
                int i12 = i11 == 0 ? kVar2.f31616e : (kVar2.f31616e + 1) / 2;
                GLES20.glActiveTexture(33984 + i11);
                GLES20.glBindTexture(3553, this.f2156b[i11]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i11], i12, 0, 6409, 5121, byteBufferArr[i11]);
                i11++;
            }
            int i13 = kVar2.f31615d;
            int i14 = (i13 + 1) / 2;
            int[] iArr2 = {i13, i14, i14};
            for (int i15 = 0; i15 < 3; i15++) {
                if (this.f2158d[i15] != iArr2[i15] || this.f2159e[i15] != iArr[i15]) {
                    a4.a.g(iArr[i15] != 0);
                    float f10 = iArr2[i15] / iArr[i15];
                    this.f2161g[i15] = a4.o.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f10, 0.0f, f10, 1.0f});
                    GLES20.glVertexAttribPointer(this.f2157c[i15], 2, 5126, false, 0, (Buffer) this.f2161g[i15]);
                    this.f2158d[i15] = iArr2[i15];
                    this.f2159e[i15] = iArr[i15];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            try {
                a4.o.b();
            } catch (o.a e10) {
                Log.e("VideoDecoderGLSV", "Failed to draw a frame", e10);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
            GLES20.glViewport(0, 0, i10, i11);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                a4.n nVar = new a4.n("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.f2162h = nVar;
                GLES20.glVertexAttribPointer(nVar.e("in_pos"), 2, 5126, false, 0, (Buffer) f2154o);
                this.f2157c[0] = this.f2162h.e("in_tc_y");
                this.f2157c[1] = this.f2162h.e("in_tc_u");
                this.f2157c[2] = this.f2162h.e("in_tc_v");
                this.f2163i = this.f2162h.j("mColorConversion");
                a4.o.b();
                b();
                a4.o.b();
            } catch (o.a e10) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e10);
            }
        }
    }

    public j(Context context) {
        this(context, null);
    }

    public void setOutputBuffer(n2.k kVar) {
        this.f2149a.a(kVar);
    }

    public j(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f2149a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public k getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
