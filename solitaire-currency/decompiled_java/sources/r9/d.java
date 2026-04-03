package r9;

import org.jetbrains.annotations.NotNull;
import u9.i0;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface d<E> extends u<E>, t<E> {

    @NotNull
    public static final a Q7 = a.f33389a;

    /* JADX INFO: compiled from: Channel.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f33389a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f33390b = i0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private a() {
        }

        public final int a() {
            return f33390b;
        }
    }
}
