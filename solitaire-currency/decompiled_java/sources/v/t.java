package v;

import android.view.View;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Disposable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final View f34973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private volatile v0<? extends j> f34974b;

    public t(@NotNull View view, @NotNull v0<? extends j> v0Var) {
        this.f34973a = view;
        this.f34974b = v0Var;
    }

    public void a(@NotNull v0<? extends j> v0Var) {
        this.f34974b = v0Var;
    }
}
