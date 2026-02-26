package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: compiled from: MaxInputValidator.java */
/* JADX INFO: loaded from: classes3.dex */
class c implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9906a;

    public c(int i10) {
        this.f9906a = i10;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i12, i13, charSequence.subSequence(i10, i11).toString());
            if (Integer.parseInt(sb.toString()) <= this.f9906a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
