package x3;

import k2.n3;
import k2.o1;
import l3.a0;
import l3.c1;

/* JADX INFO: compiled from: ExoTrackSelection.java */
/* JADX INFO: loaded from: classes2.dex */
public interface s extends v {

    /* JADX INFO: compiled from: ExoTrackSelection.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c1 f36012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f36013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f36014c;

        public a(c1 c1Var, int... iArr) {
            this(c1Var, iArr, 0);
        }

        public a(c1 c1Var, int[] iArr, int i10) {
            if (iArr.length == 0) {
                a4.t.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f36012a = c1Var;
            this.f36013b = iArr;
            this.f36014c = i10;
        }
    }

    /* JADX INFO: compiled from: ExoTrackSelection.java */
    public interface b {
        s[] a(a[] aVarArr, z3.e eVar, a0.b bVar, n3 n3Var);
    }

    void disable();

    void enable();

    o1 getSelectedFormat();

    int getSelectedIndex();

    void onDiscontinuity();

    void onPlayWhenReadyChanged(boolean z10);

    void onPlaybackSpeed(float f10);

    void onRebuffer();
}
