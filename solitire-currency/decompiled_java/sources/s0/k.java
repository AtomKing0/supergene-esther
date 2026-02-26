package s0;

import androidx.annotation.NonNull;
import b1.y;
import java.io.IOException;
import java.io.InputStream;
import s0.e;

/* JADX INFO: compiled from: InputStreamRewinder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements e<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y f33462a;

    /* JADX INFO: compiled from: InputStreamRewinder.java */
    public static final class a implements e.a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v0.b f33463a;

        public a(v0.b bVar) {
            this.f33463a = bVar;
        }

        @Override // s0.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // s0.e.a
        @NonNull
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f33463a);
        }
    }

    k(InputStream inputStream, v0.b bVar) {
        y yVar = new y(inputStream, bVar);
        this.f33462a = yVar;
        yVar.mark(5242880);
    }

    @Override // s0.e
    public void b() {
        this.f33462a.release();
    }

    @Override // s0.e
    @NonNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public InputStream a() throws IOException {
        this.f33462a.reset();
        return this.f33462a;
    }
}
