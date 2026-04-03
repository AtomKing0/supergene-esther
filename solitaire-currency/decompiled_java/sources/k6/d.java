package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.king.amp.sa.AbmWebView;

/* JADX INFO: compiled from: AbmHtmlFragmentBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f29702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f29703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AbmWebView f29704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProgressBar f29705d;

    private d(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull AbmWebView abmWebView, @NonNull ProgressBar progressBar) {
        this.f29702a = constraintLayout;
        this.f29703b = constraintLayout2;
        this.f29704c = abmWebView;
        this.f29705d = progressBar;
    }

    @NonNull
    public static d a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i10 = j6.f.f28713a;
        AbmWebView abmWebView = (AbmWebView) ViewBindings.findChildViewById(view, i10);
        if (abmWebView != null) {
            i10 = j6.f.f28734v;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
            if (progressBar != null) {
                return new d(constraintLayout, constraintLayout, abmWebView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(j6.g.f28742d, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f29702a;
    }
}
