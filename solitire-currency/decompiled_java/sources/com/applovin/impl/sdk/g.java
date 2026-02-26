package com.applovin.impl.sdk;

import com.applovin.impl.q2;
import com.ironsource.f5;
import com.ironsource.w8;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f7041b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f7042c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f7043d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f7044e = new Object();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f7047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f7048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f7049e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f7050f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f7051g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f7052h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f7053i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ArrayDeque f7054j;

        public String b() {
            return this.f7048d;
        }

        public String c() {
            return this.f7047c;
        }

        public String d() {
            return this.f7049e;
        }

        public String e() {
            return this.f7050f;
        }

        public String f() {
            return this.f7051g;
        }

        public String g() {
            return this.f7046b;
        }

        public int h() {
            return this.f7052h;
        }

        public c i() {
            return (c) this.f7054j.getLast();
        }

        public String toString() {
            return "AdInfo{state='" + i() + "', adUnitId='" + this.f7045a + "', format='" + this.f7046b + "', adapterName='" + this.f7047c + "', adapterClass='" + this.f7048d + "', adapterVersion='" + this.f7049e + "', bCode='" + this.f7050f + "', creativeId='" + this.f7051g + "', updated=" + this.f7053i + '}';
        }

        private b(q2 q2Var, c cVar) {
            this.f7054j = new ArrayDeque();
            this.f7045a = q2Var.getAdUnitId();
            this.f7046b = q2Var.getFormat().getLabel();
            this.f7047c = q2Var.c();
            this.f7048d = q2Var.b();
            this.f7049e = q2Var.z();
            this.f7050f = q2Var.C();
            this.f7051g = q2Var.getCreativeId();
            this.f7052h = q2Var.hashCode();
            a(cVar);
        }

        public String a() {
            return this.f7045a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            this.f7053i = System.currentTimeMillis();
            this.f7054j.add(cVar);
        }
    }

    public enum c {
        LOADING("loading"),
        LOAD("load"),
        SHOW(f5.f12054u),
        HIDE("hide"),
        CLICK(w8.f16021d),
        DESTROY("destroy"),
        SHOW_ERROR("show_error");


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Set f7062i = new HashSet(Arrays.asList(values()));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7064a;

        c(String str) {
            this.f7064a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f7064a;
        }
    }

    public interface d {
        void a(b bVar);
    }

    g(j jVar) {
        this.f7040a = jVar;
        a();
    }

    public void a(q2 q2Var, c cVar) {
        synchronized (this.f7044e) {
            int iHashCode = q2Var.hashCode();
            b bVar = (b) this.f7043d.get(Integer.valueOf(iHashCode));
            if (bVar == null) {
                if (cVar == c.DESTROY) {
                    return;
                }
                bVar = new b(q2Var, cVar);
                this.f7043d.put(Integer.valueOf(iHashCode), bVar);
            } else if (bVar.i() == cVar) {
                return;
            } else {
                bVar.a(cVar);
            }
            if (cVar == c.DESTROY) {
                this.f7043d.remove(Integer.valueOf(iHashCode));
            }
            a(bVar, cVar);
        }
    }

    public void a() {
        synchronized (this.f7042c) {
            for (c cVar : c.values()) {
                this.f7041b.put(cVar, new HashSet());
            }
        }
    }

    public void a(d dVar, Set set) {
        synchronized (this.f7042c) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                a((c) it.next()).add(dVar);
            }
        }
    }

    public void a(d dVar) {
        synchronized (this.f7042c) {
            Iterator it = this.f7041b.keySet().iterator();
            while (it.hasNext()) {
                a((c) it.next()).remove(dVar);
            }
        }
    }

    private Set a(c cVar) {
        synchronized (this.f7042c) {
            Set set = (Set) this.f7041b.get(cVar);
            if (com.applovin.impl.e1.a(set)) {
                return set;
            }
            return new HashSet();
        }
    }

    private void a(b bVar, c cVar) {
        synchronized (this.f7042c) {
            Iterator it = a(cVar).iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(bVar);
            }
        }
    }
}
