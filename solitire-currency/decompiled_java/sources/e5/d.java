package e5;

/* JADX INFO: compiled from: CharMatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements p<Character> {

    /* JADX INFO: compiled from: CharMatcher.java */
    static abstract class a extends d {
        a() {
        }

        @Override // e5.p
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f25135a;

        b(char c10) {
            this.f25135a = c10;
        }

        @Override // e5.d
        public boolean e(char c10) {
            return c10 == this.f25135a;
        }

        public String toString() {
            return "CharMatcher.is('" + d.g(this.f25135a) + "')";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    static abstract class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25136a;

        c(String str) {
            this.f25136a = (String) o.j(str);
        }

        public final String toString() {
            return this.f25136a;
        }
    }

    /* JADX INFO: renamed from: e5.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class C0545d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final C0545d f25137b = new C0545d();

        private C0545d() {
            super("CharMatcher.none()");
        }

        @Override // e5.d
        public int c(CharSequence charSequence, int i10) {
            o.l(i10, charSequence.length());
            return -1;
        }

        @Override // e5.d
        public boolean e(char c10) {
            return false;
        }
    }

    protected d() {
    }

    public static d d(char c10) {
        return new b(c10);
    }

    public static d f() {
        return C0545d.f25137b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(char c10) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch) {
        return e(ch.charValue());
    }

    public int c(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        o.l(i10, length);
        while (i10 < length) {
            if (e(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public abstract boolean e(char c10);
}
