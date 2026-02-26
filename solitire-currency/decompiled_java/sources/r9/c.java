package r9;

import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;
import u9.h0;
import u9.k0;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final i<Object> f33369a = new i<>(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33370b = k0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f33371c = k0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final h0 f33372d = new h0("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final h0 f33373e = new h0("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final h0 f33374f = new h0("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final h0 f33375g = new h0("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final h0 f33376h = new h0("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final h0 f33377i = new h0("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final h0 f33378j = new h0("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final h0 f33379k = new h0("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final h0 f33380l = new h0("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private static final h0 f33381m = new h0("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private static final h0 f33382n = new h0("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private static final h0 f33383o = new h0("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private static final h0 f33384p = new h0("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private static final h0 f33385q = new h0("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private static final h0 f33386r = new h0("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private static final h0 f33387s = new h0("NO_CLOSE_CAUSE");

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: BufferedChannel.kt */
    /* synthetic */ class a<E> extends kotlin.jvm.internal.q implements h9.p<Long, i<E>, i<E>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f33388b = new a();

        a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @NotNull
        public final i<E> a(long j10, @NotNull i<E> iVar) {
            return c.x(j10, iVar);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Long l10, Object obj) {
            return a(l10.longValue(), (i) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(kotlinx.coroutines.o<? super T> oVar, T t10, h9.l<? super Throwable, v8.k0> lVar) {
        Object objK = oVar.k(t10, null, lVar);
        if (objK == null) {
            return false;
        }
        oVar.u(objK);
        return true;
    }

    static /* synthetic */ boolean C(kotlinx.coroutines.o oVar, Object obj, h9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        return B(oVar, obj, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j10, int i10) {
        return (((long) i10) << 60) + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> i<E> x(long j10, i<E> iVar) {
        return new i<>(j10, iVar, iVar.u(), 0);
    }

    @NotNull
    public static final <E> KFunction<i<E>> y() {
        return a.f33388b;
    }

    @NotNull
    public static final h0 z() {
        return f33380l;
    }
}
