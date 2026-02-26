package d6;

import com.google.firebase.messaging.l0;
import s5.d;

/* JADX INFO: compiled from: MessagingClientEventExtension.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f24498b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d6.a f24499a;

    /* JADX INFO: compiled from: MessagingClientEventExtension.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d6.a f24500a = null;

        a() {
        }

        public b a() {
            return new b(this.f24500a);
        }

        public a b(d6.a aVar) {
            this.f24500a = aVar;
            return this;
        }
    }

    b(d6.a aVar) {
        this.f24499a = aVar;
    }

    public static a b() {
        return new a();
    }

    @d(tag = 1)
    public d6.a a() {
        return this.f24499a;
    }

    public byte[] c() {
        return l0.a(this);
    }
}
