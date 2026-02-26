package oa;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f32302c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final int[] f32304b = new int[10];

    /* JADX INFO: compiled from: Settings.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public final int a(int i10) {
        return this.f32304b[i10];
    }

    public final int b() {
        if ((this.f32303a & 2) != 0) {
            return this.f32304b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.f32303a & 128) != 0) {
            return this.f32304b[7];
        }
        return 65535;
    }

    public final int d() {
        if ((this.f32303a & 16) != 0) {
            return this.f32304b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int e(int i10) {
        return (this.f32303a & 32) != 0 ? this.f32304b[5] : i10;
    }

    public final boolean f(int i10) {
        return ((1 << i10) & this.f32303a) != 0;
    }

    public final void g(@NotNull m other) {
        t.i(other, "other");
        int i10 = 0;
        while (i10 < 10) {
            int i11 = i10 + 1;
            if (other.f(i10)) {
                h(i10, other.a(i10));
            }
            i10 = i11;
        }
    }

    @NotNull
    public final m h(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f32304b;
            if (i10 < iArr.length) {
                this.f32303a = (1 << i10) | this.f32303a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f32303a);
    }
}
