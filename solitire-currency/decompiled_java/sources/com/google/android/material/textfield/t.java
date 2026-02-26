package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TextInputLayout f9799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s f9800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f9801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final CheckableImageButton f9802d;

    t(@NonNull s sVar) {
        this.f9799a = sVar.f9769a;
        this.f9800b = sVar;
        this.f9801c = sVar.getContext();
        this.f9802d = sVar.r();
    }

    @StringRes
    int c() {
        return 0;
    }

    @DrawableRes
    int d() {
        return 0;
    }

    View.OnFocusChangeListener e() {
        return null;
    }

    View.OnClickListener f() {
        return null;
    }

    View.OnFocusChangeListener g() {
        return null;
    }

    AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    boolean i(int i10) {
        return true;
    }

    boolean j() {
        return false;
    }

    boolean k() {
        return false;
    }

    boolean l() {
        return false;
    }

    boolean m() {
        return false;
    }

    final void r() {
        this.f9800b.L(false);
    }

    boolean t() {
        return false;
    }

    void s() {
    }

    void u() {
    }

    void a(Editable editable) {
    }

    void n(@Nullable EditText editText) {
    }

    void q(boolean z10) {
    }

    void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    void b(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
