package g2;

import com.google.auto.value.AutoValue;
import g2.a;

/* JADX INFO: compiled from: EventStoreConfig.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final e f25807a = a().f(10485760).d(200).b(10000).c(604800000).e(81920).a();

    /* JADX INFO: compiled from: EventStoreConfig.java */
    @AutoValue.Builder
    static abstract class a {
        a() {
        }

        abstract e a();

        abstract a b(int i10);

        abstract a c(long j10);

        abstract a d(int i10);

        abstract a e(int i10);

        abstract a f(long j10);
    }

    e() {
    }

    static a a() {
        return new a.b();
    }

    abstract int b();

    abstract long c();

    abstract int d();

    abstract int e();

    abstract long f();
}
