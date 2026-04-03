package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public SubMesh getSubMesh(int i10) {
            return this.subMeshes[i10];
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i10, float[] fArr, float[] fArr2, int i11) {
            this.textureId = i10;
            Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i11;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public Projection(Mesh mesh, int i10) {
        this(mesh, mesh, i10);
    }

    public static Projection createEquirectangular(int i10) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i10);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i10) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i10;
        this.singleMesh = mesh == mesh2;
    }

    public static Projection createEquirectangular(float f10, int i10, int i11, float f11, float f12, int i12) {
        int i13;
        float f13;
        int i14;
        int i15;
        int i16;
        float[] fArr;
        int i17;
        int i18 = i10;
        int i19 = i11;
        Assertions.checkArgument(f10 > 0.0f);
        Assertions.checkArgument(i18 >= 1);
        Assertions.checkArgument(i19 >= 1);
        Assertions.checkArgument(f11 > 0.0f && f11 <= 180.0f);
        Assertions.checkArgument(f12 > 0.0f && f12 <= 360.0f);
        float radians = (float) Math.toRadians(f11);
        float radians2 = (float) Math.toRadians(f12);
        float f14 = radians / i18;
        float f15 = radians2 / i19;
        int i20 = i19 + 1;
        int i21 = ((i20 * 2) + 2) * i18;
        float[] fArr2 = new float[i21 * 3];
        float[] fArr3 = new float[i21 * 2];
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i22 < i18) {
            float f16 = radians / 2.0f;
            float f17 = (i22 * f14) - f16;
            int i25 = i22 + 1;
            float f18 = (i25 * f14) - f16;
            int i26 = 0;
            while (i26 < i20) {
                float f19 = f17;
                int i27 = i25;
                int i28 = 0;
                int i29 = 2;
                while (i28 < i29) {
                    if (i28 == 0) {
                        f13 = f19;
                        i13 = i20;
                    } else {
                        i13 = i20;
                        f13 = f18;
                    }
                    float f20 = i26 * f15;
                    float f21 = f15;
                    int i30 = i23 + 1;
                    int i31 = i26;
                    double d10 = f10;
                    float f22 = f14;
                    double d11 = (f20 + 3.1415927f) - (radians2 / 2.0f);
                    int i32 = i28;
                    double d12 = f13;
                    float[] fArr4 = fArr3;
                    float f23 = f18;
                    fArr2[i23] = -((float) (Math.sin(d11) * d10 * Math.cos(d12)));
                    int i33 = i30 + 1;
                    int i34 = i22;
                    fArr2[i30] = (float) (d10 * Math.sin(d12));
                    int i35 = i33 + 1;
                    fArr2[i33] = (float) (d10 * Math.cos(d11) * Math.cos(d12));
                    int i36 = i24 + 1;
                    fArr4[i24] = f20 / radians2;
                    int i37 = i36 + 1;
                    fArr4[i36] = ((i34 + i32) * f22) / radians;
                    if (i31 == 0 && i32 == 0) {
                        i14 = i11;
                        i15 = i31;
                        i16 = i32;
                    } else {
                        i14 = i11;
                        i15 = i31;
                        i16 = i32;
                        if (i15 != i14 || i16 != 1) {
                            fArr = fArr4;
                            i17 = 2;
                        }
                        i24 = i37;
                        i23 = i35;
                        i28 = i16 + 1;
                        i19 = i14;
                        i26 = i15;
                        fArr3 = fArr;
                        i29 = i17;
                        i22 = i34;
                        i20 = i13;
                        f15 = f21;
                        f14 = f22;
                        f18 = f23;
                    }
                    System.arraycopy(fArr2, i35 - 3, fArr2, i35, 3);
                    i35 += 3;
                    fArr = fArr4;
                    i17 = 2;
                    System.arraycopy(fArr, i37 - 2, fArr, i37, 2);
                    i37 += 2;
                    i24 = i37;
                    i23 = i35;
                    i28 = i16 + 1;
                    i19 = i14;
                    i26 = i15;
                    fArr3 = fArr;
                    i29 = i17;
                    i22 = i34;
                    i20 = i13;
                    f15 = f21;
                    f14 = f22;
                    f18 = f23;
                }
                float f24 = f14;
                int i38 = i26;
                int i39 = i19;
                int i40 = i38 + 1;
                f17 = f19;
                i25 = i27;
                i20 = i20;
                f14 = f24;
                f18 = f18;
                i19 = i39;
                i26 = i40;
            }
            i18 = i10;
            i22 = i25;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr2, fArr3, 1)), i12);
    }
}
