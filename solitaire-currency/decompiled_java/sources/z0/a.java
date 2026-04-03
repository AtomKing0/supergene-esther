package z0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import r0.h;
import s0.j;
import y0.g;
import y0.m;
import y0.n;
import y0.o;
import y0.r;

/* JADX INFO: compiled from: HttpGlideUrlLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements n<g, InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r0.g<Integer> f36962b = r0.g.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final m<g, g> f36963a;

    /* JADX INFO: renamed from: z0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpGlideUrlLoader.java */
    public static class C0760a implements o<g, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m<g, g> f36964a = new m<>(500);

        @Override // y0.o
        @NonNull
        public n<g, InputStream> b(r rVar) {
            return new a(this.f36964a);
        }
    }

    public a(@Nullable m<g, g> mVar) {
        this.f36963a = mVar;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(@NonNull g gVar, int i10, int i11, @NonNull h hVar) {
        m<g, g> mVar = this.f36963a;
        if (mVar != null) {
            g gVarA = mVar.a(gVar, 0, 0);
            if (gVarA == null) {
                this.f36963a.b(gVar, 0, 0, gVar);
            } else {
                gVar = gVarA;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) hVar.c(f36962b)).intValue()));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull g gVar) {
        return true;
    }
}
