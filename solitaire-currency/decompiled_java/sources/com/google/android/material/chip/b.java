package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.g;
import e4.j;
import java.util.List;

/* JADX INFO: compiled from: ChipGroup.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9131i = j.f24909o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Dimension
    private int f9132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Dimension
    private int f9133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private d f9134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9135h;

    /* JADX INFO: compiled from: ChipGroup.java */
    class a implements d {
        a(c cVar) {
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.chip.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChipGroup.java */
    public static class C0209b extends ViewGroup.MarginLayoutParams {
        public C0209b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0209b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0209b(int i10, int i11) {
            super(i10, i11);
        }
    }

    /* JADX INFO: compiled from: ChipGroup.java */
    @Deprecated
    public interface c {
    }

    /* JADX INFO: compiled from: ChipGroup.java */
    public interface d {
    }

    /* JADX INFO: compiled from: ChipGroup.java */
    private class e implements ViewGroup.OnHierarchyChangeListener {
        static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(e eVar, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
            throw null;
        }
    }

    private boolean e(int i10) {
        return getChildAt(i10).getVisibility() == 0;
    }

    private int getVisibleChipCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof Chip) && e(i11)) {
                i10++;
            }
        }
        return i10;
    }

    @Override // com.google.android.material.internal.g
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0209b);
    }

    int d(@Nullable View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt instanceof Chip) && e(i11)) {
                if (((Chip) childAt) == view) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public boolean f() {
        throw null;
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0209b(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0209b(getContext(), attributeSet);
    }

    @IdRes
    public int getCheckedChipId() {
        throw null;
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        throw null;
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.f9132e;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.f9133f;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.f9135h != -1) {
            throw null;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), c() ? getVisibleChipCount() : -1, false, f() ? 1 : 2));
    }

    public void setChipSpacing(@Dimension int i10) {
        setChipSpacingHorizontal(i10);
        setChipSpacingVertical(i10);
    }

    public void setChipSpacingHorizontal(@Dimension int i10) {
        if (this.f9132e != i10) {
            this.f9132e = i10;
            setItemSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingResource(@DimenRes int i10) {
        setChipSpacing(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingVertical(@Dimension int i10) {
        if (this.f9133f != i10) {
            this.f9133f = i10;
            setLineSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable c cVar) {
        if (cVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new a(cVar));
        }
    }

    public void setOnCheckedStateChangeListener(@Nullable d dVar) {
        this.f9134g = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        e.a(null, onHierarchyChangeListener);
    }

    public void setSelectionRequired(boolean z10) {
        throw null;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.g
    public void setSingleLine(boolean z10) {
        super.setSingleLine(z10);
    }

    public void setSingleSelection(boolean z10) {
        throw null;
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0209b(layoutParams);
    }

    public void setSingleLine(@BoolRes int i10) {
        setSingleLine(getResources().getBoolean(i10));
    }

    public void setSingleSelection(@BoolRes int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
