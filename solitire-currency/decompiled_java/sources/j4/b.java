package j4;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import e4.e;
import e4.f;
import e4.i;
import e4.j;
import e4.k;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: MaterialCheckBox.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends AppCompatCheckBox {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f28667u = j.f24911q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[] f28668v = {e4.b.U};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int[] f28669w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int[][] f28670x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SuppressLint({"DiscouragedApi"})
    private static final int f28671y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinkedHashSet<c> f28672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final LinkedHashSet<InterfaceC0594b> f28673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private ColorStateList f28674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f28675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f28677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private CharSequence f28678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Drawable f28679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Drawable f28680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f28681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    ColorStateList f28682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    ColorStateList f28683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    private PorterDuff.Mode f28684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f28685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f28686o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f28687p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private CharSequence f28688q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private CompoundButton.OnCheckedChangeListener f28689r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private final AnimatedVectorDrawableCompat f28690s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f28691t;

    /* JADX INFO: compiled from: MaterialCheckBox.java */
    class a extends Animatable2Compat.AnimationCallback {
        a() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            ColorStateList colorStateList = b.this.f28682k;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            super.onAnimationStart(drawable);
            b bVar = b.this;
            ColorStateList colorStateList = bVar.f28682k;
            if (colorStateList != null) {
                DrawableCompat.setTint(drawable, colorStateList.getColorForState(bVar.f28686o, b.this.f28682k.getDefaultColor()));
            }
        }
    }

    /* JADX INFO: renamed from: j4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialCheckBox.java */
    public interface InterfaceC0594b {
        void a(@NonNull b bVar, int i10);
    }

    /* JADX INFO: compiled from: MaterialCheckBox.java */
    public interface c {
        void a(@NonNull b bVar, boolean z10);
    }

    /* JADX INFO: compiled from: MaterialCheckBox.java */
    static class d extends View.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28693a;

        /* JADX INFO: compiled from: MaterialCheckBox.java */
        class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        /* synthetic */ d(Parcel parcel, a aVar) {
            this(parcel);
        }

        @NonNull
        private String a() {
            int i10 = this.f28693a;
            return i10 != 1 ? i10 != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        @NonNull
        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.f28693a));
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        private d(Parcel parcel) {
            super(parcel);
            this.f28693a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    static {
        int i10 = e4.b.T;
        f28669w = new int[]{i10};
        f28670x = new int[][]{new int[]{R.attr.state_enabled, i10}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f28671y = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, e4.b.f24747d);
    }

    private boolean c(TintTypedArray tintTypedArray) {
        return tintTypedArray.getResourceId(k.f24922a3, 0) == f28671y && tintTypedArray.getResourceId(k.f24930b3, 0) == 0;
    }

    private void e() {
        this.f28679h = com.google.android.material.drawable.b.c(this.f28679h, this.f28682k, CompoundButtonCompat.getButtonTintMode(this));
        this.f28680i = com.google.android.material.drawable.b.c(this.f28680i, this.f28683l, this.f28684m);
        g();
        h();
        super.setButtonDrawable(com.google.android.material.drawable.b.a(this.f28679h, this.f28680i));
        refreshDrawableState();
    }

    private void f() {
        if (Build.VERSION.SDK_INT < 30 || this.f28688q != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    private void g() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        if (this.f28681j) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.f28690s;
            if (animatedVectorDrawableCompat2 != null) {
                animatedVectorDrawableCompat2.unregisterAnimationCallback(this.f28691t);
                this.f28690s.registerAnimationCallback(this.f28691t);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.f28679h;
                if (!(drawable instanceof AnimatedStateListDrawable) || (animatedVectorDrawableCompat = this.f28690s) == null) {
                    return;
                }
                int i10 = f.f24821b;
                int i11 = f.V;
                ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, animatedVectorDrawableCompat, false);
                ((AnimatedStateListDrawable) this.f28679h).addTransition(f.f24829j, i11, this.f28690s, false);
            }
        }
    }

    @NonNull
    private String getButtonStateDescription() {
        int i10 = this.f28685n;
        return i10 == 1 ? getResources().getString(i.f24879h) : i10 == 0 ? getResources().getString(i.f24881j) : getResources().getString(i.f24880i);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f28674c == null) {
            int[][] iArr = f28670x;
            int[] iArr2 = new int[iArr.length];
            int iD = n4.a.d(this, e4.b.f24749f);
            int iD2 = n4.a.d(this, e4.b.f24751h);
            int iD3 = n4.a.d(this, e4.b.f24756m);
            int iD4 = n4.a.d(this, e4.b.f24752i);
            iArr2[0] = n4.a.j(iD3, iD2, 1.0f);
            iArr2[1] = n4.a.j(iD3, iD, 1.0f);
            iArr2[2] = n4.a.j(iD3, iD4, 0.54f);
            iArr2[3] = n4.a.j(iD3, iD4, 0.38f);
            iArr2[4] = n4.a.j(iD3, iD4, 0.38f);
            this.f28674c = new ColorStateList(iArr, iArr2);
        }
        return this.f28674c;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f28682k;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    private void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f28679h;
        if (drawable != null && (colorStateList2 = this.f28682k) != null) {
            DrawableCompat.setTintList(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f28680i;
        if (drawable2 == null || (colorStateList = this.f28683l) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable2, colorStateList);
    }

    public boolean d() {
        return this.f28677f;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.f28679h;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f28680i;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.f28683l;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f28684m;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.f28682k;
    }

    public int getCheckedState() {
        return this.f28685n;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.f28678g;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f28685n == 1;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f28675d && this.f28682k == null && this.f28683l == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f28668v);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f28669w);
        }
        this.f28686o = com.google.android.material.drawable.b.e(iArrOnCreateDrawableState);
        i();
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.f28676e || !TextUtils.isEmpty(getText()) || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (s.g(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            DrawableCompat.setHotspotBounds(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f28678g));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setCheckedState(dVar.f28693a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f28693a = getCheckedState();
        return dVar;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i10) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i10));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f28680i = drawable;
        e();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i10) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), i10));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f28683l == colorStateList) {
            return;
        }
        this.f28683l = colorStateList;
        e();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f28684m == mode) {
            return;
        }
        this.f28684m = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.f28682k == colorStateList) {
            return;
        }
        this.f28682k = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f28676e = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f28685n != i10) {
            this.f28685n = i10;
            super.setChecked(i10 == 1);
            refreshDrawableState();
            f();
            if (this.f28687p) {
                return;
            }
            this.f28687p = true;
            LinkedHashSet<InterfaceC0594b> linkedHashSet = this.f28673b;
            if (linkedHashSet != null) {
                Iterator<InterfaceC0594b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f28685n);
                }
            }
            if (this.f28685n != 2 && (onCheckedChangeListener = this.f28689r) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f28687p = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        i();
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.f28678g = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f28677f == z10) {
            return;
        }
        this.f28677f = z10;
        refreshDrawableState();
        Iterator<c> it = this.f28672a.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f28677f);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f28689r = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.f28688q = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f28675d = z10;
        if (z10) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Context context, @Nullable AttributeSet attributeSet, int i10) {
        int i11 = f28667u;
        super(b5.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f28672a = new LinkedHashSet<>();
        this.f28673b = new LinkedHashSet<>();
        this.f28690s = AnimatedVectorDrawableCompat.create(getContext(), e.f24814g);
        this.f28691t = new a();
        Context context2 = getContext();
        this.f28679h = CompoundButtonCompat.getButtonDrawable(this);
        this.f28682k = getSuperButtonTintList();
        setSupportButtonTintList(null);
        TintTypedArray tintTypedArrayJ = p.j(context2, attributeSet, k.Z2, i10, i11, new int[0]);
        this.f28680i = tintTypedArrayJ.getDrawable(k.f24938c3);
        if (this.f28679h != null && p.g(context2) && c(tintTypedArrayJ)) {
            super.setButtonDrawable((Drawable) null);
            this.f28679h = AppCompatResources.getDrawable(context2, e.f24813f);
            this.f28681j = true;
            if (this.f28680i == null) {
                this.f28680i = AppCompatResources.getDrawable(context2, e.f24815h);
            }
        }
        this.f28683l = u4.c.b(context2, tintTypedArrayJ, k.f24946d3);
        this.f28684m = s.i(tintTypedArrayJ.getInt(k.f24954e3, -1), PorterDuff.Mode.SRC_IN);
        this.f28675d = tintTypedArrayJ.getBoolean(k.f24994j3, false);
        this.f28676e = tintTypedArrayJ.getBoolean(k.f24962f3, true);
        this.f28677f = tintTypedArrayJ.getBoolean(k.f24986i3, false);
        this.f28678g = tintTypedArrayJ.getText(k.f24978h3);
        int i12 = k.f24970g3;
        if (tintTypedArrayJ.hasValue(i12)) {
            setCheckedState(tintTypedArrayJ.getInt(i12, 0));
        }
        tintTypedArrayJ.recycle();
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.f28679h = drawable;
        this.f28681j = false;
        e();
    }

    private void i() {
    }
}
