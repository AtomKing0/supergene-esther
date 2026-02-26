package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: PickerFragment.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class s<S> extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final LinkedHashSet<r<S>> f9279a = new LinkedHashSet<>();

    s() {
    }

    boolean p(r<S> rVar) {
        return this.f9279a.add(rVar);
    }

    void q() {
        this.f9279a.clear();
    }
}
