package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    public static final String DRAWPATH = "drawPath";
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    private static final String TAG = "KeyPosition";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    String mTransitionEasing = null;
    int mPathMotionArc = Key.UNSET;
    int mDrawPath = 0;
    float mPercentWidth = Float.NaN;
    float mPercentHeight = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    int mPositionType = 0;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    private static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyPosition.mTargetString = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTargetString = typedArray.getString(index);
                        } else {
                            keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                        }
                        break;
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                        } else {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f10 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f10;
                        keyPosition.mPercentHeight = f10;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
            if (keyPosition.mFramePosition == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float f16 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f17 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f18 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (f10 + (f16 * f14) + ((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f15));
        this.mCalculatedPositionY = (int) (f11 + (f14 * f17) + (f15 * f18));
    }

    private void calcPathPosition(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float f16 = this.mPercentX;
        float f17 = this.mPercentY;
        this.mCalculatedPositionX = f10 + (f14 * f16) + ((-f15) * f17);
        this.mCalculatedPositionY = f11 + (f15 * f16) + (f14 * f17);
    }

    private void calcScreenPosition(int i10, int i11) {
        float f10 = this.mPercentX;
        float f11 = 0;
        this.mCalculatedPositionX = ((i10 - 0) * f10) + f11;
        this.mCalculatedPositionY = ((i11 - 0) * f10) + f11;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    void calcPosition(int i10, int i11, float f10, float f11, float f12, float f13) {
        int i12 = this.mPositionType;
        if (i12 == 1) {
            calcPathPosition(f10, f11, f12, f13);
        } else if (i12 != 2) {
            calcCartesianPosition(f10, f11, f12, f13);
        } else {
            calcScreenPosition(i10, i11);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.mTransitionEasing = keyPosition.mTransitionEasing;
        this.mPathMotionArc = keyPosition.mPathMotionArc;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mPercentWidth = keyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = keyPosition.mPercentX;
        this.mPercentY = keyPosition.mPercentY;
        this.mAltPercentX = keyPosition.mAltPercentX;
        this.mAltPercentY = keyPosition.mAltPercentY;
        this.mCalculatedPositionX = keyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = keyPosition.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i10, int i11, RectF rectF, RectF rectF2, float f10, float f11) {
        calcPosition(i10, i11, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return Math.abs(f10 - this.mCalculatedPositionX) < 20.0f && Math.abs(f11 - this.mCalculatedPositionY) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        int i10 = this.mPositionType;
        if (i10 == 1) {
            positionPathAttributes(rectF, rectF2, f10, f11, strArr, fArr);
        } else if (i10 != 2) {
            positionCartAttributes(rectF, rectF2, f10, f11, strArr, fArr);
        } else {
            positionScreenAttributes(view, rectF, rectF2, f10, f11, strArr, fArr);
        }
    }

    void positionCartAttributes(RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        float fCenterX2 = rectF2.centerX() - fCenterX;
        float fCenterY2 = rectF2.centerY() - fCenterY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f10 - fCenterX) / fCenterX2;
            strArr[1] = "percentY";
            fArr[1] = (f11 - fCenterY) / fCenterY2;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = (f10 - fCenterX) / fCenterX2;
            fArr[1] = (f11 - fCenterY) / fCenterY2;
        } else {
            fArr[1] = (f10 - fCenterX) / fCenterX2;
            fArr[0] = (f11 - fCenterY) / fCenterY2;
        }
    }

    void positionPathAttributes(RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        float fCenterX2 = rectF2.centerX() - fCenterX;
        float fCenterY2 = rectF2.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f12 = fCenterX2 / fHypot;
        float f13 = fCenterY2 / fHypot;
        float f14 = f11 - fCenterY;
        float f15 = f10 - fCenterX;
        float f16 = ((f12 * f14) - (f15 * f13)) / fHypot;
        float f17 = ((f12 * f15) + (f13 * f14)) / fHypot;
        String str = strArr[0];
        if (str != null) {
            if ("percentX".equals(str)) {
                fArr[0] = f17;
                fArr[1] = f16;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f17;
        fArr[1] = f16;
    }

    void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f10 / width;
            strArr[1] = "percentY";
            fArr[1] = f11 / height;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = f10 / width;
            fArr[1] = f11 / height;
        } else {
            fArr[1] = f10 / width;
            fArr[0] = f11 / height;
        }
    }

    public void setType(int i10) {
        this.mPositionType = i10;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "percentWidth":
                this.mPercentWidth = toFloat(obj);
                break;
            case "percentHeight":
                this.mPercentHeight = toFloat(obj);
                break;
            case "drawPath":
                this.mDrawPath = toInt(obj);
                break;
            case "sizePercent":
                float f10 = toFloat(obj);
                this.mPercentWidth = f10;
                this.mPercentHeight = f10;
                break;
            case "percentX":
                this.mPercentX = toFloat(obj);
                break;
            case "percentY":
                this.mPercentY = toFloat(obj);
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public Key mo3924clone() {
        return new KeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> map) {
    }
}
