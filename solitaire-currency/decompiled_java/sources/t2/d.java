package t2;

import a4.c0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p2.k;

/* JADX INFO: compiled from: ScriptTagPayloadReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f34054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f34055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long[] f34056d;

    public d() {
        super(new k());
        this.f34054b = C.TIME_UNSET;
        this.f34055c = new long[0];
        this.f34056d = new long[0];
    }

    private static Boolean g(c0 c0Var) {
        return Boolean.valueOf(c0Var.D() == 1);
    }

    @Nullable
    private static Object h(c0 c0Var, int i10) {
        if (i10 == 0) {
            return j(c0Var);
        }
        if (i10 == 1) {
            return g(c0Var);
        }
        if (i10 == 2) {
            return n(c0Var);
        }
        if (i10 == 3) {
            return l(c0Var);
        }
        if (i10 == 8) {
            return k(c0Var);
        }
        if (i10 == 10) {
            return m(c0Var);
        }
        if (i10 != 11) {
            return null;
        }
        return i(c0Var);
    }

    private static Date i(c0 c0Var) {
        Date date = new Date((long) j(c0Var).doubleValue());
        c0Var.Q(2);
        return date;
    }

    private static Double j(c0 c0Var) {
        return Double.valueOf(Double.longBitsToDouble(c0Var.w()));
    }

    private static HashMap<String, Object> k(c0 c0Var) {
        int iH = c0Var.H();
        HashMap<String, Object> map = new HashMap<>(iH);
        for (int i10 = 0; i10 < iH; i10++) {
            String strN = n(c0Var);
            Object objH = h(c0Var, o(c0Var));
            if (objH != null) {
                map.put(strN, objH);
            }
        }
        return map;
    }

    private static HashMap<String, Object> l(c0 c0Var) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strN = n(c0Var);
            int iO = o(c0Var);
            if (iO == 9) {
                return map;
            }
            Object objH = h(c0Var, iO);
            if (objH != null) {
                map.put(strN, objH);
            }
        }
    }

    private static ArrayList<Object> m(c0 c0Var) {
        int iH = c0Var.H();
        ArrayList<Object> arrayList = new ArrayList<>(iH);
        for (int i10 = 0; i10 < iH; i10++) {
            Object objH = h(c0Var, o(c0Var));
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    private static String n(c0 c0Var) {
        int iJ = c0Var.J();
        int iE = c0Var.e();
        c0Var.Q(iJ);
        return new String(c0Var.d(), iE, iJ);
    }

    private static int o(c0 c0Var) {
        return c0Var.D();
    }

    @Override // t2.e
    protected boolean b(c0 c0Var) {
        return true;
    }

    @Override // t2.e
    protected boolean c(c0 c0Var, long j10) {
        if (o(c0Var) != 2 || !"onMetaData".equals(n(c0Var)) || c0Var.a() == 0 || o(c0Var) != 8) {
            return false;
        }
        HashMap<String, Object> mapK = k(c0Var);
        Object obj = mapK.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f34054b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapK.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f34055c = new long[size];
                this.f34056d = new long[size];
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj5 = list.get(i10);
                    Object obj6 = list2.get(i10);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f34055c = new long[0];
                        this.f34056d = new long[0];
                        break;
                    }
                    this.f34055c[i10] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f34056d[i10] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f34054b;
    }

    public long[] e() {
        return this.f34056d;
    }

    public long[] f() {
        return this.f34055c;
    }
}
