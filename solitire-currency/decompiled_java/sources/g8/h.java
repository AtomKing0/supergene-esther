package g8;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25895b;

    public h(@NotNull String content) {
        kotlin.jvm.internal.t.i(content, "content");
        this.f25894a = content;
        String lowerCase = content.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.f25895b = lowerCase.hashCode();
    }

    @NotNull
    public final String a() {
        return this.f25894a;
    }

    public boolean equals(@Nullable Object obj) {
        String str;
        h hVar = obj instanceof h ? (h) obj : null;
        return (hVar == null || (str = hVar.f25894a) == null || !p9.q.x(str, this.f25894a, true)) ? false : true;
    }

    public int hashCode() {
        return this.f25895b;
    }

    @NotNull
    public String toString() {
        return this.f25894a;
    }
}
