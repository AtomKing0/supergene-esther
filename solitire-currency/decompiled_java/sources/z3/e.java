package z3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;
import z3.e;

/* JADX INFO: compiled from: BandwidthMeter.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e {

    /* JADX INFO: compiled from: BandwidthMeter.java */
    public interface a {

        /* JADX INFO: renamed from: z3.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BandwidthMeter.java */
        public static final class C0762a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList<C0763a> f37382a = new CopyOnWriteArrayList<>();

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: z3.e$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BandwidthMeter.java */
            static final class C0763a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Handler f37383a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final a f37384b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private boolean f37385c;

                public C0763a(Handler handler, a aVar) {
                    this.f37383a = handler;
                    this.f37384b = aVar;
                }

                public void d() {
                    this.f37385c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(C0763a c0763a, int i10, long j10, long j11) {
                c0763a.f37384b.onBandwidthSample(i10, j10, j11);
            }

            public void b(Handler handler, a aVar) {
                a4.a.e(handler);
                a4.a.e(aVar);
                e(aVar);
                this.f37382a.add(new C0763a(handler, aVar));
            }

            public void c(final int i10, final long j10, final long j11) {
                for (final C0763a c0763a : this.f37382a) {
                    if (!c0763a.f37385c) {
                        c0763a.f37383a.post(new Runnable() { // from class: z3.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0762a.d(c0763a, i10, j10, j11);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                for (C0763a c0763a : this.f37382a) {
                    if (c0763a.f37384b == aVar) {
                        c0763a.d();
                        this.f37382a.remove(c0763a);
                    }
                }
            }
        }

        void onBandwidthSample(int i10, long j10, long j11);
    }

    void a(a aVar);

    void c(Handler handler, a aVar);

    @Nullable
    m0 getTransferListener();
}
