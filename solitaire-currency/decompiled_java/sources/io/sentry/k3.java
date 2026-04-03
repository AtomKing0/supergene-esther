package io.sentry;

import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ObjectReader.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class k3 {
    @Nullable
    public static Date a(@Nullable String str, @NotNull w0 w0Var) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return n.f(str);
            } catch (Exception e10) {
                w0Var.b(SentryLevel.ERROR, "Error when deserializing millis timestamp format.", e10);
                return null;
            }
        } catch (Exception unused) {
            return n.g(str);
        }
    }
}
