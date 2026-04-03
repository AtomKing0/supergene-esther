package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import e4.h;

/* JADX INFO: loaded from: classes3.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] I;
    private static final int[] J;

    @Nullable
    private final AccessibilityManager G;
    private boolean H;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.s {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        int i10 = e4.b.N;
        I = new int[]{i10};
        J = new int[]{i10, e4.b.P};
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull a aVar) {
        super(context, viewGroup, view, aVar);
        this.G = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Nullable
    private static ViewGroup e0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private SnackbarContentLayout f0() {
        return (SnackbarContentLayout) this.f9591i.getChildAt(0);
    }

    private TextView g0() {
        return f0().getMessageView();
    }

    private static boolean h0(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(J);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @NonNull
    public static Snackbar i0(@NonNull View view, @NonNull CharSequence charSequence, int i10) {
        return j0(null, view, charSequence, i10);
    }

    @NonNull
    private static Snackbar j0(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i10) {
        ViewGroup viewGroupE0 = e0(view);
        if (viewGroupE0 == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupE0.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(h0(context) ? h.f24869u : h.f24851c, viewGroupE0, false);
        Snackbar snackbar = new Snackbar(context, viewGroupE0, snackbarContentLayout, snackbarContentLayout);
        snackbar.k0(charSequence);
        snackbar.S(i10);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int B() {
        int iB = super.B();
        if (iB == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.G.getRecommendedTimeoutMillis(iB, (this.H ? 4 : 0) | 1 | 2);
        }
        if (this.H && this.G.isTouchExplorationEnabled()) {
            return -2;
        }
        return iB;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void W() {
        super.W();
    }

    @NonNull
    public Snackbar k0(@NonNull CharSequence charSequence) {
        g0().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void x() {
        super.x();
    }
}
