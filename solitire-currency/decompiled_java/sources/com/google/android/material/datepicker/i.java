package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
class i extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9174d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Calendar f9175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9177c;

    static {
        f9174d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public i() {
        Calendar calendarK = a0.k();
        this.f9175a = calendarK;
        this.f9176b = calendarK.getMaximum(7);
        this.f9177c = calendarK.getFirstDayOfWeek();
    }

    private int b(int i10) {
        int i11 = i10 + this.f9177c;
        int i12 = this.f9176b;
        return i11 > i12 ? i11 - i12 : i11;
    }

    @Override // android.widget.Adapter
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i10) {
        if (i10 >= this.f9176b) {
            return null;
        }
        return Integer.valueOf(b(i10));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9176b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i10, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e4.h.f24863o, viewGroup, false);
        }
        this.f9175a.set(7, b(i10));
        textView.setText(this.f9175a.getDisplayName(7, f9174d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(e4.i.f24883l), this.f9175a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public i(int i10) {
        Calendar calendarK = a0.k();
        this.f9175a = calendarK;
        this.f9176b = calendarK.getMaximum(7);
        this.f9177c = i10;
    }
}
