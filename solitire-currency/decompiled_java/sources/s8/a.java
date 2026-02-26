package s8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ByteArrayPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final g<byte[]> f33630a = new C0674a();

    /* JADX INFO: renamed from: s8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteArrayPool.kt */
    public static final class C0674a extends d<byte[]> {
        C0674a() {
            super(128);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // s8.d
        @NotNull
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public byte[] x() {
            return new byte[4096];
        }
    }

    @NotNull
    public static final g<byte[]> a() {
        return f33630a;
    }
}
