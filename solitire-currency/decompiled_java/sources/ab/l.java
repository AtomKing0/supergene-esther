package ab;

import java.util.Objects;

/* JADX INFO: compiled from: HttpException.java */
/* JADX INFO: loaded from: classes5.dex */
public class l extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient y<?> f426c;

    public l(y<?> yVar) {
        super(a(yVar));
        this.f424a = yVar.b();
        this.f425b = yVar.e();
        this.f426c = yVar;
    }

    private static String a(y<?> yVar) {
        Objects.requireNonNull(yVar, "response == null");
        return "HTTP " + yVar.b() + " " + yVar.e();
    }
}
