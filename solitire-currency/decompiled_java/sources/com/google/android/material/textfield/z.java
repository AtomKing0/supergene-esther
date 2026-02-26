package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
class z extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private EditText f9849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View.OnClickListener f9850g;

    z(@NonNull s sVar, @DrawableRes int i10) {
        super(sVar);
        this.f9848e = e4.e.f24808a;
        this.f9850g = new View.OnClickListener() { // from class: com.google.android.material.textfield.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9847a.y(view);
            }
        };
        if (i10 != 0) {
            this.f9848e = i10;
        }
    }

    private boolean w() {
        EditText editText = this.f9849f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f9849f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (w()) {
            this.f9849f.setTransformationMethod(null);
        } else {
            this.f9849f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f9849f.setSelection(selectionEnd);
        }
        r();
    }

    @Override // com.google.android.material.textfield.t
    void b(CharSequence charSequence, int i10, int i11, int i12) {
        r();
    }

    @Override // com.google.android.material.textfield.t
    @StringRes
    int c() {
        return e4.i.f24893v;
    }

    @Override // com.google.android.material.textfield.t
    @DrawableRes
    int d() {
        return this.f9848e;
    }

    @Override // com.google.android.material.textfield.t
    View.OnClickListener f() {
        return this.f9850g;
    }

    @Override // com.google.android.material.textfield.t
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.t
    void n(@Nullable EditText editText) {
        this.f9849f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.t
    void s() {
        if (x(this.f9849f)) {
            this.f9849f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.t
    void u() {
        EditText editText = this.f9849f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
