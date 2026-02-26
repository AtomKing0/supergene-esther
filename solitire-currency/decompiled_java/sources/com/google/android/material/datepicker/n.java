package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialTextInputPicker.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class n<S> extends s<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @StyleRes
    private int f9251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private d<S> f9252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private com.google.android.material.datepicker.a f9253d;

    /* JADX INFO: compiled from: MaterialTextInputPicker.java */
    class a extends r<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.r
        public void a(S s10) {
            Iterator<r<S>> it = n.this.f9279a.iterator();
            while (it.hasNext()) {
                it.next().a(s10);
            }
        }
    }

    @NonNull
    static <T> n<T> r(d<T> dVar, @StyleRes int i10, @NonNull com.google.android.material.datepicker.a aVar) {
        n<T> nVar = new n<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        nVar.setArguments(bundle);
        return nVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9251b = bundle.getInt("THEME_RES_ID_KEY");
        this.f9252c = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f9253d = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f9252c.O(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f9251b)), viewGroup, bundle, this.f9253d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f9251b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f9252c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f9253d);
    }
}
