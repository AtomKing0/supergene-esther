package com.ironsource;

import com.ironsource.c3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface qp extends dl<Integer, Integer> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f14549a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14550b = 1201;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14551c = 1202;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14552d = 1005;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14553e = 1206;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f14554f = 1006;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f14555g = 1203;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f14556h = 1507;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f14557i = 1010;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f14558j = 1210;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f14559k = 1211;

        private a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f14560a = new b();

        private b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f14561a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14562b = 1001;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14563c = 1002;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14564d = 1200;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14565e = 1301;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f14566f = 1503;

        private c() {
        }
    }

    public static final class d implements qp {
        @NotNull
        public Integer a(int i10) throws IllegalArgumentException {
            int i11;
            if (i10 == 206) {
                i11 = 1503;
            } else if (i10 != 401) {
                switch (i10) {
                    case 101:
                        i11 = 81500;
                        break;
                    case 102:
                        i11 = 81510;
                        break;
                    case 103:
                        i11 = 81301;
                        break;
                    case 104:
                        i11 = 81300;
                        break;
                    case 105:
                        i11 = 81002;
                        break;
                    default:
                        switch (i10) {
                            case 109:
                                i11 = 88002;
                                break;
                            case 110:
                                i11 = 83003;
                                break;
                            case 111:
                                i11 = 81302;
                                break;
                            case 112:
                                i11 = e.f14576j;
                                break;
                            default:
                                switch (i10) {
                                    case 201:
                                        i11 = 1001;
                                        break;
                                    case 202:
                                        i11 = 1002;
                                        break;
                                    case 203:
                                        i11 = 1200;
                                        break;
                                    case 204:
                                        i11 = 1301;
                                        break;
                                    default:
                                        switch (i10) {
                                            case 403:
                                                i11 = 1202;
                                                break;
                                            case c3.a.b.f11495d /* 404 */:
                                                i11 = 1005;
                                                break;
                                            case c3.a.b.f11496e /* 405 */:
                                                i11 = 1206;
                                                break;
                                            case c3.a.b.f11497f /* 406 */:
                                                i11 = 1006;
                                                break;
                                            case c3.a.b.f11498g /* 407 */:
                                                i11 = 1203;
                                                break;
                                            case c3.a.b.f11499h /* 408 */:
                                                i11 = 1507;
                                                break;
                                            case c3.a.b.f11500i /* 409 */:
                                                i11 = 1010;
                                                break;
                                            case c3.a.b.f11501j /* 410 */:
                                                i11 = 1210;
                                                break;
                                            case c3.a.b.f11502k /* 411 */:
                                                i11 = 1211;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Unknown event code: " + i10);
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                i11 = 1201;
            }
            return Integer.valueOf(i11);
        }

        @Override // com.ironsource.dl
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final e f14567a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14568b = 81500;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14569c = 81510;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14570d = 81301;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14571e = 81300;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f14572f = 81002;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f14573g = 88002;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f14574h = 83003;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f14575i = 81302;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f14576j = 81077;

        private e() {
        }
    }
}
