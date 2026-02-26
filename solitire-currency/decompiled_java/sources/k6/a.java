package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: compiled from: AbmAdActivityBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f29678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f29679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageButton f29680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f29681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageButton f29682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ProgressBar f29683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageButton f29684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Button f29685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f29686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f29687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final FragmentContainerView f29688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f29689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f29690m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f29691n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final View f29692o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f29693p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f29694q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final ImageView f29695r;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageButton imageButton, @NonNull FrameLayout frameLayout, @NonNull ImageButton imageButton2, @NonNull ProgressBar progressBar, @NonNull ImageButton imageButton3, @NonNull Button button, @NonNull TextView textView, @NonNull View view, @NonNull FragmentContainerView fragmentContainerView, @NonNull ImageView imageView, @NonNull View view2, @NonNull View view3, @NonNull View view4, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView2) {
        this.f29678a = constraintLayout;
        this.f29679b = constraintLayout2;
        this.f29680c = imageButton;
        this.f29681d = frameLayout;
        this.f29682e = imageButton2;
        this.f29683f = progressBar;
        this.f29684g = imageButton3;
        this.f29685h = button;
        this.f29686i = textView;
        this.f29687j = view;
        this.f29688k = fragmentContainerView;
        this.f29689l = imageView;
        this.f29690m = view2;
        this.f29691n = view3;
        this.f29692o = view4;
        this.f29693p = textView2;
        this.f29694q = textView3;
        this.f29695r = imageView2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i10 = j6.f.f28714b;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i10);
        if (imageButton != null) {
            i10 = j6.f.f28715c;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
            if (frameLayout != null) {
                i10 = j6.f.f28716d;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i10);
                if (imageButton2 != null) {
                    i10 = j6.f.f28721i;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                    if (progressBar != null) {
                        i10 = j6.f.f28723k;
                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i10);
                        if (imageButton3 != null) {
                            i10 = j6.f.f28726n;
                            Button button = (Button) ViewBindings.findChildViewById(view, i10);
                            if (button != null) {
                                i10 = j6.f.f28727o;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i10 = j6.f.f28729q))) != null) {
                                    i10 = j6.f.f28732t;
                                    FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i10);
                                    if (fragmentContainerView != null) {
                                        i10 = j6.f.f28735w;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                        if (imageView != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i10 = j6.f.f28737y))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i10 = j6.f.C))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i10 = j6.f.D))) != null) {
                                            i10 = j6.f.H;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                            if (textView2 != null) {
                                                i10 = j6.f.I;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                if (textView3 != null) {
                                                    i10 = j6.f.J;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (imageView2 != null) {
                                                        return new a(constraintLayout, constraintLayout, imageButton, frameLayout, imageButton2, progressBar, imageButton3, button, textView, viewFindChildViewById, fragmentContainerView, imageView, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, textView2, textView3, imageView2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(j6.g.f28739a, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f29678a;
    }
}
