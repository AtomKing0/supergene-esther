package a5;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import e4.k;
import u4.b;
import u4.c;

/* JADX INFO: compiled from: MaterialTextView.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AppCompatTextView {
    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void a(@NonNull Resources.Theme theme, int i10) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i10, k.f25074t3);
        int iE = e(getContext(), typedArrayObtainStyledAttributes, k.f25090v3, k.f25098w3);
        typedArrayObtainStyledAttributes.recycle();
        if (iE >= 0) {
            setLineHeight(iE);
        }
    }

    private static boolean b(Context context) {
        return b.b(context, e4.b.X, true);
    }

    private static int c(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.f25106x3, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k.f25114y3, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private void d(@Nullable AttributeSet attributeSet, int i10, int i11) {
        int iC;
        Context context = getContext();
        if (b(context)) {
            Resources.Theme theme = context.getTheme();
            if (f(context, theme, attributeSet, i10, i11) || (iC = c(theme, attributeSet, i10, i11)) == -1) {
                return;
            }
            a(theme, iC);
        }
    }

    private static int e(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int iC = -1;
        for (int i10 = 0; i10 < iArr.length && iC < 0; i10++) {
            iC = c.c(context, typedArray, iArr[i10], -1);
        }
        return iC;
    }

    private static boolean f(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.f25106x3, i10, i11);
        int iE = e(context, typedArrayObtainStyledAttributes, k.f25122z3, k.A3);
        typedArrayObtainStyledAttributes.recycle();
        return iE != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i10) {
        super.setTextAppearance(context, i10);
        if (b(context)) {
            a(context.getTheme(), i10);
        }
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(b5.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        d(attributeSet, i10, 0);
    }
}
