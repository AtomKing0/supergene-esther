package com.unity3d.player;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;

/* JADX INFO: loaded from: classes4.dex */
abstract class S implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f24001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected UnityPlayer f24002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected EditText f24003c = createEditText(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f24004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f24005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected F f24006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected G f24007g;

    public S(Context context, UnityPlayer unityPlayer) {
        this.f24001a = context;
        this.f24002b = unityPlayer;
    }

    public final String a() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.f24001a.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String strA = AbstractC3273y.a(currentInputMethodSubtype);
        if (strA != null && !strA.equals("")) {
            return strA;
        }
        return currentInputMethodSubtype.getMode() + " " + currentInputMethodSubtype.getExtraValue();
    }

    public abstract void a(boolean z10);

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f24002b.reportSoftInputStr(editable.toString(), 0, false);
        int selectionStart = this.f24003c.getSelectionStart();
        this.f24002b.reportSoftInputSelection(selectionStart, this.f24003c.getSelectionEnd() - selectionStart);
    }

    public final String b() {
        EditText editText = this.f24003c;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    public abstract void c();

    protected abstract EditText createEditText(S s10);

    public boolean d() {
        return this.f24005e;
    }

    public abstract void e();

    public final void f() {
        ((InputMethodManager) this.f24001a.getSystemService("input_method")).showSoftInput(this.f24003c, 0);
    }

    protected void invokeOnClose() {
        G g10 = this.f24007g;
        if (g10 != null) {
            ((C3256p0) g10).a();
        }
    }

    protected void setupTextInput(String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13, String str2, int i11) {
        this.f24003c.setOnEditorActionListener(new Q(this));
        this.f24003c.setBackgroundColor(-1);
        this.f24003c.setImeOptions(6);
        this.f24003c.setText(str);
        this.f24003c.setHint(str2);
        this.f24003c.setHintTextColor(1627389952);
        EditText editText = this.f24003c;
        int i12 = (z10 ? 32768 : 524288) | (z11 ? 131072 : 0) | (z12 ? 128 : 0);
        if (i10 >= 0 && i10 <= 11) {
            int i13 = new int[]{1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194}[i10];
            if ((i13 & 2) != 0) {
                i12 = (z12 ? 16 : 0) | i13;
            } else {
                i12 |= i13;
            }
        }
        editText.setInputType(i12);
        this.f24003c.setImeOptions(33554432);
        if (i11 > 0) {
            this.f24003c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i11)});
        }
        this.f24003c.addTextChangedListener(this);
        EditText editText2 = this.f24003c;
        editText2.setSelection(editText2.getText().length());
        this.f24003c.setClickable(true);
    }

    public void a(String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13, String str2, int i11, boolean z14, boolean z15) {
        this.f24005e = z15;
        setupTextInput(str, i10, z10, z11, z12, z13, str2, i11);
        a(z14);
    }

    public final void a(String str, boolean z10) {
        this.f24003c.setSelection(0, 0);
        this.f24002b.reportSoftInputStr(str, 1, z10);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
