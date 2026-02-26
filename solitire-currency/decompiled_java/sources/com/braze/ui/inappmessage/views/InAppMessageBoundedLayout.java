package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.braze.ui.R$styleable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageBoundedLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageBoundedLayout extends RelativeLayout {
    private int maxDefinedHeightPixels;
    private int maxDefinedWidthPixels;
    private int minDefinedHeightPixels;
    private int minDefinedWidthPixels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageBoundedLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        t.i(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.InAppMessageBoundedLayout);
        t.h(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…nAppMessageBoundedLayout)");
        this.maxDefinedWidthPixels = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMaxWidth, 0);
        this.minDefinedWidthPixels = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMinWidth, 0);
        this.maxDefinedHeightPixels = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMaxHeight, 0);
        this.minDefinedHeightPixels = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMinHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int i12 = this.minDefinedWidthPixels;
        if (i12 <= 0 || size >= i12) {
            int i13 = this.maxDefinedWidthPixels;
            if (i13 > 0 && size > i13) {
                i10 = View.MeasureSpec.makeMeasureSpec(this.maxDefinedWidthPixels, View.MeasureSpec.getMode(i10));
            }
        } else {
            i10 = View.MeasureSpec.makeMeasureSpec(this.minDefinedWidthPixels, View.MeasureSpec.getMode(i10));
        }
        int size2 = View.MeasureSpec.getSize(i11);
        int i14 = this.minDefinedHeightPixels;
        if (i14 <= 0 || size2 >= i14) {
            int i15 = this.maxDefinedHeightPixels;
            if (i15 > 0 && size2 > i15) {
                i11 = View.MeasureSpec.makeMeasureSpec(this.maxDefinedHeightPixels, View.MeasureSpec.getMode(i11));
            }
        } else {
            i11 = View.MeasureSpec.makeMeasureSpec(this.minDefinedHeightPixels, View.MeasureSpec.getMode(i11));
        }
        super.onMeasure(i10, i11);
    }
}
