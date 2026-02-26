package t4;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.internal.p;
import e4.b;
import e4.j;
import e4.k;
import u4.c;

/* JADX INFO: compiled from: MaterialRadioButton.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AppCompatRadioButton {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f34070c = j.f24912r;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f34071d = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private ColorStateList f34072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34073b;

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, b.M);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f34072a == null) {
            int iD = n4.a.d(this, b.f24749f);
            int iD2 = n4.a.d(this, b.f24752i);
            int iD3 = n4.a.d(this, b.f24756m);
            int[][] iArr = f34071d;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = n4.a.j(iD3, iD, 1.0f);
            iArr2[1] = n4.a.j(iD3, iD2, 0.54f);
            iArr2[2] = n4.a.j(iD3, iD2, 0.38f);
            iArr2[3] = n4.a.j(iD3, iD2, 0.38f);
            this.f34072a = new ColorStateList(iArr, iArr2);
        }
        return this.f34072a;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f34073b && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f34073b = z10;
        if (z10) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        int i11 = f34070c;
        super(b5.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayI = p.i(context2, attributeSet, k.f25018m3, i10, i11, new int[0]);
        int i12 = k.f25026n3;
        if (typedArrayI.hasValue(i12)) {
            CompoundButtonCompat.setButtonTintList(this, c.a(context2, typedArrayI, i12));
        }
        this.f34073b = typedArrayI.getBoolean(k.f25034o3, false);
        typedArrayI.recycle();
    }
}
