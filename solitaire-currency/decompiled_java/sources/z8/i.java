package z8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: SafeContinuationJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i<T> implements d<T>, kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f37609b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<i<?>, Object> f37610c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "result");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d<T> f37611a;

    @Nullable
    private volatile Object result;

    /* JADX INFO: compiled from: SafeContinuationJvm.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull d<? super T> delegate, @Nullable Object obj) {
        t.i(delegate, "delegate");
        this.f37611a = delegate;
        this.result = obj;
    }

    @Nullable
    public final Object a() throws Throwable {
        Object obj = this.result;
        a9.a aVar = a9.a.f377b;
        if (obj == aVar) {
            if (androidx.concurrent.futures.a.a(f37610c, this, aVar, a9.d.e())) {
                return a9.d.e();
            }
            obj = this.result;
        }
        if (obj == a9.a.f378c) {
            return a9.d.e();
        }
        if (obj instanceof t.b) {
            throw ((t.b) obj).f35210a;
        }
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @Nullable
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        d<T> dVar = this.f37611a;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // z8.d
    @NotNull
    public g getContext() {
        return this.f37611a.getContext();
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        while (true) {
            Object obj2 = this.result;
            a9.a aVar = a9.a.f377b;
            if (obj2 == aVar) {
                if (androidx.concurrent.futures.a.a(f37610c, this, aVar, obj)) {
                    return;
                }
            } else {
                if (obj2 != a9.d.e()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.a.a(f37610c, this, a9.d.e(), a9.a.f378c)) {
                    this.f37611a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    @NotNull
    public String toString() {
        return "SafeContinuation for " + this.f37611a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(@NotNull d<? super T> delegate) {
        this(delegate, a9.a.f377b);
        kotlin.jvm.internal.t.i(delegate, "delegate");
    }
}
