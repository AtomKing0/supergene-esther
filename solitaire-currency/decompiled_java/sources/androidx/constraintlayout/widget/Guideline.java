package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    private boolean mFilterRedundantCalls;

    public Guideline(Context context) {
        super(context);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z10) {
        this.mFilterRedundantCalls = z10;
    }

    public void setGuidelineBegin(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls && layoutParams.guideBegin == i10) {
            return;
        }
        layoutParams.guideBegin = i10;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls && layoutParams.guideEnd == i10) {
            return;
        }
        layoutParams.guideEnd = i10;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls && layoutParams.guidePercent == f10) {
            return;
        }
        layoutParams.guidePercent = f10;
        setLayoutParams(layoutParams);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
    }
}
