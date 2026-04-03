package x3;

import androidx.annotation.Nullable;
import l3.c1;

/* JADX INFO: compiled from: FixedTrackSelection.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f36015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final Object f36016i;

    public t(c1 c1Var, int i10, int i11) {
        this(c1Var, i10, i11, 0, null);
    }

    @Override // x3.s
    public int getSelectedIndex() {
        return 0;
    }

    public t(c1 c1Var, int i10, int i11, int i12, @Nullable Object obj) {
        super(c1Var, new int[]{i10}, i11);
        this.f36015h = i12;
        this.f36016i = obj;
    }
}
