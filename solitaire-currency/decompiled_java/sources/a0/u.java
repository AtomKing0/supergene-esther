package a0;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Time.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f69a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static h9.a<Long> f70b = a.f71b;

    /* JADX INFO: compiled from: Time.kt */
    /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.a<Long> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f71b = new a();

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    private u() {
    }

    public final long a() {
        return f70b.invoke().longValue();
    }
}
