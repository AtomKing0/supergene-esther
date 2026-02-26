package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends h implements MenuView.ItemView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f9381r = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f9384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f9385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CheckedTextView f9386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private FrameLayout f9387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MenuItemImpl f9388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorStateList f9389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f9390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Drawable f9391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AccessibilityDelegateCompat f9392q;

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.f9384i);
        }
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        if (c()) {
            this.f9386k.setVisibility(8);
            FrameLayout frameLayout = this.f9387l;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.f9387l.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f9386k.setVisibility(0);
        FrameLayout frameLayout2 = this.f9387l;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.f9387l.setLayoutParams(layoutParams2);
        }
    }

    @Nullable
    private StateListDrawable b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f9381r, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean c() {
        return this.f9388m.getTitle() == null && this.f9388m.getIcon() == null && this.f9388m.getActionView() != null;
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.f9387l == null) {
                this.f9387l = (FrameLayout) ((ViewStub) findViewById(e4.f.f24826g)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f9387l.removeAllViews();
            this.f9387l.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f9388m;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i10) {
        this.f9388m = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, b());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        MenuItemImpl menuItemImpl = this.f9388m;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f9388m.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f9381r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.f9384i != z10) {
            this.f9384i = z10;
            this.f9392q.sendAccessibilityEvent(this.f9386k, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z10) {
        refreshDrawableState();
        this.f9386k.setChecked(z10);
        CheckedTextView checkedTextView = this.f9386k;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z10 && this.f9385j) ? 1 : 0);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.f9390o) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.f9389n);
            }
            int i10 = this.f9382g;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.f9383h) {
            if (this.f9391p == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), e4.e.f24819l, getContext().getTheme());
                this.f9391p = drawable2;
                if (drawable2 != null) {
                    int i11 = this.f9382g;
                    drawable2.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.f9391p;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f9386k, drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.f9386k.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(@Dimension int i10) {
        this.f9382g = i10;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f9389n = colorStateList;
        this.f9390o = colorStateList != null;
        MenuItemImpl menuItemImpl = this.f9388m;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.f9386k.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.f9383h = z10;
    }

    public void setTextAppearance(int i10) {
        TextViewCompat.setTextAppearance(this.f9386k, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f9386k.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f9386k.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9385j = true;
        a aVar = new a();
        this.f9392q = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(e4.h.f24852d, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(e4.d.f24782d));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(e4.f.f24827h);
        this.f9386k = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z10, char c10) {
    }
}
