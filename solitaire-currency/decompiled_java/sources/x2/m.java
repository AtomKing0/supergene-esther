package x2;

import a4.c0;
import c3.a;
import e5.s;
import i3.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k2.j2;
import p2.a0;

/* JADX INFO: compiled from: SefReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final s f35849d = s.d(':');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final s f35850e = s.d('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f35851a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f35852b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35853c;

    /* JADX INFO: compiled from: SefReader.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35856c;

        public a(int i10, long j10, int i11) {
            this.f35854a = i10;
            this.f35855b = j10;
            this.f35856c = i11;
        }
    }

    private void a(p2.m mVar, a0 a0Var) throws IOException {
        c0 c0Var = new c0(8);
        mVar.readFully(c0Var.d(), 0, 8);
        this.f35853c = c0Var.q() + 8;
        if (c0Var.n() != 1397048916) {
            a0Var.f32443a = 0L;
        } else {
            a0Var.f32443a = mVar.getPosition() - ((long) (this.f35853c - 12));
            this.f35852b = 2;
        }
    }

    private static int b(String str) throws j2 {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw j2.a("Invalid SEF name", null);
        }
    }

    private void d(p2.m mVar, a0 a0Var) throws IOException {
        long length = mVar.getLength();
        int i10 = (this.f35853c - 12) - 8;
        c0 c0Var = new c0(i10);
        mVar.readFully(c0Var.d(), 0, i10);
        for (int i11 = 0; i11 < i10 / 12; i11++) {
            c0Var.Q(2);
            short s10 = c0Var.s();
            if (s10 == 2192 || s10 == 2816 || s10 == 2817 || s10 == 2819 || s10 == 2820) {
                this.f35851a.add(new a(s10, (length - ((long) this.f35853c)) - ((long) c0Var.q()), c0Var.q()));
            } else {
                c0Var.Q(8);
            }
        }
        if (this.f35851a.isEmpty()) {
            a0Var.f32443a = 0L;
        } else {
            this.f35852b = 3;
            a0Var.f32443a = this.f35851a.get(0).f35855b;
        }
    }

    private void e(p2.m mVar, List<a.b> list) throws IOException {
        long position = mVar.getPosition();
        int length = (int) ((mVar.getLength() - mVar.getPosition()) - ((long) this.f35853c));
        c0 c0Var = new c0(length);
        mVar.readFully(c0Var.d(), 0, length);
        for (int i10 = 0; i10 < this.f35851a.size(); i10++) {
            a aVar = this.f35851a.get(i10);
            c0Var.P((int) (aVar.f35855b - position));
            c0Var.Q(4);
            int iQ = c0Var.q();
            int iB = b(c0Var.A(iQ));
            int i11 = aVar.f35856c - (iQ + 8);
            if (iB == 2192) {
                list.add(f(c0Var, i11));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static i3.c f(c0 c0Var, int i10) throws j2 {
        ArrayList arrayList = new ArrayList();
        List<String> listF = f35850e.f(c0Var.A(i10));
        for (int i11 = 0; i11 < listF.size(); i11++) {
            List<String> listF2 = f35849d.f(listF.get(i11));
            if (listF2.size() != 3) {
                throw j2.a(null, null);
            }
            try {
                arrayList.add(new c.b(Long.parseLong(listF2.get(0)), Long.parseLong(listF2.get(1)), 1 << (Integer.parseInt(listF2.get(2)) - 1)));
            } catch (NumberFormatException e10) {
                throw j2.a(null, e10);
            }
        }
        return new i3.c(arrayList);
    }

    public int c(p2.m mVar, a0 a0Var, List<a.b> list) throws IOException {
        int i10 = this.f35852b;
        long j10 = 0;
        if (i10 == 0) {
            long length = mVar.getLength();
            if (length != -1 && length >= 8) {
                j10 = length - 8;
            }
            a0Var.f32443a = j10;
            this.f35852b = 1;
        } else if (i10 == 1) {
            a(mVar, a0Var);
        } else if (i10 == 2) {
            d(mVar, a0Var);
        } else {
            if (i10 != 3) {
                throw new IllegalStateException();
            }
            e(mVar, list);
            a0Var.f32443a = 0L;
        }
        return 1;
    }

    public void g() {
        this.f35851a.clear();
        this.f35852b = 0;
    }
}
