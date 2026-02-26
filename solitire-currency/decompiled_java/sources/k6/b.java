package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.king.amp.sa.NewAbmMediaPlayerChapterAdIndicatorView;

/* JADX INFO: compiled from: AbmChapterFragmentBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f29696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final NewAbmMediaPlayerChapterAdIndicatorView f29697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f29698c;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull NewAbmMediaPlayerChapterAdIndicatorView newAbmMediaPlayerChapterAdIndicatorView, @NonNull ViewPager2 viewPager2) {
        this.f29696a = constraintLayout;
        this.f29697b = newAbmMediaPlayerChapterAdIndicatorView;
        this.f29698c = viewPager2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = j6.f.f28719g;
        NewAbmMediaPlayerChapterAdIndicatorView newAbmMediaPlayerChapterAdIndicatorView = (NewAbmMediaPlayerChapterAdIndicatorView) ViewBindings.findChildViewById(view, i10);
        if (newAbmMediaPlayerChapterAdIndicatorView != null) {
            i10 = j6.f.f28720h;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i10);
            if (viewPager2 != null) {
                return new b((ConstraintLayout) view, newAbmMediaPlayerChapterAdIndicatorView, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(j6.g.f28740b, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f29696a;
    }
}
