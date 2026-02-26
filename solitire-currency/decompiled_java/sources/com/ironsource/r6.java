package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface r6 extends dl<Integer, Integer> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f14636a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14637b = 3009;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14638c = 3008;

        private a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f14639a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14640b = 3002;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14641c = 3005;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14642d = 3300;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14643e = 3503;

        private b() {
        }
    }

    public static final class c implements r6 {
        @NotNull
        public Integer a(int i10) throws IllegalArgumentException {
            int i11;
            if (i10 == 206) {
                i11 = 3503;
            } else if (i10 == 405) {
                i11 = 3009;
            } else if (i10 != 406) {
                switch (i10) {
                    case 101:
                        i11 = 83500;
                        break;
                    case 102:
                        i11 = 83510;
                        break;
                    case 103:
                        i11 = d.f14651h;
                        break;
                    case 104:
                        i11 = 83300;
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
                                break;
                            case 112:
                                i11 = 3305;
                                break;
                            default:
                                switch (i10) {
                                    case 201:
                                        i11 = 3002;
                                        break;
                                    case 202:
                                        i11 = 3005;
                                        break;
                                    case 203:
                                        i11 = 3300;
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Unknown event code: " + i10);
                                }
                                break;
                        }
                    case 105:
                        i11 = 83302;
                        break;
                }
            } else {
                i11 = 3008;
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
        public static final d f14644a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14645b = 83500;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14646c = 83510;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14647d = 83300;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14648e = 83302;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f14649f = 83004;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f14650g = 88002;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f14651h = 83301;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f14652i = 83302;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f14653j = 3305;

        private d() {
        }
    }
}
