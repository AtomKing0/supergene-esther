package ea;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlinx.serialization.json.a f25476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25477d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull o0 writer, @NotNull kotlinx.serialization.json.a json) {
        super(writer);
        kotlin.jvm.internal.t.i(writer, "writer");
        kotlin.jvm.internal.t.i(json, "json");
        this.f25476c = json;
    }

    @Override // ea.j
    public void b() {
        n(true);
        this.f25477d++;
    }

    @Override // ea.j
    public void c() {
        n(false);
        j("\n");
        int i10 = this.f25477d;
        for (int i11 = 0; i11 < i10; i11++) {
            j(this.f25476c.e().i());
        }
    }

    @Override // ea.j
    public void o() {
        e(' ');
    }

    @Override // ea.j
    public void p() {
        this.f25477d--;
    }
}
