package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;

    @NonNull
    private final CompoundButton mView;

    AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable drawableMutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.mHasButtonTint) {
                    DrawableCompat.setTintList(drawableMutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    DrawableCompat.setTintMode(drawableMutate, this.mButtonTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.mView.getDrawableState());
                }
                this.mView.setButtonDrawable(drawableMutate);
            }
        }
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(@Nullable AttributeSet attributeSet, int i10) {
        boolean z10;
        int resourceId;
        int resourceId2;
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.CompoundButton;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        CompoundButton compoundButton = this.mView;
        ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), iArr, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        try {
            int i11 = R.styleable.CompoundButton_buttonCompat;
            if (!tintTypedArrayObtainStyledAttributes.hasValue(i11) || (resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(i11, 0)) == 0) {
                z10 = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.mView;
                    compoundButton2.setButtonDrawable(AppCompatResources.getDrawable(compoundButton2.getContext(), resourceId2));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                    z10 = false;
                }
            }
            if (!z10) {
                int i12 = R.styleable.CompoundButton_android_button;
                if (tintTypedArrayObtainStyledAttributes.hasValue(i12) && (resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(i12, 0)) != 0) {
                    CompoundButton compoundButton3 = this.mView;
                    compoundButton3.setButtonDrawable(AppCompatResources.getDrawable(compoundButton3.getContext(), resourceId));
                }
            }
            int i13 = R.styleable.CompoundButton_buttonTint;
            if (tintTypedArrayObtainStyledAttributes.hasValue(i13)) {
                CompoundButtonCompat.setButtonTintList(this.mView, tintTypedArrayObtainStyledAttributes.getColorStateList(i13));
            }
            int i14 = R.styleable.CompoundButton_buttonTintMode;
            if (tintTypedArrayObtainStyledAttributes.hasValue(i14)) {
                CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(i14, -1), null));
            }
        } finally {
            tintTypedArrayObtainStyledAttributes.recycle();
        }
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
        } else {
            this.mSkipNextApply = true;
            applyButtonTint();
        }
    }

    void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }

    int getCompoundPaddingLeft(int i10) {
        return i10;
    }
}
