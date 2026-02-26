package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.chip.a;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import e4.i;
import e4.j;
import e4.k;
import f4.h;
import java.util.List;
import u4.d;
import u4.f;
import x4.n;

/* JADX INFO: loaded from: classes3.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0208a, n, Checkable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f9079s = j.f24910p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Rect f9080t = new Rect();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int[] f9081u = {R.attr.state_selected};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[] f9082v = {R.attr.state_checkable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private com.google.android.material.chip.a f9083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private InsetDrawable f9084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private RippleDrawable f9085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private View.OnClickListener f9086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private CompoundButton.OnCheckedChangeListener f9087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Dimension(unit = 1)
    private int f9094l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private CharSequence f9095m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    private final c f9096n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f9097o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Rect f9098p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final RectF f9099q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final f f9100r;

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @NonNull Outline outline) {
            if (Chip.this.f9083a != null) {
                Chip.this.f9083a.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends ExploreByTouchHelper {
        c(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f10, float f11) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f10, f11)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f9086d != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            if (i10 == 0) {
                return Chip.this.performClick();
            }
            if (i10 == 1) {
                return Chip.this.u();
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.r());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            accessibilityNodeInfoCompat.setClassName(Chip.this.getAccessibilityClassName());
            accessibilityNodeInfoCompat.setText(Chip.this.getText());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i10, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i10 != 1) {
                accessibilityNodeInfoCompat.setContentDescription("");
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.f9080t);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i11 = i.f24882k;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                accessibilityNodeInfoCompat.setContentDescription(context.getString(i11, objArr).trim());
            }
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onVirtualViewKeyboardFocusChanged(int i10, boolean z10) {
            if (i10 == 1) {
                Chip.this.f9091i = z10;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24748e);
    }

    private void A() {
        this.f9085c = new RippleDrawable(v4.b.a(this.f9083a.e1()), getBackgroundDrawable(), null);
        this.f9083a.K2(false);
        ViewCompat.setBackground(this, this.f9085c);
        B();
    }

    private void B() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f9083a) == null) {
            return;
        }
        int iI0 = (int) (aVar.I0() + this.f9083a.i1() + this.f9083a.p0());
        int iN0 = (int) (this.f9083a.N0() + this.f9083a.j1() + this.f9083a.l0());
        if (this.f9084b != null) {
            Rect rect = new Rect();
            this.f9084b.getPadding(rect);
            iN0 += rect.left;
            iI0 += rect.right;
        }
        ViewCompat.setPaddingRelative(this, iN0, getPaddingTop(), iI0, getPaddingBottom());
    }

    private void C() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f9100r);
        }
    }

    private void D(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.f9099q.setEmpty();
        if (n() && this.f9086d != null) {
            this.f9083a.X0(this.f9099q);
        }
        return this.f9099q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f9098p.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f9098p;
    }

    @Nullable
    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.h1();
        }
        return null;
    }

    private void j(@NonNull com.google.android.material.chip.a aVar) {
        aVar.o2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @NonNull
    private int[] k() {
        ?? IsEnabled = isEnabled();
        int i10 = IsEnabled;
        if (this.f9091i) {
            i10 = IsEnabled + 1;
        }
        int i11 = i10;
        if (this.f9090h) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (this.f9089g) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (isChecked()) {
            i13 = i12 + 1;
        }
        int[] iArr = new int[i13];
        int i14 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i14 = 1;
        }
        if (this.f9091i) {
            iArr[i14] = 16842908;
            i14++;
        }
        if (this.f9090h) {
            iArr[i14] = 16843623;
            i14++;
        }
        if (this.f9089g) {
            iArr[i14] = 16842919;
            i14++;
        }
        if (isChecked()) {
            iArr[i14] = 16842913;
        }
        return iArr;
    }

    private void m() {
        if (getBackgroundDrawable() == this.f9084b && this.f9083a.getCallback() == null) {
            this.f9083a.setCallback(this.f9084b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.google.android.material.chip.a aVar = this.f9083a;
        return (aVar == null || aVar.Q0() == null) ? false : true;
    }

    private void o(Context context, @Nullable AttributeSet attributeSet, int i10) {
        TypedArray typedArrayI = p.i(context, attributeSet, k.f24951e0, i10, f9079s, new int[0]);
        this.f9092j = typedArrayI.getBoolean(k.K0, false);
        this.f9094l = (int) Math.ceil(typedArrayI.getDimension(k.f25111y0, (float) Math.ceil(s.c(getContext(), 48))));
        typedArrayI.recycle();
    }

    private void p() {
        setOutlineProvider(new b());
    }

    private void q(int i10, int i11, int i12, int i13) {
        this.f9084b = new InsetDrawable((Drawable) this.f9083a, i10, i11, i12, i13);
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f9090h != z10) {
            this.f9090h = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f9089g != z10) {
            this.f9089g = z10;
            refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(CompoundButton compoundButton, boolean z10) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f9087e;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
        }
    }

    private void v() {
        if (this.f9084b != null) {
            this.f9084b = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    private void x(@Nullable com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.o2(null);
        }
    }

    private void y() {
        if (n() && s() && this.f9086d != null) {
            ViewCompat.setAccessibilityDelegate(this, this.f9096n);
            this.f9097o = true;
        } else {
            ViewCompat.setAccessibilityDelegate(this, null);
            this.f9097o = false;
        }
    }

    private void z() {
        if (v4.b.f35115a) {
            A();
            return;
        }
        this.f9083a.K2(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        B();
        m();
    }

    @Override // com.google.android.material.chip.a.InterfaceC0208a
    public void a() {
        l(this.f9094l);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return !this.f9097o ? super.dispatchHoverEvent(motionEvent) : this.f9096n.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f9097o) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f9096n.dispatchKeyEvent(keyEvent) || this.f9096n.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f9083a;
        if ((aVar == null || !aVar.o1()) ? false : this.f9083a.k2(k())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f9095m)) {
            return this.f9095m;
        }
        if (!r()) {
            return isClickable() ? "android.widget.Button" : AndroidComposeViewAccessibilityDelegateCompat.ClassName;
        }
        ViewParent parent = getParent();
        return ((parent instanceof com.google.android.material.chip.b) && ((com.google.android.material.chip.b) parent).f()) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f9084b;
        return insetDrawable == null ? this.f9083a : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.E0();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.F0();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.G0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return Math.max(0.0f, aVar.H0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f9083a;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.I0();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.J0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.K0();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.L0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.M0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.N0();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.Q0();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.R0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.S0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.T0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.U0();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.a1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.f9097o && (this.f9096n.getKeyboardFocusedVirtualViewId() == 1 || this.f9096n.getAccessibilityFocusedVirtualViewId() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Nullable
    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.d1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    @NonNull
    public x4.k getShapeAppearanceModel() {
        return this.f9083a.C();
    }

    @Nullable
    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.i1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            return aVar.j1();
        }
        return 0.0f;
    }

    public boolean l(@Dimension int i10) {
        this.f9094l = i10;
        if (!w()) {
            if (this.f9084b != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int iMax = Math.max(0, i10 - this.f9083a.getIntrinsicHeight());
        int iMax2 = Math.max(0, i10 - this.f9083a.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f9084b != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int i11 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i12 = iMax > 0 ? iMax / 2 : 0;
        if (this.f9084b != null) {
            Rect rect = new Rect();
            this.f9084b.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                z();
                return true;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        q(i11, i12, i11, i12);
        z();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x4.h.f(this, this.f9083a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f9081u);
        }
        if (r()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f9082v);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f9097o) {
            this.f9096n.onFocusChanged(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof com.google.android.material.chip.b) {
            com.google.android.material.chip.b bVar = (com.google.android.material.chip.b) getParent();
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(bVar.b(this), 1, bVar.c() ? bVar.d(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i10) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i10);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f9093k != i10) {
            this.f9093k = i10;
            B();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L39
            if (r0 == r2) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f9089g
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r3)
            goto L3e
        L2b:
            boolean r0 = r5.f9089g
            if (r0 == 0) goto L34
            r5.u()
            r0 = r2
            goto L35
        L34:
            r0 = r3
        L35:
            r5.setCloseIconPressed(r3)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
        L3e:
            r0 = r2
            goto L41
        L40:
            r0 = r3
        L41:
            if (r0 != 0) goto L4b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
            goto L4b
        L4a:
            r2 = r3
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f9083a;
        return aVar != null && aVar.n1();
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f9083a;
        return aVar != null && aVar.p1();
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.f9095m = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f9085c) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f9085c) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.w1(z10);
        }
    }

    public void setCheckableResource(@BoolRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.x1(i10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar == null) {
            this.f9088f = z10;
        } else if (aVar.n1()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.y1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(@DrawableRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.z1(i10);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.A1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.B1(i10);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.C1(i10);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.E1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.F1(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.G1(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.H1(i10);
        }
    }

    public void setChipDrawable(@NonNull com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f9083a;
        if (aVar2 != aVar) {
            x(aVar2);
            this.f9083a = aVar;
            aVar.z2(false);
            j(this.f9083a);
            l(this.f9094l);
        }
    }

    public void setChipEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.I1(f10);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.J1(i10);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.K1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(@DrawableRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.L1(i10);
        }
    }

    public void setChipIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.M1(f10);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.N1(i10);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.O1(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.P1(i10);
        }
    }

    public void setChipIconVisible(@BoolRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.Q1(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.S1(f10);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.T1(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.U1(f10);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.V1(i10);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.W1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.X1(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.Y1(f10);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.Z1(i10);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.b2(drawable);
        }
        y();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.c2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.d2(f10);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.e2(i10);
        }
    }

    public void setCloseIconResource(@DrawableRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.f2(i10);
        }
        y();
    }

    public void setCloseIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.g2(f10);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.h2(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.i2(f10);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.j2(i10);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.l2(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.m2(i10);
        }
    }

    public void setCloseIconVisible(@BoolRes int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.X(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f9083a == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.p2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f9092j = z10;
        l(this.f9094l);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.q2(hVar);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.r2(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.s2(f10);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.t2(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.u2(f10);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.v2(i10);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f9083a == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i10) {
        super.setMaxWidth(i10);
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.w2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i10);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f9087e = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f9086d = onClickListener;
        y();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.x2(colorStateList);
        }
        if (this.f9083a.l1()) {
            return;
        }
        A();
    }

    public void setRippleColorResource(@ColorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.y2(i10);
            if (this.f9083a.l1()) {
                return;
            }
            A();
        }
    }

    @Override // x4.n
    public void setShapeAppearanceModel(@NonNull x4.k kVar) {
        this.f9083a.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.A2(hVar);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.B2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.L2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f9083a;
        if (aVar2 != null) {
            aVar2.C2(charSequence);
        }
    }

    public void setTextAppearance(@Nullable d dVar) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.D2(dVar);
        }
        C();
    }

    public void setTextAppearanceResource(@StyleRes int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.F2(f10);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.G2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.H2(TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics()));
        }
        C();
    }

    public void setTextStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.I2(f10);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.J2(i10);
        }
    }

    @CallSuper
    public boolean u() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f9086d;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f9097o) {
            this.f9096n.sendEventForVirtualView(1, 1);
        }
        return z10;
    }

    public boolean w() {
        return this.f9092j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f9079s;
        super(b5.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f9098p = new Rect();
        this.f9099q = new RectF();
        this.f9100r = new a();
        Context context2 = getContext();
        D(attributeSet);
        com.google.android.material.chip.a aVarU0 = com.google.android.material.chip.a.u0(context2, attributeSet, i10, i11);
        o(context2, attributeSet, i10);
        setChipDrawable(aVarU0);
        aVarU0.X(ViewCompat.getElevation(this));
        TypedArray typedArrayI = p.i(context2, attributeSet, k.f24951e0, i10, i11, new int[0]);
        boolean zHasValue = typedArrayI.hasValue(k.P0);
        typedArrayI.recycle();
        this.f9096n = new c(this);
        y();
        if (!zHasValue) {
            p();
        }
        setChecked(this.f9088f);
        setText(aVarU0.g1());
        setEllipsize(aVarU0.a1());
        C();
        if (!this.f9083a.L2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        B();
        if (w()) {
            setMinHeight(this.f9094l);
        }
        this.f9093k = ViewCompat.getLayoutDirection(this);
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: k4.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f29677a.t(compoundButton, z10);
            }
        });
    }

    public void setCloseIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.n2(z10);
        }
        y();
    }

    public void setCheckedIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.D1(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.R1(z10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.E2(i10);
        }
        C();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        com.google.android.material.chip.a aVar = this.f9083a;
        if (aVar != null) {
            aVar.E2(i10);
        }
        C();
    }

    class a extends f {
        a() {
        }

        @Override // u4.f
        public void b(@NonNull Typeface typeface, boolean z10) {
            Chip chip = Chip.this;
            chip.setText(chip.f9083a.L2() ? Chip.this.f9083a.g1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }

        @Override // u4.f
        public void a(int i10) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable com.google.android.material.internal.j<Chip> jVar) {
    }
}
