package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import java.util.List;

/* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
/* JADX INFO: loaded from: classes3.dex */
public class w extends AppCompatAutoCompleteTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ListPopupWindow f9835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final AccessibilityManager f9836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Rect f9837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @LayoutRes
    private final int f9838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f9839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private ColorStateList f9840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private ColorStateList f9842h;

    /* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            w wVar = w.this;
            w.this.k(i10 < 0 ? wVar.f9835a.getSelectedItem() : wVar.getAdapter().getItem(i10));
            AdapterView.OnItemClickListener onItemClickListener = w.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = w.this.f9835a.getSelectedView();
                    i10 = w.this.f9835a.getSelectedItemPosition();
                    j10 = w.this.f9835a.getSelectedItemId();
                }
                onItemClickListener.onItemClick(w.this.f9835a.getListView(), view, i10, j10);
            }
            w.this.f9835a.dismiss();
        }
    }

    /* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
    private class b<T> extends ArrayAdapter<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private ColorStateList f9844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private ColorStateList f9845b;

        b(@NonNull Context context, int i10, @NonNull String[] strArr) {
            super(context, i10, strArr);
            f();
        }

        @Nullable
        private ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{n4.a.i(w.this.f9841g, w.this.f9842h.getColorForState(iArr2, 0)), n4.a.i(w.this.f9841g, w.this.f9842h.getColorForState(iArr, 0)), w.this.f9841g});
        }

        @Nullable
        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(w.this.f9841g);
            if (this.f9845b == null) {
                return colorDrawable;
            }
            DrawableCompat.setTintList(colorDrawable, this.f9844a);
            return new RippleDrawable(this.f9845b, colorDrawable, null);
        }

        private boolean c() {
            return w.this.f9841g != 0;
        }

        private boolean d() {
            return w.this.f9842h != null;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{w.this.f9842h.getColorForState(iArr, 0), 0});
        }

        void f() {
            this.f9845b = e();
            this.f9844a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, @Nullable View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                ViewCompat.setBackground(textView, w.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public w(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24743a);
    }

    @Nullable
    private TextInputLayout e() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean f() {
        return h() || g();
    }

    private boolean g() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f9836b;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f9836b.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean h() {
        AccessibilityManager accessibilityManager = this.f9836b;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private int i() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutE = e();
        int i10 = 0;
        if (adapter == null || textInputLayoutE == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f9835a.getSelectedItemPosition()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutE);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable background = this.f9835a.getBackground();
        if (background != null) {
            background.getPadding(this.f9837c);
            Rect rect = this.f9837c;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutE.getEndIconView().getMeasuredWidth();
    }

    private void j() {
        TextInputLayout textInputLayoutE = e();
        if (textInputLayoutE != null) {
            textInputLayoutE.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void k(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (f()) {
            this.f9835a.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.f9840f;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayoutE = e();
        return (textInputLayoutE == null || !textInputLayoutE.R()) ? super.getHint() : textInputLayoutE.getHint();
    }

    public float getPopupElevation() {
        return this.f9839e;
    }

    public int getSimpleItemSelectedColor() {
        return this.f9841g;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f9842h;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutE = e();
        if (textInputLayoutE != null && textInputLayoutE.R() && super.getHint() == null && com.google.android.material.internal.i.b()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9835a.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), i()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        if (f()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t10) {
        super.setAdapter(t10);
        this.f9835a.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.f9835a;
        if (listPopupWindow != null) {
            listPopupWindow.setBackgroundDrawable(drawable);
        }
    }

    public void setDropDownBackgroundTint(@ColorInt int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f9840f = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof x4.g) {
            ((x4.g) dropDownBackground).Y(this.f9840f);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f9835a.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        j();
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f9841g = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList colorStateList) {
        this.f9842h = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(@ArrayRes int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (f()) {
            this.f9835a.show();
        } else {
            super.showDropDown();
        }
    }

    public w(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(b5.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f9837c = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.p.i(context2, attributeSet, e4.k.V1, i10, e4.j.f24897c, new int[0]);
        int i11 = e4.k.W1;
        if (typedArrayI.hasValue(i11) && typedArrayI.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f9838d = typedArrayI.getResourceId(e4.k.Z1, e4.h.f24861m);
        this.f9839e = typedArrayI.getDimensionPixelOffset(e4.k.X1, e4.d.X);
        int i12 = e4.k.Y1;
        if (typedArrayI.hasValue(i12)) {
            this.f9840f = ColorStateList.valueOf(typedArrayI.getColor(i12, 0));
        }
        this.f9841g = typedArrayI.getColor(e4.k.f24921a2, 0);
        this.f9842h = u4.c.a(context2, typedArrayI, e4.k.f24929b2);
        this.f9836b = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f9835a = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new a());
        int i13 = e4.k.f24937c2;
        if (typedArrayI.hasValue(i13)) {
            setSimpleItems(typedArrayI.getResourceId(i13, 0));
        }
        typedArrayI.recycle();
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new b(getContext(), this.f9838d, strArr));
    }
}
