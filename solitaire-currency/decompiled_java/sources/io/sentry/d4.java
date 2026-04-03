package io.sentry;

import java.net.URI;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RequestDetailsResolver.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Experimental
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final y f27757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f27758b;

    @ApiStatus.Internal
    public d4(@NotNull SentryOptions sentryOptions) {
        io.sentry.util.w.c(sentryOptions, "options is required");
        this.f27757a = sentryOptions.retrieveParsedDsn();
        this.f27758b = sentryOptions.getSentryClientName();
    }

    @NotNull
    public c4 a() {
        String str;
        URI uriC = this.f27757a.c();
        String string = uriC.resolve(uriC.getPath() + "/envelope/").toString();
        String strA = this.f27757a.a();
        String strB = this.f27757a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("Sentry sentry_version=7,sentry_client=");
        sb.append(this.f27758b);
        sb.append(",sentry_key=");
        sb.append(strA);
        if (strB == null || strB.length() <= 0) {
            str = "";
        } else {
            str = ",sentry_secret=" + strB;
        }
        sb.append(str);
        String string2 = sb.toString();
        HashMap map = new HashMap();
        map.put("User-Agent", this.f27758b);
        map.put("X-Sentry-Auth", string2);
        return new c4(string, map);
    }
}
