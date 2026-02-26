package u0;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DecodePath.java */
/* JADX INFO: loaded from: classes2.dex */
public class i<DataType, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<DataType> f34316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends r0.j<DataType, ResourceType>> f34317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g1.e<ResourceType, Transcode> f34318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f34319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f34320e;

    /* JADX INFO: compiled from: DecodePath.java */
    interface a<ResourceType> {
        @NonNull
        v<ResourceType> a(@NonNull v<ResourceType> vVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends r0.j<DataType, ResourceType>> list, g1.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f34316a = cls;
        this.f34317b = list;
        this.f34318c = eVar;
        this.f34319d = pool;
        this.f34320e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private v<ResourceType> b(s0.e<DataType> eVar, int i10, int i11, @NonNull r0.h hVar) throws q {
        List<Throwable> list = (List) o1.j.d(this.f34319d.acquire());
        try {
            return c(eVar, i10, i11, hVar, list);
        } finally {
            this.f34319d.release(list);
        }
    }

    @NonNull
    private v<ResourceType> c(s0.e<DataType> eVar, int i10, int i11, @NonNull r0.h hVar, List<Throwable> list) throws q {
        int size = this.f34317b.size();
        v<ResourceType> vVarB = null;
        for (int i12 = 0; i12 < size; i12++) {
            r0.j<DataType, ResourceType> jVar = this.f34317b.get(i12);
            try {
                if (jVar.a(eVar.a(), hVar)) {
                    vVarB = jVar.b(eVar.a(), i10, i11, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e10);
                }
                list.add(e10);
            }
            if (vVarB != null) {
                break;
            }
        }
        if (vVarB != null) {
            return vVarB;
        }
        throw new q(this.f34320e, new ArrayList(list));
    }

    public v<Transcode> a(s0.e<DataType> eVar, int i10, int i11, @NonNull r0.h hVar, a<ResourceType> aVar) throws q {
        return this.f34318c.a(aVar.a(b(eVar, i10, i11, hVar)), hVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f34316a + ", decoders=" + this.f34317b + ", transcoder=" + this.f34318c + '}';
    }
}
