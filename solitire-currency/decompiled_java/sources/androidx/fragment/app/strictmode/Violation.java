package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Violation.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class Violation extends RuntimeException {

    @NotNull
    private final Fragment fragment;

    public /* synthetic */ Violation(Fragment fragment, String str, int i10, k kVar) {
        this(fragment, (i10 & 2) != 0 ? null : str);
    }

    @NotNull
    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Violation(@NotNull Fragment fragment, @Nullable String str) {
        super(str);
        t.i(fragment, "fragment");
        this.fragment = fragment;
    }
}
