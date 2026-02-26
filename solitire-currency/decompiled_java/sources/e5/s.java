package e5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f25157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f25159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f25160d;

    /* JADX INFO: compiled from: Splitter.java */
    class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f25161a;

        /* JADX INFO: renamed from: e5.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Splitter.java */
        class C0546a extends b {
            C0546a(s sVar, CharSequence charSequence) {
                super(sVar, charSequence);
            }

            @Override // e5.s.b
            int e(int i10) {
                return i10 + 1;
            }

            @Override // e5.s.b
            int f(int i10) {
                return a.this.f25161a.c(this.f25163c, i10);
            }
        }

        a(d dVar) {
            this.f25161a = dVar;
        }

        @Override // e5.s.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(s sVar, CharSequence charSequence) {
            return new C0546a(sVar, charSequence);
        }
    }

    /* JADX INFO: compiled from: Splitter.java */
    private static abstract class b extends e5.b<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f25163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final d f25164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f25165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f25166f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f25167g;

        protected b(s sVar, CharSequence charSequence) {
            this.f25164d = sVar.f25157a;
            this.f25165e = sVar.f25158b;
            this.f25167g = sVar.f25160d;
            this.f25163c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e5.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int iF;
            int i10 = this.f25166f;
            while (true) {
                int i11 = this.f25166f;
                if (i11 == -1) {
                    return b();
                }
                iF = f(i11);
                if (iF == -1) {
                    iF = this.f25163c.length();
                    this.f25166f = -1;
                } else {
                    this.f25166f = e(iF);
                }
                int i12 = this.f25166f;
                if (i12 == i10) {
                    int i13 = i12 + 1;
                    this.f25166f = i13;
                    if (i13 > this.f25163c.length()) {
                        this.f25166f = -1;
                    }
                } else {
                    while (i10 < iF && this.f25164d.e(this.f25163c.charAt(i10))) {
                        i10++;
                    }
                    while (iF > i10 && this.f25164d.e(this.f25163c.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.f25165e || i10 != iF) {
                        break;
                    }
                    i10 = this.f25166f;
                }
            }
            int i14 = this.f25167g;
            if (i14 == 1) {
                iF = this.f25163c.length();
                this.f25166f = -1;
                while (iF > i10 && this.f25164d.e(this.f25163c.charAt(iF - 1))) {
                    iF--;
                }
            } else {
                this.f25167g = i14 - 1;
            }
            return this.f25163c.subSequence(i10, iF).toString();
        }

        abstract int e(int i10);

        abstract int f(int i10);
    }

    /* JADX INFO: compiled from: Splitter.java */
    private interface c {
        Iterator<String> a(s sVar, CharSequence charSequence);
    }

    private s(c cVar) {
        this(cVar, false, d.f(), Integer.MAX_VALUE);
    }

    public static s d(char c10) {
        return e(d.d(c10));
    }

    public static s e(d dVar) {
        o.j(dVar);
        return new s(new a(dVar));
    }

    private Iterator<String> g(CharSequence charSequence) {
        return this.f25159c.a(this, charSequence);
    }

    public List<String> f(CharSequence charSequence) {
        o.j(charSequence);
        Iterator<String> itG = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itG.hasNext()) {
            arrayList.add(itG.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private s(c cVar, boolean z10, d dVar, int i10) {
        this.f25159c = cVar;
        this.f25158b = z10;
        this.f25157a = dVar;
        this.f25160d = i10;
    }
}
