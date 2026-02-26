package za;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import xa.ILoggerFactory;

/* JADX INFO: compiled from: SubstituteLoggerFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public class f implements ILoggerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f37639a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<String, e> f37640b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue<ya.d> f37641c = new LinkedBlockingQueue<>();

    @Override // xa.ILoggerFactory
    public synchronized xa.a a(String str) {
        e eVar;
        eVar = this.f37640b.get(str);
        if (eVar == null) {
            eVar = new e(str, this.f37641c, this.f37639a);
            this.f37640b.put(str, eVar);
        }
        return eVar;
    }

    public void b() {
        this.f37640b.clear();
        this.f37641c.clear();
    }

    public LinkedBlockingQueue<ya.d> c() {
        return this.f37641c;
    }

    public List<e> d() {
        return new ArrayList(this.f37640b.values());
    }

    public void e() {
        this.f37639a = true;
    }
}
