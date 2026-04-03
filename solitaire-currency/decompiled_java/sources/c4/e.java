package c4;

/* JADX INFO: compiled from: Projection.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f4524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4526d;

    /* JADX INFO: compiled from: Projection.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b[] f4527a;

        public a(b... bVarArr) {
            this.f4527a = bVarArr;
        }

        public b a(int i10) {
            return this.f4527a[i10];
        }

        public int b() {
            return this.f4527a.length;
        }
    }

    /* JADX INFO: compiled from: Projection.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f4530c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f4531d;

        public b(int i10, float[] fArr, float[] fArr2, int i11) {
            this.f4528a = i10;
            a4.a.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f4530c = fArr;
            this.f4531d = fArr2;
            this.f4529b = i11;
        }

        public int a() {
            return this.f4530c.length / 3;
        }
    }

    public e(a aVar, int i10) {
        this(aVar, aVar, i10);
    }

    public static e a(float f10, int i10, int i11, float f11, float f12, int i12) {
        int i13;
        float f13;
        int i14;
        int i15;
        int i16;
        float[] fArr;
        int i17;
        int i18 = i10;
        int i19 = i11;
        a4.a.a(f10 > 0.0f);
        a4.a.a(i18 >= 1);
        a4.a.a(i19 >= 1);
        a4.a.a(f11 > 0.0f && f11 <= 180.0f);
        a4.a.a(f12 > 0.0f && f12 <= 360.0f);
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
        return new e(new a(new b(0, fArr2, fArr3, 1)), i12);
    }

    public static e b(int i10) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i10);
    }

    public e(a aVar, a aVar2, int i10) {
        this.f4523a = aVar;
        this.f4524b = aVar2;
        this.f4525c = i10;
        this.f4526d = aVar == aVar2;
    }
}
