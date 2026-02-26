package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    KeyPositionBase() {
    }

    abstract void calcPosition(int i10, int i11, float f10, float f11, float f12, float f13);

    abstract float getPositionX();

    abstract float getPositionY();

    public abstract boolean intersects(int i10, int i11, RectF rectF, RectF rectF2, float f10, float f11);

    abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr);

    @Override // androidx.constraintlayout.motion.widget.Key
    void getAttributeNames(HashSet<String> hashSet) {
    }
}
