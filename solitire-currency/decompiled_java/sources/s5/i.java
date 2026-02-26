package s5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: ProtobufValueEncoderContext.java */
/* JADX INFO: loaded from: classes3.dex */
class i implements p5.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f33581a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33582b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p5.c f33583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f33584d;

    i(f fVar) {
        this.f33584d = fVar;
    }

    private void b() {
        if (this.f33581a) {
            throw new p5.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f33581a = true;
    }

    @Override // p5.g
    @NonNull
    public p5.g a(@Nullable String str) throws IOException {
        b();
        this.f33584d.g(this.f33583c, str, this.f33582b);
        return this;
    }

    void c(p5.c cVar, boolean z10) {
        this.f33581a = false;
        this.f33583c = cVar;
        this.f33582b = z10;
    }

    @Override // p5.g
    @NonNull
    public p5.g e(boolean z10) throws IOException {
        b();
        this.f33584d.l(this.f33583c, z10, this.f33582b);
        return this;
    }
}
