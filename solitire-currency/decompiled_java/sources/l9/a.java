package l9;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends c {
    @Override // l9.c
    public int b(int i10) {
        return d.f(i().nextInt(), i10);
    }

    @Override // l9.c
    public int c() {
        return i().nextInt();
    }

    @Override // l9.c
    public int d(int i10) {
        return i().nextInt(i10);
    }

    @Override // l9.c
    public long f() {
        return i().nextLong();
    }

    @NotNull
    public abstract Random i();
}
