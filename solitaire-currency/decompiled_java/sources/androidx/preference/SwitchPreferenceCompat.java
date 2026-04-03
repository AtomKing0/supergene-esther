package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;

    private class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (SwitchPreferenceCompat.this.callChangeListener(Boolean.valueOf(z10))) {
                SwitchPreferenceCompat.this.setChecked(z10);
            } else {
                compoundButton.setChecked(!z10);
            }
        }
    }

    public SwitchPreferenceCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mListener = new Listener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreferenceCompat, i10, i11);
        setSummaryOn(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOn, R.styleable.SwitchPreferenceCompat_android_summaryOn));
        setSummaryOff(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOff, R.styleable.SwitchPreferenceCompat_android_summaryOff));
        setSwitchTextOn(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOn, R.styleable.SwitchPreferenceCompat_android_switchTextOn));
        setSwitchTextOff(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOff, R.styleable.SwitchPreferenceCompat_android_switchTextOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_disableDependentsState, R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void syncSwitchView(View view) {
        boolean z10 = view instanceof SwitchCompat;
        if (z10) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z10) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.mSwitchOn);
            switchCompat.setTextOff(this.mSwitchOff);
            switchCompat.setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            syncSwitchView(view.findViewById(R.id.switchWidget));
            syncSummaryView(view.findViewById(android.R.id.summary));
        }
    }

    @Nullable
    public CharSequence getSwitchTextOff() {
        return this.mSwitchOff;
    }

    @Nullable
    public CharSequence getSwitchTextOn() {
        return this.mSwitchOn;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncSwitchView(preferenceViewHolder.findViewById(R.id.switchWidget));
        syncSummaryView(preferenceViewHolder);
    }

    @Override // androidx.preference.Preference
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected void performClick(@NonNull View view) {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public void setSwitchTextOff(@Nullable CharSequence charSequence) {
        this.mSwitchOff = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOn(@Nullable CharSequence charSequence) {
        this.mSwitchOn = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOff(int i10) {
        setSwitchTextOff(getContext().getString(i10));
    }

    public void setSwitchTextOn(int i10) {
        setSwitchTextOn(getContext().getString(i10));
    }

    public SwitchPreferenceCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SwitchPreferenceCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(@NonNull Context context) {
        this(context, null);
    }
}
