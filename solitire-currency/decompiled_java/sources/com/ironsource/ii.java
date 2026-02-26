package com.ironsource;

import com.ironsource.c3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ii extends dl<Integer, Integer> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f12617a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f12618b = 2201;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f12619c = 2203;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f12620d = 2005;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f12621e = 2210;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f12622f = 2006;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f12623g = 2204;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f12624h = 2507;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f12625i = 2211;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f12626j = 2212;

        private a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f12627a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f12628b = 2002;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f12629c = 2003;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f12630d = 2200;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f12631e = 2503;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f12632f = 2300;

        private b() {
        }
    }

    public static final class c implements ii {
        @NotNull
        public Integer a(int i10) throws IllegalArgumentException {
            int i11;
            if (i10 == 206) {
                i11 = 2503;
            } else if (i10 == 401) {
                i11 = 2201;
            } else if (i10 == 410) {
                i11 = 2211;
            } else if (i10 != 411) {
                switch (i10) {
                    case 101:
                        i11 = 82500;
                        break;
                    case 102:
                        i11 = 82510;
                        break;
                    case 103:
                        i11 = 82301;
                        break;
                    case 104:
                        i11 = 82300;
                        break;
                    case 105:
                        i11 = 82002;
                        break;
                    default:
                        switch (i10) {
                            case 109:
                                i11 = 88002;
                                break;
                            case 110:
                                i11 = 83004;
                                break;
                            case 111:
                                i11 = 82302;
                                break;
                            case 112:
                                i11 = d.f12642j;
                                break;
                            default:
                                switch (i10) {
                                    case 201:
                                        i11 = 2002;
                                        break;
                                    case 202:
                                        i11 = 2003;
                                        break;
                                    case 203:
                                        i11 = 2200;
                                        break;
                                    case 204:
                                        i11 = 2300;
                                        break;
                                    default:
                                        switch (i10) {
                                            case 403:
                                                i11 = 2203;
                                                break;
                                            case c3.a.b.f11495d /* 404 */:
                                                i11 = 2005;
                                                break;
                                            case c3.a.b.f11496e /* 405 */:
                                                i11 = 2210;
                                                break;
                                            case c3.a.b.f11497f /* 406 */:
                                                i11 = 2006;
                                                break;
                                            case c3.a.b.f11498g /* 407 */:
                                                i11 = 2204;
                                                break;
                                            case c3.a.b.f11499h /* 408 */:
                                                i11 = 2507;
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
                i11 = 2212;
            }
            return Integer.valueOf(i11);
        }

        @Override // com.ironsource.dl
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f12633a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f12634b = 82500;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f12635c = 82510;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f12636d = 82300;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f12637e = 82002;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f12638f = 83004;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f12639g = 88002;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f12640h = 82301;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f12641i = 82302;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f12642j = 82076;

        private d() {
        }
    }
}
