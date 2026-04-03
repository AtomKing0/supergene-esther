package la;

import ga.d0;
import ga.w;
import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConnectInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f30981a = new a();

    private a() {
    }

    @Override // ga.w
    @NotNull
    public d0 intercept(@NotNull w.a chain) throws IOException {
        t.i(chain, "chain");
        ma.g gVar = (ma.g) chain;
        return ma.g.d(gVar, 0, gVar.e().s(gVar), null, 0, 0, 0, 61, null).b(gVar.i());
    }
}
