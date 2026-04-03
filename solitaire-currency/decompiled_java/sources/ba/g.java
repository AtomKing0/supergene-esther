package ba;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SerialDescriptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: compiled from: SerialDescriptor.kt */
    public static final class a implements Iterator<SerialDescriptor>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SerialDescriptor f2313b;

        a(SerialDescriptor serialDescriptor) {
            this.f2313b = serialDescriptor;
            this.f2312a = serialDescriptor.d();
        }

        @Override // java.util.Iterator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SerialDescriptor next() {
            SerialDescriptor serialDescriptor = this.f2313b;
            int iD = serialDescriptor.d();
            int i10 = this.f2312a;
            this.f2312a = i10 - 1;
            return serialDescriptor.g(iD - i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2312a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: SerialDescriptor.kt */
    public static final class b implements Iterator<String>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SerialDescriptor f2315b;

        b(SerialDescriptor serialDescriptor) {
            this.f2315b = serialDescriptor;
            this.f2314a = serialDescriptor.d();
        }

        @Override // java.util.Iterator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            SerialDescriptor serialDescriptor = this.f2315b;
            int iD = serialDescriptor.d();
            int i10 = this.f2314a;
            this.f2314a = i10 - 1;
            return serialDescriptor.e(iD - i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2314a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: Iterables.kt */
    public static final class c implements Iterable<SerialDescriptor>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SerialDescriptor f2316a;

        public c(SerialDescriptor serialDescriptor) {
            this.f2316a = serialDescriptor;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<SerialDescriptor> iterator() {
            return new a(this.f2316a);
        }
    }

    /* JADX INFO: compiled from: Iterables.kt */
    public static final class d implements Iterable<String>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SerialDescriptor f2317a;

        public d(SerialDescriptor serialDescriptor) {
            this.f2317a = serialDescriptor;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<String> iterator() {
            return new b(this.f2317a);
        }
    }

    @NotNull
    public static final Iterable<SerialDescriptor> a(@NotNull SerialDescriptor serialDescriptor) {
        t.i(serialDescriptor, "<this>");
        return new c(serialDescriptor);
    }

    @NotNull
    public static final Iterable<String> b(@NotNull SerialDescriptor serialDescriptor) {
        t.i(serialDescriptor, "<this>");
        return new d(serialDescriptor);
    }
}
