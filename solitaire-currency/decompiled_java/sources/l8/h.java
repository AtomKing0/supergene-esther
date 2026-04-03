package l8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PipelinePhase.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f30957a;

    public h(@NotNull String name) {
        t.i(name, "name");
        this.f30957a = name;
    }

    @NotNull
    public final String a() {
        return this.f30957a;
    }

    @NotNull
    public String toString() {
        return "Phase('" + this.f30957a + "')";
    }
}
