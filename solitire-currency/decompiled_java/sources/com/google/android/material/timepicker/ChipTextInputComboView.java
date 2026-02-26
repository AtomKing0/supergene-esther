package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.o;
import com.google.android.material.internal.s;
import com.google.android.material.textfield.TextInputLayout;
import e4.h;

/* JADX INFO: loaded from: classes3.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chip f9851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f9852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EditText f9853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextWatcher f9854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f9855e;

    private class b extends o {
        private b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f9851a.setText(ChipTextInputComboView.this.c("00"));
                return;
            }
            String strC = ChipTextInputComboView.this.c(editable);
            Chip chip = ChipTextInputComboView.this.f9851a;
            if (TextUtils.isEmpty(strC)) {
                strC = ChipTextInputComboView.this.c("00");
            }
            chip.setText(strC);
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return f.a(getResources(), charSequence);
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f9853c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9851a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        this.f9851a.setChecked(z10);
        this.f9853c.setVisibility(z10 ? 0 : 4);
        this.f9851a.setVisibility(z10 ? 8 : 0);
        if (isChecked()) {
            s.k(this.f9853c, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f9851a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        this.f9851a.setTag(i10, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f9851a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(h.f24858j, (ViewGroup) this, false);
        this.f9851a = chip;
        chip.setAccessibilityClassName(AndroidComposeViewAccessibilityDelegateCompat.ClassName);
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(h.f24859k, (ViewGroup) this, false);
        this.f9852b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f9853c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f9854d = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f9855e = (TextView) findViewById(e4.f.f24835p);
        editText.setId(ViewCompat.generateViewId());
        ViewCompat.setLabelFor(this.f9855e, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
