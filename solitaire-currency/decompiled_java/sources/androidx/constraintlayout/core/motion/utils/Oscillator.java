package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d10, float f10) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d10;
        this.mPeriod[iBinarySearch] = f10;
        this.mNormalized = false;
    }

    double getDP(double d10) {
        if (d10 <= 0.0d) {
            d10 = 1.0E-5d;
        } else if (d10 >= 1.0d) {
            d10 = 0.999999d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (iBinarySearch > 0 || iBinarySearch == 0) {
            return 0.0d;
        }
        int i10 = (-iBinarySearch) - 1;
        float[] fArr = this.mPeriod;
        float f10 = fArr[i10];
        int i11 = i10 - 1;
        float f11 = fArr[i11];
        double d11 = f10 - f11;
        double[] dArr = this.mPosition;
        double d12 = dArr[i10];
        double d13 = dArr[i11];
        double d14 = d11 / (d12 - d13);
        return (((double) f11) - (d14 * d13)) + (d10 * d14);
    }

    double getP(double d10) {
        if (d10 < 0.0d) {
            d10 = 0.0d;
        } else if (d10 > 1.0d) {
            d10 = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return 0.0d;
        }
        int i10 = (-iBinarySearch) - 1;
        float[] fArr = this.mPeriod;
        float f10 = fArr[i10];
        int i11 = i10 - 1;
        float f11 = fArr[i11];
        double d11 = f10 - f11;
        double[] dArr = this.mPosition;
        double d12 = dArr[i10];
        double d13 = dArr[i11];
        double d14 = d11 / (d12 - d13);
        return this.mArea[i11] + ((((double) f11) - (d14 * d13)) * (d10 - d13)) + ((d14 * ((d10 * d10) - (d13 * d13))) / 2.0d);
    }

    public double getSlope(double d10, double d11, double d12) {
        double p10 = d11 + getP(d10);
        double dp = getDP(d10) + d12;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                return dp * 4.0d * Math.signum((((p10 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d13 = this.PI2;
                return (-d13) * dp * Math.sin(d13 * p10);
            case 6:
                return dp * 4.0d * ((((p10 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.mCustomCurve.getSlope(p10 % 1.0d, 0);
            default:
                double d14 = this.PI2;
                return dp * d14 * Math.cos(d14 * p10);
        }
    }

    public double getValue(double d10, double d11) {
        double dAbs;
        double p10 = getP(d10) + d11;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p10 % 1.0d));
            case 2:
                dAbs = Math.abs((((p10 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p10 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((p10 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * (d11 + p10));
            case 6:
                double dAbs2 = 1.0d - Math.abs(((p10 * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p10 % 1.0d, 0);
            default:
                return Math.sin(this.PI2 * p10);
        }
        return 1.0d - dAbs;
    }

    public void normalize() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i10 >= fArr.length) {
                break;
            }
            d10 += (double) fArr[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i11 >= fArr2.length) {
                break;
            }
            int i12 = i11 - 1;
            float f10 = (fArr2[i12] + fArr2[i11]) / 2.0f;
            double[] dArr = this.mPosition;
            d11 += (dArr[i11] - dArr[i12]) * ((double) f10);
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i13 >= fArr3.length) {
                break;
            }
            fArr3[i13] = (float) (((double) fArr3[i13]) * (d10 / d11));
            i13++;
        }
        this.mArea[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i14 >= fArr4.length) {
                this.mNormalized = true;
                return;
            }
            int i15 = i14 - 1;
            float f11 = (fArr4[i15] + fArr4[i14]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d12 = dArr2[i14] - dArr2[i15];
            double[] dArr3 = this.mArea;
            dArr3[i14] = dArr3[i15] + (d12 * ((double) f11));
            i14++;
        }
    }

    public void setType(int i10, String str) {
        this.mType = i10;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
