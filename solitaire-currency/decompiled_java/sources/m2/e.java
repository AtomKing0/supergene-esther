package m2;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.ironsource.mediationsdk.logger.IronSourceError;
import k2.h;

/* JADX INFO: compiled from: AudioAttributes.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements k2.h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f31249g = new C0628e().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h.a<e> f31250h = new h.a() { // from class: m2.d
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return e.d(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f31253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f31254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f31255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private d f31256f;

    /* JADX INFO: compiled from: AudioAttributes.java */
    @RequiresApi(29)
    private static final class b {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i10) {
            builder.setAllowedCapturePolicy(i10);
        }
    }

    /* JADX INFO: compiled from: AudioAttributes.java */
    @RequiresApi(32)
    private static final class c {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i10) {
            builder.setSpatializationBehavior(i10);
        }
    }

    /* JADX INFO: compiled from: AudioAttributes.java */
    @RequiresApi(21)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes f31257a;

        private d(e eVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(eVar.f31251a).setFlags(eVar.f31252b).setUsage(eVar.f31253c);
            int i10 = a4.o0.f214a;
            if (i10 >= 29) {
                b.a(usage, eVar.f31254d);
            }
            if (i10 >= 32) {
                c.a(usage, eVar.f31255e);
            }
            this.f31257a = usage.build();
        }
    }

    /* JADX INFO: renamed from: m2.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AudioAttributes.java */
    public static final class C0628e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f31258a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f31259b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f31260c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f31261d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f31262e = 0;

        public e a() {
            return new e(this.f31258a, this.f31259b, this.f31260c, this.f31261d, this.f31262e);
        }

        public C0628e b(int i10) {
            this.f31261d = i10;
            return this;
        }

        public C0628e c(int i10) {
            this.f31258a = i10;
            return this;
        }

        public C0628e d(int i10) {
            this.f31259b = i10;
            return this;
        }

        public C0628e e(int i10) {
            this.f31262e = i10;
            return this;
        }

        public C0628e f(int i10) {
            this.f31260c = i10;
            return this;
        }
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e d(Bundle bundle) {
        C0628e c0628e = new C0628e();
        if (bundle.containsKey(c(0))) {
            c0628e.c(bundle.getInt(c(0)));
        }
        if (bundle.containsKey(c(1))) {
            c0628e.d(bundle.getInt(c(1)));
        }
        if (bundle.containsKey(c(2))) {
            c0628e.f(bundle.getInt(c(2)));
        }
        if (bundle.containsKey(c(3))) {
            c0628e.b(bundle.getInt(c(3)));
        }
        if (bundle.containsKey(c(4))) {
            c0628e.e(bundle.getInt(c(4)));
        }
        return c0628e.a();
    }

    @RequiresApi(21)
    public d b() {
        if (this.f31256f == null) {
            this.f31256f = new d();
        }
        return this.f31256f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f31251a == eVar.f31251a && this.f31252b == eVar.f31252b && this.f31253c == eVar.f31253c && this.f31254d == eVar.f31254d && this.f31255e == eVar.f31255e;
    }

    public int hashCode() {
        return ((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f31251a) * 31) + this.f31252b) * 31) + this.f31253c) * 31) + this.f31254d) * 31) + this.f31255e;
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), this.f31251a);
        bundle.putInt(c(1), this.f31252b);
        bundle.putInt(c(2), this.f31253c);
        bundle.putInt(c(3), this.f31254d);
        bundle.putInt(c(4), this.f31255e);
        return bundle;
    }

    private e(int i10, int i11, int i12, int i13, int i14) {
        this.f31251a = i10;
        this.f31252b = i11;
        this.f31253c = i12;
        this.f31254d = i13;
        this.f31255e = i14;
    }
}
