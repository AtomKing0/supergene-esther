package u0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import u0.i;

/* JADX INFO: compiled from: LoadPath.java */
/* JADX INFO: loaded from: classes2.dex */
public class t<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<Data> f34411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f34412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f34413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f34414d;

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f34411a = cls;
        this.f34412b = pool;
        this.f34413c = (List) o1.j.c(list);
        this.f34414d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private v<Transcode> b(s0.e<Data> eVar, @NonNull r0.h hVar, int i10, int i11, i.a<ResourceType> aVar, List<Throwable> list) throws q {
        int size = this.f34413c.size();
        v<Transcode> vVarA = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                vVarA = this.f34413c.get(i12).a(eVar, i10, i11, hVar, aVar);
            } catch (q e10) {
                list.add(e10);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f34414d, new ArrayList(list));
    }

    public v<Transcode> a(s0.e<Data> eVar, @NonNull r0.h hVar, int i10, int i11, i.a<ResourceType> aVar) throws q {
        List<Throwable> list = (List) o1.j.d(this.f34412b.acquire());
        try {
            return b(eVar, hVar, i10, i11, aVar, list);
        } finally {
            this.f34412b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f34413c.toArray()) + '}';
    }
}
