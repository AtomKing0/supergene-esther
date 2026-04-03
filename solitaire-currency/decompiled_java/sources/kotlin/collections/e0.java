package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e0 implements ListIterator, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e0 f29773a = new e0();

    private e0() {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void previous() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
