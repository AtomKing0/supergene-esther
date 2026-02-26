package l9;

import java.util.Random;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends l9.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final a f30971c = new a();

    /* JADX INFO: compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // l9.a
    @NotNull
    public Random i() {
        Random random = this.f30971c.get();
        t.h(random, "implStorage.get()");
        return random;
    }
}
