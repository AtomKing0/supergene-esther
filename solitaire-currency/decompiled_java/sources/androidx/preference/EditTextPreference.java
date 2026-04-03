package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

/* JADX INFO: loaded from: classes2.dex */
public class EditTextPreference extends DialogPreference {

    @Nullable
    private OnBindEditTextListener mOnBindEditTextListener;
    private String mText;

    public interface OnBindEditTextListener {
        void onBindEditText(@NonNull EditText editText);
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<EditTextPreference> {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        private SimpleSummaryProvider() {
        }

        @NonNull
        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider == null) {
                sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            return sSimpleSummaryProvider;
        }

        @Override // androidx.preference.Preference.SummaryProvider
        @Nullable
        public CharSequence provideSummary(@NonNull EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.getText()) ? editTextPreference.getContext().getString(R.string.not_set) : editTextPreference.getText();
        }
    }

    public EditTextPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, i10, i11);
        int i12 = R.styleable.EditTextPreference_useSimpleSummaryProvider;
        if (TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, i12, i12, false)) {
            setSummaryProvider(SimpleSummaryProvider.getInstance());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Nullable
    OnBindEditTextListener getOnBindEditTextListener() {
        return this.mOnBindEditTextListener;
    }

    @Nullable
    public String getText() {
        return this.mText;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(@NonNull TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.mText);
    }

    @Override // androidx.preference.Preference
    @Nullable
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.mText = getText();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        setText(getPersistedString((String) obj));
    }

    public void setOnBindEditTextListener(@Nullable OnBindEditTextListener onBindEditTextListener) {
        this.mOnBindEditTextListener = onBindEditTextListener;
    }

    public void setText(@Nullable String str) {
        boolean zShouldDisableDependents = shouldDisableDependents();
        this.mText = str;
        persistString(str);
        boolean zShouldDisableDependents2 = shouldDisableDependents();
        if (zShouldDisableDependents2 != zShouldDisableDependents) {
            notifyDependencyChange(zShouldDisableDependents2);
        }
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.mText) || super.shouldDisableDependents();
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.EditTextPreference.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        String mText;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.mText);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public EditTextPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
    }

    public EditTextPreference(@NonNull Context context) {
        this(context, null);
    }
}
