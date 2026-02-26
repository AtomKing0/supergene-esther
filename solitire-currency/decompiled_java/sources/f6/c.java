package f6;

import java.util.Iterator;
import java.util.Set;
import l5.r;

/* JADX INFO: compiled from: DefaultUserAgentPublisher.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f25714b;

    c(Set<f> set, d dVar) {
        this.f25713a = d(set);
        this.f25714b = dVar;
    }

    public static l5.c<i> b() {
        return l5.c.c(i.class).b(r.l(f.class)).f(new l5.h() { // from class: f6.b
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return c.c(eVar);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i c(l5.e eVar) {
        return new c(eVar.f(f.class), d.a());
    }

    private static String d(Set<f> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // f6.i
    public String getUserAgent() {
        if (this.f25714b.b().isEmpty()) {
            return this.f25713a;
        }
        return this.f25713a + ' ' + d(this.f25714b.b());
    }
}
