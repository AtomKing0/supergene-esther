package o9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
final class h<T> extends i<T> implements Iterator<T>, z8.d<k0>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private T f32064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Iterator<? extends T> f32065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private z8.d<? super k0> f32066d;

    private final Throwable f() {
        int i10 = this.f32063a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f32063a);
    }

    private final T g() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // o9.i
    @Nullable
    public Object a(T t10, @NotNull z8.d<? super k0> dVar) {
        this.f32064b = t10;
        this.f32063a = 3;
        this.f32066d = dVar;
        Object objE = a9.d.e();
        if (objE == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objE == a9.d.e() ? objE : k0.f35197a;
    }

    @Override // o9.i
    @Nullable
    public Object c(@NotNull Iterator<? extends T> it, @NotNull z8.d<? super k0> dVar) {
        if (!it.hasNext()) {
            return k0.f35197a;
        }
        this.f32065c = it;
        this.f32063a = 2;
        this.f32066d = dVar;
        Object objE = a9.d.e();
        if (objE == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objE == a9.d.e() ? objE : k0.f35197a;
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        return z8.h.f37608a;
    }

    public final void h(@Nullable z8.d<? super k0> dVar) {
        this.f32066d = dVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.f32063a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator<? extends T> it = this.f32065c;
                t.f(it);
                if (it.hasNext()) {
                    this.f32063a = 2;
                    return true;
                }
                this.f32065c = null;
            }
            this.f32063a = 5;
            z8.d<? super k0> dVar = this.f32066d;
            t.f(dVar);
            this.f32066d = null;
            t.a aVar = v8.t.f35208b;
            dVar.resumeWith(v8.t.b(k0.f35197a));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i10 = this.f32063a;
        if (i10 == 0 || i10 == 1) {
            return g();
        }
        if (i10 == 2) {
            this.f32063a = 1;
            Iterator<? extends T> it = this.f32065c;
            kotlin.jvm.internal.t.f(it);
            return it.next();
        }
        if (i10 != 3) {
            throw f();
        }
        this.f32063a = 0;
        T t10 = this.f32064b;
        this.f32064b = null;
        return t10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        u.b(obj);
        this.f32063a = 4;
    }
}
