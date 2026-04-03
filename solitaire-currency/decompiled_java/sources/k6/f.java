package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: compiled from: AbmVideoFragmentBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f29711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f29712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final PlayerView f29713c;

    private f(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull PlayerView playerView) {
        this.f29711a = constraintLayout;
        this.f29712b = constraintLayout2;
        this.f29713c = playerView;
    }

    @NonNull
    public static f a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i10 = j6.f.K;
        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, i10);
        if (playerView != null) {
            return new f(constraintLayout, constraintLayout, playerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(j6.g.f28747i, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f29711a;
    }
}
