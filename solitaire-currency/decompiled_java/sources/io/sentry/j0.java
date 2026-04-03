package io.sentry;

import java.util.Objects;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FilterString.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Pattern f27938b;

    public j0(@NotNull String str) {
        Pattern patternCompile;
        this.f27937a = str;
        try {
            patternCompile = Pattern.compile(str);
        } catch (Throwable unused) {
            Sentry.getCurrentScopes().getOptions().getLogger().c(SentryLevel.DEBUG, "Only using filter string for String comparison as it could not be parsed as regex: %s", str);
            patternCompile = null;
        }
        this.f27938b = patternCompile;
    }

    @NotNull
    public String a() {
        return this.f27937a;
    }

    public boolean b(String str) {
        Pattern pattern = this.f27938b;
        if (pattern == null) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    public boolean equals(Object obj) {
        if (obj == null || j0.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f27937a, ((j0) obj).f27937a);
    }

    public int hashCode() {
        return Objects.hash(this.f27937a);
    }
}
