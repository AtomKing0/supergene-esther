package t7;

import e8.k;
import e8.o;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.j;

/* JADX INFO: compiled from: HttpClientCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f34090a;

    public c(@NotNull b8.c response, @NotNull KClass<?> from, @NotNull KClass<?> to) {
        t.i(response, "response");
        t.i(from, "from");
        t.i(to, "to");
        StringBuilder sb = new StringBuilder();
        sb.append("\n        Expected response body of the type '");
        sb.append(to);
        sb.append("' but was '");
        sb.append(from);
        sb.append("'\n        In response from `");
        sb.append(b8.e.e(response).getUrl());
        sb.append("`\n        Response status `");
        sb.append(response.f());
        sb.append("`\n        Response header `ContentType: ");
        k kVarB = response.b();
        o oVar = o.f25274a;
        sb.append(kVarB.get(oVar.i()));
        sb.append("` \n        Request header `Accept: ");
        sb.append(b8.e.e(response).b().get(oVar.c()));
        sb.append("`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
        this.f34090a = j.f(sb.toString());
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        return this.f34090a;
    }
}
