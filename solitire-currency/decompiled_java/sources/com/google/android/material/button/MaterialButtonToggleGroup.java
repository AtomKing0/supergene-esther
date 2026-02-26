package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import e4.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import x4.k;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f8963k = j.f24914t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c> f8964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f8965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashSet<d> f8966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Comparator<MaterialButton> f8967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer[] f8968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @IdRes
    private final int f8972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set<Integer> f8973j;

    class a implements Comparator<MaterialButton> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final x4.c f8976e = new x4.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        x4.c f8977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        x4.c f8978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        x4.c f8979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        x4.c f8980d;

        c(x4.c cVar, x4.c cVar2, x4.c cVar3, x4.c cVar4) {
            this.f8977a = cVar;
            this.f8978b = cVar3;
            this.f8979c = cVar4;
            this.f8980d = cVar2;
        }

        public static c a(c cVar) {
            x4.c cVar2 = f8976e;
            return new c(cVar2, cVar.f8980d, cVar2, cVar.f8979c);
        }

        public static c b(c cVar, View view) {
            return s.g(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            x4.c cVar2 = cVar.f8977a;
            x4.c cVar3 = cVar.f8980d;
            x4.c cVar4 = f8976e;
            return new c(cVar2, cVar3, cVar4, cVar4);
        }

        public static c d(c cVar) {
            x4.c cVar2 = f8976e;
            return new c(cVar2, cVar2, cVar.f8978b, cVar.f8979c);
        }

        public static c e(c cVar, View view) {
            return s.g(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            x4.c cVar2 = cVar.f8977a;
            x4.c cVar3 = f8976e;
            return new c(cVar2, cVar3, cVar.f8978b, cVar3);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i10, boolean z10);
    }

    private class e implements MaterialButton.b {
        private e() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24765v);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
            MaterialButton materialButtonH = h(i10);
            int iMin = Math.min(materialButtonH.getStrokeWidth(), h(i10 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsD = d(materialButtonH);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(layoutParamsD, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParamsD, -iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = -iMin;
                MarginLayoutParamsCompat.setMarginStart(layoutParamsD, 0);
            }
            materialButtonH.setLayoutParams(layoutParamsD);
        }
        n(firstVisibleChildIndex);
    }

    @NonNull
    private LinearLayout.LayoutParams d(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(@IdRes int i10, boolean z10) {
        if (i10 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f8973j);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f8970g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else {
            if (z10 || !hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            if (!this.f8971h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        }
        q(hashSet);
    }

    private void g(@IdRes int i10, boolean z10) {
        Iterator<d> it = this.f8966c.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10, z10);
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (k(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && k(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private MaterialButton h(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && k(i11)) {
                i10++;
            }
        }
        return -1;
    }

    @Nullable
    private c j(int i10, int i11, int i12) {
        c cVar = this.f8964a.get(i10);
        if (i11 == i12) {
            return cVar;
        }
        boolean z10 = getOrientation() == 0;
        if (i10 == i11) {
            return z10 ? c.e(cVar, this) : c.f(cVar);
        }
        if (i10 == i12) {
            return z10 ? c.b(cVar, this) : c.a(cVar);
        }
        return null;
    }

    private boolean k(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    private void n(int i10) {
        if (getChildCount() == 0 || i10 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i10).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void o(@IdRes int i10, boolean z10) {
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById instanceof MaterialButton) {
            this.f8969f = true;
            ((MaterialButton) viewFindViewById).setChecked(z10);
            this.f8969f = false;
        }
    }

    private static void p(k.b bVar, @Nullable c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.B(cVar.f8977a).t(cVar.f8980d).F(cVar.f8978b).x(cVar.f8979c);
        }
    }

    private void q(Set<Integer> set) {
        Set<Integer> set2 = this.f8973j;
        this.f8973j = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = h(i10).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void r() {
        TreeMap treeMap = new TreeMap(this.f8967d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(h(i10), Integer.valueOf(i10));
        }
        this.f8968e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f8965b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void t() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            h(i10).setA11yClassName((this.f8970g ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f8964a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        ViewCompat.setAccessibilityDelegate(materialButton, new b());
    }

    public void b(@NonNull d dVar) {
        this.f8966c.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void f() {
        q(new HashSet());
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.f8970g || this.f8973j.isEmpty()) {
            return -1;
        }
        return this.f8973j.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = h(i10).getId();
            if (this.f8973j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f8968e;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i11;
    }

    public boolean l() {
        return this.f8970g;
    }

    void m(@NonNull MaterialButton materialButton, boolean z10) {
        if (this.f8969f) {
            return;
        }
        e(materialButton.getId(), z10);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f8972i;
        if (i10 != -1) {
            q(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, l() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        s();
        c();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f8964a.remove(iIndexOfChild);
        }
        s();
        c();
    }

    @VisibleForTesting
    void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton materialButtonH = h(i10);
            if (materialButtonH.getVisibility() != 8) {
                k.b bVarV = materialButtonH.getShapeAppearanceModel().v();
                p(bVarV, j(i10, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonH.setShapeAppearanceModel(bVarV.m());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            h(i10).setEnabled(z10);
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f8971h = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f8970g != z10) {
            this.f8970g = z10;
            f();
        }
        t();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        int i11 = f8963k;
        super(b5.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8964a = new ArrayList();
        this.f8965b = new e(this, null);
        this.f8966c = new LinkedHashSet<>();
        this.f8967d = new a();
        this.f8969f = false;
        this.f8973j = new HashSet();
        TypedArray typedArrayI = p.i(getContext(), attributeSet, e4.k.f25113y2, i10, i11, new int[0]);
        setSingleSelection(typedArrayI.getBoolean(e4.k.C2, false));
        this.f8972i = typedArrayI.getResourceId(e4.k.A2, -1);
        this.f8971h = typedArrayI.getBoolean(e4.k.B2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayI.getBoolean(e4.k.f25121z2, true));
        typedArrayI.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(@BoolRes int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
