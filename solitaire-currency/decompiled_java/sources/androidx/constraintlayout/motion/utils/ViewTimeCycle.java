package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setAlpha(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            this.mCurveFit.getPos(f10, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f13 = (float) ((((double) this.last_cycle) + ((j11 * 1.0E-9d) * ((double) f11))) % 1.0d);
            this.last_cycle = f13;
            this.last_time = j10;
            float fCalcWave = calcWave(f13);
            this.mContinue = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.mContinue;
                float f14 = this.mTempValues[i10];
                this.mContinue = z10 | (((double) f14) != 0.0d);
                fArr2[i10] = (f14 * fCalcWave) + f12;
                i10++;
            }
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mCache);
            if (f11 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i10) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i11 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i11];
            this.mCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i11);
            for (int i12 = 0; i12 < size; i12++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i12);
                ConstraintAttribute constraintAttributeValueAt = this.mConstraintAttributeList.valueAt(i12);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i12);
                dArr[i12] = ((double) iKeyAt) * 0.01d;
                constraintAttributeValueAt.getValuesToInterpolate(this.mTempValues);
                int i13 = 0;
                while (true) {
                    if (i13 < this.mTempValues.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                double[] dArr3 = dArr2[i12];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }

        public void setPoint(int i10, ConstraintAttribute constraintAttribute, float f10, int i11, float f11) {
            this.mConstraintAttributeList.append(i10, constraintAttribute);
            this.mWaveProperties.append(i10, new float[]{f10, f11});
            this.mWaveShape = Math.max(this.mWaveShape, i11);
        }
    }

    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setElevation(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f10, long j10, double d10, double d11) {
            view.setRotation(get(f10, j10, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f10, j10, view, keyCache));
            } else {
                if (this.mNoMethod) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(get(f10, j10, view, keyCache)));
                    } catch (IllegalAccessException e10) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e11);
                    }
                }
            }
            return this.mContinue;
        }
    }

    static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotation(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotationX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotationY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setScaleX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setScaleY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationZ(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j10) {
        ViewTimeCycle rotationXset;
        str.hashCode();
        switch (str) {
            case "rotationX":
                rotationXset = new RotationXset();
                break;
            case "rotationY":
                rotationXset = new RotationYset();
                break;
            case "translationX":
                rotationXset = new TranslationXset();
                break;
            case "translationY":
                rotationXset = new TranslationYset();
                break;
            case "translationZ":
                rotationXset = new TranslationZset();
                break;
            case "progress":
                rotationXset = new ProgressSet();
                break;
            case "scaleX":
                rotationXset = new ScaleXset();
                break;
            case "scaleY":
                rotationXset = new ScaleYset();
                break;
            case "rotation":
                rotationXset = new RotationSet();
                break;
            case "elevation":
                rotationXset = new ElevationSet();
                break;
            case "transitionPathRotate":
                rotationXset = new PathRotate();
                break;
            case "alpha":
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j10);
        return rotationXset;
    }

    public float get(float f10, long j10, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f10, this.mCache);
        float[] fArr = this.mCache;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f12 = (float) ((((double) this.last_cycle) + (((j10 - this.last_time) * 1.0E-9d) * ((double) f11))) % 1.0d);
        this.last_cycle = f12;
        keyCache.setFloatValue(view, this.mType, 0, f12);
        this.last_time = j10;
        float f13 = this.mCache[0];
        float fCalcWave = (calcWave(this.last_cycle) * f13) + this.mCache[2];
        this.mContinue = (f13 == 0.0f && f11 == 0.0f) ? false : true;
        return fCalcWave;
    }

    public abstract boolean setProperty(View view, float f10, long j10, KeyCache keyCache);
}
