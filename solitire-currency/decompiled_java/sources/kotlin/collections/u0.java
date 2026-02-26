package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u0<E> extends c<E> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<E> f29791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29793c;

    /* JADX WARN: Multi-variable type inference failed */
    public u0(@NotNull List<? extends E> list) {
        kotlin.jvm.internal.t.i(list, "list");
        this.f29791a = list;
    }

    public final void a(int i10, int i11) {
        c.Companion.d(i10, i11, this.f29791a.size());
        this.f29792b = i10;
        this.f29793c = i11 - i10;
    }

    @Override // kotlin.collections.c, java.util.List
    public E get(int i10) {
        c.Companion.b(i10, this.f29793c);
        return this.f29791a.get(this.f29792b + i10);
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f29793c;
    }
}
