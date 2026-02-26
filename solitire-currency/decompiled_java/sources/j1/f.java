package j1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import r0.k;

/* JADX INFO: compiled from: ResourceEncoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?>> f28624a = new ArrayList();

    /* JADX INFO: compiled from: ResourceEncoderRegistry.java */
    private static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f28625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final k<T> f28626b;

        a(@NonNull Class<T> cls, @NonNull k<T> kVar) {
            this.f28625a = cls;
            this.f28626b = kVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f28625a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull k<Z> kVar) {
        this.f28624a.add(new a<>(cls, kVar));
    }

    @Nullable
    public synchronized <Z> k<Z> b(@NonNull Class<Z> cls) {
        int size = this.f28624a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a<?> aVar = this.f28624a.get(i10);
            if (aVar.a(cls)) {
                return (k<Z>) aVar.f28626b;
            }
        }
        return null;
    }
}
