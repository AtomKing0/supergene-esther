package f6;

import android.content.Context;
import l5.r;

/* JADX INFO: compiled from: LibraryVersionComponent.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: compiled from: LibraryVersionComponent.java */
    public interface a<T> {
        String a(T t10);
    }

    public static l5.c<?> b(String str, String str2) {
        return l5.c.l(f.a(str, str2), f.class);
    }

    public static l5.c<?> c(final String str, final a<Context> aVar) {
        return l5.c.m(f.class).b(r.i(Context.class)).f(new l5.h() { // from class: f6.g
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return h.d(str, aVar, eVar);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f d(String str, a aVar, l5.e eVar) {
        return f.a(str, aVar.a((Context) eVar.a(Context.class)));
    }
}
