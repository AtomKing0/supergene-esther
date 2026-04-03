package j1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EncoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C0592a<?>> f28610a = new ArrayList();

    /* JADX INFO: renamed from: j1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EncoderRegistry.java */
    private static final class C0592a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f28611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final r0.d<T> f28612b;

        C0592a(@NonNull Class<T> cls, @NonNull r0.d<T> dVar) {
            this.f28611a = cls;
            this.f28612b = dVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f28611a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull r0.d<T> dVar) {
        this.f28610a.add(new C0592a<>(cls, dVar));
    }

    @Nullable
    public synchronized <T> r0.d<T> b(@NonNull Class<T> cls) {
        for (C0592a<?> c0592a : this.f28610a) {
            if (c0592a.a(cls)) {
                return (r0.d<T>) c0592a.f28612b;
            }
        }
        return null;
    }
}
