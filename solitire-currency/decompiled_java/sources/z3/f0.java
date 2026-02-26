package z3;

import java.io.IOException;

/* JADX INFO: compiled from: LoadErrorHandlingPolicy.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f0 {

    /* JADX INFO: compiled from: LoadErrorHandlingPolicy.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l3.t f37390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l3.w f37391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IOException f37392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f37393d;

        public a(l3.t tVar, l3.w wVar, IOException iOException, int i10) {
            this.f37390a = tVar;
            this.f37391b = wVar;
            this.f37392c = iOException;
            this.f37393d = i10;
        }
    }

    long a(a aVar);

    int getMinimumLoadableRetryCount(int i10);

    void onLoadTaskConcluded(long j10);
}
