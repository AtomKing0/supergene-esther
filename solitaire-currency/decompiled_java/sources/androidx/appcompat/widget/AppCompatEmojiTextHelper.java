package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiTextHelper {

    @NonNull
    private final EmojiTextViewHelper mEmojiTextViewHelper;

    @NonNull
    private final TextView mView;

    AppCompatEmojiTextHelper(@NonNull TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(textView, false);
    }

    @NonNull
    InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
        return this.mEmojiTextViewHelper.getFilters(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    void loadFromAttributes(@Nullable AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z10);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void setAllCaps(boolean z10) {
        this.mEmojiTextViewHelper.setAllCaps(z10);
    }

    void setEnabled(boolean z10) {
        this.mEmojiTextViewHelper.setEnabled(z10);
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(transformationMethod);
    }
}
