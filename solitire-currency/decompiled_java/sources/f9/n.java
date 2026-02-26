package f9;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes5.dex */
final class n implements o9.g<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final BufferedReader f25764a;

    /* JADX INFO: compiled from: ReadWrite.kt */
    public static final class a implements Iterator<String>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f25765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f25766b;

        a() {
        }

        @Override // java.util.Iterator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f25765a;
            this.f25765a = null;
            t.f(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f25765a == null && !this.f25766b) {
                String line = n.this.f25764a.readLine();
                this.f25765a = line;
                if (line == null) {
                    this.f25766b = true;
                }
            }
            return this.f25765a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public n(@NotNull BufferedReader reader) {
        t.i(reader, "reader");
        this.f25764a = reader;
    }

    @Override // o9.g
    @NotNull
    public Iterator<String> iterator() {
        return new a();
    }
}
