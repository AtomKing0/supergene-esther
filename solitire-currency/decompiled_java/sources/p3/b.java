package p3;

import a4.b0;
import a4.o0;
import a4.t;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n3.b;

/* JADX INFO: compiled from: DvbParser.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f32556h = {0, 7, 8, 15};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f32557i = {0, 119, -120, -1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f32558j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f32559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f32560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Canvas f32561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0651b f32562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f32563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f32564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f32565g;

    /* JADX INFO: compiled from: DvbParser.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f32567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f32568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f32569d;

        public a(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f32566a = i10;
            this.f32567b = iArr;
            this.f32568c = iArr2;
            this.f32569d = iArr3;
        }
    }

    /* JADX INFO: renamed from: p3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DvbParser.java */
    private static final class C0651b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f32574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f32575f;

        public C0651b(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f32570a = i10;
            this.f32571b = i11;
            this.f32572c = i12;
            this.f32573d = i13;
            this.f32574e = i14;
            this.f32575f = i15;
        }
    }

    /* JADX INFO: compiled from: DvbParser.java */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f32577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f32578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f32579d;

        public c(int i10, boolean z10, byte[] bArr, byte[] bArr2) {
            this.f32576a = i10;
            this.f32577b = z10;
            this.f32578c = bArr;
            this.f32579d = bArr2;
        }
    }

    /* JADX INFO: compiled from: DvbParser.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<e> f32583d;

        public d(int i10, int i11, int i12, SparseArray<e> sparseArray) {
            this.f32580a = i10;
            this.f32581b = i11;
            this.f32582c = i12;
            this.f32583d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: DvbParser.java */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32585b;

        public e(int i10, int i11) {
            this.f32584a = i10;
            this.f32585b = i11;
        }
    }

    /* JADX INFO: compiled from: DvbParser.java */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f32587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f32590e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f32591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f32592g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f32593h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f32594i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f32595j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SparseArray<g> f32596k;

        public f(int i10, boolean z10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, SparseArray<g> sparseArray) {
            this.f32586a = i10;
            this.f32587b = z10;
            this.f32588c = i11;
            this.f32589d = i12;
            this.f32590e = i13;
            this.f32591f = i14;
            this.f32592g = i15;
            this.f32593h = i16;
            this.f32594i = i17;
            this.f32595j = i18;
            this.f32596k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.f32596k;
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                this.f32596k.put(sparseArray.keyAt(i10), sparseArray.valueAt(i10));
            }
        }
    }

    /* JADX INFO: compiled from: DvbParser.java */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32600d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f32601e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f32602f;

        public g(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f32597a = i10;
            this.f32598b = i11;
            this.f32599c = i12;
            this.f32600d = i13;
            this.f32601e = i14;
            this.f32602f = i15;
        }
    }

    /* JADX INFO: compiled from: DvbParser.java */
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray<f> f32605c = new SparseArray<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<a> f32606d = new SparseArray<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray<c> f32607e = new SparseArray<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray<a> f32608f = new SparseArray<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SparseArray<c> f32609g = new SparseArray<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public C0651b f32610h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public d f32611i;

        public h(int i10, int i11) {
            this.f32603a = i10;
            this.f32604b = i11;
        }

        public void a() {
            this.f32605c.clear();
            this.f32606d.clear();
            this.f32607e.clear();
            this.f32608f.clear();
            this.f32609g.clear();
            this.f32610h = null;
            this.f32611i = null;
        }
    }

    public b(int i10, int i11) {
        Paint paint = new Paint();
        this.f32559a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f32560b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f32561c = new Canvas();
        this.f32562d = new C0651b(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.f32563e = new a(0, c(), d(), e());
        this.f32564f = new h(i10, i11);
    }

    private static byte[] a(int i10, int i11, b0 b0Var) {
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr[i12] = (byte) b0Var.h(i11);
        }
        return bArr;
    }

    private static int[] c() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            if (i10 < 8) {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 127 : 0, (i10 & 2) != 0 ? 127 : 0, (i10 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i10 = 0; i10 < 256; i10++) {
            if (i10 < 8) {
                iArr[i10] = f(63, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) == 0 ? 0 : 255);
            } else {
                int i11 = i10 & 136;
                if (i11 == 0) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 8) {
                    iArr[i10] = f(127, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 128) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 43 : 0) + 127 + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + 127 + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + 127 + ((i10 & 64) == 0 ? 0 : 85));
                } else if (i11 == 136) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 43 : 0) + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + ((i10 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int f(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    private static int g(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i10, int i11, @Nullable Paint paint, Canvas canvas) {
        boolean z10;
        int i12;
        int iH;
        int iH2;
        int i13 = i10;
        boolean z11 = false;
        while (true) {
            int iH3 = b0Var.h(2);
            if (iH3 != 0) {
                z10 = z11;
                i12 = 1;
            } else {
                if (b0Var.g()) {
                    iH = b0Var.h(3) + 3;
                    iH2 = b0Var.h(2);
                } else {
                    if (b0Var.g()) {
                        z10 = z11;
                        i12 = 1;
                    } else {
                        int iH4 = b0Var.h(2);
                        if (iH4 == 0) {
                            z10 = true;
                        } else if (iH4 == 1) {
                            z10 = z11;
                            i12 = 2;
                        } else if (iH4 == 2) {
                            iH = b0Var.h(4) + 12;
                            iH2 = b0Var.h(2);
                        } else if (iH4 != 3) {
                            z10 = z11;
                        } else {
                            iH = b0Var.h(8) + 29;
                            iH2 = b0Var.h(2);
                        }
                        iH3 = 0;
                        i12 = 0;
                    }
                    iH3 = 0;
                }
                z10 = z11;
                i12 = iH;
                iH3 = iH2;
            }
            if (i12 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i13, i11, i13 + i12, i11 + 1, paint);
            }
            i13 += i12;
            if (z10) {
                return i13;
            }
            z11 = z10;
        }
    }

    private static int h(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i10, int i11, @Nullable Paint paint, Canvas canvas) {
        boolean z10;
        int i12;
        int iH;
        int iH2;
        int i13 = i10;
        boolean z11 = false;
        while (true) {
            int iH3 = b0Var.h(4);
            if (iH3 != 0) {
                z10 = z11;
                i12 = 1;
            } else if (b0Var.g()) {
                if (b0Var.g()) {
                    int iH4 = b0Var.h(2);
                    if (iH4 == 0) {
                        z10 = z11;
                        i12 = 1;
                    } else if (iH4 == 1) {
                        z10 = z11;
                        i12 = 2;
                    } else if (iH4 == 2) {
                        iH = b0Var.h(4) + 9;
                        iH2 = b0Var.h(4);
                    } else if (iH4 != 3) {
                        z10 = z11;
                        iH3 = 0;
                        i12 = 0;
                    } else {
                        iH = b0Var.h(8) + 25;
                        iH2 = b0Var.h(4);
                    }
                    iH3 = 0;
                } else {
                    iH = b0Var.h(2) + 4;
                    iH2 = b0Var.h(4);
                }
                z10 = z11;
                i12 = iH;
                iH3 = iH2;
            } else {
                int iH5 = b0Var.h(3);
                if (iH5 != 0) {
                    z10 = z11;
                    i12 = iH5 + 2;
                    iH3 = 0;
                } else {
                    z10 = true;
                    iH3 = 0;
                    i12 = 0;
                }
            }
            if (i12 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i13, i11, i13 + i12, i11 + 1, paint);
            }
            i13 += i12;
            if (z10) {
                return i13;
            }
            z11 = z10;
        }
    }

    private static int i(b0 b0Var, int[] iArr, @Nullable byte[] bArr, int i10, int i11, @Nullable Paint paint, Canvas canvas) {
        boolean z10;
        int iH;
        int i12 = i10;
        boolean z11 = false;
        while (true) {
            int iH2 = b0Var.h(8);
            if (iH2 != 0) {
                z10 = z11;
                iH = 1;
            } else if (b0Var.g()) {
                z10 = z11;
                iH = b0Var.h(7);
                iH2 = b0Var.h(8);
            } else {
                int iH3 = b0Var.h(7);
                if (iH3 != 0) {
                    z10 = z11;
                    iH = iH3;
                    iH2 = 0;
                } else {
                    z10 = true;
                    iH2 = 0;
                    iH = 0;
                }
            }
            if (iH != 0 && paint != null) {
                if (bArr != null) {
                    iH2 = bArr[iH2];
                }
                paint.setColor(iArr[iH2]);
                canvas.drawRect(i12, i11, i12 + iH, i11 + 1, paint);
            }
            i12 += iH;
            if (z10) {
                return i12;
            }
            z11 = z10;
        }
    }

    private static void j(byte[] bArr, int[] iArr, int i10, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        b0 b0Var = new b0(bArr);
        int iG = i11;
        int i13 = i12;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (b0Var.b() != 0) {
            int iH = b0Var.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        if (i10 == 3) {
                            bArr3 = bArrA == null ? f32557i : bArrA;
                        } else if (i10 != 2) {
                            bArr2 = null;
                            iG = g(b0Var, iArr, bArr2, iG, i13, paint, canvas);
                            b0Var.c();
                        } else {
                            bArr3 = bArrA3 == null ? f32556h : bArrA3;
                        }
                        bArr2 = bArr3;
                        iG = g(b0Var, iArr, bArr2, iG, i13, paint, canvas);
                        b0Var.c();
                        break;
                    case 17:
                        iG = h(b0Var, iArr, i10 == 3 ? bArrA2 == null ? f32558j : bArrA2 : null, iG, i13, paint, canvas);
                        b0Var.c();
                        break;
                    case 18:
                        iG = i(b0Var, iArr, null, iG, i13, paint, canvas);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrA3 = a(4, 4, b0Var);
                                break;
                            case 33:
                                bArrA = a(4, 8, b0Var);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, b0Var);
                                break;
                        }
                        break;
                }
            } else {
                i13 += 2;
                iG = i11;
            }
        }
    }

    private static void k(c cVar, a aVar, int i10, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
        int[] iArr = i10 == 3 ? aVar.f32569d : i10 == 2 ? aVar.f32568c : aVar.f32567b;
        j(cVar.f32578c, iArr, i10, i11, i12, paint, canvas);
        j(cVar.f32579d, iArr, i10, i11, i12 + 1, paint, canvas);
    }

    private static a l(b0 b0Var, int i10) {
        int iH;
        int i11;
        int iH2;
        int iH3;
        int iH4;
        int i12 = 8;
        int iH5 = b0Var.h(8);
        b0Var.r(8);
        int i13 = 2;
        int i14 = i10 - 2;
        int[] iArrC = c();
        int[] iArrD = d();
        int[] iArrE = e();
        while (i14 > 0) {
            int iH6 = b0Var.h(i12);
            int iH7 = b0Var.h(i12);
            int i15 = i14 - 2;
            int[] iArr = (iH7 & 128) != 0 ? iArrC : (iH7 & 64) != 0 ? iArrD : iArrE;
            if ((iH7 & 1) != 0) {
                iH3 = b0Var.h(i12);
                iH4 = b0Var.h(i12);
                iH = b0Var.h(i12);
                iH2 = b0Var.h(i12);
                i11 = i15 - 4;
            } else {
                int iH8 = b0Var.h(6) << i13;
                int iH9 = b0Var.h(4) << 4;
                iH = b0Var.h(4) << 4;
                i11 = i15 - 2;
                iH2 = b0Var.h(i13) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH2 = 255;
                iH4 = 0;
                iH = 0;
            }
            double d10 = iH3;
            double d11 = iH4 - 128;
            double d12 = iH - 128;
            iArr[iH6] = f((byte) (255 - (iH2 & 255)), o0.p((int) (d10 + (1.402d * d11)), 0, 255), o0.p((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255), o0.p((int) (d10 + (d12 * 1.772d)), 0, 255));
            i14 = i11;
            iH5 = iH5;
            i12 = 8;
            i13 = 2;
        }
        return new a(iH5, iArrC, iArrD, iArrE);
    }

    private static C0651b m(b0 b0Var) {
        int i10;
        int i11;
        int i12;
        int iH;
        b0Var.r(4);
        boolean zG = b0Var.g();
        b0Var.r(3);
        int iH2 = b0Var.h(16);
        int iH3 = b0Var.h(16);
        if (zG) {
            int iH4 = b0Var.h(16);
            int iH5 = b0Var.h(16);
            int iH6 = b0Var.h(16);
            iH = b0Var.h(16);
            i12 = iH5;
            i11 = iH6;
            i10 = iH4;
        } else {
            i10 = 0;
            i11 = 0;
            i12 = iH2;
            iH = iH3;
        }
        return new C0651b(iH2, iH3, i10, i12, i11, iH);
    }

    private static c n(b0 b0Var) {
        byte[] bArr;
        int iH = b0Var.h(16);
        b0Var.r(4);
        int iH2 = b0Var.h(2);
        boolean zG = b0Var.g();
        b0Var.r(1);
        byte[] bArr2 = o0.f219f;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = b0Var.h(16);
                int iH4 = b0Var.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    b0Var.k(bArr2, 0, iH3);
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    b0Var.k(bArr, 0, iH4);
                }
            }
            return new c(iH, zG, bArr2, bArr);
        }
        b0Var.r(b0Var.h(8) * 16);
        bArr = bArr2;
        return new c(iH, zG, bArr2, bArr);
    }

    private static d o(b0 b0Var, int i10) {
        int iH = b0Var.h(8);
        int iH2 = b0Var.h(4);
        int iH3 = b0Var.h(2);
        b0Var.r(2);
        int i11 = i10 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i11 > 0) {
            int iH4 = b0Var.h(8);
            b0Var.r(8);
            i11 -= 6;
            sparseArray.put(iH4, new e(b0Var.h(16), b0Var.h(16)));
        }
        return new d(iH, iH2, iH3, sparseArray);
    }

    private static f p(b0 b0Var, int i10) {
        int iH;
        int iH2;
        int iH3 = b0Var.h(8);
        b0Var.r(4);
        boolean zG = b0Var.g();
        b0Var.r(3);
        int i11 = 16;
        int iH4 = b0Var.h(16);
        int iH5 = b0Var.h(16);
        int iH6 = b0Var.h(3);
        int iH7 = b0Var.h(3);
        int i12 = 2;
        b0Var.r(2);
        int iH8 = b0Var.h(8);
        int iH9 = b0Var.h(8);
        int iH10 = b0Var.h(4);
        int iH11 = b0Var.h(2);
        b0Var.r(2);
        int i13 = i10 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i13 > 0) {
            int iH12 = b0Var.h(i11);
            int iH13 = b0Var.h(i12);
            int iH14 = b0Var.h(i12);
            int iH15 = b0Var.h(12);
            int i14 = iH11;
            b0Var.r(4);
            int iH16 = b0Var.h(12);
            i13 -= 6;
            if (iH13 == 1 || iH13 == 2) {
                i13 -= 2;
                iH = b0Var.h(8);
                iH2 = b0Var.h(8);
            } else {
                iH = 0;
                iH2 = 0;
            }
            sparseArray.put(iH12, new g(iH13, iH14, iH15, iH16, iH, iH2));
            iH11 = i14;
            i12 = 2;
            i11 = 16;
        }
        return new f(iH3, zG, iH4, iH5, iH6, iH7, iH8, iH9, iH10, iH11, sparseArray);
    }

    private static void q(b0 b0Var, h hVar) {
        f fVar;
        int iH = b0Var.h(8);
        int iH2 = b0Var.h(16);
        int iH3 = b0Var.h(16);
        int iD = b0Var.d() + iH3;
        if (iH3 * 8 > b0Var.b()) {
            t.i("DvbParser", "Data field length exceeds limit");
            b0Var.r(b0Var.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == hVar.f32603a) {
                    d dVar = hVar.f32611i;
                    d dVarO = o(b0Var, iH3);
                    if (dVarO.f32582c != 0) {
                        hVar.f32611i = dVarO;
                        hVar.f32605c.clear();
                        hVar.f32606d.clear();
                        hVar.f32607e.clear();
                    } else if (dVar != null && dVar.f32581b != dVarO.f32581b) {
                        hVar.f32611i = dVarO;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f32611i;
                if (iH2 == hVar.f32603a && dVar2 != null) {
                    f fVarP = p(b0Var, iH3);
                    if (dVar2.f32582c == 0 && (fVar = hVar.f32605c.get(fVarP.f32586a)) != null) {
                        fVarP.a(fVar);
                    }
                    hVar.f32605c.put(fVarP.f32586a, fVarP);
                }
                break;
            case 18:
                if (iH2 == hVar.f32603a) {
                    a aVarL = l(b0Var, iH3);
                    hVar.f32606d.put(aVarL.f32566a, aVarL);
                } else if (iH2 == hVar.f32604b) {
                    a aVarL2 = l(b0Var, iH3);
                    hVar.f32608f.put(aVarL2.f32566a, aVarL2);
                }
                break;
            case 19:
                if (iH2 == hVar.f32603a) {
                    c cVarN = n(b0Var);
                    hVar.f32607e.put(cVarN.f32576a, cVarN);
                } else if (iH2 == hVar.f32604b) {
                    c cVarN2 = n(b0Var);
                    hVar.f32609g.put(cVarN2.f32576a, cVarN2);
                }
                break;
            case 20:
                if (iH2 == hVar.f32603a) {
                    hVar.f32610h = m(b0Var);
                }
                break;
        }
        b0Var.s(iD - b0Var.d());
    }

    public List<n3.b> b(byte[] bArr, int i10) {
        int i11;
        SparseArray<g> sparseArray;
        b0 b0Var = new b0(bArr, i10);
        while (b0Var.b() >= 48 && b0Var.h(8) == 15) {
            q(b0Var, this.f32564f);
        }
        h hVar = this.f32564f;
        d dVar = hVar.f32611i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0651b c0651b = hVar.f32610h;
        if (c0651b == null) {
            c0651b = this.f32562d;
        }
        Bitmap bitmap = this.f32565g;
        if (bitmap == null || c0651b.f32570a + 1 != bitmap.getWidth() || c0651b.f32571b + 1 != this.f32565g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0651b.f32570a + 1, c0651b.f32571b + 1, Bitmap.Config.ARGB_8888);
            this.f32565g = bitmapCreateBitmap;
            this.f32561c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = dVar.f32583d;
        for (int i12 = 0; i12 < sparseArray2.size(); i12++) {
            this.f32561c.save();
            e eVarValueAt = sparseArray2.valueAt(i12);
            f fVar = this.f32564f.f32605c.get(sparseArray2.keyAt(i12));
            int i13 = eVarValueAt.f32584a + c0651b.f32572c;
            int i14 = eVarValueAt.f32585b + c0651b.f32574e;
            this.f32561c.clipRect(i13, i14, Math.min(fVar.f32588c + i13, c0651b.f32573d), Math.min(fVar.f32589d + i14, c0651b.f32575f));
            a aVar = this.f32564f.f32606d.get(fVar.f32592g);
            if (aVar == null && (aVar = this.f32564f.f32608f.get(fVar.f32592g)) == null) {
                aVar = this.f32563e;
            }
            SparseArray<g> sparseArray3 = fVar.f32596k;
            int i15 = 0;
            while (i15 < sparseArray3.size()) {
                int iKeyAt = sparseArray3.keyAt(i15);
                g gVarValueAt = sparseArray3.valueAt(i15);
                c cVar = this.f32564f.f32607e.get(iKeyAt);
                c cVar2 = cVar == null ? this.f32564f.f32609g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    i11 = i15;
                    sparseArray = sparseArray3;
                    k(cVar2, aVar, fVar.f32591f, gVarValueAt.f32599c + i13, i14 + gVarValueAt.f32600d, cVar2.f32577b ? null : this.f32559a, this.f32561c);
                } else {
                    i11 = i15;
                    sparseArray = sparseArray3;
                }
                i15 = i11 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f32587b) {
                int i16 = fVar.f32591f;
                this.f32560b.setColor(i16 == 3 ? aVar.f32569d[fVar.f32593h] : i16 == 2 ? aVar.f32568c[fVar.f32594i] : aVar.f32567b[fVar.f32595j]);
                this.f32561c.drawRect(i13, i14, fVar.f32588c + i13, fVar.f32589d + i14, this.f32560b);
            }
            arrayList.add(new b.C0631b().f(Bitmap.createBitmap(this.f32565g, i13, i14, fVar.f32588c, fVar.f32589d)).k(i13 / c0651b.f32570a).l(0).h(i14 / c0651b.f32571b, 0).i(0).n(fVar.f32588c / c0651b.f32570a).g(fVar.f32589d / c0651b.f32571b).a());
            this.f32561c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f32561c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f32564f.a();
    }
}
