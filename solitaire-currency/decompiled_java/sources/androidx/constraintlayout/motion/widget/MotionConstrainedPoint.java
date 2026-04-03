package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names = {v8.h.L, ViewHierarchyNode.JsonKeys.X, ViewHierarchyNode.JsonKeys.Y, "width", "height", "pathRotate"};
    private float height;
    private Easing mKeyFrameEasing;
    private float position;
    int visibility;
    private float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f822x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f823y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    private int mAnimateRelativeTo = -1;
    LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    private boolean diff(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void addValues(HashMap<String, ViewSpline> map, int i10) {
        for (String str : map.keySet()) {
            ViewSpline viewSpline = map.get(str);
            str.hashCode();
            byte b10 = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b10 = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b10 = 1;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b10 = 2;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b10 = 3;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b10 = 4;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b10 = 5;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b10 = 6;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b10 = 7;
                    }
                    break;
                case -760884510:
                    if (str.equals(Key.PIVOT_X)) {
                        b10 = 8;
                    }
                    break;
                case -760884509:
                    if (str.equals(Key.PIVOT_Y)) {
                        b10 = 9;
                    }
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        b10 = 10;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        b10 = 11;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        b10 = 12;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b10 = 13;
                    }
                    break;
            }
            switch (b10) {
                case 0:
                    viewSpline.setPoint(i10, Float.isNaN(this.rotationX) ? 0.0f : this.rotationX);
                    break;
                case 1:
                    viewSpline.setPoint(i10, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case 2:
                    viewSpline.setPoint(i10, Float.isNaN(this.translationX) ? 0.0f : this.translationX);
                    break;
                case 3:
                    viewSpline.setPoint(i10, Float.isNaN(this.translationY) ? 0.0f : this.translationY);
                    break;
                case 4:
                    viewSpline.setPoint(i10, Float.isNaN(this.translationZ) ? 0.0f : this.translationZ);
                    break;
                case 5:
                    viewSpline.setPoint(i10, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                    break;
                case 6:
                    viewSpline.setPoint(i10, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                    break;
                case 7:
                    viewSpline.setPoint(i10, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                    break;
                case 8:
                    viewSpline.setPoint(i10, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                    break;
                case 9:
                    viewSpline.setPoint(i10, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                    break;
                case 10:
                    viewSpline.setPoint(i10, Float.isNaN(this.rotation) ? 0.0f : this.rotation);
                    break;
                case 11:
                    viewSpline.setPoint(i10, Float.isNaN(this.elevation) ? 0.0f : this.elevation);
                    break;
                case 12:
                    viewSpline.setPoint(i10, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                    break;
                case 13:
                    viewSpline.setPoint(i10, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.attributes.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.attributes.get(str2);
                            if (viewSpline instanceof ViewSpline.CustomSet) {
                                ((ViewSpline.CustomSet) viewSpline).setPoint(i10, constraintAttribute);
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i10 + ", value" + constraintAttribute.getValueToInterpolate() + viewSpline);
                            }
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
    }

    void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.alpha, motionConstrainedPoint.alpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("elevation");
        }
        int i10 = this.visibility;
        int i11 = motionConstrainedPoint.visibility;
        if (i10 != i11 && this.mVisibilityMode == 0 && (i10 == 0 || i11 == 0)) {
            hashSet.add("alpha");
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.translationX, motionConstrainedPoint.translationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.translationY, motionConstrainedPoint.translationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
            hashSet.add("translationZ");
        }
    }

    void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f822x, this.f823y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 18) {
                dArr[i10] = fArr[r4];
                i10++;
            }
        }
    }

    int getCustomData(String str, double[] dArr, int i10) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i10] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        constraintAttribute.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        int i11 = 0;
        while (i11 < iNumberOfInterpolatedValues) {
            dArr[i10] = r1[i11];
            i11++;
            i10++;
        }
        return iNumberOfInterpolatedValues;
    }

    int getCustomDataCount(String str) {
        return this.attributes.get(str).numberOfInterpolatedValues();
    }

    boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    void setBounds(float f10, float f11, float f12, float f13) {
        this.f822x = f10;
        this.f823y = f11;
        this.width = f12;
        this.height = f13;
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    public void setState(Rect rect, View view, int i10, float f10) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(view);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i10 == 1) {
            this.rotation = f10 - 90.0f;
        } else {
            if (i10 != 2) {
                return;
            }
            this.rotation = f10 + 90.0f;
        }
    }

    public void setState(Rect rect, ConstraintSet constraintSet, int i10, int i11) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(constraintSet.getParameters(i11));
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return;
                    }
                }
            }
            float f10 = this.rotation + 90.0f;
            this.rotation = f10;
            if (f10 > 180.0f) {
                this.rotation = f10 - 360.0f;
                return;
            }
            return;
        }
        this.rotation -= 90.0f;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        ConstraintSet.PropertySet propertySet = constraint.propertySet;
        int i10 = propertySet.mVisibilityMode;
        this.mVisibilityMode = i10;
        int i11 = propertySet.visibility;
        this.visibility = i11;
        this.alpha = (i11 == 0 || i10 != 0) ? propertySet.alpha : 0.0f;
        ConstraintSet.Transform transform = constraint.transform;
        this.applyElevation = transform.applyElevation;
        this.elevation = transform.elevation;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.isContinuous()) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.position, motionConstrainedPoint.position);
        zArr[1] = zArr[1] | diff(this.f822x, motionConstrainedPoint.f822x);
        zArr[2] = zArr[2] | diff(this.f823y, motionConstrainedPoint.f823y);
        zArr[3] = zArr[3] | diff(this.width, motionConstrainedPoint.width);
        zArr[4] = diff(this.height, motionConstrainedPoint.height) | zArr[4];
    }
}
