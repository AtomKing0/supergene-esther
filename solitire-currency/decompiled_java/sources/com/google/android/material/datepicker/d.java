package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.util.Collection;

/* JADX INFO: compiled from: DateSelector.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface d<S> extends Parcelable {
    @NonNull
    String B(Context context);

    @NonNull
    Collection<Pair<Long, Long>> J();

    @NonNull
    View O(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull a aVar, @NonNull r<S> rVar);

    boolean R();

    @NonNull
    Collection<Long> S();

    @Nullable
    S W();

    void h0(long j10);

    @NonNull
    String q(@NonNull Context context);

    @StyleRes
    int x(Context context);
}
