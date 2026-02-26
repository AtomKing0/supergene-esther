package y0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ModelLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public interface n<Model, Data> {

    /* JADX INFO: compiled from: ModelLoader.java */
    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.f f36303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<r0.f> f36304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s0.d<Data> f36305c;

        public a(@NonNull r0.f fVar, @NonNull s0.d<Data> dVar) {
            this(fVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull r0.f fVar, @NonNull List<r0.f> list, @NonNull s0.d<Data> dVar) {
            this.f36303a = (r0.f) o1.j.d(fVar);
            this.f36304b = (List) o1.j.d(list);
            this.f36305c = (s0.d) o1.j.d(dVar);
        }
    }

    boolean a(@NonNull Model model);

    @Nullable
    a<Data> b(@NonNull Model model, int i10, int i11, @NonNull r0.h hVar);
}
