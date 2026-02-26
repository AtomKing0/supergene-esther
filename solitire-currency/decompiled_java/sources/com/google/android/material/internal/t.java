package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: VisibilityAwareImageButton.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class t extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9499a;

    public final void b(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f9499a = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f9499a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        b(i10, true);
    }
}
