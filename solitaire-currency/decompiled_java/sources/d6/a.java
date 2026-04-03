package d6;

/* JADX INFO: compiled from: MessagingClientEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final a f24450p = new C0540a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f24451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f24454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f24455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f24456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f24457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f24458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f24459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f24460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f24461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b f24462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f24463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f24464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f24465o;

    /* JADX INFO: renamed from: d6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MessagingClientEvent.java */
    public static final class C0540a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f24466a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f24467b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f24468c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f24469d = c.UNKNOWN;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d f24470e = d.UNKNOWN_OS;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f24471f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f24472g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f24473h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24474i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f24475j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f24476k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private b f24477l = b.UNKNOWN_EVENT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f24478m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private long f24479n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f24480o = "";

        C0540a() {
        }

        public a a() {
            return new a(this.f24466a, this.f24467b, this.f24468c, this.f24469d, this.f24470e, this.f24471f, this.f24472g, this.f24473h, this.f24474i, this.f24475j, this.f24476k, this.f24477l, this.f24478m, this.f24479n, this.f24480o);
        }

        public C0540a b(String str) {
            this.f24478m = str;
            return this;
        }

        public C0540a c(String str) {
            this.f24472g = str;
            return this;
        }

        public C0540a d(String str) {
            this.f24480o = str;
            return this;
        }

        public C0540a e(b bVar) {
            this.f24477l = bVar;
            return this;
        }

        public C0540a f(String str) {
            this.f24468c = str;
            return this;
        }

        public C0540a g(String str) {
            this.f24467b = str;
            return this;
        }

        public C0540a h(c cVar) {
            this.f24469d = cVar;
            return this;
        }

        public C0540a i(String str) {
            this.f24471f = str;
            return this;
        }

        public C0540a j(long j10) {
            this.f24466a = j10;
            return this;
        }

        public C0540a k(d dVar) {
            this.f24470e = dVar;
            return this;
        }

        public C0540a l(String str) {
            this.f24475j = str;
            return this;
        }

        public C0540a m(int i10) {
            this.f24474i = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: MessagingClientEvent.java */
    public enum b implements s5.c {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24485a;

        b(int i10) {
            this.f24485a = i10;
        }

        @Override // s5.c
        public int getNumber() {
            return this.f24485a;
        }
    }

    /* JADX INFO: compiled from: MessagingClientEvent.java */
    public enum c implements s5.c {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24491a;

        c(int i10) {
            this.f24491a = i10;
        }

        @Override // s5.c
        public int getNumber() {
            return this.f24491a;
        }
    }

    /* JADX INFO: compiled from: MessagingClientEvent.java */
    public enum d implements s5.c {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24497a;

        d(int i10) {
            this.f24497a = i10;
        }

        @Override // s5.c
        public int getNumber() {
            return this.f24497a;
        }
    }

    a(long j10, String str, String str2, c cVar, d dVar, String str3, String str4, int i10, int i11, String str5, long j11, b bVar, String str6, long j12, String str7) {
        this.f24451a = j10;
        this.f24452b = str;
        this.f24453c = str2;
        this.f24454d = cVar;
        this.f24455e = dVar;
        this.f24456f = str3;
        this.f24457g = str4;
        this.f24458h = i10;
        this.f24459i = i11;
        this.f24460j = str5;
        this.f24461k = j11;
        this.f24462l = bVar;
        this.f24463m = str6;
        this.f24464n = j12;
        this.f24465o = str7;
    }

    public static C0540a p() {
        return new C0540a();
    }

    @s5.d(tag = 13)
    public String a() {
        return this.f24463m;
    }

    @s5.d(tag = 11)
    public long b() {
        return this.f24461k;
    }

    @s5.d(tag = 14)
    public long c() {
        return this.f24464n;
    }

    @s5.d(tag = 7)
    public String d() {
        return this.f24457g;
    }

    @s5.d(tag = 15)
    public String e() {
        return this.f24465o;
    }

    @s5.d(tag = 12)
    public b f() {
        return this.f24462l;
    }

    @s5.d(tag = 3)
    public String g() {
        return this.f24453c;
    }

    @s5.d(tag = 2)
    public String h() {
        return this.f24452b;
    }

    @s5.d(tag = 4)
    public c i() {
        return this.f24454d;
    }

    @s5.d(tag = 6)
    public String j() {
        return this.f24456f;
    }

    @s5.d(tag = 8)
    public int k() {
        return this.f24458h;
    }

    @s5.d(tag = 1)
    public long l() {
        return this.f24451a;
    }

    @s5.d(tag = 5)
    public d m() {
        return this.f24455e;
    }

    @s5.d(tag = 10)
    public String n() {
        return this.f24460j;
    }

    @s5.d(tag = 9)
    public int o() {
        return this.f24459i;
    }
}
