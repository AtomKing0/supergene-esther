package c4;

import a4.n;
import a4.o;
import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.Nullable;
import c4.e;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: ProjectionRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f4532j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float[] f4533k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f4534l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float[] f4535m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float[] f4536n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private a f4538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private a f4539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n f4540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4545i;

    /* JADX INFO: compiled from: ProjectionRenderer.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FloatBuffer f4547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FloatBuffer f4548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4549d;

        public a(e.b bVar) {
            this.f4546a = bVar.a();
            this.f4547b = o.e(bVar.f4530c);
            this.f4548c = o.e(bVar.f4531d);
            int i10 = bVar.f4529b;
            if (i10 == 1) {
                this.f4549d = 5;
            } else if (i10 != 2) {
                this.f4549d = 4;
            } else {
                this.f4549d = 6;
            }
        }
    }

    g() {
    }

    public static boolean c(e eVar) {
        e.a aVar = eVar.f4523a;
        e.a aVar2 = eVar.f4524b;
        return aVar.b() == 1 && aVar.a(0).f4528a == 0 && aVar2.b() == 1 && aVar2.a(0).f4528a == 0;
    }

    public void a(int i10, float[] fArr, boolean z10) {
        a aVar = z10 ? this.f4539c : this.f4538b;
        if (aVar == null) {
            return;
        }
        int i11 = this.f4537a;
        GLES20.glUniformMatrix3fv(this.f4542f, 1, false, i11 == 1 ? z10 ? f4534l : f4533k : i11 == 2 ? z10 ? f4536n : f4535m : f4532j, 0);
        GLES20.glUniformMatrix4fv(this.f4541e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i10);
        GLES20.glUniform1i(this.f4545i, 0);
        try {
            o.b();
        } catch (o.a e10) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e10);
        }
        GLES20.glVertexAttribPointer(this.f4543g, 3, 5126, false, 12, (Buffer) aVar.f4547b);
        try {
            o.b();
        } catch (o.a e11) {
            Log.e("ProjectionRenderer", "Failed to load position data", e11);
        }
        GLES20.glVertexAttribPointer(this.f4544h, 2, 5126, false, 8, (Buffer) aVar.f4548c);
        try {
            o.b();
        } catch (o.a e12) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e12);
        }
        GLES20.glDrawArrays(aVar.f4549d, 0, aVar.f4546a);
        try {
            o.b();
        } catch (o.a e13) {
            Log.e("ProjectionRenderer", "Failed to render", e13);
        }
    }

    public void b() {
        try {
            n nVar = new n("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f4540d = nVar;
            this.f4541e = nVar.j("uMvpMatrix");
            this.f4542f = this.f4540d.j("uTexMatrix");
            this.f4543g = this.f4540d.e("aPosition");
            this.f4544h = this.f4540d.e("aTexCoords");
            this.f4545i = this.f4540d.j("uTexture");
        } catch (o.a e10) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e10);
        }
    }

    public void d(e eVar) {
        if (c(eVar)) {
            this.f4537a = eVar.f4525c;
            a aVar = new a(eVar.f4523a.a(0));
            this.f4538b = aVar;
            if (!eVar.f4526d) {
                aVar = new a(eVar.f4524b.a(0));
            }
            this.f4539c = aVar;
        }
    }
}
