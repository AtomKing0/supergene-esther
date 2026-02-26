package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.p;
import com.google.android.material.internal.q;
import e4.j;
import e4.k;
import x4.g;
import x4.h;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8745f = j.f24917w;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ImageView.ScaleType[] f8746g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Integer f8747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ImageView.ScaleType f8750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Boolean f8751e;

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24744a0);
    }

    private Pair<Integer, Integer> a(@Nullable TextView textView, @Nullable TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i10 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i10 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i10 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void b(Context context) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : com.google.android.material.drawable.b.f(background);
        if (colorStateListValueOf != null) {
            g gVar = new g();
            gVar.Y(colorStateListValueOf);
            gVar.O(context);
            gVar.X(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, gVar);
        }
    }

    private void c(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i10 += iMax;
            i11 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i10, view.getTop(), i11, view.getBottom());
    }

    private void d() {
        if (this.f8748b || this.f8749c) {
            TextView textViewG = q.g(this);
            TextView textViewE = q.e(this);
            if (textViewG == null && textViewE == null) {
                return;
            }
            Pair<Integer, Integer> pairA = a(textViewG, textViewE);
            if (this.f8748b && textViewG != null) {
                c(textViewG, pairA);
            }
            if (!this.f8749c || textViewE == null) {
                return;
            }
            c(textViewE, pairA);
        }
    }

    @Nullable
    private Drawable e(@Nullable Drawable drawable) {
        if (drawable == null || this.f8747a == null) {
            return drawable;
        }
        Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(drawableWrap, this.f8747a.intValue());
        return drawableWrap;
    }

    private void f() {
        ImageView imageViewC = q.c(this);
        if (imageViewC != null) {
            Boolean bool = this.f8751e;
            if (bool != null) {
                imageViewC.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f8750d;
            if (scaleType != null) {
                imageViewC.setScaleType(scaleType);
            }
        }
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.f8750d;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.f8747a;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i10) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof MenuBuilder;
        if (z10) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i10);
        if (z10) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        d();
        f();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        h.d(this, f10);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f8751e;
        if (bool == null || bool.booleanValue() != z10) {
            this.f8751e = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.f8750d != scaleType) {
            this.f8750d = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(e(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i10) {
        this.f8747a = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f8749c != z10) {
            this.f8749c = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f8748b != z10) {
            this.f8748b = z10;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        int i11 = f8745f;
        super(b5.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayI = p.i(context2, attributeSet, k.C3, i10, i11, new int[0]);
        int i12 = k.F3;
        if (typedArrayI.hasValue(i12)) {
            setNavigationIconTint(typedArrayI.getColor(i12, -1));
        }
        this.f8748b = typedArrayI.getBoolean(k.H3, false);
        this.f8749c = typedArrayI.getBoolean(k.G3, false);
        int i13 = typedArrayI.getInt(k.E3, -1);
        if (i13 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f8746g;
            if (i13 < scaleTypeArr.length) {
                this.f8750d = scaleTypeArr[i13];
            }
        }
        int i14 = k.D3;
        if (typedArrayI.hasValue(i14)) {
            this.f8751e = Boolean.valueOf(typedArrayI.getBoolean(i14, false));
        }
        typedArrayI.recycle();
        b(context2);
    }
}
